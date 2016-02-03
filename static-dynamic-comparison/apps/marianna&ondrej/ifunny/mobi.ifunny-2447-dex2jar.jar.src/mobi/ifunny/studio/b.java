package mobi.ifunny.studio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.k;
import mobi.ifunny.f;
import mobi.ifunny.studio.gif.GifCaptionActivity;
import mobi.ifunny.studio.gif.UploadGifActivity;

class b
        implements DialogInterface.OnClickListener {
    b(a parama) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = (f) this.a.getActivity();
        switch (paramInt) {
        }
        for (; ; ) {
            this.a.a();
            this.a.getActivity().finish();
            return;
            paramDialogInterface = new Intent(paramDialogInterface, GifCaptionActivity.class);
            paramDialogInterface.putExtra("state.loader.uri", a.a(this.a));
            this.a.startActivity(paramDialogInterface);
            continue;
            paramDialogInterface = new Intent(paramDialogInterface, UploadGifActivity.class);
            paramDialogInterface.putExtra("state.loader.uri", a.a(this.a));
            this.a.startActivity(paramDialogInterface);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */