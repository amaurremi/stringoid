package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.everimaging.fotorsdk.R.styleable;
import com.everimaging.fotorsdk.utils.TypefaceUtils;

public class FotorHeaderButton
        extends Button {
    public FotorHeaderButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorHeaderButton, paramInt, 0);
        setTypeface(paramContext.getString(0));
        paramContext.recycle();
    }

    public void setTypeface(String paramString) {
        if (paramString != null) {
        }
        try {
            setTypeface(TypefaceUtils.createFromAssetPath(getContext(), paramString));
            return;
        } catch (Throwable paramString) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorHeaderButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */