package mobi.ifunny.studio.meme;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ah;
import android.support.v7.a.a;
import android.support.v7.a.e;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import mobi.ifunny.rest.content.MemeSource;

public class MemeSourceActivity
        extends mobi.ifunny.f
        implements k {
    private static final String[] o = {"new", "popular", null};
    private static final int[] p = {2131690073, 2131690075, 2131690074};
    private SearchView q;

    private void c(Intent paramIntent) {
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            paramIntent = paramIntent.getStringExtra("query");
            Intent localIntent = new Intent(this, MemeSearchActivity.class);
            localIntent.setAction("android.intent.action.SEARCH");
            localIntent.putExtra("query", paramIntent);
            startActivityForResult(localIntent, 0);
        }
    }

    private void n() {
        this.q.setIconified(false);
    }

    public void a(MemeSource paramMemeSource) {
        b(paramMemeSource);
    }

    public void b(MemeSource paramMemeSource) {
        Intent localIntent = new Intent();
        localIntent.putExtra("intent.meme_source", paramMemeSource);
        setResult(-1, localIntent);
        finish();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            return;
        } while ((paramInt2 != -1) || (paramIntent == null));
        b((MemeSource) paramIntent.getParcelableExtra("intent.meme"));
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = h();
        paramBundle.c(2);
        int i = 0;
        while (i < o.length) {
            Object localObject = o[i];
            int j = p[i];
            String str = getString(j);
            Bundle localBundle = new Bundle();
            localBundle.putString("arg.category", (String) localObject);
            localObject = new h(this, str, j.class, localBundle);
            paramBundle.a(paramBundle.e().a(j).a((android.support.v7.a.f) localObject));
            i += 1;
        }
        c(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820558, paramMenu);
        this.q = ((SearchView) ah.a(paramMenu.findItem(2131493388)));
        SearchableInfo localSearchableInfo = ((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName());
        this.q.setSearchableInfo(localSearchableInfo);
        this.q.setQueryHint(getString(2131690076));
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

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        h().b(paramBundle.getInt("state.tab_texted", 0));
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("state.tab_texted", h().a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/MemeSourceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */