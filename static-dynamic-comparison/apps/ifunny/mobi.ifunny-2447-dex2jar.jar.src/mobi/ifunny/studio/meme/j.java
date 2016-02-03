package mobi.ifunny.studio.meme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.a.a;
import mobi.ifunny.gallery.h;
import mobi.ifunny.rest.content.MemeSource;
import mobi.ifunny.rest.content.MemeSourcesFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Studio;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class j
        extends a<MemeSource, MemeSourcesFeed> {
    private k a;
    private String b;

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
        if (this.a != null) {
            paramAdapterView = (MemeSource) d().c(paramInt).a;
            this.a.a(paramAdapterView);
        }
    }

    protected <K extends ContentAdapterFragment<MemeSource, MemeSourcesFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<MemeSourcesFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Studio.getMemeSources(this, paramString3, this.b, o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected i c() {
        return new i(b());
    }

    protected i d() {
        return (i) super.i();
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        try {
            this.a = ((k) paramActivity);
            return;
        } catch (ClassCastException paramActivity) {
            throw new IllegalStateException(paramActivity);
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.b = getArguments().getString("arg.category");
    }

    public void onDetach() {
        super.onDetach();
        this.a = null;
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        f(2131690071);
    }

    protected String p() {
        return "source.meme";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */