package repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.model.Project;

import java.util.List;

import dao.ProjectDao;

public class ProjectDataRepository {

    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) { this.projectDao = projectDao; }

    // --- GET ---

    public LiveData<List<Project>> getProjects() { return projectDao.getProjects(); }
}