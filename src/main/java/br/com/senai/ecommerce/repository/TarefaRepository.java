package br.com.senai.ecommerce.repository;

import br.com.senai.ecommerce.entities.Product;
import br.com.senai.ecommerce.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
