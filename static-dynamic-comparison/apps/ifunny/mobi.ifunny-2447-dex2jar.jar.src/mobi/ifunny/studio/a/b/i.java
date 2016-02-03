package mobi.ifunny.studio.a.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.b.c;
import org.b.d.a;
import org.b.e.ae;
import org.b.e.af;
import org.b.e.n;
import org.b.e.v;

public class i
        extends a<d> {
    public d a(org.b.f.q paramq, d paramd, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        paramd = new HashMap();
        int j = paramq.t();
        int i = 0;
        while (i < j) {
            paramd.put(paramq.r(), paramq.e());
            i += 1;
        }
        paramq.c();
        i = ((ae) paramd.get("type")).j().p();
        switch (i) {
            default:
                throw new c("Unknown DraftComicsObject type " + i);
            case 1:
                paramq = new f();
                paramq.e = ((ae) paramd.get("src")).m().o();
                paramq.b = ((ae) paramd.get("left")).k().n();
                paramq.c = ((ae) paramd.get("top")).k().n();
                paramq.d = ((ae) paramd.get("flip")).i().n();
                paramq.f = ((ae) paramd.get("angle")).k().n();
                paramq.g = ((ae) paramd.get("scale")).k().n();
                return paramq;
            case 2:
                h localh = new h();
                localh.e = ((ae) paramd.get("text")).m().p();
                localh.f = ((ae) paramd.get("font")).m().p();
                paramq = (ae) paramd.get("style");
                if (paramq != null) {
                    if (!paramq.h()) {
                        break label590;
                    }
                }
                for (paramq = paramq.m().p(); ; paramq = null) {
                    localh.g = paramq;
                    localh.h = ((ae) paramd.get("size")).k().n();
                    localh.i = mobi.ifunny.util.f.a(((ae) paramd.get("color")).m().p());
                    localh.b = ((ae) paramd.get("left")).k().n();
                    localh.c = ((ae) paramd.get("top")).k().n();
                    localh.d = ((ae) paramd.get("flip")).i().n();
                    localh.j = ((ae) paramd.get("width")).k().n();
                    localh.k = ((ae) paramd.get("height")).k().n();
                    return localh;
                }
            case 3:
                label590:
                paramq = new g();
                paramq.e = ((ae) paramd.get("face_id")).m().p();
                paramq.f = ((ae) paramd.get("url")).m().p();
                paramq.b = ((ae) paramd.get("left")).k().n();
                paramq.c = ((ae) paramd.get("top")).k().n();
                paramq.d = ((ae) paramd.get("flip")).i().n();
                paramq.g = ((ae) paramd.get("angle")).k().n();
                paramq.h = ((ae) paramd.get("scale")).k().n();
                return paramq;
        }
        paramq = new e();
        paramq.e = ((ae) paramd.get("src")).m().o();
        paramq.b = ((ae) paramd.get("left")).k().n();
        paramq.c = ((ae) paramd.get("top")).k().n();
        paramq.d = ((ae) paramd.get("flip")).i().n();
        paramq.f = ((ae) paramd.get("angle")).k().n();
        paramq.g = ((ae) paramd.get("scale")).k().n();
        return paramq;
    }

    public void a(org.b.c.e parame, d paramd, boolean paramBoolean) {
        if (paramd == null) {
            if (paramBoolean) {
                throw new NullPointerException();
            }
            parame.d();
            return;
        }
        Object localObject = new HashMap();
        ((Map) localObject).put("type", af.a(paramd.a));
        switch (paramd.a) {
        }
        for (; ; ) {
            parame.d(((Map) localObject).size());
            paramd = ((Map) localObject).entrySet().iterator();
            while (paramd.hasNext()) {
                localObject = (Map.Entry) paramd.next();
                parame.a((String) ((Map.Entry) localObject).getKey());
                parame.a((ae) ((Map.Entry) localObject).getValue());
            }
            paramd = (f) paramd;
            ((Map) localObject).put("src", af.a(paramd.e));
            ((Map) localObject).put("left", af.a(paramd.b));
            ((Map) localObject).put("top", af.a(paramd.c));
            ((Map) localObject).put("flip", af.a(paramd.d));
            ((Map) localObject).put("angle", af.a(paramd.f));
            ((Map) localObject).put("scale", af.a(paramd.g));
            continue;
            paramd = (h) paramd;
            ((Map) localObject).put("text", af.a(paramd.e));
            ((Map) localObject).put("font", af.a(paramd.f));
            ((Map) localObject).put("style", af.a(paramd.g));
            ((Map) localObject).put("size", af.a(paramd.h));
            ((Map) localObject).put("color", af.a(mobi.ifunny.util.f.a(paramd.i)));
            ((Map) localObject).put("left", af.a(paramd.b));
            ((Map) localObject).put("top", af.a(paramd.c));
            ((Map) localObject).put("flip", af.a(paramd.d));
            ((Map) localObject).put("width", af.a(paramd.j));
            ((Map) localObject).put("height", af.a(paramd.k));
            continue;
            paramd = (g) paramd;
            ((Map) localObject).put("face_id", af.a(paramd.e));
            ((Map) localObject).put("url", af.a(paramd.f));
            ((Map) localObject).put("left", af.a(paramd.b));
            ((Map) localObject).put("top", af.a(paramd.c));
            ((Map) localObject).put("flip", af.a(paramd.d));
            ((Map) localObject).put("angle", af.a(paramd.g));
            ((Map) localObject).put("scale", af.a(paramd.h));
            continue;
            paramd = (e) paramd;
            ((Map) localObject).put("src", af.a(paramd.e));
            ((Map) localObject).put("left", af.a(paramd.b));
            ((Map) localObject).put("top", af.a(paramd.c));
            ((Map) localObject).put("flip", af.a(paramd.d));
            ((Map) localObject).put("angle", af.a(paramd.f));
            ((Map) localObject).put("scale", af.a(paramd.g));
        }
        parame.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */