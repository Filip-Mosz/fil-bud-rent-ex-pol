package pl.rental.dtos;

public class EmployeeDto {
    String name;
    String surname;
    String position;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public EmployeeDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public EmployeeDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public EmployeeDto setPosition(String position) {
        this.position = position;
        return this;
    }

}
