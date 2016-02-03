package mobi.ifunny.studio.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.b.c.e;
import org.b.e.ae;
import org.b.e.af;
import org.b.e.v;
import org.b.f.q;

public class b
        extends org.b.d.a<a> {
    public a a(q paramq, a parama, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        HashMap localHashMap = new HashMap();
        int j = paramq.t();
        int i = 0;
        while (i < j) {
            localHashMap.put(paramq.r(), paramq.e());
            i += 1;
        }
        paramq.c();
        paramq = parama;
        if (parama == null) {
            paramq = new a();
        }
        paramq.a = ((ae) localHashMap.get("text")).m().p();
        paramq.b = ((ae) localHashMap.get("src")).m().o();
        return paramq;
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
        ((Map) localObject).put("text", af.a(parama.a));
        ((Map) localObject).put("src", af.a(parama.b));
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */