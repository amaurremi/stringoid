package mobi.ifunny.profile;

import android.graphics.Bitmap;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

class q
        extends n<l, Bitmap> {
    public q(l paraml, String paramString, f<Bitmap> paramf) {
        super(paraml, paramString, paramf);
    }

    protected void a(l paraml, m<Bitmap> paramm) {
        super.onPostExecute(paraml, paramm);
        paraml.a((Bitmap) paramm.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */