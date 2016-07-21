package models;

import java.util.ArrayList;
import java.util.List;


public class Company {

    private String name;
//    private List<Flight> oneWayFlightList = new ArrayList<>();
//    private List<Flight> returnFlightsList = new ArrayList<>();
    private List<Vip> vipsList = new ArrayList<>();

    public Company(String name, List<Vip> vipsList) {
        this.name = name;
//        this.oneWayFlightList = oneWayFlightList;
//        this.returnFlightsList = returnFlightsList;
        this.vipsList = vipsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Flight> getOneWayFlightList() {
//        return oneWayFlightList;
//    }
//
//    public void setOneWayFlightList(List<Flight> oneWayFlightList) {
//        this.oneWayFlightList = oneWayFlightList;
//    }
//
//    public List<Flight> getReturnFlightsList() {
//        return returnFlightsList;
//    }
//
//    public void setReturnFlightsList(List<Flight> returnFlightsList) {
//        this.returnFlightsList = returnFlightsList;
//    }

    public List<Vip> getVipsList() {
        return vipsList;
    }

    public void setVipsList(List<Vip> vipsList) {
        this.vipsList = vipsList;
    }
}
