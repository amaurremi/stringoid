package mobi.ifunny.search;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.GalleryActivity;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.SearchResponse;
import mobi.ifunny.rest.content.SearchResponse.SearchCounters;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Search;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;
import mobi.ifunny.view.DynamicStaggeredGridView;

public class h
        extends a<IFunny, SearchResponse>
        implements mobi.ifunny.view.a {
    private int a;
    private DynamicStaggeredGridView b;

    protected void L() {
    }

    public void O() {
        g(1);
    }

    public void P() {
    }

    protected void a(int paramInt, SearchResponse paramSearchResponse) {
        super.a(paramInt, paramSearchResponse);
        if (paramInt == 1) {
            this.b.r();
        }
        if (paramSearchResponse != null) {
            if (paramInt != 0) {
                break label88;
            }
            c().a(paramSearchResponse.num.content);
            c().d(paramSearchResponse.num.users);
            if ((C() != 0) && (((SearchResponse) B()).hasNext())) {
                this.b.l(2130903157);
            }
        }
        label88:
        while ((paramInt != 1) || (((SearchResponse) B()).hasNext())) {
            return;
        }
        this.b.p();
    }

    protected void a(Bundle paramBundle) {
        paramBundle.putInt("STATE_POSITION", this.b.getFirstVisiblePosition());
    }

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
        paramAdapterView = new Intent(getActivity(), GalleryActivity.class);
        paramAdapterView.putExtra("intent.gallery.type", 40);
        paramAdapterView.putExtra("arg.query", b());
        paramView = new IFunnyCache.ListEntry();
        paramView.a(new IFunnyList((IFunnyList) ((SearchResponse) B()).getPagingList()));
        paramView.a = paramInt;
        GalleryActivity.a(paramView);
        startActivity(paramAdapterView);
    }

    protected void a(SearchResponse paramSearchResponse) {
        super.a(paramSearchResponse);
        if (B() != null) {
            c().a(((SearchResponse) B()).num.content);
            c().d(((SearchResponse) B()).num.users);
            if ((!this.b.q()) && (C() != 0) && (((SearchResponse) B()).hasNext())) {
                this.b.l(2130903157);
            }
        }
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if ((paramBoolean) && (B() != null)) {
            if ((!this.b.q()) && (C() != 0) && (((SearchResponse) B()).hasNext())) {
                this.b.l(2130903157);
            }
            c().a(((SearchResponse) B()).num.content);
            c().d(((SearchResponse) B()).num.users);
        }
    }

    protected boolean a(int paramInt, RestError paramRestError) {
        if (paramInt == 0) {
            c().a(0);
        }
        this.b.r();
        return super.a(paramInt, paramRestError);
    }

    protected <K extends ContentAdapterFragment<IFunny, SearchResponse>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<SearchResponse, K> paramRestHttpHandler) {
        if (TextUtils.isEmpty(b())) {
            return false;
        }
        IFunnyRestRequest.Search.searchContent(this, paramString3, b(), o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
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

    protected DynamicStaggeredGridView f() {
        return (DynamicStaggeredGridView) super.E();
    }

    protected g g() {
        return new g(f());
    }

    protected g h() {
        return (g) super.i();
    }

    protected int o() {
        return this.a;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903098, paramViewGroup, false);
        this.b = ((DynamicStaggeredGridView) paramLayoutInflater.findViewById(2131493075));
        a(this.b);
        return paramLayoutInflater;
    }

    public void onRefreshStarted(View paramView) {
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        e(getResources().getString(2131689897));
        this.a = (this.b.getOptimalRequestCount() * 4);
        this.b.setAutomaticRequestAtEnd(true);
        this.b.setRequestAtLeastItemsAtEnd(this.a / 2);
        this.b.setDynamicAdapterViewListener(this);
        this.b.setAdapter(h());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */