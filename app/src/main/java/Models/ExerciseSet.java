package Models;

public class ExerciseSet {
    int numberTime;
    double weight;
    int reps;
    boolean done;

    public ExerciseSet(int numberTime, double weight, int reps, boolean done) {
        this.numberTime = numberTime;
        this.weight = weight;
        this.reps = reps;
        this.done = done;
    }
}
