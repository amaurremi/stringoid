package com.uservoice.uservoicesdk.ui;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public abstract class PaginatedAdapter<T>
        extends ModelAdapter<T> {
    private int page = 1;

    public PaginatedAdapter(Context paramContext, int paramInt, List<T> paramList) {
        super(paramContext, paramInt, paramList);
    }

    protected List<T> getObjects() {
        if (shouldShowSearchResults()) {
            return this.searchResults;
        }
        return this.objects;
    }

    protected abstract int getTotalNumberOfObjects();

    public void loadMore() {
        if ((this.loading) || (this.searchActive) || (this.objects.size() == getTotalNumberOfObjects())) {
            return;
        }
        this.loading = true;
        notifyDataSetChanged();
        loadPage(this.page, new DefaultCallback(this.context) {
            public void onModel(List<T> paramAnonymousList) {
                PaginatedAdapter.this.objects.addAll(paramAnonymousList);
                PaginatedAdapter.access$012(PaginatedAdapter.this, 1);
                PaginatedAdapter.this.loading = false;
                PaginatedAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void reload() {
        if (this.loading) {
            return;
        }
        this.page = 1;
        this.objects = new ArrayList();
        loadMore();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/PaginatedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */