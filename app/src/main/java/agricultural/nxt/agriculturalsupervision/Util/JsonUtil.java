package agricultural.nxt.agriculturalsupervision.Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by huqiang on 2016/12/27 17:08.
 */

public class JsonUtil {

    public static String PareJson(String string){
        try {
            JSONObject jsonObject = new JSONObject(string);
            return jsonObject.getString("success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String ParseMsg(String string){
        try {
            JSONObject jsonObject = new JSONObject(string);
            return jsonObject.getString("msg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
