package com.capg.fms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capg.fms.bean.EmployeeDTO;
import com.capg.fms.service.IFMSService;

@Controller
public class FeedbackController {

	@Autowired
	private IFMSService iFmsService;

	@RequestMapping("/FeedbackLogin")
	public String getHomeLogin(Model model) {
		model.addAttribute("employee", new EmployeeDTO());
		return "FeedbackLogin";
	}

	@RequestMapping("/Login")
	public String doLogin(@ModelAttribute("employee")@Valid EmployeeDTO employee,
			BindingResult bindingResult, Model model) {

		boolean hasErrors = bindingResult.hasErrors();
		if(hasErrors){
			model.addAttribute("employee", employee);
			return "FeedbackLogin";
		}
		try {
			employee = iFmsService.getEmployee(employee.getEmployeeId(),
					employee.getPassword());
			if (employee.getRole().equals("admin")) {
				model.addAttribute("admin", employee);
				return "AdminPage";
			} else if (employee.getRole().equals("Cordinator")) {
				model.addAttribute("coordinator", employee);
				return "CoordinatorPage";
			}

			else if (employee.getRole().equals("participant")) {
				return ("redirect:/participantPage.obj?id="+employee.getEmployeeId());
			} 
		} catch (NullPointerException e) {
			model.addAttribute("invalid",true);
			return "FeedbackLogin";
		}
		model.addAttribute("otherUser", true);
		return "Error";
	}
}
