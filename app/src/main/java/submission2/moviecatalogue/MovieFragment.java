package submission2.moviecatalogue;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private String[] movieName;
    private String[] movieDescription;
    private String[] movieReleasedate;
    private String[] movieRuntime;
    private String[] moviePicture;
    private MovieAdapter movieAdapter;
    private ArrayList<DataModel> dataModels;

    public MovieFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieAdapter = new MovieAdapter(getContext());

        ListView listView = getView().findViewById(R.id.lv_movie);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.data, dataModels.get(i));
                startActivity(intent);
            }
        });
    }

    private void prepare() {
        movieName = getResources().getStringArray(R.array.movie_name);
        movieDescription = getResources().getStringArray(R.array.movie_description);
        movieReleasedate = getResources().getStringArray(R.array.movie_releasedate);
        movieRuntime = getResources().getStringArray(R.array.movie_runtime);
        moviePicture = getResources().getStringArray(R.array.movie_picture);
    }

    private void addItem() {
        dataModels = new ArrayList<>();

        for (int i = 0; i < movieName.length; i++) {
            DataModel dataModel = new DataModel();

            dataModel.setName(movieName[i]);
            dataModel.setDescription(movieDescription[i]);
            dataModel.setReleasedate(movieReleasedate[i]);
            dataModel.setRuntime(movieRuntime[i]);
            dataModel.setPicture(moviePicture[i]);

            dataModels.add(dataModel);
        }

        movieAdapter.setDataModel(dataModels);
    }
}
