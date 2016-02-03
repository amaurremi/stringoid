package com.facebook.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.Button;
import com.facebook.android.R.color;
import com.facebook.android.R.dimen;
import com.facebook.android.R.drawable;
import com.facebook.android.R.string;

public class LikeButton
        extends Button {
    private boolean isLiked;

    public LikeButton(Context paramContext, boolean paramBoolean) {
        super(paramContext);
        this.isLiked = paramBoolean;
        initialize();
    }

    private void initialize() {
        setGravity(16);
        setTextColor(getResources().getColor(R.color.com_facebook_likebutton_text_color));
        setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likebutton_text_size));
        setTypeface(Typeface.DEFAULT_BOLD);
        setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.com_facebook_likebutton_compound_drawable_padding));
        setPadding(getResources().getDimensionPixelSize(R.dimen.com_facebook_likebutton_padding_left), getResources().getDimensionPixelSize(R.dimen.com_facebook_likebutton_padding_top), getResources().getDimensionPixelSize(R.dimen.com_facebook_likebutton_padding_right), getResources().getDimensionPixelSize(R.dimen.com_facebook_likebutton_padding_bottom));
        updateForLikeStatus();
    }

    private void updateForLikeStatus() {
        if (this.isLiked) {
            setBackgroundResource(R.drawable.com_facebook_button_like_selected);
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(R.string.com_facebook_like_button_liked));
            return;
        }
        setBackgroundResource(R.drawable.com_facebook_button_like);
        setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_facebook_button_like_icon, 0, 0, 0);
        setText(getResources().getString(R.string.com_facebook_like_button_not_liked));
    }

    public void setLikeState(boolean paramBoolean) {
        if (paramBoolean != this.isLiked) {
            this.isLiked = paramBoolean;
            updateForLikeStatus();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */