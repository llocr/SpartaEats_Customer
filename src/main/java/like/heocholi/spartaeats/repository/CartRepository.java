package like.heocholi.spartaeats.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import like.heocholi.spartaeats.entity.Cart;
import like.heocholi.spartaeats.entity.Customer;
import like.heocholi.spartaeats.entity.Menu;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findByCustomer(Customer customer);
	
	Optional<Cart> findByMenuAndCustomer(Menu menu, Customer customer);
}
