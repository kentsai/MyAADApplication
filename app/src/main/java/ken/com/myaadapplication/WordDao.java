package ken.com.myaadapplication;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao //這要注意error
public interface WordDao {
    @Query("select * from word")
    List<Word> getAll();

    @Query("select * from word where name = :name")
    Word get(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);

    @Delete
    void delete(Word word);
}
