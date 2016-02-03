package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.quoord.DialogUtil.AccountDialog;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.adapter.forum.UserInfoAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DisplayUserInfoFragment
        extends QuoordFragment
        implements ForumActivityStatus {
    public static final int TOPICLISTPAGE = 2;
    public static final int USERINFOPAGE = 1;
    private ActionBar bar;
    public LinearLayout footlay;
    private ForumStatus forumStatus;
    public boolean isTopic = false;
    private Activity mActivity;
    public int mCurrentPage;
    String mIconUsername = "";
    ProgressDialog mProgressDialog = null;
    public Handler mUIhandler;
    public UploadAdapter mUploadAdapter;
    private ProgressDialog mUploadProgressDialog;
    public UserInfoAdapter mUserAdapter = null;
    private RelativeLayout profile_layout = null;
    public Topic topic;
    public ListView userinfo;
    private View v;

    private static String getHost(String paramString) {
        try {
            String str = new URL(paramString).getHost();
            return str;
        } catch (MalformedURLException localMalformedURLException) {
            localMalformedURLException.printStackTrace();
        }
        return paramString;
    }

    public static DisplayUserInfoFragment newInstance(ForumStatus paramForumStatus, String paramString, RelativeLayout paramRelativeLayout) {
        DisplayUserInfoFragment localDisplayUserInfoFragment = new DisplayUserInfoFragment();
        localDisplayUserInfoFragment.forumStatus = paramForumStatus;
        localDisplayUserInfoFragment.mIconUsername = paramString;
        localDisplayUserInfoFragment.profile_layout = paramRelativeLayout;
        return localDisplayUserInfoFragment;
    }

    public void closeProgress() {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
    }

    public String getActivityID() {
        return getHost(this.forumStatus.getUrl()) + "." + this.forumStatus.tapatalkForum.getUserName();
    }

    public Activity getDefaultActivity() {
        return getActivity();
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

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayShowHomeEnabled(true);
        this.bar.setTitle(this.mIconUsername);
        this.footlay = ButtomProgress.get(this.mActivity);
        this.mUploadAdapter = new UploadAdapter(this.mActivity);
        this.mUIhandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                if (13 == paramAnonymousMessage.what) {
                    paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                    DisplayUserInfoFragment.this.closeProgress();
                    Toast.makeText(DisplayUserInfoFragment.this.mActivity, DisplayUserInfoFragment.this.mActivity.getString(2131100071), 1).show();
                }
                for (; ; ) {
                    return;
                    int i;
                    if (31 == paramAnonymousMessage.what) {
                        if (DisplayUserInfoFragment.this.mProgressDialog != null) {
                            i = ((Integer) paramAnonymousMessage.obj).intValue();
                            paramAnonymousMessage = "";
                            if (i == 0) {
                                paramAnonymousMessage = DisplayUserInfoFragment.this.getString(2131099870);
                            }
                            for (; ; ) {
                                DisplayUserInfoFragment.this.mProgressDialog.setMessage(paramAnonymousMessage);
                                return;
                                if (i == 1) {
                                    paramAnonymousMessage = DisplayUserInfoFragment.this.getString(2131099871);
                                } else if (i == 2) {
                                    paramAnonymousMessage = DisplayUserInfoFragment.this.getString(2131099872);
                                } else if (i == 3) {
                                    paramAnonymousMessage = DisplayUserInfoFragment.this.getString(2131099873);
                                } else if (i == 4) {
                                    paramAnonymousMessage = DisplayUserInfoFragment.this.getString(2131099874);
                                }
                            }
                        }
                    } else if (37 == paramAnonymousMessage.what) {
                        try {
                            i = ((Integer) paramAnonymousMessage.obj).intValue();
                            DisplayUserInfoFragment.this.mUploadProgressDialog.setMax(DisplayUserInfoFragment.this.mUploadAdapter.realSize);
                            DisplayUserInfoFragment.this.mUploadProgressDialog.setProgress(i);
                            if (i == DisplayUserInfoFragment.this.mUploadAdapter.realSize) {
                                DisplayUserInfoFragment.this.mUploadProgressDialog.setTitle(DisplayUserInfoFragment.this.mActivity.getString(2131100202));
                                return;
                            }
                        } catch (Exception paramAnonymousMessage) {
                            paramAnonymousMessage.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.v = paramLayoutInflater.inflate(2130903426, paramViewGroup, false);
        this.userinfo = ((ListView) this.v.findViewById(2131231720));
        this.userinfo.setDivider(null);
        this.userinfo.setSelector(2131165212);
        ThemeUtil.setListViewStyle(this.userinfo, this.mActivity);
        this.mCurrentPage = 1;
        return this.v;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.forumStatus != null) {
            this.mUserAdapter = new UserInfoAdapter(this.mActivity, this.forumStatus.getUrl(), this.mIconUsername, this.forumStatus.tapatalkForum.isSupportConve(), this.profile_layout);
            this.userinfo.addFooterView(this.footlay);
            this.userinfo.setAdapter(this.mUserAdapter);
            showProgress();
        }
    }

    public void removeListFootLay() {
        if (this.userinfo.getFooterViewsCount() > 0) {
            this.userinfo.removeFooterView(this.footlay);
        }
    }

    public void setCurrentPage(int paramInt) {
        this.mCurrentPage = paramInt;
    }

    public void showDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 0:
                new DialogFragment() {
                    public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                        new AlertDialog.Builder(getActivity()).setMessage(DisplayUserInfoFragment.this.mActivity.getString(2131099870)).setPositiveButton(DisplayUserInfoFragment.this.mActivity.getString(2131099792), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            }
                        }).setNegativeButton(DisplayUserInfoFragment.this.mActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                            }
                        }).create();
                    }
                }.show(getFragmentManager(), "dailog");
                return;
            case 42:
                this.mUploadProgressDialog = new ProgressDialog(this.mActivity);
                this.mUploadProgressDialog.setIcon(17301633);
                this.mUploadProgressDialog.setTitle(this.mActivity.getString(2131100203));
                this.mUploadProgressDialog.setProgressStyle(1);
                return;
        }
        AccountDialog.showUnreadDialog(this.mActivity, this.topic, this.forumStatus);
    }

    public void showProgress() {
        this.mActivity.showDialog(0);
    }

    public void showProgress(String paramString) {
    }

    public void updateDialog(int paramInt) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = 31;
        localMessage.obj = new Integer(paramInt);
        this.mUIhandler.sendMessage(localMessage);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/DisplayUserInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */