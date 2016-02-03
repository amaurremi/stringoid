package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@ii
public final class gi
        extends gu {
    private String a;
    private Context b;
    private String c;
    private ArrayList<String> d;

    public gi(String paramString1, ArrayList<String> paramArrayList, Context paramContext, String paramString2) {
        this.c = paramString1;
        this.d = paramArrayList;
        this.a = paramString2;
        this.b = paramContext;
    }

    private void b() {
        try {
            this.b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.b, this.c, "", Boolean.valueOf(true)});
            return;
        } catch (ClassNotFoundException localClassNotFoundException) {
            mx.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
            return;
        } catch (NoSuchMethodException localNoSuchMethodException) {
            mx.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
            return;
        } catch (Exception localException) {
            mx.d("Fail to report a conversion.", localException);
        }
    }

    protected int a(int paramInt) {
        if (paramInt == 0) {
            return 1;
        }
        if (paramInt == 1) {
            return 2;
        }
        if (paramInt == 4) {
            return 3;
        }
        return 0;
    }

    public String a() {
        return this.c;
    }

    protected String a(String paramString, HashMap<String, String> paramHashMap) {
        String str3 = this.b.getPackageName();
        long l1;
        long l2;
        String str2;
        try {
            String str1 = this.b.getPackageManager().getPackageInfo(str3, 0).versionName;
            l1 = SystemClock.elapsedRealtime();
            l2 = lj.e().a();
            Iterator localIterator = paramHashMap.keySet().iterator();
            while (localIterator.hasNext()) {
                String str4 = (String) localIterator.next();
                paramString = paramString.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{str4}), String.format("$1%s$2", new Object[]{paramHashMap.get(str4)}));
            }
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            for (; ; ) {
                mx.d("Error to retrieve app version", localNameNotFoundException);
                str2 = "";
            }
        }
        return paramString.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp135_132), String.format("$1%s$2", tmp149_146)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp167_164), String.format("$1%s$2", tmp181_178)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp198_195), String.format("$1%s$2", tmp212_209)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp233_230), String.format("$1%s$2", tmp247_244)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp266_263), String.format("$1%s$2", tmp280_277)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp297_294), String.format("$1%s$2", tmp311_308)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp333_330), String.format("$1%s$2", tmp347_344)).replaceAll("@@", "@");
    }

    public void b(int paramInt) {
        if (paramInt == 1) {
            b();
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("status", String.valueOf(paramInt));
        localHashMap.put("sku", this.c);
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            new mu(this.b, this.a, a(str, localHashMap)).e();
        }
    }

    public void c(int paramInt) {
        if (paramInt == 0) {
            b();
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("google_play_status", String.valueOf(paramInt));
        localHashMap.put("sku", this.c);
        localHashMap.put("status", String.valueOf(a(paramInt)));
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            new mu(this.b, this.a, a(str, localHashMap)).e();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */