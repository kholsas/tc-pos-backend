package za.co.tech.code.pointofsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tech.code.pointofsale.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {}