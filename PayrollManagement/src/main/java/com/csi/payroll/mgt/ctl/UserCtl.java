package com.csi.payroll.mgt.ctl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jboss.logging.Message;
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

import com.csi.payroll.mgt.dto.UserDTO;
import com.csi.payroll.mgt.exception.DuplicateRecordException;
import com.csi.payroll.mgt.form.ChangePasswordForm;
import com.csi.payroll.mgt.form.MyProfileForm;
import com.csi.payroll.mgt.form.UserForm;
import com.csi.payroll.mgt.service.RoleServiceInt;
import com.csi.payroll.mgt.service.UserServiceInt;
import com.csi.payroll.mgt.util.DataUtility;

import javassist.compiler.ast.NewExpr;


/** UserCtl Implementation 
 * @author Navigable Set
 * @Version 1.0
 */

@Controller

@RequestMapping(value = "/ctl/User")
public class UserCtl extends BaseCtl {

	@Autowired
	UserServiceInt userservice;

	@Autowired
	RoleServiceInt roleservice;

	@Autowired
	MessageSource messageSource;

	@ModelAttribute
	public void preload(Model model) {
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("Female", "Female");
		genderMap.put("Male", "Male");
		
		model.addAttribute("genderMap", genderMap);
		model.addAttribute("roleList", roleservice.search(null));
	
	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") UserForm form, Model model) {

		if (form.getId() > 0) {
			form.populate(userservice.findByPK(id));
		}

		return "User";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation, @ModelAttribute("form") @Valid UserForm form,
			BindingResult bindingResult, Model model) {

	
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:User";
		}
		
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:User/Search";
		}

		if (OP_SAVE.equalsIgnoreCase(operation)) {

			if (!form.getConfirmPassword().equals(form.getPassword())) {

				String msg = messageSource.getMessage("Message.Form.confirmpasswordandpassword", null, locale);
				model.addAttribute("error", msg);

				return "User";
			}

			if (bindingResult.hasErrors()) {
				System.err.println("input error");
				return "User";
			}

			UserDTO dto = (UserDTO) form.getDto();
			try {
				String msg = null;

				if (form.getId() > 0) {
					userservice.update(dto);
					msg = messageSource.getMessage("message.success.update", null, locale);
				}
				if (form.getId() == 0) {
					userservice.add(dto);
					msg = messageSource.getMessage("message.success.add", null, locale);
				}
				model.addAttribute("success", msg);
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("message.userIsAlreadyExist", null, locale);
				model.addAttribute("error", msg);
			}
			return "User";
		}
		return null;

	}

	/**
	 * Displays User List
	 * 
	 * @param form
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation,HttpSession session, Model model) {

	
		
		
		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/User/Search";
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
			pageNo = 1;
			if (form.getIds() != null) {

				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
					userservice.delete(dto);
				}
				String msg = messageSource.getMessage("message.success.delete", null, locale);
				model.addAttribute("success", msg);

				// redirectAttributes.addFlashAttribute("success", msg);
				// return "UserList";

			} else {

				System.out.println("select at least one records");
				String msg = messageSource.getMessage("message.unsuccess.selectatleastonerecords", null, locale);
				model.addAttribute("error", msg);
			}

		}

		List<UserDTO> list = userservice.search((UserDTO) form.getDto(), pageNo, pageSize);

		List<UserDTO> totallist = userservice.search(null);

		model.addAttribute("list", list);

		Set<Long> roleIds = new HashSet<Long>();
		for (UserDTO userDTO : list) {
			roleIds.add(userDTO.getRoleId());
		}

		model.addAttribute("roleMap", roleservice.getMapDTO(roleIds));

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			String msg = messageSource.getMessage("message.unsuccess.recoudNotFound", null, locale);
			model.addAttribute("error", msg);
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		
		
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);

		return "UserList";
	}

	/**
	 * Displays MyProfile View
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)

	public String displayProfile(HttpSession session, @ModelAttribute("form") MyProfileForm form, Model model) {
		UserDTO dto = (UserDTO) session.getAttribute("userLogin");
		form.populate(dto);

		System.out.println("/Myprofile");
		return "Myprofile";
	}

	/**
	 * Submits MyProfile
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String submitProfile(Locale locale, HttpSession session, @ModelAttribute("form") @Valid MyProfileForm form,BindingResult bindingResult,
			@RequestParam(required = false) String operation,  Model model) {


		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/User/profile";
		}

		if (bindingResult.hasErrors()) {
			return "Myprofile";
		}
		UserDTO dto = (UserDTO) session.getAttribute("userLogin");
		dto = userservice.findByPK(dto.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setDob(DataUtility.getDate(form.getDob()));
		dto.setMobileNo(form.getMobileNo());
		dto.setGender(form.getGender());

		try {
			userservice.update(dto);
		} catch (DuplicateRecordException e) {

		}
		String msg = messageSource.getMessage("message.success.profile", null, locale);
		model.addAttribute("success", msg);

		return "Myprofile";
	}

	/**
	 * Displays Change Password view.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form, Model model) {
		return "ChangePassword";
	}

	/**
	 * Submits Change Password data.
	 * 
	 * @param session
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(Locale locale, HttpSession session,
			@ModelAttribute("form") @Valid ChangePasswordForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "ChangePassword";
		}

		UserDTO dto = (UserDTO) session.getAttribute("userLogin");
		dto = userservice.findByPK(dto.getId());

		// Old password must be valid
		if (dto.getPassword().equals(form.getOldPassword())) {
			// Change Password
			dto.setPassword(form.getNewPassword());

			try {
				userservice.update(dto);
			} catch (DuplicateRecordException e) {
			}

			String msg = messageSource.getMessage("message.success.changePassword", null, locale);
			model.addAttribute("success", msg);
		} else {
			String msg = messageSource.getMessage("message.unsuccess.changePassword", null, locale);
			model.addAttribute("error", msg);
		}

		return "ChangePassword";
	}
}
