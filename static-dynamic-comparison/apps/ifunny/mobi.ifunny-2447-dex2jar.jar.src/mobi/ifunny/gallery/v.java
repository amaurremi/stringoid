package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RepublishedCounter;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class v
        extends SimpleRestHttpHandler<RepublishedCounter, GalleryFragment> {
    private final IFunny a;

    private v(IFunny paramIFunny) {
        this.a = paramIFunny;
    }

    public void a(GalleryFragment paramGalleryFragment) {
        GalleryFragment.a(paramGalleryFragment, this.a);
    }

    public void a(GalleryFragment paramGalleryFragment, Throwable paramThrowable) {
        paramGalleryFragment.f(this.a);
    }

    public void a(GalleryFragment paramGalleryFragment, RepublishedCounter paramRepublishedCounter) {
        GalleryFragment.a(paramGalleryFragment, this.a, paramRepublishedCounter);
    }

    public void a(GalleryFragment paramGalleryFragment, RestError paramRestError) {
        if (paramRestError.status == 403) {
            GalleryFragment.b(paramGalleryFragment, this.a);
            return;
        }
        super.onFailureCallback(paramGalleryFragment, paramRestError);
        paramGalleryFragment.f(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */