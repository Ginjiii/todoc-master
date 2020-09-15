package dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

@Dao
public interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProject(Project project);

    @Query("SELECT * FROM Project;")
    LiveData<List<Project>> getAllProjects();

    @Query("SELECT * FROM Project WHERE id= :id;")
    LiveData<Project> getProject(long id);

    @Query("SELECT * FROM Project WHERE id= :id;")
    Project getProjectById(long id);
}
