package controller;

import api.FileReader;
import models.Flight;

import java.util.ArrayList;
import java.util.List;


public class FlightsController {

    private FileReader fileReader;
    private List<Flight> flightList = new ArrayList<>();

    public FlightsController(String fileName) {
        fileReader = new FileReader(fileName);
    }

    public List<Flight> init() {

        flightList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        lines = this.fileReader.getLines();

        for (int i = 0; i < lines.size(); i++) {

            String[] array = lines.get(i).split(",");

            String flightNumber = array[0].trim();
            String dep = array[1].trim();
            String arr = array[2].trim();
            String depTime = array[3].trim();
            String arrTime = array[4].trim();
            String companyName = array[5].trim();
            float cost = Float.parseFloat(array[6].trim());

            Flight flightTemp = new Flight(flightNumber, dep, arr, depTime, arrTime, companyName, cost);
            flightList.add(flightTemp);
        }

        return flightList;
    }

    public List<Flight> getListByParams(String dep, String arr) {

        List<Flight> localFlight = new ArrayList<>();
        for (int i = 0; i < flightList.size(); i++) {
            Flight currentFlight = flightList.get(i);

            if (currentFlight.getDep().equals(dep) && currentFlight.getArr().equals(arr)) {

                localFlight.add(currentFlight);
            }
        }
        return localFlight;
    }
}
