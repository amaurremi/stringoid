package mobi.ifunny.profile.settings;

import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.SettingsItemLayout;

public class ProfileSettingsFragmentMain$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, ProfileSettingsFragmentMain paramProfileSettingsFragmentMain, Object paramObject) {
        paramProfileSettingsFragmentMain.facebookView = ((SettingsItemLayout) paramFinder.findRequiredView(paramObject, 2131493231, "field 'facebookView'"));
        paramProfileSettingsFragmentMain.twitterView = ((SettingsItemLayout) paramFinder.findRequiredView(paramObject, 2131493232, "field 'twitterView'"));
        paramProfileSettingsFragmentMain.gplusView = ((SettingsItemLayout) paramFinder.findRequiredView(paramObject, 2131493233, "field 'gplusView'"));
        paramProfileSettingsFragmentMain.emailView = ((SettingsItemLayout) paramFinder.findRequiredView(paramObject, 2131493235, "field 'emailView'"));
        paramProfileSettingsFragmentMain.resetPasswordView = ((SettingsItemLayout) paramFinder.findRequiredView(paramObject, 2131493165, "field 'resetPasswordView'"));
        paramProfileSettingsFragmentMain.notificationsView = ((SettingsItemLayout) paramFinder.findRequiredView(paramObject, 2131493197, "field 'notificationsView'"));
    }

    public static void reset(ProfileSettingsFragmentMain paramProfileSettingsFragmentMain) {
        paramProfileSettingsFragmentMain.facebookView = null;
        paramProfileSettingsFragmentMain.twitterView = null;
        paramProfileSettingsFragmentMain.gplusView = null;
        paramProfileSettingsFragmentMain.emailView = null;
        paramProfileSettingsFragmentMain.resetPasswordView = null;
        paramProfileSettingsFragmentMain.notificationsView = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/ProfileSettingsFragmentMain$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */