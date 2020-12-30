package pl.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Sprzet")
@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String brand;
    String model;
    String type;
    String status;
    Long prizeForDay;

    public Long getId() {
        return id;
    }

    public EquipmentEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public EquipmentEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public EquipmentEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getType() {
        return type;
    }

    public EquipmentEntity setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public EquipmentEntity setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getPrizeForDay() {
        return prizeForDay;
    }

    public EquipmentEntity setPrizeForDay(Long prizeForDay) {
        this.prizeForDay = prizeForDay;
        return this;
    }
}
