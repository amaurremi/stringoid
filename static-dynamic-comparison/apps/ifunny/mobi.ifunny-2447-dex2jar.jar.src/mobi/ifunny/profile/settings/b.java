package mobi.ifunny.profile.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import android.widget.EditText;

class b
        implements DialogInterface.OnClickListener {
    b(a parama, EditText paramEditText) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        Fragment localFragment = this.b.getTargetFragment();
        if ((localFragment instanceof d)) {
            ((d) localFragment).a(this.a.getText().toString());
        }
        paramDialogInterface.dismiss();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */