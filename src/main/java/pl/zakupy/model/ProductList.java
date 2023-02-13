package pl.zakupy.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @OneToMany(cascade = CascadeType.REMOVE)
    @Fetch( FetchMode.JOIN)
    private List<Position> position;

    @Transient
    private int[] array;


    public int[] getTablica() {
        return array;
    }
}
