package pl.zakupy.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double numberOfUnits;

    private boolean whetherBought;

   @ManyToOne
    private Product product;

    @ManyToOne
    private ProductList productList;

}
