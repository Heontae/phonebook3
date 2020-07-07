package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlsession;

	// 사람 리스트(검색할때)
	public List<PersonVo> getPersonList() {
		List<PersonVo> personList = sqlsession.selectList("phonebook.getList");

		return personList;
	}

	// 사람 추가
	public int personInsert(PersonVo personVo) {
		int count = sqlsession.insert("phonebook.insert", personVo);

		return count;
	}

	// 사람 추가2(Map 방식)
	public int personInsert2(String name, String hp, String company) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("name", name);
		pMap.put("hp", hp);
		pMap.put("company", company);

		int count = sqlsession.insert("phonebook.insert2", pMap);

		return count;
	}
	
	// 사람 정보 (1명)
	public PersonVo getPerson(int personId) {
		PersonVo personVo = sqlsession.selectOne("phonebook.selectById",personId);
		
		return personVo;
	}

	// 사람 정보 (1명) Map방식
	public Map<String,Object> getPerson2(int personId) {
		Map<String,Object> personMap = sqlsession.selectOne("phonebook.selectById2",personId);
		
		//System.out.println(personMap.get("PERSONID")); 키값은 컬럼에 대문자
		return personMap;
	}

	
	// 사람 수정
	public int personUpdate(PersonVo personVo) {
		int count = sqlsession.update("phonebook.update",personVo);
		return count;
	}
	
	// 사람 삭제 
	public int personDelete(int personId) {
		int count = sqlsession.delete("phonebook.delete",personId);
		
		return count;
	}

}
