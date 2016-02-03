package com.uservoice.uservoicesdk.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.flow.InitManager;
import com.uservoice.uservoicesdk.ui.InstantAnswersAdapter;

public abstract class InstantAnswersActivity
        extends BaseListActivity {
    private InstantAnswersAdapter adapter;

    protected abstract InstantAnswersAdapter createAdapter();

    protected abstract int getDiscardDialogMessage();

    public void onBackPressed() {
        if (this.adapter.hasText()) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
            localBuilder.setTitle(R.string.uv_confirm);
            localBuilder.setMessage(getDiscardDialogMessage());
            localBuilder.setPositiveButton(R.string.uv_yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    InstantAnswersActivity.this.finish();
                }
            });
            localBuilder.setNegativeButton(R.string.uv_no, null);
            localBuilder.show();
            return;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        getListView().setDivider(null);
        this.adapter = createAdapter();
        setListAdapter(this.adapter);
        getListView().setOnHierarchyChangeListener(this.adapter);
        getListView().setOnItemClickListener(this.adapter);
        getListView().setDescendantFocusability(262144);
        new InitManager(this, new Runnable() {
            public void run() {
                InstantAnswersActivity.this.onInitialize();
            }
        }).init();
        getWindow().setSoftInputMode(36);
    }

    protected void onInitialize() {
        this.adapter.notifyDataSetChanged();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/activity/InstantAnswersActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */