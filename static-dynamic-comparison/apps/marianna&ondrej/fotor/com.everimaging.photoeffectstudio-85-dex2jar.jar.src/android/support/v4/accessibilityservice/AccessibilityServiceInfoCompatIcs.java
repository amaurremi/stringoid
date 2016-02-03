package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class AccessibilityServiceInfoCompatIcs {
    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo paramAccessibilityServiceInfo) {
        return paramAccessibilityServiceInfo.getCanRetrieveWindowContent();
    }

    public static String getDescription(AccessibilityServiceInfo paramAccessibilityServiceInfo) {
        return paramAccessibilityServiceInfo.getDescription();
    }

    public static String getId(AccessibilityServiceInfo paramAccessibilityServiceInfo) {
        return paramAccessibilityServiceInfo.getId();
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo paramAccessibilityServiceInfo) {
        return paramAccessibilityServiceInfo.getResolveInfo();
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo paramAccessibilityServiceInfo) {
        return paramAccessibilityServiceInfo.getSettingsActivityName();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/accessibilityservice/AccessibilityServiceInfoCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */