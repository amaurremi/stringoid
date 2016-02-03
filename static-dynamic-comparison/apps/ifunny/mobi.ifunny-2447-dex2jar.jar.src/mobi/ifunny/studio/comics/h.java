package mobi.ifunny.studio.comics;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.g;

public class h
        extends g {
    public Dialog a(Bundle paramBundle) {
        paramBundle = new i(this);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
        localBuilder.setPositiveButton(2131689686, paramBundle);
        localBuilder.setNegativeButton(2131689676, paramBundle);
        localBuilder.setMessage(2131689980);
        localBuilder.setTitle(2131689981);
        localBuilder.setCancelable(true);
        return localBuilder.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */