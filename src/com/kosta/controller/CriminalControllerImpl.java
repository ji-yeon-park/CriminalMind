package com.kosta.controller;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.ArrestDayDTO;
import com.kosta.dto.CrimeInfoDTO;
import com.kosta.service.CriminalService;
import com.kosta.service.CriminalServiceImpl;
import com.kosta.view.FailView;
import com.kosta.view.SuccessView;

public class CriminalControllerImpl implements CriminalController {
		
	 CriminalService criminalservice = new CriminalServiceImpl();
		
	public void SelectAll() {
		try {
		 List<CrimeInfoDTO> list=criminalservice.SelectAll();
		 SuccessView.successlistAll(list);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
}
	
	public void SelectAll2() {
		try {
		 List<ArrestDayDTO> list=criminalservice.SelectAll2();
		 SuccessView.successlistAll2(list);
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
}
	

	public void SearchOccur(String str) {
		try {
    		CrimeInfoDTO occur =criminalservice.SearchOccur(str);
    		SuccessView.OccurPrint(occur);
    		
    	}catch (SQLException e) {
    		FailView.errorMessage(e.getMessage());
    	}
	}
	
	public void SearchArrest(String str) {
		try {
			ArrestDayDTO arrest = criminalservice.SearchArrest(str);
			SuccessView.ArrestPrint(arrest);
		
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	//////////////
	/// 출력
	////////////////

	public void callSuperCrime() {
		System.out.println("A.강력범죄");
    	System.out.println("B.절도범죄");
    	System.out.println("C.폭력범죄");
    	System.out.println("D.지능범죄");
    	System.out.println("E.풍속범죄");
    	System.out.println("F.특별범죄");
    	System.out.println("G.기타범죄");
	}

	public void CallMidCrime(String name) {
		try {
			List<String> list = criminalservice.CallMidCrime(name);
			SuccessView.successlist(list);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	///////////////////
	
	public void managerUpdate(String name, String comments) {
		try {
			criminalservice.managerUpdate(name,comments);
			SuccessView.printMessage("수정되었습니다.");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	

	public void managerUpdate2(String name, String comments) {
		try {
			criminalservice.managerUpdate2(name,comments);
			SuccessView.printMessage("수정되었습니다.");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public boolean PWCheck(String password) {
		boolean result=false;
		
		try {
			result = criminalservice.PWCheck(password);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return result;
	}
}
