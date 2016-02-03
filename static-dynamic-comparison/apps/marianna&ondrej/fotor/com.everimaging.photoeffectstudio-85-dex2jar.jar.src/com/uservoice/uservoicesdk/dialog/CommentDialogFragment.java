package com.uservoice.uservoicesdk.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.flow.SigninCallback;
import com.uservoice.uservoicesdk.flow.SigninManager;
import com.uservoice.uservoicesdk.model.Comment;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.ui.DefaultCallback;
import com.uservoice.uservoicesdk.ui.Utils;

@SuppressLint({"ValidFragment"})
public class CommentDialogFragment
        extends DialogFragmentBugfixed {
    private final Suggestion suggestion;
    private final SuggestionDialogFragment suggestionDialog;

    public CommentDialogFragment(Suggestion paramSuggestion, SuggestionDialogFragment paramSuggestionDialogFragment) {
        this.suggestion = paramSuggestion;
        this.suggestionDialog = paramSuggestionDialogFragment;
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        if (!Utils.isDarkTheme(getActivity())) {
            paramBundle.setInverseBackgroundForced(true);
        }
        paramBundle.setTitle(R.string.uv_post_a_comment);
        final Object localObject = getActivity().getLayoutInflater().inflate(R.layout.uv_comment_dialog, null);
        final EditText localEditText1 = (EditText) ((View) localObject).findViewById(R.id.uv_comment_edit_text);
        View localView1 = ((View) localObject).findViewById(R.id.uv_email);
        View localView2 = ((View) localObject).findViewById(R.id.uv_name);
        final EditText localEditText2 = (EditText) localView1.findViewById(R.id.uv_text_field);
        final EditText localEditText3 = (EditText) localView2.findViewById(R.id.uv_text_field);
        if (Session.getInstance().getUser() != null) {
            localView1.setVisibility(8);
            localView2.setVisibility(8);
        }
        for (; ; ) {
            paramBundle.setView((View) localObject);
            paramBundle.setNegativeButton(R.string.uv_cancel, null);
            localObject = getActivity();
            paramBundle.setPositiveButton(R.string.uv_post_comment, new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    paramAnonymousDialogInterface = localEditText1.getText().toString();
                    if (paramAnonymousDialogInterface.trim().length() > 0) {
                        SigninManager.signIn(CommentDialogFragment.this.getActivity(), localEditText2.getText().toString(), localEditText3.getText().toString(), new SigninCallback() {
                            public void onSuccess() {
                                Comment.createComment(CommentDialogFragment.this.suggestion, paramAnonymousDialogInterface, new DefaultCallback(CommentDialogFragment.this.getActivity()) {
                                    public void onModel(Comment paramAnonymous3Comment) {
                                        Toast.makeText(CommentDialogFragment .1.
                                        this.val$context, R.string.uv_msg_comment_posted, 0).show();
                                        CommentDialogFragment.this.suggestionDialog.commentPosted(paramAnonymous3Comment);
                                    }
                                });
                            }
                        });
                    }
                }
            });
            paramBundle = paramBundle.create();
            paramBundle.getWindow().setSoftInputMode(5);
            return paramBundle;
            localEditText2.setText(Session.getInstance().getEmail());
            ((TextView) localView1.findViewById(R.id.uv_header_text)).setText(R.string.uv_your_email_address);
            localEditText3.setText(Session.getInstance().getName());
            ((TextView) localView2.findViewById(R.id.uv_header_text)).setText(R.string.uv_your_name);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/CommentDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */