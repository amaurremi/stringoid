package com.uservoice.uservoicesdk.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.flow.SigninCallback;
import com.uservoice.uservoicesdk.flow.SigninManager;
import com.uservoice.uservoicesdk.model.Category;
import com.uservoice.uservoicesdk.model.Forum;
import com.uservoice.uservoicesdk.model.Suggestion;
import com.uservoice.uservoicesdk.rest.RestResult;

import java.util.ArrayList;
import java.util.List;

public class PostIdeaAdapter
        extends InstantAnswersAdapter {
    private static int CATEGORY = 9;
    private static int DESCRIPTION = 8;
    private static int HELP = 10;
    private static int TEXT_HEADING = 11;
    private Spinner categorySelect;
    private EditText descriptionField;

    public PostIdeaAdapter(FragmentActivity paramFragmentActivity) {
        super(paramFragmentActivity);
        this.continueButtonMessage = R.string.uv_post_idea_continue_button;
    }

    protected void doSubmit() {
        this.isPosting = false;
        SigninManager.signIn(this.context, this.emailField.getText().toString(), this.nameField.getText().toString(), new SigninCallback() {
            public void onSuccess() {
                PostIdeaAdapter.this.isPosting = true;
                if (PostIdeaAdapter.this.categorySelect == null) {
                }
                for (Category localCategory = null; ; localCategory = (Category) PostIdeaAdapter.this.categorySelect.getSelectedItem()) {
                    Suggestion.createSuggestion(Session.getInstance().getForum(), localCategory, PostIdeaAdapter.this.textField.getText().toString(), PostIdeaAdapter.this.descriptionField.getText().toString(), 1, new DefaultCallback(PostIdeaAdapter.this.context) {
                        public void onError(RestResult paramAnonymous2RestResult) {
                            PostIdeaAdapter.this.isPosting = false;
                            super.onError(paramAnonymous2RestResult);
                        }

                        public void onModel(Suggestion paramAnonymous2Suggestion) {
                            Babayaga.track(Babayaga.Event.SUBMIT_IDEA);
                            Toast.makeText(PostIdeaAdapter.this.context, R.string.uv_msg_idea_created, 0).show();
                            PostIdeaAdapter.this.context.finish();
                        }
                    });
                    return;
                }
            }
        });
    }

    protected List<Integer> getDetailRows() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(DESCRIPTION));
        if (Session.getInstance().getForum().getCategories().size() > 0) {
            localArrayList.add(Integer.valueOf(CATEGORY));
        }
        localArrayList.add(Integer.valueOf(this.SPACE));
        localArrayList.add(Integer.valueOf(this.EMAIL_FIELD));
        localArrayList.add(Integer.valueOf(this.NAME_FIELD));
        return localArrayList;
    }

    protected List<Integer> getRows() {
        List localList = super.getRows();
        localList.add(0, Integer.valueOf(TEXT_HEADING));
        if (this.state == InstantAnswersAdapter.State.DETAILS) {
            localList.add(Integer.valueOf(HELP));
        }
        return localList;
    }

    protected String getSubmitString() {
        return this.context.getString(R.string.uv_submit_idea);
    }

    @SuppressLint({"CutPasteId"})
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int i = getItemViewType(paramInt);
        View localView = paramView;
        if (paramView == null) {
            if (i != DESCRIPTION) {
                break label125;
            }
            localView = this.inflater.inflate(R.layout.uv_text_field_item, null);
            ((TextView) localView.findViewById(R.id.uv_header_text)).setText(R.string.uv_idea_description_heading);
            paramView = (EditText) localView.findViewById(R.id.uv_text_field);
            restoreEnteredText(this.descriptionField, paramView, "");
            this.descriptionField = paramView;
            this.descriptionField.setHint(R.string.uv_idea_description_hint);
        }
        while ((i == DESCRIPTION) || (i == CATEGORY) || (i == HELP) || (i == TEXT_HEADING)) {
            return localView;
            label125:
            if (i == CATEGORY) {
                localView = this.inflater.inflate(R.layout.uv_select_field_item, null);
                paramView = (TextView) localView.findViewById(R.id.uv_header_text);
                this.categorySelect = ((Spinner) localView.findViewById(R.id.uv_select_field));
                this.categorySelect.setAdapter(new SpinnerAdapter(this.context, Session.getInstance().getForum().getCategories()));
                paramView.setText(R.string.uv_category);
            } else if (i == HELP) {
                localView = this.inflater.inflate(R.layout.uv_idea_help_item, null);
            } else if (i == TEXT_HEADING) {
                localView = this.inflater.inflate(R.layout.uv_header_item, null);
                ((TextView) localView.findViewById(R.id.uv_header_text)).setText(R.string.uv_idea_text_heading);
            } else {
                localView = super.getView(paramInt, paramView, paramViewGroup);
            }
        }
        if (i == this.TEXT) {
            paramView = (TextView) localView.findViewById(R.id.uv_text);
            paramView.setHint(R.string.uv_idea_text_hint);
            paramView.setMinLines(1);
            return localView;
        }
        return super.getView(paramInt, localView, paramViewGroup);
    }

    public int getViewTypeCount() {
        return super.getViewTypeCount() + 4;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/PostIdeaAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */