package mobi.ifunny.userlists;

import android.os.Bundle;
import android.view.View;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.RepublishersFeed;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.r;

public class a
        extends g<RepublishersFeed> {
    private IFunny b;

    protected void a(int paramInt) {
        String str = r.b(getResources(), 2131623945, 2131690171, paramInt);
        a().a(str);
    }

    public void a(IFunny paramIFunny) {
        this.b = paramIFunny;
    }

    protected <K extends ContentAdapterFragment<User, RepublishersFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<RepublishersFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Content.getRepublishers(this, paramString3, this.b.getOriginalCid(), o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle == null) {
            mobi.ifunny.b.g.a(getActivity(), "Republishers");
            return;
        }
        this.b = ((IFunny) paramBundle.getParcelable("SAVE_CONTENT"));
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("SAVE_CONTENT", this.b);
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        f(2131690170);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */