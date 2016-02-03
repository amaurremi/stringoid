package mobi.ifunny.gallery.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.ButterKnife;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.rest.content.Feed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.view.DynamicStaggeredGridView;

public abstract class a<D, T extends Feed<D>>
        extends ContentAdapterFragment<D, T>
        implements AdapterView.OnItemClickListener, mobi.ifunny.view.a {
    private static final String a = a.class.getSimpleName();
    private DynamicStaggeredGridView b;

    protected void L() {
    }

    public void O() {
        g(1);
    }

    public void P() {
    }

    protected void a(int paramInt, T paramT) {
        super.a(paramInt, paramT);
        if (paramInt == 1) {
            this.b.r();
        }
        if (paramT != null) {
            if (paramInt != 0) {
                break label53;
            }
            if ((C() != 0) && (B().hasNext())) {
                this.b.l(2130903157);
            }
        }
        label53:
        while ((paramInt != 1) || (B().hasNext())) {
            return;
        }
        this.b.p();
    }

    protected void a(Bundle paramBundle) {
        paramBundle.putInt("STATE_POSITION", this.b.getFirstVisiblePosition());
    }

    protected void a(T paramT) {
        super.a(paramT);
        if ((!this.b.q()) && (B() != null) && (C() != 0) && (B().hasNext())) {
            this.b.l(2130903157);
        }
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if ((paramBoolean) && (!this.b.q()) && (B() != null) && (C() != 0) && (B().hasNext())) {
            this.b.l(2130903157);
        }
    }

    protected boolean a(int paramInt, RestError paramRestError) {
        this.b.r();
        return super.a(paramInt, paramRestError);
    }

    protected DynamicStaggeredGridView b() {
        return (DynamicStaggeredGridView) super.E();
    }

    protected void b(Bundle paramBundle) {
        this.b.setFirstVisiblePosition(paramBundle.getInt("STATE_POSITION"));
    }

    protected void d(int paramInt) {
        this.b.setFirstVisiblePosition(paramInt);
    }

    public void e() {
        this.b.r();
        this.b.p();
        super.e();
    }

    protected void e(int paramInt) {
        this.b.k(paramInt);
    }

    protected void j(int paramInt) {
        if (this.b != null) {
            this.b.r();
        }
    }

    protected int o() {
        return this.b.getOptimalRequestCount() * 4;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2130903098, paramViewGroup, false);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        this.b = ((DynamicStaggeredGridView) ButterKnife.findById(paramView, 2131493075));
        a(this.b);
        this.b.setDynamicAdapterViewListener(this);
        this.b.setAutomaticRequestAtEnd(true);
        this.b.setRequestAtLeastItemsAtEnd(o() / 2);
        super.onViewCreated(paramView, paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */