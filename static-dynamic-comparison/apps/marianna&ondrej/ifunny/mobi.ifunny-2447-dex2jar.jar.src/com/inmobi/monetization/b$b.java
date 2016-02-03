package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;

class b$b
        implements Runnable {
    b$b(b paramb) {
    }

    public void run() {
        try {
            if (IMNative.a(this.a.a) != null) {
                IMNative.a(this.a.a).onNativeRequestSucceeded(this.a.a);
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
            Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/b$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */