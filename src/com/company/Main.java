package com.company;

import controller.CompaniesController;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Type the location abbreviation of flight's start:");
        String dep = scanner.next();

        System.out.println("Type the location abbreviation of flight's start:");
        String arr = scanner.next();

        new CompaniesController().init();


    }
}
