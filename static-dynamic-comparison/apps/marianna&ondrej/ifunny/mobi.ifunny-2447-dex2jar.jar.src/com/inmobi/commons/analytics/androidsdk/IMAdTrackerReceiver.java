package com.inmobi.commons.analytics.androidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.net.URLEncoder;

public class IMAdTrackerReceiver
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if (paramContext == null) {
            Log.debug("[InMobi]-4.5.1", "Application Context NULL");
            Log.debug("[InMobi]-4.5.1", "context cannot be null");
        }
        String str4;
        String str1;
        String str5;
        String str2;
        String str3;
        long l1;
        long l2;
        do {
            do {
                return;
                if (paramIntent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {
                    try {
                        Log.debug("[InMobi]-[AdTracker]-4.5.1", "Received INSTALL REFERRER");
                        paramIntent = paramIntent.getExtras().getString("referrer");
                        Log.debug("[InMobi]-[AdTracker]-4.5.1", "Referrer String: " + paramIntent);
                        FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "rfs", 1);
                        paramIntent = URLEncoder.encode(paramIntent, "utf-8");
                        AdTrackerUtils.setInternalReferrer(paramContext.getApplicationContext(), paramIntent);
                        return;
                    } catch (Exception paramContext) {
                        Log.internal("[InMobi]-[AdTracker]-4.5.1", "Error install receiver", paramContext);
                        return;
                    }
                }
                if ((paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) && (InternalSDKUtil.checkNetworkAvailibility(paramContext))) {
                    try {
                        Log.internal("[InMobi]-[AdTracker]-4.5.1", "Received CONNECTIVITY BROADCAST");
                        AdTrackerNetworkInterface.init();
                        AdTrackerNetworkInterface.reportToServer(FileOperations.getPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "mk-siteid"));
                        return;
                    } catch (Exception paramContext) {
                        Log.internal("[InMobi]-[AdTracker]-4.5.1", "Connectivity receiver exception", paramContext);
                        return;
                    }
                }
            } while (!paramIntent.getAction().equals("com.inmobi.share.id"));
            str4 = paramIntent.getExtras().getString("AID");
            str1 = FileOperations.getPreferences(paramContext, "impref", "IMID");
            str5 = paramIntent.getExtras().getString("IMID");
            str2 = FileOperations.getPreferences(paramContext, "impref", "AIDL");
            str3 = paramIntent.getExtras().getString("AIDL");
            l1 = FileOperations.getLongPreferences(paramContext, "impref", "timestamp");
            l2 = paramIntent.getExtras().getLong("timestamp");
        } while ((str2 == null) || (str4 == null));
        if (!str2.contains(str4)) {
            if (l2 < l1) {
                FileOperations.setPreferences(paramContext, "impref", "IMID", str5);
            }
            paramIntent = new Intent();
            paramIntent.setAction("com.inmobi.share.id");
            paramIntent.putExtra("IMID", str1);
            paramIntent.putExtra("AIDL", str2);
            paramIntent.putExtra("timestamp", l1);
            paramIntent.putExtra("AID", DeviceInfo.getAid());
            paramContext.sendBroadcast(paramIntent);
        }
        FileOperations.setPreferences(paramContext, "impref", "AIDL", InternalSDKUtil.union(str3, str2));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/androidsdk/IMAdTrackerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */