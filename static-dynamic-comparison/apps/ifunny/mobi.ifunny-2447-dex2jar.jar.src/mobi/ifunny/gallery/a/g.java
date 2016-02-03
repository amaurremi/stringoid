package mobi.ifunny.gallery.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import butterknife.ButterKnife;
import mobi.ifunny.gallery.am;
import mobi.ifunny.k.a;
import mobi.ifunny.k.f;
import mobi.ifunny.k.l;
import mobi.ifunny.k.y;
import mobi.ifunny.rest.content.Feed;

public abstract class g<T extends Drawable, D extends am, E extends Feed<D>>
        extends h<T, D, E, y<D>> {
    public g(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        super(paramAbsListView, paramInt1, paramInt2);
    }

    protected a a(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        return new a(new i(paramAbsListView.getContext()), d(), paramInt1, paramInt2);
    }

    protected l a(mobi.ifunny.gallery.h<D> paramh, y<D> paramy, String paramString) {
        return new f(paramy.g, paramy.f, paramString, paramh.a);
    }

    protected void a(y<D> paramy, mobi.ifunny.gallery.h<D> paramh, View paramView) {
        paramy.f = ButterKnife.findById(paramView, 2131493140);
        paramy.g = ((ImageView) ButterKnife.findById(paramView, 2131493141));
    }

    protected int b() {
        return 2130903121;
    }

    protected y<D> c() {
        return new y();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */