package com.csi.payroll.mgt.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** UserWelcomeCtl Implmentation
 * 
 * @author Navigable Set
 * @Version 1.0
 */

@Controller
@RequestMapping(value = "/ctl/Welcome")
public class UserWelcomeCtl {

	
	@RequestMapping(method = RequestMethod.GET)
    public String display() {
        return "UserWelcome";
    }
	
}
