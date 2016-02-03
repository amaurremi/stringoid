package mobi.ifunny.preferences;

import android.view.View;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.SettingsItemLayout;

public class PreferencesFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, PreferencesFragment paramPreferencesFragment, Object paramObject) {
        paramFinder = paramFinder.findRequiredView(paramObject, 2131493197, "field 'notificationsView' and method 'onNotificationsClick'");
        paramPreferencesFragment.notificationsView = ((SettingsItemLayout) paramFinder);
        paramFinder.setOnClickListener(new a(paramPreferencesFragment));
    }

    public static void reset(PreferencesFragment paramPreferencesFragment) {
        paramPreferencesFragment.notificationsView = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/preferences/PreferencesFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */