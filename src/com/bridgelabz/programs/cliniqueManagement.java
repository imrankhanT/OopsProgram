package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.utility;

public class cliniqueManagement {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while (true) {
		System.out.println("Enter 1 to Add Doctors");
		System.out.println("Enter 2 to Add Patients");
		System.out.println("Enter 3 to Search Doctor");
		System.out.println("Enter 4 to Search Patient");
		System.out.println("Enter 5 to Take an appoitment");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			utility.addDoctors();
		break;
		case 2:
			utility.addPatient();
		break;
		case 3:
			utility.searchDoctor();
		break;
		case 4:
			utility.searchPatient();
		break;
		case 5:
			utility.takeAnAppointment();
		break;
		}
		}
		}
}
