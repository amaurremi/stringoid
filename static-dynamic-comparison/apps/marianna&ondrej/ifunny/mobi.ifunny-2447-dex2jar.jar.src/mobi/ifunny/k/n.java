package mobi.ifunny.k;

import android.os.SystemClock;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

class n
        implements Runnable {
    n(m paramm) {
    }

    public void run() {
        if ((m.a(this.a)) && (m.b(this.a).size() > 0)) {
            long l = SystemClock.uptimeMillis();
            Iterator localIterator = m.b(this.a).iterator();
            while (localIterator.hasNext()) {
                q localq = (q) localIterator.next();
                if (l - q.a(localq) >= m.c(this.a)) {
                    m.a(this.a, localq, true);
                }
            }
            if (m.b(this.a).size() > 0) {
                m.d(this.a);
                return;
            }
        }
        m.a(this.a, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */