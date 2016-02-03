package mobi.ifunny.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.support.v7.a.a;
import android.text.TextUtils;
import mobi.ifunny.f;

public class SearchActivity
        extends f {
    private void c(Intent paramIntent) {
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            paramIntent = paramIntent.getStringExtra("query");
            if (!TextUtils.isEmpty(paramIntent)) {
                ((SearchFragment) f().a("search")).a(paramIntent);
            }
        }
    }

    protected boolean k() {
        return false;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903111);
        h().a(getString(2131689893));
        if (paramBundle == null) {
            paramBundle = new SearchFragment();
            ab localab = f().a();
            localab.a(2131493009, paramBundle, "search");
            localab.b();
        }
    }

    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        setIntent(paramIntent);
        c(paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/SearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */