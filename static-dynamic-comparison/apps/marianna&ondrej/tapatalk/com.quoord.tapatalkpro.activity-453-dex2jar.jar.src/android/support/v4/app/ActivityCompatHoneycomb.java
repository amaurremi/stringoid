package android.support.v4.app;

import android.app.Activity;

import java.io.FileDescriptor;
import java.io.PrintWriter;

class ActivityCompatHoneycomb {
    static void dump(Activity paramActivity, String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        paramActivity.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }

    static void invalidateOptionsMenu(Activity paramActivity) {
        paramActivity.invalidateOptionsMenu();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/android/support/v4/app/ActivityCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */