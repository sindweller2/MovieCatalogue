package submission2.moviecatalogue;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class TVFragment extends Fragment {

    private String[] tvName;
    private String[] tvDescription;
    private String[] tvReleasedate;
    private String[] tvRuntime;
    private String[] tvPicture;
    private TVAdapter tvAdapter;
    private ArrayList<DataModel> dataModels;

    public TVFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvAdapter = new TVAdapter(getContext());

        ListView listView = getView().findViewById(R.id.lv_tv);
        listView.setAdapter(tvAdapter);

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
        tvName = getResources().getStringArray(R.array.tv_name);
        tvDescription = getResources().getStringArray(R.array.tv_description);
        tvReleasedate = getResources().getStringArray(R.array.tv_releasedate);
        tvRuntime = getResources().getStringArray(R.array.tv_runtime);
        tvPicture = getResources().getStringArray(R.array.tv_picture);
    }

    private void addItem() {
        dataModels = new ArrayList<>();

        for (int i = 0; i < tvName.length; i++) {
            DataModel dataModel = new DataModel();

            dataModel.setName(tvName[i]);
            dataModel.setDescription(tvDescription[i]);
            dataModel.setReleasedate(tvReleasedate[i]);
            dataModel.setRuntime(tvRuntime[i]);
            dataModel.setPicture(tvPicture[i]);

            dataModels.add(dataModel);
        }

        tvAdapter.setDataModel(dataModels);
    }
}
