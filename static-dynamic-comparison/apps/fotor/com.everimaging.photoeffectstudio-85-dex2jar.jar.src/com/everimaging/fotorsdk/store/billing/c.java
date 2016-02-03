package com.everimaging.fotorsdk.store.billing;

public class c {
    int a;
    String b;

    public c(int paramInt, String paramString) {
        this.a = paramInt;
        if ((paramString == null) || (paramString.trim().length() == 0)) {
            this.b = b.a(paramInt);
            return;
        }
        this.b = (paramString + " (response: " + b.a(paramInt) + ")");
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        return this.a == 0;
    }

    public boolean c() {
        return this.a == 7;
    }

    public String toString() {
        return "IabResult: " + a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/billing/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */