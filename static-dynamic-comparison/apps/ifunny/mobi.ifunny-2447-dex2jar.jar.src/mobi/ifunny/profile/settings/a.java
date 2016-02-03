package mobi.ifunny.profile.settings;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.g;
import android.text.InputFilter;
import android.view.Window;
import android.widget.EditText;
import mobi.ifunny.util.ak;

public class a
        extends g {
    public Dialog a(Bundle paramBundle) {
        boolean bool = getArguments().getBoolean("isChangingEmail");
        paramBundle = new AlertDialog.Builder(getActivity());
        if (Boolean.valueOf(bool).booleanValue()) {
        }
        for (int i = 2131689853; ; i = 2131689865) {
            paramBundle.setTitle(i);
            EditText localEditText = new EditText(getActivity());
            localEditText.setInputType(33);
            localEditText.setFilters(new InputFilter[]{new ak()});
            paramBundle.setView(localEditText);
            paramBundle.setPositiveButton(2131689800, new b(this, localEditText));
            paramBundle.setNegativeButton(2131689669, new c(this));
            paramBundle = paramBundle.create();
            paramBundle.getWindow().setSoftInputMode(5);
            return paramBundle;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */