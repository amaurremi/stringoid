package mobi.ifunny.studio.source;

import android.os.Bundle;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.rest.content.WebImageFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Studio;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.view.drawable.f;

public class l
        extends d<f> {
    public static d a(String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putString("arg.query", paramString);
        paramString = new l();
        paramString.setArguments(localBundle);
        return paramString;
    }

    protected <K extends ContentAdapterFragment<WebImage, WebImageFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<WebImageFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Studio.searchWebImages(this, paramString3, this.a, paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected c c() {
        return new c(b());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */