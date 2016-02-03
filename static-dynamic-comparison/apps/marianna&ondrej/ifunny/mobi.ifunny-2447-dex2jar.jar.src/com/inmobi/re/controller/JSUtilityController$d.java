package com.inmobi.re.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.ImageProcessing;
import com.inmobi.re.controller.util.StartActivityForResultCallback;

class JSUtilityController$d
        implements StartActivityForResultCallback {
    JSUtilityController$d(JSUtilityController paramJSUtilityController, Uri paramUri) {
    }

    public void onActivityResult(int paramInt, Intent paramIntent) {
        if (paramInt == -1) {
            if (paramIntent == null) {
            }
            for (paramIntent = ImageProcessing.convertMediaUriToPath(this.a, this.b.mContext); ; paramIntent = ImageProcessing.convertMediaUriToPath(paramIntent.getData(), this.b.mContext)) {
                paramIntent = ImageProcessing.getCompressedBitmap(paramIntent, this.b.mContext);
                paramInt = paramIntent.getWidth();
                int i = paramIntent.getHeight();
                paramIntent = ImageProcessing.getBase64EncodedImage(paramIntent, this.b.mContext);
                this.b.imWebView.raiseCameraPictureCapturedEvent(paramIntent, paramInt, i);
                return;
            }
        }
        this.b.imWebView.raiseError("User did not take a picture", "takeCameraPicture");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSUtilityController$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */