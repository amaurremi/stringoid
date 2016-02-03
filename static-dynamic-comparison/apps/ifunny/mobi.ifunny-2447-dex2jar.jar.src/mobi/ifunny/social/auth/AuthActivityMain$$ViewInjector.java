package mobi.ifunny.social.auth;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AuthActivityMain$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, AuthActivityMain paramAuthActivityMain, Object paramObject) {
        paramAuthActivityMain.rootView = paramFinder.findRequiredView(paramObject, 2131493008, "field 'rootView'");
        paramFinder.findRequiredView(paramObject, 2131493023, "method 'onFacebookClick'").setOnClickListener(new a(paramAuthActivityMain));
        paramFinder.findRequiredView(paramObject, 2131493024, "method 'onTwitterClick'").setOnClickListener(new b(paramAuthActivityMain));
        paramFinder.findRequiredView(paramObject, 2131493027, "method 'onSignUpClick'").setOnClickListener(new c(paramAuthActivityMain));
        paramFinder.findRequiredView(paramObject, 2131493029, "method 'onLoginClick'").setOnClickListener(new d(paramAuthActivityMain));
    }

    public static void reset(AuthActivityMain paramAuthActivityMain) {
        paramAuthActivityMain.rootView = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/AuthActivityMain$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */