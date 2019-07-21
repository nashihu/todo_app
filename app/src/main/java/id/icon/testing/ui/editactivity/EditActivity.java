package id.icon.testing.ui.editactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import id.icon.testing.R;
import id.icon.testing.ui.detailactivity.DetailActivity;

public class EditActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final String title = getIntent().getStringExtra("title");
        final String desc = getIntent().getStringExtra("desc");
        final String id = getIntent().getStringExtra("id");
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
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
                String url = "https://jsonplaceholder.typicode.com/posts/" + id
                        + "?title=" + title_
                        + "&body=" + desc_
                        + "&userId=1";
                RequestQueue requestQueue = Volley.newRequestQueue(EditActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(EditActivity.this, "success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EditActivity.this, DetailActivity.class)
                                        .putExtra("title", title_)
                                        .putExtra("desc", desc_)
                                        .putExtra("id", id));
                                finish();
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EditActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(jsonObjectRequest);

            }
        });


    }
}
