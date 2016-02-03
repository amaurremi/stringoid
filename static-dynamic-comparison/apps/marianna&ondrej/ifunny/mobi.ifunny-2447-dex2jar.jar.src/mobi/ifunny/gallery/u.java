package mobi.ifunny.gallery;

import android.graphics.Bitmap;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

public class u
        extends n<GalleryFragment, Bitmap> {
    private a a;

    public u(GalleryFragment paramGalleryFragment, a parama, String paramString) {
        super(paramGalleryFragment, paramString, f.b(parama));
        this.a = parama;
    }

    protected void a(GalleryFragment paramGalleryFragment, m<Bitmap> paramm) {
        super.onPostExecute(paramGalleryFragment, paramm);
        paramGalleryFragment.a((Bitmap) paramm.a, this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */