package Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dataCenter.Converters;

@Entity(tableName = "workout_table")
public class Workout implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @TypeConverters(Converters.class)
    private List<Exercise> exercisesList;
    Date dateFinished;

    public Workout(String name) {
        this.name = name;
    }

    public void addExercise(Exercise exercise) {
        this.exercisesList.add(exercise);
    }

    // Getter
    public List<Exercise> getExercises() {
        return exercisesList;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExercisesList(List<Exercise> exercisesList) {
        this.exercisesList = exercisesList;
    }
}
