package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManifestUtils {
    private static final List<Class<? extends Activity>> a = new ArrayList(4);
    private static final List<Class<? extends Activity>> b;

    static {
        a.add(MoPubActivity.class);
        a.add(MraidActivity.class);
        a.add(MraidVideoPlayerActivity.class);
        a.add(MoPubBrowser.class);
        b = new ArrayList(1);
        b.add(MoPubBrowser.class);
    }

    static void a(Context paramContext, List<Class<? extends Activity>> paramList) {
        if (paramContext == null) {
        }
        do {
            return;
            paramList = b(paramContext, paramList);
        } while (paramList.isEmpty());
        if (a(paramContext)) {
            paramContext = Toast.makeText(paramContext, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities.", 1);
            paramContext.setGravity(7, 0, 0);
            paramContext.show();
        }
        a(paramList);
    }

    private static void a(List<String> paramList) {
        StringBuilder localStringBuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            String str = (String) paramList.next();
            localStringBuilder.append("\n\t").append(str);
        }
        localStringBuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.w(localStringBuilder.toString());
    }

    static boolean a(Context paramContext) {
        if ((paramContext == null) || (paramContext.getApplicationInfo() == null)) {
            return false;
        }
        return Utils.bitMaskContainsFlag(paramContext.getApplicationInfo().flags, 2);
    }

    private static List<String> b(Context paramContext, List<Class<? extends Activity>> paramList) {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            Class localClass = (Class) paramList.next();
            if (!IntentUtils.deviceCanHandleIntent(paramContext, new Intent(paramContext, localClass))) {
                localArrayList.add(localClass.getName());
            }
        }
        return localArrayList;
    }

    public static void checkNativeActivitiesDeclared(Context paramContext) {
        a(paramContext, b);
    }

    public static void checkWebViewActivitiesDeclared(Context paramContext) {
        a(paramContext, a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/ManifestUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */