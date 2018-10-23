package com.capg.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.FacultyDTO;
import com.capg.fms.service.IAdminService;

@Controller
public class AdminController {

	@Autowired
	private IAdminService iAdminService;

	@RequestMapping("/facultySkill")
	public String facultySkillMaintenance(Model model) {
		model.addAttribute("faculty", new FacultyDTO());
		model.addAttribute("choice", 0);
		List<FacultyDTO> facultyList = iAdminService.getFacultyList();
		model.addAttribute("facultylist", facultyList);
		return "FacultySkillMaintenance";
	}

	@RequestMapping("/facultyDetails")
	public String getFacultySkills(@RequestParam("id") int facultyId,
			Model model) {
		model.addAttribute("choice", 1);
		FacultyDTO faculty = iAdminService.getFacultyDetails(facultyId);
		if (faculty.equals(null))
			return "Error";
		model.addAttribute("faculty", faculty);
		return "FacultySkillMaintenance";
	}

	@RequestMapping("/updateDetails")
	public String updateFacultyDetails(@RequestParam("skills") String skills,
			@ModelAttribute("faculty") FacultyDTO faculty,
			BindingResult bindingResult, Model model) {
		model.addAttribute("choice", 2);
		if (skills.equals("")) {
			model.addAttribute("choice", 1);
			model.addAttribute("faculty", faculty);
			model.addAttribute("error", true);
			return "FacultySkillMaintenance";
		}
		faculty.setSkillSet(skills + "," + faculty.getSkillSet());
		iAdminService.updateFacultySkills(faculty);
		List<FacultyDTO> facultyList = iAdminService.getFacultyList();
		model.addAttribute("facultylist", facultyList);
		return "FacultySkillMaintenance";
	}

	@RequestMapping("/courseMaintenance")
	public String courseMaintenance(Model model) {
		model.addAttribute("choice", 0);
		List<CourseDTO> courseList = iAdminService.getCourseList();
		model.addAttribute("courselist", courseList);
		return "CourseMaintenance";
	}

	@RequestMapping("/addCourse")
	public String addCourse(Model model) {
		model.addAttribute("course", new CourseDTO());
		model.addAttribute("choice", 1);
		return "CourseMaintenance";
	}

	@RequestMapping("/newCourse")
	public String addNewCourse(
			@ModelAttribute("course") @Valid CourseDTO course,
			BindingResult bindingResult, Model model) {
		boolean error = bindingResult.hasErrors();
		if (error) {
			model.addAttribute("course", course);

			model.addAttribute("choice", 1);
			return "CourseMaintenance";
		} else {
			model.addAttribute("choice", 2);
			int courseId = iAdminService.addNewCourse(course);
			course.setCourseId(courseId);
			List<CourseDTO> courseList = iAdminService.getCourseList();
			model.addAttribute("courselist", courseList);
			return "CourseMaintenance";
		}
	}

	@RequestMapping("/getCourse")
	public String getCourse(@RequestParam("id") int id, Model model) {
		model.addAttribute("choice", 3);
		CourseDTO course = iAdminService.getCourse(id);
		model.addAttribute("course", course);
		return "CourseMaintenance";
	}

	@RequestMapping("/updateCourse")
	public String updateCourse(@ModelAttribute("course") CourseDTO course,
			BindingResult bindingResult, Model model) {
		model.addAttribute("choice", 0);
		iAdminService.updateCourse(course);
		List<CourseDTO> courseList = iAdminService.getCourseList();
		model.addAttribute("courselist", courseList);
		model.addAttribute("updated", true);
		return "CourseMaintenance";

	}

	@RequestMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("id") int id, Model model) {
		iAdminService.removeCourse(id);
		model.addAttribute("choice", 0);
		List<CourseDTO> courseList = iAdminService.getCourseList();
		model.addAttribute("courselist", courseList);
		model.addAttribute("updated", true);
		return "CourseMaintenance";
	}

}
