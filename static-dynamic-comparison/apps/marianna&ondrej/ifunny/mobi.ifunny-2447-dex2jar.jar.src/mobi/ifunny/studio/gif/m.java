package mobi.ifunny.studio.gif;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.b.a.a.a.a;
import mobi.ifunny.f;

class m
        implements DialogInterface.OnClickListener {
    m(l paraml) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = (f) this.a.getActivity();
        switch (paramInt) {
        }
        for (; ; ) {
            this.a.a();
            return;
            Intent localIntent = a.a();
            localIntent.setType("image/gif");
            paramDialogInterface.startActivityForResult(localIntent, 1);
            continue;
            paramDialogInterface.startActivityForResult(new Intent(paramDialogInterface, UploadGifUrlActivity.class), 0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */