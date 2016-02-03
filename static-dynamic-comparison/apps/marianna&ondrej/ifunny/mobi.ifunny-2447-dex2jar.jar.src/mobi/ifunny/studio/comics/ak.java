package mobi.ifunny.studio.comics;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;

public class ak
        extends g {
    private DialogInterface.OnClickListener j = new al(this);

    public Dialog a(Bundle paramBundle) {
        paramBundle = getResources().getString(2131690002);
        String str = getResources().getString(2131690000);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity()).setTitle(2131690001);
        DialogInterface.OnClickListener localOnClickListener = this.j;
        return localBuilder.setItems(new String[]{paramBundle, str}, localOnClickListener).create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */