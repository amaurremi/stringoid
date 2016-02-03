package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

class Utils {
    static JSONObject a(View paramView) {
        JSONObject localJSONObject = new JSONObject();
        if (paramView == null) {
            MMLog.e("Utils", "Unable to calculate view dimensions for null view");
        }
        DisplayMetrics localDisplayMetrics;
        do {
            return localJSONObject;
            localDisplayMetrics = paramView.getContext().getResources().getDisplayMetrics();
        } while (localDisplayMetrics == null);
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        try {
            localJSONObject.put("x", (int) (arrayOfInt[0] / localDisplayMetrics.density));
            localJSONObject.put("y", (int) (arrayOfInt[1] / localDisplayMetrics.density));
            localJSONObject.put("width", (int) (paramView.getWidth() / localDisplayMetrics.density));
            localJSONObject.put("height", (int) (paramView.getHeight() / localDisplayMetrics.density));
            return localJSONObject;
        } catch (JSONException paramView) {
            MMLog.a("Utils", "Unable to build view dimensions", paramView);
        }
        return localJSONObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */