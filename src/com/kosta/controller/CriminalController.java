package com.kosta.controller;

public interface CriminalController {

	  void SelectAll() ;
	  void SelectAll2();
		
	  void SearchOccur(String str);	
	  void SearchArrest(String str);

	  void callSuperCrime();
	  void CallMidCrime(String name);
		
	  void managerUpdate(String name, String comments);
	  void managerUpdate2(String name, String comments);
		
	  boolean PWCheck(String password);
	
}

