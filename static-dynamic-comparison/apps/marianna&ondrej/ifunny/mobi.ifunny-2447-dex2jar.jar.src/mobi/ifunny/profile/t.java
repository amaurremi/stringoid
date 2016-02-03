package mobi.ifunny.profile;

import mobi.ifunny.util.a.d;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

class t
        extends n<l, d> {
    public t(l paraml, String paramString, f<d> paramf) {
        super(paraml, paramString, paramf);
    }

    protected void a(l paraml, m<d> paramm) {
        super.onPostExecute(paraml, paramm);
        paraml.a((d) paramm.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */