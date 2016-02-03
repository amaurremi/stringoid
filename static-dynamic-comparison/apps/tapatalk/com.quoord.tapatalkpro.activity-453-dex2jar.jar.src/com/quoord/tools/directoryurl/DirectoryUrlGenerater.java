package com.quoord.tools.directoryurl;

import android.content.Context;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.Util;

public class DirectoryUrlGenerater {
    public static String appendAppKey(Context paramContext, String paramString) {
        if (paramString.contains("?")) {
        }
        for (paramString = paramString + "&" + TapatalkApp.APP_KEY; ; paramString = paramString + "?" + TapatalkApp.APP_KEY) {
            return paramString + "&locale=" + Util.getDeviceLocal(paramContext);
        }
    }

    public static String appendAuidWithOutTokenAndAppKey(Context paramContext, String paramString) {
        TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(paramContext);
        String str = paramString;
        if (localTapatalkId.getAuid() != -1) {
            str = paramString;
            if (localTapatalkId.getToken() != null) {
                if (!paramString.contains("?")) {
                    break label72;
                }
            }
        }
        label72:
        for (str = paramString + "&au_id=" + localTapatalkId.getAuid(); ; str = paramString + "?au_id=" + localTapatalkId.getAuid()) {
            return appendAppKey(paramContext, str);
        }
    }

    public static String appendTokenAndAppKey(Context paramContext, String paramString) {
        TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(paramContext);
        String str = paramString;
        if (localTapatalkId.getAuid() != -1) {
            str = paramString;
            if (localTapatalkId.getToken() != null) {
                if (!paramString.contains("?")) {
                    break label86;
                }
            }
        }
        label86:
        for (str = paramString + "&au_id=" + localTapatalkId.getAuid() + "&token=" + localTapatalkId.getToken(); ; str = paramString + "?au_id=" + localTapatalkId.getAuid() + "&token=" + localTapatalkId.getToken()) {
            return appendAppKey(paramContext, str);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/directoryurl/DirectoryUrlGenerater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */