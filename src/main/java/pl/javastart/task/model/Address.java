package pl.javastart.task.model;

public class Address {
    private String street;
    private String homeNo;
    private String zipCode;
    private String city;

    public Address(String street, String homeNo, String zipCode, String city) {
        this.street = street;
        this.homeNo = homeNo;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(String homeNo) {
        this.homeNo = homeNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String info() {
        return street + " " + homeNo + ", " + zipCode + " " + city;
    }
}
