package like.heocholi.spartaeats.repository;

import like.heocholi.spartaeats.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Optional<List<Menu>> findAllByStoreId(int storeId);
    Optional<Menu> findByStoreIdAndMenuId(int storeId, int menuId);
}
