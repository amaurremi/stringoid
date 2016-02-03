package mobi.ifunny.gallery;

import android.text.TextUtils;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class p
        extends SimpleRestHttpHandler<Void, GalleryFragment> {
    private final IFunny a;

    private p(IFunny paramIFunny) {
        this.a = paramIFunny;
    }

    public void a(GalleryFragment paramGalleryFragment, Void paramVoid) {
        paramGalleryFragment.b(this.a);
    }

    public void a(GalleryFragment paramGalleryFragment, RestError paramRestError) {
        if ((paramRestError.status == 403) && (TextUtils.equals(paramRestError.error, "entity_abused"))) {
            paramGalleryFragment.a(paramRestError);
            return;
        }
        super.onFailureCallback(paramGalleryFragment, paramRestError);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */