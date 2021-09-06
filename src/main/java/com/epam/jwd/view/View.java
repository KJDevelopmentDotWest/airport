package com.epam.jwd.view;

import com.epam.jwd.controller.Controller;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;
import com.epam.jwd.service.exception.MinMaxFuelConsumptionExeption;
import com.epam.jwd.service.exception.WrongIdException;
import com.epam.jwd.view.api.Performer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final static String INCORRECT_CHOICE_MESSAGE = "Incorrect choice";
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
    public static final String STRING_PLEASE_SELECT_COMPANY = "Please select company";
    private static Company selectedCompany;
    private static boolean whileState = true;

    private static final Map<Integer, Performer> userInputToPerformerMap = new HashMap<>();

    public View(){
        userInputToPerformerMap.put(1, this::createCompanyOption);
        userInputToPerformerMap.put(2, this::getCompanyByIdOption);
        userInputToPerformerMap.put(3, this::addAirplaneToCompanyOption);
        userInputToPerformerMap.put(4, this::deleteAirplaneFromCompanyOption);
        userInputToPerformerMap.put(5, this::printCompanyAirplanesOption);
        userInputToPerformerMap.put(6, this::calculateTotalPayloadOption);
        userInputToPerformerMap.put(7, this::calculateTotalCapacityOption);
        userInputToPerformerMap.put(8, this::findByFuelConsumptionOption);
        userInputToPerformerMap.put(9, this::sortByRangeOption);
        userInputToPerformerMap.put(10, this::saveOption);
        userInputToPerformerMap.put(11, this::exitOption);
    }

    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            whileState = false;
            logger.error(INCORRECT_CHOICE_MESSAGE, e);
        }
        return choice;
    }

    private int readInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            whileState = false;
            logger.error(INCORRECT_CHOICE_MESSAGE, e);
        }
        return choice;
    }

    private String readString(String message) {
        logger.info(INPUT_LETTER_MESSAGE);
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            whileState = false;
            logger.error(INCORRECT_CHOICE_MESSAGE, e);
        }
        return "";
    }

    private void printCompanies() {
        Controller.getCompanies()
                .forEach(company1 -> System.out.printf("Company: %s (id=%d) %n", company1.getName(), company1.getId()));
    }

    private void printDefaultAirplanes() {
        Controller.getDefaultAirplanes()
                .forEach(System.out::println);
    }

    private void printCompanyAirplanes() {
        System.out.println("List of " + selectedCompany.getName() + " airplanes");
        Controller.getCompanyAirplanes(selectedCompany)
                .forEach(System.out::println);
    }

    private void printCompanyCargoAirplanes() {
        System.out.println("List of " + selectedCompany.getName() + " cargo airplanes:");
        Controller.getCompanyAirplanes(selectedCompany).stream()
                .filter(airplane -> airplane instanceof CargoPlane)
                .forEach(System.out::println);
    }

    private void printCompanyPassengersAirplanes() {
        System.out.println("List of " + selectedCompany.getName() + " passengers airplanes:");
        Controller.getCompanyAirplanes(selectedCompany).stream()
                .filter(airplane -> airplane instanceof PassengerPlane)
                .forEach(System.out::println);
    }

    public void start(Level logLevel) {
        while (whileState) {
            if (selectedCompany != null) {
                System.out.println("\n* Selected company to edit: " + selectedCompany.getName());
            }
            System.out.println(menu);
            userInputToPerformerMap.get(readInt()).execute();
        }
    }

    private void createCompanyOption(){
        selectedCompany = Controller.createCompany(readString("Enter company name:"));
    }

    private void getCompanyByIdOption(){
        printCompanies();
        selectedCompany = Controller.getCompanies().get(readInt("Select company id:"));
    }

    private void addAirplaneToCompanyOption(){
        if (selectedCompany != null){
            printDefaultAirplanes();
            try {
                Controller.addAirplanesToCompany(selectedCompany, readInt("Select airplane id:"));
            } catch (WrongIdException e) {
                logger.error(e);
            }
            printCompanyAirplanes();
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void deleteAirplaneFromCompanyOption(){
        if (selectedCompany != null){
            printCompanyAirplanes();
            Controller.deleteAirplaneFromCompany(selectedCompany, readInt("Select airplane id:"));
            printCompanyAirplanes();
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void printCompanyAirplanesOption(){
        if (selectedCompany != null) {
            printCompanyAirplanes();
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void calculateTotalPayloadOption(){
        if (selectedCompany != null) {
            printCompanyCargoAirplanes();
            System.out.println("Total payload of all company`s cargo airplanes: " + Controller.calculatePayload(selectedCompany));
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void calculateTotalCapacityOption(){
        if (selectedCompany != null) {
            printCompanyPassengersAirplanes();
            System.out.println("Total capacity of all company`s passenger airplanes:" + Controller.calculateTotalCapacity(selectedCompany));
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void findByFuelConsumptionOption(){
        if (selectedCompany != null) {
            System.out.println("Find Airplane by range of Fuel Consumption");
            try {
                Controller.findAirplaneByFuelConsumption(selectedCompany, readInt("Enter min Fuel Consumption:"), readInt("Enter max Fuel Consumption:"))
                        .forEach(System.out::println);
            } catch (MinMaxFuelConsumptionExeption e) {
                logger.error(e);
            }
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void sortByRangeOption(){
        if (selectedCompany != null) {
            System.out.println("Sorted by range airplanes:");
            Controller.sortAirplaneByRange(selectedCompany).forEach(System.out::println);
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void saveOption(){
        Controller.saveToMemory();
    }

    private void exitOption(){
        whileState = false;
    }
}


