package mobi.ifunny.profile;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.g;

public class e
        extends g {
    private static final String j = e.class.getSimpleName();
    private DialogInterface.OnClickListener k = new f(this);

    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setMessage(2131689792);
        paramBundle.setPositiveButton(2131689686, this.k);
        paramBundle.setNegativeButton(2131689676, this.k);
        return paramBundle.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */