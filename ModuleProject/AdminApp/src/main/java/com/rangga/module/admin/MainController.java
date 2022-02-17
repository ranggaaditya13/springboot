package com.rangga.module.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rangga.module.project.CommonUtil;

@Controller
public class MainController {
	
	@GetMapping("")
	public String viewHomePage(Model model) {
		String appName = CommonUtil.getAppName();
		model.addAttribute("appName",appName);
		return "index";
	}

}
