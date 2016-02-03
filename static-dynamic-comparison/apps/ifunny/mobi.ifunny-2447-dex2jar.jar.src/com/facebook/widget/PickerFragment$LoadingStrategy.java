package com.facebook.widget;

import android.support.v4.app.af;
import com.facebook.Request;

abstract class PickerFragment$LoadingStrategy {
    protected static final int CACHED_RESULT_REFRESH_DELAY = 2000;
    protected GraphObjectAdapter<T> adapter;
    protected GraphObjectPagingLoader<T> loader;

    PickerFragment$LoadingStrategy(PickerFragment paramPickerFragment) {
    }

    public void attach(GraphObjectAdapter<T> paramGraphObjectAdapter) {
        this.loader = ((GraphObjectPagingLoader) this.this$0.getLoaderManager().a(0, null, new PickerFragment.LoadingStrategy
        .1 (this)));
        this.loader.setOnErrorListener(new PickerFragment.LoadingStrategy .2 (this));
        this.adapter = paramGraphObjectAdapter;
        this.adapter.changeCursor(this.loader.getCursor());
        this.adapter.setOnErrorListener(new PickerFragment.LoadingStrategy .3 (this));
    }

    protected boolean canSkipRoundTripIfCached() {
        return true;
    }

    public void clearResults() {
        if (this.loader != null) {
            this.loader.clearResults();
        }
    }

    public void detach() {
        this.adapter.setDataNeededListener(null);
        this.adapter.setOnErrorListener(null);
        this.loader.setOnErrorListener(null);
        this.loader = null;
        this.adapter = null;
    }

    public boolean isDataPresentOrLoading() {
        return (!this.adapter.isEmpty()) || (this.loader.isLoading());
    }

    protected GraphObjectPagingLoader<T> onCreateLoader() {
        return new GraphObjectPagingLoader(this.this$0.getActivity(), PickerFragment.access$600(this.this$0));
    }

    protected void onLoadFinished(GraphObjectPagingLoader<T> paramGraphObjectPagingLoader, SimpleGraphObjectCursor<T> paramSimpleGraphObjectCursor) {
        this.this$0.updateAdapter(paramSimpleGraphObjectCursor);
    }

    protected void onLoadReset(GraphObjectPagingLoader<T> paramGraphObjectPagingLoader) {
        this.adapter.changeCursor(null);
    }

    protected void onStartLoading(GraphObjectPagingLoader<T> paramGraphObjectPagingLoader, Request paramRequest) {
        this.this$0.displayActivityCircle();
    }

    public void startLoading(Request paramRequest) {
        if (this.loader != null) {
            this.loader.startLoading(paramRequest, canSkipRoundTripIfCached());
            onStartLoading(this.loader, paramRequest);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$LoadingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */