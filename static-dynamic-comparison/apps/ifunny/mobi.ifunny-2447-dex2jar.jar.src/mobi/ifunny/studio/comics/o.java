package mobi.ifunny.studio.comics;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;

public class o
        extends g {
    public Dialog a(Bundle paramBundle) {
        paramBundle = getResources().getString(2131690004);
        String str = getResources().getString(2131690006);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
        p localp = new p(this);
        localBuilder.setItems(new String[]{paramBundle, str}, localp);
        return localBuilder.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */