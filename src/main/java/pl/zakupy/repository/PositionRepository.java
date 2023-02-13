package pl.zakupy.repository;

import org.springframework.data.repository.CrudRepository;
import pl.zakupy.model.Position;

public interface PositionRepository extends CrudRepository<Position,Integer> {

    public Boolean existsByProductIdAndProductListId(int productId, int productListId);


}
