package mobi.ifunny.profile.editor;

import java.io.File;

import mobi.ifunny.d;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.UploadedCover;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class r
        extends SimpleRestHttpHandler<UploadedCover, b> {
    private final File a;

    private r(File paramFile) {
        this.a = paramFile;
    }

    private void a() {
        if (!this.a.delete()) {
            d.e(b.i(), "Cannot delete " + this.a);
        }
    }

    public void a(b paramb, RestError paramRestError) {
        super.onFailureCallback(paramb, paramRestError);
        a();
        b.k(paramb);
        paramb.d();
    }

    public void a(b paramb, UploadedCover paramUploadedCover) {
        a();
        paramb.a(paramUploadedCover);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */