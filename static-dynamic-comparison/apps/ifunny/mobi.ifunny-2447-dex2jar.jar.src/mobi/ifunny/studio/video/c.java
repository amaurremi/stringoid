package mobi.ifunny.studio.video;

import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class c
        extends SimpleRestHttpHandler<String, UploadVideoSearchActivity> {
    public void a(UploadVideoSearchActivity paramUploadVideoSearchActivity) {
        super.onFinishCallback(paramUploadVideoSearchActivity);
        paramUploadVideoSearchActivity.n();
    }

    public void a(UploadVideoSearchActivity paramUploadVideoSearchActivity, String paramString) {
        paramUploadVideoSearchActivity.b(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/video/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */