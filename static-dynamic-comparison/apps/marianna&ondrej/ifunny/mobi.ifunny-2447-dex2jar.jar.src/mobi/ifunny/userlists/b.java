package mobi.ifunny.userlists;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.a.a;
import android.view.View;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.SmilersFeed;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.r;

public class b
        extends g<SmilersFeed> {
    private IFunny b;

    private void d() {
        UserListAdapter localUserListAdapter;
        Resources localResources;
        if ((B() != null) && (!((SmilersFeed) B()).hasNext())) {
            localUserListAdapter = c();
            localResources = getResources();
            localUserListAdapter.a();
            if (this.b.num.unsmiles <= 0) {
                break label62;
            }
            localUserListAdapter.a(localResources.getString(2131690169));
        }
        for (; ; ) {
            D();
            return;
            label62:
            if (this.b.num.smiles > localUserListAdapter.getCount()) {
                localUserListAdapter.a(localResources.getString(2131690175));
            }
        }
    }

    protected void a(int paramInt) {
        String str = r.b(getResources(), 2131623946, 2131690174, paramInt);
        a().a(str);
        if (this.a == 0) {
        }
        for (paramInt = 2131690172; ; paramInt = 2131690173) {
            f(paramInt);
            return;
        }
    }

    protected void a(int paramInt, SmilersFeed paramSmilersFeed) {
        super.a(paramInt, paramSmilersFeed);
        if ((paramInt == 0) || (paramInt == 1)) {
            d();
        }
    }

    public void a(IFunny paramIFunny) {
        this.b = paramIFunny;
    }

    protected void a(SmilersFeed paramSmilersFeed) {
        super.a(paramSmilersFeed);
        d();
    }

    protected <K extends ContentAdapterFragment<User, SmilersFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<SmilersFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Content.getSmilers(this, paramString3, this.b.getOriginalCid(), o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle == null) {
            mobi.ifunny.b.g.a(getActivity(), "Smilers");
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
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.b = ((IFunny) paramBundle.getParcelable("SAVE_CONTENT"));
            d();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/userlists/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */