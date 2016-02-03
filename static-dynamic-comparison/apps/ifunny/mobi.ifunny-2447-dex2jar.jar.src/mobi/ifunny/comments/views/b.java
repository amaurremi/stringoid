package mobi.ifunny.comments.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import mobi.ifunny.social.auth.l;

public class b {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Drawable e;
    public final String f;
    public final int g;
    public final int h;
    public final int i;

    public b(Context paramContext, Integer paramInteger) {
        if (paramInteger == null) {
        }
        for (int j = 900001; ; j = paramInteger.intValue() * 1000) {
            this.a = j;
            paramContext = paramContext.getResources();
            this.e = paramContext.getDrawable(2130837943);
            this.f = paramContext.getString(2131689525);
            this.g = paramContext.getColor(2131361820);
            this.b = paramContext.getColor(2131361851);
            this.c = paramContext.getColor(2131361850);
            this.d = paramContext.getColor(2131361849);
            this.h = paramContext.getInteger(2131558402);
            this.i = paramContext.getInteger(2131558403);
            return;
        }
    }

    public Drawable a() {
        return this.e.mutate();
    }

    public boolean a(String paramString) {
        String str = l.a().d();
        return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)) && (str.compareTo(paramString) == 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */