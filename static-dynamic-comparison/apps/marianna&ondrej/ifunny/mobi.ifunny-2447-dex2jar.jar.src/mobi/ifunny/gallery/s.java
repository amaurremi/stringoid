package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class s<T extends IFunnyFeed>
        extends SimpleRestHttpHandler<T, GalleryFragment> {
    private final int a;

    private s(int paramInt) {
        this.a = paramInt;
    }

    public void a(GalleryFragment paramGalleryFragment, Throwable paramThrowable) {
        super.onExceptionCallback(paramGalleryFragment, paramThrowable);
        paramGalleryFragment.c(this.a);
    }

    public void a(GalleryFragment paramGalleryFragment, T paramT) {
        paramGalleryFragment.a(this.a, paramT);
    }

    public void a(GalleryFragment paramGalleryFragment, RestError paramRestError) {
        super.onFailureCallback(paramGalleryFragment, paramRestError);
        paramGalleryFragment.c(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */