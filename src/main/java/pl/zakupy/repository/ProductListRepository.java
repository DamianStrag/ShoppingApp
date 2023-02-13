package pl.zakupy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zakupy.model.ProductList;
@Repository
public interface ProductListRepository extends CrudRepository<ProductList,Integer> {


}
