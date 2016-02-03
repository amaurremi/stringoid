package com.uservoice.uservoicesdk.activity;

import android.content.Context;
import android.os.Bundle;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.model.Forum;
import com.uservoice.uservoicesdk.ui.DefaultCallback;
import com.uservoice.uservoicesdk.ui.InstantAnswersAdapter;
import com.uservoice.uservoicesdk.ui.PostIdeaAdapter;

public class PostIdeaActivity
        extends InstantAnswersActivity {
    protected InstantAnswersAdapter createAdapter() {
        return new PostIdeaAdapter(this);
    }

    protected int getDiscardDialogMessage() {
        return R.string.uv_msg_confirm_discard_idea;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setTitle(R.string.uv_idea_form_title);
    }

    protected void onInitialize() {
        if (Session.getInstance().getForum() != null) {
            super.onInitialize();
            return;
        }
        Forum.loadForum(Session.getInstance().getConfig().getForumId(), new DefaultCallback(this) {
            public void onModel(Forum paramAnonymousForum) {
                Session.getInstance().setForum(paramAnonymousForum);
                PostIdeaActivity.this.onInitialize();
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/activity/PostIdeaActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */