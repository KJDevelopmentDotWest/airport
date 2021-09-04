package com.epam.jwd.view;


import com.epam.jwd.controller.command.Command;
import java.util.InputMismatchException;
import java.util.Scanner;


public class View  {

    public void airportOptions (){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        System.out.println("Available options for companies");

        while (choice != 0) {
            System.out.println("1. Show companies");
            System.out.println("2. Add airplane to company");
            System.out.println("3. Delete airplane from company");
            System.out.println("4. Count total payload");
            System.out.println("5. Calculate total capacity");
            System.out.println("6. Find airplane by fuel consumption");
            System.out.println("7. Sort airplanes by range");
            System.out.println("8. Add new airplane to repository");//....

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong option!");
                scanner.next();
                choice = -1;
            }

            switch (choice) {
                case 1:

                    break;


                 case 2:

                break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

               case 7:

                    break;

                case 8:

                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }




    public void showOptions() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        Command command = null;

        System.out.println("What do you want today?");

        while (choice != 0) {
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Show companies ");
            System.out.println(/*"2. Add airplane to company"*/);
            System.out.println(/*"3. Delete airplane from company"*/);
            System.out.println("4. Count total payload");
            System.out.println("5. Calculate total capacity");
            System.out.println("6. Find airplane by fuel consumption");
            System.out.println("7. Sort airplanes by range");
            System.out.println(/*"8. Add new airplane to repository"*/);
            System.out.println("0. Exit");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong option!");
                scanner.next();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.println();//...
                    break;

                case 2:
                    System.out.println("");//...
                    break;

                case 3:
                    System.out.println("");//...
                    break;

                case 4:
                    System.out.println("");//...

                    break;

                case 5:
                    System.out.println("");//...

                    break;

                case 6:
                    System.out.println("");//...
                    break;

                case 7:
                    System.out.println("");//...
                    break;

                case 8:
                    System.out.println("");//...

                    break;

                case 0:
                    System.exit(0);//...
                    break;

                default:
                    break;
            }
        }
        scanner.close();
    }
}
