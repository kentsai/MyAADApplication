package ken.com.myaadapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//class WordAdapter extends RecyclerView.Adapter {
public class WordAdapter extends RecyclerView.Adapter<WordViewHolder>{
    public WordAdapter(List<Word> words) {
        this.words = words;
    }
    List<Word> words;

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  WordViewHolder holder, int position) {
        Word word = words.get(position);
        if (word != null){
            holder.setWord(word);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
