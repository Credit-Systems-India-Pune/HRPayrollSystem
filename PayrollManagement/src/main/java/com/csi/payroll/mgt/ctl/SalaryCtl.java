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

import com.csi.payroll.mgt.dto.LeaveDTO;
import com.csi.payroll.mgt.dto.SalaryDTO;
import com.csi.payroll.mgt.dto.UserDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;
import com.csi.payroll.mgt.form.SalaryForm;
import com.csi.payroll.mgt.service.SalaryServiceInt;
import com.csi.payroll.mgt.service.UserServiceInt;

@Controller
@RequestMapping(value="/ctl/Salary")
public class SalaryCtl extends BaseCtl {
	
	@Autowired
	SalaryServiceInt salaryService;
	
	@Autowired
	UserServiceInt userService;
	
	@Autowired
	MessageSource messageSource;
	
	@ModelAttribute
	public void preload(Model model) {
		
		Map<String, String> monthMap = new LinkedHashMap<String, String>();
		monthMap.put("January", "January");
		monthMap.put("February", "February");
		monthMap.put("March", "March");
		monthMap.put("April", "April");
		monthMap.put("May", "May");
		monthMap.put("June", "June");
		monthMap.put("July", "July");
		monthMap.put("August", "August");
		monthMap.put("September", "September");
		monthMap.put("October", "October");
		monthMap.put("November", "November");
		monthMap.put("December", "December");
		
		model.addAttribute("monthMap", monthMap);
		
		List list = userService.search(null);

		model.addAttribute("userList", list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") SalaryForm form, Model model) {

		if (form.getId() > 0) {
			form.populate(salaryService.findByPK(id));
		}

		return "Salary";

	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation, @ModelAttribute("form") @Valid SalaryForm form,
			BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Salary";
		}
		
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Salary/Search";
		}

		
		if (bindingResult.hasErrors()) {
			System.err.println("input error");
			return "Salary";
		}
		
		if (OP_SAVE.equalsIgnoreCase(operation)) {

			SalaryDTO dto = (SalaryDTO) form.getDto();
			
			

			try {
				String msg = null;
					
				if (form.getId() > 0) {
					salaryService.update(dto);
					msg = messageSource.getMessage("message.success.update", null, locale);
				}
				if (form.getId() == 0) {
					salaryService.add(dto);
					msg = messageSource.getMessage("message.success.add", null, locale);
				}
				model.addAttribute("success", msg);
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("message.salaryIsAlreadyExist", null, locale);
				model.addAttribute("error", msg);
			}
			return "Salary";
		}
		return null;

	}
	
	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") SalaryForm form,
			@RequestParam(required = false) String operation,HttpSession session, RedirectAttributes redirectAttributes,Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Salary/Search";
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
					SalaryDTO dto = new SalaryDTO();
					dto.setId(id);
					salaryService.delete(dto);
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
		
		SalaryDTO dto=(SalaryDTO) form.getDto();
		
		UserDTO uDto=(UserDTO) session.getAttribute("userLogin");
		if(uDto.getRoleId()==2) {
			dto.setUserId(uDto.getId());
		}

		List<SalaryDTO> list = salaryService.search(dto, pageNo, pageSize);

		List<SalaryDTO> totallist = salaryService.search(null);

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

		return "SalaryList";
	}
}
