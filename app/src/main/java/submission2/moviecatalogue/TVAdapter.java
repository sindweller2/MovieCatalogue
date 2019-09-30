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

public class TVAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<DataModel> dataModels;

    public void setDataModel(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    public TVAdapter(Context context) {
        this.context = context;
        dataModels = new ArrayList<>();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<DataModel> getDataModels() {
        return dataModels;
    }

    public void setDataModels(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @Override
    public int getCount() {
        return dataModels.size();
    }

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
            view = LayoutInflater.from(context).inflate(R.layout.item_tv, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        DataModel dataModel = (DataModel) getItem(i);
        viewHolder.bind(dataModel);
        return view;
    }

    public class ViewHolder {
        TextView tName;
        TextView tDescription;
        ImageView tPicture;

        ViewHolder(View view) {
            tName = view.findViewById(R.id.t_name);
            tDescription = view.findViewById(R.id.t_description);
            tPicture = view.findViewById(R.id.t_picture);
        }

        void bind(DataModel dataModel) {
            tName.setText(dataModel.getName());
            tDescription.setText(dataModel.getDescription());
            Glide.with(context)
                    .load(dataModel.getPicture())
                    .into(tPicture);
        }
    }
}
