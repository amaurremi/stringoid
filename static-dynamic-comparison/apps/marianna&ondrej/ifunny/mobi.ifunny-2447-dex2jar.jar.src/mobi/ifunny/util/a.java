package mobi.ifunny.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.View;
import mobi.ifunny.f.b;

public class a {
    public static Point a(View paramView) {
        b localb = mobi.ifunny.f.a.a(paramView.getContext());
        int i = (int) TypedValue.applyDimension(1, localb.b(), paramView.getContext().getResources().getDisplayMetrics());
        return new Point((int) TypedValue.applyDimension(1, localb.a(), paramView.getContext().getResources().getDisplayMetrics()), i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */