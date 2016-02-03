package mobi.ifunny.social.auth;

import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, LoginActivity paramLoginActivity, Object paramObject) {
        paramLoginActivity.emailEdit = ((EditText) paramFinder.findRequiredView(paramObject, 2131493029, "field 'emailEdit'"));
        paramLoginActivity.passEdit = ((EditText) paramFinder.findRequiredView(paramObject, 2131493162, "field 'passEdit'"));
        paramLoginActivity.emailBottomLine = paramFinder.findRequiredView(paramObject, 2131493159, "field 'emailBottomLine'");
        paramLoginActivity.passwordBottomLine = paramFinder.findRequiredView(paramObject, 2131493163, "field 'passwordBottomLine'");
        paramLoginActivity.cancel = paramFinder.findRequiredView(paramObject, 2131493084, "field 'cancel'");
        paramLoginActivity.done = paramFinder.findRequiredView(paramObject, 2131493085, "field 'done'");
        paramLoginActivity.doneText = ((TextView) paramFinder.findRequiredView(paramObject, 2131493086, "field 'doneText'"));
        paramLoginActivity.resetPassword = paramFinder.findRequiredView(paramObject, 2131493165, "field 'resetPassword'");
    }

    public static void reset(LoginActivity paramLoginActivity) {
        paramLoginActivity.emailEdit = null;
        paramLoginActivity.passEdit = null;
        paramLoginActivity.emailBottomLine = null;
        paramLoginActivity.passwordBottomLine = null;
        paramLoginActivity.cancel = null;
        paramLoginActivity.done = null;
        paramLoginActivity.doneText = null;
        paramLoginActivity.resetPassword = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/LoginActivity$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */