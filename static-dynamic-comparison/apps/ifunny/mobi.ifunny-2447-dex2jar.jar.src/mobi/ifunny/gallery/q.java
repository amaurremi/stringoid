package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class q
        extends SimpleRestHttpHandler<Void, GalleryFragment> {
    private final IFunny a;

    private q(IFunny paramIFunny) {
        this.a = paramIFunny;
    }

    public void a(GalleryFragment paramGalleryFragment, Void paramVoid) {
        paramGalleryFragment.d(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */