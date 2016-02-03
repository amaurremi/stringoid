package com.uservoice.uservoicesdk.ui;

import android.annotation.SuppressLint;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import com.uservoice.uservoicesdk.activity.SearchActivity;

@SuppressLint({"NewApi"})
public class SearchExpandListener
        implements MenuItem.OnActionExpandListener {
    private final SearchActivity searchActivity;

    public SearchExpandListener(SearchActivity paramSearchActivity) {
        this.searchActivity = paramSearchActivity;
    }

    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem) {
        this.searchActivity.getSearchAdapter().setSearchActive(false);
        this.searchActivity.hideSearch();
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem paramMenuItem) {
        this.searchActivity.getSearchAdapter().setSearchActive(true);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/SearchExpandListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */