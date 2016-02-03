package com.facebook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

final class GetTokenClient
        implements ServiceConnection {
    final String applicationId;
    final Context context;
    final Handler handler;
    CompletedListener listener;
    boolean running;
    Messenger sender;

    GetTokenClient(Context paramContext, String paramString) {
        Context localContext = paramContext.getApplicationContext();
        if (localContext != null) {
            paramContext = localContext;
        }
        for (; ; ) {
            this.context = paramContext;
            this.applicationId = paramString;
            this.handler = new Handler() {
                public void handleMessage(Message paramAnonymousMessage) {
                    GetTokenClient.this.handleMessage(paramAnonymousMessage);
                }
            };
            return;
        }
    }

    private void callback(Bundle paramBundle) {
        if (!this.running) {
        }
        CompletedListener localCompletedListener;
        do {
            return;
            this.running = false;
            localCompletedListener = this.listener;
        } while (localCompletedListener == null);
        localCompletedListener.completed(paramBundle);
    }

    private void getToken() {
        Bundle localBundle = new Bundle();
        localBundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
        Message localMessage = Message.obtain(null, 65536);
        localMessage.arg1 = 20121101;
        localMessage.setData(localBundle);
        localMessage.replyTo = new Messenger(this.handler);
        try {
            this.sender.send(localMessage);
            return;
        } catch (RemoteException localRemoteException) {
            callback(null);
        }
    }

    private void handleMessage(Message paramMessage) {
        if (paramMessage.what == 65537) {
            paramMessage = paramMessage.getData();
            if (paramMessage.getString("com.facebook.platform.status.ERROR_TYPE") == null) {
                break label37;
            }
            callback(null);
        }
        for (; ; ) {
            this.context.unbindService(this);
            return;
            label37:
            callback(paramMessage);
        }
    }

    void cancel() {
        this.running = false;
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        this.sender = new Messenger(paramIBinder);
        getToken();
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        this.sender = null;
        this.context.unbindService(this);
        callback(null);
    }

    void setCompletedListener(CompletedListener paramCompletedListener) {
        this.listener = paramCompletedListener;
    }

    boolean start() {
        Intent localIntent = new Intent("com.facebook.platform.PLATFORM_SERVICE");
        localIntent.addCategory("android.intent.category.DEFAULT");
        localIntent = NativeProtocol.validateKatanaServiceIntent(this.context, localIntent);
        if (localIntent == null) {
            callback(null);
            return false;
        }
        this.running = true;
        this.context.bindService(localIntent, this, 1);
        return true;
    }

    static abstract interface CompletedListener {
        public abstract void completed(Bundle paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/GetTokenClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */