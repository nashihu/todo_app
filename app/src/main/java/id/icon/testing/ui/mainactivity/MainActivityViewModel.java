package id.icon.testing.ui.mainactivity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import java.util.List;

import id.icon.testing.base.BaseFunction;
import id.icon.testing.model.MainItem;
import id.icon.testing.rest.API;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private final MutableLiveData<List<MainItem>> dataDetail = new MutableLiveData<>();
    void setData(final Context context) {
        API.mainItem().search().enqueue(new Callback<List<MainItem>>() {
            @Override
            public void onFailure(Call<List<MainItem>> call, Throwable t) {
                BaseFunction.proceed(t);
            }

            @Override
            public void onResponse(Call<List<MainItem>> call, Response<List<MainItem>> response) {
                BaseFunction.proceed(call);
                dataDetail.postValue(response.body());
            }
        });

    }

    LiveData<List<MainItem>> getData() {

        return dataDetail;
    }

    void log() {
        final StackTraceElement stackTrace = new Exception().getStackTrace()[1];

        String fileName = stackTrace.getFileName();
        if (fileName == null) fileName="";  // It is necessary if you want to use proguard obfuscation.

        final String info = stackTrace.getMethodName() + " (" + fileName + ":"
                + stackTrace.getLineNumber() + ")";

        Log.e("url", info + ": " + "sip");
    }
}
