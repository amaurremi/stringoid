package mobi.ifunny.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class f
        implements DialogInterface.OnKeyListener {
    f(ImagePreviewFragment paramImagePreviewFragment) {
    }

    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            this.a.d();
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */