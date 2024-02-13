package me.jodfedlet.thewine.modules.product.repository;

import me.jodfedlet.thewine.modules.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
