package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForceViewTopicDailog
        extends DialogFragment {
    public static ForceViewTopicDailog newInstance() {
        return new ForceViewTopicDailog();
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = getActivity();
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramBundle);
        LinearLayout localLinearLayout = (LinearLayout) paramBundle.getLayoutInflater().inflate(2130903233, null);
        TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
        TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231298);
        localTextView1.setText(getString(2131100740));
        localTextView2.setText(getString(2131100777));
        localBuilder.setView(localLinearLayout);
        localBuilder.setNegativeButton(paramBundle.getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        return localBuilder.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/ForceViewTopicDailog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */