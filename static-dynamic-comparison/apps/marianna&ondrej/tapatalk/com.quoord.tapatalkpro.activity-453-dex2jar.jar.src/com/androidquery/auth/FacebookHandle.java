package com.androidquery.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.androidquery.AQuery;
import com.androidquery.WebDialog;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONObject;

public class FacebookHandle
        extends AccountHandle {
    private static final String CANCEL_URI = "fbconnect:cancel";
    public static final String FB_APP_SIGNATURE = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
    private static final String FB_PERMISSION = "aq.fb.permission";
    private static final String FB_TOKEN = "aq.fb.token";
    private static final String OAUTH_ENDPOINT = "https://graph.facebook.com/oauth/authorize";
    private static final String REDIRECT_URI = "https://www.facebook.com/connect/login_success.html";
    private static Boolean hasSSO;
    private Activity act;
    private String appId;
    private WebDialog dialog;
    private boolean first;
    private String message;
    private String permissions;
    private int requestId;
    private boolean sso;
    private String token;

    public FacebookHandle(Activity paramActivity, String paramString1, String paramString2) {
        this(paramActivity, paramString1, paramString2, null);
    }

    public FacebookHandle(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
        this.appId = paramString1;
        this.act = paramActivity;
        this.permissions = paramString2;
        this.token = paramString3;
        if ((this.token == null) && (permissionOk(paramString2, fetchPermission()))) {
            this.token = fetchToken();
        }
        if (this.token == null) {
        }
        for (boolean bool = true; ; bool = false) {
            this.first = bool;
            return;
        }
    }

    private static Bundle decodeUrl(String paramString) {
        Bundle localBundle = new Bundle();
        int j;
        int i;
        if (paramString != null) {
            paramString = paramString.split("&");
            j = paramString.length;
            i = 0;
        }
        for (; ; ) {
            if (i >= j) {
                return localBundle;
            }
            String[] arrayOfString = paramString[i].split("=");
            localBundle.putString(arrayOfString[0], arrayOfString[1]);
            i += 1;
        }
    }

    private void dismiss() {
        if (this.dialog != null) {
            new AQuery(this.act).dismiss(this.dialog);
            this.dialog = null;
        }
    }

    private static String encodeUrl(Bundle paramBundle) {
        if (paramBundle == null) {
            return "";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 1;
        Iterator localIterator = paramBundle.keySet().iterator();
        if (!localIterator.hasNext()) {
            return localStringBuilder.toString();
        }
        String str = (String) localIterator.next();
        if (i != 0) {
            i = 0;
        }
        for (; ; ) {
            localStringBuilder.append(str + "=" + paramBundle.getString(str));
            break;
            localStringBuilder.append("&");
        }
    }

    private String extractToken(String paramString) {
        paramString = Uri.parse(paramString.replace('#', '?')).getQueryParameter("access_token");
        AQUtility.debug("token", paramString);
        return paramString;
    }

    private void failure() {
        failure("cancel");
    }

    private void failure(String paramString) {
        dismiss();
        failure(this.act, -102, paramString);
    }

    private String fetchPermission() {
        return PreferenceManager.getDefaultSharedPreferences(this.act).getString("aq.fb.permission", null);
    }

    private String fetchToken() {
        return PreferenceManager.getDefaultSharedPreferences(this.act).getString("aq.fb.token", null);
    }

    public static String getToken(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("aq.fb.token", null);
    }

    private void hide() {
        if (this.dialog != null) {
        }
        try {
            this.dialog.hide();
            return;
        } catch (Exception localException) {
            AQUtility.debug(localException);
        }
    }

    private static Bundle parseUrl(String paramString) {
        try {
            paramString = new URL(paramString);
            Bundle localBundle = decodeUrl(paramString.getQuery());
            localBundle.putAll(decodeUrl(paramString.getRef()));
            return localBundle;
        } catch (MalformedURLException paramString) {
        }
        return new Bundle();
    }

    private boolean permissionOk(String paramString1, String paramString2) {
        if (paramString1 == null) {
        }
        for (; ; ) {
            return true;
            if (paramString2 == null) {
                return false;
            }
            paramString2 = new HashSet(Arrays.asList(paramString2.split("[,\\s]+")));
            paramString1 = paramString1.split("[,\\s]+");
            int i = 0;
            while (i < paramString1.length) {
                if (!paramString2.contains(paramString1[i])) {
                    AQUtility.debug("perm mismatch");
                    return false;
                }
                i += 1;
            }
        }
    }

    private void show() {
        if (this.dialog != null) {
            new AQuery(this.act).show(this.dialog);
        }
    }

    private boolean sso() {
        if (!this.sso) {
            return false;
        }
        return startSingleSignOn(this.act, this.appId, this.permissions, this.requestId);
    }

    private boolean startSingleSignOn(Activity paramActivity, String paramString1, String paramString2, int paramInt) {
        boolean bool = true;
        Intent localIntent = new Intent();
        localIntent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        localIntent.putExtra("client_id", paramString1);
        if (paramString2 != null) {
            localIntent.putExtra("scope", paramString2);
        }
        if (!validateAppSignatureForIntent(paramActivity, localIntent)) {
            return false;
        }
        try {
            paramActivity.startActivityForResult(localIntent, paramInt);
            return bool;
        } catch (ActivityNotFoundException paramActivity) {
            for (; ; ) {
                bool = false;
            }
        }
    }

    private void storeToken(String paramString1, String paramString2) {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.act).edit();
        localEditor.putString("aq.fb.token", paramString1).putString("aq.fb.permission", paramString2);
        AQUtility.apply(localEditor);
    }

    private boolean validateAppSignatureForIntent(Context paramContext, Intent paramIntent) {
        paramContext = paramContext.getPackageManager();
        paramIntent = paramContext.resolveActivity(paramIntent, 0);
        if (paramIntent == null) {
            return false;
        }
        paramIntent = paramIntent.activityInfo.packageName;
        for (; ; ) {
            int i;
            try {
                paramContext = paramContext.getPackageInfo(paramIntent, 64);
                paramContext = paramContext.signatures;
                int j = paramContext.length;
                i = 0;
                if (i >= j) {
                    break;
                }
                if (paramContext[i].toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException paramContext) {
                return false;
            }
            i += 1;
        }
    }

    private void webAuth() {
        AQUtility.debug("web auth");
        Object localObject = new Bundle();
        ((Bundle) localObject).putString("client_id", this.appId);
        ((Bundle) localObject).putString("type", "user_agent");
        if (this.permissions != null) {
            ((Bundle) localObject).putString("scope", this.permissions);
        }
        ((Bundle) localObject).putString("redirect_uri", "https://www.facebook.com/connect/login_success.html");
        localObject = "https://graph.facebook.com/oauth/authorize?" + encodeUrl((Bundle) localObject);
        FbWebViewClient localFbWebViewClient = new FbWebViewClient(null);
        this.dialog = new WebDialog(this.act, (String) localObject, localFbWebViewClient);
        this.dialog.setLoadingMessage(this.message);
        this.dialog.setOnCancelListener(localFbWebViewClient);
        show();
        if ((!this.first) || (this.token != null)) {
            AQUtility.debug("auth hide");
            hide();
        }
        this.dialog.load();
        AQUtility.debug("auth started");
    }

    public void ajaxProfile(AjaxCallback<JSONObject> paramAjaxCallback) {
        ajaxProfile(paramAjaxCallback, 0L);
    }

    public void ajaxProfile(AjaxCallback<JSONObject> paramAjaxCallback, long paramLong) {
        ((AQuery) new AQuery(this.act).auth(this)).ajax("https://graph.facebook.com/me", JSONObject.class, paramLong, paramAjaxCallback);
    }

    protected void auth() {
        if (this.act.isFinishing()) {
        }
        boolean bool;
        do {
            return;
            bool = sso();
            AQUtility.debug("authing", Boolean.valueOf(bool));
        } while (bool);
        webAuth();
    }

    protected void authenticated(String paramString) {
    }

    public boolean authenticated() {
        return this.token != null;
    }

    public boolean expired(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, AjaxStatus paramAjaxStatus) {
        int i = paramAjaxStatus.getCode();
        if (i == 200) {
        }
        do {
            return false;
            paramAjaxStatus = paramAjaxStatus.getError();
            if ((paramAjaxStatus != null) && (paramAjaxStatus.contains("OAuthException"))) {
                AQUtility.debug("fb token expired");
                return true;
            }
            paramAbstractAjaxCallback = paramAbstractAjaxCallback.getUrl();
        }
        while (((i == 400) && ((paramAbstractAjaxCallback.endsWith("/likes")) || (paramAbstractAjaxCallback.endsWith("/comments")) || (paramAbstractAjaxCallback.endsWith("/checkins")))) || ((i == 403) && ((paramAbstractAjaxCallback.endsWith("/feed")) || (paramAbstractAjaxCallback.contains("method=delete")))) || ((i != 400) && (i != 401) && (i != 403)));
        return true;
    }

    public String getCacheUrl(String paramString) {
        return getNetworkUrl(paramString);
    }

    public String getNetworkUrl(String paramString) {
        if (paramString.indexOf('?') == -1) {
        }
        for (paramString = paramString + "?"; ; paramString = paramString + "&") {
            return paramString + "access_token=" + this.token;
        }
    }

    public String getToken() {
        return this.token;
    }

    public boolean isSSOAvailable() {
        if (hasSSO == null) {
            Intent localIntent = new Intent();
            localIntent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
            hasSSO = Boolean.valueOf(validateAppSignatureForIntent(this.act, localIntent));
        }
        return hasSSO.booleanValue();
    }

    public FacebookHandle message(String paramString) {
        this.message = paramString;
        return this;
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        AQUtility.debug("on result", Integer.valueOf(paramInt2));
        if (paramInt2 == -1) {
            str2 = paramIntent.getStringExtra("error");
            str1 = str2;
            if (str2 == null) {
                str1 = paramIntent.getStringExtra("error_type");
            }
            if (str1 != null) {
                AQUtility.debug("error", str1);
                if ((str1.equals("service_disabled")) || (str1.equals("AndroidAuthKillSwitchException"))) {
                    webAuth();
                }
            }
        }
        while (paramInt2 != 0) {
            String str2;
            String str1;
            return;
            paramIntent = paramIntent.getStringExtra("error_description");
            AQUtility.debug("fb error", paramIntent);
            Log.e("fb error", paramIntent);
            failure(paramIntent);
            return;
            this.token = paramIntent.getStringExtra("access_token");
            AQUtility.debug("onComplete", this.token);
            if (this.token != null) {
                storeToken(this.token, this.permissions);
                this.first = false;
                authenticated(this.token);
                success(this.act);
                return;
            }
            failure();
            return;
        }
        failure();
    }

    public boolean reauth(final AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback) {
        AQUtility.debug("reauth requested");
        this.token = null;
        AQUtility.post(new Runnable() {
            public void run() {
                FacebookHandle.this.auth(paramAbstractAjaxCallback);
            }
        });
        return false;
    }

    public FacebookHandle setLoadingMessage(int paramInt) {
        this.message = this.act.getString(paramInt);
        return this;
    }

    public FacebookHandle sso(int paramInt) {
        this.sso = true;
        this.requestId = paramInt;
        return this;
    }

    public void unauth() {
        this.token = null;
        CookieSyncManager.createInstance(this.act);
        CookieManager.getInstance().removeAllCookie();
        storeToken(null, null);
    }

    private class FbWebViewClient
            extends WebViewClient
            implements DialogInterface.OnCancelListener {
        private FbWebViewClient() {
        }

        private boolean checkDone(String paramString) {
            if (paramString.startsWith("https://www.facebook.com/connect/login_success.html")) {
                String str = FacebookHandle.parseUrl(paramString).getString("error_reason");
                AQUtility.debug("error", str);
                if (str == null) {
                    FacebookHandle.this.token = FacebookHandle.this.extractToken(paramString);
                }
                if (FacebookHandle.this.token != null) {
                    FacebookHandle.this.dismiss();
                    FacebookHandle.this.storeToken(FacebookHandle.this.token, FacebookHandle.this.permissions);
                    FacebookHandle.this.first = false;
                    FacebookHandle.this.authenticated(FacebookHandle.this.token);
                    FacebookHandle.this.success(FacebookHandle.this.act);
                    return true;
                }
                FacebookHandle.this.failure();
                return true;
            }
            if (paramString.startsWith("fbconnect:cancel")) {
                AQUtility.debug("cancelled");
                FacebookHandle.this.failure();
                return true;
            }
            return false;
        }

        public void onCancel(DialogInterface paramDialogInterface) {
            FacebookHandle.this.failure();
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            super.onPageFinished(paramWebView, paramString);
            FacebookHandle.this.show();
            AQUtility.debug("finished", paramString);
        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            AQUtility.debug("started", paramString);
            if (!checkDone(paramString)) {
                super.onPageStarted(paramWebView, paramString, paramBitmap);
            }
        }

        public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
            FacebookHandle.this.failure();
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            AQUtility.debug("return url: " + paramString);
            return checkDone(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/auth/FacebookHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */