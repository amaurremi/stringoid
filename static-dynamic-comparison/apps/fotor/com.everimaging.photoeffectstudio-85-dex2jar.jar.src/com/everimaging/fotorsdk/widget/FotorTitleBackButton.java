package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.R.styleable;

public class FotorTitleBackButton
        extends LinearLayout {
    private TextView a;
    private FotorTextView b;

    public FotorTitleBackButton(Context paramContext) {
        this(paramContext, null);
    }

    public FotorTitleBackButton(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultTitleBackButtonStyle);
    }

    public FotorTitleBackButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet);
        a();
        a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorTitleBackButton, paramInt, 0));
    }

    private void a() {
        setClickable(true);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        this.a = new TextView(getContext());
        addView(this.a, localLayoutParams);
        this.b = new FotorTextView(getContext());
        this.b.setGravity(19);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 17;
        addView(this.b, localLayoutParams);
    }

    private void a(TypedArray paramTypedArray) {
        int i = paramTypedArray.getDimensionPixelSize(0, 15);
        this.b.setTextSize(0, i);
        setText(paramTypedArray.getString(1));
        setTextColor(paramTypedArray.getColorStateList(2));
        setIcon(paramTypedArray.getDrawable(3));
        setTypeface(paramTypedArray.getString(4));
        paramTypedArray.recycle();
    }

    @SuppressLint({"NewApi"})
    public void setIcon(Drawable paramDrawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setBackground(paramDrawable);
            return;
        }
        this.a.setBackgroundDrawable(paramDrawable);
    }

    public void setOrientation(int paramInt) {
        super.setOrientation(0);
    }

    public void setPressed(boolean paramBoolean) {
        super.setPressed(paramBoolean);
        this.b.setPressed(paramBoolean);
        this.a.setPressed(paramBoolean);
    }

    public void setText(String paramString) {
        this.b.setText(paramString);
    }

    public void setTextColor(int paramInt) {
        this.b.setTextColor(paramInt);
    }

    public void setTextColor(ColorStateList paramColorStateList) {
        this.b.setTextColor(paramColorStateList);
    }

    public void setTextSize(float paramFloat) {
        this.b.setTextSize(paramFloat);
    }

    public void setTypeface(String paramString) {
        this.b.setTypeface(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorTitleBackButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */