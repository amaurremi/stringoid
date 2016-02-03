package mobi.ifunny.profile.editor;

import mobi.ifunny.e.k;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.cache.m;

final class o
        extends k<b, d> {
    private boolean a;

    private o(boolean paramBoolean) {
        this.a = paramBoolean;
    }

    public void a(b paramb, m<d> paramm) {
        if (this.a) {
            b.a(paramb, paramm);
            return;
        }
        paramb.a((d) paramm.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */