package com.quoord.tapatalkpro.activity.forum.moderation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.DialogUtil.DialogUtil;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerateAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ModerateActivity
        extends FragmentActivity
        implements ForumActivityStatus {
    public static final int CREATE_NEWTOPIC = 0;
    public static final int MERGE_POST = 5;
    public static final int MERGE_TOPIC = 4;
    public static final int MERGE_TOPIC_TO_FORUM = 6;
    public static final int MOVE_POST = 3;
    public static final int MOVE_TOPIC = 2;
    public static final int SHARE_IMAGE = 1;
    private ForumStatus forumStatus = null;
    public ModerateFragment fragment = null;
    private Activity mActivity = null;
    public Topic mTopic = null;
    private Handler mUIhandler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            if (paramAnonymousMessage.what == 14) {
                if (ModerateActivity.this.fragment.mForumAdapter != null) {
                    ModerateActivity.this.fragment.mForumAdapter.notifyDataSetChanged();
                }
            }
            while (13 != paramAnonymousMessage.what) {
                return;
            }
            try {
                paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                Toast.makeText(ModerateActivity.this.mActivity, ModerateActivity.this.mActivity.getString(2131100071), 1).show();
                ((ForumActivityStatus) ModerateActivity.this.mActivity).closeProgress();
                return;
            } catch (Exception paramAnonymousMessage) {
                ((ForumActivityStatus) ModerateActivity.this.mActivity).closeProgress();
            }
        }
    };
    public PostData postData = null;
    public ArrayList<PostData> postDatas = new ArrayList();
    public String postId = "";
    public int select_forum_action = -1;

    public void closeProgress() {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
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
        return this.forumStatus;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt1 == 1) {
            finish();
        }
        while ((paramInt1 != 601) || (this.fragment.mForumAdapter == null) || (paramIntent == null)) {
            return;
        }
        ((ForumActivityStatus) this.mActivity).showProgress();
        this.fragment.mForumAdapter.newTopicName = paramIntent.getStringExtra("topic_name");
        this.fragment.mForumAdapter.isRedirect = paramIntent.getBooleanExtra("isRedirect", true);
        this.fragment.mForumAdapter.mergedForumId = paramIntent.getStringExtra("mergedForumId");
        this.fragment.mForumAdapter.mergedTopic = ((Topic) paramIntent.getSerializableExtra("mergedTopic"));
        this.fragment.mForumAdapter.mergeTopic(paramIntent.getStringExtra("first_topic_id"), paramIntent.getStringExtra("second_topic_id"));
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        paramBundle = this.mActivity.getIntent();
        if (paramBundle.hasExtra("forumStatus")) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializableExtra("forumStatus"));
        }
        if (paramBundle.hasExtra("topic")) {
            this.mTopic = ((Topic) paramBundle.getSerializableExtra("topic"));
        }
        if (getIntent().hasExtra("select_forum_action")) {
            this.select_forum_action = this.mActivity.getIntent().getIntExtra("select_forum_action", -1);
        }
        if (getIntent().hasExtra("post")) {
            this.postData = ((PostData) getIntent().getSerializableExtra("post"));
        }
        if (getIntent().hasExtra("post_list")) {
            this.postDatas = ((ArrayList) getIntent().getSerializableExtra("post_list"));
        }
        paramBundle = this.mActivity.getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setIcon(2130837525);
        this.fragment = ModerateFragment.newInstance(this.forumStatus, this.mTopic);
        showToFront(this.fragment, true);
    }

    protected Dialog onCreateDialog(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 0:
                localObject = new ProgressDialog(this.mActivity);
                ((ProgressDialog) localObject).setMessage(this.mActivity.getString(2131099870));
                ((ProgressDialog) localObject).setIndeterminate(true);
                ((ProgressDialog) localObject).setCancelable(true);
                ((ProgressDialog) localObject).setOnKeyListener(new DialogInterface.OnKeyListener() {
                    public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
                        if ((paramAnonymousKeyEvent.getKeyCode() == 4) && (ModerateActivity.this.fragment.mForumAdapter != null) && (paramAnonymousKeyEvent.getAction() == 0)) {
                            ModerateActivity.this.fragment.mForumAdapter.setOpCancel(true);
                        }
                        return false;
                    }
                });
                this.fragment.mProgressDlg = ((ProgressDialog) localObject);
                return (Dialog) localObject;
            case 80:
                localObject = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("Moving: \"")).append(this.mTopic.getTitle()).append("\"").toString())).append(" from \"").toString())).append(this.mTopic.getForumName()).append("\" to \"").toString() + this.fragment.mForumAdapter.getTargetForumName() + "\"";
                new AlertDialog.Builder(this.mActivity).setTitle("Move Topic").setMessage((CharSequence) localObject).setPositiveButton(2131099792, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        ((ForumActivityStatus) ModerateActivity.this.mActivity).showProgress();
                        ModerateActivity.this.fragment.mForumAdapter.moveTopic(ModerateActivity.this.mTopic.getId(), ModerateActivity.this.fragment.mForumAdapter.getTargetForumId());
                    }
                }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        ModerateActivity.this.removeDialog(80);
                    }
                }).create();
            case 81:
                if ((this.postDatas != null) && (this.postDatas.size() > 0)) {
                    paramInt = 0;
                    if (paramInt < this.postDatas.size()) {
                    }
                }
                for (; ; ) {
                    localObject = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("Moving Post:")).append(" from \"").toString())).append(this.mTopic.getForumName()).append("\" to \"").toString() + this.fragment.mForumAdapter.getTargetForumName() + "\"";
                    new AlertDialog.Builder(this.mActivity).setTitle("Move Post").setMessage((CharSequence) localObject).setPositiveButton(2131100062, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            paramAnonymousDialogInterface = (LinearLayout) LayoutInflater.from(ModerateActivity.this.mActivity).inflate(2130903274, null);
                            final EditText localEditText = (EditText) paramAnonymousDialogInterface.findViewById(2131231392);
                            localEditText.setSingleLine();
                            localEditText.setText(ModerateActivity.this.mTopic.getTitle());
                            new AlertDialog.Builder(ModerateActivity.this.mActivity).setView(paramAnonymousDialogInterface).setTitle(2131100754).setPositiveButton(2131099792, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                    if (!localEditText.getText().toString().equals("")) {
                                        ((ForumActivityStatus) ModerateActivity.this.mActivity).showProgress();
                                        ModerateActivity.this.fragment.mForumAdapter.movePost(ModerateActivity.this.postId, ModerateActivity.this.fragment.mForumAdapter.getTargetForumId(), localEditText.getText().toString());
                                        ((InputMethodManager) ModerateActivity.this.getSystemService("input_method")).toggleSoftInput(0, 2);
                                        return;
                                    }
                                    Toast.makeText(ModerateActivity.this.mActivity, "new topic title can't empty", 1).show();
                                }
                            }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                    ((ViewGroup) localEditText.getParent()).removeAllViews();
                                }
                            }).create().show();
                        }
                    }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            ModerateActivity.this.removeDialog(81);
                        }
                    }).create();
                    this.postId += ((PostData) this.postDatas.get(paramInt)).getPostId();
                    if (paramInt < this.postDatas.size() - 1) {
                        this.postId += ",";
                    }
                    paramInt += 1;
                    break;
                    this.postId += this.postData.getPostId();
                }
        }
        Object localObject = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("Merge: \"")).append(this.mTopic.getTitle()).append("\"").toString())).append(" from \"").toString())).append(this.mTopic.getForumName()).append("\" to \"").toString() + this.fragment.mForumAdapter.getTargetForumName() + "\"";
        new AlertDialog.Builder(this.mActivity).setTitle("Merge Topic").setMessage((CharSequence) localObject).setPositiveButton(2131099792, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("forumName", ModerateActivity.this.fragment.mForumAdapter.getTargetForumName());
                paramAnonymousDialogInterface.putExtra("forumId", ModerateActivity.this.fragment.mForumAdapter.getTargetForumId());
                ModerateActivity.this.mActivity.setResult(-1, paramAnonymousDialogInterface);
                ModerateActivity.this.mActivity.finish();
            }
        }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                ModerateActivity.this.removeDialog(82);
            }
        }).create();
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && ((this.fragment instanceof ModerateFragment))) {
            if ((this.fragment.mForumAdapter.forumStack.size() > 0) && (!this.fragment.mForumAdapter.forumStack.empty())) {
                this.fragment.mForumAdapter.backToTopLevel();
                this.mActivity.invalidateOptionsMenu();
                return true;
            }
            this.mActivity.finish();
            return true;
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
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

    public void setTargetForum(String paramString) {
        String str;
        if ((paramString != null) && (this.fragment.textView != null)) {
            this.fragment.textView.setEnabled(true);
            this.fragment.textView.setVisibility(0);
            str = paramString;
            if (paramString.length() > 24) {
                str = paramString.substring(0, 24) + "...";
            }
            if ((this.mActivity instanceof ModerateActivity)) {
                if (((ModerateActivity) this.mActivity).select_forum_action != 2) {
                    break label139;
                }
                this.fragment.textView.setText(this.mActivity.getApplicationContext().getString(2131099948) + str);
            }
        }
        label139:
        do {
            return;
            if (((ModerateActivity) this.mActivity).select_forum_action == 3) {
                this.fragment.textView.setText(this.mActivity.getApplicationContext().getString(2131099948) + str);
                return;
            }
            if (((ModerateActivity) this.mActivity).select_forum_action == 4) {
                this.fragment.textView.setText(this.mActivity.getApplicationContext().getString(2131100753) + str);
                return;
            }
            if (((ModerateActivity) this.mActivity).select_forum_action == 6) {
                this.fragment.textView.setText(this.mActivity.getApplicationContext().getString(2131100753) + str);
                return;
            }
            if (((ModerateActivity) this.mActivity).select_forum_action == 5) {
                this.fragment.textView.setText(this.mActivity.getApplicationContext().getString(2131100753) + str);
                return;
            }
        } while (((ModerateActivity) this.mActivity).select_forum_action != 0);
        this.fragment.textView.setText(this.mActivity.getApplicationContext().getString(2131100694) + str);
    }

    public void showProgress() {
        try {
            this.mActivity.showDialog(0);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void showProgress(String paramString) {
    }

    public void showToFront(QuoordFragment paramQuoordFragment, boolean paramBoolean) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.replace(16908290, paramQuoordFragment);
        localFragmentTransaction.commit();
    }

    public void updateDialog(int paramInt) {
        DialogUtil.updateProgressDialog(this.fragment.mProgressDlg, paramInt, this.mActivity);
    }

    public void updateUI(int paramInt, Object paramObject) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = paramInt;
        localMessage.obj = paramObject;
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/moderation/ModerateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */