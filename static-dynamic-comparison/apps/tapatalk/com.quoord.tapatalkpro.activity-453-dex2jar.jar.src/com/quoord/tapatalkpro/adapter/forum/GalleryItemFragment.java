package com.quoord.tapatalkpro.adapter.forum;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.quoord.tapatalkpro.ui.ScaleImageView;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ImageInThreadLoader;
import com.quoord.tapatalkpro.util.ImageItem;
import com.quoord.tapatalkpro.util.Util;

import java.io.File;
import java.io.IOException;

public class GalleryItemFragment
        extends QuoordFragment
        implements View.OnTouchListener {
    private int currentPage;
    private ScaleImageView imageView;
    private String type = ImageItem.JPEG;
    private String url;
    private View view;

    public static GalleryItemFragment newInstance(int paramInt, String paramString) {
        GalleryItemFragment localGalleryItemFragment = new GalleryItemFragment();
        localGalleryItemFragment.currentPage = paramInt;
        localGalleryItemFragment.type = ImageInThreadLoader.getImageType(paramString);
        localGalleryItemFragment.url = paramString;
        return localGalleryItemFragment;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        if (this.type.equals(ImageItem.JPEG)) {
            setImage();
            return;
        }
        setWebView();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        if (this.type.equals(ImageItem.JPEG)) {
            this.view = paramLayoutInflater.inflate(2130903431, paramViewGroup, false);
            this.imageView = ((ScaleImageView) this.view.findViewById(2131231730));
        }
        for (; ; ) {
            return this.view;
            this.view = new LinearLayout(getActivity());
        }
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        return false;
    }

    public void setImage() {
        Bitmap localBitmap = Util.getRemotePicFullScreen(this.url);
        this.imageView.setImageBitmap(localBitmap);
    }

    public void setQuoordBackGround(Context paramContext) {
        getView().setBackgroundResource(2131165212);
    }

    public void setWebView() {
        ((LinearLayout) this.view).setOrientation(1);
        ((LinearLayout) this.view).setGravity(17);
        String str = this.url;
        if (!new File(str + ".gif").exists()) {
        }
        try {
            Util.copyFile(new File(str), new File(str + ".gif"));
            Object localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options) localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, (BitmapFactory.Options) localObject);
            double d = ((BitmapFactory.Options) localObject).outWidth;
            localObject = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
            if (((DisplayMetrics) localObject).densityDpi < 320) {
            }
            for (d *= 1.5D; ; d *= 2.0D) {
                localObject = new LinearLayout.LayoutParams((int) d, -2);
                ((LinearLayout.LayoutParams) localObject).gravity = 17;
                WebView localWebView = new WebView(getActivity());
                localWebView.loadUrl("file:///" + str + ".gif");
                localWebView.setLayoutParams((ViewGroup.LayoutParams) localObject);
                ((LinearLayout) this.view).addView(localWebView);
                return;
            }
        } catch (IOException localIOException) {
            for (; ; ) {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/GalleryItemFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */