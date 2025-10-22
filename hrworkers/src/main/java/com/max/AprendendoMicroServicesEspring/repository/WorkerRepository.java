package com.max.AprendendoMicroServicesEspring.repository;

import com.max.AprendendoMicroServicesEspring.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
