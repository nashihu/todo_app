package id.icon.testing.ui.editactivity;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import id.icon.testing.base.BasePresenter;

public class EditPresenter implements BasePresenter<EditView> {
    private EditView view;

    void putData(final String title, final String body, final String id, Context context) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id
                + "?title=" + title
                + "&body=" + body
                + "&userId=1";
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        view.sendMessage("success");
                        view.requestFinish(title, body, id);
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                view.sendMessage(error.toString());
                view.requestFinish(title, body, id);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onAttach(EditView view) {
        this.view = view;

    }

    @Override
    public void onDetach() {

    }
}
