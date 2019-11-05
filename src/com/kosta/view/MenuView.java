package com.kosta.view;

import java.util.Scanner;

import mvc.controller.BoardController;
import mvc.model.dto.BoardDTO;

public class MenuView {
	   static Scanner sc =new Scanner(System.in);
	 
	   /**
	    * �޴�
	    * */
	    public static void menuChoice() {
	         while(true) {
	        	 System.out.println("\n----------------------------------------");
	        	 System.out.print("[ 1. ��ü�˻� ");
	        	 System.out.print("2. �۹�ȣ�� �ش��ϴ� �˻� ");
	          	System.out.print("3. ���� ���Ե� �˻� ");
	         	System.out.print("4. ��� ");
	         	System.out.print("5. ���� ");
	         	System.out.print("6. ���� ");
	         	System.out.print("7. ���� ]");

	              System.out.println("\n--------------------------------------------");
	              System.out.println("���ø޴���?");
	              try {
		              int menu = Integer.parseInt(sc.nextLine());
		              switch (menu) {
					  case 1:
						  BoardController.boardSelectByAll();	
						break;
		               case 2:
		            	   inputBoardByno(); //�����ϴ� �Խù�
						break;
		               case 3:
		            	   inputBoardBySubject();
		 				break;
		               case 4:
		            	   inputInsertBoard();
		 				break;
		               case 5:
		    				inputUpdateBoard();
		    				break;
		               case 6:
		            	   inputDeleteBoard();
		    				break;
		               case 7:
		            	  System.out.println("������ �ٽ� ������~~^^ �α׾ƿ��˴ϴ�...");
		    			 System.exit(0);	
		    			break;
					default:
						System.out.println("�߸��Ǿ����ϴ�..�ٽ� �Է����ּ���.");
					}
		        	 
	              }catch (NumberFormatException e) {
					System.out.println("�޴��� ���ڸ� �����մϴ�.");
				}
	         }//while��
	    	
	    }
	    /**
	     * 2. �۹�ȣ �˻�...
	     * */
	     public static void inputBoardByno() {
	    	 try {
		    	 System.out.println("�۹�ȣ�� ???");
		    	 String no = sc.nextLine();
		    	 
		    	 BoardController.boardSelectByNo(Integer.parseInt(no));
	    	  }catch (NumberFormatException e) {
				System.out.println("�۹�ȣ�� ���ڸ� �Է����ּ���.");
				System.out.println("�ٽ� �ҷ���?  yes or no");
				String choice = sc.nextLine();
				if(choice.equals("yes")) {
					inputBoardByno();
				}
			 }//catch��End
	     }//�޼ҵ� end
	     
	     /**
	      *  �˻��ʵ�..�˻�
	      * */
	     public static void inputBoardBySubject() {
	    	 System.out.println("ã�� ���ڿ��� ???");
	    	 String word = sc.nextLine();
	    	 BoardController.boardSelectBySubject(word);
	     }
	    
	    
	    /**
	     *  ���
	     * */
	     public static void inputInsertBoard() {
	    	 System.out.println("������?");
	    	 String subject = sc.nextLine();
	    	 
	    	 System.out.println("�ۼ���?");
	    	 String writer = sc.nextLine();
	    	 
	    	 System.out.println("������?");
	    	 String content = sc.nextLine();
	    	 
	    	 BoardDTO board =  new BoardDTO(0, subject, writer, content, null);
	    	 BoardController.boardInsert(board);
	     }
	     
	    /**
	     * ����
	     * */
	     public static void inputUpdateBoard() {
	    	 System.out.println("���� �� �Խù� ��ȣ��?");
	    	 int no = Integer.parseInt(sc.nextLine());
	    	 
	    	 System.out.println("���� ������?");
	    	 String content = sc.nextLine();
	    	
	    	 BoardDTO board =  new BoardDTO(no, null, null, content, null);
	    	 
	    	 BoardController.boardUpdate(board);
	     }
	    
	    /**
	     * ����
	     * */
	     public static void inputDeleteBoard() {
	    	 System.out.println("���� �Խù� ��ȣ��?");
	    	 int no = Integer.parseInt(sc.nextLine());
	    	 BoardController.boardDelete(no);
	     }
	}