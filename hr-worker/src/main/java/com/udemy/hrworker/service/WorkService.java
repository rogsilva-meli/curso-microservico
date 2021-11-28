package com.udemy.hrworker.service;

import com.udemy.hrworker.entity.Worker;
import com.udemy.hrworker.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    private WorkerRepository workerRepository;

    public WorkService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> list() {
        return workerRepository.findAll();
    }

    public Worker getById(Long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new NullPointerException("Worker " + id + " not found"));
        return worker;
    }

    public Worker create(Worker worker) {
        return workerRepository.save(worker);
    }

    public void delete(Long id) {
        Worker worker = getById(id);
        workerRepository.delete(worker);
    }
}
