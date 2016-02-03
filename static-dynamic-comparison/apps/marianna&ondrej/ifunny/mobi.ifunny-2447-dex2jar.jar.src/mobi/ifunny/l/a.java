package mobi.ifunny.l;

import android.os.Bundle;
import mobi.ifunny.f;

public abstract class a
        extends f
        implements h {
    private String o;
    private boolean p;
    private boolean q;

    public void H_() {
        this.p = true;
    }

    public boolean I_() {
        return this.p;
    }

    public void J_() {
        this.q = true;
    }

    public void K_() {
        this.q = false;
    }

    public String L_() {
        return this.o;
    }

    public void M_() {
        this.p = false;
    }

    public void b(String... paramVarArgs) {
        g.a(this, paramVarArgs);
    }

    public void b_(String paramString) {
        this.o = paramString;
    }

    public boolean e(String paramString) {
        return g.b(this, paramString);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.o = paramBundle.getString("SAVE_SUBSCRIBE_ID");
        }
        g.a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.a(this, isFinishing());
    }

    protected void onPause() {
        super.onPause();
        g.c(this);
    }

    protected void onResume() {
        super.onResume();
        g.b(this);
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        g.c(this);
        paramBundle.putString("SAVE_SUBSCRIBE_ID", this.o);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */