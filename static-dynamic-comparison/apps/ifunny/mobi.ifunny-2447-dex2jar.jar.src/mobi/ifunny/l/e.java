package mobi.ifunny.l;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import mobi.ifunny.a;

public class e
        extends a
        implements h {
    private String a;
    private boolean b;
    private boolean c;

    private boolean a(Fragment paramFragment) {
        Fragment localFragment = paramFragment.getParentFragment();
        if (localFragment == null) {
            return paramFragment.isRemoving();
        }
        if (localFragment.isRemoving()) {
            return true;
        }
        return a(localFragment);
    }

    public void H_() {
        this.b = true;
    }

    public boolean I_() {
        return this.b;
    }

    public void J_() {
        this.c = true;
    }

    public void K_() {
        this.c = false;
    }

    public String L_() {
        return this.a;
    }

    public void M_() {
        this.b = false;
    }

    public void a(String... paramVarArgs) {
        g.a(this, paramVarArgs);
    }

    public void b_(String paramString) {
        this.a = paramString;
    }

    public boolean f(String paramString) {
        return g.b(this, paramString);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.a = paramBundle.getString("SAVE_SUBSCRIBE_ID");
        }
        g.a(this);
    }

    public void onDestroy() {
        super.onDestroy();
        boolean bool2 = isRemoving();
        boolean bool1 = bool2;
        if (!bool2) {
            bool1 = a(this);
        }
        g.a(this, bool1);
    }

    public void onPause() {
        super.onPause();
        g.c(this);
    }

    public void onResume() {
        super.onResume();
        g.b(this);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        g.c(this);
        paramBundle.putString("SAVE_SUBSCRIBE_ID", this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/l/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */