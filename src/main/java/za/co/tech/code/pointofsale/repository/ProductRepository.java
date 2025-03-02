package za.co.tech.code.pointofsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tech.code.pointofsale.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {}