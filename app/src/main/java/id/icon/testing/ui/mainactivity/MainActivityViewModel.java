package id.icon.testing.ui.mainactivity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.icon.testing.model.MainItem;

public class MainActivityViewModel extends ViewModel {
    private final MutableLiveData<List<MainItem>> dataDetail = new MutableLiveData<>();
    void setData(final Context context, final String userid) {
        final String url = "https://jsonplaceholder.typicode.com/posts?userId="+userid;
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if(response!=null) {
                            ArrayList<MainItem> mainItems = new ArrayList<>();
                            for(int i = 0; i<response.length(); i++) {
                                try {
                                    mainItems.add(new MainItem((JSONObject) response.get(i)));
                                } catch (JSONException e) {
                                    //asdf
                                }
                            }
                            dataDetail.postValue(mainItems);

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonObjectRequest);

    }

    LiveData<List<MainItem>> getData() {

        return dataDetail;
    }
}
