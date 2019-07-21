package id.icon.testing.ui.detailactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import id.icon.testing.R;
import id.icon.testing.ui.editactivity.EditActivity;
import id.icon.testing.ui.mainactivity.MainActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        edit();
        delete();
    }

    private void delete() {
        final String id = getIntent().getStringExtra("id");
        findViewById(R.id.btn_detail_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.pd_detail).setVisibility(View.VISIBLE);
                findViewById(R.id.LL_detial_button).setVisibility(View.GONE);
                String url = "https://jsonplaceholder.typicode.com/posts/" + id;
                RequestQueue requestQueue = Volley.newRequestQueue(DetailActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(DetailActivity.this, "success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DetailActivity.this, MainActivity.class));
                                finish();
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DetailActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(jsonObjectRequest);

            }
        });

    }

    private void edit() {
        final String title = getIntent().getStringExtra("title");
        final String desc = getIntent().getStringExtra("desc");
        ((TextView) findViewById(R.id.tv_detail_title)).setText(title);
        ((TextView) findViewById(R.id.tv_detail_desc)).setText(desc);
        findViewById(R.id.btn_detail_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, EditActivity.class)
                        .putExtra("title", title)
                        .putExtra("desc", desc));
                finish();

            }
        });

    }
}
