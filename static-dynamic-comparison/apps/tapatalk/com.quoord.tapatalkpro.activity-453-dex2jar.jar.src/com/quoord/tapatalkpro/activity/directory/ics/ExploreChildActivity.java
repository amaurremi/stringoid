package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.util.Stack;

public class ExploreChildActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    private QuoordFragment currentFragment = null;
    ProgressDialog progressDialog;
    private MenuItem searchMenuItem;
    private Stack<QuoordFragment> searchStack = new Stack();
    private SearchView searchView;
    private TapatalkCategory tapatalkCategory;

    private void handleIntent(Intent paramIntent) {
        if ("android.intent.action.SEARCH".equals(paramIntent.getAction())) {
            paramIntent = paramIntent.getStringExtra("query");
            this.searchView.clearFocus();
            Intent localIntent = new Intent(this, IcsSearchActivity.class);
            localIntent.putExtra("queryKeyword", paramIntent);
            startActivity(localIntent);
        }
    }

    public void addFragmentToStack(QuoordFragment paramQuoordFragment) {
        this.searchStack.push(paramQuoordFragment);
        showToFront(paramQuoordFragment);
    }

    public void closeProgress() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
        }
    }

    public void createSearchMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131623940, paramMenu);
        this.searchMenuItem = paramMenu.findItem(2131231471);
        this.searchMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("ic_menu_search", this));
        SearchManager localSearchManager = (SearchManager) getSystemService("search");
        this.searchView = ((SearchView) paramMenu.findItem(2131231471).getActionView());
        this.searchView.setSearchableInfo(localSearchManager.getSearchableInfo(getComponentName()));
        int i = getResources().getIdentifier("android:id/search_plate", null, null);
        ((ViewGroup) this.searchView.findViewById(i)).setBackgroundResource(2130839292);
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextChange(String paramAnonymousString) {
                return true;
            }

            public boolean onQueryTextSubmit(String paramAnonymousString) {
                Util.hideSoftKeyb(ExploreChildActivity.this, ExploreChildActivity.this.searchView);
                new SearchRecentSuggestions(ExploreChildActivity.this, "com.quoord.tapatalkpro.activity.SearchSuggestionProvider", 1).saveRecentQuery(paramAnonymousString, null);
                ExploreChildActivity.this.searchView.clearFocus();
                Intent localIntent = new Intent(ExploreChildActivity.this, IcsSearchActivity.class);
                localIntent.putExtra("queryKeyword", paramAnonymousString);
                ExploreChildActivity.this.startActivity(localIntent);
                return true;
            }
        });
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return null;
    }

    public ForumStatus getForumStatus() {
        return null;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    public void manageStack() {
        if (this.searchStack.size() > 1) {
            FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
            localFragmentTransaction.remove((Fragment) this.searchStack.pop());
            localFragmentTransaction.commitAllowingStateLoss();
            showToFront((QuoordFragment) this.searchStack.peek());
            return;
        }
        this.searchStack.clear();
        finish();
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903112);
        this.tapatalkCategory = ((TapatalkCategory) getIntent().getExtras().get("childcategory"));
        addFragmentToStack(ExploreChildFragment.newInstance(this.tapatalkCategory));
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onMenuItemSelected(paramInt, paramMenuItem);
            manageStack();
        }
    }

    public void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        handleIntent(paramIntent);
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        paramMenu.removeGroup(0);
        createSearchMenu(paramMenu);
        return true;
    }

    public void showProgress() {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(this);
            this.progressDialog.setMessage(getString(2131099870));
            this.progressDialog.setIndeterminate(true);
            this.progressDialog.setCancelable(true);
        }
        if (!this.progressDialog.isShowing()) {
            new Handler().post(new Runnable() {
                public void run() {
                    ExploreChildActivity.this.progressDialog.show();
                }
            });
        }
    }

    public void showProgress(String paramString) {
    }

    public void showToFront(QuoordFragment paramQuoordFragment) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.setCustomAnimations(2130968598, 2130968599);
        if (this.currentFragment == null) {
            localFragmentTransaction.add(2131230953, paramQuoordFragment, String.valueOf(paramQuoordFragment.hashCode()));
        }
        for (; ; ) {
            this.currentFragment = paramQuoordFragment;
            localFragmentTransaction.commitAllowingStateLoss();
            invalidateOptionsMenu();
            return;
            if (getSupportFragmentManager().findFragmentByTag(String.valueOf(paramQuoordFragment.hashCode())) != null) {
                localFragmentTransaction.hide(this.currentFragment);
                localFragmentTransaction.show(paramQuoordFragment);
            } else {
                localFragmentTransaction.add(2131230953, paramQuoordFragment, String.valueOf(paramQuoordFragment.hashCode()));
                localFragmentTransaction.hide(this.currentFragment);
                localFragmentTransaction.show(paramQuoordFragment);
            }
        }
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/ExploreChildActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */