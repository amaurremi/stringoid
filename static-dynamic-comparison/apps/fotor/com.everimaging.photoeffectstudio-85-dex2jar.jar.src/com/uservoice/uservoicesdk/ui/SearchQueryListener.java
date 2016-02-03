package com.uservoice.uservoicesdk.ui;

import android.widget.SearchView.OnQueryTextListener;
import com.uservoice.uservoicesdk.activity.SearchActivity;

public class SearchQueryListener
        implements SearchView.OnQueryTextListener {
    private final SearchActivity searchActivity;

    public SearchQueryListener(SearchActivity paramSearchActivity) {
        this.searchActivity = paramSearchActivity;
    }

    public boolean onQueryTextChange(String paramString) {
        this.searchActivity.getSearchAdapter().performSearch(paramString);
        if (paramString.length() > 0) {
            this.searchActivity.showSearch();
        }
        for (; ; ) {
            return true;
            this.searchActivity.hideSearch();
        }
    }

    public boolean onQueryTextSubmit(String paramString) {
        this.searchActivity.getSearchAdapter().performSearch(paramString);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/SearchQueryListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */