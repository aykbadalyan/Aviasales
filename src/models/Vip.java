package models;


public class Vip {
    private String fullName;

    public Vip(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public Vip setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
