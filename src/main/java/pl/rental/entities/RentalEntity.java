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

    String companyName;
    String website;
    String address;

    @OneToOne( fetch = FetchType.LAZY)
    private EmployeeEntity ceo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<EmployeeEntity> employees = new ArrayList<>();

}
