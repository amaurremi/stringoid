package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.b.c;
import android.widget.ImageButton;

class f
        extends ImageButton
        implements j {
    public f(ActionMenuPresenter paramActionMenuPresenter, Context paramContext) {
        super(paramContext, null, c.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.a.a();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */