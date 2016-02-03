package com.inmobi.monetization.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.RequestResponseManager;

public class ConnBroadcastReciever
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if ((paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) && (InternalSDKUtil.checkNetworkAvailibility(paramContext))) {
            Log.internal("[InMobi]-[Monetization]", "Received CONNECTIVITY BROADCAST");
        }
        try {
            paramIntent = new RequestResponseManager();
            paramIntent.init();
            paramIntent.processClick(paramContext.getApplicationContext(), null);
            return;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-[Monetization]", "Connectivity receiver exception", paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/ConnBroadcastReciever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */