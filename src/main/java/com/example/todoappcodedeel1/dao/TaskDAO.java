package com.example.todoappcodedeel1.dao;

import com.example.todoappcodedeel1.dto.TaskDTO;
import com.example.todoappcodedeel1.models.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDAO {

    private TaskRepository repository;

    public TaskDAO(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks(){
        return this.repository.findAll();
    }

    public void createTask(TaskDTO taskDTO){
        Task task = new Task(taskDTO.name, taskDTO.description);
        this.repository.save(task);
    }

    public void updateTask(TaskDTO taskDTO, Long id){
        Optional<Task> task = this.repository.findById(id);

        if (task.isPresent()){
            task.get().setDescription(taskDTO.description);
            task.get().setName(taskDTO.name);

            this.repository.save(task.get());
        }
    }

    public void checkTask(Long id) {
        this.toggleTask(id, true);
    }

    public void uncheckTask(Long id) {
        this.toggleTask(id, false);
    }

    private void toggleTask(Long id, boolean value){
        Optional<Task> task = this.repository.findById(id);

        if (task.isPresent()){
            task.get().setFinished(value);
            this.repository.save(task.get());
        }
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
