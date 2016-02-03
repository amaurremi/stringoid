package com.millennialmedia.android;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

class CachedVideoPlayerActivity$FetchWebViewContentTask
        extends AsyncTask<Void, Void, String> {
    private String b;
    private boolean c;

    public CachedVideoPlayerActivity$FetchWebViewContentTask(CachedVideoPlayerActivity paramCachedVideoPlayerActivity, String paramString) {
        this.b = paramString;
    }

    protected String a(Void... paramVarArgs) {
        try {
            paramVarArgs = new HttpGetRequest().a(this.b);
            StatusLine localStatusLine = paramVarArgs.getStatusLine();
            if ((paramVarArgs != null) && (localStatusLine != null) && (localStatusLine.getStatusCode() != 404)) {
                paramVarArgs = paramVarArgs.getEntity();
                if (paramVarArgs != null) {
                    return HttpGetRequest.a(paramVarArgs.getContent());
                }
            } else {
                this.c = true;
            }
        } catch (Exception paramVarArgs) {
            for (; ; ) {
                MMLog.a("CachedVideoPlayerActivity", "Error with http web overlay", paramVarArgs);
            }
        }
        return null;
    }

    protected void a(String paramString) {
        if (this.c) {
            this.a.m();
        }
        if ((paramString != null) && (CachedVideoPlayerActivity.a(this.a) != null)) {
            CachedVideoPlayerActivity.a(this.a).a(paramString, this.b, this.a.c);
            this.a.b = true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/CachedVideoPlayerActivity$FetchWebViewContentTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */