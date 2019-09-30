package submission2.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DataModel> dataModels;

    public void setDataModel(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        dataModels = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return dataModels.size();    }

    @Override
    public Object getItem(int i) {
        return dataModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        DataModel dataModel = (DataModel) getItem(i);
        viewHolder.bind(dataModel);
        return view;
    }

    public class ViewHolder {
        TextView mName;
        TextView mDescription;
        ImageView mPicture;

        ViewHolder(View view) {
            mName = view.findViewById(R.id.m_name);
            mDescription = view.findViewById(R.id.m_description);
            mPicture = view.findViewById(R.id.m_picture);
        }

        void bind(DataModel dataModel) {
            mName.setText(dataModel.getName());
            mDescription.setText(dataModel.getDescription());
            Glide.with(context)
                    .load(dataModel.getPicture())
                    .into(mPicture);
        }
    }
}
