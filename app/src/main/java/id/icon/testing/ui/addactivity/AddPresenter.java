package id.icon.testing.ui.addactivity;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import id.icon.testing.base.BasePresenter;

public class AddPresenter implements BasePresenter<AddView> {
    AddView view;

    void postData(String title, String body, final Context context) {
        view.requestProcess();
        String url = "https://jsonplaceholder.typicode.com/posts/"
                + "?title=" + title
                + "&body=" + body;
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        view.requestMessage("success");
                        view.requestFinish();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                view.requestMessage(error.toString());
                view.requestFinish();
            }
        });
        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public void onAttach(AddView view) {
        this.view = view;

    }

    @Override
    public void onDetach() {
        this.view = null;

    }
}
