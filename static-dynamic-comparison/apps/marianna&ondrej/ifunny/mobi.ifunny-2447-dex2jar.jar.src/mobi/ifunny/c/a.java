package mobi.ifunny.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import mobi.ifunny.main.i;
import mobi.ifunny.search.SearchActivity;

public class a
        extends i {
    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        a().a(getString(2131689714));
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131820551, paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        startActivity(new Intent(getActivity(), SearchActivity.class));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */