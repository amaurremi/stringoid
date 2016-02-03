package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.inmobi.commons.thinICE.icedatacollector.BuildSettings;

import java.lang.reflect.Method;
import java.util.ArrayList;

class CellUtil$a {
    static int a(Context paramContext) {
        paramContext = (TelephonyManager) paramContext.getSystemService("phone");
        try {
            paramContext = (ArrayList) TelephonyManager.class.getMethod("getAllCellInfo", (Class[]) null).invoke(paramContext, (Object[]) null);
            if (paramContext != null) {
                paramContext = paramContext.get(0);
                paramContext = paramContext.getClass().getMethod("getCellSignalStrength", (Class[]) null).invoke(paramContext, (Object[]) null);
                int i = ((Integer) paramContext.getClass().getMethod("getDbm", (Class[]) null).invoke(paramContext, (Object[]) null)).intValue();
                return i;
            }
        } catch (Exception paramContext) {
            if (BuildSettings.DEBUG) {
                Log.e("IceDataCollector", "Error getting cell tower signal strength", paramContext);
            }
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/cellular/CellUtil$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */