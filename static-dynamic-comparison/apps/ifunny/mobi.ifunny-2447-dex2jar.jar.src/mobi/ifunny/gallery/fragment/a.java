package mobi.ifunny.gallery.fragment;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.g;
import mobi.ifunny.rest.content.IFunny;

public class a
        extends g {
    private IFunny j;
    private String k;
    private DialogInterface.OnClickListener l = new b(this);

    public static a a(IFunny paramIFunny, String paramString) {
        a locala = new a();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.content", paramIFunny);
        localBundle.putString("arg.tag", paramString);
        locala.setArguments(localBundle);
        return locala;
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setMessage(2131689616);
        paramBundle.setPositiveButton(2131689686, this.l);
        paramBundle.setNegativeButton(2131689676, this.l);
        return paramBundle.create();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.j = ((IFunny) paramBundle.getParcelable("arg.content"));
        this.k = paramBundle.getString("arg.tag");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */