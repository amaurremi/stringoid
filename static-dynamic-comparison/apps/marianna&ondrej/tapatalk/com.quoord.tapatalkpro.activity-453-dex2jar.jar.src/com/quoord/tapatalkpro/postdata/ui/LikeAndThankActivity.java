package com.quoord.tapatalkpro.postdata.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class LikeAndThankActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    private LikeAndThankAdapter adapter;
    private ForumStatus forumStatus;
    private boolean isLike;
    private ArrayList<HashMap> list;
    private ListView listView;
    private LikeAndThankActivity mActivity;

    public void closeProgress() {
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        getActionBar().setIcon(2130837525);
        setContentView(2130903259);
        this.listView = ((ListView) findViewById(2131231364));
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        this.list = ((ArrayList) getIntent().getSerializableExtra("user_map"));
        this.isLike = getIntent().getBooleanExtra("isLike", false);
        if (this.forumStatus != null) {
            this.adapter = new LikeAndThankAdapter(this, this.forumStatus, this.list, this.isLike);
        }
        this.listView.setAdapter(this.adapter);
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        setListOnclick();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        finish();
        return true;
    }

    public void setListOnclick() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                try {
                    if (LikeAndThankActivity.this.forumStatus.isLogin()) {
                        paramAnonymousAdapterView = new Intent(LikeAndThankActivity.this.mActivity, ProfilesActivity.class);
                        paramAnonymousAdapterView.putExtra("forumStatus", LikeAndThankActivity.this.forumStatus);
                        paramAnonymousAdapterView.putExtra("iconusername", new String((byte[]) ((HashMap) LikeAndThankActivity.this.list.get(paramAnonymousInt)).get("username")));
                        if (((HashMap) LikeAndThankActivity.this.list.get(paramAnonymousInt)).containsKey("userid")) {
                            paramAnonymousView = ((HashMap) LikeAndThankActivity.this.list.get(paramAnonymousInt)).get("userid");
                            if (paramAnonymousView != null) {
                                break label147;
                            }
                            paramAnonymousAdapterView.putExtra("userid", "");
                        }
                        for (; ; ) {
                            LikeAndThankActivity.this.mActivity.startActivity(paramAnonymousAdapterView);
                            return;
                            label147:
                            if ((paramAnonymousView instanceof String)) {
                                paramAnonymousAdapterView.putExtra("userid", (String) paramAnonymousView);
                            } else if ((paramAnonymousView instanceof byte[])) {
                                paramAnonymousAdapterView.putExtra("userid", new String((byte[]) paramAnonymousView));
                            } else {
                                paramAnonymousAdapterView.putExtra("userid", "");
                            }
                        }
                    }
                    return;
                } catch (Exception paramAnonymousAdapterView) {
                }
            }
        });
    }

    public void showProgress() {
    }

    public void showProgress(String paramString) {
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/postdata/ui/LikeAndThankActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */