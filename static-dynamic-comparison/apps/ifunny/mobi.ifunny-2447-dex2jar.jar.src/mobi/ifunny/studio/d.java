package mobi.ifunny.studio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.k;
import mobi.ifunny.f;
import mobi.ifunny.studio.caption.CaptionEditorActivity;
import mobi.ifunny.studio.image.UploadImageActivity;
import mobi.ifunny.studio.meme.MemeEditorActivity;

class d
        implements DialogInterface.OnClickListener {
    d(c paramc) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = (f) this.a.getActivity();
        switch (paramInt) {
        }
        for (; ; ) {
            this.a.a();
            this.a.getActivity().finish();
            return;
            paramDialogInterface = new Intent(paramDialogInterface, CaptionEditorActivity.class);
            paramDialogInterface.putExtra("export.image.uri", c.a(this.a));
            this.a.startActivity(paramDialogInterface);
            continue;
            paramDialogInterface = new Intent(paramDialogInterface, MemeEditorActivity.class);
            paramDialogInterface.putExtra("export.image.uri", c.a(this.a));
            this.a.startActivity(paramDialogInterface);
            continue;
            paramDialogInterface = new Intent(paramDialogInterface, UploadImageActivity.class);
            paramDialogInterface.putExtra("export.image.uri", c.a(this.a));
            this.a.startActivity(paramDialogInterface);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */