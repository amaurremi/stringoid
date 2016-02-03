package mobi.ifunny.gallery.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import mobi.ifunny.k.a;
import mobi.ifunny.k.l;
import mobi.ifunny.k.z;
import mobi.ifunny.rest.content.FeedPagingList;
import mobi.ifunny.rest.content.IFunny;

public abstract class b<T extends Drawable, E extends FeedPagingList<IFunny>>
        extends h<T, IFunny, E, d> {
    public b(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        super(paramAbsListView, paramInt1, paramInt2);
    }

    protected d a() {
        return new d();
    }

    protected a a(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        return new a(new c(paramAbsListView.getContext()), d(), paramInt1, paramInt2);
    }

    protected l a(mobi.ifunny.gallery.h<IFunny> paramh, d paramd, String paramString) {
        return new z(paramd.g, paramd.f, paramString, paramd);
    }

    protected void a(d paramd, mobi.ifunny.gallery.h<IFunny> paramh, View paramView) {
        paramd.a(paramView);
    }

    protected int b() {
        return 2130903099;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */