package com.facebook.android;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.LegacyHelper;
import com.facebook.Session;
import com.facebook.Session.Builder;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.TokenCachingStrategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Facebook {
    @Deprecated
    public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    @Deprecated
    public static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    @Deprecated
    public static final String CANCEL_URI = "fbconnect://cancel";
    private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;
    @Deprecated
    protected static String DIALOG_BASE_URL = "https://m.facebook.com/dialog/";
    @Deprecated
    public static final String EXPIRES = "expires_in";
    @Deprecated
    public static final String FB_APP_SIGNATURE = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
    @Deprecated
    public static final int FORCE_DIALOG_AUTH = -1;
    @Deprecated
    protected static String GRAPH_BASE_URL = "https://graph.facebook.com/";
    private static final String LOGIN = "oauth";
    @Deprecated
    public static final String REDIRECT_URI = "fbconnect://success";
    @Deprecated
    protected static String RESTSERVER_URL = "https://api.facebook.com/restserver.php";
    @Deprecated
    public static final String SINGLE_SIGN_ON_DISABLED = "service_disabled";
    @Deprecated
    public static final String TOKEN = "access_token";
    private final long REFRESH_TOKEN_BARRIER = 86400000L;
    private long accessExpiresMillisecondsAfterEpoch = 0L;
    private String accessToken = null;
    private long lastAccessUpdateMillisecondsAfterEpoch = 0L;
    private final Object lock = new Object();
    private String mAppId;
    private Activity pendingAuthorizationActivity;
    private String[] pendingAuthorizationPermissions;
    private Session pendingOpeningSession;
    private volatile Session session;
    private boolean sessionInvalidated;
    private SetterTokenCachingStrategy tokenCache;
    private volatile Session userSetSession;

    @Deprecated
    public Facebook(String paramString) {
        if (paramString == null) {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        }
        this.mAppId = paramString;
    }

    private void authorize(Activity paramActivity, String[] paramArrayOfString, int paramInt, SessionLoginBehavior paramSessionLoginBehavior, final DialogListener paramDialogListener) {
        checkUserSession("authorize");
        this.pendingOpeningSession = new Session.Builder(paramActivity).setApplicationId(this.mAppId).setTokenCachingStrategy(getTokenCache()).build();
        this.pendingAuthorizationActivity = paramActivity;
        String[] arrayOfString;
        if (paramArrayOfString != null) {
            arrayOfString = paramArrayOfString;
            this.pendingAuthorizationPermissions = arrayOfString;
            paramDialogListener = new Session.StatusCallback() {
                public void call(Session paramAnonymousSession, SessionState paramAnonymousSessionState, Exception paramAnonymousException) {
                    Facebook.this.onSessionCallback(paramAnonymousSession, paramAnonymousSessionState, paramAnonymousException, paramDialogListener);
                }
            };
            paramActivity = new Session.OpenRequest(paramActivity).setCallback(paramDialogListener).setLoginBehavior(paramSessionLoginBehavior).setRequestCode(paramInt).setPermissions(Arrays.asList(paramArrayOfString));
            paramArrayOfString = this.pendingOpeningSession;
            if (this.pendingAuthorizationPermissions.length <= 0) {
                break label129;
            }
        }
        label129:
        for (boolean bool = true; ; bool = false) {
            openSession(paramArrayOfString, paramActivity, bool);
            return;
            arrayOfString = new String[0];
            break;
        }
    }

    private void checkUserSession(String paramString) {
        if (this.userSetSession != null) {
            throw new UnsupportedOperationException(String.format("Cannot call %s after setSession has been called.", new Object[]{paramString}));
        }
    }

    @Deprecated
    public static String getAttributionId(ContentResolver paramContentResolver) {
        return Settings.getAttributionId(paramContentResolver);
    }

    private TokenCachingStrategy getTokenCache() {
        if (this.tokenCache == null) {
            this.tokenCache = new SetterTokenCachingStrategy(null);
        }
        return this.tokenCache;
    }

    private void onSessionCallback(Session paramSession, SessionState paramSessionState, Exception arg3, DialogListener paramDialogListener) {
        Bundle localBundle = paramSession.getAuthorizationBundle();
        if (paramSessionState == SessionState.OPENED) {
            paramSessionState = null;
        }
        while (???==null){
            synchronized (this.lock) {
                if (paramSession != this.session) {
                    paramSessionState = this.session;
                    this.session = paramSession;
                    this.sessionInvalidated = false;
                }
                if (paramSessionState != null) {
                    paramSessionState.close();
                }
                paramDialogListener.onComplete(localBundle);
                return;
            }
        }
        if (( ???instanceof FacebookOperationCanceledException))
        {
            paramDialogListener.onCancel();
            return;
        }
        if ((( ? ??instanceof FacebookAuthorizationException))&&
        (localBundle != null) && (localBundle.containsKey("com.facebook.sdk.WebViewErrorCode")) && (localBundle.containsKey("com.facebook.sdk.FailingUrl")))
        {
            paramDialogListener.onError(new DialogError( ? ??.
            getMessage(), localBundle.getInt("com.facebook.sdk.WebViewErrorCode"), localBundle.getString("com.facebook.sdk.FailingUrl")))
            ;
            return;
        }
        paramDialogListener.onFacebookError(new FacebookError( ? ??.getMessage()));
    }

    private void openSession(Session paramSession, Session.OpenRequest paramOpenRequest, boolean paramBoolean) {
        paramOpenRequest.setIsLegacy(true);
        if (paramBoolean) {
            paramSession.openForPublish(paramOpenRequest);
            return;
        }
        paramSession.openForRead(paramOpenRequest);
    }

    private static String[] stringArray(List<String> paramList) {
        String[] arrayOfString = new String[paramList.size()];
        int i;
        if (paramList != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= arrayOfString.length) {
                return arrayOfString;
            }
            arrayOfString[i] = ((String) paramList.get(i));
            i += 1;
        }
    }

    private static List<String> stringList(String[] paramArrayOfString) {
        if (paramArrayOfString != null) {
            return Arrays.asList(paramArrayOfString);
        }
        return Collections.emptyList();
    }

    private boolean validateAppSignatureForPackage(Context paramContext, String paramString) {
        for (; ; ) {
            int i;
            try {
                paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
                paramContext = paramContext.signatures;
                int j = paramContext.length;
                i = 0;
                if (i >= j) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException paramContext) {
                return false;
            }
            if (paramContext[i].toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                return true;
            }
            i += 1;
        }
    }

    private boolean validateServiceIntent(Context paramContext, Intent paramIntent) {
        paramIntent = paramContext.getPackageManager().resolveService(paramIntent, 0);
        if (paramIntent == null) {
            return false;
        }
        return validateAppSignatureForPackage(paramContext, paramIntent.serviceInfo.packageName);
    }

    @Deprecated
    public void authorize(Activity paramActivity, DialogListener paramDialogListener) {
        SessionLoginBehavior localSessionLoginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK;
        authorize(paramActivity, new String[0], 32665, localSessionLoginBehavior, paramDialogListener);
    }

    @Deprecated
    public void authorize(Activity paramActivity, String[] paramArrayOfString, int paramInt, DialogListener paramDialogListener) {
        if (paramInt >= 0) {
        }
        for (SessionLoginBehavior localSessionLoginBehavior = SessionLoginBehavior.SSO_WITH_FALLBACK; ; localSessionLoginBehavior = SessionLoginBehavior.SUPPRESS_SSO) {
            authorize(paramActivity, paramArrayOfString, paramInt, localSessionLoginBehavior, paramDialogListener);
            return;
        }
    }

    @Deprecated
    public void authorize(Activity paramActivity, String[] paramArrayOfString, DialogListener paramDialogListener) {
        authorize(paramActivity, paramArrayOfString, 32665, SessionLoginBehavior.SSO_WITH_FALLBACK, paramDialogListener);
    }

    @Deprecated
    public void authorizeCallback(int paramInt1, int paramInt2, Intent paramIntent) {
        checkUserSession("authorizeCallback");
        Session localSession = this.pendingOpeningSession;
        if ((localSession != null) && (localSession.onActivityResult(this.pendingAuthorizationActivity, paramInt1, paramInt2, paramIntent))) {
            this.pendingOpeningSession = null;
            this.pendingAuthorizationActivity = null;
            this.pendingAuthorizationPermissions = null;
        }
    }

    @Deprecated
    public void dialog(Context paramContext, String paramString, Bundle paramBundle, DialogListener paramDialogListener) {
        paramBundle.putString("display", "touch");
        paramBundle.putString("redirect_uri", "fbconnect://success");
        if (paramString.equals("oauth")) {
            paramBundle.putString("type", "user_agent");
            paramBundle.putString("client_id", this.mAppId);
        }
        while (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            Util.showAlert(paramContext, "Error", "Application requires permission to access the Internet");
            return;
            paramBundle.putString("app_id", this.mAppId);
            if (isSessionValid()) {
                paramBundle.putString("access_token", getAccessToken());
            }
        }
        new FbDialog(paramContext, paramString, paramBundle, paramDialogListener).show();
    }

    @Deprecated
    public void dialog(Context paramContext, String paramString, DialogListener paramDialogListener) {
        dialog(paramContext, paramString, new Bundle(), paramDialogListener);
    }

    @Deprecated
    public boolean extendAccessToken(Context paramContext, ServiceListener paramServiceListener) {
        checkUserSession("extendAccessToken");
        Intent localIntent = new Intent();
        localIntent.setClassName("com.facebook.katana", "com.facebook.katana.platform.TokenRefreshService");
        if (!validateServiceIntent(paramContext, localIntent)) {
            return false;
        }
        return paramContext.bindService(localIntent, new TokenRefreshServiceConnection(paramContext, paramServiceListener), 1);
    }

    @Deprecated
    public boolean extendAccessTokenIfNeeded(Context paramContext, ServiceListener paramServiceListener) {
        checkUserSession("extendAccessTokenIfNeeded");
        if (shouldExtendAccessToken()) {
            return extendAccessToken(paramContext, paramServiceListener);
        }
        return true;
    }

    @Deprecated
    public long getAccessExpires() {
        Session localSession = getSession();
        if (localSession != null) {
            return localSession.getExpirationDate().getTime();
        }
        return this.accessExpiresMillisecondsAfterEpoch;
    }

    @Deprecated
    public String getAccessToken() {
        Session localSession = getSession();
        if (localSession != null) {
            return localSession.getAccessToken();
        }
        return null;
    }

    @Deprecated
    public String getAppId() {
        return this.mAppId;
    }

    @Deprecated
    public long getLastAccessUpdate() {
        return this.lastAccessUpdateMillisecondsAfterEpoch;
    }

    @Deprecated
    public final Session getSession() {
        for (; ; ) {
            synchronized (this.lock) {
                Session localSession1;
                if (this.userSetSession != null) {
                    localSession1 = this.userSetSession;
                    return localSession1;
                }
                if ((this.session != null) || (!this.sessionInvalidated)) {
                    localSession1 = this.session;
                    return localSession1;
                }
            }
            Object localObject4 = this.accessToken;
            Session localSession2 = this.session;
            if (localObject4 == null) {
                return null;
            }
            if (localSession2 != null) {
                ???=localSession2.getPermissions();
            }
            for (; ; ) {
                localSession2 = new Session.Builder(this.pendingAuthorizationActivity).setApplicationId(this.mAppId).setTokenCachingStrategy(getTokenCache()).build();
                if (localSession2.getState() == SessionState.CREATED_TOKEN_LOADED) {
                    break;
                }
                return null;
                if (this.pendingAuthorizationPermissions != null) {
                    ???=Arrays.asList(this.pendingAuthorizationPermissions);
                } else {
                    ???=Collections.emptyList();
                }
            }
            localObject4 = new Session.OpenRequest(this.pendingAuthorizationActivity).setPermissions((List) ? ??);
            boolean bool;
            if (((List) ? ??).isEmpty())
            {
                bool = false;
                openSession(localSession2, (Session.OpenRequest) localObject4, bool);
                ???=null;
                localObject4 = null;
            }
            synchronized (this.lock) {
                if ((this.sessionInvalidated) || (this.session == null)) {
                    ???=this.session;
                    this.session = localSession2;
                    localObject4 = localSession2;
                    this.sessionInvalidated = false;
                }
                if (???!=null){
                    ((Session) ? ??).close();
                }
                if (localObject4 == null) {
                    continue;
                }
                return (Session) localObject4;
                bool = true;
            }
        }
    }

    @Deprecated
    public boolean getShouldAutoPublishInstall() {
        return Settings.getShouldAutoPublishInstall();
    }

    @Deprecated
    public boolean isSessionValid() {
        return (getAccessToken() != null) && ((getAccessExpires() == 0L) || (System.currentTimeMillis() < getAccessExpires()));
    }

    @Deprecated
    public String logout(Context paramContext)
            throws MalformedURLException, IOException {
        return logoutImpl(paramContext);
    }

    String logoutImpl(Context arg1)
            throws MalformedURLException, IOException {
        checkUserSession("logout");
        ???=new Bundle();
        ???.putString("method", "auth.expireSession");
        String str = request( ???);
        long l = System.currentTimeMillis();
        synchronized (this.lock) {
            Session localSession = this.session;
            this.session = null;
            this.accessToken = null;
            this.accessExpiresMillisecondsAfterEpoch = 0L;
            this.lastAccessUpdateMillisecondsAfterEpoch = l;
            this.sessionInvalidated = false;
            if (localSession != null) {
                localSession.closeAndClearTokenInformation();
            }
            return str;
        }
    }

    @Deprecated
    public boolean publishInstall(Context paramContext) {
        Settings.publishInstallAsync(paramContext, this.mAppId);
        return false;
    }

    @Deprecated
    public String request(Bundle paramBundle)
            throws MalformedURLException, IOException {
        if (!paramBundle.containsKey("method")) {
            throw new IllegalArgumentException("API method must be specified. (parameters must contain key \"method\" and value). See http://developers.facebook.com/docs/reference/rest/");
        }
        return requestImpl(null, paramBundle, "GET");
    }

    @Deprecated
    public String request(String paramString)
            throws MalformedURLException, IOException {
        return requestImpl(paramString, new Bundle(), "GET");
    }

    @Deprecated
    public String request(String paramString, Bundle paramBundle)
            throws MalformedURLException, IOException {
        return requestImpl(paramString, paramBundle, "GET");
    }

    @Deprecated
    public String request(String paramString1, Bundle paramBundle, String paramString2)
            throws FileNotFoundException, MalformedURLException, IOException {
        return requestImpl(paramString1, paramBundle, paramString2);
    }

    String requestImpl(String paramString1, Bundle paramBundle, String paramString2)
            throws FileNotFoundException, MalformedURLException, IOException {
        paramBundle.putString("format", "json");
        if (isSessionValid()) {
            paramBundle.putString("access_token", getAccessToken());
        }
        if (paramString1 != null) {
        }
        for (paramString1 = GRAPH_BASE_URL + paramString1; ; paramString1 = RESTSERVER_URL) {
            return Util.openUrl(paramString1, paramString2, paramBundle);
        }
    }

    @Deprecated
    public void setAccessExpires(long paramLong) {
        checkUserSession("setAccessExpires");
        synchronized (this.lock) {
            this.accessExpiresMillisecondsAfterEpoch = paramLong;
            this.lastAccessUpdateMillisecondsAfterEpoch = System.currentTimeMillis();
            this.sessionInvalidated = true;
            return;
        }
    }

    @Deprecated
    public void setAccessExpiresIn(String paramString) {
        checkUserSession("setAccessExpiresIn");
        if (paramString != null) {
            if (!paramString.equals("0")) {
                break label29;
            }
        }
        label29:
        for (long l = 0L; ; l = System.currentTimeMillis() + Long.parseLong(paramString) * 1000L) {
            setAccessExpires(l);
            return;
        }
    }

    @Deprecated
    public void setAccessToken(String paramString) {
        checkUserSession("setAccessToken");
        synchronized (this.lock) {
            this.accessToken = paramString;
            this.lastAccessUpdateMillisecondsAfterEpoch = System.currentTimeMillis();
            this.sessionInvalidated = true;
            return;
        }
    }

    @Deprecated
    public void setAppId(String paramString) {
        checkUserSession("setAppId");
        synchronized (this.lock) {
            this.mAppId = paramString;
            this.sessionInvalidated = true;
            return;
        }
    }

    @Deprecated
    public void setSession(Session paramSession) {
        if (paramSession == null) {
            throw new IllegalArgumentException("session cannot be null");
        }
        synchronized (this.lock) {
            this.userSetSession = paramSession;
            return;
        }
    }

    @Deprecated
    public void setShouldAutoPublishInstall(boolean paramBoolean) {
        Settings.setShouldAutoPublishInstall(paramBoolean);
    }

    @Deprecated
    public void setTokenFromCache(String paramString, long paramLong1, long paramLong2) {
        checkUserSession("setTokenFromCache");
        synchronized (this.lock) {
            this.accessToken = paramString;
            this.accessExpiresMillisecondsAfterEpoch = paramLong1;
            this.lastAccessUpdateMillisecondsAfterEpoch = paramLong2;
            return;
        }
    }

    @Deprecated
    public boolean shouldExtendAccessToken() {
        checkUserSession("shouldExtendAccessToken");
        return (isSessionValid()) && (System.currentTimeMillis() - this.lastAccessUpdateMillisecondsAfterEpoch >= 86400000L);
    }

    public static abstract interface DialogListener {
        public abstract void onCancel();

        public abstract void onComplete(Bundle paramBundle);

        public abstract void onError(DialogError paramDialogError);

        public abstract void onFacebookError(FacebookError paramFacebookError);
    }

    public static abstract interface ServiceListener {
        public abstract void onComplete(Bundle paramBundle);

        public abstract void onError(Error paramError);

        public abstract void onFacebookError(FacebookError paramFacebookError);
    }

    private class SetterTokenCachingStrategy
            extends TokenCachingStrategy {
        private SetterTokenCachingStrategy() {
        }

        public void clear() {
            Facebook.this.accessToken = null;
        }

        public Bundle load() {
            Bundle localBundle = new Bundle();
            if (Facebook.this.accessToken != null) {
                TokenCachingStrategy.putToken(localBundle, Facebook.this.accessToken);
                TokenCachingStrategy.putExpirationMilliseconds(localBundle, Facebook.this.accessExpiresMillisecondsAfterEpoch);
                TokenCachingStrategy.putPermissions(localBundle, Facebook.stringList(Facebook.this.pendingAuthorizationPermissions));
                TokenCachingStrategy.putSource(localBundle, AccessTokenSource.WEB_VIEW);
                TokenCachingStrategy.putLastRefreshMilliseconds(localBundle, Facebook.this.lastAccessUpdateMillisecondsAfterEpoch);
            }
            return localBundle;
        }

        public void save(Bundle paramBundle) {
            Facebook.this.accessToken = TokenCachingStrategy.getToken(paramBundle);
            Facebook.this.accessExpiresMillisecondsAfterEpoch = TokenCachingStrategy.getExpirationMilliseconds(paramBundle);
            Facebook.this.pendingAuthorizationPermissions = Facebook.stringArray(TokenCachingStrategy.getPermissions(paramBundle));
            Facebook.this.lastAccessUpdateMillisecondsAfterEpoch = TokenCachingStrategy.getLastRefreshMilliseconds(paramBundle);
        }
    }

    private static class TokenRefreshConnectionHandler
            extends Handler {
        WeakReference<Facebook.TokenRefreshServiceConnection> connectionWeakReference;
        WeakReference<Facebook> facebookWeakReference;

        TokenRefreshConnectionHandler(Facebook paramFacebook, Facebook.TokenRefreshServiceConnection paramTokenRefreshServiceConnection) {
            this.facebookWeakReference = new WeakReference(paramFacebook);
            this.connectionWeakReference = new WeakReference(paramTokenRefreshServiceConnection);
        }

        public void handleMessage(Message paramMessage) {
            Object localObject1 = (Facebook) this.facebookWeakReference.get();
            Facebook.TokenRefreshServiceConnection localTokenRefreshServiceConnection = (Facebook.TokenRefreshServiceConnection) this.connectionWeakReference.get();
            if ((localObject1 == null) || (localTokenRefreshServiceConnection == null)) {
                return;
            }
            Object localObject2 = paramMessage.getData().getString("access_token");
            long l = paramMessage.getData().getLong("expires_in") * 1000L;
            if (localObject2 != null) {
                ((Facebook) localObject1).setAccessToken((String) localObject2);
                ((Facebook) localObject1).setAccessExpires(l);
                localObject1 = ((Facebook) localObject1).session;
                if (localObject1 != null) {
                    LegacyHelper.extendTokenCompleted((Session) localObject1, paramMessage.getData());
                }
                if (localTokenRefreshServiceConnection.serviceListener != null) {
                    paramMessage = (Bundle) paramMessage.getData().clone();
                    paramMessage.putLong("expires_in", l);
                    localTokenRefreshServiceConnection.serviceListener.onComplete(paramMessage);
                }
            }
            label136:
            while (localTokenRefreshServiceConnection != null) {
                localTokenRefreshServiceConnection.applicationsContext.unbindService(localTokenRefreshServiceConnection);
                return;
                if (localTokenRefreshServiceConnection.serviceListener != null) {
                    localObject1 = paramMessage.getData().getString("error");
                    if (paramMessage.getData().containsKey("error_code")) {
                        int i = paramMessage.getData().getInt("error_code");
                        localTokenRefreshServiceConnection.serviceListener.onFacebookError(new FacebookError((String) localObject1, null, i));
                    } else {
                        localObject2 = localTokenRefreshServiceConnection.serviceListener;
                        if (localObject1 == null) {
                            break label250;
                        }
                    }
                }
            }
            label250:
            for (paramMessage = (Message) localObject1; ; paramMessage = "Unknown service error") {
                ((Facebook.ServiceListener) localObject2).onError(new Error(paramMessage));
                break label136;
                break;
            }
        }
    }

    private class TokenRefreshServiceConnection
            implements ServiceConnection {
        final Context applicationsContext;
        final Messenger messageReceiver = new Messenger(new Facebook.TokenRefreshConnectionHandler(Facebook.this, this));
        Messenger messageSender = null;
        final Facebook.ServiceListener serviceListener;

        public TokenRefreshServiceConnection(Context paramContext, Facebook.ServiceListener paramServiceListener) {
            this.applicationsContext = paramContext;
            this.serviceListener = paramServiceListener;
        }

        private void refreshToken() {
            Bundle localBundle = new Bundle();
            localBundle.putString("access_token", Facebook.this.accessToken);
            Message localMessage = Message.obtain();
            localMessage.setData(localBundle);
            localMessage.replyTo = this.messageReceiver;
            try {
                this.messageSender.send(localMessage);
                return;
            } catch (RemoteException localRemoteException) {
                this.serviceListener.onError(new Error("Service connection error"));
            }
        }

        public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
            this.messageSender = new Messenger(paramIBinder);
            refreshToken();
        }

        public void onServiceDisconnected(ComponentName paramComponentName) {
            this.serviceListener.onError(new Error("Service disconnected"));
            this.applicationsContext.unbindService(this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/android/Facebook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */