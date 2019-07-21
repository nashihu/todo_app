package id.icon.testing.ui.editactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import id.icon.testing.R;
import id.icon.testing.ui.detailactivity.DetailActivity;

public class EditActivity extends AppCompatActivity implements EditView {
    EditPresenter editPresenter;
    String titlee,descc,idd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intentdata = getIntent();
        titlee = intentdata.getStringExtra("title");
        descc = intentdata.getStringExtra("desc");
        idd = intentdata.getStringExtra("id");
        setContentView(R.layout.activity_edit);
        editPresenter = new EditPresenter();
        onAttachView();
        edit();


    }

    private void edit() {
        final String title = getIntent().getStringExtra("title");
        final String desc = getIntent().getStringExtra("desc");
        final String id = getIntent().getStringExtra("id");
        final EditText et_title = findViewById(R.id.et_edit_title);
        final EditText et_desc = findViewById(R.id.et_edit_desc);
        et_title.setText(title);
        et_desc.setText(desc);

        findViewById(R.id.btn_edit_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.pd_edit).setVisibility(View.VISIBLE);
                findViewById(R.id.btn_edit_edit).setVisibility(View.GONE);
                final String title_ = et_title.getText().toString();
                final String desc_ = et_desc.getText().toString();
                editPresenter.putData(title_, desc_, id, EditActivity.this);


            }
        });
    }

    @Override
    public void requestProcess() {
        findViewById(R.id.pd_edit).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_edit_edit).setVisibility(View.GONE);

    }


    @Override
    public void requestFinish(String title_, String desc_, String id) {
        startActivity(new Intent(EditActivity.this, DetailActivity.class)
                .putExtra("title", title_)
                .putExtra("desc", desc_)
                .putExtra("id", id));
        finish();

    }

    @Override
    public void sendMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAttachView() {
        editPresenter.onAttach(this);

    }

    @Override
    public void onDetachView() {
        editPresenter.onDetach();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,DetailActivity.class)
        .putExtra("title",titlee)
        .putExtra("desc",descc)
        .putExtra("id",idd));
    }
}
