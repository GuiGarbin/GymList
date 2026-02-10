package Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Workout implements Serializable {

    private String name;
    private List<Exercise> exercisesList;
    Date dateFinished;

    public Workout(String name, List<Exercise> exercisesList, String weekDay) {
        this.name = name;
        this.exercisesList = exercisesList;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public String getName() {
        return name;
    }
}
