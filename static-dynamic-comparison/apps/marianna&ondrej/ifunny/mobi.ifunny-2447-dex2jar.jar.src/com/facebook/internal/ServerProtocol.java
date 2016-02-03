package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

public final class ServerProtocol {
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    public static final String DIALOG_PARAM_DISPLAY = "display";
    public static final String DIALOG_PARAM_E2E = "e2e";
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    public static final String DIALOG_PARAM_SCOPE = "scope";
    public static final String DIALOG_PATH = "dialog/";
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN = "token";
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    public static final String GRAPH_API_VERSION = "v2.1";
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    private static final String LEGACY_API_VERSION = "v1.0";
    private static final String TAG = ServerProtocol.class.getName();
    public static final Collection<String> errorsProxyAuthDisabled = Utility.unmodifiableCollection(new String[]{"service_disabled", "AndroidAuthKillSwitchException"});
    public static final Collection<String> errorsUserCanceled = Utility.unmodifiableCollection(new String[]{"access_denied", "OAuthAccessDeniedException"});

    public static final String getAPIVersion() {
        if (Settings.getPlatformCompatibilityEnabled()) {
            return "v1.0";
        }
        return "v2.1";
    }

    public static final String getDialogAuthority() {
        return String.format("m.%s", new Object[]{Settings.getFacebookDomain()});
    }

    public static final String getGraphUrlBase() {
        return String.format("https://graph.%s", new Object[]{Settings.getFacebookDomain()});
    }

    public static final String getGraphVideoUrlBase() {
        return String.format("https://graph-video.%s", new Object[]{Settings.getFacebookDomain()});
    }

    public static Bundle getQueryParamsForPlatformActivityIntentWebFallback(Context paramContext, String paramString1, int paramInt, String paramString2, Bundle paramBundle) {
        paramContext = Settings.getApplicationSignature(paramContext);
        if (Utility.isNullOrEmpty(paramContext)) {
        }
        for (; ; ) {
            return null;
            Bundle localBundle1 = new Bundle();
            localBundle1.putString("android_key_hash", paramContext);
            localBundle1.putString("app_id", Settings.getApplicationId());
            localBundle1.putInt("version", paramInt);
            localBundle1.putString("display", "touch");
            Bundle localBundle2 = new Bundle();
            localBundle2.putString("action_id", paramString1);
            localBundle2.putString("app_name", paramString2);
            paramContext = paramBundle;
            if (paramBundle == null) {
                paramContext = new Bundle();
            }
            try {
                paramString1 = BundleJSONConverter.convertToJSON(localBundle2);
                paramContext = BundleJSONConverter.convertToJSON(paramContext);
                if ((paramString1 != null) && (paramContext != null)) {
                    localBundle1.putString("bridge_args", paramString1.toString());
                    localBundle1.putString("method_args", paramContext.toString());
                    paramContext = localBundle1;
                }
            } catch (JSONException paramContext) {
                for (; ; ) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + paramContext);
                    paramContext = null;
                }
            }
        }
        return paramContext;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ServerProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */