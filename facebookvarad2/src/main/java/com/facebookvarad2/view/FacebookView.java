package com.facebookvarad2.view;

import java.util.Scanner;

import com.facebookvarad2.controller.FacebookController;
import com.facebookvarad2.controller.FacebookControllerInterface;

public class FacebookView {

	public static void main(String[] args)throws Exception {
		
		String ss="y";
		
		while(ss.equals("y")){
		
		System.out.println("****************MAIN MENU****************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to delete profile");
		System.out.println("press 4 to edit profile");
		System.out.println("press 5 to search profile");
		System.out.println("press 6 to view all profile");

		System.out.println("Enter your choice");
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();
		
		FacebookControllerInterface c=new FacebookController();

		switch (choice) {
		case 1:
			c.createProfile();
			break;
		case 2:
			c.viewProfile();
			break;
		case 3:
			c.deleteProfile();
			break;
		case 4:
			c.editProfile();
			break;
		case 5:
			c.searchProfile();
			break;
		case 6:
			c.viewAllProfile();
			break;
		default:
			System.out.println("wrong choice");
		}
	System.out.println("do you want to procede press y/n");
	ss=sc.next();
	}

	}

}
