package mobi.ifunny.studio.gif;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;

public class l
        extends g {
    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(2131690126);
        m localm = new m(this);
        paramBundle.setItems(new String[]{getResources().getString(2131690125), getResources().getString(2131690127)}, localm);
        return paramBundle.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */