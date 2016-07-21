package controller;

import api.FileReader;
import models.Company;
import models.Flight;
import models.Vip;

import java.util.ArrayList;
import java.util.List;


public class CompaniesController {

    private List<Company> companiesList = new ArrayList<>();
    private FileReader fileReader = new FileReader("companies_data.txt");


    public List<Company> init() {
        companiesList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        lines = fileReader.getLines();

        for (int i = 0; i < lines.size(); i++) {

            String[] array = lines.get(i).split(",");
            String companyName = array[0].trim();
            String vipFileName = array[1].trim();
            List<Vip> vipList = new VipController(vipFileName).init();

            Company tempCompany = new Company(companyName, vipList);
            companiesList.add(tempCompany);
        }

        return companiesList;
    }
}
