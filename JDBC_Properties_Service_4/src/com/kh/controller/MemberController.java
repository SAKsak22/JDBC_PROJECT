package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

// Controller : View를 통해서 사용자가 요청한 기능에 대해서 처리하는 담당
//				해당 메소드로 전달된 데이터 [가공처리후] ado로 전달하며 호출
//				dao로부터 반환받은 결과에따라서 성공인지 실패인지 판단 후 응답화면 결정(View 메소드 호출) 
public class MemberController {
	
	/**
	 * 사용자의 추가요청을 처리해주는 메소드
	 * @param userId ~ hobby : 사용자가 입력햇던 정보들이 담겨있는 메게변수
	 */
	
	
	
	
	public void insertMember(String userId, String userPwd, String userName, String gender,
			String age, String email, String phone, String address, String hobby) {
		
		 Member m = new Member(userId, userPwd,userName, gender,  Integer.parseInt(age),
				 email, phone , address, hobby );
		 
		 int result = new MemberService().insertMember(m);
		 
		 if(result>0) {
			 new MemberMenu().displaySuccess("성공적으로 회원을 추가했씁니다.");
			 
		 } else {
			 new MemberMenu().displayFail("회원 추가에 실패했습니다..");

		 }
		
		// view로부터 전달받은 값을 바로 dao쪽으로 전달x
		// 어딘가(Member객체(vo))에 담아서 전달
		
		// 방법1) 기본생성자로 생성한 후에 각 필드에 setter메소드를 통해서 일일히 담는 방법
		// 방법2) 매개변수 생성자로 생성과 동시에 담는 방법
		
		
	}
	
	/**
	 * 사용자의 회원 전체조회 요청을 처리해주는 메소드
	 */
	
	
	
	public void selectList() {
	ArrayList<Member>list =	new MemberService().selectList();
	
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("전체 조회 결과가 없습니다.");
			
		} else {
			new MemberMenu().displayMemberList(list);
		}
	}
	
	/**
	 * 사용자의 아이디로 회원 검색 요청을 처리해주는 메소드
	 * @param userId : 사용자가 입력한 검색하고자하는 회원 아이디
	 */
	public void selectByUserId(String userId) {
		
	}
	
	/**
	 * 이름으로 키워드 검색 요청시 처리해주는 메소드
	 * @param keyword : 사용자가 입력한 검색할 키워드명
	 */
	public void selectByUserName(String keyword) {
		
	}
	
	public void updateMember(String userID, String userPwd, String email, String phone, String address) {
	
	}
	
	public void deleteMember(String userid) {
	
	}
}
