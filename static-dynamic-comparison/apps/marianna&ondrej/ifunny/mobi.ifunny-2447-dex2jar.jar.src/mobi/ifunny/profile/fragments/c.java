package mobi.ifunny.profile.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import mobi.ifunny.gallery.ContentAdapterFragment;
import mobi.ifunny.gallery.GalleryActivity;
import mobi.ifunny.gallery.h;
import mobi.ifunny.profile.k;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.content.IFunnyList;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Timelines;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;
import mobi.ifunny.view.DynamicStaggeredGridView;

public class c
        extends a<IFunny, IFunnyFeed> {
    private String a;
    private String b;

    protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
        paramAdapterView = d().c(paramInt);
        switch (paramAdapterView.b) {
            default:
                return;
        }
        paramView = (IFunny) paramAdapterView.a;
        paramAdapterView = new IFunnyList(((IFunnyFeed) B()).getContent());
        paramInt = paramAdapterView.items.indexOf(paramView);
        paramView = new IFunnyCache.ListEntry();
        paramView.a(paramAdapterView);
        paramView.a = paramInt;
        paramAdapterView = new Intent(getActivity(), GalleryActivity.class);
        paramAdapterView.putExtra("intent.gallery.type", 20);
        paramAdapterView.putExtra("arg.uid", this.a);
        paramAdapterView.putExtra("arg.nick", this.b);
        GalleryActivity.a(paramView);
        startActivity(paramAdapterView);
    }

    public void a(User paramUser) {
        this.a = paramUser.id;
        this.b = paramUser.nick;
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
        if (TextUtils.isEmpty(this.a)) {
            return false;
        }
        IFunnyRestRequest.Timelines.getUser(this, paramString3, this.a, o(), paramString1, paramString2, paramRestHttpHandler);
        return true;
    }

    protected k c() {
        return new k(b());
    }

    protected k d() {
        return (k) super.i();
    }

    public void onViewCreated(View paramView, Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        f(2131689845);
        b().setColumnCount(getResources().getInteger(2131558410));
    }

    protected String p() {
        return "TASK_PROFILE_WORKS";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/fragments/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */