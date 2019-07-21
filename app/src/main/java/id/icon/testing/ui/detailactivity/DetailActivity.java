package id.icon.testing.ui.detailactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.icon.testing.R;
import id.icon.testing.ui.editactivity.EditActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final String title = getIntent().getStringExtra("title");
        final String desc = getIntent().getStringExtra("desc");
        ((TextView) findViewById(R.id.tv_detail_title)).setText(title);
        ((TextView) findViewById(R.id.tv_detail_desc)).setText(desc);
        findViewById(R.id.btn_detail_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, EditActivity.class)
                .putExtra("title",title)
                .putExtra("desc",desc));
                finish();
            }
        });
    }
}
