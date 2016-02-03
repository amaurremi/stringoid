package mobi.ifunny;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class h {
    private static final String a = h.class.getSimpleName();
    private static volatile h b;
    private String c;
    private SharedPreferences d;
    private SharedPreferences.Editor e;

    @SuppressLint({"CommitPrefEdits"})
    private h(Context paramContext) {
        this.c = paramContext.getPackageName().replace('.', '_');
        this.d = paramContext.getSharedPreferences(this.c, 0);
        this.e = this.d.edit();
    }

    public static String a(String paramString) {
        return "pref.installation_id_" + paramString;
    }

    public static h a() {
        return b;
    }

    public static void a(Context paramContext) {
        if (b == null) {
            b = new h(paramContext);
        }
    }

    public int a(String paramString, int paramInt) {
        d.a(a, "get " + paramString);
        return this.d.getInt(paramString, paramInt);
    }

    public long a(String paramString, long paramLong) {
        d.a(a, "get " + paramString);
        return this.d.getLong(paramString, paramLong);
    }

    public String a(String paramString1, String paramString2) {
        d.a(a, "get " + paramString1);
        return this.d.getString(paramString1, paramString2);
    }

    public boolean a(String paramString, boolean paramBoolean) {
        d.a(a, "get " + paramString);
        return this.d.getBoolean(paramString, paramBoolean);
    }

    public void b(String paramString, int paramInt) {
        d.a(a, "put " + paramString);
        this.e.putInt(paramString, paramInt);
        this.e.apply();
    }

    public void b(String paramString, long paramLong) {
        d.a(a, "put " + paramString);
        this.e.putLong(paramString, paramLong);
        this.e.apply();
    }

    public void b(String paramString1, String paramString2) {
        d.a(a, "put " + paramString1);
        this.e.putString(paramString1, paramString2);
        this.e.apply();
    }

    public void b(String paramString, boolean paramBoolean) {
        d.a(a, "put " + paramString);
        this.e.putBoolean(paramString, paramBoolean);
        this.e.apply();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */