package ken.com.myaadapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
class Word {
    @PrimaryKey
//    @ColumnInfo(name = "word")
    @NonNull
    String name;
    @Nullable
    String means;
    @NonNull
    Boolean star;

    public Word(@NonNull String name, @Nullable String means, @NonNull Boolean star) {
        this.name = name;
        this.means = means;
        this.star = star;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Nullable
    public String getMeans() {
        return means;
    }

    public void setMeans(@Nullable String means) {
        this.means = means;
    }

    @NonNull
    public Boolean getStar() {
        return star;
    }

    public void setStar(@NonNull Boolean star) {
        this.star = star;
    }
}
