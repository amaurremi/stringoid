package com.everimaging.fotorsdk.store.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.everimaging.fotorsdk.http.f;
import com.everimaging.fotorsdk.http.k;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.db.entity.PurchasedPack;
import com.everimaging.fotorsdk.store.utils.d;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorZipUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipInputStream;

import org.apache.http.Header;

public class PluginDownloadService
        extends Service {
    private static final String a = PluginDownloadService.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private Object c = new Object();
    private a d;
    private LinkedHashMap<String, c> e;
    private ArrayList<c> f;
    private LinkedHashMap<String, k> g;
    private boolean h = false;
    private int i = 0;
    private b j;

    private void a() {
        if ((this.i < 3) && (this.f.size() > 0)) {
            this.i += 1;
            if (this.f.size() > 0) {
                final Object localObject2 = (c) this.f.remove(0);
                final PurchasedPack localPurchasedPack = ((c) localObject2).d();
                localPurchasedPack.getPackName();
                final Object localObject1 = localPurchasedPack.getPackID();
                String str1 = localPurchasedPack.getResourceUrl();
                final String str2 = ((c) localObject2).b();
                ((c) localObject2).a(1);
                if ((str1 != null) && (str2 != null)) {
                    localObject2 = String.valueOf(System.currentTimeMillis());
                    localObject1 = d.b(str1, null, new f(new String[]{".*"}) {
                        public void a(int paramAnonymousInt1, int paramAnonymousInt2) {
                            super.a(paramAnonymousInt1, paramAnonymousInt2);
                            for (; ; ) {
                                float f;
                                synchronized (PluginDownloadService.a(PluginDownloadService.this)) {
                                    if (!PluginDownloadService.b(PluginDownloadService.this)) {
                                        return;
                                    }
                                    f = paramAnonymousInt1 / paramAnonymousInt2;
                                    if (PluginDownloadService.f(PluginDownloadService.this).containsKey(localObject1)) {
                                        PluginDownloadService.c localc = (PluginDownloadService.c) PluginDownloadService.f(PluginDownloadService.this).get(localObject1);
                                        localc.b((int) (100.0F * f));
                                        if (localc.a() == 2) {
                                            PluginDownloadService.a(PluginDownloadService.this, localObject2);
                                            PluginDownloadService.f(PluginDownloadService.this).remove(localObject1);
                                            PluginDownloadService.d(PluginDownloadService.this).remove(localObject2);
                                            PluginDownloadService.c(PluginDownloadService.this);
                                            PluginDownloadService.e(PluginDownloadService.this);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                if ((f >= 0.0F) && (f <= 1.0D)) {
                                    PluginDownloadService.a(PluginDownloadService.this, localPurchasedPack, f);
                                }
                            }
                        }

                        public void a(int paramAnonymousInt, Header[] arg2, byte[] paramAnonymousArrayOfByte) {
                            synchronized (PluginDownloadService.a(PluginDownloadService.this)) {
                                if (!PluginDownloadService.b(PluginDownloadService.this)) {
                                    return;
                                }
                                paramAnonymousArrayOfByte = new ByteArrayInputStream(paramAnonymousArrayOfByte);
                                new PluginDownloadService.d(PluginDownloadService.this, str2, localPurchasedPack, paramAnonymousArrayOfByte).execute(new Void[0]);
                                PluginDownloadService.c(PluginDownloadService.this);
                                PluginDownloadService.d(PluginDownloadService.this).remove(localObject2);
                                PluginDownloadService.e(PluginDownloadService.this);
                                return;
                            }
                        }

                        public void a(int paramAnonymousInt, Header[] arg2, byte[] paramAnonymousArrayOfByte, Throwable paramAnonymousThrowable) {
                            synchronized (PluginDownloadService.a(PluginDownloadService.this)) {
                                if (!PluginDownloadService.b(PluginDownloadService.this)) {
                                    return;
                                }
                                PluginDownloadService.f(PluginDownloadService.this).remove(localObject1);
                                PluginDownloadService.c(PluginDownloadService.this);
                                PluginDownloadService.d(PluginDownloadService.this).remove(localObject2);
                                PluginDownloadService.a(PluginDownloadService.this, localPurchasedPack, 0);
                                PluginDownloadService.e(PluginDownloadService.this);
                                return;
                            }
                        }
                    });
                    this.g.put(localObject2, localObject1);
                    b(localPurchasedPack);
                }
            }
        }
    }

    private void a(PurchasedPack paramPurchasedPack) {
        if (this.j != null) {
            this.j.c(paramPurchasedPack);
        }
    }

    private void a(PurchasedPack paramPurchasedPack, float paramFloat) {
        if (this.j != null) {
            this.j.a(paramPurchasedPack, paramFloat);
        }
    }

    private void a(PurchasedPack paramPurchasedPack, int paramInt) {
        if (this.j != null) {
            this.j.a(paramPurchasedPack, paramInt);
        }
    }

    private void a(PurchasedPack paramPurchasedPack, String paramString) {
        if (this.j != null) {
            this.j.a(paramPurchasedPack, paramString);
        }
    }

    private void b(PurchasedPack paramPurchasedPack) {
        if (this.j != null) {
            this.j.b(paramPurchasedPack);
        }
    }

    private void b(String paramString) {
        if (this.g.containsKey(paramString)) {
            ((k) this.g.get(paramString)).a(true);
        }
    }

    private void c(String paramString) {
        int k = 0;
        b.c(new Object[]{"Unzip error!Clean error directory"});
        paramString = new File(paramString);
        if (paramString.exists()) {
            String[] arrayOfString = paramString.list();
            if (k < arrayOfString.length) {
                File localFile = new File(paramString, arrayOfString[k]);
                if (localFile.isDirectory()) {
                    c(localFile.getAbsolutePath());
                }
                for (; ; ) {
                    k += 1;
                    break;
                    localFile.delete();
                }
            }
            paramString.delete();
        }
    }

    public c a(String paramString) {
        return (c) this.e.get(paramString);
    }

    public void a(b paramb) {
        this.j = paramb;
    }

    public void a(c paramc) {
        synchronized (this.c) {
            if ((this.e != null) && (paramc != null) && (this.f != null)) {
                this.e.put(paramc.d().getPackID(), paramc);
                this.f.add(paramc);
                a(paramc.d());
            }
            a();
            return;
        }
    }

    public IBinder onBind(Intent paramIntent) {
        b.c(new Object[]{"Download Service: OnBind"});
        return this.d;
    }

    public void onCreate() {
        super.onCreate();
        b.c(new Object[]{"Download Service: OnCreate"});
        this.d = new a();
        this.e = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.f = new ArrayList();
        this.h = true;
    }

    public void onDestroy() {
        super.onDestroy();
        b.c(new Object[]{"Download Service: onDestroy"});
        this.h = false;
        this.d = null;
        Iterator localIterator = this.g.values().iterator();
        while (localIterator.hasNext()) {
            ((k) localIterator.next()).a(true);
        }
        this.e.clear();
        this.f.clear();
    }

    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        b.c(new Object[]{"Download Service: onStartCommand"});
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }

    public class a
            extends Binder {
        public a() {
        }

        public PluginDownloadService a() {
            return PluginDownloadService.this;
        }
    }

    public static abstract interface b {
        public abstract void a(PurchasedPack paramPurchasedPack, float paramFloat);

        public abstract void a(PurchasedPack paramPurchasedPack, int paramInt);

        public abstract void a(PurchasedPack paramPurchasedPack, String paramString);

        public abstract void b(PurchasedPack paramPurchasedPack);

        public abstract void c(PurchasedPack paramPurchasedPack);
    }

    public static class c {
        private int a = 0;
        private String b;
        private PurchasedPack c;
        private int d = 0;

        public int a() {
            return this.a;
        }

        public void a(int paramInt) {
            this.a = paramInt;
        }

        public void a(PurchasedPack paramPurchasedPack) {
            this.c = paramPurchasedPack;
        }

        public void a(String paramString) {
            this.b = paramString;
        }

        public String b() {
            return this.b;
        }

        public void b(int paramInt) {
            this.d = paramInt;
        }

        public int c() {
            return this.d;
        }

        public PurchasedPack d() {
            return this.c;
        }
    }

    private class d
            extends FotorAsyncTask<Void, Void, Integer> {
        private InputStream b;
        private String c;
        private PurchasedPack d;

        public d(String paramString, PurchasedPack paramPurchasedPack, InputStream paramInputStream) {
            this.c = paramString;
            this.b = paramInputStream;
            this.d = paramPurchasedPack;
        }

        protected Integer a(Void... paramVarArgs) {
            if (this.b != null) {
                paramVarArgs = new ZipInputStream(this.b);
                return Integer.valueOf(FotorZipUtils.UnzipStream(this.c, paramVarArgs));
            }
            return Integer.valueOf(-1);
        }

        protected void a(Integer paramInteger) {
            for (; ; ) {
                synchronized (PluginDownloadService.a(PluginDownloadService.this)) {
                    if (!PluginDownloadService.b(PluginDownloadService.this)) {
                        return;
                    }
                    switch (paramInteger.intValue()) {
                        case 0:
                            PluginDownloadService.f(PluginDownloadService.this).remove(this.d.getPackID());
                            return;
                    }
                }
                PluginDownloadService.a(PluginDownloadService.this, this.d, this.c);
                continue;
                PluginDownloadService.a(PluginDownloadService.this, this.d, 2);
                PluginDownloadService.b(PluginDownloadService.this, this.c);
                continue;
                PluginDownloadService.a(PluginDownloadService.this, this.d, 1);
                PluginDownloadService.b(PluginDownloadService.this, this.c);
            }
        }

        protected void onCancelled() {
        }

        protected void onPreExecute() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/services/PluginDownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */