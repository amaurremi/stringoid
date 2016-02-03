package com.google.android.gms.internal;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

@ii
public final class dr {
    public static List<String> a(JSONObject paramJSONObject, String paramString) {
        paramJSONObject = paramJSONObject.optJSONArray(paramString);
        if (paramJSONObject != null) {
            paramString = new ArrayList(paramJSONObject.length());
            int i = 0;
            while (i < paramJSONObject.length()) {
                paramString.add(paramJSONObject.getString(i));
                i += 1;
            }
            return Collections.unmodifiableList(paramString);
        }
        return null;
    }

    public static void a(Context paramContext, String paramString1, lc paramlc, String paramString2, boolean paramBoolean, List<String> paramList) {
        if (paramBoolean) {
        }
        for (String str1 = "1"; ; str1 = "0") {
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext()) {
                String str2 = ((String) localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramlc.o.f).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", lj.a).replaceAll("@gw_seqnum@", paramlc.i);
                paramList = str2;
                if (paramlc.l != null) {
                    paramList = str2.replaceAll("@gw_adnetid@", paramlc.l.b).replaceAll("@gw_allocid@", paramlc.l.d);
                }
                new mu(paramContext, paramString1, paramList).e();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */