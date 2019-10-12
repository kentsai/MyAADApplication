package ken.com.myaadapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
    private static volatile WordDatabase instance = null;

    public static WordDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    WordDatabase.class,
                    "word-database")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                        }
                    })
                    .build();
            fillDataFromJsonFile(instance.wordDao(), context);
        }
        return instance;
    }

    private static void fillDataFromJsonFile(WordDao wordDao, Context context) {
        InputStream is = context.getResources()
                .openRawResource(R.raw.vocabulary);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is)       );
        String Line =null;
        StringBuilder builder = new StringBuilder();
        while(true){
            try {
                while (!((Line = reader.readLine())!= null)){
                    builder.append(Line);
                }
                JSONObject json = new JSONObject(builder.toString());
                JSONArray words = json.getJSONArray("words");
                for(int i =0; i<words.length(); i++){
                    JSONObject word = words.getJSONObject(i);

//                    wordDao.insert(new Word(word.getString("word"),
//                            word.getString("means"),
//                            word.getInt("star") == 0 ? false :true));
                    Word w = new Word(word.getString("word"),
                            word.getString("means"),
                            word.getInt("star") == 0 ? false : true);
                    wordDao.insert(w);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
