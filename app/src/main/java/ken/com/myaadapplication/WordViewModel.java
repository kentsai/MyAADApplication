package ken.com.myaadapplication;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Objects;
public class WordViewModel extends AndroidViewModel{

    private LiveData<List<Word>> wordsLiveData;
    private WordDao dao;

    public WordViewModel(@NonNull Application application) {
        super(application);
        dao = WordDatabase.getInstance(application.getApplicationContext())
                .wordDao();
//        wordsLiveData = dao.getAll();
    }
    //    private WordDao dao = WordDatabase.getInstance().wordDao()
    public LiveData<List<Word>> getWords() {
        return wordsLiveData;
    }
}
