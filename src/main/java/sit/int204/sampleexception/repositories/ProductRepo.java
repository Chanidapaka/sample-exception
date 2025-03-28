package sit.int204.sampleexception.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.sampleexception.entities.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
}
