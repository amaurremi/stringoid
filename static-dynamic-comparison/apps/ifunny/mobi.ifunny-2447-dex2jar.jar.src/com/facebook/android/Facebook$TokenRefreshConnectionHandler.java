package com.facebook.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.LegacyHelper;
import com.facebook.Session;

import java.lang.ref.WeakReference;

class Facebook$TokenRefreshConnectionHandler
        extends Handler {
    WeakReference<Facebook.TokenRefreshServiceConnection> connectionWeakReference;
    WeakReference<Facebook> facebookWeakReference;

    Facebook$TokenRefreshConnectionHandler(Facebook paramFacebook, Facebook.TokenRefreshServiceConnection paramTokenRefreshServiceConnection) {
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
            localObject1 = Facebook.access$200((Facebook) localObject1);
            if (localObject1 != null) {
                LegacyHelper.extendTokenCompleted((Session) localObject1, paramMessage.getData());
            }
            if (localTokenRefreshServiceConnection.serviceListener != null) {
                paramMessage = (Bundle) paramMessage.getData().clone();
                paramMessage.putLong("expires_in", l);
                localTokenRefreshServiceConnection.serviceListener.onComplete(paramMessage);
            }
        }
        for (; ; ) {
            localTokenRefreshServiceConnection.applicationsContext.unbindService(localTokenRefreshServiceConnection);
            return;
            if (localTokenRefreshServiceConnection.serviceListener != null) {
                localObject1 = paramMessage.getData().getString("error");
                if (!paramMessage.getData().containsKey("error_code")) {
                    break;
                }
                int i = paramMessage.getData().getInt("error_code");
                localTokenRefreshServiceConnection.serviceListener.onFacebookError(new FacebookError((String) localObject1, null, i));
            }
        }
        localObject2 = localTokenRefreshServiceConnection.serviceListener;
        if (localObject1 != null) {
        }
        for (paramMessage = (Message) localObject1; ; paramMessage = "Unknown service error") {
            ((Facebook.ServiceListener) localObject2).onError(new Error(paramMessage));
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/Facebook$TokenRefreshConnectionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */