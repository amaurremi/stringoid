package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import mobi.ifunny.j;
import mobi.ifunny.view.drawable.b;

public class DotsView
        extends ImageView {
    private b a;

    public DotsView(Context paramContext) {
        this(paramContext, null, 0);
    }

    public DotsView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public DotsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (paramAttributeSet != null) {
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_DotsView);
            paramInt = paramContext.getInt(2, 0);
            int i = paramContext.getColor(1, 0);
            int j = paramContext.getDimensionPixelSize(0, 0);
            int k = paramContext.getDimensionPixelSize(3, 0);
            paramContext.recycle();
            this.a = new b(paramInt, j, i, k);
            setImageDrawable(this.a);
            setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    public int getDotsCount() {
        if (this.a != null) {
            return this.a.a();
        }
        return 0;
    }

    public void setDotsCount(int paramInt) {
        if (this.a != null) {
            this.a.a(paramInt);
            setImageDrawable(null);
            setImageDrawable(this.a);
            requestLayout();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/DotsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */