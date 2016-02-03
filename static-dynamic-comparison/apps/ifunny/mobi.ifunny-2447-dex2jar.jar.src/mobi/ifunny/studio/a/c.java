package mobi.ifunny.studio.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.b.c.e;
import org.b.d.a;
import org.b.e.ae;
import org.b.e.af;
import org.b.e.v;

public class c
        extends a<b> {
    public b a(org.b.f.q paramq, b paramb, boolean paramBoolean) {
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
        paramq = paramb;
        if (paramb == null) {
            paramq = new b();
        }
        paramq.a = ((ae) localHashMap.get("type")).m().p();
        paramq.b = ((ae) localHashMap.get("version")).j().p();
        return paramq;
    }

    public void a(e parame, b paramb, boolean paramBoolean) {
        if (paramb == null) {
            if (paramBoolean) {
                throw new NullPointerException();
            }
            parame.d();
            return;
        }
        Object localObject = new HashMap();
        ((Map) localObject).put("type", af.a(paramb.a));
        ((Map) localObject).put("version", af.a(paramb.b));
        parame.d(((Map) localObject).size());
        paramb = ((Map) localObject).entrySet().iterator();
        while (paramb.hasNext()) {
            localObject = (Map.Entry) paramb.next();
            parame.a((String) ((Map.Entry) localObject).getKey());
            parame.a((ae) ((Map.Entry) localObject).getValue());
        }
        parame.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */