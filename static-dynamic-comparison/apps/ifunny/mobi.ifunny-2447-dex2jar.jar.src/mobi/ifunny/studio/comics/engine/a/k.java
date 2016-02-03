package mobi.ifunny.studio.comics.engine.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.ifunny.studio.comics.engine.c.h;
import mobi.ifunny.studio.comics.engine.f;

class k
        implements DialogInterface.OnClickListener {
    f a = this.c.j();

    k(i parami, h paramh) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 0:
                this.a.c(this.b, 0);
                return;
            case 1:
                this.a.d(this.b, 0);
                return;
            case 2:
                this.a.e(this.b, 0);
                return;
        }
        this.a.f(this.b, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */