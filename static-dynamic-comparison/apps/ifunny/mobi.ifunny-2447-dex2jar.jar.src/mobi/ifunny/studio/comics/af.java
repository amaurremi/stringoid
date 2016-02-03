package mobi.ifunny.studio.comics;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import java.util.ArrayList;

import mobi.ifunny.studio.comics.a.a;
import mobi.ifunny.studio.comics.a.c;

class af
        implements DialogInterface.OnClickListener {
    af(RageEditorActivity paramRageEditorActivity, ArrayList paramArrayList, int paramInt, mobi.ifunny.studio.a.b.b paramb, boolean paramBoolean) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = (am) this.a.get(paramInt);
        switch (ah.a[paramDialogInterface.ordinal()]) {
        }
        do {
            return;
            RageEditorActivity.a(this.e, this.b);
            return;
            RageEditorActivity.a(this.e, this.b, this.c);
            return;
            RageEditorActivity.b(this.e, this.b, this.c);
            return;
            paramDialogInterface = RageEditorActivity.b(this.e).a();
        } while (!(paramDialogInterface instanceof c));
        paramDialogInterface = (mobi.ifunny.studio.a.b.b) paramDialogInterface.a();
        if (this.d) {
            RageEditorActivity.c(this.e, this.b, paramDialogInterface);
            return;
        }
        RageEditorActivity.d(this.e, this.b, paramDialogInterface);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */