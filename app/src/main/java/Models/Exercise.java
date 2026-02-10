package Models;

import java.io.Serializable;

public class Exercise implements Serializable {
    String name;
    int timeExecuted;
    int reps;
    double weight;

    public Exercise(String name, int timeExecuted, int reps, double weight) {
        this.name = name;
        this.timeExecuted = timeExecuted;
        this.reps = reps;
        this.weight = weight;
    }
}
