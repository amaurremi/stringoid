package com.quoord.DialogUtil;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.activity.forum.BanUserActivity;
import com.quoord.tapatalkpro.activity.forum.EditTopicTitleActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewSubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubForumAdapter;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.adapter.forum.TopicAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.net.HashUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ModerationDialogAdapter
        extends BaseAdapter {
    private Activity mContext;
    private ArrayList<String> mMenuArray = new ArrayList();
    private String mUser;

    public ModerationDialogAdapter(Activity paramActivity, PostData paramPostData, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        this.mUser = paramPostData.getRealName();
        if (paramPostData.canEdit) {
            this.mMenuArray.add(paramActivity.getString(2131100098));
        }
        if (paramPostData.canDelete) {
            if (paramPostData.isDeleted) {
                this.mMenuArray.add(paramActivity.getString(2131100035));
            }
        } else if (paramPostData.canApprove) {
            if (!paramPostData.isApprove) {
                break label197;
            }
            this.mMenuArray.add(paramActivity.getString(2131100037));
        }
        for (; ; ) {
            if ((paramPostData.canBan) && (!paramPostData.isBan)) {
                this.mMenuArray.add(paramActivity.getString(2131100057) + " " + paramPostData.getRealName());
            }
            if (paramPostData.canMove) {
                this.mMenuArray.add(paramActivity.getString(2131100062));
            }
            return;
            this.mMenuArray.add(paramActivity.getString(2131100034));
            break;
            label197:
            this.mMenuArray.add(paramActivity.getString(2131100036));
        }
    }

    public ModerationDialogAdapter(Activity paramActivity, Topic paramTopic, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        this.mUser = paramTopic.getRealName();
        if (paramTopic.isCanStick()) {
            if (!paramTopic.isSticked()) {
                this.mMenuArray.add(this.mContext.getString(2131100014));
            }
        } else {
            if (paramTopic.isCanDelete()) {
                if (!paramTopic.isDeleted()) {
                    break label355;
                }
                this.mMenuArray.add(this.mContext.getString(2131100017));
            }
            label90:
            if (paramTopic.isCanApprove()) {
                if (!paramTopic.isApproved()) {
                    break label375;
                }
                this.mMenuArray.add(this.mContext.getString(2131100018));
            }
            label121:
            if (paramTopic.isCanClose()) {
                if (!paramTopic.isClosed()) {
                    break label395;
                }
                this.mMenuArray.add(this.mContext.getString(2131100020));
            }
        }
        for (; ; ) {
            if ((paramTopic.isCanMerge()) && (!paramTopic.isRedirect()) && (paramTopic.isShowMergeTopic) && ((this.mContext instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.mContext).currentTabMenuId == 1018)) {
                this.mMenuArray.add(this.mContext.getString(2131100746));
            }
            if (paramTopic.isCanMove()) {
                this.mMenuArray.add(this.mContext.getString(2131100062));
            }
            if ((paramTopic.isCanBan()) && (!paramForumStatus.getUser().equals(paramTopic.getRealName())) && (!paramTopic.isBan())) {
                this.mMenuArray.add(this.mContext.getString(2131100057) + " " + paramTopic.getRealName());
            }
            if (paramTopic.isCanRename()) {
                this.mMenuArray.add(this.mContext.getString(2131100273));
            }
            return;
            this.mMenuArray.add(this.mContext.getString(2131100015));
            break;
            label355:
            this.mMenuArray.add(this.mContext.getString(2131100016));
            break label90;
            label375:
            this.mMenuArray.add(this.mContext.getString(2131100019));
            break label121;
            label395:
            this.mMenuArray.add(this.mContext.getString(2131100021));
        }
    }

    private static void editTitle(Activity paramActivity, ForumStatus paramForumStatus, Object paramObject, Topic paramTopic) {
        Object localObject3 = null;
        int j = -1;
        paramForumStatus = paramTopic.getPrefix().trim();
        Object localObject1 = paramForumStatus;
        if (paramForumStatus.startsWith("[")) {
            localObject1 = paramForumStatus;
            if (paramForumStatus.endsWith("]")) {
                localObject1 = paramForumStatus.substring(1, paramForumStatus.length() - 1);
            }
        }
        paramForumStatus = null;
        boolean bool = false;
        Object localObject2;
        int i;
        if ((paramObject instanceof SubForumAdapter)) {
            paramForumStatus = ((SubForumAdapter) paramObject).getCurAdapter().getTopicAction.mPrefixes;
            bool = ((SubForumAdapter) paramObject).getCurAdapter().getTopicAction.requiredPrefix();
            localObject2 = localObject3;
            i = j;
            if (paramForumStatus != null) {
                localObject2 = localObject3;
                i = j;
                if (paramForumStatus.size() > 0) {
                    i = 0;
                    label122:
                    if (i < paramForumStatus.size()) {
                        break label289;
                    }
                    i = j;
                    label135:
                    j = i;
                    if (i == -1) {
                        bool = false;
                        j = 0;
                    }
                    localObject2 = GetTopicAction.getPrefixForCreateTopic(paramActivity, paramForumStatus, bool);
                    i = j;
                }
            }
            paramForumStatus = new Intent();
            paramForumStatus.setClass(paramActivity, EditTopicTitleActivity.class);
            if (!(paramObject instanceof ForumRootAdapter)) {
                break label330;
            }
            paramForumStatus.putExtra("forumStatus", ((ForumRootAdapter) paramObject).forumStatus);
        }
        for (; ; ) {
            paramForumStatus.putExtra("topic", paramTopic);
            paramForumStatus.putExtra("modifytype", 53328);
            paramForumStatus.putExtra("prefixes", (Serializable) localObject2);
            paramForumStatus.putExtra("prefixIndex", i);
            paramActivity.startActivityForResult(paramForumStatus, 53328);
            return;
            if (!(paramObject instanceof ThreadAdapter)) {
                break;
            }
            paramForumStatus = ((ThreadAdapter) paramObject).mOutFragment.mTopic.getPrefixes();
            bool = ((ThreadAdapter) paramObject).mOutFragment.mTopic.requiredPrefix();
            break;
            label289:
            if (((String) localObject1).equals(HashUtil.getString(((HashMap) paramForumStatus.get(i)).get("prefix_display_name"), ""))) {
                break label135;
            }
            i += 1;
            break label122;
            label330:
            if ((paramObject instanceof NewSubscribeForumAndTopicAdapter)) {
                paramForumStatus.putExtra("forumStatus", ((NewSubscribeForumAndTopicAdapter) paramObject).forumStatus);
            }
        }
    }

    public static Dialog getEditTitleDialog(final Activity paramActivity, ForumStatus paramForumStatus, final ForumRootAdapter paramForumRootAdapter, final Topic paramTopic) {
        paramForumStatus = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903362, null);
        final EditText localEditText = (EditText) paramForumStatus.getChildAt(0);
        localEditText.setText(paramTopic.getTitle());
        localEditText.requestFocus();
        new AlertDialog.Builder(paramActivity).setTitle(paramTopic.getTitle()).setView(paramForumStatus).setCancelable(false).setPositiveButton(paramActivity.getString(2131099792), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (ModerationDialogAdapter.this.getText().length() == 0) {
                    Toast.makeText(paramActivity, paramActivity.getString(2131100788), 1).show();
                }
                for (; ; ) {
                    ((InputMethodManager) paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(ModerationDialogAdapter.this.getWindowToken(), 0);
                    return;
                    Toast.makeText(paramActivity, paramActivity.getString(2131100274), 1).show();
                    paramTopic.rename(paramForumRootAdapter, paramActivity, ModerationDialogAdapter.this.getText().toString());
                }
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                ((InputMethodManager) ModerationDialogAdapter.this.getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
            }
        }).create();
    }

    public static Dialog getEditTitleDialog(final Activity paramActivity, ForumStatus paramForumStatus, final NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, final Topic paramTopic) {
        paramForumStatus = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903362, null);
        final EditText localEditText = (EditText) paramForumStatus.getChildAt(0);
        localEditText.setText(paramTopic.getTitle());
        localEditText.requestFocus();
        new AlertDialog.Builder(paramActivity).setTitle(paramTopic.getTitle()).setView(paramForumStatus).setCancelable(false).setPositiveButton(paramActivity.getString(2131099792), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (ModerationDialogAdapter.this.getText().length() == 0) {
                    Toast.makeText(paramActivity, paramActivity.getString(2131100788), 1).show();
                }
                for (; ; ) {
                    ((InputMethodManager) paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(ModerationDialogAdapter.this.getWindowToken(), 0);
                    return;
                    Toast.makeText(paramActivity, paramActivity.getString(2131100274), 1).show();
                    paramTopic.rename(paramNewSubscribeForumAndTopicAdapter, paramActivity, ModerationDialogAdapter.this.getText().toString());
                }
            }
        }).setNegativeButton(paramActivity.getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                ((InputMethodManager) ModerationDialogAdapter.this.getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
            }
        }).create();
    }

    public static Dialog getModerateDialog(final Activity paramActivity, final ForumStatus paramForumStatus, final ForumRootAdapter paramForumRootAdapter, final Topic paramTopic) {
        ModerationDialogAdapter localModerationDialogAdapter = new ModerationDialogAdapter(paramActivity, paramTopic, paramForumStatus);
        new AlertDialog.Builder(paramActivity).setTitle(paramTopic.getTitle()).setAdapter(localModerationDialogAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = ModerationDialogAdapter.this.getItem(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100014))) {
                    paramTopic.stickyTopic(paramForumRootAdapter, paramActivity);
                    paramTopic.setSticked(true);
                }
                do {
                    return;
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100015))) {
                        paramTopic.unstickyTopic(paramForumRootAdapter, paramActivity);
                        paramTopic.setSticked(false);
                        paramForumRootAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100017))) {
                        if ((paramTopic.getPostId() != null) && (!paramTopic.getPostId().equals(""))) {
                            paramTopic.unDeletePost(paramForumRootAdapter, paramActivity);
                        }
                        for (; ; ) {
                            paramForumRootAdapter.notifyDataSetChanged();
                            return;
                            paramTopic.unDeleteTopic(paramForumRootAdapter, paramActivity);
                        }
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100016))) {
                        DialogUtil.getDeleteDialog(paramActivity, paramForumStatus, paramTopic, paramForumRootAdapter).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100019))) {
                        if ((paramTopic.getPostId() != null) && (!paramTopic.getPostId().equals(""))) {
                            paramTopic.approvePost(paramForumRootAdapter, paramActivity, true);
                        }
                        for (; ; ) {
                            paramForumRootAdapter.notifyDataSetChanged();
                            return;
                            paramTopic.approveTopic(paramForumRootAdapter, paramActivity, true);
                        }
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100018))) {
                        if ((paramTopic.getPostId() != null) && (!paramTopic.getPostId().equals(""))) {
                            paramTopic.approvePost(paramForumRootAdapter, paramActivity, false);
                        }
                        for (; ; ) {
                            paramForumRootAdapter.notifyDataSetChanged();
                            return;
                            paramTopic.approveTopic(paramForumRootAdapter, paramActivity, false);
                        }
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100020))) {
                        paramTopic.closeTopic(paramForumRootAdapter, paramActivity, false);
                        paramTopic.setClosed(false);
                        paramForumRootAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100021))) {
                        paramTopic.closeTopic(paramForumRootAdapter, paramActivity, true);
                        paramTopic.setClosed(true);
                        paramForumRootAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100054))) {
                        paramTopic.actionShareTopic(paramForumRootAdapter.forumStatus, paramActivity);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100057) + " " + paramTopic.getRealName())) {
                        paramAnonymousDialogInterface = new Intent(paramActivity, BanUserActivity.class);
                        paramAnonymousDialogInterface.putExtra("username", paramTopic.getRealName());
                        paramAnonymousDialogInterface.putExtra("forumStatus", paramForumStatus);
                        paramAnonymousDialogInterface.putExtra("isBan", false);
                        paramActivity.startActivity(paramAnonymousDialogInterface);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100062))) {
                        paramAnonymousDialogInterface = new Intent();
                        paramAnonymousDialogInterface.setClass(paramActivity, ModerateActivity.class);
                        paramAnonymousDialogInterface.putExtra("forumStatus", paramForumRootAdapter.forumStatus);
                        paramAnonymousDialogInterface.putExtra("topic", paramTopic);
                        paramAnonymousDialogInterface.putExtra("select_forum_action", 2);
                        paramActivity.startActivityForResult(paramAnonymousDialogInterface, 21);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100067))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramForumRootAdapter, paramTopic).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100102))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramForumRootAdapter, paramTopic).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100273))) {
                        ModerationDialogAdapter.editTitle(paramActivity, paramForumStatus, paramForumRootAdapter, paramTopic);
                        return;
                    }
                } while (!paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100746)));
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.setClass(paramActivity, ModerateActivity.class);
                paramAnonymousDialogInterface.putExtra("forumStatus", paramForumStatus);
                paramAnonymousDialogInterface.putExtra("topic", paramTopic);
                paramAnonymousDialogInterface.putExtra("select_forum_action", 4);
                paramActivity.startActivityForResult(paramAnonymousDialogInterface, 601);
            }
        }).create();
    }

    public static Dialog getModerateDialog(final Activity paramActivity, final ForumStatus paramForumStatus, final NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, final Topic paramTopic) {
        ModerationDialogAdapter localModerationDialogAdapter = new ModerationDialogAdapter(paramActivity, paramTopic, paramForumStatus);
        new AlertDialog.Builder(paramActivity).setTitle(paramTopic.getTitle()).setAdapter(localModerationDialogAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = ModerationDialogAdapter.this.getItem(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100014))) {
                    paramTopic.stickyTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                    paramTopic.setSticked(true);
                }
                do {
                    return;
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100015))) {
                        paramTopic.unstickyTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                        paramTopic.setSticked(false);
                        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100017))) {
                        if ((paramTopic.getPostId() != null) && (!paramTopic.getPostId().equals(""))) {
                            paramTopic.unDeletePost(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                        }
                        for (; ; ) {
                            paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                            return;
                            paramTopic.unDeleteTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                        }
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100016))) {
                        DialogUtil.getDeleteDialog(paramActivity, paramForumStatus, paramTopic, paramNewSubscribeForumAndTopicAdapter).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100019))) {
                        if ((paramTopic.getPostId() != null) && (!paramTopic.getPostId().equals(""))) {
                            paramTopic.approvePost(paramNewSubscribeForumAndTopicAdapter, paramActivity, true);
                        }
                        for (; ; ) {
                            paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                            return;
                            paramTopic.approveTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity, true);
                        }
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100018))) {
                        if ((paramTopic.getPostId() != null) && (!paramTopic.getPostId().equals(""))) {
                            paramTopic.approvePost(paramNewSubscribeForumAndTopicAdapter, paramActivity, false);
                        }
                        for (; ; ) {
                            paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                            return;
                            paramTopic.approveTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity, false);
                        }
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100020))) {
                        paramTopic.closeTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity, false);
                        paramTopic.setClosed(false);
                        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100021))) {
                        paramTopic.closeTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity, true);
                        paramTopic.setClosed(true);
                        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100054))) {
                        paramTopic.actionShareTopic(paramNewSubscribeForumAndTopicAdapter.forumStatus, paramActivity);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100057) + " " + paramTopic.getRealName())) {
                        DialogUtil.getBanDialog(paramActivity, paramForumStatus, paramTopic.getRealName(), paramNewSubscribeForumAndTopicAdapter).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100062))) {
                        paramAnonymousDialogInterface = new Intent();
                        paramAnonymousDialogInterface.setClass(paramActivity, ModerateActivity.class);
                        paramAnonymousDialogInterface.putExtra("forumStatus", paramNewSubscribeForumAndTopicAdapter.forumStatus);
                        paramAnonymousDialogInterface.putExtra("topic", paramTopic);
                        paramAnonymousDialogInterface.putExtra("select_forum_action", 2);
                        paramActivity.startActivityForResult(paramAnonymousDialogInterface, 21);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100067))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramNewSubscribeForumAndTopicAdapter, paramTopic).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100102))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramNewSubscribeForumAndTopicAdapter, paramTopic).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100273))) {
                        ModerationDialogAdapter.editTitle(paramActivity, paramForumStatus, paramNewSubscribeForumAndTopicAdapter, paramTopic);
                        return;
                    }
                } while (!paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100746)));
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.setClass(paramActivity, ModerateActivity.class);
                paramAnonymousDialogInterface.putExtra("forumStatus", paramForumStatus);
                paramAnonymousDialogInterface.putExtra("topic", paramTopic);
                paramAnonymousDialogInterface.putExtra("select_forum_action", 4);
                paramActivity.startActivityForResult(paramAnonymousDialogInterface, 601);
            }
        }).create();
    }

    public int getCount() {
        return this.mMenuArray.size();
    }

    public String getItem(int paramInt) {
        return (String) this.mMenuArray.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
        paramView.setText((CharSequence) this.mMenuArray.get(paramInt));
        paramView.setCompoundDrawablePadding(5);
        if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100014))) {
            paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_stick", this.mContext), 0, 0, 0);
        }
        do {
            return paramView;
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100015))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_unstick", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100016))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_delete", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100057) + " " + this.mUser)) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_ban", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100062))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_move", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100021))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_lock", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100020))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_open", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100017))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_delete", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100019))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_approve", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100018))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_unapprove", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100098))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_edit", this.mContext), 0, 0, 0);
                return paramView;
            }
            if (((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100273))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_rename", this.mContext), 0, 0, 0);
                return paramView;
            }
        } while (!((String) this.mMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100746)));
        paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_merge", this.mContext), 0, 0, 0);
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/ModerationDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */