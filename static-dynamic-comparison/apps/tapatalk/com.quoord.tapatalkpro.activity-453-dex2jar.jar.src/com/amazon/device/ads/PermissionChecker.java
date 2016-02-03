package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

class PermissionChecker {
    private static PermissionChecker INSTANCE = new PermissionChecker();
    private static final String INTERNET_PERMISSION = "android.permission.INTERNET";
    private static final String LOG_TAG = PermissionChecker.class.getSimpleName();
    private boolean isInternetPermissionPresent = false;

    static PermissionChecker getInstance() {
        return INSTANCE;
    }

    private static final boolean permissionCheckErrorCondition() {
        Log.d(LOG_TAG, "App permissions were not read.");
        return true;
    }

    protected static void setInstance(PermissionChecker paramPermissionChecker) {
        INSTANCE = paramPermissionChecker;
    }

    public final boolean passesInternetPermissionCheck(Context paramContext) {
        return passesInternetPermissionCheck(paramContext, null);
    }

    public final boolean passesInternetPermissionCheck(Context paramContext, String paramString) {
        if (this.isInternetPermissionPresent) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return permissionCheckErrorCondition();
        }
        String str = AndroidTargetUtils.getPackageCodePath(paramContext);
        if (str == null) {
            return permissionCheckErrorCondition();
        }
        paramContext = paramContext.getPackageManager();
        if (paramContext == null) {
            return permissionCheckErrorCondition();
        }
        paramContext = paramContext.getPackageArchiveInfo(str, 4096);
        if (paramContext == null) {
            return permissionCheckErrorCondition();
        }
        paramContext = paramContext.requestedPermissions;
        if (paramContext == null) {
            return permissionCheckErrorCondition();
        }
        int j = paramContext.length;
        int i = 0;
        while (i < j) {
            if (paramContext[i].equals("android.permission.INTERNET")) {
                this.isInternetPermissionPresent = true;
                return true;
            }
            i += 1;
        }
        if (paramString != null) {
            Log.e(paramString, "Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/PermissionChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */