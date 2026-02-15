package dataCenter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import Models.Workout;

@Dao
public interface WorkoutDao {

    @Insert
    void insert(Workout workout);

    @Update
    void update(Workout workout);

    @Delete
    void delete(Workout workout);

    @Query("SELECT * FROM workout_table")
    List<Workout> getAll();

    @Query("DELETE FROM workout_table")
    void deleteAll();
}