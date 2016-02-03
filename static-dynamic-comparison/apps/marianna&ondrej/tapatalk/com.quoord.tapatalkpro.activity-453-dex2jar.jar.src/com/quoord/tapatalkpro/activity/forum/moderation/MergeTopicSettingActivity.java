package com.quoord.tapatalkpro.activity.forum.moderation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class MergeTopicSettingActivity
        extends FragmentActivity {
    public static final int REQUESTCODE = 0;
    private ActionBar bar;
    private CheckBox checkBox;
    private TextView destinationForum = null;
    private TextView destinationForumTitle = null;
    private TextView destinationTopic = null;
    private TextView destinationTopicTitle = null;
    private TextView divice1;
    private TextView divice2;
    private TextView divice3;
    private TextView divice4;
    private Topic first_topic;
    private String first_topic_id;
    private String forumId;
    private String forumName = null;
    private ForumStatus forumStatus = null;
    private RelativeLayout forum_layout = null;
    private boolean isRedirect = true;
    private Activity mActivity;
    private TextView merge;
    public Topic mergedTopic = null;
    private String newTopicName;
    private TextView redirectTitle = null;
    private TextView redirect_des;
    private RelativeLayout redirect_layout = null;
    private TextView renameTitle;
    private Topic second_topic;
    private String second_topic_id;
    private int select_position = 1;
    private LinearLayout topic_layout = null;
    private TextView topic_name;
    private LinearLayout topic_name_layout = null;

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 0) && (paramIntent != null) && (paramIntent.hasExtra("forumName"))) {
            this.forumName = paramIntent.getStringExtra("forumName");
            this.forumId = paramIntent.getStringExtra("forumId");
            if (this.forumName != null) {
                this.destinationForum.setText(this.forumName);
            }
        }
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setTitle(getResources().getString(2131100752));
        this.bar.setIcon(2130837525);
        this.forumName = getIntent().getStringExtra("forum_name");
        this.first_topic = ((Topic) getIntent().getSerializableExtra("first_topic"));
        this.second_topic = ((Topic) getIntent().getSerializableExtra("second_topic"));
        if (getIntent().hasExtra("forumStatus")) {
            this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        }
        this.forumId = this.first_topic.getForumId();
        setContentView(2130903270);
        this.destinationTopic = ((TextView) findViewById(2131231375));
        this.destinationTopicTitle = ((TextView) findViewById(2131231374));
        this.destinationForum = ((TextView) findViewById(2131231383));
        this.destinationForumTitle = ((TextView) findViewById(2131231382));
        this.topic_layout = ((LinearLayout) findViewById(2131231373));
        this.topic_name_layout = ((LinearLayout) findViewById(2131231385));
        this.redirect_layout = ((RelativeLayout) findViewById(2131231377));
        this.redirect_des = ((TextView) findViewById(2131231378));
        this.redirectTitle = ((TextView) findViewById(2131231281));
        this.renameTitle = ((TextView) findViewById(2131231386));
        this.checkBox = ((CheckBox) findViewById(2131231379));
        this.topic_name = ((TextView) findViewById(2131231387));
        this.divice1 = ((TextView) findViewById(2131231376));
        this.divice2 = ((TextView) findViewById(2131231380));
        this.divice3 = ((TextView) findViewById(2131231384));
        this.divice4 = ((TextView) findViewById(2131231388));
        if (!SettingsFragment.isLightTheme(this.mActivity)) {
            this.divice1.setBackgroundResource(2131165576);
            this.divice2.setBackgroundResource(2131165576);
            this.divice3.setBackgroundResource(2131165576);
            this.divice4.setBackgroundResource(2131165576);
            this.destinationTopic.setTextColor(this.mActivity.getResources().getColor(2131165581));
            this.redirect_des.setTextColor(this.mActivity.getResources().getColor(2131165581));
            this.destinationForum.setTextColor(this.mActivity.getResources().getColor(2131165581));
            this.topic_name.setTextColor(this.mActivity.getResources().getColor(2131165581));
            this.destinationTopicTitle.setTextColor(this.mActivity.getResources().getColor(2131165213));
            this.destinationForumTitle.setTextColor(this.mActivity.getResources().getColor(2131165213));
            this.redirectTitle.setTextColor(this.mActivity.getResources().getColor(2131165213));
            this.renameTitle.setTextColor(this.mActivity.getResources().getColor(2131165213));
        }
        this.destinationTopic.setText(this.second_topic.getTitle());
        this.first_topic_id = this.first_topic.getId();
        this.second_topic_id = this.second_topic.getId();
        if (this.forumStatus.isIP()) {
            if (Integer.parseInt(this.first_topic_id) > Integer.parseInt(this.second_topic_id)) {
                this.mergedTopic = this.second_topic;
                this.newTopicName = this.second_topic.getTitle().toString();
                this.topic_name.setText(this.second_topic.getTitle());
                this.topic_layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        paramAnonymousView = MergeTopicSettingActivity.this.first_topic.getTitle();
                        String str = MergeTopicSettingActivity.this.second_topic.getTitle();
                        AlertDialog.Builder localBuilder = new AlertDialog.Builder(MergeTopicSettingActivity.this.mActivity).setTitle("Destination Topic");
                        int i = MergeTopicSettingActivity.this.select_position;
                        DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                MergeTopicSettingActivity.this.select_position = paramAnonymous2Int;
                            }
                        };
                        localBuilder.setSingleChoiceItems(new String[]{paramAnonymousView, str}, i, local1).setPositiveButton(MergeTopicSettingActivity.this.mActivity.getResources().getString(2131099914), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                if ((MergeTopicSettingActivity.this.forumStatus.isSMF()) || (MergeTopicSettingActivity.this.forumStatus.isSMF1()) || (MergeTopicSettingActivity.this.forumStatus.isSMF2()) || (MergeTopicSettingActivity.this.forumStatus.isIP())) {
                                    if (Integer.parseInt(MergeTopicSettingActivity.this.first_topic_id) > Integer.parseInt(MergeTopicSettingActivity.this.second_topic_id)) {
                                        MergeTopicSettingActivity.this.mergedTopic = MergeTopicSettingActivity.this.second_topic;
                                        return;
                                    }
                                    MergeTopicSettingActivity.this.mergedTopic = MergeTopicSettingActivity.this.first_topic;
                                    return;
                                }
                                if (MergeTopicSettingActivity.this.select_position == 0) {
                                    MergeTopicSettingActivity.this.first_topic_id = MergeTopicSettingActivity.this.second_topic.getId();
                                    MergeTopicSettingActivity.this.second_topic_id = MergeTopicSettingActivity.this.first_topic.getId();
                                    MergeTopicSettingActivity.this.newTopicName = MergeTopicSettingActivity.this.first_topic.getTitle();
                                    MergeTopicSettingActivity.this.topic_name.setText(MergeTopicSettingActivity.this.first_topic.getTitle());
                                    MergeTopicSettingActivity.this.destinationTopic.setText(MergeTopicSettingActivity.this.first_topic.getTitle());
                                    MergeTopicSettingActivity.this.mergedTopic = MergeTopicSettingActivity.this.first_topic;
                                    return;
                                }
                                MergeTopicSettingActivity.this.first_topic_id = MergeTopicSettingActivity.this.first_topic.getId();
                                MergeTopicSettingActivity.this.second_topic_id = MergeTopicSettingActivity.this.second_topic.getId();
                                MergeTopicSettingActivity.this.newTopicName = MergeTopicSettingActivity.this.second_topic.getTitle();
                                MergeTopicSettingActivity.this.destinationTopic.setText(MergeTopicSettingActivity.this.second_topic.getTitle());
                                MergeTopicSettingActivity.this.topic_name.setText(MergeTopicSettingActivity.this.second_topic.getTitle());
                                MergeTopicSettingActivity.this.mergedTopic = MergeTopicSettingActivity.this.second_topic;
                            }
                        }).setNegativeButton(MergeTopicSettingActivity.this.mActivity.getResources().getString(2131099974), null).create().show();
                    }
                });
                this.redirect_layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (MergeTopicSettingActivity.this.checkBox.isChecked()) {
                            MergeTopicSettingActivity.this.isRedirect = false;
                            MergeTopicSettingActivity.this.checkBox.setChecked(false);
                            return;
                        }
                        MergeTopicSettingActivity.this.isRedirect = true;
                        MergeTopicSettingActivity.this.checkBox.setChecked(true);
                    }
                });
                this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                        if (paramAnonymousBoolean) {
                            MergeTopicSettingActivity.this.isRedirect = true;
                            return;
                        }
                        MergeTopicSettingActivity.this.isRedirect = false;
                    }
                });
                if (this.forumStatus.isSupportAdvanceMerge()) {
                    break label1011;
                }
                this.redirect_layout.setVisibility(8);
                this.divice2.setVisibility(8);
                label763:
                this.forum_layout = ((RelativeLayout) findViewById(2131231381));
                if ((!this.forumStatus.isMB()) && (!this.forumStatus.isIP()) && (!this.forumStatus.isSMF()) && (!this.forumStatus.isSMF1()) && (!this.forumStatus.isSMF2()) && (!this.forumStatus.isIP())) {
                    break label1030;
                }
                this.topic_layout.setVisibility(8);
                this.divice1.setVisibility(8);
            }
        }
        for (; ; ) {
            this.forum_layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Intent(MergeTopicSettingActivity.this.mActivity, ModerateActivity.class);
                    paramAnonymousView.putExtra("forumStatus", MergeTopicSettingActivity.this.forumStatus);
                    paramAnonymousView.putExtra("select_forum_action", 6);
                    paramAnonymousView.putExtra("topic", MergeTopicSettingActivity.this.first_topic);
                    MergeTopicSettingActivity.this.mActivity.startActivityForResult(paramAnonymousView, 0);
                }
            });
            this.topic_name_layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View paramAnonymousView) {
                    paramAnonymousView = new EditText(MergeTopicSettingActivity.this.mActivity);
                    paramAnonymousView.setText(MergeTopicSettingActivity.this.newTopicName);
                    new AlertDialog.Builder(MergeTopicSettingActivity.this.mActivity).setTitle("Topic name").setView(paramAnonymousView).setPositiveButton(MergeTopicSettingActivity.this.mActivity.getResources().getString(2131099914), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            MergeTopicSettingActivity.this.newTopicName = paramAnonymousView.getText().toString();
                            MergeTopicSettingActivity.this.topic_name.setText(MergeTopicSettingActivity.this.newTopicName);
                        }
                    }).setNegativeButton(MergeTopicSettingActivity.this.mActivity.getResources().getString(2131099974), null).create().show();
                }
            });
            this.merge = ((TextView) findViewById(2131231389));
            if (this.forumName != null) {
                this.destinationForum.setText(this.forumName);
            }
            this.merge.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("first_topic_id", MergeTopicSettingActivity.this.first_topic_id);
                    paramAnonymousView.putExtra("second_topic_id", MergeTopicSettingActivity.this.second_topic_id);
                    if ((!MergeTopicSettingActivity.this.newTopicName.equals(MergeTopicSettingActivity.this.first_topic.getTitle())) && (!MergeTopicSettingActivity.this.newTopicName.equals(MergeTopicSettingActivity.this.second_topic.getTitle()))) {
                        paramAnonymousView.putExtra("topic_name", MergeTopicSettingActivity.this.newTopicName);
                    }
                    paramAnonymousView.putExtra("isRedirect", MergeTopicSettingActivity.this.isRedirect);
                    paramAnonymousView.putExtra("mergedForumId", MergeTopicSettingActivity.this.forumId);
                    paramAnonymousView.putExtra("mergedTopic", MergeTopicSettingActivity.this.mergedTopic);
                    MergeTopicSettingActivity.this.mActivity.setResult(-1, paramAnonymousView);
                    MergeTopicSettingActivity.this.mActivity.finish();
                }
            });
            return;
            this.mergedTopic = this.first_topic;
            this.newTopicName = this.first_topic.getTitle().toString();
            this.topic_name.setText(this.first_topic.getTitle());
            break;
            this.mergedTopic = this.second_topic;
            this.newTopicName = this.second_topic.getTitle().toString();
            this.topic_name.setText(this.second_topic.getTitle());
            break;
            label1011:
            this.redirect_layout.setVisibility(0);
            this.divice2.setVisibility(0);
            break label763;
            label1030:
            this.topic_layout.setVisibility(0);
            this.divice1.setVisibility(0);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return super.onOptionsItemSelected(paramMenuItem);
            finish();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/moderation/MergeTopicSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */