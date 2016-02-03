package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.everimaging.fotorsdk.collage.R.attr;
import com.everimaging.fotorsdk.collage.R.color;
import com.everimaging.fotorsdk.collage.R.dimen;
import com.everimaging.fotorsdk.collage.R.styleable;
import com.everimaging.fotorsdk.widget.FotorTextView;

public class c
        extends LinearLayout {
    private String a;
    private int b;
    private ImageView c;
    private FotorTextView d;
    private int e;

    public c(Context paramContext) {
        super(paramContext);
        Object localObject1 = new TypedValue();
        paramContext.getTheme().resolveAttribute(R.attr.fotorCollagePopupMenuStyle, (TypedValue) localObject1, true);
        localObject1 = paramContext.obtainStyledAttributes(((TypedValue) localObject1).data, R.styleable.FotorCollagePopupMenu);
        this.e = paramContext.getResources().getDimensionPixelSize(R.dimen.fotor_collage_menu_tools_text_left_margin);
        Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) localObject2).gravity = 16;
        ((LinearLayout.LayoutParams) localObject2).height = paramContext.getResources().getDimensionPixelSize(R.dimen.fotor_collage_menu_tools_height);
        setLayoutParams((ViewGroup.LayoutParams) localObject2);
        setMinimumWidth(paramContext.getResources().getDimensionPixelSize(R.dimen.fotor_collage_menu_tools_min_width));
        setOrientation(0);
        this.c = new ImageView(paramContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) localObject2).gravity = 16;
        ((LinearLayout.LayoutParams) localObject2).leftMargin = this.e;
        this.c.setLayoutParams((ViewGroup.LayoutParams) localObject2);
        this.d = new FotorTextView(paramContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) localObject2).gravity = 16;
        ((LinearLayout.LayoutParams) localObject2).leftMargin = this.e;
        this.d.setLayoutParams((ViewGroup.LayoutParams) localObject2);
        localObject2 = ((TypedArray) localObject1).getColorStateList(6);
        if (localObject2 == null) {
            int i = ((TypedArray) localObject1).getColor(6, paramContext.getResources().getColor(R.color.fotor_collage_menu_tools_text_color));
            this.d.setTextColor(i);
        }
        for (; ; ) {
            this.d.setTextSize(16.0F);
            addView(this.c);
            addView(this.d);
            ((TypedArray) localObject1).recycle();
            return;
            this.d.setTextColor((ColorStateList) localObject2);
        }
    }

    public String getText() {
        return this.a;
    }

    public int getTextLeftMargin() {
        return this.b;
    }

    public void setIconDrawalbe(Drawable paramDrawable) {
        this.c.setImageDrawable(paramDrawable);
    }

    public void setOnHighlight(boolean paramBoolean) {
        setPressed(paramBoolean);
        this.c.setPressed(paramBoolean);
        this.d.setPressed(paramBoolean);
    }

    public void setText(String paramString) {
        this.a = paramString;
        this.d.setText(paramString);
    }

    public void setTextLeftMargin(int paramInt) {
        this.b = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */