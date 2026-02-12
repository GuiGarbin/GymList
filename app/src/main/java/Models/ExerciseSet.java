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


    public void setDone(boolean done) {
        this.done = done;
    }

    public int getNumberTime() {
        return numberTime;
    }

    public double getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    public boolean isDone() {
        return done;
    }
}
