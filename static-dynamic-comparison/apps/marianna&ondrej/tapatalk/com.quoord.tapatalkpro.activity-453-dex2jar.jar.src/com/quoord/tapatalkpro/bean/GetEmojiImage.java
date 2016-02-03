package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import android.view.View;
import com.quoord.gif.GifDrawable;
import com.quoord.tapatalkpro.util.ImageItem;

import java.io.IOException;
import java.io.InputStream;

public class GetEmojiImage
        implements Html.ImageGetter {
    private Activity mActivity;
    public View view;

    public GetEmojiImage(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    public Drawable getDrawable(String paramString) {
        int i = this.mActivity.getResources().getIdentifier(this.mActivity.getPackageName() + ":drawable/" + paramString, null, null);
        paramString = this.mActivity.getResources();
        if (i != 0) {
            paramString = paramString.openRawResource(i);
            Object localObject = ImageItem.getImageType(paramString);
            try {
                paramString.reset();
                if ((localObject != null) && (((String) localObject).equalsIgnoreCase("image/gif"))) {
                    localObject = new GifDrawable();
                    ((GifDrawable) localObject).setGifImage(paramString);
                    ((GifDrawable) localObject).setBounds(0, 0, ((GifDrawable) localObject).getIntrinsicWidth(), ((GifDrawable) localObject).getIntrinsicHeight());
                    ((GifDrawable) localObject).setContainerView(this.view);
                    return (Drawable) localObject;
                }
            } catch (IOException localIOException) {
                for (; ; ) {
                    localIOException.printStackTrace();
                }
                try {
                    paramString = this.mActivity.getResources().getDrawable(i);
                    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
                    return paramString;
                } catch (Exception paramString) {
                    paramString = this.mActivity.getResources().getDrawable(2130839428);
                    paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
                    return paramString;
                }
            }
        }
        paramString = this.mActivity.getResources().getDrawable(2130839428);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
        return paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/GetEmojiImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */