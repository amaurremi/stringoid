package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class ai
        extends GalleryFragment<IFunnyFeed> {
    private static final String b = ai.class.getSimpleName();

    protected void a(String paramString1, String paramString2, RestHttpHandler<IFunnyFeed, GalleryFragment> paramRestHttpHandler) {
    }

    public String d() {
        return "MonoFeed";
    }

    public String e() {
        return "feed_mono";
    }

    protected int h() {
        return 1;
    }

    protected boolean l() {
        return false;
    }

    protected boolean m() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */