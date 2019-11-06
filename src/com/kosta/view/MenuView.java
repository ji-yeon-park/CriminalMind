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
//	        	 System.out.println("2. 범죄별 처벌내용");
//	        	 System.out.print("2.범죄별 검거기간 ");
//	          	 System.out.print("3.범죄별 발생횟수 ");
//	         	 System.out.print("4.comment 수정 ");
//	         	 System.out.print("5.comment 삭제 ");
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
		            	   //SearchOccur();
						break;
//		               case 3:
//		            	   SearchArrest();
//		 				break;
//		               case 4:
//		            	   managerUpdate();
//		 				break;
//		               case 5:
//		            	   managerDelete();
//		    				break;
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
	    	System.out.println("");
	    	
	    	 
	    	System.out.println("원하는 번호를 입력해주세요");
	    	System.out.println("1번을 누르면 범죄별 세부범죄를 확인할 수 있습니다.");
	    	System.out.println("2번을 누르면 범죄별 검거기간을 확인할 수 있습니다.");
	    	try {
	    	int nums = Integer.parseInt(sc.nextLine());
	    	switch(nums) {
	    	case 1:
	    		callMidCrime(nums);
	    	case 2:
	    		SearchArrest();
	    	}
	    	}catch( NumberFormatException e) {
	    		System.out.println("1번과 2번 중 번호를 입력해주세요.");
	    	}finally {
	    		System.out.println("다른 범죄도 확인하시겠습니까 yes or no");
	    		String choice = sc.nextLine();
	    		if(choice.equals("yes")) { 
	    			System.out.println("원하는 번호를 입력해주세요");
	    			int nums = Integer.parseInt(sc.nextLine());
	    			callMidCrime(nums);
	    		}else System.out.println("종료합니다.");
	    			System.exit(0);	
	    	}
	    }
	    
		/**
		 * 세부범죄 확인 
		 */
		public static void callMidCrime(int nums) {
			System.out.println("항목별 범죄명을 확인 할 수 있습니다.");
			System.out.println("원하는 번호를 입력해주세요.");
			try {
			int num = Integer.parseInt(sc.nextLine());	
			 if(num ==1) {
	        		System.out.println("1.살인기수");
	    	    	System.out.println("2.살인미수등");
	    	    	System.out.println("3.강도");
	    	    	System.out.println("4.강간");
	    	    	System.out.println("5.유사강간");
	    	    	System.out.println("6.강제추행");
	    	    	System.out.println("7.기타강간강제추행등");
	    	    	System.out.println("8.방화");
	         	}else if(num ==2) {
	         		System.out.println("1.절도범죄");
	    	    
	         	}else if(num ==3) {
	         		System.out.println("1.상해");
	    	    	System.out.println("2.폭행");
	    	    	System.out.println("3.체포감금");
	    	    	System.out.println("4.협박");
	    	    	System.out.println("5.약취유인");
	    	    	System.out.println("6.폭력행위등");
	    	    	System.out.println("7.공갈");
	    	    	System.out.println("8.손괴");
	         	}else if(num ==4) {
	         		System.out.println("1.직무유기");
	    	    	System.out.println("2.직권남용");
	    	    	System.out.println("3.증수뢰");
	    	    	System.out.println("4.통화");
	    	    	System.out.println("5.문서인장");
	    	    	System.out.println("6.유가증권인지");
	    	    	System.out.println("7.사기");
	    	    	System.out.println("8.횡령");
	    	    	System.out.println("8.배임");
	         	}else if(num ==5) {
	         		System.out.println("1.성풍속범죄");
	         		System.out.println("2.도박범죄");
	         	}else if(num ==6) {
	         		System.out.println("1.특별경제범죄");
	    	    	System.out.println("2.마약범죄");
	    	    	System.out.println("3.보건범죄");
	    	    	System.out.println("4.환경범죄");
	    	    	System.out.println("5.교통범죄");
	    	    	System.out.println("6.노동범죄");
	    	    	System.out.println("7.안보범죄");
	    	    	System.out.println("8.선거범죄");
	    	    	System.out.println("8.병역범죄");
	         	}else if(num ==7) {
	         		System.out.println("1.기타범죄");
			}
			}catch(NumberFormatException e) {
				
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