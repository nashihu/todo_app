package id.icon.testing.model;

import org.json.JSONException;
import org.json.JSONObject;

public class MainItem {
    private String title;
    private String desc;

    public MainItem(JSONObject jsonObject) {
        try {
            this.title = jsonObject.getString("title");
            this.desc = jsonObject.getString("body");
        } catch (JSONException e) {
            //
        }

    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
