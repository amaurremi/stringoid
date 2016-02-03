package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.forum.ForumAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;

import java.util.ArrayList;

public class RebrandingUtil {
    public static int defaultID;
    public static boolean isGetMenuId;

    public static void addTabItem(Activity paramActivity, ForumStatus paramForumStatus, ArrayList<TabItem> paramArrayList1, ArrayList<TabItem> paramArrayList2) {
        int i = 0;
        if (i >= paramArrayList1.size()) {
            return;
        }
        TabItem localTabItem = new TabItem(paramActivity, ((TabItem) paramArrayList1.get(i)).getName(), ((TabItem) paramArrayList1.get(i)).getDisplay_name(), ((TabItem) paramArrayList1.get(i)).getValue(), false);
        if ((paramForumStatus != null) && (!paramForumStatus.isLogin())) {
        }
        for (paramArrayList2 = getGuestTabItem(localTabItem, paramForumStatus, paramArrayList2); ; paramArrayList2 = getLoginTabItem(localTabItem, paramForumStatus, paramArrayList2)) {
            i += 1;
            break;
        }
    }

    public static int getDefaultMenuId(Activity paramActivity, int paramInt) {
        int j = 0;
        int i = 0;
        for (; ; ) {
            if (i >= getRebrandingConfig(paramActivity).getOrder().size()) {
                if (j == 0) {
                    paramInt = 1013;
                }
                return paramInt;
            }
            if (((TabItem) getRebrandingConfig(paramActivity).getOrder().get(i)).isSelected()) {
                paramInt = ((TabItem) getRebrandingConfig(paramActivity).getOrder().get(i)).getMenuid();
                j = 1;
            }
            i += 1;
        }
    }

    public static void getForumById(Activity paramActivity, ForumStatus paramForumStatus, String paramString1, String paramString2) {
        Object localObject;
        if (paramActivity.getIntent().getExtras().containsKey("forumId")) {
            localObject = paramActivity.getIntent().getExtras().getString("forumId");
            paramForumStatus.tapatalkForum = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(localObject);
        }
        if ((paramForumStatus.tapatalkForum == null) && (paramActivity.getIntent().getExtras().containsKey("forumStatus"))) {
            localObject = ((ForumStatus) paramActivity.getIntent().getExtras().getSerializable("forumStatus")).tapatalkForum.getId();
            paramForumStatus.tapatalkForum = new FavoriateSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivateById(localObject);
        }
        if ((paramForumStatus.tapatalkForum == null) && (paramActivity.getIntent().getExtras().containsKey("forumStatus"))) {
            paramActivity = (ForumStatus) paramActivity.getIntent().getExtras().getSerializable("forumStatus");
        }
        while (paramForumStatus.tapatalkForum == null) {
            return;
        }
        ForumStatus.initialForumStatus(paramActivity, paramString1, paramForumStatus.tapatalkForum.getUserName(), paramString2);
    }

    public static ArrayList<TabItem> getGuestTabItem(TabItem paramTabItem, ForumStatus paramForumStatus, ArrayList<TabItem> paramArrayList) {
        if (paramTabItem.getMenuid() == 1027) {
            paramArrayList.add(paramTabItem);
        }
        do {
            do {
                return paramArrayList;
            } while ((paramTabItem.getMenuid() == 1026) && (paramForumStatus.isRegister()));
            if ((paramTabItem.getMenuid() == 1016) && (paramForumStatus.isGuestOkay())) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1018) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if ((paramTabItem.getMenuid() == 1011) && (paramForumStatus.isGuestSearch()) && (paramForumStatus.isCanSearch())) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1029) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if ((paramTabItem.getMenuid() == 1201) && (paramForumStatus != null) && (paramForumStatus.getRebrandingConfig().getCms_url() != null) && (!paramForumStatus.getRebrandingConfig().getCms_url().equals(""))) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
        } while (paramTabItem.getMenuid() != paramTabItem.getValue().hashCode() + 2000);
        paramArrayList.add(paramTabItem);
        return paramArrayList;
    }

    public static ArrayList<TabItem> getLoginTabItem(TabItem paramTabItem, ForumStatus paramForumStatus, ArrayList<TabItem> paramArrayList) {
        if (paramForumStatus != null) {
            if ((paramTabItem.getMenuid() != 1024) || (!paramForumStatus.isAlert())) {
                break label29;
            }
            paramArrayList.add(paramTabItem);
        }
        label29:
        do {
            return paramArrayList;
            if (paramTabItem.getMenuid() == 1019) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1014) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if ((paramTabItem.getMenuid() == 1013) && (paramForumStatus.isCanUnread())) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1035) {
                if ((paramForumStatus.tapatalkForum != null) && (paramForumStatus.tapatalkForum.isSupportConve())) {
                    paramTabItem.setMenuid(1020);
                    paramArrayList.add(paramTabItem);
                    return paramArrayList;
                }
                paramTabItem.setMenuid(1021);
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1016) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1018) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if ((paramTabItem.getMenuid() == 1011) && (paramForumStatus.isCanSearch())) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if ((paramTabItem.getMenuid() == 1028) && (paramForumStatus.isCanWhoOnline())) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1029) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if ((paramTabItem.getMenuid() == 1201) && (paramForumStatus != null) && (paramForumStatus.getRebrandingConfig().getCms_url() != null) && (!paramForumStatus.getRebrandingConfig().getCms_url().equals(""))) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == paramTabItem.getValue().hashCode() + 2000) {
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1020) {
                paramTabItem.setMenuid(1020);
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
            if (paramTabItem.getMenuid() == 1021) {
                paramTabItem.setMenuid(1021);
                paramArrayList.add(paramTabItem);
                return paramArrayList;
            }
        }
        while ((paramTabItem.getMenuid() != 1038) || (paramForumStatus == null) || (!paramForumStatus.isVersionSupportMod()) || (!paramForumStatus.isCanModerate()));
        paramArrayList.add(paramTabItem);
        return paramArrayList;
    }

    public static boolean getRebrandMenuTab(Activity paramActivity, ForumStatus paramForumStatus, int paramInt) {
        Prefs.get(paramActivity);
        if (paramInt == 1027) {
        }
        while ((paramInt == 1026) || (paramInt == 1016) || ((paramInt == 1011) && (paramForumStatus.isCanSearch())) || (paramInt == 1018) || (paramInt == 1201)) {
            return true;
        }
        return false;
    }

    public static RebrandingConfig getRebrandingConfig(Context paramContext) {
        Object localObject1 = null;
        try {
            Object localObject2 = AppCacheManager.getRebrandingUrl(paramContext);
            paramContext = (Context) localObject1;
            if (AppCacheManager.checkFile((String) localObject2)) {
                localObject2 = AppCacheManager.getCacheData((String) localObject2);
                paramContext = (Context) localObject1;
                if (localObject2 != null) {
                    paramContext = (Context) localObject1;
                    if ((localObject2 instanceof RebrandingConfig)) {
                        paramContext = (RebrandingConfig) localObject2;
                    }
                }
            }
            return paramContext;
        } catch (Exception paramContext) {
            paramContext.printStackTrace();
        }
        return null;
    }

    public static int getSelectMenuId(SlidingMenuActivity paramSlidingMenuActivity, ForumStatus paramForumStatus) {
        int i = 0;
        int k = 0;
        int m = 0;
        if ((paramForumStatus != null) && (paramForumStatus.getRebrandingConfig() != null) && (getRebrandingConfig(paramSlidingMenuActivity).getOrder() != null) && (getRebrandingConfig(paramSlidingMenuActivity).getOrder().size() > 0)) {
            int j = 0;
            label65:
            ArrayList localArrayList;
            if (j >= getRebrandingConfig(paramSlidingMenuActivity).getOrder().size()) {
                if (k == 0) {
                    j = 0;
                    if (j < getRebrandingConfig(paramSlidingMenuActivity).getOrder().size()) {
                        break label186;
                    }
                }
                localArrayList = new ArrayList();
                j = 0;
                if (j < getRebrandingConfig(paramSlidingMenuActivity).getOrder().size()) {
                    break label236;
                }
                defaultID = i;
                j = 0;
                k = m;
                label114:
                if (j < localArrayList.size()) {
                    break label339;
                }
                if (k == 0) {
                    break label365;
                }
                defaultID = i;
            }
            for (isGetMenuId = false; ; isGetMenuId = true) {
                return i;
                if (((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(j)).isSelected()) {
                    i = ((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(j)).getMenuid();
                    k = 1;
                }
                j += 1;
                break;
                label186:
                if (getRebrandMenuTab(paramSlidingMenuActivity, paramForumStatus, ((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(j)).getMenuid())) {
                    return ((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(j)).getMenuid();
                }
                j += 1;
                break label65;
                label236:
                TabItem localTabItem = new TabItem(paramSlidingMenuActivity, ((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(j)).getName(), ((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(j)).getDisplay_name(), ((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(j)).getValue(), false);
                if ((paramForumStatus != null) && (paramForumStatus.isLogin())) {
                }
                for (localArrayList = getLoginTabItem(localTabItem, paramForumStatus, localArrayList); ; localArrayList = getGuestTabItem(localTabItem, paramForumStatus, localArrayList)) {
                    j += 1;
                    break;
                }
                label339:
                if (((TabItem) localArrayList.get(j)).getMenuid() == i) {
                    k = 1;
                }
                j += 1;
                break label114;
                label365:
                i = 1018;
                defaultID = 1018;
            }
        }
        if ((paramForumStatus.tapatalkForum.getCms_url() != null) && (!paramForumStatus.tapatalkForum.getCms_url().equals(""))) {
            return 1201;
        }
        if (paramForumStatus.isGuestOkay()) {
            return 1016;
        }
        paramSlidingMenuActivity.showBackListFragment(1027, true, false);
        paramSlidingMenuActivity.showFragment(1027);
        return 1027;
    }

    public static ArrayList<TabItem> getTabItem(Activity paramActivity, ForumStatus paramForumStatus) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramForumStatus != null) {
            localObject1 = localObject2;
            if (paramForumStatus.getRebrandingConfig() != null) {
                localObject1 = paramForumStatus.getRebrandingConfig().getOrder();
            }
        }
        paramForumStatus = getRebrandingConfig(paramActivity);
        paramActivity = (Activity) localObject1;
        if (paramForumStatus != null) {
            if (localObject1 != null) {
                break label47;
            }
            paramActivity = paramForumStatus.getOrder();
        }
        label47:
        do {
            return paramActivity;
            paramActivity = (Activity) localObject1;
        } while (((ArrayList) localObject1).size() > 0);
        return paramForumStatus.getOrder();
    }

    public static ArrayList<TabItem> initTabMenu(Activity paramActivity, BackListFragment paramBackListFragment, final ForumStatus paramForumStatus, int paramInt) {
        FragmentActivity localFragmentActivity = paramBackListFragment.getActivity();
        Object localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        if ((localFragmentActivity.getResources().getBoolean(2131558401)) && (!localFragmentActivity.getResources().getBoolean(2131558402))) {
            Object localObject1;
            if (paramForumStatus != null) {
                localObject1 = localArrayList;
            }
            for (; ; ) {
                try {
                    localObject2 = AppCacheManager.getForumStatusCacheUrl(paramActivity, paramForumStatus.getUrl(), paramForumStatus.tapatalkForum.getLowerUserName());
                    if (paramInt == 1018) {
                        localObject1 = localArrayList;
                        if (AppCacheManager.checkFile((String) localObject2)) {
                        }
                    } else {
                        localObject1 = localArrayList;
                        new Thread() {
                            public void run() {
                                Looper.prepare();
                                ForumAdapter localForumAdapter = new ForumAdapter(RebrandingUtil.this, paramForumStatus.getUrl(), true);
                                localForumAdapter.setOnlyRefresh(true);
                                localForumAdapter.getForum();
                            }
                        }.start();
                    }
                    localObject1 = localArrayList;
                    localObject2 = getTabItem(paramActivity, paramForumStatus);
                    localObject1 = localArrayList;
                    if (((ArrayList) localObject2).size() > 0) {
                        paramActivity = localArrayList;
                        if (localArrayList != null) {
                            localObject1 = localArrayList;
                            paramActivity = new ArrayList();
                        }
                        localObject1 = paramActivity;
                        paramActivity.add(new TabItem(localFragmentActivity.getResources().getString(2131100425), false, 1010));
                        localObject1 = paramActivity;
                        addTabItem(localFragmentActivity, paramForumStatus, (ArrayList) localObject2, paramActivity);
                        return paramActivity;
                    }
                    localObject1 = localArrayList;
                    paramBackListFragment.initTabMenu(paramActivity, localArrayList);
                    localObject1 = localArrayList;
                    if ((!localFragmentActivity.getResources().getBoolean(2131558401)) || (paramForumStatus == null)) {
                        break;
                    }
                    localObject1 = localArrayList;
                    if (paramForumStatus.getRebrandingConfig().getCms_url() == null) {
                        break;
                    }
                    localObject1 = localArrayList;
                    if (paramForumStatus.getRebrandingConfig().getCms_url().equals("")) {
                        break;
                    }
                    localObject1 = localArrayList;
                    paramActivity = new TabItem(localFragmentActivity.getString(2131100429), false, 1201);
                    localObject1 = localArrayList;
                    if (SettingsFragment.isLightTheme(localFragmentActivity)) {
                        localObject1 = localArrayList;
                        paramActivity.setIcon(2130839039);
                        localObject1 = localArrayList;
                        paramActivity.setIconSelected(2130839039);
                        localObject1 = localArrayList;
                        if (localArrayList.contains(Integer.valueOf(1201))) {
                            break;
                        }
                        localObject1 = localArrayList;
                        localArrayList.add(1, paramActivity);
                        return localArrayList;
                    }
                } catch (Exception paramActivity) {
                    paramActivity.printStackTrace();
                    return (ArrayList<TabItem>) localObject1;
                }
                localObject1 = localArrayList;
                paramActivity.setIcon(2130839039);
                localObject1 = localArrayList;
                paramActivity.setIconSelected(2130839039);
            }
        }
        paramBackListFragment.initTabMenu(paramActivity, localArrayList);
        return localArrayList;
    }

    public static void showLoginSelectView(SlidingMenuActivity paramSlidingMenuActivity, int paramInt) {
        if (getRebrandingConfig(paramSlidingMenuActivity).getOrder().size() > 0) {
            if ((paramInt != 0) && (paramInt != 1027) && (paramInt != 1026)) {
                paramSlidingMenuActivity.showSelectView(paramInt);
            }
        } else {
            return;
        }
        int i = 1;
        paramInt = 0;
        for (; ; ) {
            if (paramInt >= getRebrandingConfig(paramSlidingMenuActivity).getOrder().size()) {
                if (i == 0) {
                    break;
                }
                paramSlidingMenuActivity.showSelectView(((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(0)).getMenuid());
                return;
            }
            if (((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(paramInt)).getMenuid() == 1018) {
                i = 0;
                paramSlidingMenuActivity.showSelectView(((TabItem) getRebrandingConfig(paramSlidingMenuActivity).getOrder().get(paramInt)).getMenuid());
            }
            paramInt += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/RebrandingUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */