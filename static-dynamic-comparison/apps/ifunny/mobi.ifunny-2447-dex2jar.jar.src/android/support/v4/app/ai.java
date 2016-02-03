package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.l;
import android.support.v4.a.m;
import android.support.v4.d.d;
import android.support.v4.d.n;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class ai
        implements m<Object> {
    final int a;
    final Bundle b;
    ag<Object> c;
    l<Object> d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    ai n;

    public ai(int paramInt, Bundle paramBundle, ag<Object> paramag) {
        this.a = paramBundle;
        this.b = paramag;
        ag localag;
        this.c = localag;
    }

    void a() {
        if ((this.i) && (this.j)) {
            this.h = true;
        }
        do {
            do {
                return;
            } while (this.h);
            this.h = true;
            if (ah.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if ((this.d == null) && (this.c != null)) {
                this.d = this.c.onCreateLoader(this.a, this.b);
            }
        } while (this.d == null);
        if ((this.d.getClass().isMemberClass()) && (!Modifier.isStatic(this.d.getClass().getModifiers()))) {
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.d);
        }
        if (!this.m) {
            this.d.registerListener(this.a, this);
            this.m = true;
        }
        this.d.startLoading();
    }

    public void a(l<Object> paraml, Object paramObject) {
        if (ah.a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.l) {
            if (ah.a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        }
        do {
            do {
                return;
                if (this.o.b.a(this.a) == this) {
                    break;
                }
            } while (!ah.a);
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
            return;
            ai localai = this.n;
            if (localai != null) {
                if (ah.a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + localai);
                }
                this.n = null;
                this.o.b.b(this.a, null);
                f();
                this.o.a(localai);
                return;
            }
            if ((this.g != paramObject) || (!this.e)) {
                this.g = paramObject;
                this.e = true;
                if (this.h) {
                    b(paraml, paramObject);
                }
            }
            paraml = (ai) this.o.c.a(this.a);
            if ((paraml != null) && (paraml != this)) {
                paraml.f = false;
                paraml.f();
                this.o.c.c(this.a);
            }
        } while ((this.o.e == null) || (this.o.a()));
        this.o.e.b.e();
    }

    public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(this.a);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(this.b);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(this.c);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(this.d);
        if (this.d != null) {
            this.d.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        if ((this.e) || (this.f)) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("mHaveData=");
            paramPrintWriter.print(this.e);
            paramPrintWriter.print("  mDeliveredData=");
            paramPrintWriter.println(this.f);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("mData=");
            paramPrintWriter.println(this.g);
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.print(this.h);
        paramPrintWriter.print(" mReportNextStart=");
        paramPrintWriter.print(this.k);
        paramPrintWriter.print(" mDestroyed=");
        paramPrintWriter.println(this.l);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mRetaining=");
        paramPrintWriter.print(this.i);
        paramPrintWriter.print(" mRetainingStarted=");
        paramPrintWriter.print(this.j);
        paramPrintWriter.print(" mListenerRegistered=");
        paramPrintWriter.println(this.m);
        if (this.n != null) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.println("Pending Loader ");
            paramPrintWriter.print(this.n);
            paramPrintWriter.println(":");
            this.n.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
    }

    void b() {
        if (ah.a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.i = true;
        this.j = this.h;
        this.h = false;
        this.c = null;
    }

    void b(l<Object> paraml, Object paramObject) {
        String str;
        if (this.c != null) {
            if (this.o.e == null) {
                break label159;
            }
            str = this.o.e.b.u;
            this.o.e.b.u = "onLoadFinished";
        }
        for (; ; ) {
            try {
                if (ah.a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + paraml + ": " + paraml.dataToString(paramObject));
                }
                this.c.onLoadFinished(paraml, paramObject);
                if (this.o.e != null) {
                    this.o.e.b.u = str;
                }
                this.f = true;
                return;
            } finally {
                if (this.o.e != null) {
                    this.o.e.b.u = str;
                }
            }
            label159:
            str = null;
        }
    }

    void c() {
        if (this.i) {
            if (ah.a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.i = false;
            if ((this.h != this.j) && (!this.h)) {
                e();
            }
        }
        if ((this.h) && (this.e) && (!this.k)) {
            b(this.d, this.g);
        }
    }

    void d() {
        if ((this.h) && (this.k)) {
            this.k = false;
            if (this.e) {
                b(this.d, this.g);
            }
        }
    }

    void e() {
        if (ah.a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.h = false;
        if ((!this.i) && (this.d != null) && (this.m)) {
            this.m = false;
            this.d.unregisterListener(this);
            this.d.stopLoading();
        }
    }

    void f() {
        if (ah.a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.l = true;
        boolean bool = this.f;
        this.f = false;
        String str;
        if ((this.c != null) && (this.d != null) && (this.e) && (bool)) {
            if (ah.a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.o.e == null) {
                break label272;
            }
            str = this.o.e.b.u;
            this.o.e.b.u = "onLoaderReset";
        }
        for (; ; ) {
            try {
                this.c.onLoaderReset(this.d);
                if (this.o.e != null) {
                    this.o.e.b.u = str;
                }
                this.c = null;
                this.g = null;
                this.e = false;
                if (this.d != null) {
                    if (this.m) {
                        this.m = false;
                        this.d.unregisterListener(this);
                    }
                    this.d.reset();
                }
                if (this.n != null) {
                    this.n.f();
                }
                return;
            } finally {
                if (this.o.e != null) {
                    this.o.e.b.u = str;
                }
            }
            label272:
            str = null;
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(64);
        localStringBuilder.append("LoaderInfo{");
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" #");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" : ");
        d.a(this.d, localStringBuilder);
        localStringBuilder.append("}}");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */