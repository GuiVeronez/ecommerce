package br.com.senai.ecommerce.repository;

import br.com.senai.ecommerce.entities.Product;
import br.com.senai.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}