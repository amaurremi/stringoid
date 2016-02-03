package mobi.ifunny.comments;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.g;

public abstract class h
        extends g
        implements DialogInterface.OnClickListener {
    private Parcelable j;
    private String k;

    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setMessage(this.k);
        paramBundle.setCancelable(true);
        paramBundle.setNegativeButton(2131689676, this);
        paramBundle.setPositiveButton(2131689686, this);
        return paramBundle.create();
    }

    protected void a(Parcelable paramParcelable, String paramString) {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.data", paramParcelable);
        localBundle.putString("arg.message", paramString);
        setArguments(localBundle);
    }

    public Object d() {
        return this.j;
    }

    public abstract void e();

    public void f() {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        if (paramInt == -1) {
            e();
        }
        for (; ; ) {
            b();
            return;
            if (paramInt == -2) {
                f();
            }
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.j = paramBundle.getParcelable("arg.data");
        this.k = paramBundle.getString("arg.message");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */