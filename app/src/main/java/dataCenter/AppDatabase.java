package dataCenter;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import Models.Assessment;
import Models.MacroCycle;
import Models.Workout;

@Database(entities = {Workout.class, Assessment.class, MacroCycle.class}, version = 3, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract WorkoutDao workoutDao();
    public abstract AssessmentDao assessmentDao();
    public abstract MacroCycleDao macroCycleDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            // Se não existe, cria o banco
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "gym_list_database") // Nome do arquivo
                            .allowMainThreadQueries() // PERMISSÃO TEMPORÁRIA (Para facilitar agora)
                            .fallbackToDestructiveMigration() // Se mudar o banco, apaga e recria (útil em dev)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}