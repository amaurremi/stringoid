package com.facebook.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;

public class AdInvalidationUtils {
    public static boolean isNativePackageInstalled(Context paramContext, String paramString) {
        if (StringUtils.isNullOrEmpty(paramString)) {
            return false;
        }
        paramContext = paramContext.getPackageManager();
        try {
            paramContext.getPackageInfo(paramString, 1);
            return true;
        } catch (PackageManager.NameNotFoundException paramContext) {
        }
        return false;
    }

    public static Collection<String> parseDetectionStrings(JSONArray paramJSONArray) {
        if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
            return null;
        }
        HashSet localHashSet = new HashSet();
        int i = 0;
        while (i < paramJSONArray.length()) {
            localHashSet.add(paramJSONArray.optString(i));
            i += 1;
        }
        return localHashSet;
    }

    public static boolean shouldInvalidate(Context paramContext, AdDataModel paramAdDataModel) {
        boolean bool2 = true;
        AdInvalidationBehavior localAdInvalidationBehavior = paramAdDataModel.getInvalidationBehavior();
        if ((localAdInvalidationBehavior == null) || (localAdInvalidationBehavior == AdInvalidationBehavior.NONE)) {
        }
        do {
            return false;
            paramAdDataModel = paramAdDataModel.getDetectionStrings();
        } while ((paramAdDataModel == null) || (paramAdDataModel.isEmpty()));
        paramAdDataModel = paramAdDataModel.iterator();
        do {
            if (!paramAdDataModel.hasNext()) {
                break;
            }
        } while (!isNativePackageInstalled(paramContext, (String) paramAdDataModel.next()));
        for (boolean bool1 = true; ; bool1 = false) {
            if (localAdInvalidationBehavior == AdInvalidationBehavior.INSTALLED) {
                return bool1;
            }
            if (localAdInvalidationBehavior != AdInvalidationBehavior.NOT_INSTALLED) {
                break;
            }
            if (!bool1) {
            }
            for (bool1 = bool2; ; bool1 = false) {
                return bool1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdInvalidationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */