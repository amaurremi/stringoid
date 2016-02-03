package mobi.ifunny.fragment;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.text.TextUtils;

public abstract class a
        extends g {
    public static String j = "ARG_TITLE";
    public static String k = "ARG_MESSAGE";
    public static String l = "ARG_POSITIVE";
    public static String m = "ARG_NEGATIVE";
    private String n;
    private String o;
    private String p;
    private String q;

    public Dialog a(Bundle paramBundle) {
        paramBundle = new b(this);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity()).setTitle(this.n).setMessage(this.o).setCancelable(true);
        if (!TextUtils.isEmpty(this.q)) {
            localBuilder.setNegativeButton(this.q, paramBundle);
        }
        if (!TextUtils.isEmpty(this.p)) {
            localBuilder.setPositiveButton(this.p, paramBundle);
        }
        return localBuilder.create();
    }

    public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        String str3 = null;
        Resources localResources = paramContext.getResources();
        String str1;
        label22:
        String str2;
        if (paramInt1 == 0) {
            paramContext = null;
            if (paramInt2 != 0) {
                break label57;
            }
            str1 = null;
            if (paramInt3 != 0) {
                break label68;
            }
            str2 = null;
            label30:
            if (paramInt4 != 0) {
                break label80;
            }
        }
        for (; ; ) {
            a(paramContext, str1, str2, str3);
            return;
            paramContext = localResources.getString(paramInt1);
            break;
            label57:
            str1 = localResources.getString(paramInt2);
            break label22;
            label68:
            str2 = localResources.getString(paramInt3);
            break label30;
            label80:
            str3 = localResources.getString(paramInt4);
        }
    }

    public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
        Bundle localBundle = new Bundle();
        localBundle.putString(j, paramString1);
        localBundle.putString(k, paramString2);
        localBundle.putString(l, paramString3);
        localBundle.putString(m, paramString4);
        setArguments(localBundle);
    }

    public abstract void d();

    public abstract void e();

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.n = paramBundle.getString(j);
        this.o = paramBundle.getString(k);
        this.p = paramBundle.getString(l);
        this.q = paramBundle.getString(m);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */