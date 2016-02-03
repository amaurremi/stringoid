package mobi.ifunny.gallery.a;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.RecyclerListener;
import mobi.ifunny.gallery.g;
import mobi.ifunny.k.a;
import mobi.ifunny.k.l;
import mobi.ifunny.rest.content.Feed;

public abstract class f<D, E extends Feed<D>>
        extends g<D, E>
        implements AbsListView.RecyclerListener {
    private final a a;

    public f(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        this(null, paramAbsListView, paramInt1, paramInt2);
    }

    public f(E paramE, AbsListView paramAbsListView, int paramInt1, int paramInt2) {
        super(paramE);
        paramAbsListView.setRecyclerListener(this);
        this.a = a(paramAbsListView, paramInt1, paramInt2);
    }

    protected abstract a a(AbsListView paramAbsListView, int paramInt1, int paramInt2);

    protected void a(l paraml, View paramView) {
        this.a.a(paraml, paramView);
    }

    public void e() {
        super.e();
        h();
    }

    public void g() {
        super.g();
        this.a.b();
    }

    public void h() {
        this.a.c();
    }

    protected final a i() {
        return this.a;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        h();
    }

    public void onMovedToScrapHeap(View paramView) {
        this.a.a(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */