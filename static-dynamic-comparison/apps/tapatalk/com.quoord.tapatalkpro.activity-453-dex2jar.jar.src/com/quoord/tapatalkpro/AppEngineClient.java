package com.quoord.tapatalkpro;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class AppEngineClient {
    private static final String AUTH_TOKEN_TYPE = "ah";
    private static final String AUTH_URL = "https://chrometophone.appspot.com/_ah/login";
    static final String BASE_URL = "https://chrometophone.appspot.com";
    private static final String TAG = "AppEngineClient";
    private final String mAccountName;
    private final Context mContext;

    public AppEngineClient(Context paramContext, String paramString) {
        this.mContext = paramContext;
        this.mAccountName = paramString;
    }

    private String getAuthToken(Context paramContext, Account paramAccount)
            throws AppEngineClient.PendingAuthException {
        Object localObject5 = null;
        Object localObject6 = null;
        Object localObject4 = null;
        paramContext = AccountManager.get(paramContext);
        Object localObject1 = localObject4;
        Object localObject2 = localObject5;
        Object localObject3 = localObject6;
        try {
            paramAccount = (Bundle) paramContext.getAuthToken(paramAccount, "ah", false, null, null).getResult();
            localObject1 = localObject4;
            localObject2 = localObject5;
            localObject3 = localObject6;
            paramContext = paramAccount.getString("authtoken");
            localObject1 = paramContext;
            if (paramContext == null) {
                localObject1 = paramContext;
                localObject2 = paramContext;
                localObject3 = paramContext;
                throw new PendingAuthException(paramAccount);
            }
        } catch (OperationCanceledException paramContext) {
            Log.w("AppEngineClient", paramContext.getMessage());
            return (String) localObject1;
        } catch (AuthenticatorException paramContext) {
            Log.w("AppEngineClient", paramContext.getMessage());
            return (String) localObject2;
        } catch (IOException paramContext) {
            Log.w("AppEngineClient", paramContext.getMessage());
        }
        return (String) localObject3;
    }

    private HttpResponse makeRequestNoRetry(String paramString, List<NameValuePair> paramList, boolean paramBoolean)
            throws Exception {
        Object localObject3 = new Account(this.mAccountName, "com.google");
        Object localObject2 = getAuthToken(this.mContext, (Account) localObject3);
        Object localObject1 = localObject2;
        if (paramBoolean) {
            AccountManager.get(this.mContext).invalidateAuthToken(((Account) localObject3).type, (String) localObject2);
            localObject1 = getAuthToken(this.mContext, (Account) localObject3);
        }
        localObject2 = new DefaultHttpClient();
        localObject1 = new HttpGet(new URI("https://chrometophone.appspot.com/_ah/login?continue=" + URLEncoder.encode("https://chrometophone.appspot.com", "UTF-8") + "&auth=" + (String) localObject1));
        localObject3 = new BasicHttpParams();
        HttpClientParams.setRedirecting((HttpParams) localObject3, false);
        ((HttpGet) localObject1).setParams((HttpParams) localObject3);
        localObject1 = ((DefaultHttpClient) localObject2).execute((HttpUriRequest) localObject1);
        localObject3 = ((HttpResponse) localObject1).getHeaders("Set-Cookie");
        if ((((HttpResponse) localObject1).getStatusLine().getStatusCode() != 302) || (localObject3.length == 0)) {
            return (HttpResponse) localObject1;
        }
        localObject1 = null;
        int j = localObject3.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                paramString = new HttpPost(new URI("https://chrometophone.appspot.com" + paramString));
                paramString.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
                paramString.setHeader("Cookie", (String) localObject1);
                paramString.setHeader("X-Same-Domain", "1");
                return ((DefaultHttpClient) localObject2).execute(paramString);
            }
            Object localObject4 = localObject3[i];
            if (((Header) localObject4).getValue().indexOf("ACSID=") >= 0) {
                localObject1 = localObject4.getValue().split(";")[0];
            }
            i += 1;
        }
    }

    public HttpResponse makeRequest(String paramString, List<NameValuePair> paramList)
            throws Exception {
        HttpResponse localHttpResponse2 = makeRequestNoRetry(paramString, paramList, false);
        HttpResponse localHttpResponse1 = localHttpResponse2;
        if (localHttpResponse2.getStatusLine().getStatusCode() == 500) {
            localHttpResponse1 = makeRequestNoRetry(paramString, paramList, true);
        }
        return localHttpResponse1;
    }

    public class PendingAuthException
            extends Exception {
        private static final long serialVersionUID = 1L;
        private final Bundle mAccountManagerBundle;

        public PendingAuthException(Bundle paramBundle) {
            this.mAccountManagerBundle = paramBundle;
        }

        public Bundle getAccountManagerBundle() {
            return this.mAccountManagerBundle;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/AppEngineClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */