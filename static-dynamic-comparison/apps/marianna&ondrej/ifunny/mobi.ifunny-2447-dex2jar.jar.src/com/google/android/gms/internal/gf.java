package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

import java.lang.reflect.Method;

@ii
public class gf {
    private Object a;
    private final Context b;

    public gf(Context paramContext) {
        this.b = paramContext;
    }

    public int a(String paramString1, String paramString2) {
        try {
            Class localClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            int i = ((Integer) localClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(localClass.cast(this.a), new Object[]{Integer.valueOf(3), paramString1, paramString2})).intValue();
            return i;
        } catch (Exception paramString1) {
            mx.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", paramString1);
        }
        return 5;
    }

    public Bundle a(String paramString1, String paramString2, String paramString3) {
        try {
            Class localClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            paramString1 = (Bundle) localClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(localClass.cast(this.a), new Object[]{Integer.valueOf(3), paramString1, paramString2, "inapp", paramString3});
            return paramString1;
        } catch (Exception paramString1) {
            mx.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", paramString1);
        }
        return null;
    }

    public void a() {
        this.a = null;
    }

    public void a(IBinder paramIBinder) {
        try {
            this.a = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{paramIBinder});
            return;
        } catch (Exception paramIBinder) {
            mx.e("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }

    public Bundle b(String paramString1, String paramString2) {
        try {
            Class localClass = this.b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            paramString1 = (Bundle) localClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(localClass.cast(this.a), new Object[]{Integer.valueOf(3), paramString1, "inapp", paramString2});
            return paramString1;
        } catch (Exception paramString1) {
            mx.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", paramString1);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */