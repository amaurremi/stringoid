package mobi.ifunny.studio.source;

import android.widget.AbsListView;

import java.util.HashSet;
import java.util.Iterator;

import mobi.ifunny.gallery.a.g;
import mobi.ifunny.k.l;
import mobi.ifunny.k.t;
import mobi.ifunny.k.y;
import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.rest.content.WebImageFeed;

public class f
        extends g<mobi.ifunny.video.a, WebImage, WebImageFeed> {
    private final HashSet<mobi.ifunny.video.a> b = new HashSet();

    public f(AbsListView paramAbsListView) {
        super(paramAbsListView, 2, 25000);
    }

    private void a() {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            ((mobi.ifunny.video.a) localIterator.next()).d();
        }
        this.b.clear();
    }

    protected mobi.ifunny.k.a a(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        return new mobi.ifunny.k.a(new h(this, paramAbsListView.getContext()), d(), paramInt1, paramInt2);
    }

    protected l a(mobi.ifunny.gallery.h<WebImage> paramh, y<WebImage> paramy, String paramString) {
        return new mobi.ifunny.k.f(paramy.g, paramy.f, paramString, paramh.a);
    }

    protected t<mobi.ifunny.video.a> d() {
        return new i(null);
    }

    public void e() {
        super.e();
        a();
    }

    public void g() {
        super.g();
        a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */