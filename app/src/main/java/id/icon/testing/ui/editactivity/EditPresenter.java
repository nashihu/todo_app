package id.icon.testing.ui.editactivity;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Timer;

import id.icon.testing.base.BaseFunction;
import id.icon.testing.base.BasePresenter;
import id.icon.testing.model.MainItem;
import id.icon.testing.rest.API;
import retrofit2.Call;

public class EditPresenter implements BasePresenter<EditView> {
    private EditView view;

    void putData(final String title, final String body, final String id, Context context) {
        MainItem mainItem = new MainItem();
        mainItem.setDesc(body);
        mainItem.setTitle(title);
        mainItem.setId(id);
        API.mainItem().edit(mainItem).enqueue(new retrofit2.Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                BaseFunction.proceed(call);
                view.sendMessage("success with code "+response.code());
                view.requestFinish(title,body,id);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                BaseFunction.proceed(t);
                view.sendMessage(t.getMessage());
                view.requestFinish(title,body,id);
            }
        });
    }

    @Override
    public void onAttach(EditView view) {
        this.view = view;

    }

    @Override
    public void onDetach() {

    }
}
