package mobi.ifunny.b;

import android.app.Activity;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Iterator;

public class a {
    public static ArrayList<b> a = new ArrayList();

    public static void a(Activity paramActivity) {
        Iterator localIterator = a.iterator();
        while (localIterator.hasNext()) {
            b localb = (b) localIterator.next();
            g.a(paramActivity, localb.a, "content_views", localb.b, localb.c);
        }
        a = new ArrayList();
    }

    public static void a(String paramString1, String paramString2) {
        Iterator localIterator = a.iterator();
        while (localIterator.hasNext()) {
            b localb = (b) localIterator.next();
            if ((TextUtils.equals(localb.a, paramString1)) && (TextUtils.equals(localb.b, paramString2))) {
                localb.c += 1L;
                return;
            }
        }
        a.add(new b(paramString1, paramString2));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */