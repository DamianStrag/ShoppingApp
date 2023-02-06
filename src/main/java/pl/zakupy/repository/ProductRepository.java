package pl.zakupy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zakupy.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findById(int id);

    Product findByName(String name);



}
