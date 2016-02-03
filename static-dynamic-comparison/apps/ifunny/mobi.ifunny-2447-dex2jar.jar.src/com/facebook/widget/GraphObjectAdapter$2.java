package com.facebook.widget;

import android.widget.ImageView;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;

class GraphObjectAdapter$2
        implements ImageRequest.Callback {
    GraphObjectAdapter$2(GraphObjectAdapter paramGraphObjectAdapter, String paramString, ImageView paramImageView) {
    }

    public void onCompleted(ImageResponse paramImageResponse) {
        GraphObjectAdapter.access$200(this.this$0, paramImageResponse, this.val$profileId, this.val$imageView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/GraphObjectAdapter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */