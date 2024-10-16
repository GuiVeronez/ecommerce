package br.com.senai.ecommerce.controller;

import br.com.senai.ecommerce.entities.Tarefa;
import br.com.senai.ecommerce.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/tarefa")
    public class TarefaController {
        @Autowired
        private TarefaRepository tarefaRepository;

        @PostMapping
        public Tarefa createTarefa(@RequestBody Tarefa tarefa) {
            return tarefaRepository.save(tarefa);
        }


        @GetMapping
        public List<Tarefa> getAlltarefas() {
            return tarefaRepository.findAll();
        }


        @GetMapping("/{id}")
        public Tarefa gettarefaById(@PathVariable Long id) {
            return tarefaRepository.findById(id).orElse(null);
        }


        @DeleteMapping("/{id}")
        public void deletetarefa(@PathVariable Long id) {
            tarefaRepository.deleteById(id);
        }

        @PutMapping("/{id}")
        public Tarefa updateTarefa(@PathVariable Long id,
                               @RequestBody Tarefa tarefa) {
            Tarefa updateTarefa = tarefaRepository.findById(id).orElse(null);
            if (updateTarefa != null) {
                updateTarefa.setTitulo(tarefa.getTitulo());
                updateTarefa.setDescricao(tarefa.getDescricao());
                return tarefaRepository.save(tarefa);
            }
            return null;
        }
    }
