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
    private final ProjectDataRepository mProjectDataSource;
    private final TaskDataRepository mTaskDataSource;
    private final Executor mExecutor;

    // DATA
    @Nullable
    private LiveData<List<Project>> mProjects;

    public TaskViewModel(ProjectDataRepository projectDataSource, TaskDataRepository taskDataSource, Executor executor) {
        mProjectDataSource = projectDataSource;
        mTaskDataSource = taskDataSource;
        mExecutor = executor;
    }

    public void init() {
        if (mProjects == null)
            mProjects = mProjectDataSource.getProjects();
    }

    // FOR PROJECT

    @Nullable
    public LiveData<List<Project>> getProjects() { return mProjects; }

    // FOR TASK

    public LiveData<List<Task>> getTasks() { return mTaskDataSource.getTasks(); }

    public void createTask(Task task) { mExecutor.execute(() -> mTaskDataSource.createTask(task)); }

    public void deleteTask(Task task) { mExecutor.execute(() -> mTaskDataSource.deleteTask(task)); }
}