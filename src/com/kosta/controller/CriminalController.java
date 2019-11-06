package com.kosta.controller;

import java.sql.SQLException;
import java.util.List;

import com.kosta.dto.CriminalDTO;
import com.kosta.service.CriminalService;
import com.kosta.service.CriminalServiceImpl;
import com.kosta.view.FailView;
import com.kosta.view.SuccessView;

public interface CriminalController {
		
	static CriminalService criminalservice = new CriminalServiceImpl();
		
		public static void SelectAll() {
			try {
			 List<CriminalDTO> list=criminalservice.SelectAll();
			 SuccessView.successlist(list);
			}catch (SQLException e) {
				FailView.errorMessage(e.getMessage());
			}
	}
	
	static void CallMidCrime(String name) {
				try {
					List<CriminalDTO> list = criminalservice.CallMidCrime(name);
					SuccessView.successlist(list);
				}catch(SQLException e) {
					FailView.errorMessage(e.getMessage());
				}
			}
	
	static void SearchOccur(int number) {
		try {
    		int occur =criminalservice.SearchOccur(number);
    		SuccessView.OccurPrint(occur);
    		
    	}catch (SQLException e) {
    		FailView.errorMessage(e.getMessage());
    	}
	}
	
	static void SearchArrest(String midcrime) {
		try {
			int arrest = criminalservice.SearchArrest(midcrime);
			SuccessView.ArrestPrint(arrest);
		
		}catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	static void managerUpdate(CriminalDTO dto) {
		try {
			criminalservice.managerUpdate(dto);
			SuccessView.printMessage("수정되었습니다.");
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	static void managerDelete(String id) {
		try {
			criminalservice.managerDelete(id);
			SuccessView.printMessage("삭제되었습니다.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
}
