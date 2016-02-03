package mobi.ifunny.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.k;
import mobi.ifunny.view.b.a;

public class h
        extends android.support.v4.app.g {
    private String[] j;
    private boolean k;

    public static h a(mobi.ifunny.l.h paramh, boolean paramBoolean, String... paramVarArgs) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramVarArgs != null) {
            localObject1 = localObject2;
            if (paramVarArgs.length > 0) {
                localObject1 = new String[paramVarArgs.length];
                int i = 0;
                while (i < paramVarArgs.length) {
                    localObject1[i] = mobi.ifunny.l.g.a(paramh, paramVarArgs[i]);
                    i += 1;
                }
            }
        }
        paramh = new h();
        paramVarArgs = new Bundle();
        paramVarArgs.putStringArray("arg.tasks", (String[]) localObject1);
        paramVarArgs.putBoolean("arg.back", paramBoolean);
        paramh.setArguments(paramVarArgs);
        return paramh;
    }

    public static h a(mobi.ifunny.l.h paramh, String... paramVarArgs) {
        return a(paramh, false, paramVarArgs);
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new a(getActivity(), 2131755184);
        paramBundle.a(true);
        paramBundle.setMessage(getString(2131689682));
        paramBundle.setCanceledOnTouchOutside(false);
        return paramBundle;
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        super.onCancel(paramDialogInterface);
        paramDialogInterface = getActivity();
        if (paramDialogInterface != null) {
            mobi.ifunny.l.g.a(this.j);
            if (this.k) {
                paramDialogInterface.onBackPressed();
            }
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        if (paramBundle != null) {
            this.j = paramBundle.getStringArray("arg.tasks");
            this.k = paramBundle.getBoolean("arg.back", false);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */