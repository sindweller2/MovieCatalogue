package submission2.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String data = "data";

    TextView dName, dDescription, dReleasedate, dRuntime;
    ImageView dPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dName = findViewById(R.id.d_name);
        dDescription = findViewById(R.id.d_description);
        dReleasedate = findViewById(R.id.d_releasedate);
        dRuntime = findViewById(R.id.d_runtime);
        dPicture = findViewById(R.id.d_picture);

        DataModel dataModel = getIntent().getParcelableExtra(data);

        dName.setText(dataModel.getName());
        dDescription.setText("Description :\n" + dataModel.getDescription());
        dReleasedate.setText("Release Date :\n" + dataModel.getReleasedate());
        dRuntime.setText("Run Time :\n" + dataModel.getRuntime());

        Glide.with(getApplicationContext())
                .load(dataModel.getPicture())
                .into(dPicture);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
