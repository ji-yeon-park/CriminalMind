package com.kosta.view;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.kosta.controller.CriminalController;
import com.kosta.controller.CriminalControllerImpl;
import com.kosta.dto.CrimeInfoDTO;

public class MenuView {
		CriminalController controller = new CriminalControllerImpl();
	   static Scanner sc = new Scanner(System.in);
	   static private int mode = 0;
	   /**
	    * 메뉴
	    * */
	    public void menuChoice() {
	         while(true) {
	        	 
	        	 if (mode==0) System.out.println("**********************************");
	        	 else System.out.println("***********관리자모드ON************");

	        	 System.out.print("[1.전체검색 ");
	        	 System.out.print("2.세부검색 ");
	        	 System.out.print("3.관리자모드 ");
	        	 System.out.print("9.종료 ]");
	             System.out.println("\n**********************************");
	             System.out.println("메뉴를 선택해주세요.");
	             
	              try {
		              int menu = Integer.parseInt(sc.nextLine());
		              switch (menu) {

		              case 1:
						   SelectAll();	
						   sc.nextLine();
						   //버퍼 치우기
						   break;
		               case 2:
		            	   SearchMode();
		            	   sc.nextLine();
		            	   break;
		            	
		              case 3:
		            	  if (mode==0) {
		            	  managerMode();
		            	} else System.out.println("이미 관리자모드 입니다.");
		            	  break;
		               case 9:
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
	    public void managerMode() {
	    	System.out.print("비밀번호를 입력해주세요.");
	    	
	    	//패스워드 마스킹 코드
	    	//이클립스 실행 안됨	    	
//	    	char passwd[];
//	    	String stPw;
//	    	Console cons = System.console();
//	    	passwd = cons.readPassword(" Enter Your Password : ");
//
//
//	    	java.util.Arrays.fill(passwd, ' ');
//	    	stPw = new String(passwd);
//	    	System.out.println("The Password is : " + stPw);
	    	
	    	try{
	    		for(int i =0 ; i < 3; i++) {  	
	    			String password = sc.nextLine();
	    			
		    	if(controller.PWCheck(password)) {
		    		mode=1;
		    		return;
		    	} else	System.out.println("잘못된 패스워드 입니다 (" + (i+1) + "/3)");
	    		}
	    		System.out.println("비밀번호 3번 실패해서 종료합니다. ");
		    	System.exit(0);
	    	}catch (NumberFormatException e) {
	    		System.out.println("처음으로 돌아갑니다.");
	    	}
	    }
	    
	    /**
	     * 1. 전체 검색
	     */
	    public void SelectAll() {
	    	System.out.println("전체 보기를 원하시는 테이블을 선택해 주세요");
	    	System.out.println("1. 2016 서울 범죄 발생 횟수");
	    	System.out.println("2. 2016 범죄 발생일로 부터 검거 기간");
	    	try {
	    		int nums = sc.nextInt();
		    	if(nums ==1 ) controller.SelectAll();
		    	else if(nums ==2) controller.SelectAll2();
		    	else System.out.println("잘못 입력 하셨습니다");
		
	    	} catch (Exception e) {
	    		FailView.failmessage("잘못 입력 하셨습니다");
			}
	    }
	   

	    /**
	     * 2. 세부검색
	     */
	    public void SearchMode() { 
	    	controller.callSuperCrime();
	    	System.out.println("다음 목록 중 한가지를 선택해주세요");
	    	try {
	    	String name = sc.nextLine();
//	    	boolean b = Pattern.matches("[a-z]", name) || Pattern.matches("[A-Z]", name);
	    	boolean b = Pattern.matches("[a-g]", name) || Pattern.matches("[A-G]", name);
	    	//확장성 문제..
	    	
	    	
	    	if(b==false) {
	    		System.out.println("잘못된 값을 입력하셨습니다.");
	    		return;
	    	}
	    	
	    	System.out.println("1번을 누르면 범죄별 세부항목을 확인할 수 있습니다.");
	    	System.out.println("2번을 누르면 2016 서울 범죄 발생 횟수를 확인할 수 있습니다.");
	    	int nums = sc.nextInt();
	    	
	    	switch(nums) {
	    	case 1:
	    		controller.CallMidCrime(name);
	    		System.out.println("다음 목록 중 한가지를 선택해주세요");
	    		System.out.println("범죄 발생일로 부터 검거 기간을 확인할 수 있습니다.");
	    		
	    		sc.nextLine();
	    		//버퍼처리
	    		int num = sc.nextInt();
	    		String name2 = Integer.toString(num-1);
	    		if(name2.length()<2) name2 = "0"+name2;
	    		controller.SearchArrest(name+"-"+name2);
	    		
	    		if (mode==1)  {
	    			while(true) {
	    			System.out.println("수정은 1번, 삽입은 2번, 삭제는 3번, 메인 화면으로 되돌아가기는 4번을 입력하세요");
	    			int choose = sc.nextInt();
	    			switch(choose) {
	    			case 1 :
		    			System.out.println("comments를 입력하세요 : ");
		    			sc.nextLine();
		    			String comments = sc.nextLine();
		    			controller.managerUpdate2(name+"-"+name2,comments);
		    			return;
	    			case 4 : 
	    				return;
	    			default : 
	    				System.out.println("잘못 입력하셨습니다.");
	    				break;
	    			}
	    			}
	    		}

	    		break;
	    	case 2:    	
	    		controller.SearchOccur(name);
	    		if (mode==1) {
	    			while(true) {
	    			System.out.println("수정은 1번, 삽입은 2번, 삭제는 3번, 메인 화면으로 되돌아가기는 4번을 입력하세요");
	    			int choose = sc.nextInt();
	    			switch(choose) {
	    			case 1 :
		    			System.out.println("comments를 입력하세요 : ");
		    			sc.nextLine();
		    			String comments = sc.nextLine();
		    			controller.managerUpdate(name,comments);
		    			return;
	    			case 4 : 
	    				return;
	    			default : 
	    				System.out.println("잘못 입력하셨습니다.");
	    				break;
		
	    			}
	    			}
	    		}
	    	default : 
				System.out.println("잘못 입력하셨습니다.");
				break;
	    	}
	    	
	    	}catch( Exception e) {
	    		System.out.println("1번과 2번 이외의 값을 입력 하셨습니다.");
	    	}
//	    	
//	    	finally {
//	    		System.out.println("다른 범죄도 확인하시겠습니까 yes or no");
//	    		sc.nextLine();
//	    		String choice = sc.nextLine();
//	    		if(choice.equals("yes")) { 
//	    			System.out.println("원하는 문자를 입력해주세요");
//	    			String name = sc.nextLine();
//	    			CriminalController.CallMidCrime(name);
//	    		}else 
//	    			System.out.println("종료합니다.");
//    			System.exit(0);	
//	    	}
	    }
}
		     
		     //////////////////
	
//	     
//	    /**
//	     * 수정
//	     * */
//	     public static void managerUpdate() {
//	    	 System.out.println("수정 할 범죄코드을 입력해주세요");
//	    	 String id = sc.nextLine();
//	    	 
//	    	 System.out.println("수정 내용은?");
//	    	 String comment = sc.nextLine();
//	    	
//	    	 CriminalDTO dto =  new CriminalDTO(id, null, null, comment);
//	    	 
//	    	 CriminalController.managerUpdate(dto);
//	     }
//	    
//	    /**
//	     * 삭제
//	     * */
//	     public static void managerDelete() {
//	    	 System.out.println("삭제 할 범죄코드를 입력해주세요.");
//	    	 String id = sc.nextLine();
//	    	 
//	    	 CriminalController.managerDelete(id);
//	     }
//	}
//
//		