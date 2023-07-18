package com.facebookvarad;

import java.util.Scanner;

public class Table {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no to write table");
		int i=sc.nextInt();
		
		for(int j=1;j<=10;j++) { //j++==j+1
			System.out.println(i*j);
		}

	}

}
