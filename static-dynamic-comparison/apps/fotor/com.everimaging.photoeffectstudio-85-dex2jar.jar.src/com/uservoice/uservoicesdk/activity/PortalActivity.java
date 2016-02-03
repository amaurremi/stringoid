package com.uservoice.uservoicesdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.menu;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.ui.PortalAdapter;

public class PortalActivity
        extends BaseListActivity
        implements SearchActivity {
    public PortalAdapter getModelAdapter() {
        return (PortalAdapter) getListAdapter();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setTitle(R.string.uv_portal_title);
        getListView().setDivider(null);
        setListAdapter(new PortalAdapter(this));
        getListView().setOnItemClickListener(getModelAdapter());
        Babayaga.track(Babayaga.Event.VIEW_KB);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.uv_portal, paramMenu);
        setupScopedSearch(paramMenu);
        return true;
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == R.id.uv_action_contact) {
            startActivity(new Intent(this, ContactActivity.class));
            return true;
        }
        return super.onMenuItemSelected(paramInt, paramMenuItem);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/activity/PortalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */