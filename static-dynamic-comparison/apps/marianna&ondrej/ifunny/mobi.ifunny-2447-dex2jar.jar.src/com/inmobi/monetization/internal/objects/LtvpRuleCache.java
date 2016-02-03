package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.LtvpRulesObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class LtvpRuleCache {
    static LtvpRuleCache a;
    private static String c = "IMAdMLtvpRuleCache";
    private static String d = "IMAdMLtvpRuleId";
    private static String e = "IMAdMLtvpHardExpiry";
    private static String f = "IMAdMLtvpSoftExpiry";
    private SharedPreferences b = null;

    private LtvpRuleCache(Context paramContext) {
        this.b = paramContext.getSharedPreferences(c, 0);
    }

    private void a(long paramLong) {
        SharedPreferences.Editor localEditor = this.b.edit();
        localEditor.putLong(e, paramLong);
        localEditor.commit();
    }

    private void a(String paramString) {
        SharedPreferences.Editor localEditor = this.b.edit();
        localEditor.putString(d, paramString);
        localEditor.commit();
    }

    private void a(HashMap<String, Integer> paramHashMap) {
        try {
            SharedPreferences.Editor localEditor = this.b.edit();
            Iterator localIterator = paramHashMap.keySet().iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                localEditor.putInt(str, ((Integer) paramHashMap.get(str)).intValue());
            }
            localEditor.commit();
        } catch (Exception paramHashMap) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Exception saving rule map", paramHashMap);
            return;
        }
    }

    private void b(long paramLong) {
        SharedPreferences.Editor localEditor = this.b.edit();
        localEditor.putLong(f, paramLong);
        localEditor.commit();
    }

    public static LtvpRuleCache getInstance(Context paramContext) {
        if (a == null) {
        }
        try {
            if (a == null) {
                a = new LtvpRuleCache(paramContext);
            }
            return a;
        } finally {
        }
    }

    public void clearLtvpRuleCache() {
        SharedPreferences.Editor localEditor = this.b.edit();
        localEditor.clear();
        localEditor.commit();
    }

    public long getHardExpiryForLtvpRule() {
        return this.b.getLong(e, 0L);
    }

    public int getLtvpRule(long paramLong) {
        return this.b.getInt(String.valueOf(paramLong), 0);
    }

    public String getLtvpRuleId() {
        return this.b.getString(d, "");
    }

    public long getSoftExpiryForLtvpRule() {
        return this.b.getLong(f, 0L);
    }

    public void setLtvpRuleConfig(LtvpRulesObject paramLtvpRulesObject) {
        a(paramLtvpRulesObject.getRuleId());
        a(paramLtvpRulesObject.getHardExpiry() + paramLtvpRulesObject.getTimeStamp());
        b(paramLtvpRulesObject.getSoftExpiry() + paramLtvpRulesObject.getTimeStamp());
        a(paramLtvpRulesObject.getRules());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/objects/LtvpRuleCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */