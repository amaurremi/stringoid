package mobi.ifunny.profile.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;

class t
        implements DialogInterface.OnClickListener {
    t(s params) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        switch (paramInt) {
        }
        for (; ; ) {
            paramDialogInterface.dismiss();
            return;
            Fragment localFragment = this.a.getTargetFragment();
            k localk = this.a.getActivity();
            if ((localFragment instanceof u)) {
                ((u) localFragment).O_();
            }
            if ((localk instanceof u)) {
                ((u) localk).O_();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */