package com.millennialmedia.android;

import java.io.ObjectInputStream;
import java.util.Date;

final class AdCache$4
        extends AdCache.Iterator {
    boolean a(String paramString1, int paramInt, Date paramDate, String paramString2, long paramLong, ObjectInputStream paramObjectInputStream) {
        if ((paramDate != null) && (paramDate.getTime() <= System.currentTimeMillis())) {
        }
        try {
            MMLog.e("AdCache", String.format("Deleting expired ad %s.", new Object[]{((CachedAd) paramObjectInputStream.readObject()).e()}));
            return true;
        } catch (Exception paramDate) {
            MMLog.a("AdCache", String.format("There was a problem reading the cached ad %s.", new Object[]{paramString1}), paramDate);
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdCache$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */