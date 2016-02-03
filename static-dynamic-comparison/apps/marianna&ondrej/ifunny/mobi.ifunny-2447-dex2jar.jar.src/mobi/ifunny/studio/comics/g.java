package mobi.ifunny.studio.comics;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g
        implements DialogInterface.OnClickListener {
    g(f paramf, l paraml) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        FrameEditorActivity.b((FrameEditorActivity) this.b.getActivity(), paramInt);
        this.a.notifyDataSetChanged();
        this.b.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */