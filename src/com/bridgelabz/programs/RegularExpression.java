package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.utility;

public class RegularExpression {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String fullUserName,mobile_Number;
	
		System.out.println("Enter the Full Name of The User....");
		fullUserName=scanner.nextLine();
		
		System.out.println("Enter the Mobile Number........");
		mobile_Number=scanner.next();
		
	String message=" Hello <<name>> , "
			+ "We have your full name as <<full name>>  in our system."
			+ " your contact number is 91-xxxxxxxxxx. "
			+ "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016. ";
	
	
	System.out.println(utility.regExpression(fullUserName,mobile_Number,message));
	
		scanner.close();

	}

}
