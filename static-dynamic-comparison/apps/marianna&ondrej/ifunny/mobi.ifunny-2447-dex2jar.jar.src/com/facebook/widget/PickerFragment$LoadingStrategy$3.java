package com.facebook.widget;

import com.facebook.FacebookException;

class PickerFragment$LoadingStrategy$3
        implements GraphObjectAdapter.OnErrorListener {
    PickerFragment$LoadingStrategy$3(PickerFragment.LoadingStrategy paramLoadingStrategy) {
    }

    public void onError(GraphObjectAdapter<?> paramGraphObjectAdapter, FacebookException paramFacebookException) {
        if (PickerFragment.access$500(this.this$1.this$0) != null) {
            PickerFragment.access$500(this.this$1.this$0).onError(this.this$1.this$0, paramFacebookException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$LoadingStrategy$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */