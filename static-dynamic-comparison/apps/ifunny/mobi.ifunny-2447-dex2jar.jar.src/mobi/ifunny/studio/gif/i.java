package mobi.ifunny.studio.gif;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;

import java.util.ArrayList;

public class i
        extends g {
    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(2131690126);
        j localj = new j(this);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getResources().getString(2131690125));
        localArrayList.add(getResources().getString(2131690127));
        localArrayList.add(getResources().getString(2131690059));
        paramBundle.setItems((CharSequence[]) localArrayList.toArray(new String[localArrayList.size()]), localj);
        return paramBundle.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/gif/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */