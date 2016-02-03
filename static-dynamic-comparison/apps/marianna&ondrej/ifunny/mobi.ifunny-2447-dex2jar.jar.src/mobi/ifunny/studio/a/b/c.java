package mobi.ifunny.studio.a.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mobi.ifunny.util.aa;
import org.b.c.e;
import org.b.d.a;
import org.b.e.ae;
import org.b.e.v;
import org.b.f.g;
import org.b.f.q;

public class c
        extends a<b> {
    private i a = new i();

    public b a(q paramq, b paramb, boolean paramBoolean) {
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
        if (paramb == null) {
            paramb = new b();
        }
        for (; ; ) {
            paramb.a = mobi.ifunny.util.f.a(((ae) ((Map) localObject).get("bck_color")).m().p());
            localObject = ((ae) ((Map) localObject).get("objects")).b().n();
            k = localObject.length;
            i = j;
            for (; ; ) {
                paramq = paramb;
                if (i >= k) {
                    break;
                }
                paramq = localObject[i];
                paramq = new g(aa.a(), paramq);
                d locald = (d) paramq.a(this.a);
                paramq.close();
                paramb.b.add(locald);
                i += 1;
            }
            paramb.b.clear();
        }
    }

    public void a(e parame, b paramb, boolean paramBoolean) {
        if (paramb == null) {
            if (paramBoolean) {
                throw new NullPointerException();
            }
            parame.d();
            return;
        }
        parame.d(2);
        parame.a("bck_color");
        parame.a(mobi.ifunny.util.f.a(paramb.a));
        parame.a("objects");
        paramb = paramb.b;
        parame.c(paramb.size());
        paramb = paramb.iterator();
        while (paramb.hasNext()) {
            d locald = (d) paramb.next();
            this.a.a(parame, locald);
        }
        parame.a();
        parame.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */