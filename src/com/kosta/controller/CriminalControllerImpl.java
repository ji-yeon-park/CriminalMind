package com.kosta.controller;

import java.util.List;

import com.kosta.dto.CriminalDTO;
import com.kosta.service.CriminalService;
import com.kosta.service.CriminalServiceImpl;
import com.kosta.view.FailView;
import com.kosta.view.SuccessView;

public class CriminalControllerImpl implements CriminalController {
	static CriminalService criminalservice = new CriminalServiceImpl();
	
	public static void SelectAll() {
		try {
		 List<CriminalDTO> list=criminalservice.SelectAll();
		 SuccessView.successlist(list);
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

    private static void SearchOccur(String supercrime) {
    	try {
    		int occur =criminalservice.SearchOccur(supercrime);
    		SuccessView.OccurPrint(occur);
    		
    	}catch (Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    private static void SearchArrest(String midcrime) {
    	try {
    		int arrest =criminalservice.SearchArrest(midcrime);
    		SuccessView.ArrestPrint(arrest);
    		
    	}catch (Exception e) {
    		FailView.errorMessage(e.getMessage());
    	}
    	
    }
    
    private static void managerUpdate() {
    	// TODO Auto-generated method stub
    	
        }
    
    private static void managerDelete() {
    	// TODO Auto-generated method stub
    	
        }
    
	
	private static boolean PWCheck(String password) {
		boolean result=false;
		
		try {
			result = criminalservice.PWCheck(password);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return result;
	}
    
}
