package com.inmobi.monetization;

import com.inmobi.monetization.internal.AdErrorCode;

class b$a
        implements Runnable {
    b$a(b paramb, AdErrorCode paramAdErrorCode) {
    }

    public void run() {
        if (IMNative.a(this.b.a) != null) {
            IMNative.a(this.b.a).onNativeRequestFailed(IMErrorCode.a(this.a));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */