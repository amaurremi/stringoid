package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class i
        extends SimpleRestHttpHandler<IFunny, GalleryActivity> {
    public void a(GalleryActivity paramGalleryActivity) {
        GalleryActivity.a(paramGalleryActivity);
    }

    public void a(GalleryActivity paramGalleryActivity, Throwable paramThrowable) {
        super.onExceptionCallback(paramGalleryActivity, paramThrowable);
        paramGalleryActivity.finish();
    }

    public void a(GalleryActivity paramGalleryActivity, IFunny paramIFunny) {
        GalleryActivity.a(paramGalleryActivity, paramIFunny);
    }

    public void a(GalleryActivity paramGalleryActivity, RestError paramRestError) {
        super.onFailureCallback(paramGalleryActivity, paramRestError);
        paramGalleryActivity.finish();
    }

    public void b(GalleryActivity paramGalleryActivity) {
        GalleryActivity.b(paramGalleryActivity);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */