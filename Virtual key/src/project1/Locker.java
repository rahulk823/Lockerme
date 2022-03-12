package project1;

import java.util.*;
import java.io.*;

class Locker {
	public static String directory = "/Users/rahul/";

	static void createFile(String name) {
		try {
			File myObj = new File(directory + name);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	static void deleteFile(String name) {
		File myObj = new File(directory + name);
		if (myObj.delete()) {
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}
	}

	static void listFiles() {
		try {
		File myObj = new File(directory);
		String[] files = myObj.list();

		for (String filename : files) {
			System.out.println(filename);
		}
	}
		catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	static void searchFile(String name) {
		File myObj = new File(directory);
		String[] files = myObj.list();

		boolean isFilePresent = false;

		for (String filename : files) {
			if (name.compareTo(filename) == 0) {
				isFilePresent = true;
				break;
			}
		}

		if (isFilePresent) {
			System.out.println("File is Present");
		} else {
			System.out.println("File is not Present");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n\n---------- LockerMe.com ----------");
			System.out.println("Developed by : Rahul Kuzhi Parambil");
			System.out.println("Main Menu :");
			System.out.println("1. List all files ");
			System.out.println("2. Business level Operation  \n\t 2.Create file  \n\t 3.Delete file  \n\t 4.Search file");
			System.out.println("5. Quit the program ");
			System.out.println("\n ENTER YOUR CHOICE :");

			int userOperation = sc.nextInt();

			String name = "";
			switch (userOperation) {
			case 2:
				sc.nextLine();
				System.out.print("Enter name of the File : ");
				name = sc.nextLine();
				createFile(name);
				break;
			case 3:
				sc.nextLine();
				System.out.print("Enter name of the File : ");
				name = sc.nextLine();
				deleteFile(name);
				break;
			case 1:
				listFiles();
				break;
			case 4:
				sc.nextLine();
				System.out.print("Enter name of the File : ");
				name = sc.nextLine();
				searchFile(name);
				break;
			case 5:
				System.out.println("Application closed ");
				System.exit(0);
			default:
				System.exit(0);
			}
		}
	}
}
