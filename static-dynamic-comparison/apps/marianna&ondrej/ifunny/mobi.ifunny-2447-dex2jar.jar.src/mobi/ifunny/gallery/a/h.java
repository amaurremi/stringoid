package mobi.ifunny.gallery.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import mobi.ifunny.gallery.am;
import mobi.ifunny.k.l;
import mobi.ifunny.k.t;
import mobi.ifunny.k.y;
import mobi.ifunny.rest.content.Feed;
import mobi.ifunny.util.ah;

public abstract class h<T extends Drawable, D extends am, E extends Feed<D>, V extends y<D>>
        extends f<D, E> {
    protected LayoutInflater a;

    public h(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        super(paramAbsListView, paramInt1, paramInt2);
        this.a = LayoutInflater.from(paramAbsListView.getContext());
    }

    protected abstract l a(mobi.ifunny.gallery.h<D> paramh, V paramV, String paramString);

    protected abstract void a(V paramV, mobi.ifunny.gallery.h<D> paramh, View paramView);

    protected abstract int b();

    public View c(int paramInt, mobi.ifunny.gallery.h<D> paramh, View paramView, ViewGroup paramViewGroup) {
        am localam = (am) paramh.a;
        Context localContext = paramViewGroup.getContext();
        if (paramView == null) {
            paramView = this.a.inflate(b(), paramViewGroup, false);
            paramViewGroup = c();
            a(paramViewGroup, paramh, paramView);
            paramView.setTag(paramViewGroup);
        }
        for (; ; ) {
            paramViewGroup.e = localam;
            a(a(paramh, paramViewGroup, localam.getThumbUrl(ah.c(localContext))), paramView);
            return paramView;
            paramViewGroup = (y) paramView.getTag();
        }
    }

    protected abstract V c();

    protected abstract t<T> d();

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public boolean hasStableIds() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */