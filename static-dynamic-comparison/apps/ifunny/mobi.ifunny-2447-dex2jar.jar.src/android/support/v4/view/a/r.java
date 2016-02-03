package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

import java.util.List;

final class r
        extends AccessibilityNodeProvider {
    r(s params) {
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt) {
        return (AccessibilityNodeInfo) this.a.a(paramInt);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt) {
        return this.a.a(paramString, paramInt);
    }

    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle) {
        return this.a.a(paramInt1, paramInt2, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */