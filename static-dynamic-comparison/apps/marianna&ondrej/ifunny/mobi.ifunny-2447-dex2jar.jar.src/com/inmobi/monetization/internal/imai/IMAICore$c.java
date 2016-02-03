package com.inmobi.monetization.internal.imai;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;

import java.lang.ref.WeakReference;

final class IMAICore$c
        implements Runnable {
    IMAICore$c(String paramString, boolean paramBoolean, WeakReference paramWeakReference) {
    }

    public void run() {
        try {
            int i = Initializer.getConfigParams().getImai().getMaxRetry();
            ClickData localClickData = new ClickData(this.a, this.b, true, i);
            RequestResponseManager localRequestResponseManager = new RequestResponseManager();
            localRequestResponseManager.init();
            RequestResponseManager.mNetworkQueue.add(0, localClickData);
            localRequestResponseManager.processClick(InternalSDKUtil.getContext(), new IMAICore.c.a(this));
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception ping in background", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/IMAICore$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */