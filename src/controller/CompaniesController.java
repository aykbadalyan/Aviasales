package controller;

import api.FileReader;
import models.Company;
import models.Flight;
import models.Vip;

import java.util.ArrayList;
import java.util.List;


public class CompaniesController {

    private List<Company> companiesList;
    private FileReader fileReader = new FileReader("companies_input_data");


    public List<Company> init() {

        List<String> lines = new ArrayList<>();
        lines = fileReader.getLines();

        for (int i = 0; i < lines.size(); i++) {

            String[] array = lines.get(i).split("|");
            String companyName = array[0];
            String oneWayFileName = array[1].trim();
            String returnFileName = array[2].trim();
            String vipFileName = array[3].trim();


            List<Flight> oneWayFlightList = new ArrayList<>();
            List<Flight> returnFlightsList = new ArrayList<>();

            List<Vip> vipList = new VipController(vipFileName).init();

            Company tempCompany = new Company(companyName, oneWayFlightList, returnFlightsList, vipList);
            companiesList.add(tempCompany);
        }

        return null;
    }
}