package com.quoord.DialogUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.directory.FavoriteForumAdapter;
import com.quoord.tapatalkpro.alarm.notification.NotificationSettingActivity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountDialog {
    private static int position = 0;

    public static void showDeleteDialog(final int paramInt, Activity paramActivity, FavoriteForumAdapter paramFavoriteForumAdapter) {
        new AlertDialog.Builder(paramActivity).setMessage(paramActivity.getString(2131100633)).setPositiveButton(paramActivity.getString(2131099915), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                AccountDialog.this.deleteFavoriateForum(paramInt);
            }
        }).setNegativeButton(paramActivity.getString(2131100263), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create().show();
    }

    public static void showPushDialog(Activity paramActivity, ForumStatus paramForumStatus) {
        Object localObject1 = new ArrayList();
        SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences("notificationsetting", 0);
        Object localObject2 = new ArrayList();
        label90:
        int i;
        if (!paramForumStatus.tapatalkForum.isPush()) {
            if (paramForumStatus.tapatalkForum.isSupportConve()) {
                ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100368));
                ((ArrayList) localObject2).add("conversation");
                ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100356));
                ((ArrayList) localObject2).add("sub");
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= ((ArrayList) localObject1).size()) {
                localObject1 = new Intent();
                ((Intent) localObject1).setClass(paramActivity, NotificationSettingActivity.class);
                ((Intent) localObject1).putExtra("forumStatus", paramForumStatus);
                paramActivity.startActivity((Intent) localObject1);
                return;
                ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100355));
                ((ArrayList) localObject2).add("pm");
                break;
                if (paramForumStatus.tapatalkForum.isPushConv()) {
                    ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100368));
                    ((ArrayList) localObject2).add("conversation");
                }
                if (paramForumStatus.tapatalkForum.isPushPM()) {
                    ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100355));
                    ((ArrayList) localObject2).add("pm");
                }
                if (paramForumStatus.tapatalkForum.isPushSub()) {
                    ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100356));
                    ((ArrayList) localObject2).add("sub");
                }
                if (paramForumStatus.tapatalkForum.isPushNewTopic()) {
                    ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100359));
                    ((ArrayList) localObject2).add("newtopic");
                }
                if (paramForumStatus.tapatalkForum.isPushLike()) {
                    ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100357));
                    ((ArrayList) localObject2).add("like");
                }
                if (paramForumStatus.tapatalkForum.isPushQuote()) {
                    ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100358));
                    ((ArrayList) localObject2).add("quote");
                }
                if (!paramForumStatus.tapatalkForum.isPushTag()) {
                    break label90;
                }
                ((ArrayList) localObject1).add(paramActivity.getResources().getString(2131100360));
                ((ArrayList) localObject2).add("tag");
                break label90;
            }
            if (!localSharedPreferences.contains(paramForumStatus.tapatalkForum.getId() + (String) ((ArrayList) localObject1).get(i))) {
                localObject2 = localSharedPreferences.edit();
                ((SharedPreferences.Editor) localObject2).putBoolean(paramForumStatus.tapatalkForum.getId() + (String) ((ArrayList) localObject1).get(i), true);
                ((SharedPreferences.Editor) localObject2).commit();
            }
            i += 1;
        }
    }

    private static void showPushDisableDialog(boolean paramBoolean, Context paramContext) {
        paramContext = new AlertDialog.Builder(paramContext).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        if (paramBoolean) {
            paramContext.setMessage(2131100371);
        }
        for (; ; ) {
            paramContext.create().show();
            return;
            paramContext.setMessage(2131100372);
        }
    }

    public static void showPushSettingDialog(Activity paramActivity, final TapatalkForum paramTapatalkForum, final ArrayList<String> paramArrayList1, final ArrayList<String> paramArrayList2) {
        new ForumStatus(paramActivity).tapatalkForum = paramTapatalkForum;
        final boolean[] arrayOfBoolean = new boolean[paramArrayList2.size()];
        SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences("notificationsetting", 0);
        if (localSharedPreferences.getBoolean(paramActivity.getResources().getString(2131100361), true)) {
            int i = 0;
            for (; ; ) {
                if (i >= paramArrayList2.size()) {
                    String[] arrayOfString = new String[paramArrayList2.size()];
                    new AlertDialog.Builder(paramActivity).setMultiChoiceItems((CharSequence[]) paramArrayList2.toArray(arrayOfString), arrayOfBoolean, new DialogInterface.OnMultiChoiceClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, boolean paramAnonymousBoolean) {
                            AccountDialog.this[paramAnonymousInt] = paramAnonymousBoolean;
                        }
                    }).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            paramAnonymousDialogInterface = AccountDialog.this.edit();
                            HashMap localHashMap = new HashMap();
                            paramAnonymousInt = 0;
                            if (paramAnonymousInt >= paramArrayList2.size()) {
                                paramAnonymousDialogInterface.commit();
                                return;
                            }
                            paramAnonymousDialogInterface.putBoolean(paramTapatalkForum.getId() + (String) paramArrayList2.get(paramAnonymousInt), arrayOfBoolean[paramAnonymousInt]);
                            if (arrayOfBoolean[paramAnonymousInt] != 0) {
                                localHashMap.put(paramArrayList1.get(paramAnonymousInt), Integer.valueOf(1));
                            }
                            for (; ; ) {
                                paramAnonymousInt += 1;
                                break;
                                localHashMap.put(paramArrayList1.get(paramAnonymousInt), Integer.valueOf(0));
                            }
                        }
                    }).setNegativeButton("Cancel", null).create().show();
                    return;
                }
                arrayOfBoolean[i] = localSharedPreferences.getBoolean(paramTapatalkForum.getId() + (String) paramArrayList2.get(i), true);
                i += 1;
            }
        }
        Toast.makeText(paramActivity, "Please open push notificaion in settings firstly", 0).show();
    }

    public static Dialog showUnreadDialog(Activity paramActivity, final Topic paramTopic, final ForumStatus paramForumStatus) {
        final SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences("defualt_first_unread", 0);
        position = localSharedPreferences.getInt("default", 1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramActivity.getResources().getString(2131100092));
        if (!paramActivity.getResources().getBoolean(2131558402)) {
            localArrayList.add(paramActivity.getResources().getString(2131100091));
        }
        localArrayList.add(paramActivity.getResources().getString(2131100093));
        String[] arrayOfString = new String[localArrayList.size()];
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getResources().getString(2131100080)).setSingleChoiceItems((CharSequence[]) localArrayList.toArray(arrayOfString), arrayOfString.length, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                AccountDialog.position = paramAnonymousInt;
            }
        }).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                switch (AccountDialog.position) {
                }
                for (; ; ) {
                    paramAnonymousDialogInterface = localSharedPreferences.edit();
                    paramAnonymousDialogInterface.putInt("default", AccountDialog.position);
                    paramAnonymousDialogInterface.commit();
                    paramTopic.openThread(AccountDialog.this, paramForumStatus);
                    return;
                    SettingsFragment.setLandBehavior(AccountDialog.this, "0");
                    continue;
                    SettingsFragment.setLandBehavior(AccountDialog.this, "1");
                    continue;
                    SettingsFragment.setLandBehavior(AccountDialog.this, "2");
                }
            }
        }).setNegativeButton("Cancel", null).create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/AccountDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */