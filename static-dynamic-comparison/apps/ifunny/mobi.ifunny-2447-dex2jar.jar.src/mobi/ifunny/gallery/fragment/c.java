package mobi.ifunny.gallery.fragment;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.g;
import mobi.ifunny.rest.content.IFunny;

public class c
        extends g {
    private IFunny j;
    private String k;
    private DialogInterface.OnClickListener l = new d(this);

    public static c a(IFunny paramIFunny, String paramString) {
        c localc = new c();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.content", paramIFunny);
        localBundle.putString("arg.tag", paramString);
        localc.setArguments(localBundle);
        return localc;
    }

    public Dialog a(Bundle paramBundle) {
        return new AlertDialog.Builder(getActivity()).setMessage(2131689625).setPositiveButton(2131689686, this.l).setNegativeButton(2131689676, this.l).create();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.j = ((IFunny) getArguments().getParcelable("arg.content"));
        this.k = getArguments().getString("arg.tag");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */