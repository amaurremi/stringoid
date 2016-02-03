package com.quoord.tapatalkpro.bean;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.quoord.DialogUtil.ModerationDialogAdapter;
import com.quoord.DialogUtil.TopicDialogAdapter;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkpro.action.SubscribeForumAndTopicAction;
import com.quoord.tapatalkpro.action.TopicAction;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewSubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubForumAdapter;
import com.quoord.tapatalkpro.adapter.forum.SubscribeForumAndTopicAdapter;
import com.quoord.tapatalkpro.adapter.forum.TopicAdapter;
import com.quoord.tapatalkpro.feed.FeedListAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment.ChangeUnreadNumbers;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.ListItemRemoveAnimatorController;
import com.quoord.tapatalkpro.ui.ThreadQuoteHelper;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.NewTitleTextView;
import com.quoord.tapatalkpro.view.ShortContentView;
import com.quoord.tools.ImageTools;
import com.quoord.tools.LoginStatus;
import com.quoord.tools.bitmap.ui.GifImageView;
import com.quoord.tools.net.TapatalkAjaxLogAction;
import com.quoord.tools.net.TapatalkLogUrlUtil;
import com.quoord.tools.roundedimageview.RoundedImageView;
import com.wbtech.ums.UmsAgent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Topic
        extends BaseBean
        implements Serializable, ListItemClickable {
    public static final String ISSUBSCRIBEEDTAB = "isSubscribedTab";
    public static final String SHOWFORUMNAME = "showForumName";
    public static final String SHOWREPLYNUM = "showreplynum";
    public static final String SHOWSELECTBG = "showSelectBg";
    private static final long serialVersionUID = -6922031442523626122L;
    private int attachment_flag = 0;
    public String authorDisplayName;
    private String authorId;
    public String authorName;
    private boolean canApprove = false;
    private boolean canBan = false;
    private boolean canClose = false;
    private boolean canDelete = false;
    private boolean canMerge = false;
    private boolean canMove = false;
    private boolean canPost = false;
    private boolean canRename = false;
    private boolean canStick = false;
    private boolean canSubscribe = true;
    private boolean canUpload = true;
    private Forum forum;
    private String forumId = "";
    private String forumName = "";
    private String forumUrl = "";
    private boolean has_notification_mode = false;
    private String icon_url;
    private String id = "";
    private boolean isAnn = false;
    private boolean isApproved = true;
    private boolean isBan = false;
    private boolean isClosed = false;
    private boolean isDeleted = false;
    private boolean isMerged = false;
    private boolean isMoved = false;
    private boolean isRedirect = false;
    public boolean isShowMergeTopic = false;
    private boolean isSticked = false;
    private boolean isSubscribe = false;
    private boolean isThumbUp;
    private String lastPosterDisplayName;
    private String lastPosterId;
    private String lastPosterName;
    private Date lastReplyTime;
    private String lastReplyTimeString;
    private String localIconUri = null;
    private LoginStatus loginStatus;
    private Context mContext = null;
    private boolean newPost;
    private String openMode = null;
    private String postId;
    private String prefix;
    private ArrayList<HashMap<String, Object>> prefixes = null;
    private String real_topic_id = "";
    private int replyCount = 0;
    private boolean requiredPrefix = false;
    private String shortContent = "";
    private String tapatalkForumId = "";
    private String tapatalkForumName = "";
    private int thumbCount;
    private int thumbType;
    private int timeStamp;
    private String title = "";
    private String topicImgUrl;
    private int viewCount = 0;

    public static Topic createTopicBean(HashMap paramHashMap, Context paramContext) {
        if (paramHashMap == null) {
            paramContext = null;
            return paramContext;
        }
        localTopic = new Topic();
        localTopic.setForumId((String) paramHashMap.get("forum_id"));
        localTopic.setPostId((String) paramHashMap.get("post_id"));
        localTopic.setId((String) paramHashMap.get("topic_id"));
        localTopic.setReal_topic_id((String) paramHashMap.get("real_topic_id"));
        if (paramHashMap.containsKey("time_string")) {
            localTopic.setTimeString(new String((byte[]) paramHashMap.get("time_string")));
        }
        if ((Date) paramHashMap.get("post_time") != null) {
            localTopic.setLastReplyTime((Date) paramHashMap.get("post_time"), paramContext);
        }
        for (; ; ) {
            if (paramHashMap.containsKey("new_post")) {
                localTopic.setNewPost(((Boolean) paramHashMap.get("new_post")).booleanValue());
            }
            if (paramHashMap.containsKey("icon_url")) {
                localTopic.setIconUrl(paramHashMap.get("icon_url").toString());
                localTopic.setLocalIconUri(paramHashMap.get("icon_url").toString());
            }
            paramContext = (Integer) paramHashMap.get("reply_number");
            if (paramContext != null) {
                localTopic.setReplyCount(paramContext.intValue());
            }
            try {
                localTopic.setShortContent(new String((byte[]) paramHashMap.get("short_content"), "UTF-8"));
                localTopic.setTitle(new String((byte[]) paramHashMap.get("topic_title"), "UTF-8"));
                if (paramHashMap.get("post_author_name") != null) {
                    localTopic.setAuthorName(new String((byte[]) paramHashMap.get("post_author_name"), "UTF-8"));
                }
                if (paramHashMap.get("topic_title") != null) {
                    localTopic.setTitle(new String((byte[]) paramHashMap.get("topic_title"), "UTF-8"));
                }
                if (paramHashMap.get("forum_name") != null) {
                    localTopic.setForumName(new String((byte[]) paramHashMap.get("forum_name"), "UTF-8"));
                }
                if (paramHashMap.get("post_author_display_name") != null) {
                    localTopic.setAuthorDisplayName(new String((byte[]) paramHashMap.get("post_author_display_name"), "UTF-8"));
                }
            } catch (UnsupportedEncodingException paramContext) {
                for (; ; ) {
                    paramContext.printStackTrace();
                    continue;
                    if (paramHashMap.containsKey("is_subscribed")) {
                        localTopic.setSubscribe(((Boolean) paramHashMap.get("is_subscribed")).booleanValue());
                    } else {
                        localTopic.setSubscribe(false);
                        continue;
                        localTopic.setDeleted(false);
                        continue;
                        localTopic.setCanDelete(false);
                        continue;
                        localTopic.setCanApprove(false);
                        continue;
                        localTopic.setApproved(true);
                        continue;
                        localTopic.setClosed(false);
                        continue;
                        localTopic.setCanClose(false);
                        continue;
                        localTopic.setCanBan(false);
                        continue;
                        localTopic.setBan(false);
                        continue;
                        localTopic.setCanMove(false);
                        continue;
                        if (paramHashMap.containsKey("can_sticky")) {
                            localTopic.setCanStick(((Boolean) paramHashMap.get("can_sticky")).booleanValue());
                        } else {
                            localTopic.setCanStick(false);
                            continue;
                            localTopic.setCanMerge(false);
                            continue;
                            localTopic.setCanRename(false);
                        }
                    }
                }
            }
            if (!paramHashMap.containsKey("issubscribed")) {
                break label1103;
            }
            localTopic.setSubscribe(((Boolean) paramHashMap.get("issubscribed")).booleanValue());
            if (!paramHashMap.containsKey("is_deleted")) {
                break label1141;
            }
            localTopic.setDeleted(((Boolean) paramHashMap.get("is_deleted")).booleanValue());
            if (!paramHashMap.containsKey("can_delete")) {
                break label1149;
            }
            localTopic.setCanDelete(((Boolean) paramHashMap.get("can_delete")).booleanValue());
            if (!paramHashMap.containsKey("can_approve")) {
                break label1157;
            }
            localTopic.setCanApprove(((Boolean) paramHashMap.get("can_approve")).booleanValue());
            if (!paramHashMap.containsKey("is_approved")) {
                break label1165;
            }
            localTopic.setApproved(((Boolean) paramHashMap.get("is_approved")).booleanValue());
            if (paramHashMap.containsKey("attachment")) {
                localTopic.setAttachFlag(Integer.parseInt((String) paramHashMap.get("attachment")));
            }
            if (paramHashMap.containsKey("can_subscribe")) {
                localTopic.setCanSubscribe(((Boolean) paramHashMap.get("can_subscribe")).booleanValue());
            }
            if (paramHashMap.containsKey("issubscribed")) {
                localTopic.setSubscribe(((Boolean) paramHashMap.get("issubscribed")).booleanValue());
            }
            if (!paramHashMap.containsKey("is_closed")) {
                break label1173;
            }
            localTopic.setClosed(((Boolean) paramHashMap.get("is_closed")).booleanValue());
            if (!paramHashMap.containsKey("can_close")) {
                break label1181;
            }
            localTopic.setCanClose(((Boolean) paramHashMap.get("can_close")).booleanValue());
            if (!paramHashMap.containsKey("can_ban")) {
                break label1189;
            }
            localTopic.setCanBan(((Boolean) paramHashMap.get("can_ban")).booleanValue());
            if (!paramHashMap.containsKey("is_ban")) {
                break label1197;
            }
            localTopic.setBan(((Boolean) paramHashMap.get("is_ban")).booleanValue());
            if (!paramHashMap.containsKey("can_move")) {
                break label1205;
            }
            localTopic.setCanMove(((Boolean) paramHashMap.get("can_move")).booleanValue());
            if (!paramHashMap.containsKey("can_stick")) {
                break label1213;
            }
            localTopic.setCanStick(((Boolean) paramHashMap.get("can_stick")).booleanValue());
            if (!paramHashMap.containsKey("can_merge")) {
                break label1251;
            }
            localTopic.setCanMerge(((Boolean) paramHashMap.get("can_merge")).booleanValue());
            if (!paramHashMap.containsKey("can_rename")) {
                break label1259;
            }
            localTopic.setCanRename(((Boolean) paramHashMap.get("can_rename")).booleanValue());
            if (paramHashMap.containsKey("is_sticky")) {
                localTopic.setSticked(((Boolean) paramHashMap.get("is_sticky")).booleanValue());
            }
            if (paramHashMap.equals("view_number")) {
                localTopic.setViewCount(Integer.parseInt((String) paramHashMap.get("view_number")));
            }
            if (paramHashMap.containsKey("fid")) {
                localTopic.setTapatalkForumId((String) paramHashMap.get("fid"));
            }
            if (paramHashMap.containsKey("fname")) {
                localTopic.setTapatalkForumName((String) paramHashMap.get("fname"));
            }
            if (paramHashMap.containsKey("topic_image")) {
                localTopic.setTopicImgUrl((String) paramHashMap.get("topic_image"));
            }
            if (paramHashMap.containsKey("is_moved")) {
                localTopic.setMoved(((Boolean) paramHashMap.get("is_moved")).booleanValue());
                if (((Boolean) paramHashMap.get("is_moved")).booleanValue()) {
                    localTopic.setRedirect(true);
                }
            }
            if (paramHashMap.containsKey("is_merged")) {
                localTopic.setMerged(((Boolean) paramHashMap.get("is_merged")).booleanValue());
                if (((Boolean) paramHashMap.get("is_merged")).booleanValue()) {
                    localTopic.setRedirect(true);
                }
            }
            paramContext = localTopic;
            if (!paramHashMap.containsKey("real_topic_id")) {
                break;
            }
            localTopic.setReal_topic_id((String) paramHashMap.get("real_topic_id"));
            return localTopic;
            localTopic.setLastReplyTime((Date) paramHashMap.get("last_reply_time"), paramContext);
        }
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        this.forumName = ((String) paramObjectInputStream.readObject());
        this.id = ((String) paramObjectInputStream.readObject());
        this.prefix = ((String) paramObjectInputStream.readObject());
        this.authorId = ((String) paramObjectInputStream.readObject());
        this.lastReplyTime = ((Date) paramObjectInputStream.readObject());
        this.lastPosterId = ((String) paramObjectInputStream.readObject());
        this.lastPosterName = ((String) paramObjectInputStream.readObject());
        this.shortContent = ((String) paramObjectInputStream.readObject());
        this.title = ((String) paramObjectInputStream.readObject());
        this.authorName = ((String) paramObjectInputStream.readObject());
        this.icon_url = ((String) paramObjectInputStream.readObject());
        this.authorDisplayName = ((String) paramObjectInputStream.readObject());
        this.lastPosterDisplayName = ((String) paramObjectInputStream.readObject());
        this.localIconUri = ((String) paramObjectInputStream.readObject());
        this.lastReplyTimeString = ((String) paramObjectInputStream.readObject());
        this.replyCount = paramObjectInputStream.readInt();
        this.viewCount = paramObjectInputStream.readInt();
        this.attachment_flag = paramObjectInputStream.readInt();
        this.newPost = paramObjectInputStream.readBoolean();
        this.isSubscribe = paramObjectInputStream.readBoolean();
        this.canSubscribe = paramObjectInputStream.readBoolean();
        this.canUpload = paramObjectInputStream.readBoolean();
        this.isSticked = paramObjectInputStream.readBoolean();
        this.canStick = paramObjectInputStream.readBoolean();
        this.canDelete = paramObjectInputStream.readBoolean();
        this.canApprove = paramObjectInputStream.readBoolean();
        this.isApproved = paramObjectInputStream.readBoolean();
        this.canClose = paramObjectInputStream.readBoolean();
        this.isClosed = paramObjectInputStream.readBoolean();
        this.isDeleted = paramObjectInputStream.readBoolean();
        this.canBan = paramObjectInputStream.readBoolean();
        this.canMove = paramObjectInputStream.readBoolean();
        this.isBan = paramObjectInputStream.readBoolean();
        this.forumId = ((String) paramObjectInputStream.readObject());
        this.isAnn = paramObjectInputStream.readBoolean();
        this.forum = ((Forum) paramObjectInputStream.readObject());
        this.timeStamp = paramObjectInputStream.readInt();
        this.postId = ((String) paramObjectInputStream.readObject());
        this.tapatalkForumId = ((String) paramObjectInputStream.readObject());
        this.tapatalkForumName = ((String) paramObjectInputStream.readObject());
        this.topicImgUrl = ((String) paramObjectInputStream.readObject());
        this.canMerge = paramObjectInputStream.readBoolean();
        this.isMoved = paramObjectInputStream.readBoolean();
        this.isMerged = paramObjectInputStream.readBoolean();
        this.real_topic_id = ((String) paramObjectInputStream.readObject());
        this.isRedirect = paramObjectInputStream.readBoolean();
        try {
            this.requiredPrefix = paramObjectInputStream.readBoolean();
            this.prefixes = ((ArrayList) paramObjectInputStream.readObject());
            this.thumbCount = ((Integer) paramObjectInputStream.readObject()).intValue();
            return;
        } catch (Exception paramObjectInputStream) {
        }
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        paramObjectOutputStream.writeObject(this.forumName);
        paramObjectOutputStream.writeObject(this.id);
        paramObjectOutputStream.writeObject(this.prefix);
        paramObjectOutputStream.writeObject(this.authorId);
        paramObjectOutputStream.writeObject(this.lastReplyTime);
        paramObjectOutputStream.writeObject(this.lastPosterId);
        paramObjectOutputStream.writeObject(this.lastPosterName);
        paramObjectOutputStream.writeObject(this.shortContent);
        paramObjectOutputStream.writeObject(this.title);
        paramObjectOutputStream.writeObject(this.authorName);
        paramObjectOutputStream.writeObject(this.icon_url);
        paramObjectOutputStream.writeObject(this.authorDisplayName);
        paramObjectOutputStream.writeObject(this.lastPosterDisplayName);
        paramObjectOutputStream.writeObject(this.localIconUri);
        paramObjectOutputStream.writeObject(this.lastReplyTimeString);
        paramObjectOutputStream.writeInt(this.replyCount);
        paramObjectOutputStream.writeInt(this.viewCount);
        paramObjectOutputStream.writeInt(this.attachment_flag);
        paramObjectOutputStream.writeBoolean(this.newPost);
        paramObjectOutputStream.writeBoolean(this.isSubscribe);
        paramObjectOutputStream.writeBoolean(this.canSubscribe);
        paramObjectOutputStream.writeBoolean(this.canUpload);
        paramObjectOutputStream.writeBoolean(this.isSticked);
        paramObjectOutputStream.writeBoolean(this.canStick);
        paramObjectOutputStream.writeBoolean(this.canDelete);
        paramObjectOutputStream.writeBoolean(this.canApprove);
        paramObjectOutputStream.writeBoolean(this.isApproved);
        paramObjectOutputStream.writeBoolean(this.canClose);
        paramObjectOutputStream.writeBoolean(this.isClosed);
        paramObjectOutputStream.writeBoolean(this.isDeleted);
        paramObjectOutputStream.writeBoolean(this.canBan);
        paramObjectOutputStream.writeBoolean(this.canMove);
        paramObjectOutputStream.writeBoolean(this.isBan);
        paramObjectOutputStream.writeObject(this.forumId);
        paramObjectOutputStream.writeBoolean(this.isAnn);
        paramObjectOutputStream.writeObject(this.forum);
        paramObjectOutputStream.writeInt(this.timeStamp);
        paramObjectOutputStream.writeObject(this.postId);
        paramObjectOutputStream.writeObject(this.tapatalkForumId);
        paramObjectOutputStream.writeObject(this.tapatalkForumName);
        paramObjectOutputStream.writeObject(this.topicImgUrl);
        paramObjectOutputStream.writeBoolean(this.canMerge);
        paramObjectOutputStream.writeBoolean(this.isMoved);
        paramObjectOutputStream.writeBoolean(this.isMerged);
        paramObjectOutputStream.writeObject(this.real_topic_id);
        paramObjectOutputStream.writeBoolean(this.isRedirect);
        paramObjectOutputStream.writeBoolean(this.requiredPrefix);
        paramObjectOutputStream.writeObject(this.prefixes);
        paramObjectOutputStream.writeObject(Integer.valueOf(this.thumbCount));
    }

    public void actionShareTopic(ForumStatus paramForumStatus, Activity paramActivity) {
        Object localObject = ForumUrlUtil.getTopicUrl(paramForumStatus, getId(), getTitle(), getForumId(), this.isAnn);
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.SEND");
        localIntent.setType("text/plain");
        localIntent.addFlags(1);
        localIntent.putExtra("android.intent.extra.TEXT", localObject + "\r\n" + getTitle());
        localIntent.putExtra("android.intent.extra.SUBJECT", getTitle());
        if (!paramActivity.getResources().getBoolean(2131558401)) {
        }
        try {
            String str = TapatalkJsonEngine.COMMON + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(paramActivity)) + "&device_type=" + Util.getDeviceName() + "&forum_id=" + paramForumStatus.getForumId() + "&action=share-android" + "&uid=" + paramForumStatus.tapatalkForum.getUserId();
            localObject = str;
            if (paramForumStatus.isLogin()) {
                localObject = str;
                if (paramForumStatus.tapatalkForum.getUserName() != null) {
                    localObject = str + "&username=" + URLEncoder.encode(paramForumStatus.tapatalkForum.getUserName(), "utf-8");
                }
            }
            TapatalkJsonEngine.callLogin(paramActivity, (String) localObject);
        } catch (UnsupportedEncodingException paramForumStatus) {
            for (; ; ) {
                paramForumStatus.printStackTrace();
            }
        }
        paramActivity.startActivity(Intent.createChooser(localIntent, "Share"));
    }

    public void approvePost(ForumRootAdapter paramForumRootAdapter, Context paramContext, boolean paramBoolean) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getPostId());
        int i;
        if (paramBoolean) {
            i = 1;
            localArrayList.add(Integer.valueOf(i));
            if (!paramBoolean) {
                break label90;
            }
            setApproved(false);
            Toast.makeText(paramContext, paramContext.getString(2131100027), 1).show();
        }
        for (; ; ) {
            paramForumRootAdapter.getEngine().call("m_approve_post", localArrayList);
            return;
            i = 2;
            break;
            label90:
            setApproved(true);
            Toast.makeText(paramContext, paramContext.getString(2131100028), 1).show();
        }
    }

    public void approvePost(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext, boolean paramBoolean) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getPostId());
        int i;
        if (paramBoolean) {
            i = 1;
            localArrayList.add(Integer.valueOf(i));
            if (!paramBoolean) {
                break label99;
            }
            setApproved(false);
            Toast.makeText(paramContext, paramContext.getString(2131100027), 1).show();
        }
        for (; ; ) {
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_approve_post", localArrayList);
            return;
            i = 2;
            break;
            label99:
            setApproved(true);
            Toast.makeText(paramContext, paramContext.getString(2131100028), 1).show();
        }
    }

    public void approveTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext, boolean paramBoolean) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        int i;
        if (paramBoolean) {
            i = 1;
            localArrayList.add(Integer.valueOf(i));
            if (!paramBoolean) {
                break label90;
            }
            setApproved(true);
            Toast.makeText(paramContext, paramContext.getString(2131100027), 1).show();
        }
        for (; ; ) {
            paramForumRootAdapter.getEngine().call("m_approve_topic", localArrayList);
            return;
            i = 2;
            break;
            label90:
            setApproved(false);
            Toast.makeText(paramContext, paramContext.getString(2131100028), 1).show();
        }
    }

    public void approveTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext, boolean paramBoolean) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        int i;
        if (paramBoolean) {
            i = 1;
            localArrayList.add(Integer.valueOf(i));
            if (!paramBoolean) {
                break label99;
            }
            setApproved(true);
            Toast.makeText(paramContext, paramContext.getString(2131100027), 1).show();
        }
        for (; ; ) {
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_approve_topic", localArrayList);
            return;
            i = 2;
            break;
            label99:
            setApproved(false);
            Toast.makeText(paramContext, paramContext.getString(2131100028), 1).show();
        }
    }

    public void closeTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext, boolean paramBoolean) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        int i;
        if (paramBoolean) {
            i = 2;
            localArrayList.add(Integer.valueOf(i));
            if (!paramBoolean) {
                break label90;
            }
            setClosed(true);
            Toast.makeText(paramContext, paramContext.getString(2131100031), 1).show();
        }
        for (; ; ) {
            paramForumRootAdapter.getEngine().call("m_close_topic", localArrayList);
            return;
            i = 1;
            break;
            label90:
            setClosed(false);
            Toast.makeText(paramContext, paramContext.getString(2131100030), 1).show();
        }
    }

    public void closeTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext, boolean paramBoolean) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        int i;
        if (paramBoolean) {
            i = 2;
            localArrayList.add(Integer.valueOf(i));
            if (!paramBoolean) {
                break label99;
            }
            setClosed(true);
            Toast.makeText(paramContext, paramContext.getString(2131100031), 1).show();
        }
        for (; ; ) {
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_close_topic", localArrayList);
            return;
            i = 1;
            break;
            label99:
            setClosed(false);
            Toast.makeText(paramContext, paramContext.getString(2131100030), 1).show();
        }
    }

    public View createView(int paramInt, View paramView, ForumActivityStatus paramForumActivityStatus) {
        return null;
    }

    public View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus) {
        return getTopicView(paramHashMap, paramView, paramForumActivityStatus, false, 0, false);
    }

    public View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus, boolean paramBoolean) {
        return getTopicView(paramHashMap, paramView, paramForumActivityStatus, false, 0, paramBoolean);
    }

    public View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus, boolean paramBoolean, int paramInt) {
        return getTopicView(paramHashMap, paramView, paramForumActivityStatus, paramBoolean, paramInt, false);
    }

    public void deletePost(ForumRootAdapter paramForumRootAdapter, Context paramContext, String paramString, int paramInt, ArrayList<PostData> paramArrayList) {
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                return;
            }
            paramForumRootAdapter.setTryTwice(false);
            paramForumRootAdapter.setOpCancel(false);
            setDeleted(true);
            paramContext = new ArrayList();
            paramContext.add(((PostData) paramArrayList.get(i)).getPostId());
            paramContext.add(Integer.valueOf(paramInt));
            if (paramString != null) {
            }
            try {
                paramContext.add(paramString.getBytes("UTF-8"));
                paramForumRootAdapter.getEngine().call("m_delete_post", paramContext);
                i += 1;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    paramContext.add(paramString.getBytes());
                }
            }
        }
    }

    public void deleteTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext, String paramString, int paramInt) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        setDeleted(true);
        paramContext = new ArrayList();
        paramContext.add(getId());
        paramContext.add(Integer.valueOf(paramInt));
        if (paramString != null) {
        }
        try {
            paramContext.add(paramString.getBytes("UTF-8"));
            paramForumRootAdapter.getEngine().call("m_delete_topic", paramContext);
            return;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                paramContext.add(paramString.getBytes());
            }
        }
    }

    public void deleteTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext, String paramString, int paramInt) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        setDeleted(true);
        paramContext = new ArrayList();
        paramContext.add(getId());
        paramContext.add(Integer.valueOf(paramInt));
        if (paramString != null) {
        }
        try {
            paramContext.add(paramString.getBytes("UTF-8"));
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_delete_topic", paramContext);
            return;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                paramContext.add(paramString.getBytes());
            }
        }
    }

    public int getAttachFlag() {
        return this.attachment_flag;
    }

    public String getAuthorDisplayName() {
        return this.authorDisplayName;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public Spanned getContent(Context paramContext, String paramString1, String paramString2) {
        if (SettingsFragment.isLightTheme(paramContext)) {
            return Html.fromHtml("<font size = 15 color = #000000><b>" + paramString1 + "</b></font>" + "<font size = 15 color = #6e6e6e>" + paramString2 + "</font>");
        }
        return Html.fromHtml("<font size = 15 color = #ffffff><b>" + paramString1 + "</b></font>" + "<font size = 15 color = #cccccc>" + paramString2 + "</font>");
    }

    public void getCurrenSubForumsTopicNumber(ForumRootAdapter paramForumRootAdapter) {
        ArrayList localArrayList = new ArrayList();
        int i;
        if (((paramForumRootAdapter instanceof SubForumAdapter)) && ((((SubForumAdapter) paramForumRootAdapter).getCurAdapter() instanceof TopicAdapter))) {
            i = 0;
        }
        for (; ; ) {
            if (i >= ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().mAllDatas.size()) {
                if (localArrayList.size() > 1) {
                    this.isShowMergeTopic = true;
                }
                return;
            }
            if (((((SubForumAdapter) paramForumRootAdapter).getCurAdapter().mAllDatas.get(i) instanceof Topic)) && (((Topic) ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().mAllDatas.get(i)).isCanMerge()) && (!((Topic) ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().mAllDatas.get(i)).isRedirect())) {
                localArrayList.add((Topic) ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().mAllDatas.get(i));
            }
            i += 1;
        }
    }

    public Forum getForum() {
        return this.forum;
    }

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getForumUrl() {
        return this.forumUrl;
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public String getId() {
        return this.id;
    }

    public Topic getInstance() {
        return this;
    }

    public String getLastPosterDisplayName() {
        return this.lastPosterDisplayName;
    }

    public String getLastPosterId() {
        return this.lastPosterId;
    }

    public String getLastPosterName() {
        return this.lastPosterName;
    }

    public Date getLastReplyTime() {
        return this.lastReplyTime;
    }

    public String getLastReplyTimeString() {
        return this.lastReplyTimeString;
    }

    public String getLocalIconUri() {
        return this.localIconUri;
    }

    public LoginStatus getLoginStatus() {
        return this.loginStatus;
    }

    public AlertDialog getLongClickDialog(final ForumRootAdapter paramForumRootAdapter, final Activity paramActivity, final ForumStatus paramForumStatus) {
        getCurrenSubForumsTopicNumber(paramForumRootAdapter);
        final TopicDialogAdapter localTopicDialogAdapter = new TopicDialogAdapter(paramActivity, 5, this, paramForumRootAdapter.forumStatus);
        new AlertDialog.Builder(paramActivity).setTitle(getTitle()).setAdapter(localTopicDialogAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = localTopicDialogAdapter.getItem(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099846))) {
                    Toast.makeText(paramActivity, paramActivity.getString(2131099902), 0).show();
                    Topic.this.subscribeTopic(paramForumRootAdapter, paramActivity);
                }
                do {
                    return;
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099847))) {
                        Toast.makeText(paramActivity, paramActivity.getString(2131099904), 0).show();
                        Topic.this.unSubscribeTopic(paramForumRootAdapter, paramActivity);
                        paramForumRootAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100054))) {
                        Topic.this.actionShareTopic(paramForumRootAdapter.forumStatus, paramActivity);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100067))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramForumRootAdapter, Topic.this).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100102))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramForumRootAdapter, Topic.this).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099819))) {
                        paramForumStatus.addReadTopicMark(Topic.this.getId());
                        Topic.this.setNewPost(false);
                        paramForumRootAdapter.notifyDataSetChanged();
                        paramAnonymousDialogInterface = new TopicAction(paramActivity, paramForumStatus);
                        if (paramForumStatus.isMarkTopicRead()) {
                            paramAnonymousDialogInterface.markTopicRead(Topic.this.id);
                            return;
                        }
                        paramAnonymousDialogInterface.markTopicRead(Topic.this.id, Topic.this.replyCount);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100093))) {
                        Topic.this.openMode = "2";
                        Topic.this.openThread(paramActivity, paramForumStatus);
                        Topic.this.openMode = null;
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100091))) {
                        Topic.this.openMode = "1";
                        Topic.this.openThread(paramActivity, paramForumStatus);
                        Topic.this.openMode = null;
                        return;
                    }
                } while (!paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100092)));
                Topic.this.openMode = "0";
                Topic.this.openThread(paramActivity, paramForumStatus);
                Topic.this.openMode = null;
            }
        }).create();
    }

    public AlertDialog getLongClickDialog(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Activity paramActivity, ForumStatus paramForumStatus) {
        return longClickAlertDialog(paramNewSubscribeForumAndTopicAdapter, paramActivity, paramForumStatus);
    }

    public boolean getNewPost() {
        return this.newPost;
    }

    public boolean getNewPost(ForumStatus paramForumStatus) {
        return (this.newPost) && (!paramForumStatus.getReadTopicMark(this.id));
    }

    public View getNewTopicView(int paramInt1, View paramView, ViewGroup paramViewGroup, ForumActivityStatus paramForumActivityStatus, AQuery paramAQuery, int paramInt2) {
        View localView;
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof TrendingNoImageHodler))) {
            localView = LayoutInflater.from(paramForumActivityStatus.getDefaultActivity()).inflate(2130903410, null);
            paramViewGroup = new TrendingNoImageHodler();
            paramViewGroup.trending_layout = ((RelativeLayout) localView.findViewById(2131231452));
            paramViewGroup.trending_layout_bg = ((RelativeLayout) localView.findViewById(2131231463));
            paramViewGroup.trending_topic = ((RelativeLayout) localView.findViewById(2131231453));
            paramViewGroup.trendingTopicContent = ((RelativeLayout) localView.findViewById(2131231457));
            paramViewGroup.forumName = ((TextView) localView.findViewById(2131231454));
            paramViewGroup.topic_title = ((TextView) localView.findViewById(2131231455));
            paramViewGroup.topic_reply = ((TextView) localView.findViewById(2131231460));
            paramViewGroup.topic_paticipate = ((TextView) localView.findViewById(2131231458));
            paramViewGroup.participate_icon = ((ImageView) localView.findViewById(2131231459));
            paramViewGroup.topic_reply_icon = ((ImageView) localView.findViewById(2131231212));
            paramViewGroup.topic_content = ((ShortContentView) localView.findViewById(2131231461));
            paramViewGroup.topic_timestmap = ((TextView) localView.findViewById(2131231462));
            paramViewGroup.topic_user_icon = ((ImageView) localView.findViewById(2131231456));
            paramViewGroup.topic_user_icon.bringToFront();
            paramViewGroup.trending_layout_bg.bringToFront();
            localView.setTag(paramViewGroup);
            paramView = (AQuery) paramAQuery.recycle(localView);
            paramViewGroup.trending_layout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("trending_topic_item_bg", paramForumActivityStatus.getDefaultActivity()));
            paramViewGroup.forumName.setText(getTapatalkForumName() + " ");
            if ((this.authorName == null) && (this.authorDisplayName == null)) {
                break label863;
            }
            if (this.authorDisplayName == null) {
                break label855;
            }
            paramView = this.authorDisplayName;
            label351:
            if (!SettingsFragment.isShowTopicPrefix(paramForumActivityStatus.getDefaultActivity())) {
                break label886;
            }
            paramViewGroup.topic_title.setVisibility(0);
            paramViewGroup.topic_title.setText(getPrefix() + getTitle());
            label403:
            paramViewGroup.topic_title.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            ((RoundedImageView) paramViewGroup.topic_user_icon).setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839528));
            ImageTools.glideLoad(this.icon_url, paramViewGroup.topic_user_icon, 2130837858);
            if (Util.is2GState(paramForumActivityStatus.getDefaultActivity())) {
                break label934;
            }
            paramAQuery = (RelativeLayout.LayoutParams) paramViewGroup.trending_topic.getLayoutParams();
            paramAQuery.height = paramInt2;
            paramViewGroup.trending_topic.setLayoutParams(paramAQuery);
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label908;
            }
            paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165234));
            label543:
            paramViewGroup.forumName.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165214));
            paramViewGroup.forumName.getBackground().setAlpha(80);
            paramViewGroup.topic_timestmap.setVisibility(0);
            if (this.timeStamp == 0) {
                break label1034;
            }
            paramViewGroup.topic_timestmap.setText(getTimeStampText(paramForumActivityStatus.getDefaultActivity(), Util.getTimeString(paramForumActivityStatus.getDefaultActivity(), this.timeStamp)));
            label625:
            paramViewGroup.topic_reply.setText(getReplyCount());
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1103;
            }
            paramViewGroup.topic_reply.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165307));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165307));
            paramViewGroup.topic_reply_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839285));
        }
        for (; ; ) {
            paramViewGroup.topic_paticipate.setText(getThumbCount());
            paramViewGroup.topic_content.setText(getContent(paramForumActivityStatus.getDefaultActivity(), paramView + " ", getShortContent()));
            isThumbUp();
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1175;
            }
            paramViewGroup.trending_layout_bg.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839491));
            return localView;
            paramViewGroup = (TrendingNoImageHodler) paramView.getTag();
            localView = paramView;
            break;
            label855:
            paramView = this.authorName;
            break label351;
            label863:
            if (this.lastPosterDisplayName != null) {
                paramView = this.lastPosterDisplayName;
                break label351;
            }
            paramView = this.lastPosterName;
            break label351;
            label886:
            paramViewGroup.topic_title.setVisibility(0);
            paramViewGroup.topic_title.setText(getTitle());
            break label403;
            label908:
            paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165602));
            break label543;
            label934:
            if (SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165234));
            }
            for (; ; ) {
                paramViewGroup.forumName.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165214));
                paramViewGroup.forumName.getBackground().setAlpha(80);
                break;
                paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165602));
            }
            label1034:
            if ((getLastReplyTime() != null) && (!getLastReplyTime().equals(""))) {
                paramViewGroup.topic_timestmap.setText(getTimeStampText(paramForumActivityStatus.getDefaultActivity(), Util.formatSmartDate(paramForumActivityStatus.getDefaultActivity(), Util.stringFormat(getLastReplyTime()))));
                break label625;
            }
            paramViewGroup.topic_timestmap.setText("");
            break label625;
            label1103:
            paramViewGroup.topic_reply.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            paramViewGroup.topic_reply_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839286));
        }
        label1175:
        paramViewGroup.trending_layout_bg.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839492));
        return localView;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getPrefix() {
        if ((this.prefix == null) || (this.prefix.length() == 0)) {
            return "";
        }
        if ((this.prefix.startsWith("[")) && (this.prefix.endsWith("]"))) {
            return this.prefix;
        }
        return "[" + this.prefix + "] ";
    }

    public ArrayList<HashMap<String, Object>> getPrefixes() {
        return this.prefixes;
    }

    public String getRealName() {
        if (getAuthorName() != null) {
            if (getAuthorDisplayName() != null) {
                return getAuthorDisplayName();
            }
            return getAuthorName();
        }
        if (getLastPosterDisplayName() != null) {
            return getLastPosterDisplayName();
        }
        return getLastPosterName();
    }

    public String getReal_topic_id() {
        return this.real_topic_id;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    public String getReplyString(Context paramContext) {
        paramContext = this.replyCount;
        if (this.replyCount > 1000000) {
            paramContext = this.replyCount / 1000000 + "M";
        }
        for (; ; ) {
            return paramContext;
            if (this.replyCount > 1000) {
                paramContext = this.replyCount / 1000 + "K";
            }
        }
    }

    public Integer getSearchScore() {
        Integer localInteger2 = Integer.valueOf(this.replyCount * 10);
        Integer localInteger1 = localInteger2;
        if (this.topicImgUrl != null) {
            localInteger1 = localInteger2;
            if (!this.topicImgUrl.equals("")) {
                localInteger1 = Integer.valueOf(localInteger2.intValue() + 1);
            }
        }
        return localInteger1;
    }

    public String getShortContent() {
        return this.shortContent;
    }

    public String getTapatalkForumId() {
        return this.tapatalkForumId;
    }

    public String getTapatalkForumName() {
        return this.tapatalkForumName;
    }

    public int getThumbCount() {
        return this.thumbCount;
    }

    public int getThumbType() {
        return this.thumbType;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public Spanned getTimeStampText(Context paramContext, String paramString) {
        if (SettingsFragment.isLightTheme(paramContext)) {
            return Html.fromHtml("<font color = #A8A8A8><i>" + paramString + "</i></font>");
        }
        return Html.fromHtml("<font color = #a8a8a8><i>" + paramString + "</i></font>");
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopicImgUrl() {
        return this.topicImgUrl;
    }

    public View getTopicView(HashMap paramHashMap, View paramView, final ForumActivityStatus paramForumActivityStatus, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
        TopicViewHolder localTopicViewHolder;
        label311:
        View localView;
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof TopicViewHolder))) {
            paramView = LayoutInflater.from(paramForumActivityStatus.getDefaultActivity());
            if (paramBoolean1) {
                paramView = paramView.inflate(2130903224, null);
                localTopicViewHolder = new TopicViewHolder();
                localTopicViewHolder.avaterbg = ((ImageView) paramView.findViewById(2131230795));
                localTopicViewHolder.llayout1 = paramView.findViewById(2131230793);
                localTopicViewHolder.topicAuthor = ((TextView) paramView.findViewById(2131230797));
                localTopicViewHolder.topicTime = ((TextView) paramView.findViewById(2131231202));
                localTopicViewHolder.topicTitle = ((NewTitleTextView) paramView.findViewById(2131230800));
                localTopicViewHolder.shortContent = ((ShortContentView) paramView.findViewById(2131230801));
                localTopicViewHolder.forumtitle_lay = ((RelativeLayout) paramView.findViewById(2131231213));
                localTopicViewHolder.forumTitle = ((TextView) paramView.findViewById(2131231215));
                localTopicViewHolder.attach = ((ImageView) paramView.findViewById(2131231206));
                localTopicViewHolder.redirect = ((ImageView) paramView.findViewById(2131231281));
                localTopicViewHolder.replyNum = ((TextView) paramView.findViewById(2131231211));
                localTopicViewHolder.viewNum = ((TextView) paramView.findViewById(2131230798));
                localTopicViewHolder.viewIcon = ((ImageView) paramView.findViewById(2131230799));
                localTopicViewHolder.breaker = ((ImageView) paramView.findViewById(2131231210));
                localTopicViewHolder.breaker2 = ((ImageView) paramView.findViewById(2131231209));
                localTopicViewHolder.replyIcon = ((ImageView) paramView.findViewById(2131231212));
                if (!paramBoolean1) {
                    break label1258;
                }
                localTopicViewHolder.forumLogo = ((ImageView) paramView.findViewById(2131230794));
                localTopicViewHolder.approve = ((ImageView) paramView.findViewById(2131231204));
                localTopicViewHolder.ann = ((ImageView) paramView.findViewById(2131231208));
                localTopicViewHolder.close = ((ImageView) paramView.findViewById(2131231205));
                localTopicViewHolder.sticky = ((ImageView) paramView.findViewById(2131231207));
                localTopicViewHolder.notificationMode = ((ImageView) paramView.findViewById(2131231180));
                localTopicViewHolder.topicImg = ((ImageView) paramView.findViewById(2131231073));
                ThemeUtil.setAuthorColor(paramForumActivityStatus.getDefaultActivity(), localTopicViewHolder.topicAuthor);
                localTopicViewHolder.avaterbg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", paramForumActivityStatus.getDefaultActivity()));
                localTopicViewHolder.avaterbg.bringToFront();
                paramView.setTag(localTopicViewHolder);
                localView = paramView;
                label452:
                if (!paramBoolean2) {
                    break label1291;
                }
                localTopicViewHolder.llayout1.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839462));
                label480:
                if (((Boolean) paramHashMap.get("showForumName")).booleanValue()) {
                    break label1361;
                }
                localTopicViewHolder.forumtitle_lay.setVisibility(8);
                label505:
                if ((this.authorName == null) && (this.authorDisplayName == null)) {
                    break label1508;
                }
                if (this.authorDisplayName == null) {
                    break label1500;
                }
                paramView = this.authorDisplayName;
                label531:
                if (paramForumActivityStatus.getForumStatus() != null) {
                    break label1531;
                }
                localTopicViewHolder.topicTitle.initial(this.isDeleted, false, this.newPost);
                localTopicViewHolder.shortContent.isDelete(this.isDeleted, false, true);
                label571:
                if (!((Boolean) paramHashMap.get("isSubscribedTab")).booleanValue()) {
                    break label1611;
                }
                localTopicViewHolder.notificationMode.setVisibility(8);
                label596:
                if (isApproved()) {
                    break label1643;
                }
                localTopicViewHolder.approve.setVisibility(0);
                label612:
                if (!isSticked()) {
                    break label1656;
                }
                localTopicViewHolder.sticky.setVisibility(0);
                label628:
                if (!this.isAnn) {
                    break label1669;
                }
                localTopicViewHolder.ann.setVisibility(0);
                label644:
                if (!isClosed()) {
                    break label1682;
                }
                localTopicViewHolder.close.setVisibility(0);
                label660:
                if (getAttachFlag() <= 0) {
                    break label1695;
                }
                localTopicViewHolder.attach.setVisibility(0);
                label676:
                if (localTopicViewHolder.redirect != null) {
                    if (!isRedirect()) {
                        break label1708;
                    }
                    localTopicViewHolder.redirect.setVisibility(0);
                }
                label700:
                localTopicViewHolder.topicAuthor.setText(paramView);
                new Html.ImageGetter() {
                    public Drawable getDrawable(String paramAnonymousString) {
                        int i = Integer.parseInt(paramAnonymousString);
                        return paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(i);
                    }
                };
                localTopicViewHolder.topicTitle.setText("");
                if (!SettingsFragment.isShowTopicPrefix(paramForumActivityStatus.getDefaultActivity())) {
                    break label1721;
                }
                localTopicViewHolder.topicTitle.setVisibility(0);
                localTopicViewHolder.topicTitle.setText(getPrefix() + getTitle());
                label782:
                if (Util.is2GState(paramForumActivityStatus.getDefaultActivity())) {
                    break label1758;
                }
                if ((!SettingsFragment.isEnableTopicImg(paramForumActivityStatus.getDefaultActivity())) || (this.topicImgUrl == null) || (this.topicImgUrl.equals(""))) {
                    break label1745;
                }
                localTopicViewHolder.topicImg.setVisibility(0);
                ImageTools.glideLoad(this.topicImgUrl, localTopicViewHolder.topicImg);
                label846:
                if (!Util.isEmpty(getShortContent())) {
                    break label1826;
                }
                localTopicViewHolder.shortContent.setVisibility(8);
                if ((!((Boolean) paramHashMap.get("showForumName")).booleanValue()) && ((this.topicImgUrl == null) || (this.topicImgUrl.equals("")))) {
                    localTopicViewHolder.topicTitle.setPadding(localTopicViewHolder.topicTitle.getPaddingLeft(), 0, 0, Util.getPxFromDip(paramForumActivityStatus.getDefaultActivity(), 12.0F));
                }
                if ((this.topicImgUrl != null) && (!this.topicImgUrl.equals(""))) {
                    paramHashMap = (RelativeLayout.LayoutParams) localTopicViewHolder.topicImg.getLayoutParams();
                    if (paramHashMap.bottomMargin != Util.getPxFromDip(paramForumActivityStatus.getDefaultActivity(), 12.0F)) {
                        paramHashMap.bottomMargin = Util.getPxFromDip(paramForumActivityStatus.getDefaultActivity(), 12.0F);
                        localTopicViewHolder.topicImg.setLayoutParams(paramHashMap);
                    }
                }
                label1005:
                if (this.replyCount != 0) {
                    break label1909;
                }
                localTopicViewHolder.replyNum.setVisibility(8);
                localTopicViewHolder.breaker.setVisibility(8);
                localTopicViewHolder.replyIcon.setVisibility(8);
                label1042:
                localTopicViewHolder.replyNum.setText(getReplyString(paramForumActivityStatus.getDefaultActivity()));
                if (getViewCount() <= 0) {
                    break label1939;
                }
                localTopicViewHolder.viewIcon.setVisibility(0);
                localTopicViewHolder.viewNum.setVisibility(0);
                localTopicViewHolder.breaker2.setVisibility(0);
                localTopicViewHolder.viewNum.setText(getViewString(paramForumActivityStatus.getDefaultActivity()));
                label1112:
                if ((!isSticked()) && (!isAnn())) {
                    break label1972;
                }
                localTopicViewHolder.topicTime.setVisibility(8);
                label1136:
                if (!paramBoolean1) {
                    break label2182;
                }
                localTopicViewHolder.viewDefaultIcon = ((TextView) localView.findViewById(2131231283));
                if (paramInt % 2 != 0) {
                    break label2153;
                }
                localTopicViewHolder.viewDefaultIcon.setBackgroundResource(2131165582);
                label1175:
                if (paramView != null) {
                    if (paramView.length() <= 3) {
                        break label2167;
                    }
                    localTopicViewHolder.viewDefaultIcon.setText(Util.shift(paramView.substring(0, 3)));
                }
            }
        }
        for (; ; ) {
            localTopicViewHolder.viewDefaultIcon.setVisibility(8);
            localTopicViewHolder.avaterbg.setVisibility(0);
            showTrendingTopicLogo(paramForumActivityStatus, localTopicViewHolder.forumLogo, localTopicViewHolder.viewDefaultIcon, localTopicViewHolder.avaterbg);
            return localView;
            paramView = paramView.inflate(2130903222, null);
            break;
            label1258:
            localTopicViewHolder.userIcon = ((GifImageView) paramView.findViewById(2131230794));
            break label311;
            localTopicViewHolder = (TopicViewHolder) paramView.getTag();
            localView = paramView;
            break label452;
            label1291:
            if ((paramHashMap.get("showSelectBg") != null) && (((Boolean) paramHashMap.get("showSelectBg")).booleanValue())) {
                localTopicViewHolder.llayout1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_select_bg", paramForumActivityStatus.getDefaultActivity()));
                break label480;
            }
            localTopicViewHolder.llayout1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", paramForumActivityStatus.getDefaultActivity()));
            break label480;
            label1361:
            if ((getForumName() != null) && (!getForumName().equals(""))) {
                localTopicViewHolder.forumtitle_lay.setVisibility(0);
                localTopicViewHolder.forumTitle.setText(" " + getForumName());
                localTopicViewHolder.shortContent.setPadding(localTopicViewHolder.shortContent.getPaddingLeft(), localTopicViewHolder.shortContent.getPaddingTop(), localTopicViewHolder.shortContent.getPaddingRight(), 0);
                break label505;
            }
            localTopicViewHolder.forumtitle_lay.setVisibility(8);
            localTopicViewHolder.shortContent.setPadding(localTopicViewHolder.shortContent.getPaddingLeft(), localTopicViewHolder.shortContent.getPaddingTop(), localTopicViewHolder.shortContent.getPaddingRight(), 15);
            break label505;
            label1500:
            paramView = this.authorName;
            break label531;
            label1508:
            if (this.lastPosterDisplayName != null) {
                paramView = this.lastPosterDisplayName;
                break label531;
            }
            paramView = this.lastPosterName;
            break label531;
            label1531:
            if (!paramForumActivityStatus.getForumStatus().isLogin()) {
                localTopicViewHolder.topicTitle.initial(this.isDeleted, false, true);
                localTopicViewHolder.shortContent.isDelete(this.isDeleted, false, true);
                break label571;
            }
            localTopicViewHolder.topicTitle.initial(this.isDeleted, false, this.newPost);
            localTopicViewHolder.shortContent.isDelete(this.isDeleted, false, this.newPost);
            break label571;
            label1611:
            if (this.isSubscribe) {
                localTopicViewHolder.notificationMode.setVisibility(0);
                break label596;
            }
            localTopicViewHolder.notificationMode.setVisibility(8);
            break label596;
            label1643:
            localTopicViewHolder.approve.setVisibility(8);
            break label612;
            label1656:
            localTopicViewHolder.sticky.setVisibility(8);
            break label628;
            label1669:
            localTopicViewHolder.ann.setVisibility(8);
            break label644;
            label1682:
            localTopicViewHolder.close.setVisibility(8);
            break label660;
            label1695:
            localTopicViewHolder.attach.setVisibility(8);
            break label676;
            label1708:
            localTopicViewHolder.redirect.setVisibility(8);
            break label700;
            label1721:
            localTopicViewHolder.topicTitle.setVisibility(0);
            localTopicViewHolder.topicTitle.setText(getTitle());
            break label782;
            label1745:
            localTopicViewHolder.topicImg.setVisibility(8);
            break label846;
            label1758:
            if ((SettingsFragment.isEnableTopicImgWithSlowConn(paramForumActivityStatus.getDefaultActivity())) && (this.topicImgUrl != null) && (!this.topicImgUrl.equals(""))) {
                localTopicViewHolder.topicImg.setVisibility(0);
                ImageTools.glideLoad(this.topicImgUrl, localTopicViewHolder.topicImg);
                break label846;
            }
            localTopicViewHolder.topicImg.setVisibility(8);
            break label846;
            label1826:
            paramHashMap = getShortContent().replaceAll("&quot;", "\"");
            GetEmojiImage localGetEmojiImage = new GetEmojiImage(paramForumActivityStatus.getDefaultActivity());
            localGetEmojiImage.view = localTopicViewHolder.shortContent;
            paramHashMap = Html.fromHtml(BBcodeUtil.parseSmile(paramHashMap, paramForumActivityStatus.getForumStatus()), localGetEmojiImage, new MyTagHandler());
            localTopicViewHolder.shortContent.setText(paramHashMap);
            localTopicViewHolder.shortContent.setVisibility(0);
            break label1005;
            label1909:
            localTopicViewHolder.replyNum.setVisibility(0);
            localTopicViewHolder.breaker.setVisibility(0);
            localTopicViewHolder.replyIcon.setVisibility(0);
            break label1042;
            label1939:
            localTopicViewHolder.viewIcon.setVisibility(8);
            localTopicViewHolder.viewNum.setVisibility(8);
            localTopicViewHolder.breaker2.setVisibility(8);
            break label1112;
            label1972:
            localTopicViewHolder.topicTime.setVisibility(0);
            int i = SettingsFragment.getTimeStyle(paramForumActivityStatus.getDefaultActivity());
            if (this.timeStamp != 0) {
                if (i == 0) {
                    localTopicViewHolder.topicTime.setText(Util.getSmartTime(paramForumActivityStatus.getDefaultActivity(), this.timeStamp));
                    break label1136;
                }
                localTopicViewHolder.topicTime.setText(Util.getShortTimeString(paramForumActivityStatus.getDefaultActivity(), this.timeStamp));
                break label1136;
            }
            if ((getLastReplyTime() != null) && (!getLastReplyTime().equals(""))) {
                if (i == 0) {
                    localTopicViewHolder.topicTime.setText(Util.formatSmartDate(paramForumActivityStatus.getDefaultActivity(), Util.stringFormat(getLastReplyTime())));
                    break label1136;
                }
                localTopicViewHolder.topicTime.setText(Util.formatDate2(paramForumActivityStatus.getDefaultActivity(), Util.stringFormat(getLastReplyTime())));
                break label1136;
            }
            localTopicViewHolder.topicTime.setText("");
            localTopicViewHolder.breaker.setVisibility(8);
            break label1136;
            label2153:
            localTopicViewHolder.viewDefaultIcon.setBackgroundResource(2131165583);
            break label1175;
            label2167:
            localTopicViewHolder.viewDefaultIcon.setText(Util.shift(paramView));
        }
        label2182:
        paramView = paramForumActivityStatus.getDefaultActivity();
        if (this.loginStatus != null) {
        }
        for (paramHashMap = this.loginStatus; ; paramHashMap = paramForumActivityStatus.getForumStatus()) {
            Util.getUserImage(paramView, paramHashMap, localTopicViewHolder.userIcon, getIconUrl(), localTopicViewHolder.avaterbg);
            return localView;
        }
    }

    public View getTrendingTopicView(final int paramInt1, View paramView, ViewGroup paramViewGroup, final ForumActivityStatus paramForumActivityStatus, AQuery paramAQuery, final FeedListAdapter paramFeedListAdapter, final TapatalkForum paramTapatalkForum, final TapatalkAjaxLogAction paramTapatalkAjaxLogAction, int paramInt2, ListItemRemoveAnimatorController paramListItemRemoveAnimatorController) {
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof TrendingHodler))) {
            paramListItemRemoveAnimatorController = LayoutInflater.from(paramForumActivityStatus.getDefaultActivity()).inflate(2130903409, null);
            paramViewGroup = new TrendingHodler();
            paramViewGroup.trending_layout = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231452));
            paramViewGroup.trending_layout_bg = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231463));
            paramViewGroup.trending_topic = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231453));
            paramViewGroup.trendingTopicContent = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231457));
            paramViewGroup.trendingImage = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231682));
            paramViewGroup.forumName = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231454));
            paramViewGroup.topic_title = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231455));
            paramViewGroup.topic_reply = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231460));
            paramViewGroup.topic_paticipate = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231458));
            paramViewGroup.participate_icon = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231459));
            paramViewGroup.topic_reply_icon = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231212));
            paramViewGroup.topic_content = ((ShortContentView) paramListItemRemoveAnimatorController.findViewById(2131231461));
            paramViewGroup.topic_timestmap = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231462));
            paramViewGroup.topic_user_icon = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231456));
            paramViewGroup.feed_trending_like_layout = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231685));
            paramViewGroup.feed_trending_unlike_layout = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231687));
            paramViewGroup.trending_like = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231686));
            paramViewGroup.trending_unlike = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231688));
            paramViewGroup.topic_user_icon.bringToFront();
            paramViewGroup.trending_layout_bg.bringToFront();
            paramListItemRemoveAnimatorController.setTag(paramViewGroup);
            paramView = (AQuery) paramAQuery.recycle(paramListItemRemoveAnimatorController);
            paramViewGroup.trending_layout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("trending_topic_item_bg", paramForumActivityStatus.getDefaultActivity()));
            paramViewGroup.forumName.setText(getTapatalkForumName() + " ");
            if ((this.authorName == null) && (this.authorDisplayName == null)) {
                break label1127;
            }
            if (this.authorDisplayName == null) {
                break label1119;
            }
            paramView = this.authorDisplayName;
            label426:
            if (!SettingsFragment.isShowTopicPrefix(paramForumActivityStatus.getDefaultActivity())) {
                break label1150;
            }
            paramViewGroup.topic_title.setVisibility(0);
            paramViewGroup.topic_title.setText(getPrefix() + getTitle());
            label478:
            paramViewGroup.topic_title.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            ((RoundedImageView) paramViewGroup.topic_user_icon).setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839528));
            ImageTools.glideLoad(this.icon_url, paramViewGroup.topic_user_icon, 2130837858);
            if (Util.is2GState(paramForumActivityStatus.getDefaultActivity())) {
                break label1198;
            }
            paramAQuery = (RelativeLayout.LayoutParams) paramViewGroup.trendingImage.getLayoutParams();
            paramAQuery.height = paramInt2;
            paramViewGroup.trendingImage.setLayoutParams(paramAQuery);
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1172;
            }
            paramViewGroup.trendingImage.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            label618:
            ImageTools.glideLoad(this.topicImgUrl, paramViewGroup.trendingImage);
            paramViewGroup.forumName.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165212));
            label652:
            paramViewGroup.topic_timestmap.setVisibility(0);
            if (this.timeStamp == 0) {
                break label1342;
            }
            paramViewGroup.topic_timestmap.setText(getTimeStampText(paramForumActivityStatus.getDefaultActivity(), Util.getTimeString(paramForumActivityStatus.getDefaultActivity(), this.timeStamp)));
            label699:
            paramViewGroup.topic_reply.setText(getReplyCount());
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1411;
            }
            paramViewGroup.topic_reply.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165307));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165307));
            paramViewGroup.topic_reply_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839285));
            label805:
            paramViewGroup.topic_paticipate.setText(getThumbCount());
            paramViewGroup.topic_content.setText(getContent(paramForumActivityStatus.getDefaultActivity(), paramView + " ", getShortContent()));
            if (!isThumbUp()) {
                break label1483;
            }
            paramViewGroup.trending_like.setText(paramForumActivityStatus.getDefaultActivity().getResources().getString(2131100934));
            paramViewGroup.trending_like.setCompoundDrawablesWithIntrinsicBounds(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130838910), null, null, null);
            paramViewGroup.feed_trending_like_layout.setBackgroundDrawable(ThemeUtil.getViewBackgroundDrawable(paramForumActivityStatus.getDefaultActivity(), 2130838764, 2130838765));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165582));
            paramViewGroup.participate_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839287));
        }
        for (; ; ) {
            paramViewGroup.feed_trending_like_layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (TapatalkIdFactory.getTapatalkId(paramForumActivityStatus.getDefaultActivity()).isTapatalkIdLogin()) {
                        if (Topic.this.isThumbUp()) {
                            Topic.this.setThumbCount(Topic.this.getThumbCount() - 1);
                            Topic.this.setThumbUp(false);
                            paramTapatalkAjaxLogAction.logTapatalkLog(TapatalkLogUrlUtil.getTrendingTopicThumbupUrl(paramForumActivityStatus.getDefaultActivity(), paramTapatalkForum.getId().intValue(), Topic.this.getId(), 2));
                        }
                        for (; ; ) {
                            paramFeedListAdapter.notifyDataSetChanged();
                            return;
                            Topic.this.setThumbCount(Topic.this.getThumbCount() + 1);
                            Topic.this.setThumbUp(true);
                            paramTapatalkAjaxLogAction.logTapatalkLog(TapatalkLogUrlUtil.getTrendingTopicThumbupUrl(paramForumActivityStatus.getDefaultActivity(), paramTapatalkForum.getId().intValue(), Topic.this.getId(), 1));
                        }
                    }
                    paramAnonymousView = new Intent();
                    paramAnonymousView.setClass(paramForumActivityStatus.getDefaultActivity(), ObEntryActivity.class);
                    paramAnonymousView.putExtra("accountPage", true);
                    paramAnonymousView.putExtra("guestLogin", true);
                    paramForumActivityStatus.getDefaultActivity().startActivityForResult(paramAnonymousView, 37);
                }
            });
            paramViewGroup.feed_trending_unlike_layout.setBackgroundDrawable(ThemeUtil.getViewBackgroundDrawable(paramForumActivityStatus.getDefaultActivity(), 2130838762, 2130838763));
            paramViewGroup.feed_trending_unlike_layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (TapatalkIdFactory.getTapatalkId(paramForumActivityStatus.getDefaultActivity()).isTapatalkIdLogin()) {
                        if (paramTapatalkForum != null) {
                            paramTapatalkAjaxLogAction.logTapatalkLog(TapatalkLogUrlUtil.getTrendingTopicThumbupUrl(paramForumActivityStatus.getDefaultActivity(), paramTapatalkForum.getId().intValue(), Topic.this.getId(), 0));
                        }
                        if (paramFeedListAdapter != null) {
                            paramFeedListAdapter.animationDelete(paramFeedListAdapter.getGroupCount() - 1, paramInt1);
                            paramFeedListAdapter.notifyDataSetChanged();
                        }
                        return;
                    }
                    paramAnonymousView = new Intent();
                    paramAnonymousView.setClass(paramForumActivityStatus.getDefaultActivity(), ObEntryActivity.class);
                    paramAnonymousView.putExtra("accountPage", true);
                    paramAnonymousView.putExtra("guestLogin", true);
                    paramForumActivityStatus.getDefaultActivity().startActivityForResult(paramAnonymousView, 37);
                }
            });
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1577;
            }
            paramViewGroup.trending_layout_bg.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839491));
            return paramListItemRemoveAnimatorController;
            paramViewGroup = (TrendingHodler) paramView.getTag();
            paramListItemRemoveAnimatorController = paramView;
            break;
            label1119:
            paramView = this.authorName;
            break label426;
            label1127:
            if (this.lastPosterDisplayName != null) {
                paramView = this.lastPosterDisplayName;
                break label426;
            }
            paramView = this.lastPosterName;
            break label426;
            label1150:
            paramViewGroup.topic_title.setVisibility(0);
            paramViewGroup.topic_title.setText(getTitle());
            break label478;
            label1172:
            paramViewGroup.trendingImage.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165226));
            break label618;
            label1198:
            paramAQuery = (RelativeLayout.LayoutParams) paramViewGroup.trendingImage.getLayoutParams();
            paramAQuery.height = paramInt2;
            paramViewGroup.trendingImage.setLayoutParams(paramAQuery);
            if ((!SettingsFragment.isEnableTopicImgWithSlowConn(paramForumActivityStatus.getDefaultActivity())) || (this.topicImgUrl == null) || (this.topicImgUrl.equals(""))) {
                break label652;
            }
            if (SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165234));
            }
            for (; ; ) {
                paramViewGroup.trendingImage.setVisibility(0);
                ImageTools.glideLoad(this.topicImgUrl, paramViewGroup.trendingImage);
                break;
                paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165602));
            }
            label1342:
            if ((getLastReplyTime() != null) && (!getLastReplyTime().equals(""))) {
                paramViewGroup.topic_timestmap.setText(getTimeStampText(paramForumActivityStatus.getDefaultActivity(), Util.formatSmartDate(paramForumActivityStatus.getDefaultActivity(), Util.stringFormat(getLastReplyTime()))));
                break label699;
            }
            paramViewGroup.topic_timestmap.setText("");
            break label699;
            label1411:
            paramViewGroup.topic_reply.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            paramViewGroup.topic_reply_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839286));
            break label805;
            label1483:
            paramViewGroup.trending_like.setText("");
            paramViewGroup.trending_like.setCompoundDrawablesWithIntrinsicBounds(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130838909), null, null, null);
            paramViewGroup.feed_trending_like_layout.setBackgroundDrawable(ThemeUtil.getViewBackgroundDrawable(paramForumActivityStatus.getDefaultActivity(), 2130838760, 2130838761));
            paramViewGroup.participate_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(ThemeUtil.getDrawableIdByPicNameDark("s_trend_like", paramForumActivityStatus.getDefaultActivity())));
        }
        label1577:
        paramViewGroup.trending_layout_bg.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839492));
        return paramListItemRemoveAnimatorController;
    }

    public View getTrendingTopicView(final int paramInt1, View paramView, ViewGroup paramViewGroup, final ForumActivityStatus paramForumActivityStatus, AQuery paramAQuery, final FeedListAdapter paramFeedListAdapter, final TapatalkForum paramTapatalkForum, final TapatalkAjaxLogAction paramTapatalkAjaxLogAction, boolean paramBoolean, int paramInt2, ListItemRemoveAnimatorController paramListItemRemoveAnimatorController) {
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof TrendingNoImageHodler))) {
            paramListItemRemoveAnimatorController = LayoutInflater.from(paramForumActivityStatus.getDefaultActivity()).inflate(2130903410, null);
            paramViewGroup = new TrendingNoImageHodler();
            paramViewGroup.trending_layout = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231452));
            paramViewGroup.trending_layout_bg = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231463));
            paramViewGroup.trending_topic = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231453));
            paramViewGroup.trendingTopicContent = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231457));
            paramViewGroup.forumName = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231454));
            paramViewGroup.topic_title = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231455));
            paramViewGroup.topic_reply = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231460));
            paramViewGroup.topic_paticipate = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231458));
            paramViewGroup.participate_icon = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231459));
            paramViewGroup.topic_reply_icon = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231212));
            paramViewGroup.topic_content = ((ShortContentView) paramListItemRemoveAnimatorController.findViewById(2131231461));
            paramViewGroup.topic_timestmap = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231462));
            paramViewGroup.topic_user_icon = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231456));
            paramViewGroup.feed_trending_like_layout = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231685));
            paramViewGroup.feed_trending_unlike_layout = ((RelativeLayout) paramListItemRemoveAnimatorController.findViewById(2131231687));
            paramViewGroup.trending_like = ((TextView) paramListItemRemoveAnimatorController.findViewById(2131231686));
            paramViewGroup.trending_unlike = ((ImageView) paramListItemRemoveAnimatorController.findViewById(2131231688));
            paramViewGroup.topic_user_icon.bringToFront();
            paramViewGroup.trending_layout_bg.bringToFront();
            paramListItemRemoveAnimatorController.setTag(paramViewGroup);
            paramView = (AQuery) paramAQuery.recycle(paramListItemRemoveAnimatorController);
            paramViewGroup.trending_layout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("trending_topic_item_bg", paramForumActivityStatus.getDefaultActivity()));
            paramViewGroup.forumName.setText(getTapatalkForumName() + " ");
            if ((this.authorName == null) && (this.authorDisplayName == null)) {
                break label1113;
            }
            if (this.authorDisplayName == null) {
                break label1105;
            }
            paramView = this.authorDisplayName;
            label411:
            if (!SettingsFragment.isShowTopicPrefix(paramForumActivityStatus.getDefaultActivity())) {
                break label1136;
            }
            paramViewGroup.topic_title.setVisibility(0);
            paramViewGroup.topic_title.setText(getPrefix() + getTitle());
            label463:
            paramViewGroup.topic_title.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            ((RoundedImageView) paramViewGroup.topic_user_icon).setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839528));
            ImageTools.glideLoad(this.icon_url, paramViewGroup.topic_user_icon, 2130837858);
            if (Util.is2GState(paramForumActivityStatus.getDefaultActivity())) {
                break label1184;
            }
            paramAQuery = (RelativeLayout.LayoutParams) paramViewGroup.trending_topic.getLayoutParams();
            paramAQuery.height = paramInt2;
            paramViewGroup.trending_topic.setLayoutParams(paramAQuery);
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1158;
            }
            paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165234));
            label603:
            paramViewGroup.forumName.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165214));
            paramViewGroup.forumName.getBackground().setAlpha(80);
            paramViewGroup.topic_timestmap.setVisibility(0);
            if (this.timeStamp == 0) {
                break label1284;
            }
            paramViewGroup.topic_timestmap.setText(getTimeStampText(paramForumActivityStatus.getDefaultActivity(), Util.getTimeString(paramForumActivityStatus.getDefaultActivity(), this.timeStamp)));
            label685:
            paramViewGroup.topic_reply.setText(getReplyCount());
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1353;
            }
            paramViewGroup.topic_reply.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165307));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165307));
            paramViewGroup.topic_reply_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839285));
            label791:
            paramViewGroup.topic_paticipate.setText(getThumbCount());
            paramViewGroup.topic_content.setText(getContent(paramForumActivityStatus.getDefaultActivity(), paramView + " ", getShortContent()));
            if (!isThumbUp()) {
                break label1425;
            }
            paramViewGroup.trending_like.setText(paramForumActivityStatus.getDefaultActivity().getResources().getString(2131100934));
            paramViewGroup.trending_like.setCompoundDrawablesWithIntrinsicBounds(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130838910), null, null, null);
            paramViewGroup.feed_trending_like_layout.setBackgroundDrawable(ThemeUtil.getViewBackgroundDrawable(paramForumActivityStatus.getDefaultActivity(), 2130838764, 2130838765));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165582));
            paramViewGroup.participate_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839287));
        }
        for (; ; ) {
            paramViewGroup.feed_trending_like_layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (TapatalkIdFactory.getTapatalkId(paramForumActivityStatus.getDefaultActivity()).isTapatalkIdLogin()) {
                        if (Topic.this.isThumbUp()) {
                            Topic.this.setThumbCount(Topic.this.getThumbCount() - 1);
                            Topic.this.setThumbUp(false);
                            paramTapatalkAjaxLogAction.logTapatalkLog(TapatalkLogUrlUtil.getTrendingTopicThumbupUrl(paramForumActivityStatus.getDefaultActivity(), paramTapatalkForum.getId().intValue(), Topic.this.getId(), 2));
                        }
                        for (; ; ) {
                            paramFeedListAdapter.notifyDataSetChanged();
                            return;
                            Topic.this.setThumbCount(Topic.this.getThumbCount() + 1);
                            Topic.this.setThumbUp(true);
                            paramTapatalkAjaxLogAction.logTapatalkLog(TapatalkLogUrlUtil.getTrendingTopicThumbupUrl(paramForumActivityStatus.getDefaultActivity(), paramTapatalkForum.getId().intValue(), Topic.this.getId(), 1));
                        }
                    }
                    paramAnonymousView = new Intent();
                    paramAnonymousView.setClass(paramForumActivityStatus.getDefaultActivity(), ObEntryActivity.class);
                    paramAnonymousView.putExtra("accountPage", true);
                    paramAnonymousView.putExtra("guestLogin", true);
                    paramForumActivityStatus.getDefaultActivity().startActivityForResult(paramAnonymousView, 37);
                }
            });
            paramViewGroup.feed_trending_unlike_layout.setBackgroundDrawable(ThemeUtil.getViewBackgroundDrawable(paramForumActivityStatus.getDefaultActivity(), 2130838762, 2130838763));
            paramViewGroup.feed_trending_unlike_layout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (TapatalkIdFactory.getTapatalkId(paramForumActivityStatus.getDefaultActivity()).isTapatalkIdLogin()) {
                        paramFeedListAdapter.animationDelete(paramFeedListAdapter.getGroupCount() - 1, paramInt1);
                        if (paramTapatalkForum != null) {
                            paramTapatalkAjaxLogAction.logTapatalkLog(TapatalkLogUrlUtil.getTrendingTopicThumbupUrl(paramForumActivityStatus.getDefaultActivity(), paramTapatalkForum.getId().intValue(), Topic.this.getId(), 0));
                        }
                        paramFeedListAdapter.notifyDataSetChanged();
                        return;
                    }
                    paramAnonymousView = new Intent();
                    paramAnonymousView.setClass(paramForumActivityStatus.getDefaultActivity(), ObEntryActivity.class);
                    paramAnonymousView.putExtra("accountPage", true);
                    paramAnonymousView.putExtra("guestLogin", true);
                    paramForumActivityStatus.getDefaultActivity().startActivityForResult(paramAnonymousView, 37);
                }
            });
            if (!SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                break label1519;
            }
            paramViewGroup.trending_layout_bg.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839491));
            return paramListItemRemoveAnimatorController;
            paramViewGroup = (TrendingNoImageHodler) paramView.getTag();
            paramListItemRemoveAnimatorController = paramView;
            break;
            label1105:
            paramView = this.authorName;
            break label411;
            label1113:
            if (this.lastPosterDisplayName != null) {
                paramView = this.lastPosterDisplayName;
                break label411;
            }
            paramView = this.lastPosterName;
            break label411;
            label1136:
            paramViewGroup.topic_title.setVisibility(0);
            paramViewGroup.topic_title.setText(getTitle());
            break label463;
            label1158:
            paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165602));
            break label603;
            label1184:
            if (SettingsFragment.isLightTheme(paramForumActivityStatus.getDefaultActivity())) {
                paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165234));
            }
            for (; ; ) {
                paramViewGroup.forumName.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165214));
                paramViewGroup.forumName.getBackground().setAlpha(80);
                break;
                paramViewGroup.trending_topic.setBackgroundColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165602));
            }
            label1284:
            if ((getLastReplyTime() != null) && (!getLastReplyTime().equals(""))) {
                paramViewGroup.topic_timestmap.setText(getTimeStampText(paramForumActivityStatus.getDefaultActivity(), Util.formatSmartDate(paramForumActivityStatus.getDefaultActivity(), Util.stringFormat(getLastReplyTime()))));
                break label685;
            }
            paramViewGroup.topic_timestmap.setText("");
            break label685;
            label1353:
            paramViewGroup.topic_reply.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            paramViewGroup.topic_paticipate.setTextColor(paramForumActivityStatus.getDefaultActivity().getResources().getColor(2131165213));
            paramViewGroup.topic_reply_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839286));
            break label791;
            label1425:
            paramViewGroup.trending_like.setText("");
            paramViewGroup.trending_like.setCompoundDrawablesWithIntrinsicBounds(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130838909), null, null, null);
            paramViewGroup.feed_trending_like_layout.setBackgroundDrawable(ThemeUtil.getViewBackgroundDrawable(paramForumActivityStatus.getDefaultActivity(), 2130838760, 2130838761));
            paramViewGroup.participate_icon.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(ThemeUtil.getDrawableIdByPicNameDark("s_trend_like", paramForumActivityStatus.getDefaultActivity())));
        }
        label1519:
        paramViewGroup.trending_layout_bg.setBackgroundDrawable(paramForumActivityStatus.getDefaultActivity().getResources().getDrawable(2130839492));
        return paramListItemRemoveAnimatorController;
    }

    public int getViewCount() {
        return this.viewCount;
    }

    public String getViewString(Context paramContext) {
        paramContext = this.viewCount;
        if (this.viewCount > 1000000) {
            paramContext = this.viewCount / 1000000 + "M";
        }
        while (this.viewCount <= 1000) {
            return paramContext;
        }
        return this.viewCount / 1000 + "K";
    }

    public boolean isAnn() {
        return this.isAnn;
    }

    public boolean isApproved() {
        return this.isApproved;
    }

    public boolean isBan() {
        return this.isBan;
    }

    public boolean isCanApprove() {
        return this.canApprove;
    }

    public boolean isCanBan() {
        return this.canBan;
    }

    public boolean isCanClose() {
        return this.canClose;
    }

    public boolean isCanDelete() {
        return this.canDelete;
    }

    public boolean isCanMerge() {
        return this.canMerge;
    }

    public boolean isCanMove() {
        return this.canMove;
    }

    public boolean isCanPost() {
        return this.canPost;
    }

    public boolean isCanRename() {
        return this.canRename;
    }

    public boolean isCanStick() {
        return this.canStick;
    }

    public boolean isCanSubscribe() {
        return this.canSubscribe;
    }

    public boolean isCanUpload() {
        return this.canUpload;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public boolean isHas_notification_mode() {
        return this.has_notification_mode;
    }

    public boolean isMerged() {
        return this.isMerged;
    }

    public boolean isMoved() {
        return this.isMoved;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }

    public boolean isSticked() {
        return this.isSticked;
    }

    public boolean isSubscribe() {
        return this.isSubscribe;
    }

    public boolean isThumbUp() {
        return this.isThumbUp;
    }

    public AlertDialog longClickAlertDialog(final NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, final Activity paramActivity, final ForumStatus paramForumStatus) {
        final TopicDialogAdapter localTopicDialogAdapter = new TopicDialogAdapter(paramActivity, 5, this, paramNewSubscribeForumAndTopicAdapter.forumStatus);
        new AlertDialog.Builder(paramActivity).setTitle(getTitle()).setAdapter(localTopicDialogAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = localTopicDialogAdapter.getItem(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099846))) {
                    Toast.makeText(paramActivity, paramActivity.getString(2131099902), 0).show();
                    Topic.this.subscribeTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                }
                do {
                    return;
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099847))) {
                        Toast.makeText(paramActivity, paramActivity.getString(2131099904), 0).show();
                        Topic.this.unSubscribeTopic(paramNewSubscribeForumAndTopicAdapter, paramActivity);
                        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100054))) {
                        Topic.this.actionShareTopic(paramNewSubscribeForumAndTopicAdapter.forumStatus, paramActivity);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100067))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramNewSubscribeForumAndTopicAdapter, Topic.this).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100102))) {
                        ModerationDialogAdapter.getModerateDialog(paramActivity, paramForumStatus, paramNewSubscribeForumAndTopicAdapter, Topic.this).show();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131099819))) {
                        paramForumStatus.addReadTopicMark(Topic.this.getId());
                        Topic.this.setNewPost(false);
                        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
                        paramAnonymousDialogInterface = new TopicAction(paramActivity, paramForumStatus);
                        if (paramForumStatus.isMarkTopicRead()) {
                            paramAnonymousDialogInterface.markTopicRead(Topic.this.id);
                            return;
                        }
                        paramAnonymousDialogInterface.markTopicRead(Topic.this.id, Topic.this.replyCount);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100093))) {
                        Topic.this.openMode = "2";
                        Topic.this.openThread(paramActivity, paramForumStatus);
                        Topic.this.openMode = null;
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100091))) {
                        Topic.this.openMode = "1";
                        Topic.this.openThread(paramActivity, paramForumStatus);
                        Topic.this.openMode = null;
                        return;
                    }
                } while (!paramAnonymousDialogInterface.equalsIgnoreCase(paramActivity.getString(2131100092)));
                Topic.this.openMode = "0";
                Topic.this.openThread(paramActivity, paramForumStatus);
                Topic.this.openMode = null;
            }
        }).create();
    }

    public void markTopicRead(Activity paramActivity, ForumStatus paramForumStatus) {
        HashMap localHashMap = new HashMap();
        localHashMap.put("forumStatus", paramForumStatus);
        localHashMap.put("topic_id", this.id);
        localHashMap.put("topic_title", getTitle());
        localHashMap.put("reply_count", Integer.valueOf(getReplyCount()));
        localHashMap.put("forumid", getForumId());
        localHashMap.put("isNew", Boolean.valueOf(this.newPost));
        localHashMap.put("isAnn", Boolean.valueOf(this.isAnn));
        localHashMap.put("topic", this);
        paramForumStatus.addReadTopicMark(this.id);
        setNewPost(false);
        ((SlidingMenuActivity) paramActivity).getActionBar().setDisplayShowTitleEnabled(false);
        ((SlidingMenuActivity) paramActivity).showDetail(new ThreadOuterFragment(false, localHashMap));
    }

    public boolean onClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        if (paramForumActivityStatus.getForumStatus() != null) {
            openThread(paramForumActivityStatus.getDefaultActivity(), paramForumActivityStatus.getForumStatus());
        }
        return false;
    }

    public boolean onLongClick(View paramView, ForumActivityStatus paramForumActivityStatus) {
        return false;
    }

    public void openAndChangeThread(final Activity paramActivity) {
        if (this.newPost) {
            ((BackListFragment) ((SlidingMenuActivity) paramActivity).getmFrag()).setChangeIngerface(new BackListFragment.ChangeUnreadNumbers() {
                public void setUnreadNumbers(BackListAdapter paramAnonymousBackListAdapter) {
                    int i;
                    if ((paramAnonymousBackListAdapter != null) && (paramAnonymousBackListAdapter.tabItemList != null)) {
                        i = 0;
                        if (i >= paramAnonymousBackListAdapter.tabItemList.size()) {
                            paramAnonymousBackListAdapter.notifyDataSetChanged();
                        }
                    } else {
                        return;
                    }
                    if (((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getMenuid() == 1019) {
                        Object localObject = ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).getTabName();
                        localObject = Pattern.compile("[^0-9]").matcher((CharSequence) localObject);
                        int j = 0;
                        if (!((Matcher) localObject).replaceAll("").trim().equals("")) {
                            j = Integer.valueOf(((Matcher) localObject).replaceAll("").trim()).intValue() - 1;
                        }
                        if (j <= 0) {
                            break label177;
                        }
                        ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(paramActivity.getString(2131100417) + " (" + j + ") ");
                    }
                    for (; ; ) {
                        i += 1;
                        break;
                        label177:
                        ((TabItem) paramAnonymousBackListAdapter.tabItemList.get(i)).setTabName(paramActivity.getString(2131100417));
                    }
                }
            });
            ((BackListFragment) ((SlidingMenuActivity) paramActivity).getmFrag()).ChangeUnreadNumbers();
        }
    }

    public void openThread(Activity paramActivity, ForumStatus paramForumStatus) {
        openThread(paramActivity, paramForumStatus, "account");
    }

    public void openThread(Activity paramActivity, ForumStatus paramForumStatus, String paramString) {
        openThread(paramActivity, paramForumStatus, paramString, false);
    }

    public void openThread(Activity paramActivity, ForumStatus paramForumStatus, String paramString, boolean paramBoolean) {
        if ((paramActivity instanceof SlidingMenuActivity)) {
            if ((((SlidingMenuActivity) paramActivity).getOuterFragment() != null) && ((((SlidingMenuActivity) paramActivity).getOuterFragment() instanceof ThreadOuterFragment)) && (((ThreadOuterFragment) ((SlidingMenuActivity) paramActivity).getOuterFragment()).quoteHelper != null) && (((ThreadOuterFragment) ((SlidingMenuActivity) paramActivity).getOuterFragment()).quoteHelper.singleActionmMode != null)) {
                ((ThreadOuterFragment) ((SlidingMenuActivity) paramActivity).getOuterFragment()).quoteHelper.singleActionmMode.finish();
            }
            UmsAgent.onEvent(paramActivity, getId(), paramForumStatus.getForumId());
            localObject = new HashMap();
            ((HashMap) localObject).put("forumStatus", paramForumStatus);
            ((HashMap) localObject).put("topic_id", this.id);
            ((HashMap) localObject).put("topic_title", getTitle());
            ((HashMap) localObject).put("reply_count", Integer.valueOf(getReplyCount()));
            ((HashMap) localObject).put("forumid", getForumId());
            ((HashMap) localObject).put("isNew", Boolean.valueOf(this.newPost));
            if (!paramForumStatus.isLogin()) {
                ((HashMap) localObject).put("goto_first_post", Boolean.valueOf(true));
            }
            ((HashMap) localObject).put("isAnn", Boolean.valueOf(this.isAnn));
            ((HashMap) localObject).put("topic", this);
            ((HashMap) localObject).put("channel", paramString);
            ((HashMap) localObject).put("openMode", this.openMode);
            paramForumStatus.addReadTopicMark(this.id);
            setNewPost(false);
            ((SlidingMenuActivity) paramActivity).getActionBar().setDisplayShowTitleEnabled(false);
            ((SlidingMenuActivity) paramActivity).showDetail(new ThreadOuterFragment(false, (HashMap) localObject));
            return;
        }
        Object localObject = new Intent();
        ((Intent) localObject).setClass(paramActivity, ThreadActivity.class);
        ((Intent) localObject).putExtra("forumStatus", paramForumStatus);
        if (!paramForumStatus.isLogin()) {
            ((Intent) localObject).putExtra("goto_first_post", true);
        }
        ((Intent) localObject).putExtra("topic_id", this.id);
        ((Intent) localObject).putExtra("topic_title", getTitle());
        ((Intent) localObject).putExtra("reply_count", getReplyCount());
        ((Intent) localObject).putExtra("forumid", getForumId());
        ((Intent) localObject).putExtra("isNew", this.newPost);
        ((Intent) localObject).putExtra("isAnn", this.isAnn);
        ((Intent) localObject).putExtra("topic", this);
        ((Intent) localObject).putExtra("channel", paramString);
        ((Intent) localObject).putExtra("openMode", this.openMode);
        if (paramBoolean) {
            ((Intent) localObject).putExtra("fromFeed", true);
        }
        paramForumStatus.addReadTopicMark(this.id);
        setNewPost(false);
        paramActivity.startActivityForResult((Intent) localObject, 8);
    }

    public void openThreadAndChangeUnreadNum(BaseAdapter paramBaseAdapter, Activity paramActivity, ForumStatus paramForumStatus) {
        openAndChangeThread(paramActivity);
        openThread(paramActivity, paramForumStatus);
        paramBaseAdapter.notifyDataSetChanged();
    }

    public void openThreadAndChangeUnreadNum(BaseExpandableListAdapter paramBaseExpandableListAdapter, Activity paramActivity, ForumStatus paramForumStatus) {
        openAndChangeThread(paramActivity);
        openThread(paramActivity, paramForumStatus);
        paramBaseExpandableListAdapter.notifyDataSetChanged();
    }

    public void openThreadByPost(Activity paramActivity, ForumStatus paramForumStatus) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, ThreadActivity.class);
        localIntent.putExtra("forumStatus", paramForumStatus);
        localIntent.putExtra("topic_id", this.id);
        localIntent.putExtra("topic_title", getTitle());
        localIntent.putExtra("reply_count", getReplyCount());
        localIntent.putExtra("forumid", getForumId());
        localIntent.putExtra("isNew", this.newPost);
        localIntent.putExtra("isAnn", this.isAnn);
        localIntent.putExtra("topic", this);
        localIntent.putExtra("post_id", getPostId());
        localIntent.putExtra("getPost", true);
        paramForumStatus.addReadTopicMark(this.id);
        setNewPost(false);
        paramActivity.startActivityForResult(localIntent, 8);
    }

    public void openThreadFromFeed(TapatalkForum paramTapatalkForum, Activity paramActivity, String paramString) {
        setNewPost(false);
        Intent localIntent = new Intent();
        localIntent.setClass(paramActivity, ThreadActivity.class);
        localIntent.putExtra("topic_id", getId());
        localIntent.putExtra("topic_title", getTitle());
        localIntent.putExtra("reply_count", getReplyCount());
        localIntent.putExtra("forumId", getForumId());
        localIntent.putExtra("forum", paramTapatalkForum);
        localIntent.putExtra("goto_first_post", true);
        localIntent.putExtra("fromFeed", true);
        localIntent.putExtra("channel", paramString);
        paramActivity.startActivity(localIntent);
    }

    public void rename(ForumRootAdapter paramForumRootAdapter, Context paramContext, String paramString) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        paramContext.add(paramString.getBytes());
        setTitle(paramString);
        paramForumRootAdapter.notifyDataSetChanged();
        paramForumRootAdapter.getEngine().call("m_rename_topic", paramContext);
    }

    public void rename(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext, String paramString) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        paramContext.add(paramString.getBytes());
        setTitle(paramString);
        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_rename_topic", paramContext);
    }

    public boolean requiredPrefix() {
        return this.requiredPrefix;
    }

    public void selfChange(View paramView, ForumActivityStatus paramForumActivityStatus) {
    }

    public void setAnn(boolean paramBoolean) {
        this.isAnn = paramBoolean;
    }

    public void setApproved(boolean paramBoolean) {
        this.isApproved = paramBoolean;
    }

    public void setAttachFlag(int paramInt) {
        this.attachment_flag = paramInt;
    }

    public void setAuthorDisplayName(String paramString) {
        this.authorDisplayName = paramString;
    }

    public void setAuthorId(String paramString) {
        this.authorId = paramString;
    }

    public void setAuthorName(String paramString) {
        this.authorName = paramString;
    }

    public void setBan(boolean paramBoolean) {
        this.isBan = paramBoolean;
    }

    public void setCanApprove(boolean paramBoolean) {
        this.canApprove = paramBoolean;
    }

    public void setCanBan(boolean paramBoolean) {
        this.canBan = paramBoolean;
    }

    public void setCanClose(boolean paramBoolean) {
        this.canClose = paramBoolean;
    }

    public void setCanDelete(boolean paramBoolean) {
        this.canDelete = paramBoolean;
    }

    public void setCanMerge(boolean paramBoolean) {
        this.canMerge = paramBoolean;
    }

    public void setCanMove(boolean paramBoolean) {
        this.canMove = paramBoolean;
    }

    public void setCanPost(boolean paramBoolean) {
        this.canPost = paramBoolean;
    }

    public void setCanRename(boolean paramBoolean) {
        this.canRename = paramBoolean;
    }

    public void setCanStick(boolean paramBoolean) {
        this.canStick = paramBoolean;
    }

    public void setCanSubscribe(boolean paramBoolean) {
        this.canSubscribe = paramBoolean;
    }

    public void setCanUpload(boolean paramBoolean) {
        this.canUpload = paramBoolean;
    }

    public void setClosed(boolean paramBoolean) {
        this.isClosed = paramBoolean;
    }

    public void setDeleted(boolean paramBoolean) {
        this.isDeleted = paramBoolean;
    }

    public void setForum(Forum paramForum) {
        this.forum = paramForum;
    }

    public void setForumId(String paramString) {
        this.forumId = paramString;
    }

    public void setForumName(String paramString) {
        this.forumName = paramString;
    }

    public void setForumUrl(String paramString) {
        this.forumUrl = paramString;
    }

    public void setHas_notification_mode(boolean paramBoolean) {
        this.has_notification_mode = paramBoolean;
    }

    public void setIconUrl(String paramString) {
        this.icon_url = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setLastPosterDisplayName(String paramString) {
        this.lastPosterDisplayName = paramString;
    }

    public void setLastPosterId(String paramString) {
        this.lastPosterId = paramString;
    }

    public void setLastPosterName(String paramString) {
        this.lastPosterName = paramString;
    }

    public void setLastReplyTime(Date paramDate, Context paramContext) {
        this.lastReplyTime = paramDate;
        this.lastReplyTimeString = Util.formatDate(getLastReplyTime(), paramContext);
    }

    public void setLocalIconUri(String paramString) {
        this.localIconUri = paramString;
    }

    public void setLoginStatus(LoginStatus paramLoginStatus) {
        this.loginStatus = paramLoginStatus;
    }

    public void setMerged(boolean paramBoolean) {
        this.isMerged = paramBoolean;
    }

    public void setMoved(boolean paramBoolean) {
        this.isMoved = paramBoolean;
    }

    public void setNewPost(boolean paramBoolean) {
        this.newPost = paramBoolean;
    }

    public void setPostId(String paramString) {
        this.postId = paramString;
    }

    public void setPrefix(String paramString) {
        this.prefix = paramString;
    }

    public void setPrefixes(ArrayList<HashMap<String, Object>> paramArrayList) {
        this.prefixes = paramArrayList;
    }

    public void setReal_topic_id(String paramString) {
        this.real_topic_id = paramString;
    }

    public void setRedirect(boolean paramBoolean) {
        this.isRedirect = paramBoolean;
    }

    public void setReplyCount(int paramInt) {
        this.replyCount = paramInt;
    }

    public void setRequiredPrefix(boolean paramBoolean) {
        this.requiredPrefix = paramBoolean;
    }

    public void setShortContent(String paramString) {
        this.shortContent = paramString;
    }

    public void setSticked(boolean paramBoolean) {
        this.isSticked = paramBoolean;
    }

    public void setSubscribe(boolean paramBoolean) {
        this.isSubscribe = paramBoolean;
    }

    public void setTapatalkForumId(String paramString) {
        this.tapatalkForumId = paramString;
    }

    public void setTapatalkForumName(String paramString) {
        this.tapatalkForumName = paramString;
    }

    public void setThumbCount(int paramInt) {
        this.thumbCount = paramInt;
    }

    public void setThumbType(int paramInt) {
        this.thumbType = paramInt;
    }

    public void setThumbUp(boolean paramBoolean) {
        this.isThumbUp = paramBoolean;
    }

    public void setTimeStamp(int paramInt) {
        this.timeStamp = paramInt;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setTopicImgUrl(String paramString) {
        this.topicImgUrl = paramString;
    }

    public void setViewCount(int paramInt) {
        this.viewCount = paramInt;
    }

    public void showTrendingTopicLogo(ForumActivityStatus paramForumActivityStatus, ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2) {
        if (!Util.is2GState(paramForumActivityStatus.getDefaultActivity())) {
            if (SettingsFragment.isShowAvatar(paramForumActivityStatus.getDefaultActivity())) {
                if (getIconUrl() != null) {
                    ImageTools.glideLoad(getIconUrl(), paramImageView1);
                    paramTextView.setVisibility(8);
                    return;
                }
                paramTextView.setVisibility(0);
                paramImageView2.setVisibility(8);
                return;
            }
            paramImageView1.setVisibility(8);
            paramTextView.setVisibility(8);
            paramImageView2.setVisibility(8);
            return;
        }
        if (SettingsFragment.isShowAvatarWithSlowConn(paramForumActivityStatus.getDefaultActivity())) {
            if (getIconUrl() != null) {
                ImageTools.glideLoad(getIconUrl(), paramImageView1);
                paramTextView.setVisibility(8);
                return;
            }
            paramTextView.setVisibility(0);
            paramImageView2.setVisibility(8);
            return;
        }
        paramImageView1.setVisibility(8);
        paramTextView.setVisibility(8);
        paramImageView2.setVisibility(8);
    }

    public void stickyTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        localArrayList.add(Integer.valueOf(1));
        Toast.makeText(paramContext, paramContext.getString(2131100022), 1).show();
        paramForumRootAdapter.getEngine().call("m_stick_topic", localArrayList);
    }

    public void stickyTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        localArrayList.add(Integer.valueOf(1));
        Toast.makeText(paramContext, paramContext.getString(2131100022), 1).show();
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_stick_topic", localArrayList);
    }

    public void subscribeTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        setSubscribe(true);
        if ((paramForumRootAdapter instanceof SubForumAdapter)) {
            ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().notifyDataSetChanged();
        }
        for (; ; ) {
            paramForumRootAdapter.getEngine().call("subscribe_topic", paramContext);
            SlidingMenuActivity.needRefreshSubscribe = true;
            return;
            paramForumRootAdapter.notifyDataSetChanged();
        }
    }

    public void subscribeTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext, int paramInt) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        setSubscribe(true);
        if ((paramForumRootAdapter instanceof SubForumAdapter)) {
            ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().notifyDataSetChanged();
        }
        for (; ; ) {
            paramForumRootAdapter.getEngine().call("subscribe_topic", paramContext);
            SlidingMenuActivity.needRefreshSubscribe = true;
            return;
            paramForumRootAdapter.notifyDataSetChanged();
        }
    }

    public void subscribeTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        setSubscribe(true);
        paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("subscribe_topic", paramContext);
        SlidingMenuActivity.needRefreshSubscribe = true;
    }

    public void unDeletePost(ForumRootAdapter paramForumRootAdapter, Context paramContext) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        setDeleted(false);
        paramContext = new ArrayList();
        paramContext.add(getPostId());
        paramContext.add("".getBytes());
        paramForumRootAdapter.getEngine().call("m_undelete_post", paramContext);
    }

    public void unDeletePost(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        setDeleted(false);
        paramContext = new ArrayList();
        paramContext.add(getPostId());
        paramContext.add("".getBytes());
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_undelete_post", paramContext);
    }

    public void unDeleteTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        setDeleted(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        paramContext.add("".getBytes());
        paramForumRootAdapter.getEngine().call("m_undelete_topic", paramContext);
    }

    public void unDeleteTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        setDeleted(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        paramContext.add("".getBytes());
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_undelete_topic", paramContext);
    }

    public void unSubscribeTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        setSubscribe(false);
        if ((paramForumRootAdapter instanceof SubForumAdapter)) {
            ((SubForumAdapter) paramForumRootAdapter).getCurAdapter().notifyDataSetChanged();
        }
        for (; ; ) {
            paramForumRootAdapter.getEngine().call("unsubscribe_topic", paramContext);
            if ((paramForumRootAdapter instanceof SubscribeForumAndTopicAdapter)) {
                ((SubscribeForumAndTopicAdapter) paramForumRootAdapter).removeItem(this);
            }
            SlidingMenuActivity.needRefreshSubscribe = true;
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

    public void unSubscribeTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        paramContext = new ArrayList();
        paramContext.add(getId());
        setSubscribe(false);
        if ((paramNewSubscribeForumAndTopicAdapter.topicDatas != null) && (paramNewSubscribeForumAndTopicAdapter.topicDatas.contains(this))) {
            paramNewSubscribeForumAndTopicAdapter.topicDatas.remove(this);
            if (paramNewSubscribeForumAndTopicAdapter.topicDatas.size() == 0) {
                paramNewSubscribeForumAndTopicAdapter.forumDatas.size();
            }
            paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
        }
        for (; ; ) {
            paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("unsubscribe_topic", paramContext);
            paramNewSubscribeForumAndTopicAdapter.removeTopicsItem(this);
            SlidingMenuActivity.needRefreshSubscribe = true;
            return;
            paramNewSubscribeForumAndTopicAdapter.notifyDataSetChanged();
        }
    }

    public void unstickyTopic(ForumRootAdapter paramForumRootAdapter, Context paramContext) {
        paramForumRootAdapter.setTryTwice(false);
        paramForumRootAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        localArrayList.add(Integer.valueOf(2));
        Toast.makeText(paramContext, paramContext.getString(2131100023), 1).show();
        paramForumRootAdapter.getEngine().call("m_stick_topic", localArrayList);
    }

    public void unstickyTopic(NewSubscribeForumAndTopicAdapter paramNewSubscribeForumAndTopicAdapter, Context paramContext) {
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setTryTwice(false);
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getId());
        localArrayList.add(Integer.valueOf(2));
        Toast.makeText(paramContext, paramContext.getString(2131100023), 1).show();
        paramNewSubscribeForumAndTopicAdapter.getSubscribeForumAndTopicAction().getEngine().call("m_stick_topic", localArrayList);
    }

    public static class TopicViewHolder {
        public ImageView ann;
        public ImageView approve;
        public ImageView attach;
        public ImageView avaterbg;
        public ImageView breaker;
        public ImageView breaker2;
        public ImageView close;
        public ImageView defaultIconView = null;
        public ImageView forumLogo;
        public TextView forumTitle;
        public RelativeLayout forumtitle_lay;
        public View llayout1;
        public ImageView notificationMode;
        public ImageView redirect;
        public ImageView replyIcon;
        public TextView replyNum;
        public ShortContentView shortContent;
        public ColorStateList shortContentColor;
        public int shortContentFlag;
        public ImageView sticky;
        public TextView topicAuthor;
        public ColorStateList topicAuthorColor;
        public int topicAuthorFlag;
        public ImageView topicImg;
        public TextView topicTime;
        public ColorStateList topicTimeColor;
        public int topicTimeFlag;
        public NewTitleTextView topicTitle;
        public ColorStateList topicTitleColor;
        public int topicTitleFlag;
        public GifImageView userIcon;
        public TextView viewDefaultIcon;
        public ImageView viewIcon;
        public TextView viewNum;
    }

    public class TrendingHodler {
        private RelativeLayout feed_trending_like_layout;
        private RelativeLayout feed_trending_unlike_layout;
        private TextView forumName;
        private ImageView participate_icon;
        private ShortContentView topic_content;
        private TextView topic_paticipate;
        private TextView topic_reply;
        private ImageView topic_reply_icon;
        private TextView topic_timestmap;
        private TextView topic_title;
        private ImageView topic_user_icon;
        private ImageView topic_user_icon_bg;
        private ImageView topic_user_icon_default;
        private ImageView trendingImage;
        private RelativeLayout trendingTopicContent;
        private RelativeLayout trending_layout;
        private RelativeLayout trending_layout_bg;
        private TextView trending_like;
        private RelativeLayout trending_topic;
        private ImageView trending_unlike;

        public TrendingHodler() {
        }
    }

    public class TrendingNoImageHodler {
        private RelativeLayout feed_trending_like_layout;
        private RelativeLayout feed_trending_unlike_layout;
        private TextView forumName;
        private ImageView participate_icon;
        private ShortContentView topic_content;
        private TextView topic_paticipate;
        private TextView topic_reply;
        private ImageView topic_reply_icon;
        private TextView topic_timestmap;
        private TextView topic_title;
        private ImageView topic_user_icon;
        private ImageView topic_user_icon_bg;
        private ImageView topic_user_icon_default;
        private RelativeLayout trendingTopicContent;
        private RelativeLayout trending_layout;
        private RelativeLayout trending_layout_bg;
        private TextView trending_like;
        private RelativeLayout trending_topic;
        private ImageView trending_unlike;

        public TrendingNoImageHodler() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Topic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */