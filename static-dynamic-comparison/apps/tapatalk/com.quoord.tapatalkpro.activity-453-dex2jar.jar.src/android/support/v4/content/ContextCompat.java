package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public class ContextCompat {
    public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent) {
        return startActivities(paramContext, paramArrayOfIntent, null);
    }

    public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
            return true;
        }
        if (i >= 11) {
            ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/android/support/v4/content/ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */