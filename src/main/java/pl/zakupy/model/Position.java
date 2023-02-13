package pl.zakupy.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
   @Fetch( FetchMode.JOIN)
   private Product product;

    @ManyToOne
    @Fetch( FetchMode.JOIN)
    private ProductList productList;

}
