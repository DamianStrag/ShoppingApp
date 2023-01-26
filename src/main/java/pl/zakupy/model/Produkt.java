package pl.zakupy.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nazwa;

    private String jednostka;

    private double ilosc;

    private double cena;

    private String link;

//    @OneToMany
    //private List<Pozycje> listaPozycji;

    public Produkt(int id, String nazwa, String jednostka, double ilosc,double cena, String link){
        this.id = id;
        this.nazwa = nazwa;
        this.jednostka = jednostka;
        this.ilosc = ilosc;
        this.cena = cena;
        this.link = link;
       // this.listaPozycji = new ArrayList<>();
    }
}
