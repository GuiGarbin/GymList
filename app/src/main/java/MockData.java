package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Models.Workout;
import Models.Exercise;
import Models.Assessment;

public class MockData {

    public static List<Workout> gerarTreinosFalsos() {
        List<Workout> listaDeTreinos = new ArrayList<>();

        // --- TREINO A: PEITO E TRÍCEPS ---
        Workout treinoA = new Workout("Treino A - Peito e Tríceps");

        // Criando os exercícios (Ajuste o construtor conforme seu Model Exercise)
        // Ex: new Exercise(Nome, Series, Repeticoes, Carga)
        treinoA.addExercise(new Exercise("Supino Reto", 4, 10, 60.0));
        treinoA.addExercise(new Exercise("Crucifixo", 3, 12, 14.0));
        treinoA.addExercise(new Exercise("Tríceps Corda", 4, 12, 25.0));

        listaDeTreinos.add(treinoA);

        // --- TREINO B: COSTAS E BÍCEPS ---
        Workout treinoB = new Workout("Treino B - Costas e Bíceps");

        treinoB.addExercise(new Exercise("Puxada Alta", 4, 10, 50.0));
        treinoB.addExercise(new Exercise("Remada Curvada", 3, 10, 40.0));
        treinoB.addExercise(new Exercise("Rosca Direta", 3, 12, 10.0));

        listaDeTreinos.add(treinoB);

        // --- TREINO C: PERNAS ---
        Workout treinoC = new Workout("Treino C - Pernas Completo");

        treinoC.addExercise(new Exercise("Agachamento Livre", 4, 8, 80.0));
        treinoC.addExercise(new Exercise("Leg Press 45", 4, 10, 200.0));
        treinoC.addExercise(new Exercise("Cadeira Extensora", 3, 15, 45.0));

        listaDeTreinos.add(treinoC);

        return listaDeTreinos;
    }

    // Mantém as avaliações como estavam
    public static List<Assessment> gerarAvaliacoesFalsas() {
        List<Assessment> lista = new ArrayList<>();

        // Agora usamos a função auxiliar 'criarData' para converter o texto
        lista.add(new Assessment(criarData("01/01/2026"), 80.5, 18.5));
        lista.add(new Assessment(criarData("15/01/2026"), 81.2, 18.0));
        lista.add(new Assessment(criarData("01/02/2026"), 82.0, 17.5));
        lista.add(new Assessment(criarData("13/02/2026"), 82.5, 17.0));

        return lista;
    }

    // --- HELPER PRIVADO (O CONVERSOR) ---
    // Transforma "dd/MM/yyyy" em um objeto Date real que o Java aceita
    private static Date criarData(String dataTexto) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            return formato.parse(dataTexto);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(); // Se der erro, retorna a data de hoje para não travar o app
        }
    }
}