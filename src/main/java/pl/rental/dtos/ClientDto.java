package pl.rental.dtos;

public class ClientDto {

    private String name;
    private String surname;
    private String email;
    private String address;
    private String company; //may be null

    public ClientDto() {
    }

    public ClientDto(String name, String surname, String email, String address, String company) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.company = company;
    }

    public ClientDto(String name, String surname, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public ClientDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ClientDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ClientDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ClientDto setCompany(String company) {
        this.company = company;
        return this;
    }
}
