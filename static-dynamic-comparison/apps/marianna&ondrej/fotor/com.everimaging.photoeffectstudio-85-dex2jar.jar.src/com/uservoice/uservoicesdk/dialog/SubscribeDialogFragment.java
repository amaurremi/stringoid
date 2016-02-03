package com.uservoice.uservoicesdk.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.activity.InstantAnswersActivity;
import com.uservoice.uservoicesdk.deflection.Deflection;
import com.uservoice.uservoicesdk.flow.SigninCallback;
import com.uservoice.uservoicesdk.flow.SigninManager;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.ui.DefaultCallback;
import com.uservoice.uservoicesdk.ui.Utils;

@SuppressLint({"ValidFragment"})
public class SubscribeDialogFragment
        extends DialogFragmentBugfixed {
    private final String deflectingType;
    private final Suggestion suggestion;
    private final SuggestionDialogFragment suggestionDialog;

    public SubscribeDialogFragment(Suggestion paramSuggestion, SuggestionDialogFragment paramSuggestionDialogFragment, String paramString) {
        this.suggestion = paramSuggestion;
        this.suggestionDialog = paramSuggestionDialogFragment;
        this.deflectingType = paramString;
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(R.string.uv_subscribe_dialog_title);
        if (!Utils.isDarkTheme(getActivity())) {
            paramBundle.setInverseBackgroundForced(true);
        }
        View localView = getActivity().getLayoutInflater().inflate(R.layout.uv_subscribe_dialog, null);
        final EditText localEditText = (EditText) localView.findViewById(R.id.uv_email);
        localEditText.setText(Session.getInstance().getEmail());
        paramBundle.setView(localView);
        paramBundle.setNegativeButton(R.string.uv_nevermind, null);
        paramBundle.setPositiveButton(R.string.uv_subscribe, new DialogInterface.OnClickListener() {
            public void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                Session.getInstance().persistIdentity(Session.getInstance().getName(), localEditText.getText().toString());
                SigninManager.signinForSubscribe(SubscribeDialogFragment.this.getActivity(), Session.getInstance().getEmail(), new SigninCallback() {
                    public void onSuccess() {
                        SubscribeDialogFragment.this.suggestion.subscribe(new DefaultCallback(SubscribeDialogFragment.this.getActivity()) {
                            public void onModel(Suggestion paramAnonymous3Suggestion) {
                                if ((SubscribeDialogFragment.this.getActivity() instanceof InstantAnswersActivity)) {
                                    Deflection.trackDeflection("subscribed", SubscribeDialogFragment.this.deflectingType, paramAnonymous3Suggestion);
                                }
                                SubscribeDialogFragment.this.suggestionDialog.suggestionSubscriptionUpdated(paramAnonymous3Suggestion);
                                SubscribeDialogFragment .1 .1. this.val$dialog.dismiss();
                            }
                        });
                    }
                });
            }
        });
        paramBundle = paramBundle.create();
        paramBundle.getWindow().setSoftInputMode(5);
        return paramBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/SubscribeDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */