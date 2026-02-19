package dataCenter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Models.MacroCycle;

@Dao
public interface MacroCycleDao {
    @Insert
    void insert(MacroCycle cycle);

    @Update
    void update(MacroCycle cycle);

    @Delete
    void delete(MacroCycle cycle);

    @Query("SELECT * FROM macro_cycle_table") // Certifique-se que o nome é o mesmo da sua @Entity
    List<MacroCycle> getAll();
}
