package models;


public class Flight {

    private static int numberOfFreePlaces;
    private String flightCode;
    private String dep;
    private String arr;
    private String depTime;
    private String arrTime;
    private String cost;

    public Flight(String flightCode, String dep, String arr, String depTime, String arrTime, String cost) {
        this.flightCode = flightCode;
        this.dep = dep;
        this.arr = arr;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.cost = cost;
    }

    public static int getNumberOfFreePlaces() {
        return numberOfFreePlaces;
    }

    public static void setNumberOfFreePlaces(int numberOfFreePlaces) {
        Flight.numberOfFreePlaces = numberOfFreePlaces;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
