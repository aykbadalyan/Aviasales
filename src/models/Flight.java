package models;


public class Flight {

    private String flightNumber;
    private String dep;
    private String arr;
    private String depTime;
    private String arrTime;
    private String companyName;
    private float cost;


    public Flight(String flightNumber, String dep, String arr, String depTime, String arrTime, String companyName, float cost) {
        this.flightNumber = flightNumber;
        this.dep = dep;
        this.arr = arr;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.companyName = companyName;
        this.cost = cost;
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

    public String getCompanyName() {
        return companyName;
    }

    public Flight setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return " " + flightNumber + " | " + dep + " | " + arr + " | " + depTime + " | " + arrTime + " | " + companyName + " | " + cost;
    }
}
