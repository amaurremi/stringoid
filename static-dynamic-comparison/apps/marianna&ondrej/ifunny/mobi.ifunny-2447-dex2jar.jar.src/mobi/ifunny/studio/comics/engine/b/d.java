package mobi.ifunny.studio.comics.engine.b;

import android.util.Pair;

import java.util.Iterator;
import java.util.List;

import mobi.ifunny.studio.comics.engine.c.g;
import mobi.ifunny.studio.comics.engine.c.h;
import mobi.ifunny.studio.comics.engine.f;

public class d
        extends i {
    public d(Pair<List<g>, h> paramPair) {
        super(null, paramPair);
    }

    public void a(f paramf) {
        paramf.o();
    }

    public void b(f paramf) {
        paramf.B();
        Object localObject = (Pair) d();
        List localList = (List) ((Pair) localObject).first;
        paramf.b((h) ((Pair) localObject).second);
        localObject = localList.iterator();
        while (((Iterator) localObject).hasNext()) {
            paramf.a((g) ((Iterator) localObject).next());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */