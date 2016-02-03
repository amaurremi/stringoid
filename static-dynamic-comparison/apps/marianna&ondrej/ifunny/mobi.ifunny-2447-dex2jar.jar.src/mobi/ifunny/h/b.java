package mobi.ifunny.h;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import mobi.ifunny.b.g;
import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.GalleryActivity;
import mobi.ifunny.gallery.h;
import mobi.ifunny.profile.i;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;
import mobi.ifunny.view.DynamicStaggeredGridView;

public class b
        extends mobi.ifunny.profile.fragments.a<IFunny, IFunnyFeed>
        implements i {
    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
        paramView = (IFunny) d().c(paramInt).a;
        paramAdapterView = new IFunnyList(((IFunnyFeed) B()).getContent());
        paramInt = paramAdapterView.items.indexOf(paramView);
        paramView = new IFunnyCache.ListEntry();
        paramView.a(paramAdapterView);
        paramView.a = paramInt;
        paramAdapterView = new Intent(getActivity(), GalleryActivity.class);
        paramAdapterView.putExtra("intent.gallery.type", 30);
        GalleryActivity.a(paramView);
        startActivity(paramAdapterView);
    }

    public void a(User paramUser) {
    }

    public void a(User paramUser, boolean paramBoolean) {
        if (paramBoolean) {
            e();
        }
        if (B() == null) {
            g(0);
        }
        D();
    }

    protected <K extends ContentAdapterFragment<IFunny, IFunnyFeed>> boolean a(String paramString1, String paramString2, String paramString3, RestHttpHandler<IFunnyFeed, K> paramRestHttpHandler) {
        IFunnyRestRequest.Users.getMySmiles(this, paramString3, o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected a c() {
        return new a(b());
    }

    protected a d() {
        return (a) super.i();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle == null) {
            g.a(getActivity(), "MySmiles");
        }
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        f(2131689742);
        b().setVerticalScrollBarEnabled(false);
    }

    protected String p() {
        return "users.get.myliked";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */