package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.util.ArrayList;

public class IcsRecommendActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    public static final int OPENFORUM = 100;
    public boolean add_favoriate;
    private IcsRecommendForumFragment forumFragment;
    private ArrayList<Object> mDatas = new ArrayList();
    private SharedPreferences prefs;
    public boolean recommendForums;
    private IcsRecommendTopicFragment topicFragment;
    private String url;

    public void closeProgress() {
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return null;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        ForumStatus localForumStatus = new ForumStatus(this);
        localForumStatus.setLogin(true);
        localForumStatus.tapatalkForum = paramTapatalkForum;
        return localForumStatus;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        setTheme(2131361803);
        super.onCreate(paramBundle);
        setContentView(2130903112);
        this.prefs = Prefs.get(this);
        paramBundle = getActionBar();
        paramBundle.setDisplayShowTitleEnabled(true);
        paramBundle.setIcon(2130837525);
        paramBundle = getSupportFragmentManager().beginTransaction();
        this.mDatas = ((ArrayList) getIntent().getSerializableExtra("recommend_data"));
        String str = getIntent().getExtras().getString("round");
        int i = this.prefs.getInt("tapatalk_auid", -1);
        this.recommendForums = getIntent().getBooleanExtra("recommendForums", false);
        if (this.recommendForums) {
            this.forumFragment = IcsRecommendForumFragment.newInstance(this.mDatas);
            paramBundle.add(2131230953, this.forumFragment);
            paramBundle.commit();
        }
        for (this.url = (TapatalkJsonEngine.LOG_RECOMMEND_PUSH + "?au_id=" + i + "&type=forum" + "&round=" + str + "&" + TapatalkApp.APP_KEY); ; this.url = (TapatalkJsonEngine.LOG_RECOMMEND_PUSH + "?au_id=" + i + "&type=topic" + "&round=" + str + "&" + TapatalkApp.APP_KEY)) {
            TapatalkJsonEngine.callLogin(this, this.url);
            return;
            this.topicFragment = IcsRecommendTopicFragment.newInstance(this.mDatas);
            paramBundle.add(2131230953, this.topicFragment);
            paramBundle.commit();
        }
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            if (this.add_favoriate) {
                paramKeyEvent = new Intent(this, AccountEntryActivity.class);
                paramKeyEvent.putExtra("add_favoriate", this.add_favoriate);
                startActivity(paramKeyEvent);
            }
            finish();
        }
        return false;
    }

    protected void onPause() {
        super.onPause();
        CustomTracker.comScorePause(this);
    }

    protected void onResume() {
        super.onResume();
        CustomTracker.comScoreResume(this);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/IcsRecommendActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */