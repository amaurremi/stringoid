package mobi.ifunny.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class h {
    public static Point a(Context paramContext) {
        paramContext = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        Point localPoint = new Point();
        paramContext.getSize(localPoint);
        return localPoint;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */