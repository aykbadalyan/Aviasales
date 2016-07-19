package com.company;

import controller.CompaniesController;
import gui.Gui;
import models.Company;
import models.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // final
    private static final int ONE_WAY = 1;
    private static final int TWO_WAY = 2;
    private static final int STANDARD = 1;
    private static final int VIP = 2;

    private static Scanner scanner = new Scanner(System.in);
    private static List<Company> companiesList;

    public static void main(String[] args) {

        Gui gui = new Gui();

        System.out.print("Type the location abbreviation of flight's start: ");
        String dep = scanner.next();
        System.out.println();

        System.out.print("Type the location abbreviation of flight's start: ");
        String arr = scanner.next();
        System.out.println();

        System.out.print("Enter '1' for a standard ticket and '2' for a VIP one: ");

        int ticketClass = scanner.nextInt();
//        try {
//        } catch (NumberFormatException e) {
//            System.out.println("The inputted text does not match any available options.");
//        }

        System.out.print("Enter '1' for a One-Way ticket and '2' for a Two-Way one: ");

        int typeOfTicket = scanner.nextInt();
//        try {
//        } catch (NumberFormatException e) {
//            System.out.println("The inputted text does not match any available options.");
//        }

        if (ticketClass == STANDARD) {
            if (typeOfTicket == ONE_WAY) {

            } else {

            }
        } else {
            if (typeOfTicket == ONE_WAY) {

            } else {

            }
        }

        System.out.println();

        companiesList = new CompaniesController().init();

        for (int i = 0; i < companiesList.size(); i++) {

            List<Flight> selectedTicketTypeList = new ArrayList<>();
            if (typeOfTicket == ONE_WAY) {

                selectedTicketTypeList = companiesList.get(i).getOneWayFlightList();
            } else {

                selectedTicketTypeList = companiesList.get(i).getReturnFlightsList();
            }
            for (int j = 0; j < selectedTicketTypeList.size(); j++) {

                Flight localFlight = selectedTicketTypeList.get(j);

                if (localFlight.getDep().equals(dep) && localFlight.getArr().equals(arr)) {

                    System.out.println("localFlight: " + localFlight.getDep() + "  Company name: " + companiesList.get(i).getName() +
                            " Price: " + localFlight.getCost());
                }
            }
        }
    }
}
