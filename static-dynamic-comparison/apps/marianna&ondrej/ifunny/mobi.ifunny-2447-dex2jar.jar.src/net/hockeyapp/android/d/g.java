package net.hockeyapp.android.d;

import java.util.Comparator;

import org.json.JSONException;
import org.json.JSONObject;

class g
        implements Comparator<JSONObject> {
    g(f paramf) {
    }

    public int a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
        try {
            int i = paramJSONObject1.getInt("version");
            int j = paramJSONObject2.getInt("version");
            if (i > j) {
            }
            return 0;
        } catch (NullPointerException paramJSONObject1) {
            return 0;
        } catch (JSONException paramJSONObject1) {
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */