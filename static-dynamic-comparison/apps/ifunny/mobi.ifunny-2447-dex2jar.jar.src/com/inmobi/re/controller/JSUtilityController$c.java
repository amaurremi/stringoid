package com.inmobi.re.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.ImageProcessing;
import com.inmobi.re.controller.util.StartActivityForResultCallback;

class JSUtilityController$c
        implements StartActivityForResultCallback {
    JSUtilityController$c(JSUtilityController paramJSUtilityController) {
    }

    public void onActivityResult(int paramInt, Intent paramIntent) {
        if (paramInt == -1) {
            paramIntent = ImageProcessing.getCompressedBitmap(ImageProcessing.convertMediaUriToPath(paramIntent.getData(), this.a.mContext), this.a.mContext);
            paramInt = paramIntent.getWidth();
            int i = paramIntent.getHeight();
            paramIntent = ImageProcessing.getBase64EncodedImage(paramIntent, this.a.mContext);
            this.a.imWebView.raiseGalleryImageSelectedEvent(paramIntent, paramInt, i);
            return;
        }
        this.a.imWebView.raiseError("User did not select a picture", "getGalleryImage");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSUtilityController$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */