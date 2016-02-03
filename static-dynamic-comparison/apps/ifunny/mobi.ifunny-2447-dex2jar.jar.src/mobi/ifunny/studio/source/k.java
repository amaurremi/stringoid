package mobi.ifunny.studio.source;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.rest.content.WebImage;
import mobi.ifunny.rest.content.WebImageFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Studio;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class k
        extends d<mobi.ifunny.view.drawable.f> {
    public static d a(String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putString("arg.query", paramString);
        paramString = new k();
        paramString.setArguments(localBundle);
        return paramString;
    }

    protected <K extends ContentAdapterFragment<WebImage, WebImageFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<WebImageFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Studio.searchWebGifs(this, paramString3, this.a, paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected f c() {
        return new f(b());
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(2130903184, paramViewGroup, false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/source/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */