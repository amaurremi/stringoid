package mobi.ifunny.gallery;

import android.os.Bundle;
import android.text.TextUtils;

import java.util.EnumSet;

import mobi.ifunny.profile.u;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Timelines;
import mobi.ifunny.rest.retrofit.RestHttpHandler;

public class an
        extends GalleryFragment<IFunnyFeed> {
    private static final String b = an.class.getSimpleName();
    private String c;
    private String d;

    protected void a(String paramString1, String paramString2, RestHttpHandler<IFunnyFeed, GalleryFragment> paramRestHttpHandler) {
        IFunnyRestRequest.Timelines.getUser(this, p(), this.c, 20, paramString1, paramString2, paramRestHttpHandler);
    }

    protected String b() {
        return this.d;
    }

    public String d() {
        if (TextUtils.equals(this.c, mobi.ifunny.social.auth.l.a().d())) {
            return "MyProfileFeed";
        }
        return "ProfileFeed";
    }

    public void d(IFunny paramIFunny) {
        super.d(paramIFunny);
        mobi.ifunny.profile.l.h.add(u.a);
    }

    public String e() {
        return "feed_profile";
    }

    protected String f() {
        return "prof";
    }

    protected int h() {
        if (TextUtils.equals(this.c, mobi.ifunny.social.auth.l.a().d())) {
            return 2;
        }
        return 1;
    }

    protected void h(IFunny paramIFunny) {
        super.h(paramIFunny);
        mobi.ifunny.profile.l.h.add(u.a);
    }

    protected boolean m() {
        return true;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.c = paramBundle.getString("arg.uid");
        this.d = paramBundle.getString("arg.nick");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */