package mobi.ifunny.preferences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mobi.ifunny.h;
import mobi.ifunny.main.i;
import mobi.ifunny.view.SettingsItemLayout;

public class PreferencesFragment
        extends i {
    @InjectView(2131493197)
    protected SettingsItemLayout notificationsView;

    public boolean i() {
        return false;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903139, paramViewGroup, false);
        boolean bool = h.a().a("pref.push.notifications", true);
        ButterKnife.inject(this, paramLayoutInflater);
        this.notificationsView.setSwitcherState(bool);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({2131493197})
    public void onNotificationsClick(View paramView) {
        boolean bool = true;
        paramView = h.a();
        if (!paramView.a("pref.push.notifications", true)) {
        }
        for (; ; ) {
            this.notificationsView.setSwitcherState(bool);
            paramView.b("pref.push.notifications", bool);
            return;
            bool = false;
        }
    }

    public boolean y() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/preferences/PreferencesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */