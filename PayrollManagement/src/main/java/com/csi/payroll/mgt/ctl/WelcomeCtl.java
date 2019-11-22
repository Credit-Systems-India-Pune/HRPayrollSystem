package com.csi.payroll.mgt.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/** WelcomeCtl Implementation
 * 
 * @author Navigable Set
 * @Version 1.0
 */

@Controller
@RequestMapping(value = "/Welcome")
public class WelcomeCtl {
	
	@RequestMapping(method = RequestMethod.GET)
    public String display() {
        return "Welcome";
    }
	
	
	

}
