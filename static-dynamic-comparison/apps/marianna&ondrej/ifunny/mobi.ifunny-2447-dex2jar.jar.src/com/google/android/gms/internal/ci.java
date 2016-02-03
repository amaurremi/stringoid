package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

final class ci
        implements cp {
    public void a(mz parammz, Map<String, String> paramMap) {
        paramMap = (String) paramMap.get("urls");
        if (TextUtils.isEmpty(paramMap)) {
            mx.e("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] arrayOfString = paramMap.split(",");
        HashMap localHashMap = new HashMap();
        PackageManager localPackageManager = parammz.getContext().getPackageManager();
        int j = arrayOfString.length;
        int i = 0;
        if (i < j) {
            String str1 = arrayOfString[i];
            paramMap = str1.split(";", 2);
            String str2 = paramMap[0].trim();
            if (paramMap.length > 1) {
                paramMap = paramMap[1].trim();
                label100:
                if (localPackageManager.resolveActivity(new Intent(paramMap, Uri.parse(str2)), 65536) == null) {
                    break label152;
                }
            }
            label152:
            for (boolean bool = true; ; bool = false) {
                localHashMap.put(str1, Boolean.valueOf(bool));
                i += 1;
                break;
                paramMap = "android.intent.action.VIEW";
                break label100;
            }
        }
        parammz.a("openableURLs", localHashMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */