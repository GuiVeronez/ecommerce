package br.com.senai.ecommerce.controller;

import br.com.senai.ecommerce.entities.Product;
import br.com.senai.ecommerce.entities.User;
import br.com.senai.ecommerce.repository.ProductRepository;
import br.com.senai.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //suporta apenas dados
@RequestMapping("/product") // localhost:8080/product
public class ProductController {

    //injeção de dependência, criar um objeto
    @Autowired
    private ProductRepository productRepository;

    //metodo para criar um produtp
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    // listar todos os produtos do banco de dados
    @GetMapping
    public List<Product> getAllProducts(){
        // SELECT * FROM user
        return productRepository.findAll();
    }
    //pegar um produto pelo seu id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }
    // deleta um produto pelo seu id
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }
    //atualiza informações do produto pelo seu id
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                           @RequestBody Product product){
        Product usuario = productRepository.findById(id).orElse(null);
        if(product != null){
            usuario.setName(product.getName());
            usuario.setPrice(product.getPrice());
            usuario.setBrand(product.getBrand());
            return productRepository.save(product);
        }
        return null;
    }
}
