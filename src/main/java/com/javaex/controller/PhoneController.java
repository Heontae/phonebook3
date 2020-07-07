package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	PhoneDao phoneDao;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		List<PersonVo> pList = phoneDao.getPersonList();
		System.out.println(pList.toString());
		model.addAttribute("pList", pList);
		
		return "list";
	}
/*
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		return "writeForm";
	}

	//----------모델방식-------------
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@ModelAttribute PersonVo personVo) {

		phoneDao.personInsert(personVo);
		return "redirect:/phone/list";
	}
	
	
	/*----------예외상황(값이 안들어갈수도 있는상황)-------------
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam(value = "company", required = false, defaultValue = "000") String company) {
		System.out.println("phone.write");

		System.out.println(name + "," + hp + "," + company);

		return "";
	}
	*/
	/*
	@RequestMapping("/delete/{personId}")
	public String delete(@PathVariable("personId") int num) {
		phoneDao.personDelete(num);
		
		return "redirect:/phone/list";
	} 
	
	/*
	@RequestMapping("/updateForm")
	public String UpdateForm(Model model,@RequestParam("personId") int personId) {
		PersonVo personvo = phoneDao.getPerson(personId);
		
		model.addAttribute("vo",personvo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}*/
	/*
	@RequestMapping("/updateForm/{personId}")
	public String UpdateForm(Model model,@PathVariable("personId") int num) {
		PersonVo personvo = phoneDao.getPerson(num);
		
		model.addAttribute("vo",personvo);
		
		return "updateForm";
	}
	
	@RequestMapping("/update")
	public String Update(@ModelAttribute PersonVo personvo) {
		
		phoneDao.personUpdate(personvo);
		
		return "redirect:/phone/list";
	}
	*/
}
