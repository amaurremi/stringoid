package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import java.lang.ref.WeakReference;
import java.util.Map;

class BridgeMMBanner
        extends MMJSObject {
    int a(Context paramContext) {
        return Integer.parseInt(MMSDK.p(paramContext));
    }

    MMJSResponse a(String paramString, Map<String, String> paramMap) {
        MMJSResponse localMMJSResponse = null;
        if ("resize".equals(paramString)) {
            localMMJSResponse = resize(paramMap);
        }
        return localMMJSResponse;
    }

    int b(Context paramContext) {
        return Integer.parseInt(MMSDK.o(paramContext));
    }

    public MMJSResponse resize(Map<String, String> paramMap) {
        int m = 0;
        MMWebView localMMWebView = (MMWebView) this.c.get();
        String str1;
        Object localObject;
        if (localMMWebView != null) {
            if (localMMWebView.w()) {
                return MMJSResponse.b("State is currently resized");
            }
            str1 = (String) paramMap.get("width");
            localObject = (String) paramMap.get("height");
            if (TextUtils.isEmpty(str1)) {
                break label254;
            }
        }
        label254:
        for (int i = (int) Float.parseFloat(str1); ; i = 0) {
            if (!TextUtils.isEmpty((CharSequence) localObject)) {
            }
            for (int j = (int) Float.parseFloat((String) localObject); ; j = 0) {
                str1 = (String) paramMap.get("customClosePosition");
                localObject = (String) paramMap.get("offsetX");
                String str2 = (String) paramMap.get("offsetY");
                if (!TextUtils.isEmpty(str2)) {
                }
                for (int k = (int) Float.parseFloat(str2); ; k = 0) {
                    if (!TextUtils.isEmpty((CharSequence) localObject)) {
                        m = (int) Float.parseFloat((String) localObject);
                    }
                    boolean bool = Boolean.parseBoolean((String) paramMap.get("allowOffscreen"));
                    paramMap = localMMWebView.getContext();
                    localObject = paramMap.getResources().getDisplayMetrics();
                    int n = b(paramMap);
                    int i1 = a(paramMap);
                    localMMWebView.a(new DTOResizeParameters(((DisplayMetrics) localObject).density, i, j, str1, m, k, bool, n, i1));
                    return MMJSResponse.a();
                    return null;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */