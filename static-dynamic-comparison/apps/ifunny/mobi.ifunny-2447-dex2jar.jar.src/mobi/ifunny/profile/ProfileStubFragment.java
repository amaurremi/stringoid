package mobi.ifunny.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.a.a;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mobi.ifunny.main.a.b;
import mobi.ifunny.main.i;
import mobi.ifunny.preferences.PreferencesActivity;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.support.SupportActivity;

public class ProfileStubFragment
        extends i {
    protected boolean a;
    @InjectView(2131493250)
    protected View mainPart;

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        a().a(getString(2131689844));
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
                return;
        }
        this.a = false;
        if (paramInt2 == -1) {
            a(b.f);
            return;
        }
        this.mainPart.setVisibility(0);
    }

    @OnClick({2131493251})
    protected void onAuthClick() {
        this.mainPart.setVisibility(8);
        this.a = true;
        startActivityForResult(new Intent(getActivity(), AuthActivity.class), 0);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131820563, paramMenu);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903146, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        return paramLayoutInflater;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 2131493402:
                startActivity(new Intent(getActivity(), PreferencesActivity.class));
                return true;
        }
        startActivity(new Intent(getActivity(), SupportActivity.class));
        return true;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putBoolean("IS_AUTH_DIALOG_ACTIVE", this.a);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        if (paramBundle != null) {
            this.a = paramBundle.getBoolean("IS_AUTH_DIALOG_ACTIVE", false);
            if (this.a) {
                this.mainPart.setVisibility(8);
            }
        }
        super.onViewStateRestored(paramBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/ProfileStubFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */