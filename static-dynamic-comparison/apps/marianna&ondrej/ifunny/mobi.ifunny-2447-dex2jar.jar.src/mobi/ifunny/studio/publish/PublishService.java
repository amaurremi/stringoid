package mobi.ifunny.studio.publish;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.aw;
import android.support.v4.app.bv;

import java.util.concurrent.TimeUnit;

import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.util.af;

public class PublishService
        extends Service {
    private static final String a = PublishService.class.getSimpleName();
    private volatile Looper b;
    private volatile j c;

    private String a(String paramString) {
        Resources localResources = getResources();
        int i = -1;
        switch (paramString.hashCode()) {
        }
        for (; ; ) {
            switch (i) {
                default:
                    return null;
                if (paramString.equals("image_too_small")) {
                    i = 0;
                    continue;
                    if (paramString.equals("image_too_big")) {
                        i = 1;
                        continue;
                        if (paramString.equals("image_too_big_bytes")) {
                            i = 2;
                        }
                    }
                }
                break;
            }
        }
        return localResources.getString(2131690022);
        return localResources.getString(2131690021);
        return localResources.getString(2131690020);
    }

    private void a(TaskInfo paramTaskInfo, int paramInt1, int paramInt2) {
        int j = 60;
        int k = paramTaskInfo.retry_after;
        int i = k;
        if (k < 0) {
            i = 0;
        }
        if (i > 60) {
            i = j;
        }
        for (; ; ) {
            long l = TimeUnit.SECONDS.toMillis(i);
            Message localMessage = this.c.obtainMessage();
            localMessage.arg1 = paramInt1;
            localMessage.arg2 = paramInt2;
            localMessage.obj = paramTaskInfo;
            this.c.sendMessageDelayed(localMessage, l);
            return;
        }
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        HandlerThread localHandlerThread = new HandlerThread(a);
        localHandlerThread.start();
        this.b = localHandlerThread.getLooper();
        this.c = new j(this, this.b);
    }

    public void onDestroy() {
        this.b.quit();
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        TaskInfo localTaskInfo = (TaskInfo) paramIntent.getParcelableExtra("arg.info");
        if ((localTaskInfo != null) && (localTaskInfo.id == null)) {
        }
        int i = paramIntent.getIntExtra("arg.notification.id", -1);
        paramInt1 = i;
        if (i < 0) {
            paramInt1 = af.a();
            paramIntent = af.b(this);
            paramIntent.a(0, 0, true);
            bv.a(this).a(paramInt1, paramIntent.b());
        }
        a(localTaskInfo, paramInt2, paramInt1);
        return 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */