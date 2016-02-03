package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.DialogUtil.ForumDialogAdapter;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.SubscribeForumAndTopicAction;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.ForumAdapter;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewSubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubForumAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.TopicAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.SubscribeForumSqlHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ShortcutUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.LoginStatus;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class Forum
        extends BaseBean
        implements Serializable {
    public static int BOTTOM_FORUM_ITEM = 2;
    public static int MID_FORUM_ITEM = 0;
    public static int TOP_FORUM_ITEM = 0;
    private static final long serialVersionUID = 349992264881044238L;
    private boolean canSubscribe = true;
    private ArrayList<Forum> childForums;
    private String description;
    private String forum_image;
    private boolean has_notification_mode = false;
    private String id;
    private boolean isLink;
    private boolean isProtected = false;
    private boolean isSubscribe = false;
    private int level;
    private String logoURL;
    private String name;
    private int notification_mode = 0;
    private Forum parentForum = null;
    private String parentId;
    private boolean subOnly;
    private String url;

    static {
        MID_FORUM_ITEM = 1;
    }

    public static Forum createForumBean(HashMap paramHashMap, ForumStatus paramForumStatus, Context paramContext, ArrayList paramArrayList, ForumAdapter paramForumAdapter, int paramInt) {
        if ((paramHashMap == null) || (paramHashMap.get("forum_name") == null)) {
            paramHashMap = null;
        }
        for (; ; ) {
            return paramHashMap;
            Forum localForum1 = new Forum();
            paramInt += 1;
            if ((paramForumAdapter != null) && (paramInt > paramForumAdapter.maxLevel)) {
                paramForumAdapter.maxLevel = paramInt;
            }
            localForum1.setLevel(paramInt);
            localForum1.setId((String) paramHashMap.get("forum_id"));
            if ((paramHashMap.containsKey("new_post")) && (((Boolean) paramHashMap.get("new_post")).booleanValue()) && (!paramForumStatus.checkNewPost(localForum1.getId()))) {
                paramForumStatus.addNewPostForForum(localForum1.getId());
            }
            try {
                localForum1.setName(new String((byte[]) paramHashMap.get("forum_name"), "UTF-8"));
                localForum1.setParentId((String) paramHashMap.get("parent_id"));
                localForum1.setLogoURL((String) paramHashMap.get("logo_url"));
                if (paramHashMap.containsKey("can_subscribe")) {
                    localForum1.setCanSubscribe(((Boolean) paramHashMap.get("can_subscribe")).booleanValue());
                    localForum1.setUrl((String) paramHashMap.get("url"));
                    if (paramHashMap.containsKey("sub_only")) {
                        localForum1.setSubOnly(((Boolean) paramHashMap.get("sub_only")).booleanValue());
                    }
                    if (!paramHashMap.containsKey("is_protected")) {
                        break label368;
                    }
                    localForum1.setProtected(((Boolean) paramHashMap.get("is_protected")).booleanValue());
                    if (paramHashMap.containsKey("subscribe_mode")) {
                        localForum1.setHas_notification_mode(true);
                        localForum1.setNotification_mode(((Integer) paramHashMap.get("subscribe_mode")).intValue());
                    }
                    paramHashMap = (Object[]) paramHashMap.get("child");
                    if ((paramHashMap != null) && (paramHashMap.length > 0)) {
                        paramInt = 0;
                        if (paramInt < paramHashMap.length) {
                            break label377;
                        }
                    }
                    paramHashMap = localForum1;
                    if (paramArrayList == null) {
                        continue;
                    }
                    paramArrayList.add(localForum1);
                    return localForum1;
                }
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                    continue;
                    if (paramForumStatus.getApiLevel() >= 4) {
                        localForum1.setCanSubscribe(false);
                        continue;
                        label368:
                        localForum1.setProtected(false);
                        continue;
                        label377:
                        Forum localForum2 = createForumBean((HashMap) paramHashMap[paramInt], paramForumStatus, paramContext, paramArrayList, paramForumAdapter, localForum1.getLevel());
                        if (localForum2 != null) {
                            localForum1.addChildForum(localForum2);
                        }
                        paramInt += 1;
                    }
                }
            }
        }
    }

    public static View getForumView(int paramInt, Forum paramForum, View paramView, ViewGroup paramViewGroup, ForumStatus paramForumStatus, Context paramContext, BaseAdapter paramBaseAdapter, boolean paramBoolean) {
        if ((paramView == null) || (!(paramView.getTag() instanceof ThreadViewHolder))) {
            paramView = LayoutInflater.from(paramContext).inflate(2130903188, null);
            paramViewGroup = new ThreadViewHolder(null);
            paramViewGroup.forum_lay = ((RelativeLayout) paramView.findViewById(2131231179));
            paramViewGroup.icon = ((ImageView) paramView.findViewById(2131231103));
            paramViewGroup.text = ((TextView) paramView.findViewById(2131231104));
            paramViewGroup.notificationMode = ((ImageView) paramView.findViewById(2131231180));
            paramViewGroup.diver = ((ImageView) paramView.findViewById(2131230776));
            paramViewGroup.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", paramContext));
            paramView.setTag(paramViewGroup);
            if (!paramForumStatus.checkNewPost(paramForum.getId())) {
                break label240;
            }
            paramViewGroup.text.setTypeface(null, 1);
            label146:
            paramViewGroup.text.setText(paramForum.getName());
            AvatarTool.showLogo(paramContext, paramViewGroup.icon, paramForum.getLogoURL(), 3);
            if (!paramBoolean) {
                break label252;
            }
            paramViewGroup.notificationMode.setVisibility(8);
            label185:
            if (paramInt != TOP_FORUM_ITEM) {
                break label302;
            }
            paramViewGroup.forum_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", paramContext));
            paramViewGroup.diver.setVisibility(0);
        }
        for (; ; ) {
            paramViewGroup.icon.setPadding(0, 14, 0, 0);
            return paramView;
            paramViewGroup = (ThreadViewHolder) paramView.getTag();
            break;
            label240:
            paramViewGroup.text.setTypeface(null, 0);
            break label146;
            label252:
            if (((paramForum.isSubscribe) || (paramForumStatus.checkLocalSubscribeForum(paramForum.id))) && (paramForumStatus.isLogin())) {
                paramViewGroup.notificationMode.setVisibility(0);
                break label185;
            }
            paramViewGroup.notificationMode.setVisibility(8);
            break label185;
            label302:
            if (paramInt == BOTTOM_FORUM_ITEM) {
                paramViewGroup.forum_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", paramContext));
                paramViewGroup.diver.setVisibility(8);
            } else {
                paramViewGroup.forum_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", paramContext));
                paramViewGroup.diver.setVisibility(0);
            }
        }
    }

    public static View getForumView(int paramInt, Forum paramForum, View paramView, ViewGroup paramViewGroup, LoginStatus paramLoginStatus, Context paramContext, BaseAdapter paramBaseAdapter, boolean paramBoolean) {
        if ((paramView == null) || (!(paramView.getTag() instanceof ThreadViewHolder))) {
            paramView = LayoutInflater.from(paramContext).inflate(2130903188, null);
            paramViewGroup = new ThreadViewHolder(null);
            paramViewGroup.forum_lay = ((RelativeLayout) paramView.findViewById(2131231179));
            paramViewGroup.icon = ((ImageView) paramView.findViewById(2131231103));
            paramViewGroup.text = ((TextView) paramView.findViewById(2131231104));
            paramViewGroup.notificationMode = ((ImageView) paramView.findViewById(2131231180));
            paramViewGroup.diver = ((ImageView) paramView.findViewById(2131230776));
            paramViewGroup.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", paramContext));
            paramView.setTag(paramViewGroup);
            paramViewGroup.text.setText(paramForum.getName());
            AvatarTool.showLogo(paramContext, paramViewGroup.icon, paramForum.getLogoURL(), 3);
            if (!paramBoolean) {
                break label219;
            }
            paramViewGroup.notificationMode.setVisibility(8);
            label164:
            if (paramInt != TOP_FORUM_ITEM) {
                break label291;
            }
            paramViewGroup.forum_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", paramContext));
            paramViewGroup.diver.setVisibility(0);
        }
        for (; ; ) {
            paramViewGroup.icon.setPadding(0, 14, 0, 0);
            return paramView;
            paramViewGroup = (ThreadViewHolder) paramView.getTag();
            break;
            label219:
            if (((paramForum.isSubscribe) || (ForumStatus.staticCheckLocalSubscribeForum(paramContext, paramLoginStatus.getForumId().intValue(), paramLoginStatus.getUrl()))) && (paramLoginStatus.isLogin())) {
                paramViewGroup.notificationMode.setVisibility(0);
                break label164;
            }
            paramViewGroup.notificationMode.setVisibility(8);
            break label164;
            label291:
            if (paramInt == BOTTOM_FORUM_ITEM) {
                paramViewGroup.forum_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", paramContext));
                paramViewGroup.diver.setVisibility(8);
            } else {
                paramViewGroup.forum_lay.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", paramContext));
                paramViewGroup.diver.setVisibility(0);
            }
        }
    }

    public void addChildForum(Forum paramForum) {
        if (this.childForums == null) {
            this.childForums = new ArrayList();
        }
        this.childForums.add(paramForum);
    }

    public boolean equals(Object paramObject) {
        return ((paramObject instanceof Forum)) && (((Forum) paramObject).getId().equals(this.id));
    }

    public ArrayList<Forum> getChildForums() {
        return this.childForums;
    }

    public String getDescription() {
        return this.description;
    }

    public String getForum_image() {
        return this.forum_image;
    }

    public String getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    public String getLogoURL() {
        return this.logoURL;
    }

    public DialogFragment getLongClickDialogFragment(ForumStatus paramForumStatus, final Activity paramActivity, final Handler paramHandler) {
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(paramActivity).setTitle(Forum.this.getName()).setAdapter(this.val$dialogAdapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        if (this.val$dialogAdapter.getItem(paramAnonymous2Int).equalsIgnoreCase(this.val$activity.getString(2131099850))) {
                            this.val$handler.sendEmptyMessage(1);
                        }
                    }
                }).create();
            }
        };
    }

    public Dialog getLongPressDialog(final ForumRootAdapter paramForumRootAdapter, final Activity paramActivity) {
        new ArrayList();
        final ForumDialogAdapter localForumDialogAdapter = new ForumDialogAdapter(paramActivity, this, paramForumRootAdapter.forumStatus);
        new AlertDialog.Builder(paramActivity).setTitle(getName()).setAdapter(localForumDialogAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = localForumDialogAdapter.getItem(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099849))) {
                    Forum.this.subscribeForum(paramForumRootAdapter, paramActivity);
                    return;
                }
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099851))) {
                    Forum.this.markForumRead(paramForumRootAdapter, paramActivity);
                    return;
                }
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099850))) {
                    ((ForumActivityStatus) paramActivity).getForumStatus().removeLocalSubscribeForum(Forum.this.getId());
                    Forum.this.unSubscribeForum(paramForumRootAdapter, paramActivity);
                    return;
                }
                ShortcutUtil.createShortcut(paramActivity, paramForumRootAdapter.forumStatus.getForumId(), Forum.this.getName(), Forum.this.getId());
            }
        }).create();
    }

    public AlertDialog getLongPressDialogFragment(final NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, final Activity paramActivity) {
        final ForumDialogAdapter localForumDialogAdapter = new ForumDialogAdapter(paramActivity, this, paramNewSubscribeForumAndTopicAdapter.forumStatus);
        new AlertDialog.Builder(paramActivity).setTitle(getName()).setAdapter(localForumDialogAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = localForumDialogAdapter.getItem(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099849))) {
                    Forum.this.subscribeForum(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                    return;
                }
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099851))) {
                    Forum.this.markForumRead(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                    return;
                }
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099850))) {
                    ((ForumActivityStatus) paramActivity).getForumStatus().removeLocalSubscribeForum(Forum.this.id);
                    Forum.this.unSubscribeForum(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                    return;
                }
                ShortcutUtil.createShortcut(paramActivity, paramNewSubscribeForumAndTopicAdapter.forumStatus.getForumId(), Forum.this.name, Forum.this.id);
            }
        }).create();
    }

    public DialogFragment getLongPressDialogFragment(final ForumRootAdapter paramForumRootAdapter, final Activity paramActivity) {
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(paramActivity).setTitle(Forum.this.getName()).setAdapter(this.val$dialogAdapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        paramAnonymous2DialogInterface = this.val$dialogAdapter.getItem(paramAnonymous2Int);
                        if (paramAnonymous2DialogInterface.equalsIgnoreCase(this.val$mActivity.getString(2131099849))) {
                            Forum.this.subscribeForum(this.val$mAdapter, this.val$mActivity);
                            return;
                        }
                        if (paramAnonymous2DialogInterface.equalsIgnoreCase(this.val$mActivity.getString(2131099851))) {
                            Forum.this.markForumRead(this.val$mAdapter, this.val$mActivity);
                            return;
                        }
                        if (paramAnonymous2DialogInterface.equalsIgnoreCase(this.val$mActivity.getString(2131099850))) {
                            ((ForumActivityStatus) this.val$mActivity).getForumStatus().removeLocalSubscribeForum(Forum.this.id);
                            Forum.this.unSubscribeForum(this.val$mAdapter, this.val$mActivity);
                            return;
                        }
                        ShortcutUtil.createShortcut(this.val$mActivity, this.val$mAdapter.forumStatus.getForumId(), Forum.this.name, Forum.this.id);
                    }
                }).create();
            }
        };
    }

    public String getName() {
        return this.name;
    }

    public int getNotification_mode() {
        return this.notification_mode;
    }

    public Forum getParentForum() {
        return this.parentForum;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCanSubscribe() {
        return this.canSubscribe;
    }

    public boolean isHas_notification_mode() {
        return this.has_notification_mode;
    }

    public boolean isLink() {
        return this.isLink;
    }

    public boolean isProtected() {
        return this.isProtected;
    }

    public boolean isSubOnly() {
        return this.subOnly;
    }

    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public void markForumRead(final ForumRootAdapter paramForumRootAdapter, final Activity paramActivity) {
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(getActivity()).setMessage(paramActivity.getString(2131099971)).setPositiveButton(paramActivity.getString(2131099792), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        this.val$adapter.setTryTwice(false);
                        paramAnonymous2DialogInterface = new ArrayList();
                        paramAnonymous2DialogInterface.add(Forum.this.id);
                        if ((this.val$adapter instanceof SubForumAdapter)) {
                            ((SubForumAdapter) this.val$adapter).getCurAdapter().cleanNewPost();
                        }
                        this.val$adapter.getEngine().call("mark_all_as_read", paramAnonymous2DialogInterface);
                        this.val$adapter.forumStatus.cleanNewPost(Forum.this.id);
                        if ((this.val$adapter instanceof SubForumAdapter)) {
                            ((SubForumAdapter) this.val$adapter).getCurAdapter().notifyDataSetChanged();
                        }
                        for (; ; ) {
                            Toast.makeText(this.val$context, String.format(this.val$context.getString(2131099970), new Object[]{Forum.this.getName()}), 1).show();
                            if ((this.val$context instanceof SlidingMenuActivity)) {
                                ((SlidingMenuActivity) this.val$context).getUnreadNumbers();
                            }
                            return;
                            this.val$adapter.notifyDataSetChanged();
                        }
                    }
                }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                    }
                }).create();
            }
        }.show(((FragmentActivity) paramActivity).getSupportFragmentManager(), "");
    }

    public void markForumRead(final NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, final Activity paramActivity) {
        new DialogFragment() {
            public Dialog onCreateDialog(Bundle paramAnonymousBundle) {
                new AlertDialog.Builder(getActivity()).setMessage(paramActivity.getString(2131099971)).setPositiveButton(paramActivity.getString(2131099792), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                        this.val$adapter.getSubscribeForumAndTopicAction().setTryTwice(false);
                        paramAnonymous2DialogInterface = new ArrayList();
                        paramAnonymous2DialogInterface.add(Forum.this.id);
                        this.val$adapter.getSubscribeForumAndTopicAction().getEngine().call("mark_all_as_read", paramAnonymous2DialogInterface);
                        this.val$adapter.forumStatus.cleanNewPost(Forum.this.id);
                        this.val$adapter.notifyDataSetChanged();
                        if ((this.val$context instanceof SlidingMenuActivity)) {
                            ((SlidingMenuActivity) this.val$context).getUnreadNumbers();
                        }
                    }
                }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
                    }
                }).create();
            }
        }.show(((FragmentActivity) paramActivity).getSupportFragmentManager(), "");
    }

    public void markSubForumRead(ForumRootAdapter paramForumRootAdapter, Activity paramActivity) {
        paramForumRootAdapter.setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.id);
        if ((paramForumRootAdapter instanceof SubForumAdapter)) {
            ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().cleanNewPost();
        }
        paramForumRootAdapter.getEngine().call("mark_all_as_read", localArrayList);
        paramForumRootAdapter.forumStatus.cleanNewPost(this.id);
        if ((paramForumRootAdapter instanceof SubForumAdapter)) {
            ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().notifyDataSetChanged();
        }
        for (; ; ) {
            Toast.makeText(paramActivity, String.format(paramActivity.getString(2131099970), new Object[]{getName()}), 1).show();
            if ((paramActivity instanceof SlidingMenuActivity)) {
                ((SlidingMenuActivity) paramActivity).getUnreadNumbers();
            }
            return;
            paramForumRootAdapter.notifyDataSetChanged();
        }
    }

    public void setCanSubscribe(boolean paramBoolean) {
        this.canSubscribe = paramBoolean;
    }

    public void setChildForum(ArrayList<Forum> paramArrayList) {
        this.childForums = paramArrayList;
    }

    public void setDescription(String paramString) {
        this.description = paramString;
    }

    public void setForum_image(String paramString) {
        this.forum_image = paramString;
    }

    public void setHas_notification_mode(boolean paramBoolean) {
        this.has_notification_mode = paramBoolean;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setLevel(int paramInt) {
        this.level = paramInt;
    }

    public void setLink(boolean paramBoolean) {
        this.isLink = paramBoolean;
    }

    public void setLogoURL(String paramString) {
        this.logoURL = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setNotification_mode(int paramInt) {
        this.notification_mode = paramInt;
    }

    public void setParentForum(Forum paramForum) {
        this.parentForum = paramForum;
    }

    public void setParentId(String paramString) {
        this.parentId = paramString;
    }

    public void setProtected(boolean paramBoolean) {
        this.isProtected = paramBoolean;
    }

    public void setSubOnly(boolean paramBoolean) {
        this.subOnly = paramBoolean;
    }

    public void setSubscribe(boolean paramBoolean) {
        this.isSubscribe = paramBoolean;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public void subscribeForum(ForumRootAdapter paramForumRootAdapter, Activity paramActivity) {
        this.isSubscribe = true;
        Object localObject1;
        if ((paramForumRootAdapter.forumStatus.getApiLevel() >= 3) && (isCanSubscribe()) && (!isSubOnly()) && (paramForumRootAdapter.forumStatus.isSubscribeForum())) {
            localObject1 = new ArrayList();
            paramForumRootAdapter.setOpCancel(false);
            ((ArrayList) localObject1).add(this.id);
            paramForumRootAdapter.getEngine().call("subscribe_forum", (ArrayList) localObject1);
            Toast.makeText(paramActivity, String.format(paramActivity.getString(2131099863), new Object[]{getName()}), 1).show();
        }
        new SubscribeForumSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).save(this, paramForumRootAdapter.forumStatus.getUrl());
        Toast.makeText(paramActivity, String.format(paramActivity.getString(2131099863), new Object[]{getName()}), 1).show();
        paramForumRootAdapter.forumStatus.setLocalSubscribeForum(paramActivity);
        Object localObject2;
        String str1;
        String str2;
        if (((paramForumRootAdapter instanceof SubForumAdapter)) && (((SubForumAdapter) paramForumRootAdapter).getCurAdapter() != null)) {
            ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().notifyDataSetChanged();
            SlidingMenuActivity.needRefreshSubscribe = true;
            localObject2 = Prefs.get(paramActivity);
            if ((((SharedPreferences) localObject2).getBoolean("login", false)) && (paramForumRootAdapter.forumStatus != null) && (paramForumRootAdapter.forumStatus.tapatalkForum != null)) {
                paramActivity = new TapatalkJsonEngine(paramActivity, new CallBackInterface() {
                    public void callBack(EngineResponse paramAnonymousEngineResponse) {
                    }

                    public boolean isOpCancel() {
                        return false;
                    }

                    public void setOpCancel(boolean paramAnonymousBoolean) {
                    }

                    public void updateSubclassDialog(int paramAnonymousInt) {
                    }
                });
                localObject1 = ((SharedPreferences) localObject2).getInt("tapatalk_auid", 0);
                localObject2 = ((SharedPreferences) localObject2).getString("token", "");
                str1 = paramForumRootAdapter.forumStatus.tapatalkForum.getId();
                str2 = getId();
                if (!isSubOnly()) {
                    break label375;
                }
            }
        }
        label375:
        for (paramForumRootAdapter = "1"; ; paramForumRootAdapter = "0") {
            paramActivity.addSubscribeForum((String) localObject1, (String) localObject2, str1, str2, paramForumRootAdapter, URLEncoder.encode(getName()));
            return;
            paramForumRootAdapter.notifyDataSetChanged();
            break;
        }
    }

    public void subscribeForum(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Activity paramActivity) {
        this.isSubscribe = true;
        Object localObject1;
        if ((paramNewSubscribeForumAndTopicAdapter.forumStatus.getApiLevel() >= 3) && (isCanSubscribe()) && (!isSubOnly()) && (paramNewSubscribeForumAndTopicAdapter.forumStatus.isSubscribeForum())) {
            localObject1 = new ArrayList();
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
            ((ArrayList) localObject1).add(this.id);
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("subscribe_forum", (ArrayList) localObject1);
            Toast.makeText(paramActivity, String.format(paramActivity.getString(2131099863), new Object[]{getName()}), 1).show();
        }
        new SubscribeForumSqlHelper(paramActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).save(this, paramNewSubscribeForumAndTopicAdapter.forumStatus.getUrl());
        Toast.makeText(paramActivity, String.format(paramActivity.getString(2131099863), new Object[]{getName()}), 1).show();
        paramNewSubscribeForumAndTopicAdapter.forumStatus.setLocalSubscribeForum(paramActivity);
        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
        SlidingMenuActivity.needRefreshSubscribe = true;
        Object localObject2 = Prefs.get(paramActivity);
        String str1;
        String str2;
        if ((((SharedPreferences) localObject2).getBoolean("login", false)) && (paramNewSubscribeForumAndTopicAdapter.forumStatus != null) && (paramNewSubscribeForumAndTopicAdapter.forumStatus.tapatalkForum != null)) {
            paramActivity = new TapatalkJsonEngine(paramActivity, new CallBackInterface() {
                public void callBack(EngineResponse paramAnonymousEngineResponse) {
                }

                public boolean isOpCancel() {
                    return false;
                }

                public void setOpCancel(boolean paramAnonymousBoolean) {
                }

                public void updateSubclassDialog(int paramAnonymousInt) {
                }
            });
            localObject1 = ((SharedPreferences) localObject2).getInt("tapatalk_auid", 0);
            localObject2 = ((SharedPreferences) localObject2).getString("token", "");
            str1 = paramNewSubscribeForumAndTopicAdapter.forumStatus.tapatalkForum.getId();
            str2 = getId();
            if (!isSubOnly()) {
                break label351;
            }
        }
        label351:
        for (paramNewSubscribeForumAndTopicAdapter = "1"; ; paramNewSubscribeForumAndTopicAdapter = "0") {
            paramActivity.addSubscribeForum((String) localObject1, (String) localObject2, str1, str2, paramNewSubscribeForumAndTopicAdapter, URLEncoder.encode(getName()));
            return;
        }
    }

    public void unSubscribeForum(ForumRootAdapter paramForumRootAdapter, Context paramContext) {
        this.isSubscribe = false;
        new SubscribeForumSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).delete(this, paramForumRootAdapter.forumStatus.getUrl());
        paramForumRootAdapter.forumStatus.removeLocalSubscribeForum(getId());
        Object localObject;
        if ((paramForumRootAdapter.forumStatus.getApiLevel() >= 3) && (paramForumRootAdapter.forumStatus.isSubscribeForum())) {
            localObject = new ArrayList();
            ((ArrayList) localObject).add(getId());
            paramForumRootAdapter.getEngine().call("unsubscribe_forum", (ArrayList) localObject);
        }
        paramForumRootAdapter.forumStatus.setLocalSubscribeForum(paramContext);
        if (((paramForumRootAdapter instanceof SubForumAdapter)) && (((SubForumAdapter) paramForumRootAdapter).getCurAdapter() != null)) {
            ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().notifyDataSetChanged();
        }
        for (; ; ) {
            SlidingMenuActivity.needRefreshSubscribe = true;
            localObject = Prefs.get(paramContext);
            if ((((SharedPreferences) localObject).getBoolean("login", false)) && (paramForumRootAdapter.forumStatus != null) && (paramForumRootAdapter.forumStatus.tapatalkForum != null)) {
                new TapatalkJsonEngine(paramContext, new CallBackInterface() {
                    public void callBack(EngineResponse paramAnonymousEngineResponse) {
                    }

                    public boolean isOpCancel() {
                        return false;
                    }

                    public void setOpCancel(boolean paramAnonymousBoolean) {
                    }

                    public void updateSubclassDialog(int paramAnonymousInt) {
                    }
                }).delSubscribeForum(((SharedPreferences) localObject).getInt("tapatalk_auid", 0), ((SharedPreferences) localObject).getString("token", ""), paramForumRootAdapter.forumStatus.tapatalkForum.getId(), getId());
            }
            return;
            if ((paramForumRootAdapter instanceof SubscribeForumAndTopicAdapter)) {
                if ((((SubscribeForumAndTopicAdapter) paramForumRootAdapter).mDatas != null) && (((SubscribeForumAndTopicAdapter) paramForumRootAdapter).mDatas.contains(this))) {
                    ((SubscribeForumAndTopicAdapter) paramForumRootAdapter).mDatas.remove(this);
                    if (((SubscribeForumAndTopicAdapter) paramForumRootAdapter).mDatas.size() == 0) {
                        ((SubscribeForumAndTopicAdapter) paramForumRootAdapter).mDatas.add(new NoTopicView());
                    }
                    paramForumRootAdapter.notifyDataSetChanged();
                }
            } else {
                paramForumRootAdapter.notifyDataSetChanged();
            }
        }
    }

    public void unSubscribeForum(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext) {
        this.isSubscribe = false;
        new SubscribeForumSqlHelper(paramContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).delete(this, paramNewSubscribeForumAndTopicAdapter.forumStatus.getUrl());
        paramNewSubscribeForumAndTopicAdapter.forumStatus.removeLocalSubscribeForum(getId());
        if ((paramNewSubscribeForumAndTopicAdapter.forumStatus.getApiLevel() >= 3) && (paramNewSubscribeForumAndTopicAdapter.forumStatus.isSubscribeForum())) {
            localObject = new ArrayList();
            ((ArrayList) localObject).add(getId());
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("unsubscribe_forum", (ArrayList) localObject);
        }
        paramNewSubscribeForumAndTopicAdapter.forumStatus.setLocalSubscribeForum(paramContext);
        if ((paramNewSubscribeForumAndTopicAdapter.forumDatas != null) && (paramNewSubscribeForumAndTopicAdapter.forumDatas.contains(this))) {
            paramNewSubscribeForumAndTopicAdapter.forumDatas.remove(this);
            paramNewSubscribeForumAndTopicAdapter.removeForumsItem(this);
            paramNewSubscribeForumAndTopicAdapter.forumDatas.size();
            paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
        }
        SlidingMenuActivity.needRefreshSubscribe = true;
        Object localObject = Prefs.get(paramContext);
        if ((((SharedPreferences) localObject).getBoolean("login", false)) && (paramNewSubscribeForumAndTopicAdapter.forumStatus != null) && (paramNewSubscribeForumAndTopicAdapter.forumStatus.tapatalkForum != null)) {
            new TapatalkJsonEngine(paramContext, new CallBackInterface() {
                public void callBack(EngineResponse paramAnonymousEngineResponse) {
                }

                public boolean isOpCancel() {
                    return false;
                }

                public void setOpCancel(boolean paramAnonymousBoolean) {
                }

                public void updateSubclassDialog(int paramAnonymousInt) {
                }
            }).delSubscribeForum(((SharedPreferences) localObject).getInt("tapatalk_auid", 0), ((SharedPreferences) localObject).getString("token", ""), paramNewSubscribeForumAndTopicAdapter.forumStatus.tapatalkForum.getId(), getId());
        }
    }

    private static class ThreadViewHolder {
        ImageView diver;
        RelativeLayout forum_lay;
        ImageView icon;
        public ImageView notificationMode;
        TextView text;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Forum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */