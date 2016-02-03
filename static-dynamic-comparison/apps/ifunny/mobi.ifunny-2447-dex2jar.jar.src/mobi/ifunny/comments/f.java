package mobi.ifunny.comments;

import android.content.Context;
import android.widget.ImageView;
import mobi.ifunny.k.i;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.util.r;

public class f
        extends i<com.makeramen.c, g> {
    private mobi.ifunny.util.c a;

    public f(Context paramContext, mobi.ifunny.util.c paramc) {
        super(paramContext);
        this.a = paramc;
    }

    protected void a(g paramg) {
        mobi.ifunny.util.c localc = this.a;
        ImageView localImageView = paramg.a();
        if ((paramg.a != null) && (((User) paramg.a).is_banned)) {
        }
        for (boolean bool = true; ; bool = false) {
            localc.a(localImageView, bool);
            return;
        }
    }

    protected void a(g paramg, com.makeramen.c paramc) {
    }

    protected void a(g paramg, boolean paramBoolean) {
        this.a.a(r.c(((User) paramg.a).getPhotoBgColor()), paramg.b(), paramBoolean);
    }

    protected boolean a() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */