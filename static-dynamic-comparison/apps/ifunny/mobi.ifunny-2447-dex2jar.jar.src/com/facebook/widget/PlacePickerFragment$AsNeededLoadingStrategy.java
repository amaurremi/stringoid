package com.facebook.widget;

import com.facebook.model.GraphPlace;

class PlacePickerFragment$AsNeededLoadingStrategy
        extends PickerFragment<GraphPlace>.LoadingStrategy {
    private PlacePickerFragment$AsNeededLoadingStrategy(PlacePickerFragment paramPlacePickerFragment) {
        super(paramPlacePickerFragment);
    }

    public void attach(GraphObjectAdapter<GraphPlace> paramGraphObjectAdapter) {
        super.attach(paramGraphObjectAdapter);
        this.adapter.setDataNeededListener(new PlacePickerFragment.AsNeededLoadingStrategy .1 (this));
    }

    protected void onLoadFinished(GraphObjectPagingLoader<GraphPlace> paramGraphObjectPagingLoader, SimpleGraphObjectCursor<GraphPlace> paramSimpleGraphObjectCursor) {
        super.onLoadFinished(paramGraphObjectPagingLoader, paramSimpleGraphObjectCursor);
        if ((paramSimpleGraphObjectCursor == null) || (paramGraphObjectPagingLoader.isLoading())) {
        }
        do {
            return;
            this.this$0.hideActivityCircle();
        } while (!paramSimpleGraphObjectCursor.isFromCache());
        if (paramSimpleGraphObjectCursor.areMoreObjectsAvailable()) {
        }
        for (long l = 2000L; ; l = 0L) {
            paramGraphObjectPagingLoader.refreshOriginalRequest(l);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PlacePickerFragment$AsNeededLoadingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */