package mobi.ifunny.search;

import android.os.Bundle;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.rest.content.SearchResponse;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Search;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class f
        extends GalleryFragment<SearchResponse> {
    private static final String b = f.class.getSimpleName();
    private String c;

    protected void a(String paramString1, String paramString2, RestHttpHandler<SearchResponse, GalleryFragment> paramRestHttpHandler) {
        IFunnyRestRequest.Search.searchContent(this, p(), this.c, 20, paramString1, paramString2, paramRestHttpHandler);
    }

    protected String b() {
        return this.c;
    }

    public String d() {
        return "SearchFeed";
    }

    public String e() {
        return "feed_search";
    }

    protected String f() {
        return "sear";
    }

    protected int h() {
        return 1;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.c = getArguments().getString("arg.query");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/search/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */