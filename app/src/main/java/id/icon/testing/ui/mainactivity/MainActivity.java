package id.icon.testing.ui.mainactivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.icon.testing.R;
import id.icon.testing.model.MainItem;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel model;
    private ArrayList<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        model.setData(this,"1");
        model.getData().observe(this,observer);

    }

    private final Observer<List<MainItem>> observer = new Observer<List<MainItem>>() {
        @Override
        public void onChanged(@Nullable List<MainItem> mainItems) {
            if(mainItems!=null)
            for(int i = 0; i<mainItems.size();i++ ) {
                titles.add(mainItems.get(0).getTitle());
            }
            RecyclerView recyclerView = findViewById(R.id.rv_main);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
            MainAdapter mainAdapter = new MainAdapter(MainActivity.this, mainItems
            );
            recyclerView.setAdapter(mainAdapter);

        }
    };
}
