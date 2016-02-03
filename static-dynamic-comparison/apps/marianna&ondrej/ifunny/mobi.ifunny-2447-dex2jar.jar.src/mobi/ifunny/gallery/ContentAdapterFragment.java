package mobi.ifunny.gallery;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.fragment.FragmentPage;
import mobi.ifunny.rest.content.Feed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public abstract class ContentAdapterFragment<D, T extends Feed<D>>
        extends FragmentPage
        implements AdapterView.OnItemClickListener {
    private static final String a = ContentAdapterFragment.class.getSimpleName();
    @InjectView(2131493013)
    protected View additionalLayout;
    private g<D, T> b;
    private AbsListView c;
    @InjectView(2131493093)
    protected View emptyLayout;
    @InjectView(2131493094)
    protected TextView emptyText;
    @InjectView(2131493254)
    protected View progressView;

    protected T B() {
        if (i() == null) {
            return null;
        }
        return i().f();
    }

    protected int C() {
        if (i() == null) {
            return 0;
        }
        return i().getCount();
    }

    protected void D() {
        if (f(p())) {
            F();
            return;
        }
        if (f(q())) {
            r();
            return;
        }
        if (B() == null) {
            I();
            return;
        }
        if (i().getCount() == 0) {
            H();
            return;
        }
        G();
    }

    protected AbsListView E() {
        return this.c;
    }

    protected void F() {
        if (this.progressView == null) {
            return;
        }
        this.additionalLayout.setVisibility(0);
        this.progressView.setVisibility(0);
        this.c.setVisibility(8);
        this.emptyLayout.setVisibility(8);
    }

    protected void G() {
        if (this.progressView == null) {
            return;
        }
        this.additionalLayout.setVisibility(8);
        this.progressView.setVisibility(8);
        this.c.setVisibility(0);
        this.emptyLayout.setVisibility(8);
    }

    protected void H() {
        if (this.progressView == null) {
            return;
        }
        this.additionalLayout.setVisibility(0);
        this.progressView.setVisibility(8);
        this.c.setVisibility(8);
        this.emptyLayout.setVisibility(0);
    }

    protected void I() {
        if (this.progressView == null) {
            return;
        }
        this.additionalLayout.setVisibility(8);
        this.progressView.setVisibility(8);
        this.c.setVisibility(8);
        this.emptyLayout.setVisibility(8);
    }

    public boolean J() {
        return a(new d());
    }

    protected void K() {
        r();
    }

    protected void L() {
        E().post(new b(this));
    }

    protected void M() {
        s();
    }

    protected void a(int paramInt, T paramT) {
        if ((paramT != null) && (paramT.getPaging() != null) && (paramT.getList() != null)) {
            switch (paramInt) {
                default:
                    return;
                case 0:
                    b(paramT);
                    d(0);
                    return;
                case 1:
                    c(paramT);
                    return;
            }
            d(paramT);
            return;
        }
        D();
    }

    protected void a(Bundle paramBundle) {
        paramBundle.putInt("STATE_POSITION", E().getFirstVisiblePosition());
    }

    public void a(AbsListView paramAbsListView) {
        this.c = paramAbsListView;
    }

    protected abstract void a(AdapterView<?> paramAdapterView, View paramView, int paramInt);

    protected void a(T paramT) {
        e();
        if (paramT != null) {
            b(paramT);
            L();
        }
        D();
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if (paramBoolean) {
            if ((B() == null) || (C() == 0)) {
                g(0);
            }
            D();
        }
        while (!f(q())) {
            return;
        }
        s();
    }

    protected boolean a(int paramInt, RestError paramRestError) {
        return false;
    }

    protected abstract <K extends ContentAdapterFragment<D, T>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<T, K> paramRestHttpHandler);

    protected final <K extends ContentAdapterFragment<D, T>> boolean a(String paramString1, String paramString2, RestHttpHandler<T, K> paramRestHttpHandler) {
        String str1 = p();
        String str2 = q();
        if ((f(str1)) || (f(str2))) {
            return false;
        }
        return a(paramString1, paramString2, str1, paramRestHttpHandler);
    }

    protected <K extends ContentAdapterFragment<D, T>> boolean a(String paramString, RestHttpHandler<T, K> paramRestHttpHandler) {
        return a(null, null, paramString, paramRestHttpHandler);
    }

    protected boolean a(RestError paramRestError) {
        return false;
    }

    protected final <K extends ContentAdapterFragment<D, T>> boolean a(RestHttpHandler<T, K> paramRestHttpHandler) {
        String str1 = p();
        String str2 = q();
        if ((f(str1)) || (f(str2))) {
            return false;
        }
        return a(str2, paramRestHttpHandler);
    }

    protected void b(Bundle paramBundle) {
        E().setSelection(paramBundle.getInt("STATE_POSITION"));
    }

    protected void b(T paramT) {
        if (i() != null) {
            i().a(paramT);
        }
    }

    protected boolean b(RestError paramRestError) {
        return false;
    }

    protected void c(T paramT) {
        if (i() != null) {
            i().b(paramT);
        }
    }

    protected void d(int paramInt) {
        E().setSelection(paramInt);
    }

    protected void d(T paramT) {
        if (i() != null) {
            i().c(paramT);
        }
    }

    public void e() {
        I();
        a(new String[]{p(), q()});
        i().e();
        d(0);
    }

    protected void e(int paramInt) {
        E().smoothScrollToPosition(paramInt);
    }

    protected final void e(String paramString) {
        this.emptyText.setText(paramString);
    }

    protected final void f(int paramInt) {
        this.emptyText.setText(paramInt);
    }

    protected void g(int paramInt) {
        if (paramInt == 1) {
            if (B().hasNext()) {
                mobi.ifunny.d.c(a, "request next");
                a(null, B().getNext(), new c(paramInt));
            }
        }
        do {
            do {
                return;
                if (paramInt != -1) {
                    break;
                }
            } while (!B().hasPrev());
            mobi.ifunny.d.c(a, "request prev");
            a(B().getPrev(), null, new c(paramInt));
            return;
        } while (paramInt != 0);
        mobi.ifunny.d.c(a, "request init");
        a(null, null, new c(paramInt));
    }

    protected void h(int paramInt) {
        if (paramInt == 0) {
            F();
        }
    }

    protected g<D, T> i() {
        return this.b;
    }

    protected void i(int paramInt) {
        D();
    }

    protected abstract g<D, T> j();

    protected void j(int paramInt) {
    }

    protected int o() {
        return 50;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        if (this.b != null) {
            this.b.g();
        }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        a(paramAdapterView, paramView, paramInt);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_FEED", B());
        a(paramBundle);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        this.c.setOnItemClickListener(this);
        this.b = j();
        ButterKnife.inject(this, paramView);
        this.c.setAdapter(this.b);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            Feed localFeed = (Feed) paramBundle.getParcelable("STATE_FEED");
            if (localFeed != null) {
                i().a(localFeed);
                if (this.b.getCount() != 0) {
                    b(paramBundle);
                }
            }
        }
    }

    protected String p() {
        return "TASK_REQUEST";
    }

    protected String q() {
        return "TASK_REFRESH";
    }

    protected void r() {
    }

    protected void s() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/ContentAdapterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */