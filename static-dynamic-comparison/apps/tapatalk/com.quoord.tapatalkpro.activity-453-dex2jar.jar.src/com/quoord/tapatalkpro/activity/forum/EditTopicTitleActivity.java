package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.CreateTopicActionbarAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.dev.DebugModeUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.HashMap;

public class EditTopicTitleActivity
        extends Activity
        implements TryTwiceCallBackInterface {
    private static final int TAG_MENU_SUBMIT = 0;
    private ForumStatus forumStatus = null;
    private CreateTopicActionbarAdapter mActionbarAdapter = null;
    private EditTopicTitleActivity mActivity = null;
    private int mCurrentPrefixIndex = -1;
    private View mMainLayout = null;
    public int mPostStartTime = 0;
    private ArrayList<HashMap<String, String>> mPrefixes = null;
    private EditText mSubjectView = null;
    private Topic mTopic = null;

    private void initPrefix() {
        if ((this.mPrefixes == null) || (this.mPrefixes.size() == 0)) {
        }
        while (!this.forumStatus.getCanEditPrefix()) {
            return;
        }
        Object localObject = getString(2131100273);
        this.mActionbarAdapter = new CreateTopicActionbarAdapter(this.mActivity, this.mPrefixes, (String) localObject);
        localObject = this.mActivity.getActionBar();
        ((ActionBar) localObject).setDisplayShowTitleEnabled(false);
        ((ActionBar) localObject).setNavigationMode(1);
        ((ActionBar) localObject).setListNavigationCallbacks(this.mActionbarAdapter, new ActionBar.OnNavigationListener() {
            public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                EditTopicTitleActivity.this.mCurrentPrefixIndex = paramAnonymousInt;
                EditTopicTitleActivity.this.mActivity.invalidateOptionsMenu();
                return true;
            }
        });
        ((ActionBar) localObject).setSelectedNavigationItem(this.mCurrentPrefixIndex);
    }

    private void initView() {
        setContentView(2130903289);
        this.mMainLayout = findViewById(2131231432);
        this.mSubjectView = ((EditText) findViewById(2131231425));
        this.mSubjectView.setText(this.mTopic.getTitle());
        this.mSubjectView.requestFocus();
        ActionBar localActionBar = getActionBar();
        localActionBar.setDisplayHomeAsUpEnabled(true);
        localActionBar.setTitle(getString(2131100273));
        localActionBar.setIcon(2130837525);
        findViewById(2131231433).setVisibility(8);
        findViewById(2131231434).setVisibility(0);
        findViewById(2131231426).setVisibility(8);
        findViewById(2131231435).setVisibility(8);
        findViewById(2131231407).setVisibility(8);
        findViewById(2131231427).setVisibility(8);
        findViewById(2131231420).setVisibility(8);
        findViewById(2131231437).setVisibility(8);
        findViewById(2131231438).setVisibility(8);
        findViewById(2131230773).setVisibility(8);
        findViewById(2131231428).setVisibility(8);
    }

    private void submit() {
        String str = this.mSubjectView.getText().toString();
        if (str.equals("")) {
            Toast.makeText(this.mActivity, getString(2131099781), 1).show();
            this.mSubjectView.requestFocus();
            return;
        }
        this.mTopic.setTitle(str);
        TapatalkEngine localTapatalkEngine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.mTopic.getId());
        localArrayList.add(str.getBytes());
        if ((this.forumStatus.getCanEditPrefix()) && (this.mPrefixes != null) && (this.mPrefixes.size() > 0)) {
            localArrayList.add(((HashMap) this.mPrefixes.get(this.mCurrentPrefixIndex)).get("prefix_id"));
        }
        localTapatalkEngine.call("m_rename_topic", localArrayList);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.isSuccess()) {
            Toast.makeText(this.mActivity, getString(2131100274), 0).show();
            finish();
            return;
        }
        Toast.makeText(this.mActivity, paramEngineResponse.getErrorMessage(), 0).show();
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        paramConfiguration = (LinearLayout.LayoutParams) this.mMainLayout.getLayoutParams();
        paramConfiguration.setMargins((int) getResources().getDimension(2131427375), 0, (int) getResources().getDimension(2131427375), 0);
        this.mMainLayout.setLayoutParams(paramConfiguration);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        DebugModeUtil.opCrashEmial(this);
        this.mActivity = this;
        this.mPostStartTime = ((int) System.currentTimeMillis());
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        GoogleAnalyticsTools.trackPageView(this, "thread/write", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        if (getIntent().hasExtra("prefixes")) {
            this.mPrefixes = ((ArrayList) getIntent().getSerializableExtra("prefixes"));
        }
        if (getIntent().hasExtra("prefixIndex")) {
            this.mCurrentPrefixIndex = getIntent().getIntExtra("prefixIndex", 0);
        }
        if (getIntent().hasExtra("topic")) {
            paramBundle = getIntent().getSerializableExtra("topic");
            if ((paramBundle instanceof Topic)) {
                this.mTopic = ((Topic) paramBundle);
            }
        }
        initView();
        initPrefix();
        getActionBar().setIcon(2130837525);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return false;
            case 16908332:
                Util.hideSoftKeyb(this.mActivity, getCurrentFocus());
                setResult(-1);
                this.mActivity.finish();
                return true;
        }
        Util.hideSoftKeyb(this.mActivity, getCurrentFocus());
        submit();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        paramMenu = paramMenu.add(0, 0, 0, "");
        paramMenu.setTitle(getString(2131099972));
        paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("menu_send_title", this));
        paramMenu.setShowAsAction(6);
        return true;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/EditTopicTitleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */