package com.kosta.view;

import java.util.Scanner;

import com.kosta.controller.CriminalController;
import com.kosta.dto.CriminalDTO;

public class MenuView {
	   static Scanner sc =new Scanner(System.in);
	   static int password = 1234;
	   /**
	    * 메뉴
	    * */
	    public static void menuChoice() {
	         while(true) {
	        	 System.out.println("\n****************************************************************************************");
	        	 System.out.print("[ 0.관리자모드 ");
	        	 System.out.print("1.전체검색 ");
	        	 System.out.print("2.세부검색 ");
	        	// System.out.println("2. 범죄별 처벌내용");
	        	 System.out.print("2.범죄별 검거기간 ");
	          	 System.out.print("3.범죄별 발생횟수 ");
//	         	 System.out.print("4.comment 수정 ");
//	         	 System.out.print("5.comment 삭제 ");
	         	 System.out.print("6.종료 ]");

	             System.out.println("\n****************************************************************************************");
	             System.out.println("메뉴를 선택해주세요.");
	              try {
		              int menu = Integer.parseInt(sc.nextLine());
		              switch (menu) {
		              case 0:
		            	  managerMode();
		              case 1:
						   CriminalController.SelectAll();	
						break;
		               case 2:
		            	   SearchMode();
		            	   //SearchOccur();
						break;
		               case 3:
		            	   SearchArrest();
		 				break;
		               case 4:
		            	   managerUpdate();
		 				break;
		               case 5:
		            	   managerDelete();
		    				break;
		               case 6:
		            	  System.out.println("종료합니다.");
		    			 System.exit(0);	
		    			break;
					default:
						System.out.println("다시 입력하세요");
					}
		        	 
	              }catch (NumberFormatException e) {
					System.out.println("메뉴는 숫자로 입력해주세요.");
				}
	         }
	    	
	    }

	    /**
	     * 0. 매니저모드
	     * 비밀번호로 입력 후 들어가서 update, delete 들어갈 수 있는 경로 
	     */
	    public static void managerMode() {
	    	System.out.println("비밀번호를 입력해주세요.");
	    	try{
	    		int no = Integer.parseInt(sc.nextLine());		
	    	if(no == password) {
	    		System.out.print("4.comment 수정 ");
	         	System.out.print("5.comment 삭제 ");
	           int num = Integer.parseInt(sc.nextLine());	
	           	switch(num) {
	           	case 4:
	           		managerUpdate();
	           		break;
	            case 5:
	            	managerDelete();
	    		    break;
	            default:
	            	System.out.println("비밀번호를 다시 입력해주세요."); 
	            	
	           	}
	    	}
	    	}catch (NumberFormatException e) {
	    		System.out.println("처음으로 돌아갑니다.");
	    	}
	    }
	    /**
	     * 2. 세부검색
	     */
	    public static void SearchMode() {
	    	System.out.println("1.강력범죄");
	    	System.out.println("2.절도범죄");
	    	System.out.println("3.폭력범죄");
	    	System.out.println("4.지능범죄");
	    	System.out.println("5.풍속범죄");
	    	System.out.println("6.특별범죄");
	    	System.out.println("7.기타범죄");
	    	
	    	System.out.println("원하는 번호를 입력해주세요");
	    	try {
	    	int no = Integer.parseInt(sc.nextLine());
	    	System.out.println("1.범죄 별 세부범죄 검색");
	    	System.out.println("2.범죄별 검거기간 검색");
	    
         	System.out.println("번호를 입력해주세요.");
         	try {
         	int num = Integer.parseInt(sc.nextLine());
         	switch(num) {
         		
         	 }	
         	}catch(NumberFormatException e) {
         		
         		
         	}
	    }catch(NumberFormatException e){
	    	
	    }
	    }
	    
		/**
	     * 2. 범죄별 발생횟수 검색
	     * */
	     public static void SearchOccur(){
	    	 System.out.println("검색 할 범죄명을 입력해주세요");
	    	 String supercrime = sc.nextLine();
	    	 CriminalController.SearchOccur(supercrime);
	     }
	     
	     /**
		     * 3. 범죄별 검거기간 검색
		     * */
		     public static void SearchArrest(){
		    	 System.out.println("검색 할 범죄명을 입력해주세요");
		    	 String midcrime = sc.nextLine();
		    	 CriminalController.SearchOccur(midcrime);
		     }
	     
	    /**
	     * 수정
	     * */
	     public static void managerUpdate() {
	    	 System.out.println("수정 할 범죄코드을 입력해주세요");
	    	 int code = Integer.parseInt(sc.nextLine());
	    	 
	    	 System.out.println("수정 내용은?");
	    	 String comment = sc.nextLine();
	    	
	    	 CriminalDTO dto =  new CriminalDTO(code, null, null, comment);
	    	 
	    	 CriminalController.managerUpdate(dto);
	     }
	    
	    /**
	     * 삭제
	     * */
	     public static void managerDelete() {
	    	 System.out.println("삭제 할 범죄코드를 입력해주세요.");
	    	 int code = Integer.parseInt(sc.nextLine());
	    	 
	    	 CriminalController.managerDelete(code);
	     }
	}