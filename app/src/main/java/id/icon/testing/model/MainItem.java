package id.icon.testing.model;

import org.json.JSONException;
import org.json.JSONObject;

public class MainItem {
    private String title;
    private String desc;
    private String id;

    public MainItem(JSONObject jsonObject) {
        try {
            this.title = jsonObject.getString("title");
            this.desc = jsonObject.getString("body");
            this.id = jsonObject.getString("id");
        } catch (JSONException e) {
            //
        }

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

}
