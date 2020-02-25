package id.icon.testing.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class MainItem {

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String desc;

    @SerializedName("id")
    private String id;

//    public MainItem MainItem(JSONObject jsonObject) {
//        try {
//            this.title = jsonObject.getString("title");
//            this.desc = jsonObject.getString("body");
//            this.id = jsonObject.getString("id");
//        } catch (JSONException e) {
//            //
//        }
//
//    }

}
