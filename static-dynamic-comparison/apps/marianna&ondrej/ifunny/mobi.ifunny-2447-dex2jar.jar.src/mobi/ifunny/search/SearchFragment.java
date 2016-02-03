package mobi.ifunny.search;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ah;
import android.support.v4.view.an;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.b.g;
import mobi.ifunny.util.r;
import mobi.ifunny.view.FragmentTabWidget;
import mobi.ifunny.view.j;
import mobi.ifunny.view.z;
import uk.co.a.a.b.f;

public class SearchFragment
        extends mobi.ifunny.a
        implements an, b, mobi.ifunny.view.k {
    private String a;
    private String b;
    private m c;
    private uk.co.a.a.a.a.c d;
    private final String e = "STATE_QUERY";
    private final String f = "STATE_PENDING_QUERY";
    @InjectView(2131493292)
    FragmentTabWidget fragmentTabWidget;
    private final String g = "STATE_SELECTED_TAB";
    private MenuItem h;
    private SearchView i;
    @InjectView(2131493293)
    ViewPager viewPager;

    private void a(int paramInt, String paramString) {
        this.fragmentTabWidget.c(paramInt).b(paramString);
    }

    private void b(String paramString) {
        paramString = new z(paramString);
        this.fragmentTabWidget.a(paramString);
    }

    private void c(String paramString) {
        this.c.a(paramString);
        a().a(paramString);
    }

    private boolean d() {
        return (TextUtils.isEmpty(this.a)) || ((!TextUtils.equals(this.a, this.b)) && (!TextUtils.isEmpty(this.b)));
    }

    public void a(int paramInt) {
        a(0, r.a(getResources(), 2131623944, 2131689896, paramInt));
    }

    public void a(int paramInt, boolean paramBoolean) {
        if (paramBoolean) {
            c();
        }
    }

    public void a(String paramString) {
        this.a = paramString;
        this.b = paramString;
        c(paramString);
        if (this.h != null) {
            ah.c(this.h);
        }
    }

    public void a(uk.co.a.a.b.a.b paramb) {
        this.d.a(paramb);
        this.d.a(true);
    }

    public boolean a(MenuItem paramMenuItem) {
        if (d()) {
            this.i.post(new e(this));
            ah.a(this.h, null);
        }
        return true;
    }

    public void b() {
        if (TextUtils.isEmpty(this.a)) {
        }
        a locala;
        do {
            return;
            locala = this.c.a(this.viewPager.getCurrentItem());
        } while (locala == null);
        locala.J();
    }

    public void b(int paramInt) {
    }

    public boolean b(MenuItem paramMenuItem) {
        return true;
    }

    public void c() {
        this.d.d();
        this.d.a(null);
    }

    public void c(int paramInt) {
    }

    public void d(int paramInt) {
        a(1, r.a(getResources(), 2131623943, 2131689894, paramInt));
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = new f();
        paramBundle.a();
        this.d = new uk.co.a.a.a.a.c(getActivity(), paramBundle.b());
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        if (paramBundle == null) {
            g.a(getActivity(), "Search");
        }
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131820566, paramMenu);
        this.h = paramMenu.findItem(2131493388);
        this.i = ((SearchView) ah.a(this.h));
        paramMenu = getActivity();
        paramMenu = ((SearchManager) paramMenu.getSystemService("search")).getSearchableInfo(paramMenu.getComponentName());
        this.i.setSearchableInfo(paramMenu);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903159, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.fragmentTabWidget.setup(this.viewPager);
        this.fragmentTabWidget.setFragmentTabStateListener(this);
        this.c = new m(getChildFragmentManager());
        this.viewPager.setAdapter(this.c);
        b(getString(2131689892));
        b(getString(2131689891));
        return paramLayoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.f();
        this.d = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        b();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (d()) {
            ah.a(this.h, this);
            this.i.setIconifiedByDefault(false);
            this.i.setIconified(false);
            this.i.post(new c(this));
            return;
        }
        this.i.post(new d(this));
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putString("STATE_QUERY", this.a);
        if ((this.i != null) && (this.i.getQuery() != null)) {
            paramBundle.putString("STATE_PENDING_QUERY", this.i.getQuery().toString());
        }
        paramBundle.putInt("STATE_SELECTED_TAB", this.viewPager.getCurrentItem());
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        int j = 0;
        if (paramBundle != null) {
            this.a = paramBundle.getString("STATE_QUERY");
            this.b = paramBundle.getString("STATE_PENDING_QUERY");
            j = paramBundle.getInt("STATE_SELECTED_TAB");
        }
        this.fragmentTabWidget.d(j);
        if (!TextUtils.isEmpty(this.a)) {
            c(this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/SearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */