package com.uservoice.uservoicesdk.ui;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.activity.SearchActivity;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.model.Article;
import com.uservoice.uservoicesdk.model.BaseModel;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestResult;
import com.uservoice.uservoicesdk.rest.RestTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedSearchAdapter
        extends SearchAdapter<BaseModel>
        implements AdapterView.OnItemClickListener {
    protected static int LOADING = 1;
    public static int SCOPE_ALL = 0;
    public static int SCOPE_ARTICLES = 1;
    public static int SCOPE_IDEAS = 2;
    protected static int SEARCH_RESULT = 0;
    protected final FragmentActivity context;
    protected LayoutInflater inflater;

    public MixedSearchAdapter(FragmentActivity paramFragmentActivity) {
        this.context = paramFragmentActivity;
        this.inflater = ((LayoutInflater) paramFragmentActivity.getSystemService("layout_inflater"));
    }

    public int getCount() {
        if (this.loading) {
            return 1;
        }
        return getScopedSearchResults().size();
    }

    public Object getItem(int paramInt) {
        if (this.loading) {
            return null;
        }
        return (BaseModel) getScopedSearchResults().get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public int getItemViewType(int paramInt) {
        if (this.loading) {
            return LOADING;
        }
        return SEARCH_RESULT;
    }

    public List<BaseModel> getScopedSearchResults() {
        if (this.scope == SCOPE_ALL) {
            return this.searchResults;
        }
        ArrayList localArrayList;
        Iterator localIterator;
        BaseModel localBaseModel;
        if (this.scope == SCOPE_ARTICLES) {
            localArrayList = new ArrayList();
            localIterator = this.searchResults.iterator();
            while (localIterator.hasNext()) {
                localBaseModel = (BaseModel) localIterator.next();
                if ((localBaseModel instanceof Article)) {
                    localArrayList.add(localBaseModel);
                }
            }
            return localArrayList;
        }
        if (this.scope == SCOPE_IDEAS) {
            localArrayList = new ArrayList();
            localIterator = this.searchResults.iterator();
            while (localIterator.hasNext()) {
                localBaseModel = (BaseModel) localIterator.next();
                if ((localBaseModel instanceof Suggestion)) {
                    localArrayList.add(localBaseModel);
                }
            }
            return localArrayList;
        }
        return null;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int i = getItemViewType(paramInt);
        paramViewGroup = paramView;
        if (paramView == null) {
            if (i != SEARCH_RESULT) {
                break label55;
            }
            paramViewGroup = this.inflater.inflate(R.layout.uv_instant_answer_item, null);
        }
        for (; ; ) {
            if (i == SEARCH_RESULT) {
                Utils.displayInstantAnswer(paramViewGroup, (BaseModel) getItem(paramInt));
            }
            return paramViewGroup;
            label55:
            paramViewGroup = paramView;
            if (i == LOADING) {
                paramViewGroup = this.inflater.inflate(R.layout.uv_loading_item, null);
            }
        }
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isEnabled(int paramInt) {
        return !this.loading;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (getItemViewType(paramInt) == SEARCH_RESULT) {
            Utils.showModel(this.context, (BaseModel) getItem(paramInt));
        }
    }

    protected RestTask search(final String paramString, final Callback<List<BaseModel>> paramCallback) {
        this.currentQuery = paramString;
        Article.loadInstantAnswers(paramString, new Callback() {
            public void onError(RestResult paramAnonymousRestResult) {
                paramCallback.onError(paramAnonymousRestResult);
            }

            public void onModel(List<BaseModel> paramAnonymousList) {
                ArrayList localArrayList1 = new ArrayList();
                ArrayList localArrayList2 = new ArrayList();
                Iterator localIterator = paramAnonymousList.iterator();
                while (localIterator.hasNext()) {
                    BaseModel localBaseModel = (BaseModel) localIterator.next();
                    if ((localBaseModel instanceof Article)) {
                        localArrayList1.add((Article) localBaseModel);
                    } else if ((localBaseModel instanceof Suggestion)) {
                        localArrayList2.add((Suggestion) localBaseModel);
                    }
                }
                Babayaga.track(Babayaga.Event.SEARCH_ARTICLES, paramString, localArrayList1);
                Babayaga.track(Babayaga.Event.SEARCH_IDEAS, paramString, localArrayList2);
                paramCallback.onModel(paramAnonymousList);
            }
        });
    }

    protected void searchResultsUpdated() {
        Iterator localIterator = this.searchResults.iterator();
        int j = 0;
        int i = 0;
        if (localIterator.hasNext()) {
            int k;
            if (((BaseModel) localIterator.next() instanceof Article)) {
                k = j;
                j = i + 1;
            }
            for (i = k; ; i = k) {
                k = j;
                j = i;
                i = k;
                break;
                k = j + 1;
                j = i;
            }
        }
        ((SearchActivity) this.context).updateScopedSearch(this.searchResults.size(), i, j);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/MixedSearchAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */