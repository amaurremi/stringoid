package mobi.ifunny.studio.source;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.support.v4.view.ah;
import android.support.v4.view.an;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import mobi.ifunny.f;
import mobi.ifunny.rest.content.WebImage;

public class WebSearchActivity
        extends f
        implements an, e {
    private static final String o = WebSearchActivity.class.getSimpleName();
    private String p;
    private String q;
    private SearchView r;

    private void b(String paramString) {
        q localq = f();
        ab localab = localq.a();
        if (TextUtils.equals(this.q, "pic")) {
        }
        for (paramString = l.a(paramString); ; paramString = k.a(paramString)) {
            localab.b(16908290, paramString, "fragment");
            localab.b();
            localq.b();
            return;
        }
    }

    private void b(WebImage paramWebImage) {
        Intent localIntent = new Intent();
        localIntent.putExtra("intent.web_image", paramWebImage);
        setResult(-1, localIntent);
        finish();
    }

    private void c(Intent paramIntent) {
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            this.p = paramIntent.getStringExtra("query");
            this.r.setQuery(this.p, false);
            this.r.clearFocus();
            b(this.p);
        }
    }

    private void n() {
        this.r.setIconified(false);
    }

    public void a(WebImage paramWebImage) {
        b(paramWebImage);
    }

    public boolean a(MenuItem paramMenuItem) {
        if (TextUtils.isEmpty(this.p)) {
            this.r.post(new b(this));
        }
        return true;
    }

    public boolean b(MenuItem paramMenuItem) {
        return true;
    }

    protected boolean k() {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820571, paramMenu);
        this.r = ((SearchView) ah.a(paramMenu.findItem(2131493388)));
        SearchableInfo localSearchableInfo = ((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName());
        this.r.setSearchableInfo(localSearchableInfo);
        this.r.setIconifiedByDefault(false);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 84) {
            n();
            return true;
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        setIntent(paramIntent);
        c(paramIntent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        n();
        return true;
    }

    protected void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        if (paramBundle == null) {
            paramBundle = getIntent();
            this.q = paramBundle.getStringExtra("intent.search_type");
            c(paramBundle);
        }
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        if (TextUtils.isEmpty(this.p)) {
            MenuItem localMenuItem = paramMenu.findItem(2131493388);
            SearchView localSearchView = (SearchView) ah.a(localMenuItem);
            localSearchView.setIconifiedByDefault(false);
            ah.a(localMenuItem, this);
            localSearchView.post(new a(this, localMenuItem));
        }
        return super.onPrepareOptionsMenu(paramMenu);
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        if (paramBundle != null) {
            this.q = paramBundle.getString("intent.search_type");
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putString("intent.search_type", this.q);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/WebSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */