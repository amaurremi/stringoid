package mobi.ifunny.profile.settings;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.g;

public class s
        extends g {
    private DialogInterface.OnClickListener j = new t(this);

    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(2131689861);
        paramBundle.setMessage(2131689860);
        paramBundle.setPositiveButton(2131689859, this.j);
        paramBundle.setNegativeButton(2131689669, this.j);
        return paramBundle.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */