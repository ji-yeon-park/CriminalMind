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
	    * �޴�
	    * */
	    public void menuChoice() {
	         while(true) {
	        	 
	        	 if (mode==0) System.out.println("**********************************");
	        	 else System.out.println("***********�����ڸ��ON************");

	        	 System.out.print("[1.��ü�˻� ");
	        	 System.out.print("2.���ΰ˻� ");
	        	 System.out.print("3.�����ڸ�� ");
	        	 System.out.print("9.���� ]");
	             System.out.println("\n**********************************");
	             System.out.println("�޴��� �������ּ���.");
	             
	              try {
		              int menu = Integer.parseInt(sc.nextLine());
		              switch (menu) {

		              case 1:
						   SelectAll();	
						   sc.nextLine();
						   //���� ġ���
						   break;
		               case 2:
		            	   SearchMode();
		            	   sc.nextLine();
		            	   break;
		            	
		              case 3:
		            	  if (mode==0) {
		            	  managerMode();
		            	} else System.out.println("�̹� �����ڸ�� �Դϴ�.");
		            	  break;
		               case 9:
		            	  System.out.println("�����մϴ�.");
		            	  System.exit(0);	
		            	  break;
		               default:
						System.out.println("�ٽ� �Է��ϼ���");
					} 
	              }catch (NumberFormatException e) {
					System.out.println("�޴��� ���ڷ� �Է����ּ���.");
				}
	         }
	    }

	    /**
	     * 0. �Ŵ������
	     * ��й�ȣ�� �Է� �� ���� update, delete �� �� �ִ� ��� 
	     */
	    public void managerMode() {
	    	System.out.print("��й�ȣ�� �Է����ּ���.");
	    	
	    	//�н����� ����ŷ �ڵ�
	    	//��Ŭ���� ���� �ȵ�	    	
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
		    	} else	System.out.println("�߸��� �н����� �Դϴ� (" + (i+1) + "/3)");
	    		}
	    		System.out.println("��й�ȣ 3�� �����ؼ� �����մϴ�. ");
		    	System.exit(0);
	    	}catch (NumberFormatException e) {
	    		System.out.println("ó������ ���ư��ϴ�.");
	    	}
	    }
	    
	    /**
	     * 1. ��ü �˻�
	     */
	    public void SelectAll() {
	    	System.out.println("��ü ���⸦ ���Ͻô� ���̺��� ������ �ּ���");
	    	System.out.println("1. 2016 ���� ���� �߻� Ƚ��");
	    	System.out.println("2. 2016 ���� �߻��Ϸ� ���� �˰� �Ⱓ");
	    	try {
	    		int nums = sc.nextInt();
		    	if(nums ==1 ) controller.SelectAll();
		    	else if(nums ==2) controller.SelectAll2();
		    	else System.out.println("�߸� �Է� �ϼ̽��ϴ�");
		
	    	} catch (Exception e) {
	    		FailView.failmessage("�߸� �Է� �ϼ̽��ϴ�");
			}
	    }
	   

	    /**
	     * 2. ���ΰ˻�
	     */
	    public void SearchMode() { 
	    	controller.callSuperCrime();
	    	System.out.println("���� ��� �� �Ѱ����� �������ּ���");
	    	try {
	    	String name = sc.nextLine();
//	    	boolean b = Pattern.matches("[a-z]", name) || Pattern.matches("[A-Z]", name);
	    	boolean b = Pattern.matches("[a-g]", name) || Pattern.matches("[A-G]", name);
	    	//Ȯ�强 ����..
	    	
	    	
	    	if(b==false) {
	    		System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
	    		return;
	    	}
	    	
	    	System.out.println("1���� ������ ���˺� �����׸��� Ȯ���� �� �ֽ��ϴ�.");
	    	System.out.println("2���� ������ 2016 ���� ���� �߻� Ƚ���� Ȯ���� �� �ֽ��ϴ�.");
	    	int nums = sc.nextInt();
	    	
	    	switch(nums) {
	    	case 1:
	    		controller.CallMidCrime(name);
	    		System.out.println("���� ��� �� �Ѱ����� �������ּ���");
	    		System.out.println("���� �߻��Ϸ� ���� �˰� �Ⱓ�� Ȯ���� �� �ֽ��ϴ�.");
	    		
	    		sc.nextLine();
	    		//����ó��
	    		int num = sc.nextInt();
	    		String name2 = Integer.toString(num-1);
	    		if(name2.length()<2) name2 = "0"+name2;
	    		controller.SearchArrest(name+"-"+name2);
	    		
	    		if (mode==1)  {
	    			while(true) {
	    			System.out.println("������ 1��, ������ 2��, ������ 3��, ���� ȭ������ �ǵ��ư���� 4���� �Է��ϼ���");
	    			int choose = sc.nextInt();
	    			switch(choose) {
	    			case 1 :
		    			System.out.println("comments�� �Է��ϼ��� : ");
		    			sc.nextLine();
		    			String comments = sc.nextLine();
		    			controller.managerUpdate2(name+"-"+name2,comments);
		    			return;
	    			case 4 : 
	    				return;
	    			default : 
	    				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	    				break;
	    			}
	    			}
	    		}

	    		break;
	    	case 2:    	
	    		controller.SearchOccur(name);
	    		if (mode==1) {
	    			while(true) {
	    			System.out.println("������ 1��, ������ 2��, ������ 3��, ���� ȭ������ �ǵ��ư���� 4���� �Է��ϼ���");
	    			int choose = sc.nextInt();
	    			switch(choose) {
	    			case 1 :
		    			System.out.println("comments�� �Է��ϼ��� : ");
		    			sc.nextLine();
		    			String comments = sc.nextLine();
		    			controller.managerUpdate(name,comments);
		    			return;
	    			case 4 : 
	    				return;
	    			default : 
	    				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	    				break;
		
	    			}
	    			}
	    		}
	    	default : 
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
	    	}
	    	
	    	}catch( Exception e) {
	    		System.out.println("1���� 2�� �̿��� ���� �Է� �ϼ̽��ϴ�.");
	    	}
//	    	
//	    	finally {
//	    		System.out.println("�ٸ� ���˵� Ȯ���Ͻðڽ��ϱ� yes or no");
//	    		sc.nextLine();
//	    		String choice = sc.nextLine();
//	    		if(choice.equals("yes")) { 
//	    			System.out.println("���ϴ� ���ڸ� �Է����ּ���");
//	    			String name = sc.nextLine();
//	    			CriminalController.CallMidCrime(name);
//	    		}else 
//	    			System.out.println("�����մϴ�.");
//    			System.exit(0);	
//	    	}
	    }
}
		     
		     //////////////////
	
//	     
//	    /**
//	     * ����
//	     * */
//	     public static void managerUpdate() {
//	    	 System.out.println("���� �� �����ڵ��� �Է����ּ���");
//	    	 String id = sc.nextLine();
//	    	 
//	    	 System.out.println("���� ������?");
//	    	 String comment = sc.nextLine();
//	    	
//	    	 CriminalDTO dto =  new CriminalDTO(id, null, null, comment);
//	    	 
//	    	 CriminalController.managerUpdate(dto);
//	     }
//	    
//	    /**
//	     * ����
//	     * */
//	     public static void managerDelete() {
//	    	 System.out.println("���� �� �����ڵ带 �Է����ּ���.");
//	    	 String id = sc.nextLine();
//	    	 
//	    	 CriminalController.managerDelete(id);
//	     }
//	}
//
//		