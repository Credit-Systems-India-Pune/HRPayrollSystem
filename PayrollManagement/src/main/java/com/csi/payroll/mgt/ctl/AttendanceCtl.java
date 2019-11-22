package com.csi.payroll.mgt.ctl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csi.payroll.mgt.dto.AttendanceDTO;
import com.csi.payroll.mgt.dto.LeaveDTO;
import com.csi.payroll.mgt.dto.TimeSheetDTO;
import com.csi.payroll.mgt.dto.UserDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;
import com.csi.payroll.mgt.form.AttendanceForm;
import com.csi.payroll.mgt.form.LeaveForm;
import com.csi.payroll.mgt.service.AttendanceServiceInt;
import com.csi.payroll.mgt.service.LeaveServiceInt;

@Controller
@RequestMapping(value="/ctl/Attendance")
public class AttendanceCtl extends BaseCtl {
	
	@Autowired
	AttendanceServiceInt attendanceService;
	
	@Autowired
	MessageSource messageSource;
	
	@ModelAttribute
	public void preload(Model model) {
		
		Map<String, String> statusMap = new LinkedHashMap<String, String>();
		statusMap.put("Persent", "Persent");
		statusMap.put("Absent", "Absent");
		
		model.addAttribute("statusMap", statusMap);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") AttendanceForm form, Model model) {

		if (form.getId() > 0) {
			form.populate(attendanceService.findByPK(id));
		}

		return "Attendance";

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation, @ModelAttribute("form") @Valid AttendanceForm form,
			BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Attendance";
		}
		
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Attendance/Search";
		}

		
		if (bindingResult.hasErrors()) {
			System.err.println("input error");
			return "Attendance";
		}
		
		if (OP_SAVE.equalsIgnoreCase(operation)) {

			AttendanceDTO dto = (AttendanceDTO) form.getDto();

			try {
				String msg = null;
					
				if (form.getId() > 0) {
					attendanceService.update(dto);
					msg = messageSource.getMessage("message.success.update", null, locale);
				}
				if (form.getId() == 0) {
					attendanceService.add(dto);
					msg = messageSource.getMessage("message.success.add", null, locale);
				}
				model.addAttribute("success", msg);
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("message.attendanceIsAlreadyExist", null, locale);
				model.addAttribute("error", msg);
			}
			return "Attendance";
		}
		return null;

	}
	
	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") AttendanceForm form,
			@RequestParam(required = false) String operation,HttpSession session, RedirectAttributes redirectAttributes,Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Attendance/Search";
		}
		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {

			pageNo=1;
			
			if (form.getIds() != null) {

				for (long id : form.getIds()) {
					AttendanceDTO dto = new AttendanceDTO();
					dto.setId(id);
					attendanceService.delete(dto);
				}
				String msg = messageSource.getMessage("message.success.delete", null, locale);
				model.addAttribute("success", msg);
				
				
				// redirectAttributes.addFlashAttribute("success", msg);
			//	return "RoleList";
				
			} else {

				System.out.println("select at least one records");
				String msg = messageSource.getMessage("message.unsuccess.selectatleastonerecords", null, locale);
				model.addAttribute("error", msg);
			}
			
			

		}
		
		AttendanceDTO dto=(AttendanceDTO) form.getDto();
		
		UserDTO uDto=(UserDTO) session.getAttribute("userLogin");
		if(uDto.getRoleId()==2) {
			dto.setEmailId(uDto.getEmailId());
		}

		List<AttendanceDTO> list = attendanceService.search(dto, pageNo, pageSize);

		List<AttendanceDTO> totallist = attendanceService.search(null);

		 model.addAttribute("list", list);

		/*
		 Set<Long> roleIds = new HashSet<Long>();
		for (UserDTO userDTO : list) {
			roleIds.add(userDTO.getRoleId());
		}

		model.addAttribute("roleMap", roleservice.getMapDTO(roleIds));

*/		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			String msg = messageSource.getMessage("message.unsuccess.recoudNotFound", null, locale);
			model.addAttribute("error", msg);
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize=pageNo*pageSize;
		
	
		
		
		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total",total);
		model.addAttribute("pagenosize", pageNoPageSize);

		return "AttendanceList";
	}

}
