package com.uservoice.uservoicesdk.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.plurals;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.activity.ForumActivity;
import com.uservoice.uservoicesdk.activity.InstantAnswersActivity;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.deflection.Deflection;
import com.uservoice.uservoicesdk.flow.SigninCallback;
import com.uservoice.uservoicesdk.flow.SigninManager;
import com.uservoice.uservoicesdk.image.ImageCache;
import com.uservoice.uservoicesdk.model.Comment;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.ui.DefaultCallback;
import com.uservoice.uservoicesdk.ui.PaginatedAdapter;
import com.uservoice.uservoicesdk.ui.PaginationScrollListener;
import com.uservoice.uservoicesdk.ui.Utils;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
public class SuggestionDialogFragment
        extends DialogFragmentBugfixed {
    private PaginatedAdapter<Comment> adapter;
    private Context context;
    private String deflectingType;
    private View headerView;
    private Suggestion suggestion;
    private View view;

    public SuggestionDialogFragment(Suggestion paramSuggestion, String paramString) {
        this.suggestion = paramSuggestion;
        this.deflectingType = paramString;
    }

    private void displaySuggestion(View paramView, Suggestion paramSuggestion) {
        Object localObject = (TextView) paramView.findViewById(R.id.uv_status);
        TextView localTextView1 = (TextView) paramView.findViewById(R.id.uv_response_status);
        View localView = paramView.findViewById(R.id.uv_response_divider);
        TextView localTextView2 = (TextView) paramView.findViewById(R.id.uv_title);
        if (paramSuggestion.isSubscribed()) {
            ((CheckBox) paramView.findViewById(R.id.uv_subscribe_checkbox)).setChecked(true);
        }
        if (paramSuggestion.getStatus() == null) {
            ((TextView) localObject).setVisibility(8);
            localTextView1.setTextColor(-12303292);
            localView.setBackgroundColor(-12303292);
            localTextView2.setText(paramSuggestion.getTitle());
            ((TextView) paramView.findViewById(R.id.uv_text)).setText(paramSuggestion.getText());
            ((TextView) paramView.findViewById(R.id.uv_creator)).setText(String.format(paramView.getContext().getString(R.string.uv_posted_by_format), new Object[]{paramSuggestion.getCreatorName(), DateFormat.getDateInstance().format(paramSuggestion.getCreatedAt())}));
            if (paramSuggestion.getAdminResponseText() != null) {
                break label341;
            }
            paramView.findViewById(R.id.uv_admin_response).setVisibility(8);
        }
        for (; ; ) {
            ((TextView) paramView.findViewById(R.id.uv_comment_count)).setText(Utils.getQuantityString(paramView, R.plurals.uv_comments, paramSuggestion.getNumberOfComments()).toUpperCase(Locale.getDefault()));
            ((TextView) paramView.findViewById(R.id.uv_subscriber_count)).setText(String.format(paramView.getContext().getResources().getQuantityString(R.plurals.uv_number_of_subscribers_format, paramSuggestion.getNumberOfSubscribers()), new Object[]{Utils.getQuantityString(paramView, R.plurals.uv_subscribers, paramSuggestion.getNumberOfSubscribers())}));
            return;
            int i = Color.parseColor(paramSuggestion.getStatusColor());
            ((TextView) localObject).setBackgroundColor(i);
            ((TextView) localObject).setText(paramSuggestion.getStatus());
            localTextView1.setTextColor(i);
            localTextView1.setText(String.format(getString(R.string.uv_admin_response_format), new Object[]{paramSuggestion.getStatus().toUpperCase(Locale.getDefault())}));
            localView.setBackgroundColor(i);
            break;
            label341:
            paramView.findViewById(R.id.uv_admin_response).setVisibility(0);
            ((TextView) paramView.findViewById(R.id.uv_admin_name)).setText(paramSuggestion.getAdminResponseUserName());
            ((TextView) paramView.findViewById(R.id.uv_response_date)).setText(DateFormat.getDateInstance().format(paramSuggestion.getAdminResponseCreatedAt()));
            ((TextView) paramView.findViewById(R.id.uv_response_text)).setText(paramSuggestion.getAdminResponseText());
            localObject = (ImageView) paramView.findViewById(R.id.uv_admin_avatar);
            ImageCache.getInstance().loadImage(paramSuggestion.getAdminResponseAvatarUrl(), (ImageView) localObject);
        }
    }

    private PaginatedAdapter<Comment> getListAdapter() {
        new PaginatedAdapter(getActivity(), R.layout.uv_comment_item, new ArrayList()) {
            protected void customizeLayout(View paramAnonymousView, Comment paramAnonymousComment) {
                ((TextView) paramAnonymousView.findViewById(R.id.uv_text)).setText(paramAnonymousComment.getText());
                ((TextView) paramAnonymousView.findViewById(R.id.uv_name)).setText(paramAnonymousComment.getUserName());
                ((TextView) paramAnonymousView.findViewById(R.id.uv_date)).setText(DateFormat.getDateInstance().format(paramAnonymousComment.getCreatedAt()));
                paramAnonymousView = (ImageView) paramAnonymousView.findViewById(R.id.uv_avatar);
                ImageCache.getInstance().loadImage(paramAnonymousComment.getAvatarUrl(), paramAnonymousView);
            }

            protected int getTotalNumberOfObjects() {
                return SuggestionDialogFragment.this.suggestion.getNumberOfComments();
            }

            public boolean isEnabled(int paramAnonymousInt) {
                return false;
            }

            protected void loadPage(int paramAnonymousInt, Callback<List<Comment>> paramAnonymousCallback) {
                Comment.loadComments(SuggestionDialogFragment.this.suggestion, paramAnonymousInt, paramAnonymousCallback);
            }
        };
    }

    public void commentPosted(Comment paramComment) {
        this.adapter.add(0, paramComment);
        this.suggestion.commentPosted(paramComment);
        displaySuggestion(this.view, this.suggestion);
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        this.context = getActivity();
        setStyle(1, getTheme());
        if (!Utils.isDarkTheme(getActivity())) {
            paramBundle.setInverseBackgroundForced(true);
        }
        this.view = getActivity().getLayoutInflater().inflate(R.layout.uv_idea_dialog, null);
        this.headerView = getActivity().getLayoutInflater().inflate(R.layout.uv_idea_dialog_header, null);
        this.headerView.findViewById(R.id.uv_subscribe).setOnClickListener(new View.OnClickListener() {
            public void onClick(final View paramAnonymousView) {
                paramAnonymousView = new DefaultCallback(SuggestionDialogFragment.this.getActivity()) {
                    public void onModel(Suggestion paramAnonymous2Suggestion) {
                        if ((SuggestionDialogFragment.this.getActivity() instanceof InstantAnswersActivity)) {
                            Deflection.trackDeflection("subscribed", SuggestionDialogFragment.this.deflectingType, paramAnonymous2Suggestion);
                        }
                        SuggestionDialogFragment.this.suggestionSubscriptionUpdated(paramAnonymous2Suggestion);
                    }
                };
                if (SuggestionDialogFragment.this.suggestion.isSubscribed()) {
                    SuggestionDialogFragment.this.suggestion.unsubscribe(paramAnonymousView);
                    return;
                }
                if (Session.getInstance().getEmail() != null) {
                    SigninManager.signinForSubscribe(SuggestionDialogFragment.this.getActivity(), Session.getInstance().getEmail(), new SigninCallback() {
                        public void onSuccess() {
                            SuggestionDialogFragment.this.suggestion.subscribe(paramAnonymousView);
                        }
                    });
                    return;
                }
                new SubscribeDialogFragment(SuggestionDialogFragment.this.suggestion, SuggestionDialogFragment.this, SuggestionDialogFragment.this.deflectingType).show(SuggestionDialogFragment.this.getFragmentManager(), "SubscribeDialogFragment");
            }
        });
        this.headerView.findViewById(R.id.uv_post_comment).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                new CommentDialogFragment(SuggestionDialogFragment.this.suggestion, SuggestionDialogFragment.this).show(SuggestionDialogFragment.this.getActivity().getSupportFragmentManager(), "CommentDialogFragment");
            }
        });
        ListView localListView = (ListView) this.view.findViewById(R.id.uv_list);
        localListView.addHeaderView(this.headerView);
        displaySuggestion(this.view, this.suggestion);
        this.adapter = getListAdapter();
        localListView.setAdapter(this.adapter);
        localListView.setDivider(null);
        localListView.setOnScrollListener(new PaginationScrollListener(this.adapter));
        paramBundle.setView(this.view);
        paramBundle.setNegativeButton(R.string.uv_close, null);
        Babayaga.track(Babayaga.Event.VIEW_IDEA, this.suggestion.getId());
        return paramBundle.create();
    }

    public void suggestionSubscriptionUpdated(Suggestion paramSuggestion) {
        if (getActivity() == null) {
            return;
        }
        CheckBox localCheckBox = (CheckBox) this.headerView.findViewById(R.id.uv_subscribe_checkbox);
        if (this.suggestion.isSubscribed()) {
            Toast.makeText(this.context, R.string.uv_msg_subscribe_success, 0).show();
            localCheckBox.setChecked(true);
        }
        for (; ; ) {
            displaySuggestion(this.view, this.suggestion);
            if (!(getActivity() instanceof ForumActivity)) {
                break;
            }
            ((ForumActivity) getActivity()).suggestionUpdated(paramSuggestion);
            return;
            Toast.makeText(this.context, R.string.uv_msg_unsubscribe, 0).show();
            localCheckBox.setChecked(false);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/SuggestionDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */