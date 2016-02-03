package mobi.ifunny.studio.comics;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;

public class f
        extends android.support.v4.app.g {
    public Dialog a(Bundle paramBundle) {
        Object localObject = (FrameEditorActivity) getActivity();
        paramBundle = new AlertDialog.Builder((Context) localObject);
        paramBundle.setTitle(2131689997);
        localObject = new l((Context) localObject, FrameEditorActivity.j((FrameEditorActivity) localObject), FrameEditorActivity.k((FrameEditorActivity) localObject));
        paramBundle.setAdapter((ListAdapter) localObject, new g(this, (l) localObject));
        return paramBundle.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */