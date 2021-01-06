package pl.rental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Wypozyczalnia")
@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String website;
    private String address;

    @OneToOne( fetch = FetchType.LAZY)
//    @JoinColumn(name = "Ceo")
    private EmployeeEntity ceo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<EmployeeEntity> employees = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public RentalEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public RentalEntity setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public RentalEntity setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RentalEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeEntity getCeo() {
        return ceo;
    }

    public RentalEntity setCeo(EmployeeEntity ceo) {
        this.ceo = ceo;
        return this;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public RentalEntity setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
        return this;
    }
}
