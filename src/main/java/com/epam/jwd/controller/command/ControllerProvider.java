package com.epam.jwd.controller.command;

import com.epam.jwd.controller.impl.ControllerImpl;

public class ControllerProvider {
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
