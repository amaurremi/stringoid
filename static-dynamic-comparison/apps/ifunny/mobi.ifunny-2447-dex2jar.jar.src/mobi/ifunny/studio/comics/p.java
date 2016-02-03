package mobi.ifunny.studio.comics;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.b.a.a.a.a;
import mobi.ifunny.studio.source.WebSearchActivity;

class p
        implements DialogInterface.OnClickListener {
    p(o paramo) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = (FrameEditorActivity) this.a.getActivity();
        if (paramDialogInterface == null) {
            return;
        }
        switch (paramInt) {
            default:
                return;
            case 0:
                this.a.b();
                paramDialogInterface.startActivityForResult(a.a(), 0);
                return;
        }
        this.a.b();
        Intent localIntent = new Intent(paramDialogInterface, WebSearchActivity.class);
        localIntent.putExtra("intent.search_type", "pic");
        paramDialogInterface.startActivityForResult(localIntent, 3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */