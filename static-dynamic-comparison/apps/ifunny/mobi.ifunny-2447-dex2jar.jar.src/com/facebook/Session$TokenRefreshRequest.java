package com.facebook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.internal.NativeProtocol;

import java.util.Date;

class Session$TokenRefreshRequest
        implements ServiceConnection {
    final Messenger messageReceiver = new Messenger(new Session.TokenRefreshRequestHandler(this.this$0, this));
    Messenger messageSender = null;

    Session$TokenRefreshRequest(Session paramSession) {
    }

    private void cleanup() {
        if (Session.access$1600(this.this$0) == this) {
            Session.access$1602(this.this$0, null);
        }
    }

    private void refreshToken() {
        Bundle localBundle = new Bundle();
        localBundle.putString("access_token", this.this$0.getTokenInfo().getToken());
        Message localMessage = Message.obtain();
        localMessage.setData(localBundle);
        localMessage.replyTo = this.messageReceiver;
        try {
            this.messageSender.send(localMessage);
            return;
        } catch (RemoteException localRemoteException) {
            cleanup();
        }
    }

    public void bind() {
        Intent localIntent = NativeProtocol.createTokenRefreshIntent(Session.getStaticContext());
        if ((localIntent != null) && (Session.access$1500().bindService(localIntent, this, 1))) {
            this.this$0.setLastAttemptedTokenExtendDate(new Date());
            return;
        }
        cleanup();
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        this.messageSender = new Messenger(paramIBinder);
        refreshToken();
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        cleanup();
        Session.access$1500().unbindService(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$TokenRefreshRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */