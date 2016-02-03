package mobi.ifunny.studio.meme;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.support.v4.view.ah;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import mobi.ifunny.rest.content.MemeSource;

public class MemeSearchActivity
        extends mobi.ifunny.f
        implements g {
    private String o;
    private SearchView p;

    private void b(MemeSource paramMemeSource) {
        Intent localIntent = new Intent();
        localIntent.putExtra("intent.meme", paramMemeSource);
        setResult(-1, localIntent);
        finish();
    }

    private void c(Intent paramIntent) {
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            this.o = paramIntent.getStringExtra("query");
            new SearchRecentSuggestions(this, getString(2131689890), 1).saveRecentQuery(this.o, null);
            n();
        }
    }

    private void n() {
        ab localab = f().a();
        localab.b(16908290, f.a(this.o), "fragment");
        localab.b();
    }

    private void o() {
        this.p.setIconified(false);
    }

    public void a(MemeSource paramMemeSource) {
        b(paramMemeSource);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        c(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820558, paramMenu);
        this.p = ((SearchView) ah.a(paramMenu.findItem(2131493388)));
        Object localObject = ((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName());
        this.p.setSearchableInfo((SearchableInfo) localObject);
        localObject = this.p;
        if (!TextUtils.isEmpty(this.o)) {
        }
        for (boolean bool = true; ; bool = false) {
            ((SearchView) localObject).setIconifiedByDefault(bool);
            this.p.setQueryHint(getString(2131690076));
            return super.onCreateOptionsMenu(paramMenu);
        }
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 84) {
            o();
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
        o();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/MemeSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */