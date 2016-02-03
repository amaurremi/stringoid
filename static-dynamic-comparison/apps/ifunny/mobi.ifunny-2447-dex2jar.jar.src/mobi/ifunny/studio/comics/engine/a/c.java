package mobi.ifunny.studio.comics.engine.a;

import java.util.ArrayList;
import java.util.Iterator;

import mobi.ifunny.studio.comics.engine.a;
import mobi.ifunny.studio.comics.engine.b.i;
import mobi.ifunny.studio.comics.engine.f;

public final class c
        extends a {
    private mobi.ifunny.studio.comics.engine.c.c c;

    public c(f paramf, mobi.ifunny.studio.comics.engine.c.c paramc) {
        super(paramf, -1);
        this.c = paramc;
    }

    public void b() {
        ArrayList localArrayList = i();
        if (localArrayList == null) {
        }
        for (int i = 0; ; i = localArrayList.size()) {
            this.c.j();
            int j = 0;
            while (j < i) {
                mobi.ifunny.studio.comics.engine.d locald = (mobi.ifunny.studio.comics.engine.d) localArrayList.get(j);
                this.c.a(locald);
                j += 1;
            }
        }
        super.b();
    }

    public ArrayList<mobi.ifunny.studio.comics.engine.d> h() {
        int i = this.a.size();
        if (i == 0) {
            return null;
        }
        ArrayList localArrayList = new ArrayList(i);
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            localArrayList.add((mobi.ifunny.studio.comics.engine.d) ((i) localIterator.next()).d());
        }
        return localArrayList;
    }

    public ArrayList<mobi.ifunny.studio.comics.engine.d> i() {
        int j = this.a.size();
        if (j <= 0) {
            return null;
        }
        ArrayList localArrayList = new ArrayList(j - 1);
        int i = 0;
        while (i < j - 1) {
            localArrayList.add((mobi.ifunny.studio.comics.engine.d) ((i) this.a.get(i)).d());
            i += 1;
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */