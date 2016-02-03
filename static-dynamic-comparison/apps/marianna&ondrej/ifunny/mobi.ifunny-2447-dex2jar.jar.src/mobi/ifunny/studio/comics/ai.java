package mobi.ifunny.studio.comics;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.g;

public class ai
        extends g {
    private DialogInterface.OnClickListener j = new aj(this);

    public Dialog a(Bundle paramBundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(2131689994).setPositiveButton(2131690013, this.j).setNegativeButton(2131690012, this.j).create();
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        super.onCancel(paramDialogInterface);
        RageEditorActivity.a((RageEditorActivity) getActivity());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */