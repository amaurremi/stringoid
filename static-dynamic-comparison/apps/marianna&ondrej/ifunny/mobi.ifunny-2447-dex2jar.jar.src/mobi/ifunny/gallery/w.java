package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.SmilesCounter;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

class w
        extends SimpleRestHttpHandler<SmilesCounter, GalleryFragment> {
    private final int a;
    private final boolean b;
    private final boolean c;

    private w(IFunny paramIFunny, boolean paramBoolean1, boolean paramBoolean2) {
        this.a = paramIFunny.uniqueId;
        this.b = paramBoolean1;
        this.c = paramBoolean2;
    }

    public void a(GalleryFragment paramGalleryFragment) {
        super.onStartCallback(paramGalleryFragment);
        paramGalleryFragment.a(this.a, this.b, this.c);
    }

    public void a(GalleryFragment paramGalleryFragment, Throwable paramThrowable) {
    }

    public void a(GalleryFragment paramGalleryFragment, RestError paramRestError) {
    }

    public void a(GalleryFragment paramGalleryFragment, SmilesCounter paramSmilesCounter) {
        paramGalleryFragment.a(this.a, this.b, this.c, paramSmilesCounter);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */