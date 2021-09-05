package com.epam.jwd.repository.storage;

import com.epam.jwd.repository.exception.RepositoryException;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.airplane.CargoPlane;
import com.epam.jwd.repository.model.airplane.PassengerPlane;
import com.epam.jwd.repository.model.company.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    private static final Logger logger = LogManager.getLogger(Repository.class);

    private static final List<Company> companies = new ArrayList<>();

    private static final List<Airplane> defaultAirplanes = new ArrayList<>();

    private static final String STRING_FILE_NOT_FOUND_EXCEPTION = "FileNotFoundException happened";

    private static final String STRING_IO_EXCEPTION = "IOException happened";

    private static final String PATH = "src/main/resources/data.txt";

    private static final String STRING_SAVE_ALL_TO_MEMORY = "We're in saveAllToMemoryMethod";

    static {
        companies.add(new Company(
                "CompanyOne",
                Arrays.asList(
                        new PassengerPlane.Builder()
                                .withFuelConsumption(10)
                                .withManufacturer("Boeing")
                                .withModel("777")
                                .withRange(1000)
                                .withSeats(400)
                                .withId(1)
                                .build(),
                        new PassengerPlane.Builder()
                                .withFuelConsumption(12)
                                .withManufacturer("Boeing")
                                .withModel("787")
                                .withRange(1200)
                                .withSeats(500)
                                .withId(2)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(20)
                                .withManufacturer("Boeing")
                                .withModel("767")
                                .withRange(1900)
                                .withPayload(4000)
                                .withId(3)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(40)
                                .withManufacturer("Airbus")
                                .withModel("A300")
                                .withRange(4000)
                                .withPayload(8000)
                                .withId(4)
                                .build()
                )
        ));
        companies.add(new Company(
                "CompanyTwo",
                Arrays.asList(
                        new PassengerPlane.Builder()
                                .withFuelConsumption(10)
                                .withManufacturer("Boeing")
                                .withModel("777")
                                .withRange(1000)
                                .withSeats(400)
                                .withId(1)
                                .build(),
                        new PassengerPlane.Builder()
                                .withFuelConsumption(12)
                                .withManufacturer("Boeing")
                                .withModel("787")
                                .withRange(1200)
                                .withSeats(500)
                                .withId(2)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(20)
                                .withManufacturer("Boeing")
                                .withModel("767")
                                .withRange(1900)
                                .withPayload(4000)
                                .withId(3)
                                .build(),
                        new CargoPlane.Builder()
                                .withFuelConsumption(40)
                                .withManufacturer("Airbus")
                                .withModel("A300")
                                .withRange(4000)
                                .withPayload(8000)
                                .withId(4)
                                .build()
                )
        ));
    }

//    static {
//        try {
//            FileInputStream fis = new FileInputStream("src/main/resources/data.txt");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            Object object = ois.readObject();
//            if (object instanceof List){
//                companies.addAll((List<Company>) object);
//            }
//        } catch (FileNotFoundException e) {
//            logger.error("FileNotFoundException happened", e);
//        } catch (IOException e) {
//            logger.error("IOException happened", e);
//        } catch (ClassNotFoundException e) {
//            logger.error("ClassNotFoundException happened", e);
//        }
//    }

    public static List<Airplane> getDefaultAirplanes(){
        return defaultAirplanes;
    }

    public static List<Company> findAllCompanies(){
        return companies;
    }

    public static void saveAllToMemory(){
        logger.info(STRING_SAVE_ALL_TO_MEMORY);
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(companies);
        } catch (FileNotFoundException e) {
            logger.error(STRING_FILE_NOT_FOUND_EXCEPTION, e);
            throw new RepositoryException(STRING_FILE_NOT_FOUND_EXCEPTION);
        } catch (IOException e) {
            logger.error(STRING_IO_EXCEPTION, e);
            throw new RepositoryException(STRING_IO_EXCEPTION);
        }
    }
}
