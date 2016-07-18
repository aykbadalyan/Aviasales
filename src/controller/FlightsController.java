package controller;

import api.FileReader;
import models.Flight;
import models.Vip;

import java.util.ArrayList;
import java.util.List;


public class FlightsController {

    private FileReader fileReader;
    private List<Flight> flightList = new ArrayList<>();

    public FlightsController(String fileName) {
        fileReader = new FileReader(fileName);
    }

    public List<Flight> init() {

        List<String> lines = new ArrayList<>();
        lines = this.fileReader.getLines();

        for (int i = 0; i < lines.size(); i++) {
//            002W | AAA | AAB | 12.07.2016 12:15 | 15.07.2016 12:15 | 123.43

            String [] array = lines.get(i).split(",");

            String flightNumber = array[0];
            String dep = array[1].trim();
            String arr = array[2].trim();
            String depTime = array[3].trim();
            String arrTime = array[4].trim();
            String cost = array[5].trim();
            Flight flightTemp = new Flight(flightNumber, dep, arr, depTime, arrTime, cost);
            flightList.add(flightTemp);
        }

        return flightList;
    }
}
