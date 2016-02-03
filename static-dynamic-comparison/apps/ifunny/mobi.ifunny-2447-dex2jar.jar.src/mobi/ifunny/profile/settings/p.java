package mobi.ifunny.profile.settings;

import android.widget.Toast;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class p
        extends SimpleRestHttpHandler<Void, ProfileSettingsFragmentMain> {
    private String a;

    private p(String paramString) {
        this.a = paramString;
    }

    public void a(ProfileSettingsFragmentMain paramProfileSettingsFragmentMain, Void paramVoid) {
        ProfileSettingsFragmentMain.a(paramProfileSettingsFragmentMain, this.a);
    }

    public void a(ProfileSettingsFragmentMain paramProfileSettingsFragmentMain, RestError paramRestError) {
        if ((paramRestError != null) && (paramRestError.status == 403)) {
            Toast.makeText(paramProfileSettingsFragmentMain.getActivity(), 2131689866, 0).show();
            return;
        }
        super.onFailureCallback(paramProfileSettingsFragmentMain, paramRestError);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */