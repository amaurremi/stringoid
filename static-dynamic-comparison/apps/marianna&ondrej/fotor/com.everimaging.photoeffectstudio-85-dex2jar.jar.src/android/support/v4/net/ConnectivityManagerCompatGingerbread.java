package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class ConnectivityManagerCompatGingerbread {
    public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager) {
        paramConnectivityManager = paramConnectivityManager.getActiveNetworkInfo();
        if (paramConnectivityManager == null) {
            return true;
        }
        switch (paramConnectivityManager.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/net/ConnectivityManagerCompatGingerbread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */