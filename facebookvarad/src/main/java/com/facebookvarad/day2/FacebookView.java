package com.facebookvarad.day2;
//a folder will be package only if we will declare it inside our class with package keyword as a first line
import java.util.Scanner;

//import java.lang.*;
//lang is a default package not necessary to import system automatically import it and our System and String are part of it
//java package is inside JRE(java runtime environment) rt.jar file

public class FacebookView {

	public static void main(String[] args) {
		System.out.println("*********************MAIN MENU*********************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to edit profile");
		System.out.println("press 4 to delete profile");
		System.out.println("press 5 to search profile");
		System.out.println("press 6 to view all profile");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("please enter your choice");
		int choice=sc.nextInt();
		
		FacebookView f1=new  FacebookView();
		
		switch(choice) {
		case 1 : f1.createProfile();
			break;
		case 2 : f1.viewProfile();
			break;
		case 3 : f1.editProfile();
			break;
		case 4 : f1.deleteProfile();
			break;
		case 5 :f1.searchProfile();
			break;
		case 6 :f1.viewAllProfile();
			break;
			
			default : System.out.println("wrong choice");
		}

	}
	
	public void createProfile() {
		System.out.println("profile created");
	}
	
	public void viewProfile() {
		System.out.println("profile viewed");
	}
	
	public void editProfile() {
		System.out.println("profile edited");
	}
	
	public void deleteProfile() {
		System.out.println("profile deleted");
	}
	
	public void searchProfile() {
		System.out.println("profile searched");
	}
	
	public void viewAllProfile() {
		System.out.println("all profile viewed");
	}

}
