package com.facebook.widget;

class PlacePickerFragment$AsNeededLoadingStrategy$1
        implements GraphObjectAdapter.DataNeededListener {
    PlacePickerFragment$AsNeededLoadingStrategy$1(PlacePickerFragment.AsNeededLoadingStrategy paramAsNeededLoadingStrategy) {
    }

    public void onDataNeeded() {
        if (!this.this$1.loader.isLoading()) {
            this.this$1.loader.followNextLink();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PlacePickerFragment$AsNeededLoadingStrategy$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */