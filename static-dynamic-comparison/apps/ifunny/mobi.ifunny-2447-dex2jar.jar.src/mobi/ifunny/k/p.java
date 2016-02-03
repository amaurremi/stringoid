package mobi.ifunny.k;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import mobi.ifunny.d;

final class p<K, D>
        extends AsyncTask<Void, Void, D> {
    private AtomicBoolean a;
    private q<K, D> b;
    private WeakReference<m<K, D>> c;
    private D d;

    public p(q<K, D> paramq, m<K, D> paramm) {
        this.b = paramq;
        this.c = new WeakReference(paramm);
        this.a = new AtomicBoolean();
        this.a.set(false);
    }

    protected D a(Void... paramVarArgs) {
        if (this.a.get()) {
            return null;
        }
        this.d = null;
        try {
            this.d = this.b.d();
            return (D) this.d;
        } catch (Exception paramVarArgs) {
            d.b(m.c(), "AsyncBitmapTask.doInBackground", paramVarArgs);
            this.d = null;
        }
        return null;
    }

    public boolean a(boolean paramBoolean) {
        this.a.set(true);
        return cancel(paramBoolean);
    }

    protected void onCancelled() {
        super.onCancelled();
        m localm = (m) this.c.get();
        if (localm == null) {
        }
        WeakReference localWeakReference;
        do {
            return;
            localWeakReference = (WeakReference) m.g(localm).get(this.b);
        } while (localWeakReference == null);
        m.b(localm, localWeakReference.get(), this.b, this.d);
        m.a(localm, this.b);
    }

    protected void onPostExecute(D paramD) {
        if (this.a.get()) {
            onCancelled();
        }
        m localm;
        do {
            do {
                return;
                localm = (m) this.c.get();
            } while (localm == null);
            localObject = (WeakReference) m.g(localm).get(this.b);
        } while (localObject == null);
        Object localObject = ((WeakReference) localObject).get();
        if ((localObject != null) && (this.d != null) && (paramD != null)) {
            m.a(localm, localObject, this.b, this.d);
        }
        for (; ; ) {
            m.b(localm, localObject, this.b);
            return;
            m.a(localm, localObject, this.b);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */