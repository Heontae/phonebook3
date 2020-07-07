package com.javaex.dao;

import java.util.List;

import com.javaex.vo.PersonVo;

public class PhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneDao phonedao = new PhoneDao();
		List<PersonVo> pList = phonedao.getPersonList();
		System.out.println(pList.toString());
		
		/*
		PersonVo personVo = phonedao.getPerson(4);
		System.out.println(personVo.toString());
		*/
	}

}
