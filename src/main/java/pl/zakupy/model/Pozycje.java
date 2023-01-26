package pl.zakupy.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity

public class Pozycje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double iloscJednostek;

    private boolean czyZakupiono;

//    @ManyToOne
//    private Produkt produkt;

//    @OneToMany
//    private ListaProduktow listaProduktow;

}
