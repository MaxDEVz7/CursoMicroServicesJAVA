package com.max.AprendendoMicroServicesEspring.resources;

import com.max.AprendendoMicroServicesEspring.entities.Worker;
import com.max.AprendendoMicroServicesEspring.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResources {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping()
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workers = workerRepository.findAll();
        return ResponseEntity.ok().body(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = workerRepository.findById(id).get();
        return ResponseEntity.ok().body(worker);
    }
}
