package android.support.v4.a;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.d.o;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a<D>
        extends l<D> {
    volatile a<D>.b a;
    volatile a<D>.b b;
    long c;
    long d = -10000L;
    Handler e;

    public a(Context paramContext) {
        super(paramContext);
    }

    void a(a<D>.b parama, D paramD) {
        a(paramD);
        if (this.b == parama) {
            rollbackContentChanged();
            this.d = SystemClock.uptimeMillis();
            this.b = null;
            b();
        }
    }

    public void a(D paramD) {
    }

    public boolean a() {
        if (this.a != null) {
            if (this.b != null) {
                if (this.a.b) {
                    this.a.b = false;
                    this.e.removeCallbacks(this.a);
                }
                this.a = null;
            }
        } else {
            return false;
        }
        if (this.a.b) {
            this.a.b = false;
            this.e.removeCallbacks(this.a);
            this.a = null;
            return false;
        }
        boolean bool = this.a.a(false);
        if (bool) {
            this.b = this.a;
        }
        this.a = null;
        return bool;
    }

    void b() {
        if ((this.b == null) && (this.a != null)) {
            if (this.a.b) {
                this.a.b = false;
                this.e.removeCallbacks(this.a);
            }
            if ((this.c > 0L) && (SystemClock.uptimeMillis() < this.d + this.c)) {
                this.a.b = true;
                this.e.postAtTime(this.a, this.d + this.c);
            }
        } else {
            return;
        }
        this.a.a(r.d, (Void[]) null);
    }

    void b(a<D>.b parama, D paramD) {
        if (this.a != parama) {
            a(parama, paramD);
            return;
        }
        if (isAbandoned()) {
            a(paramD);
            return;
        }
        commitContentChanged();
        this.d = SystemClock.uptimeMillis();
        this.a = null;
        deliverResult(paramD);
    }

    public abstract D c();

    protected D d() {
        return (D) c();
    }

    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        if (this.a != null) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("mTask=");
            paramPrintWriter.print(this.a);
            paramPrintWriter.print(" waiting=");
            paramPrintWriter.println(this.a.b);
        }
        if (this.b != null) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("mCancellingTask=");
            paramPrintWriter.print(this.b);
            paramPrintWriter.print(" waiting=");
            paramPrintWriter.println(this.b.b);
        }
        if (this.c != 0L) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("mUpdateThrottle=");
            o.a(this.c, paramPrintWriter);
            paramPrintWriter.print(" mLastLoadCompleteTime=");
            o.a(this.d, SystemClock.uptimeMillis(), paramPrintWriter);
            paramPrintWriter.println();
        }
    }

    protected void onForceLoad() {
        super.onForceLoad();
        a();
        this.a = new b(this);
        b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */