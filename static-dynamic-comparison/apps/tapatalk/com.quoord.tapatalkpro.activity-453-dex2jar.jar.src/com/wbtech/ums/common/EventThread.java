package com.wbtech.ums.common;

import android.content.Context;
import com.wbtech.ums.UmsAgent;

public class EventThread
        extends Thread {
    private static final Object eventObject = new Object();
    private int acc;
    private String eventID;
    private String label;
    private Context paramContext;
    private String umsAppkey;

    public EventThread(Context paramContext1, String paramString1, String paramString2, String paramString3, int paramInt) {
        this.paramContext = paramContext1;
        this.eventID = paramString2;
        this.label = paramString3;
        this.umsAppkey = paramString1;
        this.acc = paramInt;
    }

    public void run() {
        try {
            synchronized (eventObject) {
                UmsAgent.saveEvent(UmsAgent.getUmsAgent(), this.paramContext, this.umsAppkey, this.eventID, this.label, this.acc);
                return;
            }
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/common/EventThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */