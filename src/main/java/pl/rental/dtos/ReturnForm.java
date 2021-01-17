package pl.rental.dtos;

public class ReturnForm {
    public ReturnForm(String name, String surname, Long rentId) {
        this.name = name;
        this.surname = surname;
        this.rentId = rentId;
    }

    public ReturnForm() {
    }

    private String name;
    private String surname;
    private Long rentId;


    public String getName() {
        return name;
    }

    public ReturnForm setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ReturnForm setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Long getRentId() {
        return rentId;
    }

    public ReturnForm setRentId(Long rentId) {
        this.rentId = rentId;
        return this;
    }
}