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
	        	 System.out.println("\n**********************************");
	        	 System.out.print("[ 0.관리자모드 ");
	        	 System.out.print("1.전체검색 ");
	        	 System.out.print("2.세부검색 ");
	         	 System.out.print("3.종료 ]");

	             System.out.println("\n**********************************");
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
						break;
		               case 3:
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
	    		System.out.print("1.comment 수정 ");
	         	System.out.print("2.comment 삭제 ");
	           int num = Integer.parseInt(sc.nextLine());	
	           	switch(num) {
	           	case 1:
	           		managerUpdate();
	           		break;
	            case 2:
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
	    	
	    	System.out.println("아래번호 중 입력해주세요");
	    	System.out.println("1번을 누르면 범죄별 세부범죄를 확인할 수 있습니다.");
	    	System.out.println("2번을 누르면 범죄별 검거기간을 확인할 수 있습니다.");
	    	
	    	try {
	    	int nums = Integer.parseInt(sc.nextLine());
	    	switch(nums) {
	    	case 1:
	    		callSuperCrime();
	    		CallMidCrime();
	    		break;
	    	case 2:
	    		callSuperCrime();
	    		SearchArrest();
	    		break;
	    	}
	    	}catch( NumberFormatException e) {
	    		System.out.println("1번과 2번 중 번호를 입력해주세요.");
	    	}finally {
	    		System.out.println("다른 범죄도 확인하시겠습니까 yes or no");
	    		String choice = sc.nextLine();
	    		if(choice.equals("yes")) { 
	    			System.out.println("원하는 문자를 입력해주세요");
	    			String str = sc.nextLine();
	    			CallMidCrime();
	    		}else System.out.println("종료합니다.");
	    			System.exit(0);	
	    	}
	    }
	   
	    /**
		 * 대분류 범죄명 보여주기
		 */
		
		public static void callSuperCrime() {
			System.out.println("A.강력범죄");
	    	System.out.println("B.절도범죄");
	    	System.out.println("C.폭력범죄");
	    	System.out.println("D.지능범죄");
	    	System.out.println("E.풍속범죄");
	    	System.out.println("F.특별범죄");
	    	System.out.println("G.기타범죄");
		}
		
		/**
		 * 세부범죄 확인 
		 */
		public static void CallMidCrime() {
			System.out.println("항목별 범죄명을 확인 할 수 있습니다.");
			System.out.println("원하는 문자를 입력해주세요.");
			String name = sc.nextLine();
			CriminalController.CallMidCrime(name);
		}
		 
		/**
	     * 2. 범죄별 발생횟수 검색
	     * */
	     public static void SearchOccur(){
	    	 System.out.println("검색할 범죄의 번호를 입력해주세요");
	    	 int number = Integer.parseInt(sc.nextLine());
	    	 CriminalController.SearchOccur(number);
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
	    	 String id = sc.nextLine();
	    	 
	    	 System.out.println("수정 내용은?");
	    	 String comment = sc.nextLine();
	    	
	    	 CriminalDTO dto =  new CriminalDTO(id, null, null, comment);
	    	 
	    	 CriminalController.managerUpdate(dto);
	     }
	    
	    /**
	     * 삭제
	     * */
	     public static void managerDelete() {
	    	 System.out.println("삭제 할 범죄코드를 입력해주세요.");
	    	 String id = sc.nextLine();
	    	 
	    	 CriminalController.managerDelete(id);
	     }
	}