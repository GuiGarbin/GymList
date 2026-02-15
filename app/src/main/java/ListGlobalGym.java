import java.util.ArrayList;
import java.util.List;
import Models.Workout;

public class ListGlobalGym {

    private static List<Workout> myWorkouts = new ArrayList<>();

    // Bloco que roda 1 vez só pra não começar vazio (Opcional)
    static {
        myWorkouts.add(new Workout("Treino Exemplo A"));
    }

    public static void addWorkout(Workout treino) {
        myWorkouts.add(treino);
    }

    public static List<Workout> getWorkout() {
        return myWorkouts;
    }
}
