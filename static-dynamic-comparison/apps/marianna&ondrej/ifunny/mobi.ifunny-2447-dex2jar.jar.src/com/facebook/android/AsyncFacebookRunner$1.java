package com.facebook.android;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

class AsyncFacebookRunner$1
        extends Thread {
    AsyncFacebookRunner$1(AsyncFacebookRunner paramAsyncFacebookRunner, Context paramContext, AsyncFacebookRunner.RequestListener paramRequestListener, Object paramObject) {
    }

    public void run() {
        try {
            String str = this.this$0.fb.logoutImpl(this.val$context);
            if ((str.length() == 0) || (str.equals("false"))) {
                this.val$listener.onFacebookError(new FacebookError("auth.expireSession failed"), this.val$state);
                return;
            }
            this.val$listener.onComplete(str, this.val$state);
            return;
        } catch (FileNotFoundException localFileNotFoundException) {
            this.val$listener.onFileNotFoundException(localFileNotFoundException, this.val$state);
            return;
        } catch (MalformedURLException localMalformedURLException) {
            this.val$listener.onMalformedURLException(localMalformedURLException, this.val$state);
            return;
        } catch (IOException localIOException) {
            this.val$listener.onIOException(localIOException, this.val$state);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/AsyncFacebookRunner$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */