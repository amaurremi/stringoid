package com.quoord.tapatalkpro.ics.tapatalkid;

import android.content.Context;
import com.quoord.tapatalkpro.bean.TapatalkId;

public final class TapatalkIdFactory {
    public static TapatalkId getTapatalkId(Context paramContext) {
        return TapatalkIdImpl.getInstance(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/TapatalkIdFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */