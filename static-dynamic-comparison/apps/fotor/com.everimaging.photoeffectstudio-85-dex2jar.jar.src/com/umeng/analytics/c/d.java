package com.umeng.analytics.c;

import com.umeng.analytics.d.s;
import org.json.JSONArray;

public class d
        extends s {
    public d() {
    }

    public d(String paramString)
            throws Exception {
        a(new JSONArray(paramString));
    }

    public d(JSONArray paramJSONArray)
            throws Exception {
        a(paramJSONArray);
    }

    private void a(JSONArray paramJSONArray)
            throws Exception {
        a(paramJSONArray.getString(0));
        a(paramJSONArray.getInt(1));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */