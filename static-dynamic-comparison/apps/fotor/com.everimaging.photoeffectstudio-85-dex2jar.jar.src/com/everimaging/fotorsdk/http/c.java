package com.everimaging.fotorsdk.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

public abstract class c
        implements m {
    private static final FotorLoggerFactory.c a = FotorLoggerFactory.a("AsyncHttpResponseHandler", FotorLoggerFactory.LoggerType.CONSOLE);
    private final Handler b;
    private String c = "UTF-8";
    private Boolean d = Boolean.valueOf(false);
    private URI e = null;
    private Header[] f = null;

    public c() {
        int i;
        if (Looper.myLooper() == null) {
            i = 1;
            if (i != 0) {
                break label63;
            }
            this.b = new a(this);
        }
        for (; ; ) {
            a(null);
            return;
            i = 0;
            break;
            label63:
            this.b = null;
            a(true);
            a.f(new Object[]{"Current thread has not called Looper.prepare(). Forcing synchronous mode."});
        }
    }

    protected Message a(int paramInt, Object paramObject) {
        return Message.obtain(this.b, paramInt, paramObject);
    }

    public void a(int paramInt) {
        a.c(new Object[]{String.format("Request retry no. %d", new Object[]{Integer.valueOf(paramInt)})});
    }

    public void a(int paramInt1, int paramInt2) {
        FotorLoggerFactory.c localc = a;
        if (paramInt2 > 0) {
        }
        for (int i = paramInt1 / paramInt2 * 100; ; i = -1) {
            localc.c(new Object[]{String.format("Progress %d from %d (%d%%)", new Object[]{Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i)})});
            return;
        }
    }

    public abstract void a(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte);

    public abstract void a(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable);

    protected void a(Message paramMessage) {
        switch (paramMessage.what) {
            default:
                return;
            case 0:
                paramMessage = (Object[]) paramMessage.obj;
                if ((paramMessage != null) && (paramMessage.length >= 3)) {
                    a(((Integer) paramMessage[0]).intValue(), (Header[]) paramMessage[1], (byte[]) paramMessage[2]);
                    return;
                }
                a.e(new Object[]{"SUCCESS_MESSAGE didn't got enough params"});
                return;
            case 1:
                paramMessage = (Object[]) paramMessage.obj;
                if ((paramMessage != null) && (paramMessage.length >= 4)) {
                    a(((Integer) paramMessage[0]).intValue(), (Header[]) paramMessage[1], (byte[]) paramMessage[2], (Throwable) paramMessage[3]);
                    return;
                }
                a.e(new Object[]{"FAILURE_MESSAGE didn't got enough params"});
                return;
            case 2:
                c();
                return;
            case 3:
                d();
                return;
            case 4:
                paramMessage = (Object[]) paramMessage.obj;
                if ((paramMessage != null) && (paramMessage.length >= 2)) {
                    try {
                        a(((Integer) paramMessage[0]).intValue(), ((Integer) paramMessage[1]).intValue());
                        return;
                    } catch (Throwable paramMessage) {
                        a.e(new Object[]{"custom onProgress contains an error", paramMessage});
                        return;
                    }
                }
                a.e(new Object[]{"PROGRESS_MESSAGE didn't got enough params"});
                return;
            case 5:
                paramMessage = (Object[]) paramMessage.obj;
                if ((paramMessage != null) && (paramMessage.length == 1)) {
                    a(((Integer) paramMessage[0]).intValue());
                    return;
                }
                a.e(new Object[]{"RETRY_MESSAGE didn't get enough params"});
                return;
        }
        e();
    }

    protected void a(Runnable paramRunnable) {
        if (paramRunnable != null) {
            if (a()) {
                paramRunnable.run();
            }
        } else {
            return;
        }
        this.b.post(paramRunnable);
    }

    public void a(String paramString) {
        this.c = paramString;
    }

    public void a(URI paramURI) {
        this.e = paramURI;
    }

    public void a(HttpResponse paramHttpResponse)
            throws IOException {
        StatusLine localStatusLine;
        byte[] arrayOfByte;
        if (!Thread.currentThread().isInterrupted()) {
            localStatusLine = paramHttpResponse.getStatusLine();
            arrayOfByte = a(paramHttpResponse.getEntity());
            if (!Thread.currentThread().isInterrupted()) {
                if (localStatusLine.getStatusCode() < 300) {
                    break label85;
                }
                b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), arrayOfByte, new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()));
            }
        }
        return;
        label85:
        b(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), arrayOfByte);
    }

    public void a(boolean paramBoolean) {
        this.d = Boolean.valueOf(paramBoolean);
    }

    public void a(Header[] paramArrayOfHeader) {
        this.f = paramArrayOfHeader;
    }

    public boolean a() {
        return this.d.booleanValue();
    }

    byte[] a(HttpEntity paramHttpEntity)
            throws IOException {
        int i = 4096;
        if (paramHttpEntity != null) {
            InputStream localInputStream = paramHttpEntity.getContent();
            if (localInputStream != null) {
                long l2 = paramHttpEntity.getContentLength();
                if (l2 > 2147483647L) {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
                if (l2 <= 0L) {
                }
                try {
                    for (; ; ) {
                        paramHttpEntity = new ByteArrayBuffer(i);
                        try {
                            byte[] arrayOfByte = new byte['က'];
                            i = 0;
                            label73:
                            int j = localInputStream.read(arrayOfByte);
                            if ((j != -1) && (!Thread.currentThread().isInterrupted())) {
                                i += j;
                                paramHttpEntity.append(arrayOfByte, 0, j);
                                if (l2 <= 0L) {
                                }
                                for (long l1 = 1L; ; l1 = l2) {
                                    b(i, (int) l1);
                                    break label73;
                                    i = (int) l2;
                                    break;
                                }
                            }
                            return paramHttpEntity.toByteArray();
                        } finally {
                            a.a(localInputStream);
                        }
                    }
                    return null;
                } catch (OutOfMemoryError paramHttpEntity) {
                    System.gc();
                    throw new IOException("File too large to fit into available memory");
                }
            }
        }
    }

    public String b() {
        if (this.c == null) {
            return "UTF-8";
        }
        return this.c;
    }

    public final void b(int paramInt) {
        b(a(5, new Object[]{Integer.valueOf(paramInt)}));
    }

    public final void b(int paramInt1, int paramInt2) {
        b(a(4, new Object[]{Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)}));
    }

    public final void b(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte) {
        b(a(0, new Object[]{Integer.valueOf(paramInt), paramArrayOfHeader, paramArrayOfByte}));
    }

    public final void b(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable) {
        b(a(1, new Object[]{Integer.valueOf(paramInt), paramArrayOfHeader, paramArrayOfByte, paramThrowable}));
    }

    protected void b(Message paramMessage) {
        if (a()) {
            a(paramMessage);
        }
        while (Thread.currentThread().isInterrupted()) {
            return;
        }
        this.b.sendMessage(paramMessage);
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        a.c(new Object[]{"Request got cancelled"});
    }

    public final void f() {
        b(a(2, null));
    }

    public final void g() {
        b(a(3, null));
    }

    public final void h() {
        b(a(6, null));
    }

    private static class a
            extends Handler {
        private final c a;

        a(c paramc) {
            this.a = paramc;
        }

        public void handleMessage(Message paramMessage) {
            this.a.a(paramMessage);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */