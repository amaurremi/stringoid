package mobi.ifunny.studio.comics.engine.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PointF;

import java.util.ArrayList;

import mobi.ifunny.studio.comics.engine.b.g;
import mobi.ifunny.studio.comics.engine.c;
import mobi.ifunny.studio.comics.engine.c.h;
import mobi.ifunny.studio.comics.engine.f;

class j
        implements DialogInterface.OnClickListener {
    j(i parami, ArrayList paramArrayList, h paramh, PointF paramPointF) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        Object localObject = (m) this.a.get(paramInt);
        f localf = this.d.j();
        switch (l.b[localObject.ordinal()]) {
            default:
            case 1:
            case 2:
                do {
                    do {
                        return;
                        paramDialogInterface = this.d.i();
                    } while (paramDialogInterface == null);
                    paramDialogInterface.a(this.b);
                    return;
                    paramDialogInterface = this.d.i();
                } while (paramDialogInterface == null);
                paramDialogInterface.a(this.c);
                return;
            case 3:
                localf.a(new g(this.b), c.a);
                return;
            case 4:
                localf.b(this.b, 0);
                return;
            case 5:
                localObject = i.a(this.d, this.b);
                paramDialogInterface.dismiss();
                ((Dialog) localObject).show();
                return;
        }
        this.d.i().b(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/engine/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */