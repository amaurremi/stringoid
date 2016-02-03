package com.everimaging.fotor.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.everimaging.fotorsdk.utils.TypefaceUtils;
import com.everimaging.photoeffectstudio.R.styleable;

public class FotorButton
        extends Button {
    private String a;

    public FotorButton(Context paramContext) {
        super(paramContext);
        a(paramContext);
    }

    public FotorButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 2130772247);
    }

    public FotorButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorButton, paramInt, 0);
        this.a = paramAttributeSet.getString(0);
        paramAttributeSet.recycle();
        a(paramContext);
    }

    private void a(Context paramContext) {
        if (this.a != null) {
            setTypeface(this.a);
        }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/widget/FotorButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */