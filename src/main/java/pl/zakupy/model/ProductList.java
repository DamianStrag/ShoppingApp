package pl.zakupy.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate data;

    @OneToMany
    private List<Position> position;

    @Transient
    private int[] array;


    public int[] getTablica() {
        return array;
    }
}
