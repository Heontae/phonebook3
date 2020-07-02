package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> pList = phoneDao.getPersonList("");

		model.addAttribute("pList", pList);

		return "/WEB-INF/views/list.jsp";
	}

	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		return "/WEB-INF/views/writeForm.jsp";
	}

	//----------모델방식-------------
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@ModelAttribute PersonVo personVo) {

		PhoneDao phoneDao = new PhoneDao();
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
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("personId") int personId) {
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(personId);
		
		return "redirect:/phone/list";
	} 
	
	@RequestMapping("/updateForm")
	public String UpdateForm(Model model,@RequestParam("personId") int personId) {
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personvo = phoneDao.getPerson(personId);
		
		model.addAttribute("vo",personvo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	@RequestMapping("/update")
	public String Update(@ModelAttribute PersonVo personvo) {
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.personUpdate(personvo);
		
		return "";
	}
}
