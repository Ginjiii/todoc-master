package repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.model.Task;

import java.util.List;

import dao.TaskDao;

public class TaskDataRepository {
    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDao) { this.taskDao = taskDao; }

    // --- GET ---

    public LiveData<List<Task>> getTasks() { return this.taskDao.getTasks(); }

    // --- CREATE ---

    public void createTask(Task task) { taskDao.insertTask(task); }

    // --- DELETE ---

    public void deleteTask(Task task) { taskDao.deleteTask(task); }
}