package android.support.v7.a;

import android.support.v7.b.f;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.ad;
import android.view.ActionMode;
import android.view.ActionMode.Callback;

class v
        extends s
        implements ad {
    final NativeActionModeAwareLayout e;
    private ActionMode f;

    public v(g paramg, b paramb) {
        super(paramg, paramb);
        this.e = ((NativeActionModeAwareLayout) paramg.findViewById(f.action_bar_root));
        if (this.e != null) {
            this.e.setActionModeForChildListener(this);
        }
    }

    public ActionMode.Callback a(ActionMode.Callback paramCallback) {
        return new w(this, paramCallback);
    }

    public void f() {
        super.f();
        if (this.f != null) {
            this.f.finish();
        }
    }

    public void g() {
        super.g();
        if (this.f != null) {
            this.f.finish();
        }
    }

    boolean m() {
        return (this.f == null) && (super.m());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */