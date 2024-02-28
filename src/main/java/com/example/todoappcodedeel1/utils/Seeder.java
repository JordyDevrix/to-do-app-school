package com.example.todoappcodedeel1.utils;

import com.example.todoappcodedeel1.dao.TaskRepository;
import com.example.todoappcodedeel1.models.Task;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {

    private TaskRepository taskRepository;

    public Seeder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event){
        this.seedTasks();
    }

    private void seedTasks(){
        this.taskRepository.save(new Task("Angular video's kijken", "Week 1 en week 2 video's van angular kijken"));
        this.taskRepository.save(new Task("Angular opdrachten maken", "Week 1 en week 2 opdrachten van angular maken"));
    }
}
