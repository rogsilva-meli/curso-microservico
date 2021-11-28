package com.udemy.hrworker.controller;

import com.udemy.hrworker.entity.Worker;
import com.udemy.hrworker.repository.WorkerRepository;
import com.udemy.hrworker.service.WorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkController {

    private WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping
    private ResponseEntity<List<Worker>> listWorker() {
        List<Worker> list = workService.list();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Worker> getWorker(@PathVariable Long id) {
        Worker worker = workService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(worker);
    }

    @PostMapping
    private ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
        Worker workerCreated = workService.create(worker);
        return ResponseEntity.status(HttpStatus.CREATED).body(workerCreated);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteWorker(@PathVariable Long id) {
        workService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Worker " + id + " was deleted.");
    }


}
