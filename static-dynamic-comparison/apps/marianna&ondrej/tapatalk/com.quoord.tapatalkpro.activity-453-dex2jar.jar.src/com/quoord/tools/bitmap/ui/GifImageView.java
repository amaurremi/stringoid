package com.quoord.tools.bitmap.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.quoord.gif.GifView;
import com.quoord.tapatalkpro.activity.R.styleable;

import java.io.InputStream;

public class GifImageView
        extends RelativeLayout {
    public static final String GIFIMAGEVIEW_AVATER = "avater";
    public static final String GIFIMAGEVIEW_BIG_IMG = "big_image";
    public static final String GIFIMAGEVIEW_FORUM_LOGO = "forum_logo";
    private AttributeSet attrs;
    private ImageView gifTag;
    public GifView gifView;
    private String imageType;
    public ImageView imageView;
    private String localUrl;
    public int position;
    private String url;

    public GifImageView(Context paramContext) {
        super(paramContext);
        init(paramContext, "avater");
    }

    public GifImageView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        if (paramAttributeSet != null) {
            this.attrs = paramAttributeSet;
            this.imageType = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.GifImageView, 0, 0).getString(0);
        }
        init(paramContext, this.imageType);
    }

    public GifImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet);
        if (paramAttributeSet != null) {
            this.attrs = paramAttributeSet;
            this.imageType = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0).getString(0);
        }
        init(paramContext, this.imageType);
    }

    private void init(Context paramContext, String paramString) {
        if ((paramString != null) && (paramString.equals("forum_logo"))) {
            paramContext = (RelativeLayout) inflate(paramContext, 2130903178, null);
            this.imageView = ((ImageView) paramContext.findViewById(2131230845));
            addView(paramContext);
            return;
        }
        paramContext = (RelativeLayout) inflate(paramContext, 2130903177, null);
        this.imageView = ((ImageView) paramContext.findViewById(2131230845));
        this.gifView = ((GifView) paramContext.findViewById(2131231134));
        addView(paramContext);
    }

    public void destroyDrawingCache() {
        if (this.gifView != null) {
            this.gifView.close();
        }
        super.destroyDrawingCache();
    }

    public String getLocalUrl() {
        return this.localUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public void setIcon(Bitmap paramBitmap) {
        this.gifView.close();
        this.gifView.setVisibility(8);
        this.imageView.setVisibility(0);
        this.imageView.setImageBitmap(paramBitmap);
    }

    public void setIs(InputStream paramInputStream) {
        try {
            this.gifView.setVisibility(0);
            this.imageView.setVisibility(8);
            this.imageView.setImageDrawable(null);
            this.gifView.setGifImage(paramInputStream);
            return;
        } catch (Exception paramInputStream) {
        }
    }

    public void setLocalUrl(String paramString) {
        this.localUrl = paramString;
    }

    public void setRes(int paramInt) {
        this.gifView.setVisibility(8);
        this.imageView.setVisibility(0);
        this.imageView.setImageResource(paramInt);
    }

    public void setShowDimension(int paramInt1, int paramInt2) {
        if (this.gifView != null) {
            this.gifView.setShowDimension(paramInt1, paramInt2);
        }
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public void showGifTag(boolean paramBoolean) {
        if (paramBoolean) {
            this.gifTag.setVisibility(0);
            return;
        }
        this.gifTag.setVisibility(8);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/bitmap/ui/GifImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */