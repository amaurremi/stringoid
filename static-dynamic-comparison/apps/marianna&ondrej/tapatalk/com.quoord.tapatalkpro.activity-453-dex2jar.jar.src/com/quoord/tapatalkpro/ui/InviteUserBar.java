package com.quoord.tapatalkpro.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.quoord.tapatalkpro.action.AuInviteUserAction;
import com.quoord.tapatalkpro.action.AuInviteUserAction.AuInviteUserActionBack;
import com.quoord.tapatalkpro.action.GetAuIdentifyAction;
import com.quoord.tapatalkpro.action.GetAuIdentifyAction.GetAuIdentifyActionBack;
import com.quoord.tapatalkpro.action.GetContactAction;
import com.quoord.tapatalkpro.action.GetContactAction.GetContactActionBack;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.FunctionConfig;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.net.HashUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class InviteUserBar {
    private final boolean DEBUG_MODE = false;
    private Activity mActivity;
    private View mBar;
    private ImageView mCloseIcon;
    FunctionConfig mFc = null;
    private String mForumId;
    private ForumStatus mForumStatus;
    private ArrayList<HashMap<String, String>> mInviteUserInfos;
    private ImageView mMailIcon;
    private int mResponseCount = 0;
    private TextView mSubtitle;
    private TextView mTitle;
    private ArrayList<HashMap<String, String>> mUserInfos;

    public InviteUserBar() {
        this.mActivity = null;
        this.mForumStatus = null;
        this.mForumId = null;
        this.mInviteUserInfos = null;
        this.mUserInfos = null;
        this.mBar = null;
    }

    public InviteUserBar(Activity paramActivity, ForumStatus paramForumStatus, ArrayList<HashMap<String, String>> paramArrayList, View paramView) {
        this.mActivity = paramActivity;
        this.mForumStatus = paramForumStatus;
        this.mUserInfos = paramArrayList;
        this.mBar = paramView;
        this.mForumId = null;
        this.mInviteUserInfos = null;
    }

    private boolean canInvite() {
        return this.mForumStatus.isSupportGetContact();
    }

    private void getEncEmail() {
        GetContactAction localGetContactAction = new GetContactAction(this.mActivity, this.mForumStatus);
        this.mResponseCount = 0;
        Iterator localIterator = this.mInviteUserInfos.iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return;
            }
            localGetContactAction.getContact((String) ((HashMap) localIterator.next()).get("userid"), new GetContactAction.GetContactActionBack() {
                public void getContactActionBack(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {
                    paramAnonymousString2 = InviteUserBar.this.mInviteUserInfos.iterator();
                    for (; ; ) {
                        if (!paramAnonymousString2.hasNext()) {
                            paramAnonymousString1 = InviteUserBar.this;
                            paramAnonymousString1.mResponseCount += 1;
                            InviteUserBar.this.sendInvite();
                            return;
                        }
                        HashMap localHashMap = (HashMap) paramAnonymousString2.next();
                        if (((String) localHashMap.get("userid")).equals(paramAnonymousString1)) {
                            localHashMap.put("enc_email", paramAnonymousString3);
                        }
                    }
                }

                public void getContactActionErrorBack(String paramAnonymousString) {
                    paramAnonymousString = InviteUserBar.this;
                    paramAnonymousString.mResponseCount += 1;
                    InviteUserBar.this.sendInvite();
                }
            });
        }
    }

    private void getUidsNeedInvite() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.mUserInfos.iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                new GetAuIdentifyAction(this.mActivity).getAuIdentify(this.mForumId, localArrayList, new GetAuIdentifyAction.GetAuIdentifyActionBack() {
                    public void getAuIdentifyActionBack(ArrayList<String> paramAnonymousArrayList) {
                        if ((paramAnonymousArrayList == null) || (paramAnonymousArrayList.size() == 0)) {
                            InviteUserBar.this.mBar.setVisibility(8);
                            return;
                        }
                        if (InviteUserBar.this.mInviteUserInfos == null) {
                            InviteUserBar.this.mInviteUserInfos = new ArrayList();
                        }
                        InviteUserBar.this.mInviteUserInfos.clear();
                        Iterator localIterator = InviteUserBar.this.mUserInfos.iterator();
                        for (; ; ) {
                            if (!localIterator.hasNext()) {
                                InviteUserBar.this.showInviteBar();
                                return;
                            }
                            HashMap localHashMap = (HashMap) localIterator.next();
                            if (paramAnonymousArrayList.indexOf(localHashMap.get("userid")) != -1) {
                                InviteUserBar.this.mInviteUserInfos.add(localHashMap);
                            }
                        }
                    }
                });
                return;
            }
            HashMap localHashMap = (HashMap) localIterator.next();
            if (!((String) localHashMap.get("userid")).equals(this.mForumStatus.getUserId())) {
                localArrayList.add((String) localHashMap.get("userid"));
            }
        }
    }

    private String getUserNameText() {
        ArrayList localArrayList = new ArrayList();
        Object localObject = this.mInviteUserInfos.iterator();
        int j;
        StringBuilder localStringBuilder;
        int i;
        int m;
        for (; ; ) {
            if (!((Iterator) localObject).hasNext()) {
                j = 40;
                if (Util.isHDDevice(this.mActivity)) {
                    j = 60;
                }
                localStringBuilder = new StringBuilder("");
                String str = (String) localArrayList.get(0);
                int k = 0;
                localObject = str;
                if (str.getBytes().length > j) {
                    k = (str.getBytes().length - str.length()) / 2;
                    i = k;
                    if (k > 20) {
                        i = 20;
                    }
                    localObject = str.substring(0, j - i) + "...";
                    k = i;
                }
                localStringBuilder.append((String) localObject);
                m = 0;
                n = 0;
                i = m;
                if (localArrayList.size() > 1) {
                    i = m;
                    if (k == 0) {
                        m = 1;
                        i = n;
                        if (m < localArrayList.size()) {
                            break;
                        }
                    }
                }
                if ((i != 0) && (k == 0)) {
                    localStringBuilder.append(", ...");
                }
                localObject = localStringBuilder.toString();
                return this.mActivity.getString(2131100782) + " " + "<b>" + (String) localObject + "</b>" + " " + this.mActivity.getString(2131100783);
            }
            localArrayList.add((String) ((HashMap) ((Iterator) localObject).next()).get("username"));
        }
        int n = localStringBuilder.toString().getBytes().length;
        if (((String) localArrayList.get(m)).getBytes().length + n <= j) {
            localStringBuilder.append(", ");
            localStringBuilder.append((String) localArrayList.get(m));
        }
        for (; ; ) {
            m += 1;
            break;
            i = 1;
        }
    }

    private boolean initView() {
        if (this.mBar == null) {
            return false;
        }
        this.mMailIcon = ((ImageView) this.mBar.findViewById(2131231294));
        this.mTitle = ((TextView) this.mBar.findViewById(2131231296));
        this.mSubtitle = ((TextView) this.mBar.findViewById(2131231297));
        this.mCloseIcon = ((ImageView) this.mBar.findViewById(2131231295));
        if ((this.mMailIcon == null) || (this.mTitle == null) || (this.mSubtitle == null) || (this.mCloseIcon == null)) {
            return false;
        }
        if (SettingsFragment.isLightTheme(this.mActivity)) {
            this.mBar.setBackgroundColor(this.mActivity.getResources().getColor(2131165255));
        }
        for (; ; ) {
            ViewGroup.LayoutParams localLayoutParams = this.mBar.getLayoutParams();
            localLayoutParams.height = Util.getPxFromDip(this.mActivity, 72.0F);
            this.mBar.setLayoutParams(localLayoutParams);
            this.mBar.setVisibility(8);
            return true;
            this.mBar.setBackgroundColor(this.mActivity.getResources().getColor(2131165256));
        }
    }

    private void inviteUser() {
        this.mBar.setVisibility(8);
        getEncEmail();
    }

    private void sendInvite() {
        if (this.mResponseCount < this.mInviteUserInfos.size()) {
            return;
        }
        AuInviteUserAction localAuInviteUserAction = new AuInviteUserAction(this.mActivity);
        HashMap localHashMap = new HashMap();
        localHashMap.put("forumid", this.mForumId);
        localHashMap.put("userid", this.mForumStatus.getUserId());
        localHashMap.put("username", this.mForumStatus.getCurrentUserName());
        localHashMap.put("avatarUrl", this.mForumStatus.getAvatarUrl());
        localAuInviteUserAction.doAuInviteUser(this.mForumId, this.mInviteUserInfos, localHashMap, new AuInviteUserAction.AuInviteUserActionBack() {
            public void auInviteUserActionBack(boolean paramAnonymousBoolean, String paramAnonymousString) {
            }
        });
    }

    private void setInviteBarShowTime() {
        long l = System.currentTimeMillis();
        SharedPreferences.Editor localEditor = Prefs.get(this.mActivity).edit();
        localEditor.putLong("invite_user_bar_show_time", l);
        localEditor.commit();
    }

    private boolean shouldInvite() {
        FunctionConfig localFunctionConfig = FunctionConfig.getFunctionConfig(this.mActivity);
        if (localFunctionConfig == null) {
        }
        int i;
        long l;
        do {
            do {
                do {
                    return false;
                }
                while (!HashUtil.getBoolean(localFunctionConfig.getEnableNewInvitation(), Boolean.valueOf(false)).booleanValue());
                i = localFunctionConfig.getNewInvitaionDisplayPeriod().intValue() * 86400000;
            } while (i < 0);
            l = Prefs.get(this.mActivity).getLong("invite_user_bar_show_time", 0L);
            if (l <= 0L) {
                return true;
            }
            l = System.currentTimeMillis() - l;
            if (l < 0L) {
                return true;
            }
        } while (l <= i);
        return true;
    }

    private void showInviteBar() {
        this.mBar.setVisibility(0);
        if ((this.mInviteUserInfos == null) || (this.mInviteUserInfos.size() == 0)) {
            return;
        }
        String str = getUserNameText();
        this.mSubtitle.setText(Html.fromHtml(str));
        this.mSubtitle.post(new Runnable() {
            public void run() {
                if (InviteUserBar.this.mSubtitle.getLineCount() > 1) {
                    ViewGroup.LayoutParams localLayoutParams = InviteUserBar.this.mBar.getLayoutParams();
                    localLayoutParams.height = Util.getPxFromDip(InviteUserBar.this.mActivity, 82.0F);
                    InviteUserBar.this.mBar.setLayoutParams(localLayoutParams);
                }
            }
        });
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                InviteUserBar.this.mBar.setVisibility(8);
            }
        });
        this.mBar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                InviteUserBar.this.inviteUser();
            }
        });
        setInviteBarShowTime();
    }

    public void process() {
        if ((this.mActivity == null) || (this.mForumStatus == null) || (this.mUserInfos == null) || (this.mBar == null)) {
        }
        do {
            return;
            this.mForumId = this.mForumStatus.getForumId();
        } while ((this.mForumId == null) || (this.mForumId.length() == 0) || (!canInvite()));
        Iterator localIterator = this.mUserInfos.iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                if ((this.mUserInfos.size() == 0) || (!initView()) || (!shouldInvite())) {
                    break;
                }
                getUidsNeedInvite();
                return;
            }
            HashMap localHashMap = (HashMap) localIterator.next();
            if ((localHashMap.get("userid") == null) || (((String) localHashMap.get("userid")).length() == 0) || (((String) localHashMap.get("userid")).equals("0")) || (localHashMap.get("username") == null) || (((String) localHashMap.get("username")).length() == 0)) {
                this.mUserInfos.remove(localHashMap);
            }
        }
    }

    public void process(Activity paramActivity, ForumStatus paramForumStatus, ArrayList<HashMap<String, String>> paramArrayList, View paramView) {
        this.mActivity = paramActivity;
        this.mForumStatus = paramForumStatus;
        this.mUserInfos = paramArrayList;
        this.mBar = paramView;
        process();
    }

    public void setActivity(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    public void setForumStatus(ForumStatus paramForumStatus) {
        this.mForumStatus = paramForumStatus;
    }

    public void setInviteBarView(View paramView) {
        this.mBar = paramView;
    }

    public void setUserInfo(ArrayList<HashMap<String, String>> paramArrayList) {
        this.mUserInfos = paramArrayList;
    }

    public void setUserInfo(HashMap<String, String> paramHashMap) {
        if (this.mUserInfos == null) {
            this.mUserInfos = new ArrayList();
        }
        this.mUserInfos.add(paramHashMap);
    }

    public void updateUI(Configuration paramConfiguration) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/InviteUserBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */