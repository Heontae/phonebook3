package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	PhoneDao phoneDao;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		List<PersonVo> pList = phoneDao.getPersonList();
		model.addAttribute("pList", pList);

		return "list";
	}

	// ----------등록 폼-------------
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		return "writeForm";
	}

	// ----------모델방식-------------
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@ModelAttribute PersonVo personVo) {
		phoneDao.personInsert(personVo);

		return "redirect:/phone/list";
	}

	// ----------Map방식-------------
	@RequestMapping(value = "/write2", method = RequestMethod.GET)
	public String write2(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {

		phoneDao.personInsert2(name, hp, company);

		return "redirect:/phone/list";
	}

	// ----------수정 폼-------------
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String UpdateForm(Model model, @RequestParam("personId") int personId) {

		PersonVo personvo = phoneDao.getPerson(personId);

		model.addAttribute("vo", personvo);

		return "updateForm";
	}

	// ----------수정 폼(Map)-------------
	@RequestMapping(value = "/updateForm2", method = { RequestMethod.GET, RequestMethod.POST })
	public String UpdateForm2(Model model, @RequestParam("personId") int personId) {

		Map<String, Object> personMap = phoneDao.getPerson2(personId);

		model.addAttribute("vo", personMap);

		return "updateForm2";
	}

	// ----------수정하기-------------
	@RequestMapping("/update")
	public String Update(@ModelAttribute PersonVo personvo) {
		phoneDao.personUpdate(personvo);

		return "redirect:/phone/list";
	}

	// ----------삭제하기-------------
	@RequestMapping("/delete")
	public String delete(@RequestParam("personId") int num) {
		phoneDao.personDelete(num);

		return "redirect:/phone/list";
	}


}
