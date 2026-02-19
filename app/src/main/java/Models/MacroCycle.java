package Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "macro_cycle_table")
public class MacroCycle implements Serializable {
    @PrimaryKey (autoGenerate = true)
    private int id;
    private String name;
    private int timesCycle;
    private boolean isActive;
    private long startDate;
    private String objective;
    private List<Integer> workoutsIds;

    public MacroCycle(String name, String objective, List<Integer> workoutsIds) {
        this.name = name;
        this.objective = objective;
        this.workoutsIds = workoutsIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimesCycle() {
        return timesCycle;
    }

    public void setTimesCycle(int timesCycle) {
        this.timesCycle = timesCycle;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<Integer> getWorkoutsIds() {
        return workoutsIds;
    }

    public void setWorkoutsIds(List<Integer> workoutsIds) {
        this.workoutsIds = workoutsIds;
    }
}


