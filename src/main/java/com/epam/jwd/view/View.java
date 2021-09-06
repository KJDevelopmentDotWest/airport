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
import org.apache.logging.log4j.core.config.Configurator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final static String INCORRECT_CHOICE_MESSAGE = "Incorrect choice";
    private final static String INPUT_STRING_MESSAGE = "Read String from console";
    private final static String INPUT_INT_MESSAGE = "Read int from console";
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
            "10. Delete company\n" +
            "11. Save to memory\n" +
            "12. Exit";
    private static final String STRING_LIST_OF = "List of ";
    private static final String STRING_PLEASE_SELECT_COMPANY = "Please select company";
    private static final String STRING_SORTED_BY_RANGE_AIRPLANES = "Sorted by range airplanes:";
    private static final String STRING_ENTER_MIN_FUEL_CONSUMPTION = "Enter min Fuel Consumption:";
    private static final String STRING_ENTER_MAX_FUEL_CONSUMPTION = "Enter max Fuel Consumption:";
    private static final String STRING_FIND_AIRPLANE_BY_RANGE_OF_FUEL_CONSUMPTION = "Find Airplane by range of Fuel Consumption";
    private static final String STRING_TOTAL_CAPACITY = "Total capacity of all company`s passenger airplanes:";
    private static final String STRING_TOTAL_PAYLOAD = "Total payload of all company`s cargo airplanes: ";
    private static final String STRING_SELECT_AIRPLANE_ID = "Select airplane id:";
    private static final String STRING_SELECT_COMPANY_ID = "Select company id:";
    private static final String STRING_ENTER_COMPANY_NAME = "Enter company name:";
    private static final String STRING_SELECTED_COMPANY = "\n* Selected company to edit: ";
    private static final String STRING_COMPANY = "Company: %s (id=%d) %n";
    private static final String STRING_AIRPLANES = " airplanes";
    private static final String STRING_CARGO_AIRPLANES = " cargo airplanes:";
    private static final String STRING_PASSENGERS_AIRPLANES = " passengers airplanes:";
    private static final String STRING_SELECT_MENU = "Select menu option:";

    private final static String INCORRECT_CHOICE_MESSAGE = "Incorrect choice";

    private final static String INPUT_LETTER_MESSAGE = "Input letter:";

    private static final String PRINT_DEFAULT_AIRPLANES_METHOD_MESSAGE = "We're at printDefaultAirplanes method";

    private static final String PRINT_COMPANY_AIRPLANES_METHOD_MESSAGE ="We're at printCompanyAirplanes method";

    private static final String PRINT_COMPANY_CARGO_AIRPLANES_METHOD_MESSAGE ="We're at printCompanyCargoAirplanes method";

    private static final String PRINT_COMPANY_PASSENGERS_AIRPLANES_METHOD_MESSAGE = "We're at printCompanyPassengersAirplanes method";

    private static final String START_METHOD_MESSAGE = "We're at start method";

    private static final String PRINT_COMPANY_METHOD_MESSAGE = "We're at printCompany method";

    private static final String CREATE_COMPANY_OPTION_METHOD_MESSAGE = "We're at createCompany method";

    private static final String GET_COMPANY_BY_ID_METHOD_MESSAGE ="We're at getCompanyById method";

    private static final String ADD_AIRPLANE_TO_COMPANY_OPTION_METHOD_MESSAGE = "We're at addAirplaneToCompany method";

    private static final String DELETE_AIRPLANE_FROM_COMPANY_OPTION_METHOD_MESSAGE ="We're at deleteAirplaneFromCompanyOption method";

    private static final String PRINT_COMPANY_AIRPLANES_OPTION_METHOD_MESSAGE ="We're at printCompanyAirplanesOption method";

    private static final String CALCULATE_TOTAL_PAYLOAD_OPTION_METHOD_MESSAGE = "We're at calculateTotalPayload method";

    private static final String CALCULATE_TOTAL_CAPACITY_OPTION_METHOD_MESSAGE = "We're at calculateTotalCapacity method";

    private static final String FIND_BY_FUEL_CONSUMPTION_OPTION_METHOD_MESSAGE ="We're at findByFuelConsumptionMethod method";

    private static final String SORT_BY_RANGE_OPTION_METHOD_MESSAGE ="We're at sortByRangeOption method";

    private static final String DELETE_COMPANY_METHOD_MESSAGE ="We're at deleteCompany method";

    private static final String SAVE_OPTION_METHOD_MESSAGE = "We're at saveOption method";

    private static final String EXIT_OPTION_METHOD_MESSAGE ="We're at exitOption method";

    private static final Map<Integer, Performer> userInputToPerformerMap = new HashMap<>();

    private static Company selectedCompany;
    private static boolean whileState = true;

    public View() {
        userInputToPerformerMap.put(1, this::createCompanyOption);
        userInputToPerformerMap.put(2, this::getCompanyByIdOption);
        userInputToPerformerMap.put(3, this::addAirplaneToCompanyOption);
        userInputToPerformerMap.put(4, this::deleteAirplaneFromCompanyOption);
        userInputToPerformerMap.put(5, this::printCompanyAirplanesOption);
        userInputToPerformerMap.put(6, this::calculateTotalPayloadOption);
        userInputToPerformerMap.put(7, this::calculateTotalCapacityOption);
        userInputToPerformerMap.put(8, this::findByFuelConsumptionOption);
        userInputToPerformerMap.put(9, this::sortByRangeOption);
        userInputToPerformerMap.put(10, this::deleteCompany);
        userInputToPerformerMap.put(11, this::saveOption);
        userInputToPerformerMap.put(12, this::exitOption);
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
        logger.debug(INPUT_INT_MESSAGE);
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
        logger.debug(INPUT_STRING_MESSAGE);
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
        logger.debug(PRINT_COMPANY_METHOD_MESSAGE);
        Controller.getCompanies()
                .forEach(company1 -> System.out.printf(STRING_COMPANY, company1.getName(), company1.getId()));
    }

    private void printDefaultAirplanes() {
        logger.debug(PRINT_DEFAULT_AIRPLANES_METHOD_MESSAGE);
        Controller.getDefaultAirplanes()
                .forEach(System.out::println);
    }

    private void printCompanyAirplanes() {
        logger.debug(PRINT_COMPANY_AIRPLANES_METHOD_MESSAGE);
        System.out.println(STRING_LIST_OF + selectedCompany.getName() + STRING_AIRPLANES);
        Controller.getCompanyAirplanes(selectedCompany)
                .forEach(System.out::println);
    }

    private void printCompanyCargoAirplanes() {
        logger.debug(PRINT_COMPANY_CARGO_AIRPLANES_METHOD_MESSAGE);
        System.out.println(STRING_LIST_OF + selectedCompany.getName() + STRING_CARGO_AIRPLANES);
        Controller.getCompanyAirplanes(selectedCompany).stream()
                .filter(airplane -> airplane instanceof CargoPlane)
                .forEach(System.out::println);
    }

    private void printCompanyPassengersAirplanes() {
        logger.debug(PRINT_COMPANY_PASSENGERS_AIRPLANES_METHOD_MESSAGE);
        System.out.println(STRING_LIST_OF + selectedCompany.getName() + STRING_PASSENGERS_AIRPLANES);
        Controller.getCompanyAirplanes(selectedCompany).stream()
                .filter(airplane -> airplane instanceof PassengerPlane)
                .forEach(System.out::println);
    }

    public void start(Level logLevel) {
        logger.debug(START_METHOD_MESSAGE);
        Configurator.setRootLevel(logLevel);
        while (whileState) {
            if (selectedCompany != null) {
                System.out.println(STRING_SELECTED_COMPANY + selectedCompany.getName());
            }
            System.out.println(menu);
            userInputToPerformerMap.get(readInt(STRING_SELECT_MENU)).execute();
        }
    }

    private void createCompanyOption() {
        logger.debug(CREATE_COMPANY_OPTION_METHOD_MESSAGE);
        selectedCompany = Controller.createCompany(readString(STRING_ENTER_COMPANY_NAME));
    }

    private void getCompanyByIdOption() {
        logger.debug(GET_COMPANY_BY_ID_METHOD_MESSAGE);
        printCompanies();
        try {
            selectedCompany = Controller.getCompany(readInt(STRING_SELECT_COMPANY_ID));
        } catch (WrongIdException e) {
            logger.error(e);
        }
    }

    private void addAirplaneToCompanyOption() {
        logger.debug(ADD_AIRPLANE_TO_COMPANY_OPTION_METHOD_MESSAGE);
        if (selectedCompany != null) {
            printDefaultAirplanes();
            try {
                Controller.addAirplanesToCompany(selectedCompany, readInt(STRING_SELECT_AIRPLANE_ID));
            } catch (WrongIdException e) {
                logger.error(e);
            }
            printCompanyAirplanes();
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void deleteAirplaneFromCompanyOption() {
        logger.debug(DELETE_AIRPLANE_FROM_COMPANY_OPTION_METHOD_MESSAGE);
        if (selectedCompany != null) {
            printCompanyAirplanes();
            Controller.deleteAirplaneFromCompany(selectedCompany, readInt(STRING_SELECT_AIRPLANE_ID));
            printCompanyAirplanes();
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void printCompanyAirplanesOption() {
        logger.debug(PRINT_COMPAY_AIRPLANES_OPTON_METHOD_MESSAGE);
        if (selectedCompany != null) {
            printCompanyAirplanes();
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void calculateTotalPayloadOption() {
        logger.debug(CALCULATE_TOTAL_PAYLOAD_OPTION_METHOD_MESSAGE);
        if (selectedCompany != null) {
            printCompanyCargoAirplanes();
            System.out.println(STRING_TOTAL_PAYLOAD + Controller.calculatePayload(selectedCompany));
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void calculateTotalCapacityOption() {
        logger.debug(CALCULATE_TOTAL_CAPACITY_OPTION_METHOD_MESSAGE);
        if (selectedCompany != null) {
            printCompanyPassengersAirplanes();
            System.out.println(STRING_TOTAL_CAPACITY + Controller.calculateTotalCapacity(selectedCompany));
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void findByFuelConsumptionOption() {
        logger.debug(FIND_BY_FUEL_CONSUMPTION_OPTION_METHOD_MESSAGE);
        if (selectedCompany != null) {
            System.out.println(STRING_FIND_AIRPLANE_BY_RANGE_OF_FUEL_CONSUMPTION);
            try {
                Controller.findAirplaneByFuelConsumption(selectedCompany, readInt(STRING_ENTER_MIN_FUEL_CONSUMPTION), readInt(STRING_ENTER_MAX_FUEL_CONSUMPTION))
                        .forEach(System.out::println);
            } catch (MinMaxFuelConsumptionExeption e) {
                logger.error(e);
            }
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void sortByRangeOption() {
        logger.debug(SORT_BY_RANGE_OPTION_METHOD_MESSAGE);
        if (selectedCompany != null) {
            System.out.println(STRING_SORTED_BY_RANGE_AIRPLANES);
            Controller.sortAirplaneByRange(selectedCompany).forEach(System.out::println);
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void deleteCompany(){
        logger.debug(DELETE_COMPANY_METHOD_MESSAGE);
        if (selectedCompany != null) {
            Controller.deleteCompany(selectedCompany);
        } else {
            System.out.println(STRING_PLEASE_SELECT_COMPANY);
        }
    }

    private void saveOption() {
        logger.debug(SAVE_OPTION_METHOD_MESSAGE);
        Controller.saveToMemory();
    }

    private void exitOption() {
        logger.debug(EXIT_OPTION_METHOD_MESSAGE);
        whileState = false;
    }
}


