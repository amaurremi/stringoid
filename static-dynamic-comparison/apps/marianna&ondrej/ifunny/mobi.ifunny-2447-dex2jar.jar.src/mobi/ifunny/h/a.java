package mobi.ifunny.h;

import android.widget.AbsListView;
import mobi.ifunny.gallery.a.b;
import mobi.ifunny.k.t;
import mobi.ifunny.k.x;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.view.drawable.f;

public class a
        extends b<f, IFunnyFeed> {
    public a(AbsListView paramAbsListView) {
        super(paramAbsListView, 3, 8000);
    }

    protected t<f> d() {
        return new x();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */