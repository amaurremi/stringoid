package mobi.ifunny.userlists;

import android.os.Bundle;
import android.support.v7.a.a;
import android.view.View;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.rest.content.SubscriptionsUserFeed;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Subscriptions;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.r;

public class c
        extends g<SubscriptionsUserFeed> {
    private String b;

    protected void a(int paramInt) {
        String str = r.b(getResources(), 2131623947, 2131690177, paramInt);
        a().a(str);
    }

    public void a(String paramString) {
        this.b = paramString;
    }

    protected <K extends ContentAdapterFragment<User, SubscriptionsUserFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<SubscriptionsUserFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Subscriptions.getSubscribers(this, paramString3, this.b, o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle == null) {
            mobi.ifunny.b.g.a(getActivity(), "Subscribers");
            return;
        }
        this.b = paramBundle.getString("SAVE_UID");
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putString("SAVE_UID", this.b);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        f(2131690176);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */