package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction;
import com.quoord.tapatalkpro.action.ForumLoginOrSignAction.ActionCallBack;
import com.quoord.tapatalkpro.action.PMAction;
import com.quoord.tapatalkpro.adapter.forum.PMContentAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.InviteUserBar;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;
import java.util.HashMap;

public class PmContentFragment
        extends QuoordFragment
        implements ForumActivityStatus, TwoPanelController {
    private ActionBar bar = null;
    private ForumStatus forumStatus;
    private boolean fromIntent = true;
    private boolean isclick = false;
    public Activity mActivity;
    private PMContentAdapter mAdapter;
    private View mInivteUserBar = null;
    private PrivateMessage mPM;
    private String pmId;
    private View pmView;
    ProgressDialog progressDialog;
    private String spkey;

    public PmContentFragment() {
    }

    public PmContentFragment(boolean paramBoolean, HashMap paramHashMap) {
        this.fromIntent = paramBoolean;
        if (paramHashMap.containsKey("forumStatus")) {
            this.forumStatus = ((ForumStatus) paramHashMap.get("forumStatus"));
        }
        if (paramHashMap.containsKey("pm")) {
            this.mPM = ((PrivateMessage) paramHashMap.get("pm"));
        }
        if (paramHashMap.containsKey("pmid")) {
            this.pmId = ((String) paramHashMap.get("pmid"));
        }
        if (paramHashMap.containsKey("spkey")) {
            this.spkey = ((String) paramHashMap.get("spkey"));
        }
    }

    public void closeProgress() {
        if ((this.progressDialog != null) && (this.progressDialog.isShowing())) {
            new Handler().post(new Runnable() {
                public void run() {
                    PmContentFragment.this.progressDialog.cancel();
                }
            });
        }
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public Activity getDefaultActivity() {
        return this.mActivity;
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

    public void initInviteBar(ArrayList<HashMap<String, String>> paramArrayList) {
        InviteUserBar localInviteUserBar = new InviteUserBar();
        localInviteUserBar.setActivity(this.mActivity);
        localInviteUserBar.setForumStatus(this.forumStatus);
        localInviteUserBar.setUserInfo(paramArrayList);
        localInviteUserBar.setInviteBarView(this.mInivteUserBar);
        localInviteUserBar.process();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setDisplayShowTitleEnabled(false);
        Intent localIntent = this.mActivity.getIntent();
        if (this.fromIntent) {
            this.forumStatus = ((ForumStatus) localIntent.getSerializableExtra("forumStatus"));
            this.mPM = ((PrivateMessage) localIntent.getSerializableExtra("pm"));
            this.spkey = localIntent.getStringExtra("spkey");
        }
        if (paramBundle != null) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
            this.mPM = ((PrivateMessage) paramBundle.getSerializable("pm"));
            this.pmId = paramBundle.getString("pmid");
            this.spkey = paramBundle.getString("spkey");
        }
        if (this.mPM == null) {
            this.mPM = new PrivateMessage();
            this.mPM.setMsgid(this.pmId);
        }
        this.mAdapter = new PMContentAdapter(this, this.pmView, this.forumStatus.getUrl(), this.mPM);
        paramBundle = this.mActivity.getSharedPreferences("notification", 0).edit();
        paramBundle.remove(this.spkey);
        paramBundle.commit();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.mActivity = getActivity();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.pmView = paramLayoutInflater.inflate(2130903315, paramViewGroup, false);
        this.mInivteUserBar = this.pmView.findViewById(2131231501);
        return this.pmView;
    }

    public void onDestroy() {
        if (this.mAdapter != null) {
            this.mAdapter.destory();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        boolean bool2 = true;
        boolean bool1 = bool2;
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            bool1 = super.onOptionsItemSelected(paramMenuItem);
            do {
                return bool1;
                this.mAdapter.getCurPm().actionFwdPm(this, this.forumStatus, this.mAdapter);
                return true;
                bool1 = bool2;
            } while (this.isclick);
            this.mAdapter.getCurPm().actionReplyPm(this, this.forumStatus, this.mAdapter);
            this.isclick = true;
            return true;
            this.mAdapter.getCurPm().actionReplyAll(this, this.forumStatus, this.mAdapter);
            return true;
            this.mAdapter.refresh();
            return true;
            this.mAdapter.getCurPm().actionReplay(this, this.forumStatus, this.mAdapter);
            continue;
            showDialog(20);
            return true;
            this.mPM.setMsgState(1);
            new PMAction(this.mActivity, this.forumStatus).markMessageUnread(this.mPM);
            if ((this.mActivity instanceof SlidingMenuActivity)) {
                ((SlidingMenuActivity) this.mActivity).removeDetail(this);
            }
            if ((this.mActivity instanceof PMContentActivity)) {
                this.mActivity.finish();
            }
        }
    }

    public void onPause() {
        super.onPause();
        CustomTracker.comScorePause(getActivity());
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (this.mAdapter != null) {
            MenuItem localMenuItem;
            if ((this.mAdapter.getCurPm().isInbox()) && (!getResources().getBoolean(2131558402)) && (this.forumStatus.isReportPm())) {
                localMenuItem = paramMenu.add(0, 19, 0, getActivity().getString(2131099803));
                localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("pm_report_icon", getActivity()));
                localMenuItem.setShowAsAction(2);
            }
            if ((this.mPM != null) && (this.mPM.getMsgState() != 1) && (this.forumStatus.isMarkPmUnread())) {
                paramMenu.add(0, 27, 0, getString(2131099818)).setIcon(ThemeUtil.getMenuIconByPicName("bubble_mark_unread", getActivity())).setShowAsAction(0);
            }
            if (this.forumStatus.isCanSendPm()) {
                localMenuItem = paramMenu.add(0, 11, 0, getActivity().getString(2131099797));
                localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("bubble_reply", getActivity()));
                localMenuItem.setShowAsAction(2);
                if (this.mAdapter.getCurPm().getMsgTo().size() > 1) {
                    paramMenu.add(0, 18, 1, getActivity().getString(2131099798)).setShowAsAction(0);
                }
                paramMenu.add(0, 23, 1, getActivity().getString(2131099800)).setShowAsAction(0);
                paramMenu.add(0, 47, 1, getActivity().getString(2131099801)).setShowAsAction(0);
            }
        }
        super.onPrepareOptionsMenu(paramMenu);
    }

    public void onResume() {
        super.onResume();
        CustomTracker.comScoreResume(getActivity());
        this.isclick = false;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putSerializable("pm", this.mPM);
        paramBundle.putString("pmid", this.pmId);
        paramBundle.putString("spkey", this.spkey);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(getActivity());
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(getActivity());
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        this.bar.setTitle("");
        this.bar.setNavigationMode(0);
    }

    public void showDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 20:
                localObject3 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(2130903343, null);
                final EditText localEditText = (EditText) ((LinearLayout) localObject3).getChildAt(0);
                final String str1 = this.mPM.getMsgId();
                localObject2 = this.mActivity.getString(2131099956);
                String str2 = SettingsFragment.getSingature(this.mActivity, this.forumStatus.getSigType(), this.forumStatus);
                localObject1 = localObject2;
                if (str2 != null) {
                    localObject1 = localObject2;
                    if (str2.length() > 0) {
                        localObject1 = localObject2 + "\n\n" + str2 + "\n\n";
                    }
                }
                localEditText.setText((CharSequence) localObject1);
                new DialogFragment() {
                    public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                        new AlertDialog.Builder(PmContentFragment.this.mActivity).setTitle(PmContentFragment.this.mActivity.getString(2131099955)).setView(localObject3).setCancelable(false).setPositiveButton(PmContentFragment.this.mActivity.getString(2131099972), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                                paramAnonymous2DialogInterface = new ArrayList();
                                paramAnonymous2DialogInterface.add(this.val$pm_id);
                                String str = this.val$mReason.getText().toString();
                                if ((str != null) && (!str.equals(""))) {
                                    paramAnonymous2DialogInterface.add(str.getBytes());
                                    PmContentFragment.this.mAdapter.report_pm(paramAnonymous2DialogInterface);
                                    Toast.makeText(PmContentFragment.this.mActivity, PmContentFragment.this.mActivity.getString(2131099957), 1).show();
                                    return;
                                }
                                Toast.makeText(PmContentFragment.this.mActivity, PmContentFragment.this.mActivity.getString(2131099958), 1).show();
                            }
                        }).setNegativeButton(PmContentFragment.this.mActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            }
                        }).create();
                    }
                }.show(this.mActivity.getFragmentManager(), "dailog");
        }
        Object localObject1 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(2130903388, null);
        final Object localObject2 = (EditText) ((LinearLayout) localObject1).getChildAt(1);
        final Object localObject3 = (EditText) ((LinearLayout) localObject1).getChildAt(3);
        new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getString(2131100013)).setView((View) localObject1).setCancelable(false).setPositiveButton(this.mActivity.getString(2131100013), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                PmContentFragment.this.forumStatus.tapatalkForum.setUserName(localObject2.getText().toString());
                PmContentFragment.this.forumStatus.tapatalkForum.setPassword(localObject3.getText().toString());
                if (PmContentFragment.this.forumStatus.tapatalkForum.getUserName().length() <= 0) {
                    Toast.makeText(PmContentFragment.this.mActivity, PmContentFragment.this.mActivity.getString(2131099814), 1).show();
                    PmContentFragment.this.forumStatus.tapatalkForum.setUserName("");
                    PmContentFragment.this.forumStatus.tapatalkForum.setPassword("");
                    return;
                }
                new ForumLoginOrSignAction(PmContentFragment.this.mActivity, PmContentFragment.this.forumStatus).loginForum(PmContentFragment.this.forumStatus.tapatalkForum.getUserNameOrDisplayName(), PmContentFragment.this.forumStatus.tapatalkForum.getPassword(), false, false, false, new ForumLoginOrSignAction.ActionCallBack() {
                    public void actionErrorBack(String paramAnonymous2String1, String paramAnonymous2String2) {
                        PmContentFragment.this.closeProgress();
                    }

                    public void actionSuccessBack(ForumStatus paramAnonymous2ForumStatus) {
                        PmContentFragment.this.closeProgress();
                    }
                });
                PmContentFragment.this.showProgress();
            }
        }).setNegativeButton(this.mActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public void showProgress() {
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(this.mActivity);
            this.progressDialog.setMessage(getString(2131099870));
            this.progressDialog.setIndeterminate(true);
            this.progressDialog.setCancelable(true);
        }
        if (!this.progressDialog.isShowing()) {
            new Handler().post(new Runnable() {
                public void run() {
                    PmContentFragment.this.progressDialog.show();
                }
            });
        }
    }

    public void showProgress(String paramString) {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception paramString) {
        }
    }

    public void updateDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/PmContentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */