package com.quoord.tapatalkpro.action;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import com.quoord.tapatalkpro.alarm.notification.RegisterTapatalkIdNotification;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;

public class RegisterService
        extends Service {
    public static final String ACTION = "com.quoord.tapatalkpro.action.RegisterService";

    private void createRegisterTapatalkIdNotification() {
        if (TapatalkIdFactory.getTapatalkId(this).getAuid() == -1) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent localIntent = new Intent();
                    localIntent.putExtra("msg", RegisterService.this.getResources().getString(2131100622));
                    localIntent.putExtra("title", RegisterService.this.getResources().getString(2131100621));
                    RegisterTapatalkIdNotification.getTapatalkIdNotification(RegisterService.this, localIntent);
                }
            }, 300000L);
        }
    }

    public IBinder onBind(Intent paramIntent) {
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStart(final Intent paramIntent, int paramInt) {
        super.onStart(paramIntent, paramInt);
        if (!TapatalkIdFactory.getTapatalkId(this).isTapatalkIdLogin()) {
            createRegisterTapatalkIdNotification();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                RegisterService.this.stopService(paramIntent);
            }
        }, 360000L);
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/RegisterService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */