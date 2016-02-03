package com.everimaging.fotorsdk.store;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.services.PluginService;
import com.everimaging.fotorsdk.services.b;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.services.PluginDownloadService;
import com.everimaging.fotorsdk.store.services.PluginDownloadService.a;
import com.everimaging.fotorsdk.store.services.PluginDownloadService.b;
import com.everimaging.fotorsdk.store.services.PluginDownloadService.c;
import com.everimaging.fotorsdk.utils.FotorCommonDirUtils;
import com.everimaging.fotorsdk.utils.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
        implements PluginDownloadService.b {
    private static final String a = c.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static c c;
    private PluginDownloadService d;
    private List<a> e = new ArrayList();
    private boolean f = false;
    private ServiceConnection g = new ServiceConnection() {
        public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {
            c.a(c.this, ((PluginDownloadService.a) paramAnonymousIBinder).a());
            c.b().c(new Object[]{"onServiceConnected : mDownloadService = " + c.a(c.this)});
            c.a(c.this).a(c.this);
            c.a(c.this, true);
        }

        public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {
            c.a(c.this).a(null);
            c.b(c.this).clear();
            c.a(c.this, null);
            c.a(c.this, false);
        }
    };

    public static c a() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    private String a(String paramString1, String paramString2) {
        String str = null;
        if (!TextUtils.isEmpty(paramString1)) {
            str = "";
            if (!paramString1.equals(com.everimaging.fotorsdk.store.utils.c.c)) {
                break label41;
            }
            str = FotorCommonDirUtils.getDownloadBorderPath();
        }
        for (; ; ) {
            str = new File(str, paramString2).getAbsolutePath();
            return str;
            label41:
            if (paramString1.equals(com.everimaging.fotorsdk.store.utils.c.a)) {
                str = FotorCommonDirUtils.getDownloadEffectPath();
            } else if (paramString1.equals(com.everimaging.fotorsdk.store.utils.c.d)) {
                str = FotorCommonDirUtils.getDownloadFontPath();
            } else if (paramString1.equals(com.everimaging.fotorsdk.store.utils.c.b)) {
                str = FotorCommonDirUtils.getDownloadStickerPath();
            } else if (paramString1.equals(com.everimaging.fotorsdk.store.utils.c.e)) {
                str = FotorCommonDirUtils.getDownloadCollageClassicPath();
            } else if (paramString1.equals(com.everimaging.fotorsdk.store.utils.c.f)) {
                str = FotorCommonDirUtils.getDownloadCollageMagazinePath();
            } else if (paramString1.equals(com.everimaging.fotorsdk.store.utils.c.g)) {
                str = FotorCommonDirUtils.getDownloadCollagePatternPath();
            }
        }
    }

    private void c() {
        if (!this.f) {
            Log.e(a, "You must bind download plugin service first.!");
        }
    }

    public int a(String paramString) {
        int j = -1;
        c();
        int i = j;
        if (this.f) {
            i = j;
            if (this.d != null) {
                paramString = this.d.a(paramString);
                i = j;
                if (paramString != null) {
                    i = paramString.c();
                }
            }
        }
        return i;
    }

    public void a(Context paramContext) {
        paramContext.bindService(new Intent(paramContext, PluginDownloadService.class), this.g, 1);
    }

    public void a(a parama) {
        if (!this.e.contains(parama)) {
            this.e.add(parama);
        }
    }

    public void a(PurchasedPack paramPurchasedPack) {
        c();
        if ((this.f) && (this.d != null) && (paramPurchasedPack != null)) {
            PluginDownloadService.c localc = new PluginDownloadService.c();
            String str = a(paramPurchasedPack.getType(), StringUtils.removeSpeicalCharacter(paramPurchasedPack.getPackName()));
            if (!TextUtils.isEmpty(str)) {
                localc.a(paramPurchasedPack);
                localc.a(str);
                this.d.a(localc);
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        if (this.e != null) {
            Iterator localIterator = this.e.iterator();
            while (localIterator.hasNext()) {
                ((a) localIterator.next()).a(paramPurchasedPack, paramFloat);
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (this.e != null) {
            Iterator localIterator = this.e.iterator();
            while (localIterator.hasNext()) {
                ((a) localIterator.next()).a(paramPurchasedPack, paramInt);
            }
        }
    }

    public void a(PurchasedPack paramPurchasedPack, String paramString) {
        ((PluginService) b.a().b(PluginService.class)).a(paramPurchasedPack, paramString);
        if (this.e != null) {
            Iterator localIterator = this.e.iterator();
            while (localIterator.hasNext()) {
                ((a) localIterator.next()).a(paramPurchasedPack, paramString);
            }
        }
    }

    public void b(Context paramContext) {
        c();
        paramContext.unbindService(this.g);
    }

    public void b(a parama) {
        this.e.remove(parama);
    }

    public void b(PurchasedPack paramPurchasedPack) {
        if (this.e != null) {
            Iterator localIterator = this.e.iterator();
            while (localIterator.hasNext()) {
                ((a) localIterator.next()).a(paramPurchasedPack);
            }
        }
    }

    public void c(PurchasedPack paramPurchasedPack) {
        if (this.e != null) {
            Iterator localIterator = this.e.iterator();
            while (localIterator.hasNext()) {
                ((a) localIterator.next()).b(paramPurchasedPack);
            }
        }
    }

    public static abstract interface a {
        public abstract void a(PurchasedPack paramPurchasedPack);

        public abstract void a(PurchasedPack paramPurchasedPack, float paramFloat);

        public abstract void a(PurchasedPack paramPurchasedPack, int paramInt);

        public abstract void a(PurchasedPack paramPurchasedPack, String paramString);

        public abstract void b(PurchasedPack paramPurchasedPack);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */