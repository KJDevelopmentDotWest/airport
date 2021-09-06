package com.epam.jwd.repository.storage;

import com.epam.jwd.repository.fileio.FileInputOutput;
import com.epam.jwd.repository.model.airplane.Airplane;
import com.epam.jwd.repository.model.company.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static final Logger logger = LogManager.getLogger(Repository.class);

    private static final List<Company> companies = new ArrayList<>();

    private static final List<Airplane> defaultAirplanes = new ArrayList<>();
    private static final String DATA_PATH = "src/main/resources/data.txt";
    private static final String DEFAULT_AIRPLANES_PATH = "src/main/resources/defaultairplanes.txt";
    private static final String STRING_SAVE_ALL_TO_MEMORY = "We're in saveAllToMemoryMethod";

    static {
        read();
    }

    private static void read(){
        FileInputOutput.read(DATA_PATH, companies);
        FileInputOutput.read(DEFAULT_AIRPLANES_PATH, defaultAirplanes);
    }

    public static List<Airplane> getDefaultAirplanes(){
        return defaultAirplanes;
    }

    public static List<Company> findAllCompanies(){
        return companies;
    }

    public static void saveAllToMemory(){
        logger.info(STRING_SAVE_ALL_TO_MEMORY);
        FileInputOutput.save(DATA_PATH, companies);
        FileInputOutput.save(DEFAULT_AIRPLANES_PATH, defaultAirplanes);
    }

}
