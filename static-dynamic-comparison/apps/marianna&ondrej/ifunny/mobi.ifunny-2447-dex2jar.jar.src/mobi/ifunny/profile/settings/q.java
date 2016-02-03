package mobi.ifunny.profile.settings;

import android.text.TextUtils;
import android.widget.Toast;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class q
        extends SimpleRestHttpHandler<Void, ProfileSettingsFragmentMain> {
    private String a;
    private String b;

    private q(String paramString1, String paramString2) {
        this.a = paramString1;
        this.b = paramString2;
    }

    public void a(ProfileSettingsFragmentMain paramProfileSettingsFragmentMain) {
        paramProfileSettingsFragmentMain.l();
        super.onFinishCallback(paramProfileSettingsFragmentMain);
    }

    public void a(ProfileSettingsFragmentMain paramProfileSettingsFragmentMain, Void paramVoid) {
        ProfileSettingsFragmentMain.a(paramProfileSettingsFragmentMain, true, this.a, this.b);
    }

    public void a(ProfileSettingsFragmentMain paramProfileSettingsFragmentMain, RestError paramRestError) {
        if (TextUtils.equals(paramRestError.error, "social_register_duplicate")) {
            Toast.makeText(paramProfileSettingsFragmentMain.getActivity(), 2131689922, 1).show();
            return;
        }
        super.onFailureCallback(paramProfileSettingsFragmentMain, paramRestError);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */