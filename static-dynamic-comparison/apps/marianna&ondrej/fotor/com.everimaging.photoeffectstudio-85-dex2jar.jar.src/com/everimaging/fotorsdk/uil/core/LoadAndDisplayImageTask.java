package com.everimaging.fotorsdk.uil.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.everimaging.fotorsdk.uil.core.assist.FailReason;
import com.everimaging.fotorsdk.uil.core.assist.FailReason.FailType;
import com.everimaging.fotorsdk.uil.core.assist.ImageScaleType;
import com.everimaging.fotorsdk.uil.core.assist.LoadedFrom;
import com.everimaging.fotorsdk.uil.core.assist.ViewScaleType;
import com.everimaging.fotorsdk.uil.core.assist.d;
import com.everimaging.fotorsdk.uil.core.download.ImageDownloader;
import com.everimaging.fotorsdk.uil.core.download.ImageDownloader.Scheme;
import com.everimaging.fotorsdk.uil.utils.b.a;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class LoadAndDisplayImageTask
        implements b.a, Runnable {
    final String a;
    final com.everimaging.fotorsdk.uil.core.imageaware.a b;
    final c c;
    final com.everimaging.fotorsdk.uil.core.assist.c d;
    final d e;
    private final f f;
    private final g g;
    private final Handler h;
    private final e i;
    private final ImageDownloader j;
    private final ImageDownloader k;
    private final ImageDownloader l;
    private final com.everimaging.fotorsdk.uil.core.decode.b m;
    private final boolean n;
    private final String o;
    private final com.everimaging.fotorsdk.uil.core.assist.e p;
    private LoadedFrom q = LoadedFrom.NETWORK;

    public LoadAndDisplayImageTask(f paramf, g paramg, Handler paramHandler) {
        this.f = paramf;
        this.g = paramg;
        this.h = paramHandler;
        this.i = paramf.a;
        this.j = this.i.r;
        this.k = this.i.w;
        this.l = this.i.x;
        this.m = this.i.s;
        this.n = this.i.u;
        this.a = paramg.a;
        this.o = paramg.b;
        this.b = paramg.c;
        this.p = paramg.d;
        this.c = paramg.e;
        this.d = paramg.f;
        this.e = paramg.g;
    }

    private Bitmap a(String paramString)
            throws IOException {
        ViewScaleType localViewScaleType = this.b.c();
        paramString = new com.everimaging.fotorsdk.uil.core.decode.c(this.o, paramString, this.p, localViewScaleType, g(), this.c);
        return this.m.a(paramString);
    }

    private void a(final FailReason.FailType paramFailType, final Throwable paramThrowable) {
        if ((this.c.s()) || (o()) || (i())) {
            return;
        }
        this.h.post(new Runnable() {
            public void run() {
                if (LoadAndDisplayImageTask.this.c.c()) {
                    LoadAndDisplayImageTask.this.b.a(LoadAndDisplayImageTask.this.c.c(LoadAndDisplayImageTask.a(LoadAndDisplayImageTask.this).a));
                }
                LoadAndDisplayImageTask.this.d.a(LoadAndDisplayImageTask.this.a, LoadAndDisplayImageTask.this.b.d(), new FailReason(paramFailType, paramThrowable));
            }
        });
    }

    private void a(String paramString, Object... paramVarArgs) {
        if (this.n) {
            com.everimaging.fotorsdk.uil.utils.c.a(paramString, paramVarArgs);
        }
    }

    private boolean a(File paramFile)
            throws LoadAndDisplayImageTask.TaskCancelledException {
        b("Cache image on disc [%s]");
        do {
            try {
                boolean bool1 = b(paramFile);
                bool2 = bool1;
                if (bool1) {
                    bool3 = bool1;
                }
                int i1;
                int i2;
                com.everimaging.fotorsdk.uil.utils.c.a(localIOException1);
            } catch (IOException localIOException1) {
                try {
                    i1 = this.i.d;
                    bool3 = bool1;
                    i2 = this.i.e;
                    if (i1 <= 0) {
                        bool2 = bool1;
                        if (i2 <= 0) {
                        }
                    } else {
                        bool3 = bool1;
                        b("Resize image in disc cache [%s]");
                        bool3 = bool1;
                        bool2 = a(paramFile, i1, i2);
                    }
                    bool3 = bool2;
                    this.i.q.a(this.a, paramFile);
                    return bool2;
                } catch (IOException localIOException2) {
                    boolean bool2;
                    boolean bool3;
                    for (; ; ) {
                    }
                }
                localIOException1 = localIOException1;
                bool3 = false;
            }
            bool2 = bool3;
        } while (!paramFile.exists());
        paramFile.delete();
        return bool3;
    }

    private boolean a(File paramFile, int paramInt1, int paramInt2)
            throws IOException {
        Object localObject1 = new com.everimaging.fotorsdk.uil.core.assist.e(paramInt1, paramInt2);
        Object localObject3 = new c.a().a(this.c).a(ImageScaleType.IN_SAMPLE_INT).a();
        localObject1 = new com.everimaging.fotorsdk.uil.core.decode.c(this.o, ImageDownloader.Scheme.FILE.wrap(paramFile.getAbsolutePath()), (com.everimaging.fotorsdk.uil.core.assist.e) localObject1, ViewScaleType.FIT_INSIDE, g(), (c) localObject3);
        localObject3 = this.m.a((com.everimaging.fotorsdk.uil.core.decode.c) localObject1);
        localObject1 = localObject3;
        if (localObject3 != null) {
            localObject1 = localObject3;
            if (this.i.h != null) {
                b("Process image before cache on disc [%s]");
                localObject3 = this.i.h.a((Bitmap) localObject3);
                localObject1 = localObject3;
                if (localObject3 == null) {
                    com.everimaging.fotorsdk.uil.utils.c.d("Bitmap processor for disc cache returned null [%s]", new Object[]{this.o});
                    localObject1 = localObject3;
                }
            }
        }
        if (localObject1 != null) {
            paramFile = new BufferedOutputStream(new FileOutputStream(paramFile), 32768);
        }
        try {
            ((Bitmap) localObject1).compress(this.i.f, this.i.g, paramFile);
            com.everimaging.fotorsdk.uil.utils.b.a(paramFile);
            ((Bitmap) localObject1).recycle();
            return true;
        } finally {
            com.everimaging.fotorsdk.uil.utils.b.a(paramFile);
        }
    }

    private void b(String paramString) {
        if (this.n) {
            com.everimaging.fotorsdk.uil.utils.c.a(paramString, new Object[]{this.o});
        }
    }

    private boolean b() {
        AtomicBoolean localAtomicBoolean = this.f.a();
        if (localAtomicBoolean.get()) {
        }
        synchronized (this.f.b()) {
            if (localAtomicBoolean.get()) {
                b("ImageLoader is paused. Waiting...  [%s]");
            }
            try {
                this.f.b().wait();
                b(".. Resume loading [%s]");
                return i();
            } catch (InterruptedException localInterruptedException) {
                com.everimaging.fotorsdk.uil.utils.c.d("Task was interrupted [%s]", new Object[]{this.o});
                return true;
            }
        }
    }

    private boolean b(final int paramInt1, final int paramInt2) {
        if ((this.c.s()) || (o()) || (i())) {
            return false;
        }
        this.h.post(new Runnable() {
            public void run() {
                LoadAndDisplayImageTask.this.e.a(LoadAndDisplayImageTask.this.a, LoadAndDisplayImageTask.this.b.d(), paramInt1, paramInt2);
            }
        });
        return true;
    }

    /* Error */
    private boolean b(File paramFile)
            throws IOException {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 142	com/everimaging/fotorsdk/uil/core/LoadAndDisplayImageTask:g	()Lcom/everimaging/fotorsdk/uil/core/download/ImageDownloader;
        //   4: aload_0
        //   5: getfield 104	com/everimaging/fotorsdk/uil/core/LoadAndDisplayImageTask:a	Ljava/lang/String;
        //   8: aload_0
        //   9: getfield 120	com/everimaging/fotorsdk/uil/core/LoadAndDisplayImageTask:c	Lcom/everimaging/fotorsdk/uil/core/c;
        //   12: invokevirtual 328	com/everimaging/fotorsdk/uil/core/c:n	()Ljava/lang/Object;
        //   15: invokeinterface 333 3 0
        //   20: astore_3
        //   21: new 272	java/io/BufferedOutputStream
        //   24: dup
        //   25: new 274	java/io/FileOutputStream
        //   28: dup
        //   29: aload_1
        //   30: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   33: ldc_w 278
        //   36: invokespecial 281	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
        //   39: astore_1
        //   40: aload_3
        //   41: aload_1
        //   42: aload_0
        //   43: invokestatic 336	com/everimaging/fotorsdk/uil/utils/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/everimaging/fotorsdk/uil/utils/b$a;)Z
        //   46: istore_2
        //   47: aload_1
        //   48: invokestatic 297	com/everimaging/fotorsdk/uil/utils/b:a	(Ljava/io/Closeable;)V
        //   51: aload_3
        //   52: invokestatic 297	com/everimaging/fotorsdk/uil/utils/b:a	(Ljava/io/Closeable;)V
        //   55: iload_2
        //   56: ireturn
        //   57: astore 4
        //   59: aload_1
        //   60: invokestatic 297	com/everimaging/fotorsdk/uil/utils/b:a	(Ljava/io/Closeable;)V
        //   63: aload 4
        //   65: athrow
        //   66: astore_1
        //   67: aload_3
        //   68: invokestatic 297	com/everimaging/fotorsdk/uil/utils/b:a	(Ljava/io/Closeable;)V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	LoadAndDisplayImageTask
        //   0	73	1	paramFile	File
        //   46	10	2	bool	boolean
        //   20	48	3	localInputStream	java.io.InputStream
        //   57	7	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   40	47	57	finally
        //   21	40	66	finally
        //   47	51	66	finally
        //   59	66	66	finally
    }

    private boolean c() {
        if (this.c.f()) {
            a("Delay %d ms before loading...  [%s]", new Object[]{Integer.valueOf(this.c.l()), this.o});
            try {
                Thread.sleep(this.c.l());
                return i();
            } catch (InterruptedException localInterruptedException) {
                com.everimaging.fotorsdk.uil.utils.c.d("Task was interrupted [%s]", new Object[]{this.o});
                return true;
            }
        }
        return false;
    }

    private Bitmap d()
            throws LoadAndDisplayImageTask.TaskCancelledException {
        File localFile = e();
        Object localObject2;
        for (; ; ) {
            try {
                String str = ImageDownloader.Scheme.FILE.wrap(localFile.getAbsolutePath());
                Bitmap localBitmap1;
                Bitmap localBitmap2;
                Bitmap localBitmap3;
                Bitmap localBitmap4;
                Bitmap localBitmap5;
                if (localFile.exists()) {
                    b("Load image from disc cache [%s]");
                    this.q = LoadedFrom.DISC_CACHE;
                    h();
                    localBitmap1 = a(str);
                    if (localBitmap1 != null) {
                        localBitmap2 = localBitmap1;
                        localBitmap3 = localBitmap1;
                        localBitmap4 = localBitmap1;
                        localBitmap5 = localBitmap1;
                    }
                }
                Object localObject1 = null;
            } catch (IllegalStateException localIllegalStateException1) {
                try {
                    if (localBitmap1.getWidth() > 0) {
                        localBitmap2 = localBitmap1;
                        localBitmap3 = localBitmap1;
                        localBitmap4 = localBitmap1;
                        localBitmap5 = localBitmap1;
                        localObject2 = localBitmap1;
                        if (localBitmap1.getHeight() > 0) {
                            break;
                        }
                    }
                    localBitmap2 = localBitmap1;
                    localBitmap3 = localBitmap1;
                    localBitmap4 = localBitmap1;
                    localBitmap5 = localBitmap1;
                    b("Load image from network [%s]");
                    localBitmap2 = localBitmap1;
                    localBitmap3 = localBitmap1;
                    localBitmap4 = localBitmap1;
                    localBitmap5 = localBitmap1;
                    this.q = LoadedFrom.NETWORK;
                    localBitmap2 = localBitmap1;
                    localBitmap3 = localBitmap1;
                    localBitmap4 = localBitmap1;
                    localBitmap5 = localBitmap1;
                    if (this.c.i()) {
                        localBitmap2 = localBitmap1;
                        localBitmap3 = localBitmap1;
                        localBitmap4 = localBitmap1;
                        localBitmap5 = localBitmap1;
                        if (a(localFile)) {
                            localObject2 = str;
                            localBitmap2 = localBitmap1;
                            localBitmap3 = localBitmap1;
                            localBitmap4 = localBitmap1;
                            localBitmap5 = localBitmap1;
                            h();
                            localBitmap2 = localBitmap1;
                            localBitmap3 = localBitmap1;
                            localBitmap4 = localBitmap1;
                            localBitmap5 = localBitmap1;
                            localBitmap1 = a((String) localObject2);
                            if (localBitmap1 != null) {
                                localBitmap2 = localBitmap1;
                                localBitmap3 = localBitmap1;
                                localBitmap4 = localBitmap1;
                                localBitmap5 = localBitmap1;
                                if (localBitmap1.getWidth() > 0) {
                                    localBitmap2 = localBitmap1;
                                    localBitmap3 = localBitmap1;
                                    localBitmap4 = localBitmap1;
                                    localBitmap5 = localBitmap1;
                                    localObject2 = localBitmap1;
                                    if (localBitmap1.getHeight() > 0) {
                                        break;
                                    }
                                }
                            }
                            localBitmap2 = localBitmap1;
                            localBitmap3 = localBitmap1;
                            localBitmap4 = localBitmap1;
                            localBitmap5 = localBitmap1;
                            a(FailReason.FailType.DECODING_ERROR, null);
                            return localBitmap1;
                        }
                    }
                    localBitmap2 = localBitmap1;
                    localBitmap3 = localBitmap1;
                    localBitmap4 = localBitmap1;
                    localBitmap5 = localBitmap1;
                    localObject2 = this.a;
                    continue;
                    localIllegalStateException1 = localIllegalStateException1;
                    localBitmap5 = null;
                } catch (Throwable localThrowable2) {
                    continue;
                } catch (OutOfMemoryError localOutOfMemoryError2) {
                    continue;
                } catch (IOException localIOException2) {
                    continue;
                } catch (IllegalStateException localIllegalStateException2) {
                    continue;
                }
                a(FailReason.FailType.NETWORK_DENIED, null);
                return localBitmap5;
            } catch (TaskCancelledException localTaskCancelledException) {
                throw localTaskCancelledException;
            } catch (IOException localIOException1) {
                localBitmap4 = null;
                com.everimaging.fotorsdk.uil.utils.c.a(localIOException1);
                a(FailReason.FailType.IO_ERROR, localIOException1);
                localObject2 = localBitmap4;
                if (!localFile.exists()) {
                    break;
                }
                localFile.delete();
                return localBitmap4;
            } catch (OutOfMemoryError localOutOfMemoryError1) {
                localBitmap3 = null;
                com.everimaging.fotorsdk.uil.utils.c.a(localOutOfMemoryError1);
                a(FailReason.FailType.OUT_OF_MEMORY, localOutOfMemoryError1);
                return localBitmap3;
            } catch (Throwable localThrowable1) {
                localBitmap2 = null;
                com.everimaging.fotorsdk.uil.utils.c.a(localThrowable1);
                a(FailReason.FailType.UNKNOWN, localThrowable1);
                return localBitmap2;
            }
        }
        return (Bitmap) localObject2;
    }

    private File e() {
        File localFile2 = this.i.q.a(this.a);
        File localFile3 = localFile2.getParentFile();
        File localFile1;
        if (localFile3 != null) {
            localFile1 = localFile2;
            if (!localFile3.exists()) {
                localFile1 = localFile2;
                if (localFile3.mkdirs()) {
                }
            }
        } else {
            localFile2 = this.i.v.a(this.a);
            localFile3 = localFile2.getParentFile();
            localFile1 = localFile2;
            if (localFile3 != null) {
                localFile1 = localFile2;
                if (!localFile3.exists()) {
                    localFile3.mkdirs();
                    localFile1 = localFile2;
                }
            }
        }
        return localFile1;
    }

    private void f() {
        if ((this.c.s()) || (o())) {
            return;
        }
        this.h.post(new Runnable() {
            public void run() {
                LoadAndDisplayImageTask.this.d.b(LoadAndDisplayImageTask.this.a, LoadAndDisplayImageTask.this.b.d());
            }
        });
    }

    private ImageDownloader g() {
        if (this.f.c()) {
            return this.k;
        }
        if (this.f.d()) {
            return this.l;
        }
        return this.j;
    }

    private void h()
            throws LoadAndDisplayImageTask.TaskCancelledException {
        j();
        l();
    }

    private boolean i() {
        return (k()) || (m());
    }

    private void j()
            throws LoadAndDisplayImageTask.TaskCancelledException {
        if (k()) {
            throw new TaskCancelledException();
        }
    }

    private boolean k() {
        if (this.b.e()) {
            b("ImageAware was collected by GC. Task is cancelled. [%s]");
            return true;
        }
        return false;
    }

    private void l()
            throws LoadAndDisplayImageTask.TaskCancelledException {
        if (m()) {
            throw new TaskCancelledException();
        }
    }

    private boolean m() {
        String str = this.f.a(this.b);
        if (!this.o.equals(str)) {
        }
        for (int i1 = 1; i1 != 0; i1 = 0) {
            b("ImageAware is reused for another image. Task is cancelled. [%s]");
            return true;
        }
        return false;
    }

    private void n()
            throws LoadAndDisplayImageTask.TaskCancelledException {
        if (o()) {
            throw new TaskCancelledException();
        }
    }

    private boolean o() {
        if (Thread.interrupted()) {
            b("Task was interrupted [%s]");
            return true;
        }
        return false;
    }

    String a() {
        return this.a;
    }

    public boolean a(int paramInt1, int paramInt2) {
        return (this.e == null) || (b(paramInt1, paramInt2));
    }

    public void run() {
        if (b()) {
        }
        while (c()) {
            return;
        }
        ReentrantLock localReentrantLock = this.g.h;
        b("Start display image task [%s]");
        if (localReentrantLock.isLocked()) {
            b("Image already is loading. Waiting... [%s]");
        }
        localReentrantLock.lock();
        try {
            h();
            Object localObject2 = (Bitmap) this.i.p.a(this.o);
            Object localObject1;
            if (localObject2 == null) {
                localObject2 = d();
                if (localObject2 == null) {
                    return;
                }
                h();
                n();
                localObject1 = localObject2;
                if (this.c.d()) {
                    b("PreProcess image before caching in memory [%s]");
                    localObject2 = this.c.o().a((Bitmap) localObject2);
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                        com.everimaging.fotorsdk.uil.utils.c.d("Pre-processor returned null [%s]", new Object[]{this.o});
                        localObject1 = localObject2;
                    }
                }
                localObject2 = localObject1;
                if (localObject1 != null) {
                    localObject2 = localObject1;
                    if (this.c.h()) {
                        b("Cache image in memory [%s]");
                        this.i.p.a(this.o, localObject1);
                        localObject2 = localObject1;
                    }
                }
            }
            for (; ; ) {
                localObject1 = localObject2;
                if (localObject2 != null) {
                    localObject1 = localObject2;
                    if (this.c.e()) {
                        b("PostProcess image before displaying [%s]");
                        localObject2 = this.c.p().a((Bitmap) localObject2);
                        localObject1 = localObject2;
                        if (localObject2 == null) {
                            com.everimaging.fotorsdk.uil.utils.c.d("Post-processor returned null [%s]", new Object[]{this.o});
                            localObject1 = localObject2;
                        }
                    }
                }
                h();
                n();
                localReentrantLock.unlock();
                localObject1 = new b((Bitmap) localObject1, this.g, this.f, this.q);
                ((b) localObject1).a(this.n);
                if (!this.c.s()) {
                    break;
                }
                ((b) localObject1).run();
                return;
                this.q = LoadedFrom.MEMORY_CACHE;
                b("...Get cached bitmap from memory after waiting. [%s]");
            }
            this.h.post(localRunnable);
        } catch (TaskCancelledException localTaskCancelledException) {
            f();
            return;
        } finally {
            localReentrantLock.unlock();
        }
    }

    class TaskCancelledException
            extends Exception {
        TaskCancelledException() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/LoadAndDisplayImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */