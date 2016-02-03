package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.everimaging.fotorsdk.R.attr;

public class FotorNavigationButtonShort
        extends a {
    public FotorNavigationButtonShort(Context paramContext) {
        super(paramContext);
    }

    public FotorNavigationButtonShort(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultNavigateBtnStyle);
    }

    public FotorNavigationButtonShort(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected void a() {
        super.a();
        this.h = 0.5F;
        this.i = 0.11666667F;
        this.j = 0.8666667F;
        this.k = 0.05F;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorNavigationButtonShort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */