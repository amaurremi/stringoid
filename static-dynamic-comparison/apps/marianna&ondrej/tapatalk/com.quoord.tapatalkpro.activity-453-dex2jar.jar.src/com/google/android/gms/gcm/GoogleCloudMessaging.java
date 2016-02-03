package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    static GoogleCloudMessaging Nq;
    private PendingIntent Nr;
    final BlockingQueue<Intent> Ns = new LinkedBlockingQueue();
    private Handler Nt = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message paramAnonymousMessage) {
            paramAnonymousMessage = (Intent) paramAnonymousMessage.obj;
            GoogleCloudMessaging.this.Ns.add(paramAnonymousMessage);
        }
    };
    private Messenger Nu = new Messenger(this.Nt);
    private Context kI;

    private void a(String paramString1, String paramString2, long paramLong, int paramInt, Bundle paramBundle)
            throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (paramString1 == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent localIntent = new Intent("com.google.android.gcm.intent.SEND");
        localIntent.putExtras(paramBundle);
        c(localIntent);
        localIntent.setPackage("com.google.android.gms");
        localIntent.putExtra("google.to", paramString1);
        localIntent.putExtra("google.message_id", paramString2);
        localIntent.putExtra("google.ttl", Long.toString(paramLong));
        localIntent.putExtra("google.delay", Integer.toString(paramInt));
        this.kI.sendOrderedBroadcast(localIntent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    private void c(String... paramVarArgs) {
        paramVarArgs = d(paramVarArgs);
        Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
        localIntent.setPackage("com.google.android.gms");
        localIntent.putExtra("google.messenger", this.Nu);
        c(localIntent);
        localIntent.putExtra("sender", paramVarArgs);
        this.kI.startService(localIntent);
    }

    public static GoogleCloudMessaging getInstance(Context paramContext) {
        try {
            if (Nq == null) {
                Nq = new GoogleCloudMessaging();
                Nq.kI = paramContext;
            }
            paramContext = Nq;
            return paramContext;
        } finally {
        }
    }

    private void hL() {
        Intent localIntent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        localIntent.setPackage("com.google.android.gms");
        this.Ns.clear();
        localIntent.putExtra("google.messenger", this.Nu);
        c(localIntent);
        this.kI.startService(localIntent);
    }

    void c(Intent paramIntent) {
        try {
            if (this.Nr == null) {
                Intent localIntent = new Intent();
                localIntent.setPackage("com.google.example.invalidpackage");
                this.Nr = PendingIntent.getBroadcast(this.kI, 0, localIntent, 0);
            }
            paramIntent.putExtra("app", this.Nr);
            return;
        } finally {
        }
    }

    public void close() {
        hM();
    }

    String d(String... paramVarArgs) {
        if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
        int i = 1;
        while (i < paramVarArgs.length) {
            localStringBuilder.append(',').append(paramVarArgs[i]);
            i += 1;
        }
        return localStringBuilder.toString();
    }

    public String getMessageType(Intent paramIntent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction())) {
            paramIntent = null;
        }
        String str;
        do {
            return paramIntent;
            str = paramIntent.getStringExtra("message_type");
            paramIntent = str;
        } while (str != null);
        return "gcm";
    }

    void hM() {
        try {
            if (this.Nr != null) {
                this.Nr.cancel();
                this.Nr = null;
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public String register(String... paramVarArgs)
            throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        this.Ns.clear();
        c(paramVarArgs);
        try {
            paramVarArgs = (Intent) this.Ns.poll(5000L, TimeUnit.MILLISECONDS);
            if (paramVarArgs == null) {
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } catch (InterruptedException paramVarArgs) {
            throw new IOException(paramVarArgs.getMessage());
        }
        String str = paramVarArgs.getStringExtra("registration_id");
        if (str != null) {
            return str;
        }
        paramVarArgs.getStringExtra("error");
        paramVarArgs = paramVarArgs.getStringExtra("error");
        if (paramVarArgs != null) {
            throw new IOException(paramVarArgs);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public void send(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
            throws IOException {
        a(paramString1, paramString2, paramLong, -1, paramBundle);
    }

    public void send(String paramString1, String paramString2, Bundle paramBundle)
            throws IOException {
        send(paramString1, paramString2, -1L, paramBundle);
    }

    public void unregister()
            throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        hL();
        try {
            Intent localIntent = (Intent) this.Ns.poll(5000L, TimeUnit.MILLISECONDS);
            if (localIntent == null) {
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } catch (InterruptedException localInterruptedException) {
            throw new IOException(localInterruptedException.getMessage());
        }
        if (localInterruptedException.getStringExtra("unregistered") != null) {
            return;
        }
        String str = localInterruptedException.getStringExtra("error");
        if (str != null) {
            throw new IOException(str);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/gcm/GoogleCloudMessaging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */