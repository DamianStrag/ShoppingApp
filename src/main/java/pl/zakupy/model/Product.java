package pl.zakupy.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String unit;

    private double quantity;

    private double price;

    private String link;

    @OneToMany
    private List<Position> positionList;

    public Product(int id, String name, String unit, double ilosc, double price, String link){
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.quantity = ilosc;
        this.price = price;
        this.link = link;
    }
}
