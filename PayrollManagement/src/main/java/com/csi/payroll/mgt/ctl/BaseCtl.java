package com.csi.payroll.mgt.ctl;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * BaseCtl
 * 
 * @author Navigable Set
 * @Version 1.0
 */
public class BaseCtl {

	protected static final String OP_SAVE = "Save";
	protected static final String OP_NEW="New";
	protected static final String OP_DELETE="Delete";
	protected static final String OP_CANCEL="Cancel";
	protected static final String OP_ERROR="Error";
	protected static final String OP_NEXT="Next";
	protected static final String OP_PREVIOUS="Previous";
	protected static final String OP_LOGOUT="Logout";
	protected static final String OP_GO="Go";
	protected static final String OP_GET="Get";

	protected static final String OP_RESET="Reset";
	
	/*
	 @ModelAttribute
	    public void preload(Model model) {}
*/
	 
}
