package com.uservoice.uservoicesdk.activity;

import com.uservoice.uservoicesdk.ui.SearchAdapter;

public abstract interface SearchActivity {
    public abstract SearchAdapter<?> getSearchAdapter();

    public abstract void hideSearch();

    public abstract void showSearch();

    public abstract void updateScopedSearch(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/activity/SearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */