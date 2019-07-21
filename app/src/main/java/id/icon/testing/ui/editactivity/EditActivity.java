package id.icon.testing.ui.editactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import id.icon.testing.R;
import id.icon.testing.ui.detailactivity.DetailActivity;

public class EditActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final String title = getIntent().getStringExtra("title");
        final String desc = getIntent().getStringExtra("desc");
        final EditText et_title =  findViewById(R.id.et_edit_title);
        final EditText et_desc = findViewById(R.id.et_edit_desc);
        et_title.setText(title);
        et_desc.setText(desc);
        findViewById(R.id.btn_edit_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(0,0);
                startActivity(new Intent(EditActivity.this, DetailActivity.class)
                .putExtra("title",et_title.getText().toString())
                .putExtra("desc",et_desc.getText().toString()));
                finish();
            }
        });


    }
}
