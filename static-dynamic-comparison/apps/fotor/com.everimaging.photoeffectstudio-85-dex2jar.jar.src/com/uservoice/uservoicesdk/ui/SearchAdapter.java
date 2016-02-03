package com.uservoice.uservoicesdk.ui;

import android.content.Context;
import android.widget.BaseAdapter;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestTask;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public abstract class SearchAdapter<T>
        extends BaseAdapter {
    protected Context context;
    protected String currentQuery;
    protected SearchAdapter<T>.SearchTask currentSearch;
    protected boolean loading;
    protected String pendingQuery;
    protected int scope;
    protected boolean searchActive = false;
    protected List<T> searchResults = new ArrayList();

    public void performSearch(String paramString) {
        this.pendingQuery = paramString;
        if (paramString.length() == 0) {
            this.searchResults = new ArrayList();
            this.loading = false;
            notifyDataSetChanged();
            return;
        }
        this.loading = true;
        notifyDataSetChanged();
        if (this.currentSearch != null) {
            this.currentSearch.cancel();
        }
        this.currentSearch = new SearchTask(paramString);
        this.currentSearch.run();
    }

    protected RestTask search(String paramString, Callback<List<T>> paramCallback) {
        return null;
    }

    protected void searchResultsUpdated() {
    }

    public void setScope(int paramInt) {
        this.scope = paramInt;
        notifyDataSetChanged();
    }

    public void setSearchActive(boolean paramBoolean) {
        this.searchActive = paramBoolean;
        this.loading = false;
        notifyDataSetChanged();
    }

    protected boolean shouldShowSearchResults() {
        return (this.searchActive) && (this.pendingQuery != null) && (this.pendingQuery.length() > 0);
    }

    private class SearchTask
            extends TimerTask {
        private final String query;
        private boolean stop;
        private RestTask task;

        public SearchTask(String paramString) {
            this.query = paramString;
        }

        public boolean cancel() {
            this.stop = true;
            if (this.task != null) {
                this.task.cancel(true);
            }
            return true;
        }

        public void run() {
            SearchAdapter.this.currentQuery = this.query;
            this.task = SearchAdapter.this.search(this.query, new DefaultCallback(SearchAdapter.this.context) {
                public void onModel(List<T> paramAnonymousList) {
                    if (!SearchAdapter.SearchTask.this.stop) {
                        SearchAdapter.this.searchResults = paramAnonymousList;
                        SearchAdapter.this.loading = false;
                        SearchAdapter.this.notifyDataSetChanged();
                        SearchAdapter.this.searchResultsUpdated();
                    }
                }
            });
            if (this.task == null) {
                SearchAdapter.this.loading = false;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/SearchAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */