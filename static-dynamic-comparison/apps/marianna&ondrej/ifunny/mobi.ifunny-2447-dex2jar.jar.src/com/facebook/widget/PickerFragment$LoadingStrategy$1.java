package com.facebook.widget;

import android.os.Bundle;
import android.support.v4.a.l;
import android.support.v4.app.ag;
import com.facebook.FacebookException;

class PickerFragment$LoadingStrategy$1
        implements ag<SimpleGraphObjectCursor<T>> {
    PickerFragment$LoadingStrategy$1(PickerFragment.LoadingStrategy paramLoadingStrategy) {
    }

    public l<SimpleGraphObjectCursor<T>> onCreateLoader(int paramInt, Bundle paramBundle) {
        return this.this$1.onCreateLoader();
    }

    public void onLoadFinished(l<SimpleGraphObjectCursor<T>> paraml, SimpleGraphObjectCursor<T> paramSimpleGraphObjectCursor) {
        if (paraml != this.this$1.loader) {
            throw new FacebookException("Received callback for unknown loader.");
        }
        this.this$1.onLoadFinished((GraphObjectPagingLoader) paraml, paramSimpleGraphObjectCursor);
    }

    public void onLoaderReset(l<SimpleGraphObjectCursor<T>> paraml) {
        if (paraml != this.this$1.loader) {
            throw new FacebookException("Received callback for unknown loader.");
        }
        this.this$1.onLoadReset((GraphObjectPagingLoader) paraml);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/PickerFragment$LoadingStrategy$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */