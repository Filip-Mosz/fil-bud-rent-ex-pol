package pl.rental.dtos;

public class EquipmentDto {
    Long id;
    String brand;
    String model;
    String type;
    String status;
    Long prizeForDay;

    public EquipmentDto() {
    }

    public EquipmentDto(String brand, String model, String type, String status, Long prizeForDay) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.status = status;
        this.prizeForDay = prizeForDay;
    }

    public Long getId() {
        return id;
    }

    public EquipmentDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public EquipmentDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public EquipmentDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getType() {
        return type;
    }

    public EquipmentDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public EquipmentDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getPrizeForDay() {
        return prizeForDay;
    }

    public EquipmentDto setPrizeForDay(Long prizeForDay) {
        this.prizeForDay = prizeForDay;
        return this;
    }
}
