package com.everimaging.fotor.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.everimaging.fotor.App;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.http.l;
import com.everimaging.fotorsdk.http.p;
import com.everimaging.fotorsdk.http.q;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.HttpResponseException;

public class NotifyPushReceiver
        extends BroadcastReceiver {
    private static final String a = NotifyPushReceiver.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static p d = new p();
    private a c;

    void a(Context paramContext) {
        a(paramContext, true);
    }

    void a(Context paramContext, boolean paramBoolean) {
        AlarmManager localAlarmManager = (AlarmManager) paramContext.getSystemService("alarm");
        paramContext = PendingIntent.getBroadcast(paramContext, 201, new Intent(paramContext, NotifyPushReceiver.class), 134217728);
        localAlarmManager.cancel(paramContext);
        if (paramBoolean) {
            localAlarmManager.set(0, com.everimaging.fotor.settings.a.d(), paramContext);
        }
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        b.c(new Object[]{"action:" + paramIntent.getAction()});
        if ("com.everimaging.fotor.push.STOP_POLL".equals(paramIntent.getAction())) {
            a(paramContext, false);
            return;
        }
        if ("com.everimaging.fotor.push.START_POLL".equals(paramIntent.getAction())) {
            a(paramContext, true);
            return;
        }
        if (!App.c(paramContext)) {
            if ((this.c == null) || (this.c.getStatus() == AsyncTask.Status.FINISHED)) {
                this.c = ((a) new a(paramContext).execute(new Void[0]));
            }
        }
        for (; ; ) {
            a(paramContext);
            return;
            b.d(new Object[]{"application was enter background.can't request message."});
        }
    }

    class a
            extends AsyncTask<Void, Void, PushMessageEntity.PushData> {
        PushMessageEntity a = null;
        private Context c;

        public a(Context paramContext) {
            this.c = paramContext;
        }

        private PushMessageEntity a()
                throws HttpResponseException, ParseException, IOException {
            l locall = new l(d.a(this.c, ""));
            NotifyPushReceiver.a().c(new Object[]{"begin request push message"});
            NotifyPushReceiver.b().a(60000);
            NotifyPushReceiver.b().b(d.b, locall, new q() {
                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString) {
                    NotifyPushReceiver.a().c(new Object[]{"pull message is:" + paramAnonymousString});
                    paramAnonymousArrayOfHeader = new GsonBuilder().create();
                    NotifyPushReceiver.a.this.a = ((PushMessageEntity) paramAnonymousArrayOfHeader.fromJson(paramAnonymousString, PushMessageEntity.class));
                }

                public void a(int paramAnonymousInt, Header[] paramAnonymousArrayOfHeader, String paramAnonymousString, Throwable paramAnonymousThrowable) {
                    NotifyPushReceiver.a().d(new Object[]{"failure message is:" + paramAnonymousString, "|error info:" + paramAnonymousThrowable.getMessage()});
                }
            });
            NotifyPushReceiver.a().c(new Object[]{"completion request push message"});
            return this.a;
        }

        private void b() {
            NotifyPushReceiver.a().c(new Object[]{"no message was pull,will get from cache."});
            int i = App.b.i();
            PushMessageEntity.MessageEntity localMessageEntity = b.a().a(i);
            if ((localMessageEntity != null) && (a.a().a(this.c, localMessageEntity))) {
                b.a().b(localMessageEntity);
            }
        }

        protected PushMessageEntity.PushData a(Void... paramVarArgs) {
            NotifyPushReceiver.a().c(new Object[]{"start pull message"});
            paramVarArgs = null;
            try {
                PushMessageEntity localPushMessageEntity = a();
                if (localPushMessageEntity != null) {
                    paramVarArgs = localPushMessageEntity.getData();
                }
                return paramVarArgs;
            } catch (Exception paramVarArgs) {
                paramVarArgs.printStackTrace();
            }
            return null;
        }

        protected void a(PushMessageEntity.PushData paramPushData) {
            super.onPostExecute(paramPushData);
            if (paramPushData != null) {
                long l = paramPushData.getVitality() * c.a;
                com.everimaging.fotor.settings.a.b(l);
                com.everimaging.fotor.settings.a.a(l + System.currentTimeMillis());
                paramPushData = paramPushData.getList();
                if ((paramPushData != null) && (paramPushData.size() > 0)) {
                    NotifyPushReceiver.a().c(new Object[]{"pull message success ,message size:" + paramPushData.size()});
                    PushMessageEntity.MessageEntity localMessageEntity = (PushMessageEntity.MessageEntity) paramPushData.get(0);
                    if ((localMessageEntity != null) && (!a.a().a(this.c, localMessageEntity))) {
                        b.a().a(localMessageEntity);
                    }
                    paramPushData.remove(0);
                    if (paramPushData.size() > 0) {
                        b.a().a(paramPushData);
                    }
                }
            }
            for (; ; ) {
                NotifyPushReceiver.this.a(this.c);
                return;
                b();
                continue;
                b();
                com.everimaging.fotor.settings.a.a(System.currentTimeMillis() + com.everimaging.fotor.settings.a.e());
            }
        }

        protected void onCancelled() {
            super.onCancelled();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/push/NotifyPushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */