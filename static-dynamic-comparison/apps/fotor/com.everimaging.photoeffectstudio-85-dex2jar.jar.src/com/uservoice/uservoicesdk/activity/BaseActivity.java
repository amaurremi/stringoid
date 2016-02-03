package com.uservoice.uservoicesdk.activity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.ViewFlipper;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.ui.MixedSearchAdapter;
import com.uservoice.uservoicesdk.ui.PortalAdapter;
import com.uservoice.uservoicesdk.ui.SearchAdapter;
import com.uservoice.uservoicesdk.ui.SearchExpandListener;
import com.uservoice.uservoicesdk.ui.SearchQueryListener;

public class BaseActivity
        extends FragmentActivity {
    protected ActionBar.Tab allTab;
    protected ActionBar.Tab articlesTab;
    protected ActionBar.Tab ideasTab;
    private int originalNavigationMode = -1;
    protected MixedSearchAdapter searchAdapter;

    public SearchAdapter<?> getSearchAdapter() {
        return this.searchAdapter;
    }

    @SuppressLint({"NewApi"})
    public boolean hasActionBar() {
        return (Build.VERSION.SDK_INT >= 11) && (getActionBar() != null);
    }

    @SuppressLint({"NewApi"})
    public void hideSearch() {
        ((ViewFlipper) findViewById(R.id.uv_view_flipper)).setDisplayedChild(0);
        ActionBar localActionBar;
        if (hasActionBar()) {
            localActionBar = getActionBar();
            if (this.originalNavigationMode != -1) {
                break label42;
            }
        }
        label42:
        for (int i = 0; ; i = this.originalNavigationMode) {
            localActionBar.setNavigationMode(i);
            return;
        }
    }

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (hasActionBar()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    @SuppressLint({"NewApi"})
    protected void setupScopedSearch(Menu paramMenu) {
        if (hasActionBar()) {
            paramMenu.findItem(R.id.uv_action_search).setOnActionExpandListener(new SearchExpandListener((SearchActivity) this));
            ((SearchView) paramMenu.findItem(R.id.uv_action_search).getActionView()).setOnQueryTextListener(new SearchQueryListener((SearchActivity) this));
            this.searchAdapter = new MixedSearchAdapter(this);
            paramMenu = new ListView(this);
            paramMenu.setAdapter(this.searchAdapter);
            paramMenu.setOnItemClickListener(this.searchAdapter);
            ((ViewFlipper) findViewById(R.id.uv_view_flipper)).addView(paramMenu, 1);
            paramMenu = new ActionBar.TabListener() {
                public void onTabReselected(ActionBar.Tab paramAnonymousTab, FragmentTransaction paramAnonymousFragmentTransaction) {
                }

                public void onTabSelected(ActionBar.Tab paramAnonymousTab, FragmentTransaction paramAnonymousFragmentTransaction) {
                    BaseActivity.this.searchAdapter.setScope(((Integer) paramAnonymousTab.getTag()).intValue());
                }

                public void onTabUnselected(ActionBar.Tab paramAnonymousTab, FragmentTransaction paramAnonymousFragmentTransaction) {
                }
            };
            this.allTab = getActionBar().newTab().setText(getString(R.string.uv_all_results_filter)).setTabListener(paramMenu).setTag(Integer.valueOf(PortalAdapter.SCOPE_ALL));
            getActionBar().addTab(this.allTab);
            this.articlesTab = getActionBar().newTab().setText(getString(R.string.uv_articles_filter)).setTabListener(paramMenu).setTag(Integer.valueOf(PortalAdapter.SCOPE_ARTICLES));
            getActionBar().addTab(this.articlesTab);
            this.ideasTab = getActionBar().newTab().setText(getString(R.string.uv_ideas_filter)).setTabListener(paramMenu).setTag(Integer.valueOf(PortalAdapter.SCOPE_IDEAS));
            getActionBar().addTab(this.ideasTab);
            return;
        }
        paramMenu.findItem(R.id.uv_action_search).setVisible(false);
    }

    @SuppressLint({"NewApi"})
    public void showSearch() {
        ((ViewFlipper) findViewById(R.id.uv_view_flipper)).setDisplayedChild(1);
        if (hasActionBar()) {
            if (this.originalNavigationMode == -1) {
                this.originalNavigationMode = getActionBar().getNavigationMode();
            }
            getActionBar().setNavigationMode(2);
        }
    }

    @SuppressLint({"NewApi"})
    public void updateScopedSearch(int paramInt1, int paramInt2, int paramInt3) {
        if (hasActionBar()) {
            this.allTab.setText(String.format("%s (%d)", new Object[]{getString(R.string.uv_all_results_filter), Integer.valueOf(paramInt1)}));
            this.articlesTab.setText(String.format("%s (%d)", new Object[]{getString(R.string.uv_articles_filter), Integer.valueOf(paramInt2)}));
            this.ideasTab.setText(String.format("%s (%d)", new Object[]{getString(R.string.uv_ideas_filter), Integer.valueOf(paramInt3)}));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/activity/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */