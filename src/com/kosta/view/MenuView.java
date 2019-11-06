package com.kosta.view;

import java.util.Scanner;

import com.kosta.controller.CriminalController;
import com.kosta.controller.CriminalControllerImpl;
import com.kosta.dto.CriminalDTO;
import com.kosta.service.CriminalServiceImpl;

public class MenuView {

	
	   static Scanner sc =new Scanner(System.in);
	   /**
	    * �޴�
	    * */
	    public static void menuChoice() {
	         while(true) {
	        	 System.out.println("\n**********************************");
	        	 System.out.print("[ 0.�����ڸ�� ");
	        	 System.out.print("1.��ü�˻� ");
	        	 System.out.print("2.���ΰ˻� ");
//	        	 System.out.println("2. ���˺� ó������");
//	        	 System.out.print("2.���˺� �˰űⰣ ");
//	          	 System.out.print("3.���˺� �߻�Ƚ�� ");
//	         	 System.out.print("4.comment ���� ");
//	         	 System.out.print("5.comment ���� ");
	         	 System.out.print("3.���� ]");

	             System.out.println("\n**********************************");
	             System.out.println("�޴��� �������ּ���.");
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
	    public static void managerMode() {
	    	System.out.println("��й�ȣ�� �Է����ּ���.");
	    	try{
	    		String password = sc.nextLine();	
	
	    		for(int i =0 ; i < 3; i++) {
	    		
		    	if(CriminalController.PWCheck(password)) {
		    		System.out.print("1.comment ���� ");
		         	System.out.print("2.comment ���� ");
		           int num = Integer.parseInt(sc.nextLine());	
		           	switch(num) {
		           	case 1:
		           		managerUpdate();
		           		i = 3;
		           		break;
		            case 2:
		            	i = 3;
		            	managerDelete();
		    		    break;
		    		 
	           	}
	    	} 	
	    		}
	    		System.out.println("��й�ȣ 3�� ");
		    	System.exit(0);
	    		
		    	
	    	}catch (NumberFormatException e) {
	    		System.out.println("ó������ ���ư��ϴ�.");
	    	}
	    }
	    
	    /**
	     * 2. ���ΰ˻�
	     */
	    public static void SearchMode() { 
	    	
	    	System.out.println("�Ʒ���ȣ �� �Է����ּ���");
	    	System.out.println("1���� ������ ���˺� ���ι��˸� Ȯ���� �� �ֽ��ϴ�.");
	    	System.out.println("2���� ������ ���˺� �˰űⰣ�� Ȯ���� �� �ֽ��ϴ�.");
	    	
	    	try {
	    	int nums = Integer.parseInt(sc.nextLine());
	    	switch(nums) {
	    	case 1:
	    		callSuperCrime();
	    		callMidCrime(str);
	    		break;
	    	case 2:
	    		callSuperCrime();
	    		SearchArrest();
	    		break;
	    	}
	    	}catch( NumberFormatException e) {
	    		System.out.println("1���� 2�� �� ��ȣ�� �Է����ּ���.");
	    	}finally {
	    		System.out.println("�ٸ� ���˵� Ȯ���Ͻðڽ��ϱ� yes or no");
	    		String choice = sc.nextLine();
	    		if(choice.equals("yes")) { 
	    			System.out.println("���ϴ� ��ȣ�� �Է����ּ���");
	    			int str = sc.nextLine();
	    			callMidCrime(str);
	    		}else System.out.println("�����մϴ�.");
	    			System.exit(0);	
	    	}
	    }
	   
	    /**
		 * ��з� ���˸� �����ֱ�
		 */
		
		public static void callSuperCrime() {
			System.out.println("A.���¹���");
	    	System.out.println("B.��������");
	    	System.out.println("C.���¹���");
	    	System.out.println("D.���ɹ���");
	    	System.out.println("E.ǳ�ӹ���");
	    	System.out.println("F.Ư������");
	    	System.out.println("G.��Ÿ����");
		}
		
		/**
		 * ���ι��� Ȯ�� 
		 */
		public static void callMidCrime(String str) {
			System.out.println("�׸� ���˸��� Ȯ�� �� �� �ֽ��ϴ�.");
			System.out.println("���ϴ� ��ȣ�� �Է����ּ���.");
			try {
				String name = sc.nextLine();
				
			}catch(Exception e) {
				System.out.println("�ٽ� �Է����ּ���");
				
			}finally {
				
			}

		}
		 
		/**
	     * 2. ���˺� �߻�Ƚ�� �˻�
	     * */
	     public static void SearchOccur(){
	    	 System.out.println("�˻��� ������ ��ȣ�� �Է����ּ���");
	    	 int number = Integer.parseInt(sc.nextLine());
	    	 CriminalController.SearchOccur(number);
	     }
	     
	     /**
		     * 3. ���˺� �˰űⰣ �˻�
		     * */
		     public static void SearchArrest(){
		    	 System.out.println("�˻� �� ���˸��� �Է����ּ���");
		    	 String midcrime = sc.nextLine();
		    	 CriminalController.SearchOccur(midcrime);
		     }
	     
	    /**
	     * ����
	     * */
	     public static void managerUpdate() {
	    	 System.out.println("���� �� �����ڵ��� �Է����ּ���");
	    	 String id = sc.nextLine();
	    	 
	    	 System.out.println("���� ������?");
	    	 String comment = sc.nextLine();
	    	
	    	 CriminalDTO dto =  new CriminalDTO(id, null, null, comment);
	    	 
	    	 CriminalController.managerUpdate(dto);
	     }
	    
	    /**
	     * ����
	     * */
	     public static void managerDelete() {
	    	 System.out.println("���� �� �����ڵ带 �Է����ּ���.");
	    	 String id = sc.nextLine();
	    	 
	    	 CriminalController.managerDelete(id);
	     }
	}