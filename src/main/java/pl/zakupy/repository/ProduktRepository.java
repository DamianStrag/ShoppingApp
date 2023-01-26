package pl.zakupy.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zakupy.model.Produkt;
@Repository
public interface ProduktRepository extends CrudRepository<Produkt, Integer> {

    Produkt findById(int id);

    Produkt findByNazwa(String name);



}
