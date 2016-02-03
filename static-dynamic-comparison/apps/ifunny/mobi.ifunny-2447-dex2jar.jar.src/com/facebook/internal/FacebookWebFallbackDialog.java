package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.WebDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog
        extends WebDialog {
    private static final String TAG = FacebookWebFallbackDialog.class.getName();

    private FacebookWebFallbackDialog(Context paramContext, String paramString1, String paramString2) {
        super(paramContext, paramString1);
        setExpectedRedirectUrl(paramString2);
    }

    public static boolean presentWebFallback(Context paramContext, String paramString1, String paramString2, FacebookDialog.PendingCall paramPendingCall, FacebookDialog.Callback paramCallback) {
        if (Utility.isNullOrEmpty(paramString1)) {
            return false;
        }
        paramString1 = new FacebookWebFallbackDialog(paramContext, paramString1, String.format("fb%s://bridge/", new Object[]{paramString2}));
        paramString1.setOnCompleteListener(new FacebookWebFallbackDialog .1
        (paramContext, paramPendingCall, paramCallback));
        paramString1.show();
        return true;
    }

    protected Bundle parseResponseUri(String paramString) {
        Bundle localBundle = Utility.parseUrlQueryString(Uri.parse(paramString).getQuery());
        paramString = localBundle.getString("bridge_args");
        localBundle.remove("bridge_args");
        if (!Utility.isNullOrEmpty(paramString)) {
        }
        try {
            localBundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(paramString)));
            String str = localBundle.getString("method_results");
            localBundle.remove("method_results");
            if (!Utility.isNullOrEmpty(str)) {
                paramString = str;
                if (Utility.isNullOrEmpty(str)) {
                    paramString = "{}";
                }
            }
        } catch (JSONException paramString) {
            try {
                localBundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(paramString)));
                localBundle.remove("version");
                localBundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
                return localBundle;
                paramString = paramString;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", paramString);
            } catch (JSONException paramString) {
                for (; ; ) {
                    Utility.logd(TAG, "Unable to parse bridge_args JSON", paramString);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FacebookWebFallbackDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */