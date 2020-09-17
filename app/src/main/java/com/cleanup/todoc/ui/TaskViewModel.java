package com.cleanup.todoc.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;
import java.util.concurrent.Executor;

import repositories.ProjectDataRepository;
import repositories.TaskDataRepository;

public class TaskViewModel extends ViewModel {

    // REPOSITORIES
    private final ProjectDataRepository projectDataSource;
    private final TaskDataRepository taskDataSource;
    private final Executor executor;

    // DATA
    @Nullable
    private LiveData<List<Project>> currentProject;

    public TaskViewModel(ProjectDataRepository projectDataSource, TaskDataRepository taskDataSource, Executor executor) {
        this.projectDataSource = projectDataSource;
        this.taskDataSource = taskDataSource;
        this.executor = executor;
    }

    public void init(long projectId) {
        if (currentProject == null)
            currentProject = projectDataSource.getProjects();
    }

    // FOR PROJECT

    @Nullable
    public LiveData<List<Project>> getProjects() { return currentProject; }

    // FOR TASK

    public LiveData<List<Task>> getTasks(long projectId) { return taskDataSource.getTasks(projectId); }

    public void createTask(Task task) { executor.execute(() -> taskDataSource.createTask(task)); }

    public void deleteTask(Task task) { executor.execute(() -> taskDataSource.deleteTask(task)); }
}