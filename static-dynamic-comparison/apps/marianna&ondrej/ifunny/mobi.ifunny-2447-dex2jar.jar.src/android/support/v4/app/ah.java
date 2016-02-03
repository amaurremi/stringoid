package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.l;
import android.support.v4.d.d;
import android.support.v4.d.n;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;

class ah
        extends af {
    static boolean a = false;
    final n<ai> b = new n();
    final n<ai> c = new n();
    final String d;
    k e;
    boolean f;
    boolean g;
    boolean h;

    ah(String paramString, k paramk, boolean paramBoolean) {
        this.d = paramString;
        this.e = paramk;
        this.f = paramBoolean;
    }

    private ai c(int paramInt, Bundle paramBundle, ag<Object> paramag) {
        ai localai = new ai(this, paramInt, paramBundle, paramag);
        localai.d = paramag.onCreateLoader(paramInt, paramBundle);
        return localai;
    }

    private ai d(int paramInt, Bundle paramBundle, ag<Object> paramag) {
        try {
            this.h = true;
            paramBundle = c(paramInt, paramBundle, paramag);
            a(paramBundle);
            return paramBundle;
        } finally {
            this.h = false;
        }
    }

    public <D> l<D> a(int paramInt, Bundle paramBundle, ag<D> paramag) {
        if (this.h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        ai localai = (ai) this.b.a(paramInt);
        if (a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
        }
        if (localai == null) {
            paramag = d(paramInt, paramBundle, paramag);
            paramBundle = paramag;
            if (a) {
                Log.v("LoaderManager", "  Created new loader " + paramag);
            }
        }
        for (paramBundle = paramag; ; paramBundle = localai) {
            if ((paramBundle.e) && (this.f)) {
                paramBundle.b(paramBundle.d, paramBundle.g);
            }
            return paramBundle.d;
            if (a) {
                Log.v("LoaderManager", "  Re-using existing loader " + localai);
            }
            localai.c = paramag;
        }
    }

    public void a(int paramInt) {
        if (this.h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (a) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
        }
        int i = this.b.g(paramInt);
        ai localai;
        if (i >= 0) {
            localai = (ai) this.b.f(i);
            this.b.d(i);
            localai.f();
        }
        paramInt = this.c.g(paramInt);
        if (paramInt >= 0) {
            localai = (ai) this.c.f(paramInt);
            this.c.d(paramInt);
            localai.f();
        }
        if ((this.e != null) && (!a())) {
            this.e.b.e();
        }
    }

    void a(ai paramai) {
        this.b.b(paramai.a, paramai);
        if (this.f) {
            paramai.a();
        }
    }

    void a(k paramk) {
        this.e = paramk;
    }

    public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
        int j = 0;
        String str;
        int i;
        ai localai;
        if (this.b.b() > 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.println("Active Loaders:");
            str = paramString + "    ";
            i = 0;
            while (i < this.b.b()) {
                localai = (ai) this.b.f(i);
                paramPrintWriter.print(paramString);
                paramPrintWriter.print("  #");
                paramPrintWriter.print(this.b.e(i));
                paramPrintWriter.print(": ");
                paramPrintWriter.println(localai.toString());
                localai.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
                i += 1;
            }
        }
        if (this.c.b() > 0) {
            paramPrintWriter.print(paramString);
            paramPrintWriter.println("Inactive Loaders:");
            str = paramString + "    ";
            i = j;
            while (i < this.c.b()) {
                localai = (ai) this.c.f(i);
                paramPrintWriter.print(paramString);
                paramPrintWriter.print("  #");
                paramPrintWriter.print(this.c.e(i));
                paramPrintWriter.print(": ");
                paramPrintWriter.println(localai.toString());
                localai.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
                i += 1;
            }
        }
    }

    public boolean a() {
        int j = this.b.b();
        int i = 0;
        boolean bool2 = false;
        if (i < j) {
            ai localai = (ai) this.b.f(i);
            if ((localai.h) && (!localai.f)) {
            }
            for (boolean bool1 = true; ; bool1 = false) {
                bool2 |= bool1;
                i += 1;
                break;
            }
        }
        return bool2;
    }

    public <D> l<D> b(int paramInt) {
        if (this.h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        ai localai = (ai) this.b.a(paramInt);
        if (localai != null) {
            if (localai.n != null) {
                return localai.n.d;
            }
            return localai.d;
        }
        return null;
    }

    public <D> l<D> b(int paramInt, Bundle paramBundle, ag<D> paramag) {
        if (this.h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        ai localai1 = (ai) this.b.a(paramInt);
        if (a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
        }
        if (localai1 != null) {
            ai localai2 = (ai) this.c.a(paramInt);
            if (localai2 == null) {
                break label304;
            }
            if (!localai1.e) {
                break label173;
            }
            if (a) {
                Log.v("LoaderManager", "  Removing last inactive loader: " + localai1);
            }
            localai2.f = false;
            localai2.f();
            localai1.d.abandon();
            this.c.b(paramInt, localai1);
        }
        for (; ; ) {
            return d(paramInt, paramBundle, paramag).d;
            label173:
            if (!localai1.h) {
                if (a) {
                    Log.v("LoaderManager", "  Current loader is stopped; replacing");
                }
                this.b.b(paramInt, null);
                localai1.f();
            } else {
                if (localai1.n != null) {
                    if (a) {
                        Log.v("LoaderManager", "  Removing pending loader: " + localai1.n);
                    }
                    localai1.n.f();
                    localai1.n = null;
                }
                if (a) {
                    Log.v("LoaderManager", "  Enqueuing as new pending loader");
                }
                localai1.n = c(paramInt, paramBundle, paramag);
                return localai1.n.d;
                label304:
                if (a) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + localai1);
                }
                localai1.d.abandon();
                this.c.b(paramInt, localai1);
            }
        }
    }

    void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f) {
            RuntimeException localRuntimeException = new RuntimeException("here");
            localRuntimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
        }
        for (; ; ) {
            return;
            this.f = true;
            int i = this.b.b() - 1;
            while (i >= 0) {
                ((ai) this.b.f(i)).a();
                i -= 1;
            }
        }
    }

    void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.f) {
            RuntimeException localRuntimeException = new RuntimeException("here");
            localRuntimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
            return;
        }
        int i = this.b.b() - 1;
        while (i >= 0) {
            ((ai) this.b.f(i)).e();
            i -= 1;
        }
        this.f = false;
    }

    void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.f) {
            RuntimeException localRuntimeException = new RuntimeException("here");
            localRuntimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
        }
        for (; ; ) {
            return;
            this.g = true;
            this.f = false;
            int i = this.b.b() - 1;
            while (i >= 0) {
                ((ai) this.b.f(i)).b();
                i -= 1;
            }
        }
    }

    void e() {
        if (this.g) {
            if (a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.g = false;
            int i = this.b.b() - 1;
            while (i >= 0) {
                ((ai) this.b.f(i)).c();
                i -= 1;
            }
        }
    }

    void f() {
        int i = this.b.b() - 1;
        while (i >= 0) {
            ((ai) this.b.f(i)).k = true;
            i -= 1;
        }
    }

    void g() {
        int i = this.b.b() - 1;
        while (i >= 0) {
            ((ai) this.b.f(i)).d();
            i -= 1;
        }
    }

    void h() {
        if (!this.g) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            i = this.b.b() - 1;
            while (i >= 0) {
                ((ai) this.b.f(i)).f();
                i -= 1;
            }
            this.b.c();
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        int i = this.c.b() - 1;
        while (i >= 0) {
            ((ai) this.c.f(i)).f();
            i -= 1;
        }
        this.c.c();
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("LoaderManager{");
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        localStringBuilder.append(" in ");
        d.a(this.e, localStringBuilder);
        localStringBuilder.append("}}");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */