package id.icon.testing.ui.addactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import id.icon.testing.R;
import id.icon.testing.ui.mainactivity.MainActivity;

public class AddActivity extends AppCompatActivity implements AddView {
    AddPresenter addPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        addPresenter = new AddPresenter();
        onAttachView();
        postData();
    }

    void postData() {

        findViewById(R.id.btn_add_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = findViewById(R.id.et_add_title);
                EditText desc = findViewById(R.id.et_add_desc);
                if(title.getText().toString().isEmpty() || desc.getText().toString().isEmpty()) {
                    Toast.makeText(AddActivity.this, "fill the field first", Toast.LENGTH_SHORT).show();
                } else {
                    addPresenter.postData(title.getText().toString(),desc.getText().toString(),AddActivity.this);
                }
            }
        });
    }

    @Override
    public void requestProcess() {
        findViewById(R.id.pd_add).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_add_add).setVisibility(View.GONE);

    }

    @Override
    public void requestFinish() {
        startActivity(new Intent(AddActivity.this, MainActivity.class));

    }

    @Override
    public void requestMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttachView() {
        addPresenter.onAttach(this);

    }

    @Override
    public void onDetachView() {
        addPresenter.onDetach();

    }
}
