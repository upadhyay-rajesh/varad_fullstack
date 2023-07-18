package com.facebookvarad;

import java.util.Scanner; //here import is like include which will add Scanner class to use

public class AddTwoNumber { //class is a wrapper around main method and it is must to write . every function, variable, constant etc must be inside class

	public static void main(String[] args) { //java main method template to start execution of java program
		
		Scanner sc=new Scanner(System.in); //to take input in java we are using Scanner class
		
		System.out.println("Enter First number");
		int i=sc.nextInt();
		
		System.out.println("Enter Second number");
		int j=sc.nextInt();
		
		System.out.println("Addition is "+(i+j));
		

	}

}
