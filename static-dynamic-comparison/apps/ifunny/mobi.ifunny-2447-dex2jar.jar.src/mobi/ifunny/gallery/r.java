package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RepublishedCounter;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class r
        extends SimpleRestHttpHandler<RepublishedCounter, GalleryFragment> {
    private final IFunny a;

    private r(IFunny paramIFunny) {
        this.a = paramIFunny;
    }

    public void a(GalleryFragment paramGalleryFragment) {
        GalleryFragment.c(paramGalleryFragment, this.a);
    }

    public void a(GalleryFragment paramGalleryFragment, Throwable paramThrowable) {
        paramGalleryFragment.g(this.a);
    }

    public void a(GalleryFragment paramGalleryFragment, RepublishedCounter paramRepublishedCounter) {
        GalleryFragment.d(paramGalleryFragment, this.a);
    }

    public void a(GalleryFragment paramGalleryFragment, RestError paramRestError) {
        if (paramRestError.status == 403) {
            GalleryFragment.e(paramGalleryFragment, this.a);
            return;
        }
        super.onFailureCallback(paramGalleryFragment, paramRestError);
        paramGalleryFragment.g(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */