package mobi.ifunny.social.auth;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class RegisterActivityMain$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, RegisterActivityMain paramRegisterActivityMain, Object paramObject) {
        paramRegisterActivityMain.nickEdit = ((EditText) paramFinder.findRequiredView(paramObject, 2131493283, "field 'nickEdit'"));
        paramRegisterActivityMain.nickChecked = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493284, "field 'nickChecked'"));
        paramRegisterActivityMain.emailEdit = ((EditText) paramFinder.findRequiredView(paramObject, 2131493029, "field 'emailEdit'"));
        paramRegisterActivityMain.passEdit = ((EditText) paramFinder.findRequiredView(paramObject, 2131493162, "field 'passEdit'"));
        paramRegisterActivityMain.passLayout = paramFinder.findRequiredView(paramObject, 2131493160, "field 'passLayout'");
        paramRegisterActivityMain.nickBottomLine = paramFinder.findRequiredView(paramObject, 2131493285, "field 'nickBottomLine'");
        paramRegisterActivityMain.emailBottomLine = paramFinder.findRequiredView(paramObject, 2131493159, "field 'emailBottomLine'");
        paramRegisterActivityMain.passwordBottomLine = paramFinder.findRequiredView(paramObject, 2131493163, "field 'passwordBottomLine'");
        paramRegisterActivityMain.cancel = paramFinder.findRequiredView(paramObject, 2131493084, "field 'cancel'");
        paramRegisterActivityMain.done = paramFinder.findRequiredView(paramObject, 2131493085, "field 'done'");
        paramRegisterActivityMain.doneText = ((TextView) paramFinder.findRequiredView(paramObject, 2131493086, "field 'doneText'"));
        paramFinder.findRequiredView(paramObject, 2131493288, "method 'onTermsOfServiceClick'").setOnClickListener(new ad(paramRegisterActivityMain));
    }

    public static void reset(RegisterActivityMain paramRegisterActivityMain) {
        paramRegisterActivityMain.nickEdit = null;
        paramRegisterActivityMain.nickChecked = null;
        paramRegisterActivityMain.emailEdit = null;
        paramRegisterActivityMain.passEdit = null;
        paramRegisterActivityMain.passLayout = null;
        paramRegisterActivityMain.nickBottomLine = null;
        paramRegisterActivityMain.emailBottomLine = null;
        paramRegisterActivityMain.passwordBottomLine = null;
        paramRegisterActivityMain.cancel = null;
        paramRegisterActivityMain.done = null;
        paramRegisterActivityMain.doneText = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/RegisterActivityMain$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */