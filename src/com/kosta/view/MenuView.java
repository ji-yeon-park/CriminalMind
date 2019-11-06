package com.kosta.view;

import java.util.Scanner;

import com.kosta.controller.CriminalController;
import com.kosta.dto.CriminalDTO;

public class MenuView {
	   static Scanner sc =new Scanner(System.in);
	   static int password = 1234;
	   /**
	    * �޴�
	    * */
	    public static void menuChoice() {
	         while(true) {
	        	 System.out.println("\n**********************************");
	        	 System.out.print("[ 0.�����ڸ�� ");
	        	 System.out.print("1.��ü�˻� ");
	        	 System.out.print("2.���ΰ˻� ");
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
	    		int no = Integer.parseInt(sc.nextLine());		
	    	if(no == password) {
	    		System.out.print("1.comment ���� ");
	         	System.out.print("2.comment ���� ");
	           int num = Integer.parseInt(sc.nextLine());	
	           	switch(num) {
	           	case 1:
	           		managerUpdate();
	           		break;
	            case 2:
	            	managerDelete();
	    		    break;
	            default:
	            	System.out.println("��й�ȣ�� �ٽ� �Է����ּ���."); 
	            	
	           	}
	    	}
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
	    		CallMidCrime();
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
	    			System.out.println("���ϴ� ���ڸ� �Է����ּ���");
	    			String str = sc.nextLine();
	    			CallMidCrime();
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
		public static void CallMidCrime() {
			System.out.println("�׸� ���˸��� Ȯ�� �� �� �ֽ��ϴ�.");
			System.out.println("���ϴ� ���ڸ� �Է����ּ���.");
			String name = sc.nextLine();
			CriminalController.CallMidCrime(name);
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