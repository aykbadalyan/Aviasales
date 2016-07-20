package models;


public class Flight {

    private static int numberOfFreePlaces;
    private String flightNumber;
    private String dep;
    private String arr;
    private String depTime;
    private String arrTime;
    private String cost;
    private float ticketCount;

    public Flight(String flightNumber, String dep, String arr, String depTime, String arrTime, String cost, float ticketCount) {
        this.flightNumber = flightNumber;
        this.dep = dep;
        this.arr = arr;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.cost = cost;
        this.ticketCount = ticketCount;
    }

    public static int getNumberOfFreePlaces() {
        return numberOfFreePlaces;
    }

    public static void setNumberOfFreePlaces(int numberOfFreePlaces) {
        Flight.numberOfFreePlaces = numberOfFreePlaces;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public float getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(float ticketCount) {
        this.ticketCount = ticketCount;
    }
}
