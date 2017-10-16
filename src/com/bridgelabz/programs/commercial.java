package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.utility;

public class commercial {

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter your choice..........");
			System.out.println("1.create user");
			System.out.println("2.Buy");
			System.out.println("3.Sell");
			System.out.println("4.display");
			System.out.println("5.Exite");
			choice=scanner.nextInt();
			String name,symbol;
			int amount;
			switch(choice) {
			case 1:  System.out.println("Create User..........");
			         utility.createUser();
			         break;
			       
			case 2: utility.Buy();
			        break;
			       
			case 3: utility.sell();
		            break;
		     
			case 4: utility.display();
			        break;
			case 5:System.exit(0);
			       break;
			      
			}
		}while(choice<=4);

	}

}
