package dataCenter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Models.Assessment;
import Models.Workout;

@Dao
public interface AssessmentDao {
    @Insert
    void insert(Assessment assessment);

    @Update
    void update(Assessment assessment);

    @Delete
    void delete(Assessment assessment);

    @Query("SELECT * FROM assessment_table")
    List<Assessment> getAll();

    @Query("DELETE FROM assessment_table")
    void deleteAll();
}
