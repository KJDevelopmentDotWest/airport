package com.epam.jwd.controller.command;

import com.epam.jwd.controller.impl.ControllerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControllerProvider {
    private static final Logger logger = LogManager.getLogger(ControllerProvider.class);

    private static final ControllerProvider instance = new ControllerProvider();

    Controller controller = new ControllerImpl();

    private ControllerProvider(){
    }

    public static ControllerProvider getInstance() {
        return instance;
    }

    public Controller getController(){
        return controller;
    }

}
