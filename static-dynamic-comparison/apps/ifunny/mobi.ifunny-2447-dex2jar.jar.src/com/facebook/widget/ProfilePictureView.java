package com.facebook.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.android.R.dimen;
import com.facebook.android.R.drawable;
import com.facebook.android.R.styleable;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;

import java.net.URISyntaxException;

public class ProfilePictureView
        extends FrameLayout {
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    public static final String TAG = ProfilePictureView.class.getSimpleName();
    private Bitmap customizedDefaultProfilePicture = null;
    private ImageView image;
    private Bitmap imageContents;
    private boolean isCropped = true;
    private ImageRequest lastRequest;
    private ProfilePictureView.OnErrorListener onErrorListener;
    private int presetSizeType = -1;
    private String profileId;
    private int queryHeight = 0;
    private int queryWidth = 0;

    public ProfilePictureView(Context paramContext) {
        super(paramContext);
        initialize(paramContext);
    }

    public ProfilePictureView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initialize(paramContext);
        parseAttributes(paramAttributeSet);
    }

    public ProfilePictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initialize(paramContext);
        parseAttributes(paramAttributeSet);
    }

    private int getPresetSizeInPixels(boolean paramBoolean) {
        int i;
        switch (this.presetSizeType) {
            default:
                return 0;
            case -2:
                i = R.dimen.com_facebook_profilepictureview_preset_size_small;
        }
        for (; ; ) {
            return getResources().getDimensionPixelSize(i);
            i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
            continue;
            i = R.dimen.com_facebook_profilepictureview_preset_size_large;
            continue;
            if (!paramBoolean) {
                break;
            }
            i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        }
    }

    private void initialize(Context paramContext) {
        removeAllViews();
        this.image = new ImageView(paramContext);
        paramContext = new FrameLayout.LayoutParams(-1, -1);
        this.image.setLayoutParams(paramContext);
        this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.image);
    }

    private void parseAttributes(AttributeSet paramAttributeSet) {
        paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_profile_picture_view);
        setPresetSize(paramAttributeSet.getInt(R.styleable.com_facebook_profile_picture_view_preset_size, -1));
        this.isCropped = paramAttributeSet.getBoolean(R.styleable.com_facebook_profile_picture_view_is_cropped, true);
        paramAttributeSet.recycle();
    }

    private void processResponse(ImageResponse paramImageResponse) {
        Bitmap localBitmap;
        Exception localException;
        if (paramImageResponse.getRequest() == this.lastRequest) {
            this.lastRequest = null;
            localBitmap = paramImageResponse.getBitmap();
            localException = paramImageResponse.getError();
            if (localException == null) {
                break label92;
            }
            paramImageResponse = this.onErrorListener;
            if (paramImageResponse == null) {
                break label76;
            }
            paramImageResponse.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), localException));
        }
        label76:
        label92:
        do {
            do {
                return;
                Logger.log(LoggingBehavior.REQUESTS, 6, TAG, localException.toString());
                return;
            } while (localBitmap == null);
            setImageBitmap(localBitmap);
        } while (!paramImageResponse.isCachedRedirect());
        sendImageRequest(false);
    }

    private void refreshImage(boolean paramBoolean) {
        boolean bool = updateImageQueryParameters();
        if ((this.profileId == null) || (this.profileId.length() == 0) || ((this.queryWidth == 0) && (this.queryHeight == 0))) {
            setBlankProfilePicture();
        }
        while ((!bool) && (!paramBoolean)) {
            return;
        }
        sendImageRequest(true);
    }

    private void sendImageRequest(boolean paramBoolean) {
        try {
            ImageRequest localImageRequest = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUrl(this.profileId, this.queryWidth, this.queryHeight)).setAllowCachedRedirects(paramBoolean).setCallerTag(this).setCallback(new ProfilePictureView
            .1 (this)).build();
            if (this.lastRequest != null) {
                ImageDownloader.cancelRequest(this.lastRequest);
            }
            this.lastRequest = localImageRequest;
            ImageDownloader.downloadAsync(localImageRequest);
            return;
        } catch (URISyntaxException localURISyntaxException) {
            Logger.log(LoggingBehavior.REQUESTS, 6, TAG, localURISyntaxException.toString());
        }
    }

    private void setBlankProfilePicture() {
        if (this.customizedDefaultProfilePicture == null) {
            if (isCropped()) {
            }
            for (int i = R.drawable.com_facebook_profile_picture_blank_square; ; i = R.drawable.com_facebook_profile_picture_blank_portrait) {
                setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
                return;
            }
        }
        updateImageQueryParameters();
        setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
    }

    private void setImageBitmap(Bitmap paramBitmap) {
        if ((this.image != null) && (paramBitmap != null)) {
            this.imageContents = paramBitmap;
            this.image.setImageBitmap(paramBitmap);
        }
    }

    private boolean updateImageQueryParameters() {
        boolean bool = false;
        int i = getHeight();
        int k = getWidth();
        if ((k < 1) || (i < 1)) {
            return false;
        }
        int j = getPresetSizeInPixels(false);
        if (j != 0) {
            i = j;
        }
        for (; ; ) {
            if (j <= i) {
                if (isCropped()) {
                }
                for (i = j; ; i = 0) {
                    if ((j != this.queryWidth) || (i != this.queryHeight)) {
                        bool = true;
                    }
                    this.queryWidth = j;
                    this.queryHeight = i;
                    return bool;
                }
            }
            if (isCropped()) {
            }
            for (j = i; ; j = 0) {
                break;
            }
            j = k;
        }
    }

    public final ProfilePictureView.OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        refreshImage(false);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int m = 1;
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        int i1 = 0;
        int i2 = View.MeasureSpec.getSize(paramInt2);
        int n = View.MeasureSpec.getSize(paramInt1);
        int k = i2;
        int i = i1;
        int j = paramInt2;
        if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
            k = i2;
            i = i1;
            j = paramInt2;
            if (localLayoutParams.height == -2) {
                k = getPresetSizeInPixels(true);
                j = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                i = 1;
            }
        }
        if ((View.MeasureSpec.getMode(paramInt1) != 1073741824) && (localLayoutParams.width == -2)) {
            paramInt2 = getPresetSizeInPixels(true);
            paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
            i = m;
        }
        for (; ; ) {
            if (i != 0) {
                setMeasuredDimension(paramInt2, k);
                measureChildren(paramInt1, j);
                return;
            }
            super.onMeasure(paramInt1, j);
            return;
            paramInt2 = n;
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        if (paramParcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(paramParcelable);
        }
        do {
            return;
            paramParcelable = (Bundle) paramParcelable;
            super.onRestoreInstanceState(paramParcelable.getParcelable("ProfilePictureView_superState"));
            this.profileId = paramParcelable.getString("ProfilePictureView_profileId");
            this.presetSizeType = paramParcelable.getInt("ProfilePictureView_presetSize");
            this.isCropped = paramParcelable.getBoolean("ProfilePictureView_isCropped");
            this.queryWidth = paramParcelable.getInt("ProfilePictureView_width");
            this.queryHeight = paramParcelable.getInt("ProfilePictureView_height");
            setImageBitmap((Bitmap) paramParcelable.getParcelable("ProfilePictureView_bitmap"));
        } while (!paramParcelable.getBoolean("ProfilePictureView_refresh"));
        refreshImage(true);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable localParcelable = super.onSaveInstanceState();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("ProfilePictureView_superState", localParcelable);
        localBundle.putString("ProfilePictureView_profileId", this.profileId);
        localBundle.putInt("ProfilePictureView_presetSize", this.presetSizeType);
        localBundle.putBoolean("ProfilePictureView_isCropped", this.isCropped);
        localBundle.putParcelable("ProfilePictureView_bitmap", this.imageContents);
        localBundle.putInt("ProfilePictureView_width", this.queryWidth);
        localBundle.putInt("ProfilePictureView_height", this.queryHeight);
        if (this.lastRequest != null) {
        }
        for (boolean bool = true; ; bool = false) {
            localBundle.putBoolean("ProfilePictureView_refresh", bool);
            return localBundle;
        }
    }

    public final void setCropped(boolean paramBoolean) {
        this.isCropped = paramBoolean;
        refreshImage(false);
    }

    public final void setDefaultProfilePicture(Bitmap paramBitmap) {
        this.customizedDefaultProfilePicture = paramBitmap;
    }

    public final void setOnErrorListener(ProfilePictureView.OnErrorListener paramOnErrorListener) {
        this.onErrorListener = paramOnErrorListener;
    }

    public final void setPresetSize(int paramInt) {
        switch (paramInt) {
            default:
                throw new IllegalArgumentException("Must use a predefined preset size");
        }
        this.presetSizeType = paramInt;
        requestLayout();
    }

    public final void setProfileId(String paramString) {
        boolean bool = false;
        if ((Utility.isNullOrEmpty(this.profileId)) || (!this.profileId.equalsIgnoreCase(paramString))) {
            setBlankProfilePicture();
            bool = true;
        }
        this.profileId = paramString;
        refreshImage(bool);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/ProfilePictureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */