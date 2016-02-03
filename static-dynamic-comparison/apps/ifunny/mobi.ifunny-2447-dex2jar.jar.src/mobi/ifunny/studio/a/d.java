package mobi.ifunny.studio.a;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import mobi.ifunny.util.aa;
import org.b.c;
import org.b.c.e;
import org.b.e.ae;
import org.b.f.g;
import org.b.f.q;

public class d
        extends org.b.d.a<a> {
    public a a(q paramq, a parama, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        Object localObject = new HashMap();
        int j = paramq.t();
        int i = 0;
        while (i < j) {
            ((Map) localObject).put(paramq.r(), paramq.e());
            i += 1;
        }
        paramq.c();
        paramq = new g(aa.a(), (ae) ((Map) localObject).get("header"));
        b localb = (b) paramq.a(b.class);
        paramq.close();
        paramq = localb.a;
        localObject = new g(aa.a(), (ae) ((Map) localObject).get("body"));
        try {
            if (TextUtils.equals(paramq, "caption")) {
                paramq = ((g) localObject).a(mobi.ifunny.studio.a.a.a.class);
            }
            for (; ; ) {
                ((g) localObject).close();
                localObject = parama;
                if (parama == null) {
                    localObject = new a();
                }
                ((a) localObject).a = localb;
                ((a) localObject).b = paramq;
                return (a) localObject;
                if (TextUtils.equals(paramq, "mem")) {
                    paramq = ((g) localObject).a(mobi.ifunny.studio.a.c.a.class);
                } else {
                    if (!TextUtils.equals(paramq, "comics")) {
                        break;
                    }
                    paramq = ((g) localObject).a(mobi.ifunny.studio.a.b.a.class);
                }
            }
            throw new c();
        } finally {
            ((g) localObject).close();
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
        parame.a("header");
        parame.a(parama.a);
        parame.a("body");
        parame.a(parama.b);
        parame.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */