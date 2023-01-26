package pl.zakupy.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class ListaProduktow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate data;

//    @ManyToOne
   // private Pozycje pozycje;


}
