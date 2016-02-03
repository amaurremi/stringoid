package mobi.ifunny.studio;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;

public class c
        extends g {
    private Uri j;

    public static c a(Uri paramUri) {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.image.uri", paramUri);
        paramUri = new c();
        paramUri.setArguments(localBundle);
        return paramUri;
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(2131690039);
        String str1 = getResources().getString(2131690042);
        String str2 = getResources().getString(2131690044);
        String str3 = getResources().getString(2131690046);
        d locald = new d(this);
        paramBundle.setItems(new String[]{str1, str2, str3}, locald);
        return paramBundle.create();
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        super.onCancel(paramDialogInterface);
        getActivity().finish();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.j = ((Uri) getArguments().getParcelable("arg.image.uri"));
        if (this.j == null) {
            throw new IllegalArgumentException();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */