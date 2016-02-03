package com.androidquery.auth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.androidquery.AQuery;
import com.androidquery.WebDialog;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import java.net.HttpURLConnection;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import org.apache.http.HttpRequest;

public class TwitterHandle
        extends AccountHandle {
    private static final String CALLBACK_URI = "twitter://callback";
    private static final String CANCEL_URI = "twitter://cancel";
    private static final String OAUTH_ACCESS_TOKEN = "https://api.twitter.com/oauth/access_token";
    private static final String OAUTH_AUTHORIZE = "https://api.twitter.com/oauth/authorize";
    private static final String OAUTH_REQUEST_TOKEN = "https://api.twitter.com/oauth/request_token";
    private static final String TW_SECRET = "aq.tw.secret";
    private static final String TW_TOKEN = "aq.tw.token";
    private Activity act;
    private CommonsHttpOAuthConsumer consumer;
    private WebDialog dialog;
    private CommonsHttpOAuthProvider provider;
    private String secret;
    private String token;

    public TwitterHandle(Activity paramActivity, String paramString1, String paramString2) {
        this.act = paramActivity;
        this.consumer = new CommonsHttpOAuthConsumer(paramString1, paramString2);
        this.token = fetchToken("aq.tw.token");
        this.secret = fetchToken("aq.tw.secret");
        if ((this.token != null) && (this.secret != null)) {
            this.consumer.setTokenWithSecret(this.token, this.secret);
        }
        this.provider = new CommonsHttpOAuthProvider("https://api.twitter.com/oauth/request_token", "https://api.twitter.com/oauth/access_token", "https://api.twitter.com/oauth/authorize");
    }

    private void dismiss() {
        if (this.dialog != null) {
            new AQuery(this.act).dismiss(this.dialog);
            this.dialog = null;
        }
    }

    private String extract(String paramString1, String paramString2) {
        return Uri.parse(paramString1).getQueryParameter(paramString2);
    }

    private void failure() {
        dismiss();
        failure(this.act, 401, "cancel");
    }

    private String fetchToken(String paramString) {
        return PreferenceManager.getDefaultSharedPreferences(this.act).getString(paramString, null);
    }

    private void show() {
        if (this.dialog != null) {
            new AQuery(this.act).show(this.dialog);
        }
    }

    private void storeToken(String paramString1, String paramString2, String paramString3, String paramString4) {
        PreferenceManager.getDefaultSharedPreferences(this.act).edit().putString(paramString1, paramString2).putString(paramString3, paramString4).commit();
    }

    public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpURLConnection paramHttpURLConnection) {
        AQUtility.debug("apply token multipart", paramAbstractAjaxCallback.getUrl());
        paramAbstractAjaxCallback = new DefaultOAuthConsumer(this.consumer.getConsumerKey(), this.consumer.getConsumerSecret());
        paramAbstractAjaxCallback.setTokenWithSecret(this.consumer.getToken(), this.consumer.getTokenSecret());
        try {
            paramAbstractAjaxCallback.sign(paramHttpURLConnection);
            return;
        } catch (Exception paramAbstractAjaxCallback) {
            AQUtility.report(paramAbstractAjaxCallback);
        }
    }

    public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpRequest paramHttpRequest) {
        AQUtility.debug("apply token", paramAbstractAjaxCallback.getUrl());
        try {
            this.consumer.sign(paramHttpRequest);
            return;
        } catch (Exception paramAbstractAjaxCallback) {
            AQUtility.report(paramAbstractAjaxCallback);
        }
    }

    protected void auth() {
        new Task(null).execute(new String[0]);
    }

    public void authenticate(boolean paramBoolean) {
        if ((!paramBoolean) && (this.token != null) && (this.secret != null)) {
            authenticated(this.secret, this.token);
            return;
        }
        auth();
    }

    protected void authenticated(String paramString1, String paramString2) {
    }

    public boolean authenticated() {
        return (this.token != null) && (this.secret != null);
    }

    public boolean expired(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, AjaxStatus paramAjaxStatus) {
        int i = paramAjaxStatus.getCode();
        return (i == 400) || (i == 401);
    }

    public String getSecret() {
        return this.secret;
    }

    public String getToken() {
        return this.token;
    }

    public boolean reauth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback) {
        this.token = null;
        this.secret = null;
        storeToken("aq.tw.token", null, "aq.tw.secret", null);
        new Task(null).cb = paramAbstractAjaxCallback;
        AQUtility.post(paramAbstractAjaxCallback);
        return false;
    }

    public void unauth() {
        this.token = null;
        this.secret = null;
        CookieSyncManager.createInstance(this.act);
        CookieManager.getInstance().removeAllCookie();
        storeToken("aq.tw.token", null, "aq.tw.secret", null);
    }

    private class Task
            extends AsyncTask<String, String, String>
            implements DialogInterface.OnCancelListener, Runnable {
        private AbstractAjaxCallback<?, ?> cb;

        private Task() {
        }

        protected String doInBackground(String... paramVarArgs) {
            try {
                paramVarArgs = TwitterHandle.this.provider.retrieveRequestToken(TwitterHandle.this.consumer, "twitter://callback");
                return paramVarArgs;
            } catch (Exception paramVarArgs) {
                AQUtility.report(paramVarArgs);
            }
            return null;
        }

        public void onCancel(DialogInterface paramDialogInterface) {
            TwitterHandle.this.failure();
        }

        protected void onPostExecute(String paramString) {
            if (paramString != null) {
                TwitterHandle.this.dialog = new WebDialog(TwitterHandle.this.act, paramString, new TwitterHandle.TwWebViewClient(TwitterHandle.this, null));
                TwitterHandle.this.dialog.setOnCancelListener(this);
                TwitterHandle.this.show();
                TwitterHandle.this.dialog.load();
                return;
            }
            TwitterHandle.this.failure();
        }

        public void run() {
            TwitterHandle.this.auth(this.cb);
        }
    }

    private class Task2
            extends AsyncTask<String, String, String> {
        private Task2() {
        }

        protected String doInBackground(String... paramVarArgs) {
            try {
                TwitterHandle.this.provider.retrieveAccessToken(TwitterHandle.this.consumer, paramVarArgs[0]);
                return "";
            } catch (Exception paramVarArgs) {
                AQUtility.report(paramVarArgs);
            }
            return null;
        }

        protected void onPostExecute(String paramString) {
            if (paramString != null) {
                TwitterHandle.this.token = TwitterHandle.this.consumer.getToken();
                TwitterHandle.this.secret = TwitterHandle.this.consumer.getTokenSecret();
                AQUtility.debug("token", TwitterHandle.this.token);
                AQUtility.debug("secret", TwitterHandle.this.secret);
                TwitterHandle.this.storeToken("aq.tw.token", TwitterHandle.this.token, "aq.tw.secret", TwitterHandle.this.secret);
                TwitterHandle.this.dismiss();
                TwitterHandle.this.success(TwitterHandle.this.act);
                TwitterHandle.this.authenticated(TwitterHandle.this.secret, TwitterHandle.this.token);
                return;
            }
            TwitterHandle.this.failure();
            TwitterHandle.this.authenticated(null, null);
        }
    }

    private class TwWebViewClient
            extends WebViewClient {
        private TwWebViewClient() {
        }

        private boolean checkDone(String paramString) {
            if (paramString.startsWith("twitter://callback")) {
                paramString = TwitterHandle.this.extract(paramString, "oauth_verifier");
                TwitterHandle.this.dismiss();
                new TwitterHandle.Task2(TwitterHandle.this, null).execute(new String[]{paramString});
                return true;
            }
            if (paramString.startsWith("twitter://cancel")) {
                TwitterHandle.this.failure();
                return true;
            }
            return false;
        }

        public void onPageFinished(WebView paramWebView, String paramString) {
            AQUtility.debug("finished", paramString);
            super.onPageFinished(paramWebView, paramString);
            TwitterHandle.this.show();
        }

        public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {
            AQUtility.debug("started", paramString);
            if (!checkDone(paramString)) {
                super.onPageStarted(paramWebView, paramString, paramBitmap);
            }
        }

        public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {
            TwitterHandle.this.failure();
        }

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            return checkDone(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/auth/TwitterHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */