package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.android.volley.VolleyError;

public class NetworkImageView
        extends ImageView {
    private int mDefaultImageId;
    private int mErrorImageId;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    public NetworkImageView(Context paramContext) {
        this(paramContext, null);
    }

    public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void loadImageIfNecessary(final boolean paramBoolean) {
        int j = getWidth();
        int k = getHeight();
        int i;
        if ((getLayoutParams() != null) && (getLayoutParams().height == -2) && (getLayoutParams().width == -2)) {
            i = 1;
            if ((j != 0) || (k != 0) || (i != 0)) {
                break label63;
            }
        }
        label63:
        do {
            return;
            i = 0;
            break;
            if (TextUtils.isEmpty(this.mUrl)) {
                if (this.mImageContainer != null) {
                    this.mImageContainer.cancelRequest();
                    this.mImageContainer = null;
                }
                setImageBitmap(null);
                return;
            }
            if ((this.mImageContainer == null) || (this.mImageContainer.getRequestUrl() == null)) {
                break label144;
            }
        } while (this.mImageContainer.getRequestUrl().equals(this.mUrl));
        this.mImageContainer.cancelRequest();
        setImageBitmap(null);
        label144:
        this.mImageContainer = this.mImageLoader.get(this.mUrl, new ImageLoader.ImageListener() {
            public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                if (NetworkImageView.this.mErrorImageId != 0) {
                    NetworkImageView.this.setImageResource(NetworkImageView.this.mErrorImageId);
                }
            }

            public void onResponse(final ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean) {
                if ((paramAnonymousBoolean) && (paramBoolean)) {
                    NetworkImageView.this.post(new Runnable() {
                        public void run() {
                            NetworkImageView .1. this.onResponse(paramAnonymousImageContainer, false);
                        }
                    });
                }
                do {
                    return;
                    if (paramAnonymousImageContainer.getBitmap() != null) {
                        NetworkImageView.this.setImageBitmap(paramAnonymousImageContainer.getBitmap());
                        return;
                    }
                } while (NetworkImageView.this.mDefaultImageId == 0);
                NetworkImageView.this.setImageResource(NetworkImageView.this.mDefaultImageId);
            }
        });
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    protected void onDetachedFromWindow() {
        if (this.mImageContainer != null) {
            this.mImageContainer.cancelRequest();
            setImageBitmap(null);
            this.mImageContainer = null;
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        loadImageIfNecessary(true);
    }

    public void setDefaultImageResId(int paramInt) {
        this.mDefaultImageId = paramInt;
    }

    public void setErrorImageResId(int paramInt) {
        this.mErrorImageId = paramInt;
    }

    public void setImageUrl(String paramString, ImageLoader paramImageLoader) {
        this.mUrl = paramString;
        this.mImageLoader = paramImageLoader;
        loadImageIfNecessary(false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/android/volley/toolbox/NetworkImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */