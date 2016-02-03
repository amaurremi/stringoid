package mobi.ifunny.studio.a.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.b.c.e;
import org.b.e.ae;
import org.b.e.af;
import org.b.e.n;
import org.b.e.v;
import org.b.f.q;

public class b
        extends org.b.d.a<a> {
    public a a(q paramq, a parama, boolean paramBoolean) {
        Object localObject1 = null;
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        Object localObject2 = new HashMap();
        int j = paramq.t();
        int i = 0;
        while (i < j) {
            ((Map) localObject2).put(paramq.r(), paramq.e());
            i += 1;
        }
        paramq.c();
        paramq = parama;
        if (parama == null) {
            paramq = new a();
        }
        paramq.a = ((ae) ((Map) localObject2).get("top_text")).m().p();
        paramq.b = ((ae) ((Map) localObject2).get("top_font_size")).k().n();
        paramq.c = ((ae) ((Map) localObject2).get("bottom_text")).m().p();
        paramq.d = ((ae) ((Map) localObject2).get("bottom_font_size")).k().n();
        parama = (ae) ((Map) localObject2).get("base_id");
        if (parama != null) {
            if (parama.h()) {
                parama = parama.m().p();
                paramq.e = parama;
            }
        } else {
            parama = (ae) ((Map) localObject2).get("base_url");
            if (parama != null) {
                if (!parama.h()) {
                    break label337;
                }
            }
        }
        label337:
        for (parama = parama.m().p(); ; parama = null) {
            paramq.f = parama;
            localObject2 = (ae) ((Map) localObject2).get("base_src");
            if (localObject2 != null) {
                parama = (a) localObject1;
                if (((ae) localObject2).h()) {
                    parama = ((ae) localObject2).m().o();
                }
                paramq.g = parama;
            }
            return paramq;
            parama = null;
            break;
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
        Object localObject = new HashMap();
        ((Map) localObject).put("top_text", af.a(parama.a));
        ((Map) localObject).put("top_font_size", af.a(parama.b));
        ((Map) localObject).put("bottom_text", af.a(parama.c));
        ((Map) localObject).put("bottom_font_size", af.a(parama.d));
        if (parama.e != null) {
            ((Map) localObject).put("base_id", af.a(parama.e));
        }
        if (parama.f != null) {
            ((Map) localObject).put("base_url", af.a(parama.f));
        }
        if (parama.g != null) {
            ((Map) localObject).put("base_src", af.a(parama.g));
        }
        parame.d(((Map) localObject).size());
        parama = ((Map) localObject).entrySet().iterator();
        while (parama.hasNext()) {
            localObject = (Map.Entry) parama.next();
            parame.a((String) ((Map.Entry) localObject).getKey());
            parame.a((ae) ((Map.Entry) localObject).getValue());
        }
        parame.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */