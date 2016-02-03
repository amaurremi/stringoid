package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.DialogUtil.UploadDialog;
import com.quoord.tapatalkpro.action.UnBanUserAction;
import com.quoord.tapatalkpro.action.UnBanUserAction.unBanUserCallback;
import com.quoord.tapatalkpro.action.UserInfoAction;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.NewPostAdapter;
import com.quoord.tapatalkpro.adapter.forum.ProfilesAdapter;
import com.quoord.tapatalkpro.adapter.forum.ProfilesPageAdapter;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.UploadImageInfo;
import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.callbackhandle.AbsCallBackHandler;
import com.quoord.tapatalkpro.callbackhandle.CallBackFactory;
import com.quoord.tapatalkpro.callbackhandle.HandlerState;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkEmailActivity;
import com.quoord.tapatalkpro.ui.InviteUserBar;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.BroadcastControl;
import com.quoord.tapatalkpro.util.ExifUtil;
import com.quoord.tapatalkpro.util.GeoPictureUploader;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.UploadAttachmentTool;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.uploadanddownload.UploadImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfilesOuterFragment
        extends QuoordFragment
        implements TwoPanelController, ForumActivityStatus, TryTwiceCallBackInterface {
    public static final int CHANGEPASSWORD = 0;
    public static final int RESETPASSWORD = 2;
    public static final int UPDATEEMAIL = 1;
    private int au_id = 0;
    private ActionBar bar;
    private BroadcastControl broadcastControl;
    private String email = null;
    TapatalkEngine engine;
    public ForumStatus forumStatus;
    private boolean isBan = false;
    public Activity mActivity;
    NewPostAdapter mAdapter;
    public String mIconUsername;
    private View mInviteUserBar = null;
    public ProfilesPageAdapter mPagerAdapter;
    private TabHost mTabHost;
    public UploadAdapter mUploadAdapter;
    private ViewPager mViewPager;
    private Uri photoUri;
    ProgressDialog progress;
    private String token = null;
    public User user;
    public String userId;
    private String userName;

    private void initInviteBar() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("userid", this.userId);
        localHashMap.put("username", this.mIconUsername);
        InviteUserBar localInviteUserBar = new InviteUserBar();
        localInviteUserBar.setActivity(this.mActivity);
        localInviteUserBar.setForumStatus(this.forumStatus);
        localInviteUserBar.setUserInfo(localHashMap);
        localInviteUserBar.setInviteBarView(this.mInviteUserBar);
        localInviteUserBar.process();
    }

    public static ProfilesOuterFragment newInstance(String paramString1, String paramString2, ForumStatus paramForumStatus) {
        ProfilesOuterFragment localProfilesOuterFragment = new ProfilesOuterFragment();
        localProfilesOuterFragment.mIconUsername = paramString1;
        localProfilesOuterFragment.userId = paramString2;
        localProfilesOuterFragment.forumStatus = paramForumStatus;
        return localProfilesOuterFragment;
    }

    private void showResetPasswordDialogStep2() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903236, null);
        TextView localTextView1 = (TextView) localLinearLayout.findViewById(2131230900);
        final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230982);
        localEditText.requestFocus();
        localEditText.setInputType(144);
        TextView localTextView2 = (TextView) localLinearLayout.findViewById(2131231299);
        localTextView1.setText(this.mActivity.getString(2131100520));
        localTextView2.setTypeface(Typeface.createFromAsset(this.mActivity.getAssets(), "font/Roboto_Condensed.ttf"));
        localTextView2.setText(this.mActivity.getString(2131100527));
        localBuilder.setView(localLinearLayout);
        localBuilder.setPositiveButton(this.mActivity.getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                Util.hideSoftKeyb(ProfilesOuterFragment.this.mActivity, localEditText);
                if (Util.checkEditText(localEditText)) {
                    paramAnonymousDialogInterface = localEditText.getText().toString().trim();
                    if ((!paramAnonymousDialogInterface.equals("")) && (paramAnonymousDialogInterface != null)) {
                        ArrayList localArrayList = new ArrayList();
                        localArrayList.add(paramAnonymousDialogInterface.getBytes());
                        localArrayList.add(ProfilesOuterFragment.this.token);
                        localArrayList.add(Util.getMD5(ProfilesOuterFragment.this.forumStatus.getForumId() + "|" + ProfilesOuterFragment.this.au_id + "|" + ProfilesOuterFragment.this.email));
                        ProfilesOuterFragment.this.engine.call("update_password", localArrayList);
                        ProfilesOuterFragment.this.getForumActivityStatus().showProgress();
                    }
                    return;
                }
                ProfilesOuterFragment.this.showResetPasswordDialogStep2();
            }
        });
        localBuilder.create().show();
    }

    public String attachImage2() {
        return new GeoPictureUploader(this.forumStatus.getForumId(), Util.getMD5(Util.getMacAddress(this.mActivity)), (ForumActivityStatus) this.mActivity).uploadPicture(this.mUploadAdapter, this.forumStatus.tapatalkForum.getUserName(), this.forumStatus.getUserId(), Util.getMD5(Util.getMacAddress(this.mActivity)), this.forumStatus.getForumId());
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject = paramEngineResponse.getMethod();
        localObject = new CallBackFactory().createCallBackHandler((String) localObject);
        paramEngineResponse = ((AbsCallBackHandler) localObject).handleCallback(paramEngineResponse, getForumActivityStatus());
        if ("forget_password".equals(((AbsCallBackHandler) localObject).getMethodName())) {
            if (paramEngineResponse == HandlerState.state_FALSEHANDLED) {
                showResetPasswordDialog();
            }
        }
        while ((!"update_password".equals(((AbsCallBackHandler) localObject).getMethodName())) || (paramEngineResponse != HandlerState.state_FALSEHANDLED)) {
            do {
                do {
                    return;
                } while (paramEngineResponse != HandlerState.state_NEEDNEXTSTEP);
                paramEngineResponse = Prefs.get(this.mActivity).getString("email", null);
            }
            while ((paramEngineResponse == null) || (this.forumStatus == null) || (!this.forumStatus.isTapatalkSignIn(this.mActivity)) || (!this.forumStatus.getRegister_email().equals(paramEngineResponse)) || (this.userName == null) || (!this.userName.equals(this.forumStatus.tapatalkForum.getUserNameOrDisplayName())));
            showResetPasswordDialogStep2();
            return;
        }
        showResetPasswordDialogStep2();
    }

    public void closeProgress() {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
    }

    public void getActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 1000) && (paramInt2 == -1)) {
            this.photoUri = paramIntent.getData();
            uploadToTk();
        }
        if (paramInt1 == 1001) {
            if (paramInt2 == -1) {
                paramIntent = new File(UploadImage.SD_CARD_TEMP_DIR);
                paramInt1 = (int) paramIntent.length();
            }
        }
        do {
            do {
                do {
                    try {
                        this.photoUri = Uri.parse(MediaStore.Images.Media.insertImage(this.mActivity.getContentResolver(), paramIntent.getAbsolutePath(), null, null));
                        uploadToTk();
                        return;
                    } catch (FileNotFoundException paramIntent) {
                        for (; ; ) {
                            paramIntent.printStackTrace();
                        }
                    }
                    if (paramInt1 != 7) {
                        break;
                    }
                } while ((paramIntent == null) || (paramIntent.getExtras() == null));
                paramIntent = paramIntent.getExtras();
                this.mUploadAdapter = new UploadAdapter(this.mActivity, this.forumStatus.getMaxJpgSize());
                this.mUploadAdapter.setUri((Uri) paramIntent.getParcelable("uri"), 0);
            }
            while ((this.mPagerAdapter == null) || (this.mPagerAdapter.profilesFragment == null) || (this.mPagerAdapter.profilesFragment.profilesAdapter == null) || (this.mPagerAdapter.profilesFragment.profilesAdapter.userAction == null) || (this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.mUploadDialog == null));
            this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.mUploadDialog.uploadAvatar(this.mUploadAdapter);
            this.mPagerAdapter.profilesFragment.profilesAdapter.refresh();
            return;
        } while (paramInt1 != 500);
        if (paramIntent != null) {
            this.isBan = paramIntent.getBooleanExtra("isBan", false);
        }
        this.mActivity.invalidateOptionsMenu();
    }

    public BaseAdapter getAdapter() {
        return null;
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

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        registBroad();
        if (paramBundle != null) {
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumStatus"));
            this.userId = paramBundle.getString("userId");
            this.mIconUsername = paramBundle.getString("mIconUsername");
        }
        if (((this.mIconUsername == null) || (this.mIconUsername.equals(""))) && (this.forumStatus != null) && (this.forumStatus.tapatalkForum != null)) {
            this.mIconUsername = this.forumStatus.tapatalkForum.getUserName();
        }
        if (this.mTabHost != null) {
            this.mTabHost.setup();
            this.mTabHost.getTabWidget().setDividerDrawable(null);
        }
        this.bar = getActivity().getActionBar();
        setActionBar();
        if ((this.mViewPager != null) && (this.mTabHost != null)) {
            this.mViewPager.setOffscreenPageLimit(2);
            this.mPagerAdapter = new ProfilesPageAdapter(getActivity(), this.mTabHost, this.mViewPager, this.mIconUsername, this.userId);
            this.mPagerAdapter.notifyDataSetChanged();
        }
        String str1 = getActivity().getResources().getString(2131100561);
        String str2 = getActivity().getResources().getString(2131100506);
        String str3 = getActivity().getResources().getString(2131100507);
        this.mPagerAdapter.addTab(this.mTabHost.newTabSpec(str1).setIndicator(str1), this.mPagerAdapter.profilesFragment, null);
        this.mPagerAdapter.startPostFragment = StartPostFragment.newInstance();
        this.mPagerAdapter.addTab(this.mTabHost.newTabSpec(str2).setIndicator(str2), this.mPagerAdapter.startPostFragment, null);
        this.mPagerAdapter.addTab(this.mTabHost.newTabSpec(str3).setIndicator(str3), RepliesFragment.newInstance(), null);
        if (this.mTabHost != null) {
            if (paramBundle != null) {
                this.mTabHost.setCurrentTabByTag(paramBundle.getString("tab"));
            }
            this.mTabHost.setCurrentTab(0);
        }
        this.mActivity.invalidateOptionsMenu();
        if (this.forumStatus != null) {
            this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
        }
        initInviteBar();
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        getActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903325, null);
        this.mViewPager = ((ViewPager) paramLayoutInflater.findViewById(2131231008));
        this.mTabHost = ((TabHost) paramLayoutInflater.findViewById(16908306));
        this.mInviteUserBar = paramLayoutInflater.findViewById(2131231540);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        this.broadcastControl.unregistBroad();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 54:
                paramMenuItem = new Intent(getActivity(), BanUserActivity.class);
                paramMenuItem.putExtra("username", this.mPagerAdapter.profilesFragment.username);
                paramMenuItem.putExtra("forumStatus", this.forumStatus);
                paramMenuItem.putExtra("isBan", this.isBan);
                getActivity().startActivityForResult(paramMenuItem, 500);
                return true;
            case 1060:
                if (this.forumStatus.tapatalkForum.isSupportConve()) {
                    paramMenuItem = new Intent(getActivity(), CreateOrReplyConversationActivity.class);
                    paramMenuItem.putExtra("is_newConversation", true);
                    paramMenuItem.putExtra("conversationName", this.mPagerAdapter.profilesFragment.username);
                    paramMenuItem.putExtra("forumStatus", this.forumStatus);
                    paramMenuItem.putExtra("can_upload", ((ProfilesActivity) getActivity()).can_upload);
                    getActivity().startActivity(paramMenuItem);
                }
                for (; ; ) {
                    return true;
                    paramMenuItem = new Intent(getActivity(), CreatePmActivity.class);
                    paramMenuItem.putExtra("forumStatus", this.forumStatus);
                    paramMenuItem.putExtra("pmto", this.mPagerAdapter.profilesFragment.username);
                    getActivity().startActivity(paramMenuItem);
                }
            case 0:
                paramMenuItem = new Intent(getActivity(), TapatalkEmailActivity.class);
                paramMenuItem.putExtra("forumStatus", this.forumStatus);
                paramMenuItem.putExtra("update", false);
                getActivity().startActivity(paramMenuItem);
                return true;
            case 1:
                paramMenuItem = new Intent(getActivity(), TapatalkEmailActivity.class);
                paramMenuItem.putExtra("forumStatus", this.forumStatus);
                paramMenuItem.putExtra("update", true);
                getActivity().startActivity(paramMenuItem);
                return true;
            case 2:
                showResetPasswordDialog();
                return true;
        }
        new AlertDialog.Builder(getActivity()).setTitle(getActivity().getResources().getString(2131100825)).setMessage(getActivity().getResources().getString(2131100826)).setPositiveButton(getActivity().getResources().getString(2131100824), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                ProfilesOuterFragment.this.showProgress();
                new UnBanUserAction(ProfilesOuterFragment.this.getActivity(), ProfilesOuterFragment.this.forumStatus, ProfilesOuterFragment.this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.user.getId()).unBanUsre(new UnBanUserAction.unBanUserCallback() {
                    public void callback(boolean paramAnonymous2Boolean) {
                        boolean bool2 = false;
                        ProfilesOuterFragment.this.closeProgress();
                        Object localObject = ProfilesOuterFragment.this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.user;
                        boolean bool1;
                        if (paramAnonymous2Boolean) {
                            bool1 = false;
                            ((User) localObject).setBan(bool1);
                            localObject = ProfilesOuterFragment.this;
                            if (!paramAnonymous2Boolean) {
                                break label88;
                            }
                        }
                        label88:
                        for (paramAnonymous2Boolean = bool2; ; paramAnonymous2Boolean = true) {
                            ((ProfilesOuterFragment) localObject).isBan = paramAnonymous2Boolean;
                            ProfilesOuterFragment.this.getActivity().invalidateOptionsMenu();
                            return;
                            bool1 = true;
                            break;
                        }
                    }
                });
            }
        }).setNegativeButton(getActivity().getResources().getString(2131099974), null).create().show();
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
        }
        label527:
        label583:
        for (; ; ) {
            return;
            Object localObject;
            if ((this.mPagerAdapter != null) && (this.mPagerAdapter.profilesFragment != null) && (this.mPagerAdapter.profilesFragment.profilesAdapter != null) && (this.mPagerAdapter.profilesFragment.profilesAdapter.userAction != null) && (this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.user != null) && (this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.user.isCanBan()) && (!this.mPagerAdapter.profilesFragment.username.equalsIgnoreCase(this.forumStatus.getUser()))) {
                if ((this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.user.isBan()) || (this.isBan)) {
                    break label527;
                }
                localObject = paramMenu.add(0, 54, 0, getActivity().getString(2131100057));
                ((MenuItem) localObject).setIcon(ThemeUtil.getMenuIconByPicName("bubble_ban", getActivity()));
                ((MenuItem) localObject).setShowAsAction(2);
            }
            for (; ; ) {
                if ((getActivity() == null) || (this.mPagerAdapter == null) || (this.mPagerAdapter.profilesFragment == null)) {
                    break label583;
                }
                if ((this.forumStatus != null) && (this.forumStatus.getCurrentUserName() != null) && (!this.mPagerAdapter.profilesFragment.username.equalsIgnoreCase(this.forumStatus.getCurrentUserName())) && (this.forumStatus.tapatalkForum != null) && (this.forumStatus.tapatalkForum.isPMEnable())) {
                    localObject = paramMenu.add(0, 1060, 0, "createPm");
                    ((MenuItem) localObject).setIcon(ThemeUtil.getMenuIconByPicName("pm", getActivity()));
                    ((MenuItem) localObject).setShowAsAction(2);
                }
                localObject = Prefs.get(getActivity()).getString("email", null);
                if ((this.forumStatus == null) || (this.mPagerAdapter.profilesFragment.username == null) || (this.forumStatus.getCurrentUserName() == null) || (!this.forumStatus.getCurrentUserName().equalsIgnoreCase(this.mPagerAdapter.profilesFragment.username))) {
                    break;
                }
                if ((localObject != null) && (this.forumStatus != null) && (Util.isSignedUser(getActivity(), this.forumStatus.tapatalkForum)) && (this.forumStatus.getRegister_email().equals(localObject))) {
                    paramMenu.add(0, 2, 0, getString(2131100480)).setShowAsAction(0);
                }
                paramMenu.add(0, 0, 0, getString(2131100296)).setShowAsAction(0);
                paramMenu.add(0, 1, 0, getString(2131100398)).setShowAsAction(0);
                return;
                if (this.forumStatus.isUnban()) {
                    localObject = paramMenu.add(0, 55, 0, getActivity().getString(2131100057));
                    ((MenuItem) localObject).setIcon(ThemeUtil.getMenuIconByPicName("bubble_unban", getActivity()));
                    ((MenuItem) localObject).setShowAsAction(2);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("forumStatus", this.forumStatus);
        paramBundle.putString("userId", this.userId);
        paramBundle.putString("mIconUsername", this.mIconUsername);
    }

    public void registBroad() {
        this.broadcastControl = new BroadcastControl(this.mActivity, this.mActivity);
        this.broadcastControl.registBroad(BroadcastControl.FINISH_ACTIVITY);
    }

    public void setActionBar() {
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setNavigationMode(0);
        if (this.mIconUsername != null) {
            this.bar.setTitle(this.mIconUsername);
        }
    }

    public void setActionBar(Activity paramActivity) {
        if (this.bar == null) {
            this.bar = paramActivity.getActionBar();
        }
        setActionBar();
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void showDialog(int paramInt) {
    }

    public void showProgress() {
        this.mActivity.showDialog(0);
    }

    public void showProgress(String paramString) {
    }

    public void showResetPasswordDialog() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
        LinearLayout localLinearLayout = (LinearLayout) this.mActivity.getLayoutInflater().inflate(2130903235, null);
        Object localObject = (TextView) localLinearLayout.findViewById(2131230900);
        final EditText localEditText = (EditText) localLinearLayout.findViewById(2131230982);
        localEditText.setText(this.forumStatus.tapatalkForum.getUserNameOrDisplayName());
        localEditText.setFocusable(false);
        TextView localTextView = (TextView) localLinearLayout.findViewById(2131231299);
        ((TextView) localObject).setText(this.mActivity.getString(2131100520));
        localTextView.setTypeface(Typeface.createFromAsset(this.mActivity.getAssets(), "font/Roboto_Condensed.ttf"));
        localTextView.setText(String.format(this.mActivity.getString(2131100521), new Object[]{this.forumStatus.getRegister_email()}));
        localObject = Prefs.get(this.mActivity);
        if (this.forumStatus != null) {
            if (((SharedPreferences) localObject).contains("token")) {
                this.token = ((SharedPreferences) localObject).getString("token", null);
            }
            if (((SharedPreferences) localObject).contains("email")) {
                this.email = ((SharedPreferences) localObject).getString("email", "");
            }
            if (((SharedPreferences) localObject).contains("tapatalk_auid")) {
                this.au_id = ((SharedPreferences) localObject).getInt("tapatalk_auid", 0);
            }
        }
        localBuilder.setView(localLinearLayout);
        localBuilder.setPositiveButton(this.mActivity.getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (Util.checkEditText(localEditText)) {
                    ProfilesOuterFragment.this.userName = localEditText.getText().toString().trim();
                    Util.hideSoftKeyb(ProfilesOuterFragment.this.mActivity, localEditText);
                    if ((!ProfilesOuterFragment.this.userName.equals("")) && (ProfilesOuterFragment.this.userName != null)) {
                        paramAnonymousDialogInterface = new ArrayList();
                        paramAnonymousDialogInterface.add(ProfilesOuterFragment.this.userName.getBytes());
                        paramAnonymousDialogInterface.add(ProfilesOuterFragment.this.token);
                        paramAnonymousDialogInterface.add(Util.getMD5(ProfilesOuterFragment.this.forumStatus.getForumId() + "|" + ProfilesOuterFragment.this.au_id + "|" + ProfilesOuterFragment.this.email));
                        ProfilesOuterFragment.this.engine.call("forget_password", paramAnonymousDialogInterface);
                        ProfilesOuterFragment.this.showProgress();
                        return;
                    }
                    ProfilesOuterFragment.this.showResetPasswordDialog();
                    return;
                }
                ProfilesOuterFragment.this.showResetPasswordDialog();
            }
        });
        localBuilder.setNegativeButton(this.mActivity.getResources().getString(2131100522), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.create().show();
    }

    public void tryFailed(String paramString) {
    }

    public void updateDialog(int paramInt) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
    }

    public void updateUI(String paramString) {
    }

    public void uploadToTk() {
        this.progress = new ProgressDialog(this.mActivity);
        this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
        this.mUploadAdapter = new UploadAdapter(this.mActivity, this.forumStatus.getMaxJpgSize());
        this.progress.show();
        new AsyncTask() {
            protected ArrayList doInBackground(String... paramAnonymousVarArgs) {
                if (ProfilesOuterFragment.this.mAdapter == null) {
                    ProfilesOuterFragment.this.mAdapter = new NewPostAdapter(ProfilesOuterFragment.this.mActivity, ProfilesOuterFragment.this.forumStatus.getUrl());
                }
                paramAnonymousVarArgs = new ArrayList();
                int i = ExifUtil.getExif(ProfilesOuterFragment.this.mActivity, ProfilesOuterFragment.this.photoUri);
                if (ProfilesOuterFragment.this.mUploadAdapter != null) {
                    ProfilesOuterFragment.this.mUploadAdapter.setUri(ProfilesOuterFragment.this.photoUri, i);
                    paramAnonymousVarArgs.add(ProfilesOuterFragment.this.attachImage2());
                }
                UserBehavior.logUserShareForum(ProfilesOuterFragment.this.mActivity);
                return paramAnonymousVarArgs;
            }

            protected void onPostExecute(ArrayList paramAnonymousArrayList) {
                try {
                    ProfilesOuterFragment.this.engine.getLoginStatus();
                    paramAnonymousArrayList = UploadAttachmentTool.getUploadImageInfo((String) paramAnonymousArrayList.get(0));
                    if (paramAnonymousArrayList.getResult() == 1) {
                        if ((paramAnonymousArrayList.getUrl() != null) && (paramAnonymousArrayList.getUrl().length() > 0)) {
                            ProfilesOuterFragment.this.mUploadAdapter.setUri(Uri.parse(paramAnonymousArrayList.getUrl()), 0);
                            if ((ProfilesOuterFragment.this.mPagerAdapter != null) && (ProfilesOuterFragment.this.mPagerAdapter.profilesFragment != null) && (ProfilesOuterFragment.this.mPagerAdapter.profilesFragment.profilesAdapter != null) && (ProfilesOuterFragment.this.mPagerAdapter.profilesFragment.profilesAdapter.userAction != null) && (ProfilesOuterFragment.this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.mUploadDialog != null)) {
                                ProfilesOuterFragment.this.mPagerAdapter.profilesFragment.profilesAdapter.userAction.mUploadDialog.uploadAvatar(ProfilesOuterFragment.this.mUploadAdapter);
                                ProfilesOuterFragment.this.progress.dismiss();
                            }
                        }
                    } else if (paramAnonymousArrayList.getResult_text() != null) {
                        Toast.makeText(ProfilesOuterFragment.this.mActivity, paramAnonymousArrayList.getResult_text(), 1).show();
                        return;
                    }
                } catch (Exception paramAnonymousArrayList) {
                    paramAnonymousArrayList.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ProfilesOuterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */