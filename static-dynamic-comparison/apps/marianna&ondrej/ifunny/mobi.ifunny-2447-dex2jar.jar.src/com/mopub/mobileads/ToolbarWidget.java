package com.mopub.mobileads;

import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.TextDrawable;

class ToolbarWidget
        extends RelativeLayout {
    private static final int IMAGE_PADDING_DIPS = 5;
    private static final int IMAGE_SIDE_LENGTH_DIPS = 37;
    private static final int TEXT_PADDING_DIPS = 5;
    private final int mImagePadding;
    private final int mImageSideLength;
    private ImageView mImageView;
    private final int mTextPadding;
    private TextView mTextView;

    private ToolbarWidget(ToolbarWidget.Builder paramBuilder) {
        super(ToolbarWidget.Builder.access$100(paramBuilder));
        Object localObject = new LinearLayout.LayoutParams(0, -2, ToolbarWidget.Builder.access$200(paramBuilder));
        ((LinearLayout.LayoutParams) localObject).gravity = ToolbarWidget.Builder.access$300(paramBuilder);
        setLayoutParams((ViewGroup.LayoutParams) localObject);
        this.mTextPadding = Dips.dipsToIntPixels(5.0F, getContext());
        this.mImagePadding = Dips.dipsToIntPixels(5.0F, getContext());
        this.mImageSideLength = Dips.dipsToIntPixels(37.0F, getContext());
        setVisibility(ToolbarWidget.Builder.access$400(paramBuilder));
        if ((ToolbarWidget.Builder.access$500(paramBuilder)) && (ToolbarWidget.Builder.access$600(paramBuilder) != null)) {
            this.mImageView = new ImageView(getContext());
            this.mImageView.setId((int) Utils.generateUniqueId());
            localObject = new RelativeLayout.LayoutParams(this.mImageSideLength, this.mImageSideLength);
            ((RelativeLayout.LayoutParams) localObject).addRule(15);
            ((RelativeLayout.LayoutParams) localObject).addRule(ToolbarWidget.Builder.access$700(paramBuilder));
            this.mImageView.setPadding(this.mImagePadding, this.mImagePadding, this.mImagePadding, this.mImagePadding);
            this.mImageView.setBackgroundColor(-16777216);
            this.mImageView.getBackground().setAlpha(0);
            this.mImageView.setImageDrawable(ToolbarWidget.Builder.access$600(paramBuilder));
            addView(this.mImageView, (ViewGroup.LayoutParams) localObject);
        }
        if (ToolbarWidget.Builder.access$800(paramBuilder)) {
            this.mTextView = new TextView(getContext());
            this.mTextView.setSingleLine();
            this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.mTextView.setText(ToolbarWidget.Builder.access$900(paramBuilder));
            localObject = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams) localObject).addRule(15);
            if (this.mImageView == null) {
                break label351;
            }
            ((RelativeLayout.LayoutParams) localObject).addRule(0, this.mImageView.getId());
        }
        for (; ; ) {
            this.mTextView.setPadding(this.mTextPadding, this.mTextPadding, this.mTextPadding, this.mTextPadding);
            addView(this.mTextView, (ViewGroup.LayoutParams) localObject);
            if (ToolbarWidget.Builder.access$1100(paramBuilder) != null) {
                setOnTouchListener(ToolbarWidget.Builder.access$1100(paramBuilder));
            }
            return;
            label351:
            ((RelativeLayout.LayoutParams) localObject).addRule(ToolbarWidget.Builder.access$1000(paramBuilder));
        }
    }

    @Deprecated
    TextDrawable getImageViewDrawable() {
        return (TextDrawable) this.mImageView.getDrawable();
    }

    @Deprecated
    void setImageViewDrawable(TextDrawable paramTextDrawable) {
        this.mImageView.setImageDrawable((Drawable) paramTextDrawable);
    }

    void updateImageText(String paramString) {
        try {
            ((TextDrawable) this.mImageView.getDrawable()).updateText(paramString);
            return;
        } catch (Exception paramString) {
            MoPubLog.d("Unable to update ToolbarWidget text.");
        }
    }

    void updateText(String paramString) {
        if (this.mTextView != null) {
            this.mTextView.setText(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/ToolbarWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */