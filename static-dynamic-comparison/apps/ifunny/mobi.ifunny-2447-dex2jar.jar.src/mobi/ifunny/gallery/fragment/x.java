package mobi.ifunny.gallery.fragment;

import android.graphics.Bitmap;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

class x
        extends n<IFunnyWorkInfoFragment, Bitmap> {
    public x(IFunnyWorkInfoFragment paramIFunnyWorkInfoFragment, String paramString, f<Bitmap> paramf) {
        super(paramIFunnyWorkInfoFragment, paramString, paramf);
    }

    protected void a(IFunnyWorkInfoFragment paramIFunnyWorkInfoFragment, m<Bitmap> paramm) {
        super.onPostExecute(paramIFunnyWorkInfoFragment, paramm);
        paramIFunnyWorkInfoFragment.a((Bitmap) paramm.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */