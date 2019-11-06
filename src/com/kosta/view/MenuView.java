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
	    		System.out.print("4.comment ���� ");
	         	System.out.print("5.comment ���� ");
	           int num = Integer.parseInt(sc.nextLine());	
	           	switch(num) {
	           	case 4:
	           		managerUpdate();
	           		break;
	            case 5:
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
	    	System.out.println("1.���¹���");
	    	System.out.println("2.��������");
	    	System.out.println("3.���¹���");
	    	System.out.println("4.���ɹ���");
	    	System.out.println("5.ǳ�ӹ���");
	    	System.out.println("6.Ư������");
	    	System.out.println("7.��Ÿ����");
	    	System.out.println("");
	    	
	    	 
	    	System.out.println("���ϴ� ��ȣ�� �Է����ּ���");
	    	System.out.println("1���� ������ ���˺� ���ι��˸� Ȯ���� �� �ֽ��ϴ�.");
	    	System.out.println("2���� ������ ���˺� �˰űⰣ�� Ȯ���� �� �ֽ��ϴ�.");
	    	try {
	    	int nums = Integer.parseInt(sc.nextLine());
	    	switch(nums) {
	    	case 1:
	    		callMidCrime(nums);
	    	case 2:
	    		SearchArrest();
	    	}
	    	}catch( NumberFormatException e) {
	    		System.out.println("1���� 2�� �� ��ȣ�� �Է����ּ���.");
	    	}finally {
	    		System.out.println("�ٸ� ���˵� Ȯ���Ͻðڽ��ϱ� yes or no");
	    		String choice = sc.nextLine();
	    		if(choice.equals("yes")) { 
	    			System.out.println("���ϴ� ��ȣ�� �Է����ּ���");
	    			int nums = Integer.parseInt(sc.nextLine());
	    			callMidCrime(nums);
	    		}else System.out.println("�����մϴ�.");
	    			System.exit(0);	
	    	}
	    }
	    
		/**
		 * ���ι��� Ȯ�� 
		 */
		public static void callMidCrime(int nums) {
			System.out.println("�׸� ���˸��� Ȯ�� �� �� �ֽ��ϴ�.");
			System.out.println("���ϴ� ��ȣ�� �Է����ּ���.");
			try {
			int num = Integer.parseInt(sc.nextLine());	
			 if(num ==1) {
	        		System.out.println("1.���α��");
	    	    	System.out.println("2.���ι̼���");
	    	    	System.out.println("3.����");
	    	    	System.out.println("4.����");
	    	    	System.out.println("5.���簭��");
	    	    	System.out.println("6.��������");
	    	    	System.out.println("7.��Ÿ�������������");
	    	    	System.out.println("8.��ȭ");
	         	}else if(num ==2) {
	         		System.out.println("1.��������");
	    	    
	         	}else if(num ==3) {
	         		System.out.println("1.����");
	    	    	System.out.println("2.����");
	    	    	System.out.println("3.ü������");
	    	    	System.out.println("4.����");
	    	    	System.out.println("5.��������");
	    	    	System.out.println("6.����������");
	    	    	System.out.println("7.����");
	    	    	System.out.println("8.�ձ�");
	         	}else if(num ==4) {
	         		System.out.println("1.��������");
	    	    	System.out.println("2.���ǳ���");
	    	    	System.out.println("3.������");
	    	    	System.out.println("4.��ȭ");
	    	    	System.out.println("5.��������");
	    	    	System.out.println("6.������������");
	    	    	System.out.println("7.���");
	    	    	System.out.println("8.Ⱦ��");
	    	    	System.out.println("8.����");
	         	}else if(num ==5) {
	         		System.out.println("1.��ǳ�ӹ���");
	         		System.out.println("2.���ڹ���");
	         	}else if(num ==6) {
	         		System.out.println("1.Ư����������");
	    	    	System.out.println("2.�������");
	    	    	System.out.println("3.���ǹ���");
	    	    	System.out.println("4.ȯ�����");
	    	    	System.out.println("5.�������");
	    	    	System.out.println("6.�뵿����");
	    	    	System.out.println("7.�Ⱥ�����");
	    	    	System.out.println("8.���Ź���");
	    	    	System.out.println("8.��������");
	         	}else if(num ==7) {
	         		System.out.println("1.��Ÿ����");
			}
			}catch(NumberFormatException e) {
				
		}
		}
		/**
	     * 2. ���˺� �߻�Ƚ�� �˻�
	     * */
	     public static void SearchOccur(){
	    	 System.out.println("�˻� �� ���˸��� �Է����ּ���");
	    	 String supercrime = sc.nextLine();
	    	 CriminalController.SearchOccur(supercrime);
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
	    	 int code = Integer.parseInt(sc.nextLine());
	    	 
	    	 System.out.println("���� ������?");
	    	 String comment = sc.nextLine();
	    	
	    	 CriminalDTO dto =  new CriminalDTO(code, null, null, comment);
	    	 
	    	 CriminalController.managerUpdate(dto);
	     }
	    
	    /**
	     * ����
	     * */
	     public static void managerDelete() {
	    	 System.out.println("���� �� �����ڵ带 �Է����ּ���.");
	    	 int code = Integer.parseInt(sc.nextLine());
	    	 
	    	 CriminalController.managerDelete(code);
	     }
	}