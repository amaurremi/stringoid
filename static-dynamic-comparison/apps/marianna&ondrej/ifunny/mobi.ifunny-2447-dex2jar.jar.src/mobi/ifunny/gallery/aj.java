package mobi.ifunny.gallery;

import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class aj
        extends GalleryFragment<IFunnyFeed> {
    protected void a(String paramString1, String paramString2, RestHttpHandler<IFunnyFeed, GalleryFragment> paramRestHttpHandler) {
        IFunnyRestRequest.Users.getMySmiles(this, p(), 20, paramString1, paramString2, paramRestHttpHandler);
    }

    protected String b() {
        return getString(2131689656);
    }

    public String d() {
        return "MySmilesFeed";
    }

    public String e() {
        return "feed_my_smiles";
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */