package mobi.ifunny.studio.a.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mobi.ifunny.util.aa;
import org.b.c.e;
import org.b.e.ae;
import org.b.e.f;
import org.b.e.i;
import org.b.f.g;
import org.b.f.q;

public class j
        extends org.b.d.a<a> {
    public a a(q paramq, a parama, boolean paramBoolean) {
        int j = 0;
        if ((!paramBoolean) && (paramq.h())) {
            paramq = null;
            return paramq;
        }
        Object localObject = new HashMap();
        int k = paramq.t();
        int i = 0;
        while (i < k) {
            ((Map) localObject).put(paramq.r(), paramq.e());
            i += 1;
        }
        paramq.c();
        if (parama == null) {
            parama = new a();
        }
        for (; ; ) {
            parama.a = ((ae) ((Map) localObject).get("border")).i().n();
            localObject = ((ae) ((Map) localObject).get("frames")).b().n();
            k = localObject.length;
            i = j;
            for (; ; ) {
                paramq = parama;
                if (i >= k) {
                    break;
                }
                paramq = localObject[i];
                paramq = new g(aa.a(), paramq);
                b localb = (b) paramq.a(b.class);
                paramq.close();
                parama.b.add(localb);
                i += 1;
            }
            parama.b.clear();
        }
    }

    public void a(e parame, a parama, boolean paramBoolean) {
        if (parama == null) {
            if (paramBoolean) {
                throw new NullPointerException();
            }
            parame.d();
            return;
        }
        parame.d(2);
        parame.a("border");
        parame.a(parama.a);
        parame.a("frames");
        parama = parama.b;
        parame.c(parama.size());
        parama = parama.iterator();
        while (parama.hasNext()) {
            parame.a((b) parama.next());
        }
        parame.a();
        parame.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */