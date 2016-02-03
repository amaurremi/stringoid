package com.facebook;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.internal.Utility;

class Session$AutoPublishAsyncTask
        extends AsyncTask<Void, Void, Void> {
    private final Context mApplicationContext;
    private final String mApplicationId;

    public Session$AutoPublishAsyncTask(Session paramSession, String paramString, Context paramContext) {
        this.mApplicationId = paramString;
        this.mApplicationContext = paramContext.getApplicationContext();
    }

    protected Void doInBackground(Void... paramVarArgs) {
        try {
            Settings.publishInstallAndWaitForResponse(this.mApplicationContext, this.mApplicationId, true);
            return null;
        } catch (Exception paramVarArgs) {
            for (; ; ) {
                Utility.logd("Facebook-publish", paramVarArgs);
            }
        }
    }

    protected void onPostExecute(Void arg1) {
        synchronized (this.this$0) {
            Session.access$1802(this.this$0, null);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$AutoPublishAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */