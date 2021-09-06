package com.epam.jwd.view;

import com.epam.jwd.controller.Controller;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.exeption.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exeption.WrongIdException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class View {
    private final static String INCORRECT_CHOISE_MESSAGE = "Incorrect choice";
    private final static String INPUT_LETTER_MESSAGE = "Input letter:";
    private static final Logger logger = LogManager.getLogger(View.class);
    private static final String menu = "\n" +
            "1. Create company\n" +
            "2. Select company to edit\n" +
            "3. Add airplane to company\n" +
            "4. Delete airplane from company\n" +
            "5. Print company`s airplanes\n" +
            "6. Calculate total payload\n" +
            "7. Calculate total capacity\n" +
            "8. Find airplane by fuel consumption\n" +
            "9. Sort airplanes by range\n" +
            "10. Save to memory\n" +
            "11. Exit";
    private static Company selectedCompany;
    private static boolean whileState = true;

    private static int readInt() {
        Scanner scanner = new Scanner(System.in);
        int choise = 0;
        try {
            choise = scanner.nextInt();
        } catch (Exception e) {
            whileState = false;
            logger.error(INCORRECT_CHOISE_MESSAGE, e);
        }
        return choise;
    }

    private static int readInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int choise = 0;
        try {
            choise = scanner.nextInt();
        } catch (Exception e) {
            whileState = false;
            logger.error(INCORRECT_CHOISE_MESSAGE, e);
        }
        return choise;
    }

    private static String readString() {
        logger.info(INPUT_LETTER_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            whileState = false;
            logger.error(INCORRECT_CHOISE_MESSAGE, e);
        }
        return "";
    }

    private static void printCompanies() {
        Controller.getCompanies().stream()
                .forEach(company1 -> System.out.println(String.format("Company: %s (id=%d) ", company1.getName(), company1.getId())));
    }

    private static void printDefaultAirplanes() {
        Controller.getDefaultAirplanes().stream()
                .forEach(System.out::println);
    }

    private static void printCompanyAirplanes() {
        System.out.println("List of " + selectedCompany.getName() + " airplanes");
        Controller.getCompanyAirplanes(selectedCompany).stream()
                .forEach(System.out::println);
    }

    private static void printCompanyCargoAirplanes() {
        System.out.println("List of " + selectedCompany.getName() + " cargo airplanes:");
        Controller.getCompanyAirplanes(selectedCompany).stream()
                .filter(airplane -> airplane instanceof CargoPlane)
                .forEach(System.out::println);
    }

    private static void printCompanyPassengersAirplanes() {
        System.out.println("List of " + selectedCompany.getName() + " passengers airplanes:");
        Controller.getCompanyAirplanes(selectedCompany).stream()
                .filter(airplane -> airplane instanceof PassengerPlane)
                .forEach(System.out::println);
    }

    public void start(Level logLevel) throws WrongIdException, MinMaxFuelConsumptionExeption {
        while (whileState) {
            if (selectedCompany != null) {
                System.out.println("\n* Selected company to edit: " + selectedCompany.getName());
            }
            System.out.println(menu);
            switch (readInt()) {
                case 1:
                    System.out.println("Enter company name:");
                    selectedCompany = Controller.createCompany(readString());
                    break;
                case 2:
                    System.out.println("Select company id:");
                    printCompanies();
                    selectedCompany = Controller.getCompanies().get(readInt());
                    break;
                case 3:
                    printDefaultAirplanes();
                    System.out.println("Select airplane id:");
                    Controller.addAirplanesToCompany(selectedCompany, readInt());
                    printCompanyAirplanes();
                    break;
                case 4:
                    printCompanyAirplanes();
                    System.out.println("Select airplane id:");
                    Controller.deleteAirplaneFromCompany(selectedCompany, readInt());
                    printCompanyAirplanes();
                    break;
                case 5:
                    printCompanyAirplanes();
                    break;
                case 6:
                    printCompanyCargoAirplanes();
                    System.out.println("Total payload of all company`s cargo airplanes: " + Controller.calculatePayload(selectedCompany));
                    break;
                case 7:
                    printCompanyPassengersAirplanes();
                    System.out.println("Total capacity of all company`s passenger airplanes:" + Controller.calculateTotalCapacity(selectedCompany));
                    break;
                case 8:
                    System.out.println("Find Airplane by range of Fuel Consumption");
                    Controller.findAirplaneByFuelConsumption(selectedCompany, readInt("Enter min Fuel Consumption:"), readInt("Enter max Fuel Consumption:")).stream()
                            .forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("Sorted by range airplanes:");
                    Controller.sortAirplaneByRange(selectedCompany).stream().forEach(System.out::println);
                    break;
                case 10:
                    Controller.saveToMemory();
                case 11:
                    whileState = false;
                default:
                    break;
            }
        }
    }
}


