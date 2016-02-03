package mobi.ifunny.studio.comics;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class i
        implements DialogInterface.OnClickListener {
    i(h paramh) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = (FrameEditorActivity) this.a.getActivity();
        switch (paramInt) {
            default:
                return;
            case -1:
                FrameEditorActivity.i(paramDialogInterface);
                return;
        }
        this.a.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */