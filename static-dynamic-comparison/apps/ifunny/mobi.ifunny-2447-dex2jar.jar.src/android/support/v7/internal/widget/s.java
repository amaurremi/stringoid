package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.b.k;
import android.util.AttributeSet;
import android.widget.TextView;

public class s
        extends TextView {
    public s(Context paramContext) {
        this(paramContext, null);
    }

    public s(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public s(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, k.CompatTextView, paramInt, 0);
        boolean bool = paramAttributeSet.getBoolean(0, false);
        paramAttributeSet.recycle();
        if (bool) {
            setTransformationMethod(new t(paramContext));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */