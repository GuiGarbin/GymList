package Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class WorkoutLog implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int workoutId;
    private int macroCycleId;
    private long dateCompleted;
}
