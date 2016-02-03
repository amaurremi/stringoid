package com.everimaging.fotorsdk.uil.cache.disc;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c
        extends a {
    private final AtomicInteger b;
    private final int c;
    private final Map<File, Long> d = Collections.synchronizedMap(new HashMap());

    public c(File paramFile, com.everimaging.fotorsdk.uil.cache.disc.naming.a parama, int paramInt) {
        super(paramFile, parama);
        this.c = paramInt;
        this.b = new AtomicInteger();
        a();
    }

    private void a() {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                File[] arrayOfFile = c.this.a.listFiles();
                if (arrayOfFile != null) {
                    int k = arrayOfFile.length;
                    int j = 0;
                    while (i < k) {
                        File localFile = arrayOfFile[i];
                        j += c.this.a(localFile);
                        c.a(c.this).put(localFile, Long.valueOf(localFile.lastModified()));
                        i += 1;
                    }
                    c.b(c.this).set(j);
                }
            }
        }).start();
    }

    private int b() {
        File localFile = null;
        int i;
        if (this.d.isEmpty()) {
            i = -1;
            return i;
        }
        Object localObject1 = this.d.entrySet();
        label213:
        for (; ; ) {
            synchronized (this.d) {
                Iterator localIterator = ((Set) localObject1).iterator();
                localObject1 = null;
                if (localIterator.hasNext()) {
                    Map.Entry localEntry = (Map.Entry) localIterator.next();
                    if (localFile == null) {
                        localFile = (File) localEntry.getKey();
                        localObject1 = (Long) localEntry.getValue();
                        break label213;
                    }
                    Long localLong = (Long) localEntry.getValue();
                    if (localLong.longValue() >= ((Long) localObject1).longValue()) {
                        break label213;
                    }
                    localFile = (File) localEntry.getKey();
                    localObject1 = localLong;
                    break label213;
                }
                i = 0;
                if (localFile == null) {
                    break;
                }
                if (localFile.exists()) {
                    int j = a(localFile);
                    i = j;
                    if (!localFile.delete()) {
                        break;
                    }
                    this.d.remove(localFile);
                    return j;
                }
            }
            this.d.remove(localFile);
            return 0;
        }
    }

    protected abstract int a(File paramFile);

    public File a(String paramString) {
        paramString = super.a(paramString);
        Long localLong = Long.valueOf(System.currentTimeMillis());
        paramString.setLastModified(localLong.longValue());
        this.d.put(paramString, localLong);
        return paramString;
    }

    public void a(String paramString, File paramFile) {
        int j = a(paramFile);
        for (int i = this.b.get(); ; i = this.b.addAndGet(-i)) {
            if (i + j > this.c) {
                i = b();
                if (i != -1) {
                }
            } else {
                this.b.addAndGet(j);
                paramString = Long.valueOf(System.currentTimeMillis());
                paramFile.setLastModified(paramString.longValue());
                this.d.put(paramFile, paramString);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/cache/disc/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */