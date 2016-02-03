package mobi.ifunny.profile.editor;

import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.UploadedPhoto;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class k
        extends SimpleRestHttpHandler<UploadedPhoto, b> {
    public void a(b paramb, RestError paramRestError) {
        super.onFailureCallback(paramb, paramRestError);
        b.k(paramb);
        paramb.d();
    }

    public void a(b paramb, UploadedPhoto paramUploadedPhoto) {
        paramb.a(paramUploadedPhoto);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */