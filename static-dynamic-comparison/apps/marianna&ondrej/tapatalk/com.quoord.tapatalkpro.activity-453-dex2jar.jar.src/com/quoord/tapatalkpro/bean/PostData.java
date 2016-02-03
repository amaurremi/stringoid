package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.DialogUtil.ModerationDialogAdapter;
import com.quoord.DialogUtil.ThreadDialogUtil;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.activity.forum.BanUserActivity;
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.EditTopicTitleActivity;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.MessageContentAdapter;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.postdata.ui.LikeAndThankActivity;
import com.quoord.tapatalkpro.ui.CustomImageViewLayout;
import com.quoord.tapatalkpro.ui.ThreadQuoteHelper;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.BBcodeUtil.BBElement;
import com.quoord.tapatalkpro.util.ForumUrlUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.bitmap.ui.GifImageView;
import com.quoord.tools.net.HashUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PostData
        extends BaseBean
        implements Serializable, ParseableData {
    public ArrayList<HashMap> EditInfo = null;
    public boolean allowSmilies = true;
    public LinearLayout attach;
    public Object[] attachments = null;
    public String authorDisplayName;
    public String authorName;
    public boolean canApprove = false;
    public boolean canBan = false;
    public boolean canDelete = false;
    public boolean canEdit = false;
    public boolean canLike = false;
    public boolean canMerge = false;
    public boolean canMergePost = false;
    public boolean canMove = false;
    public boolean canThank = false;
    Comparator<Object> comp = new Mycomparator(null);
    public View contentView;
    private String edit_id;
    private String edit_name;
    private String edit_reason;
    private String edit_time;
    private int floor = 0;
    public int floorNum = -1;
    public InputStream iconData = null;
    public String iconDataType = null;
    public String icon_url = null;
    public boolean isApprove = true;
    public boolean isBan = false;
    public boolean isDeleted = false;
    public boolean isLike = false;
    public boolean isOnline = false;
    StringBuilder likeFullString;
    StringBuilder likeString;
    public ArrayList<HashMap> likeUsers = null;
    private ThreadAdapter mAdapter;
    public ArrayList<ImageInThread> mBeans = new ArrayList();
    public ArrayList<ImageInThread> mBeansFinished = new ArrayList();
    private ThreadOuterFragment mContext = null;
    private ThreadOuterFragment outFragment;
    public ArrayList<String> picUirs = new ArrayList();
    public LinearLayout postContent;
    public int postCount = -1;
    public String postId;
    public Date postTime;
    public String post_content;
    private List<BBcodeUtil.BBElement> posts = new ArrayList();
    public String replyTime;
    StringBuilder thanksFullString;
    StringBuilder thanksString;
    public ArrayList<HashMap> thanksUsers = null;
    private String tid;
    public int timeStamp;
    public ArrayList<String> url1 = new ArrayList();

    public PostData(ThreadOuterFragment paramThreadOuterFragment, ThreadAdapter paramThreadAdapter, String paramString) {
        this.outFragment = paramThreadOuterFragment;
        this.tid = paramString;
        this.mAdapter = paramThreadAdapter;
    }

    private void actionEditTitle(ForumStatus paramForumStatus) {
        Intent localIntent = new Intent();
        localIntent.setClass(this.outFragment.getActivity(), EditTopicTitleActivity.class);
        localIntent.putExtra("forumStatus", paramForumStatus);
        localIntent.putExtra("topic", this.outFragment.mTopic);
        localIntent.putExtra("modifytype", 53328);
        ArrayList localArrayList = this.outFragment.mTopic.getPrefixes();
        boolean bool;
        int j;
        int i;
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
            String str = this.outFragment.mTopic.getPrefix().trim();
            paramForumStatus = str;
            if (str.startsWith("[")) {
                paramForumStatus = str;
                if (str.endsWith("]")) {
                    paramForumStatus = str.substring(1, str.length() - 1);
                }
            }
            bool = this.outFragment.mTopic.requiredPrefix();
            j = -1;
            i = 0;
        }
        for (; ; ) {
            if (i >= localArrayList.size()) {
                i = j;
            }
            for (; ; ) {
                j = i;
                if (i == -1) {
                    bool = false;
                    j = 0;
                }
                localIntent.putExtra("prefixes", GetTopicAction.getPrefixForCreateTopic(this.outFragment.getActivity(), this.outFragment.mTopic.getPrefixes(), bool));
                localIntent.putExtra("prefixIndex", j);
                this.outFragment.getActivity().startActivityForResult(localIntent, 53328);
                return;
                if (!paramForumStatus.equals(HashUtil.getString(((HashMap) localArrayList.get(i)).get("prefix_display_name"), ""))) {
                    break;
                }
                j = i;
                i = j;
                if (!bool) {
                    i = j + 1;
                }
            }
            i += 1;
        }
    }

    private void actionModify(final ForumStatus paramForumStatus) {
        new ArrayList();
        new AlertDialog.Builder(this.outFragment.getActivity()).setTitle(this.outFragment.getActivity().getString(2131100039)).setAdapter(new ModerationDialogAdapter(this.outFragment.getActivity(), this, paramForumStatus), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = (String) ((AlertDialog) paramAnonymousDialogInterface).getListView().getItemAtPosition(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(PostData.this.outFragment.getActivity().getString(2131100098))) {
                    PostData.this.actionEdit(paramForumStatus);
                }
                do {
                    return;
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(PostData.this.outFragment.getActivity().getString(2131100034))) {
                        PostData.this.actionDelete();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(PostData.this.outFragment.getActivity().getString(2131100035))) {
                        PostData.this.outFragment.showProgress();
                        PostData.this.unDeletePost();
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(PostData.this.outFragment.getActivity().getString(2131100036))) {
                        PostData.this.outFragment.showProgress();
                        PostData.this.approvePost(true);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(PostData.this.outFragment.getActivity().getString(2131100037))) {
                        PostData.this.outFragment.showProgress();
                        PostData.this.approvePost(false);
                        return;
                    }
                    if (paramAnonymousDialogInterface.equalsIgnoreCase(PostData.this.outFragment.getActivity().getString(2131100057) + " " + PostData.this.getRealName())) {
                        paramAnonymousDialogInterface = new Intent(PostData.this.outFragment.getActivity(), BanUserActivity.class);
                        paramAnonymousDialogInterface.putExtra("username", PostData.this.getRealName());
                        paramAnonymousDialogInterface.putExtra("forumStatus", paramForumStatus);
                        paramAnonymousDialogInterface.putExtra("isBan", PostData.this.isBan);
                        PostData.this.outFragment.getActivity().startActivity(paramAnonymousDialogInterface);
                        return;
                    }
                }
                while (!paramAnonymousDialogInterface.equalsIgnoreCase(PostData.this.outFragment.getActivity().getString(2131100062)));
                if ((paramForumStatus.isSMF()) || (paramForumStatus.isSMF1()) || (paramForumStatus.isSMF2())) {
                    PostData.this.movePost();
                    return;
                }
                paramAnonymousDialogInterface = new Intent(PostData.this.outFragment.getActivity(), ModerateActivity.class);
                paramAnonymousDialogInterface.putExtra("forumStatus", paramForumStatus);
                paramAnonymousDialogInterface.putExtra("select_forum_action", 3);
                paramAnonymousDialogInterface.putExtra("post", PostData.this);
                paramAnonymousDialogInterface.putExtra("topic", PostData.this.outFragment.mTopic);
                PostData.this.outFragment.getActivity().startActivityForResult(paramAnonymousDialogInterface, 901);
            }
        }).create().show();
    }

    public static final String byte2hex(byte[] paramArrayOfByte) {
        String str1 = "";
        int i = 0;
        if (i >= paramArrayOfByte.length) {
            return str1.toUpperCase();
        }
        String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (str2.length() == 1) {
        }
        for (str1 = str1 + "0" + str2; ; str1 = str1 + str2) {
            i += 1;
            break;
        }
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassCastException {
        try {
            this.postId = ((String) paramObjectInputStream.readObject());
            this.picUirs = ((ArrayList) paramObjectInputStream.readObject());
            this.authorName = ((String) paramObjectInputStream.readObject());
            this.authorDisplayName = ((String) paramObjectInputStream.readObject());
            this.replyTime = ((String) paramObjectInputStream.readObject());
            this.post_content = ((String) paramObjectInputStream.readObject());
            this.thanksUsers = ((ArrayList) paramObjectInputStream.readObject());
            this.iconDataType = ((String) paramObjectInputStream.readObject());
            this.canEdit = paramObjectInputStream.readBoolean();
            this.canDelete = paramObjectInputStream.readBoolean();
            this.isOnline = paramObjectInputStream.readBoolean();
            this.allowSmilies = paramObjectInputStream.readBoolean();
            this.isApprove = paramObjectInputStream.readBoolean();
            this.isDeleted = paramObjectInputStream.readBoolean();
            this.canApprove = paramObjectInputStream.readBoolean();
            this.canBan = paramObjectInputStream.readBoolean();
            this.isBan = paramObjectInputStream.readBoolean();
            this.canThank = paramObjectInputStream.readBoolean();
            this.postCount = paramObjectInputStream.readInt();
            this.canLike = paramObjectInputStream.readBoolean();
            this.isLike = paramObjectInputStream.readBoolean();
            this.canMove = paramObjectInputStream.readBoolean();
            this.canMerge = paramObjectInputStream.readBoolean();
            this.canMergePost = paramObjectInputStream.readBoolean();
            return;
        } catch (ClassNotFoundException paramObjectInputStream) {
            paramObjectInputStream.printStackTrace();
        }
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        paramObjectOutputStream.writeObject(this.postId);
        paramObjectOutputStream.writeObject(this.picUirs);
        paramObjectOutputStream.writeObject(this.authorName);
        paramObjectOutputStream.writeObject(this.authorDisplayName);
        paramObjectOutputStream.writeObject(this.replyTime);
        paramObjectOutputStream.writeObject(this.post_content);
        paramObjectOutputStream.writeObject(this.thanksUsers);
        paramObjectOutputStream.writeObject(this.iconDataType);
        paramObjectOutputStream.writeBoolean(this.canEdit);
        paramObjectOutputStream.writeBoolean(this.canDelete);
        paramObjectOutputStream.writeBoolean(this.isOnline);
        paramObjectOutputStream.writeBoolean(this.allowSmilies);
        paramObjectOutputStream.writeBoolean(this.isApprove);
        paramObjectOutputStream.writeBoolean(this.isDeleted);
        paramObjectOutputStream.writeBoolean(this.canApprove);
        paramObjectOutputStream.writeBoolean(this.canBan);
        paramObjectOutputStream.writeBoolean(this.isBan);
        paramObjectOutputStream.writeBoolean(this.canThank);
        paramObjectOutputStream.writeInt(this.postCount);
        paramObjectOutputStream.writeBoolean(this.canLike);
        paramObjectOutputStream.writeBoolean(this.isLike);
        paramObjectOutputStream.writeBoolean(this.canMove);
        paramObjectOutputStream.writeBoolean(this.canMerge);
        paramObjectOutputStream.writeBoolean(this.canMergePost);
    }

    public void actionConvo(ForumStatus paramForumStatus) {
        Intent localIntent = new Intent(this.outFragment.getActivity(), CreateOrReplyConversationActivity.class);
        localIntent.putExtra("is_newConversation", true);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("postData", this);
        localBundle.putSerializable("forumStatus", paramForumStatus);
        localIntent.putExtras(localBundle);
        if ((this.outFragment != null) && (this.outFragment.mFragment != null) && (this.outFragment.mFragment.mThreadAdapter != null)) {
            localIntent.putExtra("can_upload", this.outFragment.mFragment.mThreadAdapter.isCanUpload());
        }
        this.outFragment.getActivity().startActivity(localIntent);
        this.outFragment.quoteHelper.actionFinish();
    }

    public void actionCopyPost() {
        Object localObject1 = "";
        int i;
        if (this.postContent != null) {
            i = 0;
        }
        View localView;
        int j;
        for (; ; ) {
            if (i >= this.postContent.getChildCount()) {
                ((ClipboardManager) this.outFragment.getActivity().getSystemService("clipboard")).setText(this.post_content + "<br/>");
                Toast.makeText(this.outFragment.getActivity(), this.outFragment.getActivity().getString(2131100177), 1).show();
                this.outFragment.quoteHelper.actionFinish();
                return;
            }
            localView = this.postContent.getChildAt(i);
            localObject2 = localObject1;
            if ((localView instanceof LinearLayout)) {
                j = 0;
                if (j < ((LinearLayout) localView).getChildCount()) {
                    break;
                }
                localObject2 = localObject1;
            }
            i += 1;
            localObject1 = localObject2;
        }
        Object localObject2 = localObject1;
        if ((((LinearLayout) localView).getChildAt(j) instanceof TextView)) {
            if (!(((TextView) ((LinearLayout) localView).getChildAt(j)).getText() instanceof SpannableString)) {
                break label264;
            }
            localObject2 = (SpannableString) ((TextView) ((LinearLayout) localView).getChildAt(j)).getText();
        }
        for (localObject2 = new StringBuilder(String.valueOf(localObject1)).append(((SpannableString) localObject2).toString()).toString() + "\n"; ; localObject2 = new StringBuilder(String.valueOf(localObject1)).append(((String) localObject2).toString()).toString() + "\n") {
            j += 1;
            localObject1 = localObject2;
            break;
            label264:
            localObject2 = (String) ((TextView) ((LinearLayout) localView).getChildAt(j)).getText();
        }
    }

    public void actionCopyUrl(ForumStatus paramForumStatus) {
        paramForumStatus = ForumUrlUtil.getPostUrl(paramForumStatus, this.postId, this.outFragment.mTopic.getId(), this.outFragment.mTopic.getTitle(), this.outFragment.mTopic.getForumId(), this.outFragment.mTopic.isAnn());
        ((ClipboardManager) this.outFragment.getActivity().getSystemService("clipboard")).setText(paramForumStatus);
        Toast.makeText(this.outFragment.getActivity(), this.outFragment.getActivity().getString(2131100176), 1).show();
        this.outFragment.quoteHelper.actionFinish();
    }

    public void actionDelete() {
        if (this.floor == 1) {
            ThreadDialogUtil.getDeleteFirstPostDialog(this.mAdapter.forumStatus, this.outFragment, this.mAdapter, this).show();
        }
        for (; ; ) {
            this.outFragment.quoteHelper.actionFinish();
            return;
            ThreadDialogUtil.getDeleteDialog(this.mAdapter.forumStatus, this.outFragment, this.mAdapter, this).show();
        }
    }

    public void actionEdit(final ForumStatus paramForumStatus) {
        if ((this.floor != 1) || (!this.outFragment.mTopic.isCanRename())) {
            getPostContent(this.postId);
            this.outFragment.showProgress();
            return;
        }
        final String str1 = this.outFragment.getActivity().getString(2131100099);
        final String str2 = this.outFragment.getActivity().getString(2131100273);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.outFragment.getActivity()).setTitle(this.outFragment.mTopic.getTitle());
        paramForumStatus = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = (String) ((AlertDialog) paramAnonymousDialogInterface).getListView().getItemAtPosition(paramAnonymousInt);
                if (paramAnonymousDialogInterface.equalsIgnoreCase(str1)) {
                    PostData.this.getPostContent(PostData.this.postId);
                    PostData.this.outFragment.showProgress();
                }
                while (!paramAnonymousDialogInterface.equalsIgnoreCase(str2)) {
                    return;
                }
                PostData.this.actionEditTitle(paramForumStatus);
            }
        };
        localBuilder.setItems(new String[]{str1, str2}, paramForumStatus).create().show();
    }

    public void actionOpenPostInBrowser(ForumStatus paramForumStatus) {
        String str2 = "";
        for (; ; ) {
            try {
                if (!paramForumStatus.isVB()) {
                    continue;
                }
                if (!this.outFragment.mTopic.isAnn()) {
                    continue;
                }
                str1 = paramForumStatus.getPrefectUrl() + "announcement.php?a=" + this.postId;
                paramForumStatus = new Intent("android.intent.action.VIEW", Uri.parse(str1));
                this.outFragment.getActivity().startActivity(paramForumStatus);
            } catch (Exception paramForumStatus) {
                String str1;
                continue;
            }
            this.outFragment.quoteHelper.actionFinish();
            return;
            str1 = paramForumStatus.getPrefectUrl() + "showthread.php?p=" + this.postId;
            continue;
            if (paramForumStatus.isIP()) {
                str1 = paramForumStatus.getPrefectUrl() + "index.php?/topic/" + this.outFragment.mTopic.getId() + "-" + this.outFragment.mTopic.getTitle() + "#entry" + this.postId;
            } else if (paramForumStatus.isPB()) {
                str1 = paramForumStatus.getPrefectUrl() + "viewtopic.php?t=" + this.outFragment.mTopic.getId() + "#p" + this.outFragment.mTopic.getTitle();
            } else if (paramForumStatus.isSMF()) {
                str1 = paramForumStatus.getPrefectUrl() + "index.php?topic=" + this.outFragment.mTopic.getId() + ".msg" + this.postId + "#msg" + this.postId;
            } else if (paramForumStatus.isXF()) {
                str1 = paramForumStatus.getPrefectUrl() + "posts/" + this.postId + "/";
            } else if ((paramForumStatus.isKN1()) || (paramForumStatus.isKN2()) || (paramForumStatus.isKN3())) {
                str1 = paramForumStatus.getPrefectUrl() + "index.php?option=com_kunena&func=view&catid=" + this.outFragment.mTopic.getForumId() + "&id=" + this.postId;
            } else if (paramForumStatus.isMB()) {
                str1 = paramForumStatus.getPrefectUrl() + "showthread.php?tid=" + this.outFragment.mTopic.getId() + "&pid=" + this.postId;
            } else if (TapatalkApp.rebranding_id.equals("81333")) {
                str1 = "http://" + paramForumStatus.getPrefectUrl() + "reply/" + this.postId + "/";
            } else {
                str1 = str2;
                if (paramForumStatus.tapatalkForum.getType() != null) {
                    str1 = str2;
                    if (paramForumStatus.tapatalkForum.getType().equals("proboards")) {
                        str1 = paramForumStatus.getPrefectUrl() + "post/" + this.postId + "/thread/" + this.tid;
                    }
                }
            }
        }
    }

    public void actionPm(ForumStatus paramForumStatus) {
        String str = getRealName();
        if (str != null) {
            Intent localIntent = new Intent(this.outFragment.getActivity(), CreatePmActivity.class);
            localIntent.putExtra("pmto", str);
            localIntent.putExtra("forumStatus", paramForumStatus);
            this.outFragment.getActivity().startActivity(localIntent);
        }
        this.outFragment.quoteHelper.actionFinish();
    }

    public void actionQuote() {
        this.outFragment.showProgress();
        this.outFragment.quoteHelper.getQuotePost(this.postId);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                PostData.this.mAdapter.notifyDataSetChanged();
            }
        }, 100L);
    }

    public void actionReport(ForumStatus paramForumStatus) {
        LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(this.outFragment.getActivity()).inflate(2130903343, null);
        final EditText localEditText = (EditText) localLinearLayout.getChildAt(0);
        String str1 = this.outFragment.getActivity().getString(2131099956);
        String str2 = SettingsFragment.getSingature(this.outFragment.getActivity(), paramForumStatus.getSigType(), paramForumStatus);
        paramForumStatus = str1;
        if (str2 != null) {
            paramForumStatus = str1;
            if (str2.length() > 0) {
                paramForumStatus = str1 + "\n\n" + str2;
            }
        }
        localEditText.setText(paramForumStatus);
        new AlertDialog.Builder(this.outFragment.getActivity()).setTitle(this.outFragment.getActivity().getString(2131099955)).setView(localLinearLayout).setCancelable(false).setPositiveButton(this.outFragment.getActivity().getString(2131099972), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = new ArrayList();
                paramAnonymousDialogInterface.add(PostData.this.postId);
                if (localEditText.getText() != null) {
                    paramAnonymousDialogInterface.add(localEditText.getText().toString().getBytes());
                }
                for (; ; ) {
                    PostData.this.mAdapter.report_post(paramAnonymousDialogInterface);
                    Toast.makeText(PostData.this.outFragment.getActivity(), PostData.this.outFragment.getActivity().getString(2131099957), 1).show();
                    return;
                    paramAnonymousDialogInterface.add(null);
                }
            }
        }).setNegativeButton(this.outFragment.getActivity().getString(2131099974), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create().show();
        this.outFragment.quoteHelper.actionFinish();
    }

    public void actionShare() {
        String str = ForumUrlUtil.getPostUrl(this.mAdapter.forumStatus, this.postId, this.outFragment.mTopic.getId(), this.outFragment.mTopic.getTitle(), this.outFragment.mTopic.getForumId(), this.outFragment.mTopic.isAnn());
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.SEND");
        localIntent.setType("text/plain");
        localIntent.addFlags(1);
        localIntent.putExtra("android.intent.extra.SUBJECT", this.outFragment.mTopic.getTitle());
        localIntent.putExtra("android.intent.extra.TEXT", str + "\r\n\n" + this.outFragment.mTopic.getTitle() + "\n\n" + getPostContent());
        if ((this.outFragment.getActivity() == null) || (this.outFragment.getActivity().getApplicationContext().getResources().getBoolean(2131558401)) || (!this.outFragment.getActivity().getResources().getBoolean(2131558401))) {
        }
        try {
            str = TapatalkJsonEngine.COMMON + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(this.outFragment.getActivity())) + "&device_type=" + Util.getDeviceName() + "&forum_id=" + this.mAdapter.forumStatus.getForumId() + "&action=share-android" + "&username=" + URLEncoder.encode(this.mAdapter.forumStatus.tapatalkForum.getUserName(), "utf-8") + "&uid=" + this.mAdapter.forumStatus.tapatalkForum.getUserId();
            TapatalkJsonEngine.callLogin(this.outFragment.getActivity(), str);
            this.mContext.startActivity(Intent.createChooser(localIntent, "Share"));
            this.outFragment.quoteHelper.actionFinish();
            return;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
    }

    public void actionViewProfile(ForumStatus paramForumStatus) {
        Intent localIntent = new Intent(this.outFragment.getActivity(), ProfilesActivity.class);
        localIntent.putExtra("forumStatus", paramForumStatus);
        paramForumStatus = getRealName();
        if (paramForumStatus != null) {
            if ((this.outFragment != null) && (this.outFragment.mFragment != null) && (this.outFragment.mFragment.mThreadAdapter != null)) {
                localIntent.putExtra("can_upload", this.outFragment.mFragment.mThreadAdapter.isCanUpload());
            }
            localIntent.putExtra("iconusername", paramForumStatus);
            this.outFragment.getActivity().startActivity(localIntent);
        }
        for (; ; ) {
            this.outFragment.quoteHelper.actionFinish();
            return;
            Toast.makeText(this.outFragment.getActivity(), this.outFragment.getActivity().getString(2131099810), 1).show();
        }
    }

    public void addImageBeanToFinished(ImageInThread paramImageInThread) {
        this.mBeansFinished.add(paramImageInThread);
    }

    public void approvePost(boolean paramBoolean) {
        this.mAdapter.setTryTwice(false);
        this.mAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.postId);
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 2) {
            localArrayList.add(Integer.valueOf(i));
            this.mAdapter.getEngine().call("m_approve_post", localArrayList);
            this.outFragment.quoteHelper.actionFinish();
            return;
        }
    }

    public void deletePost(ArrayList paramArrayList) {
        this.mAdapter.setTryTwice(false);
        this.mAdapter.getEngine().call("m_delete_post", paramArrayList);
        this.outFragment.quoteHelper.actionFinish();
    }

    public void destory() {
        int i = 0;
        for (; ; ) {
            if (i >= this.mBeansFinished.size()) {
                this.attach = null;
                this.postContent = null;
                return;
            }
            if (((ImageInThread) this.mBeansFinished.get(i)).iv != null) {
                ((ImageInThread) this.mBeansFinished.get(i)).iv.recyle();
            }
            i += 1;
        }
    }

    public void fillData(HashMap paramHashMap, Activity paramActivity, ForumStatus paramForumStatus) {
        try {
            this.replyTime = Util.formatDateInThread((Date) paramHashMap.get("post_time"), paramActivity);
            this.postTime = ((Date) paramHashMap.get("post_time"));
            if ((paramHashMap.containsKey("allow_smilies")) && (!((Boolean) paramHashMap.get("allow_smilies")).booleanValue())) {
                this.allowSmilies = false;
            }
            try {
                if (paramHashMap.containsKey("timestamp")) {
                    this.timeStamp = Integer.valueOf(paramHashMap.get("timestamp").toString()).intValue();
                }
                if ((paramHashMap.containsKey("is_approved")) && (!((Boolean) paramHashMap.get("is_approved")).booleanValue())) {
                    this.isApprove = false;
                }
                if ((paramHashMap.containsKey("is_deleted")) && (((Boolean) paramHashMap.get("is_deleted")).booleanValue())) {
                    this.isDeleted = true;
                }
                if ((paramHashMap.containsKey("allow_smilie")) && (!((Boolean) paramHashMap.get("allow_smilie")).booleanValue())) {
                    this.allowSmilies = false;
                }
                if (paramHashMap.containsKey("post_content")) {
                    paramActivity = "";
                    localArrayList = new ArrayList();
                    localObject1 = paramActivity;
                }
            } catch (Exception paramActivity) {
                try {
                    Object localObject2 = (byte[]) paramHashMap.get("post_content");
                    if (localObject2 != null) {
                        localObject1 = paramActivity;
                        if (localObject2.length > 0) {
                            localObject1 = paramActivity;
                            paramActivity = new String(Util.parseByteArray((byte[]) localObject2), "UTF-8");
                            localObject1 = paramActivity;
                            localObject2 = BBcodeUtil.process(paramActivity, paramForumStatus, this.allowSmilies, paramForumStatus.isSupprotBBcode(), false, 0);
                            localObject1 = localObject2;
                            this.post_content = paramActivity;
                            this.posts = ((List) localObject1);
                            if ((paramHashMap.containsKey("attachments")) && (paramHashMap.get("attachments") != null)) {
                                this.attachments = ((Object[]) paramHashMap.get("attachments"));
                            }
                        }
                    }
                } catch (UnsupportedEncodingException paramActivity) {
                    try {
                        if (paramHashMap.containsKey("post_author_name")) {
                            this.authorName = new String((byte[]) paramHashMap.get("post_author_name"), "UTF-8");
                        }
                        if (!paramHashMap.containsKey("post_author_display_name")) {
                        }
                    } catch (Exception paramActivity) {
                        try {
                            for (; ; ) {
                                ArrayList localArrayList;
                                this.authorDisplayName = new String((byte[]) paramHashMap.get("post_author_display_name"), "UTF-8");
                                if ((paramHashMap.get("icon_url") != null) && (((String) paramHashMap.get("icon_url")).length() > 0) && (Util.getHost(paramForumStatus.getUrl()).equalsIgnoreCase(Util.getHost((String) paramHashMap.get("icon_url"))))) {
                                    setCookies(paramForumStatus.getCookie());
                                    this.icon_url = ((String) paramHashMap.get("icon_url"));
                                }
                                if (paramHashMap.containsKey("post_id")) {
                                    this.postId = ((String) paramHashMap.get("post_id"));
                                }
                                if ((paramHashMap.containsKey("can_edit")) && (((Boolean) paramHashMap.get("can_edit")).booleanValue())) {
                                    this.canEdit = true;
                                }
                                if ((paramHashMap.containsKey("can_approve")) && (((Boolean) paramHashMap.get("can_approve")).booleanValue())) {
                                    this.canApprove = true;
                                }
                                if ((paramHashMap.containsKey("can_delete")) && (((Boolean) paramHashMap.get("can_delete")).booleanValue())) {
                                    this.canDelete = true;
                                }
                                if ((paramHashMap.containsKey("is_online")) && (((Boolean) paramHashMap.get("is_online")).booleanValue())) {
                                    this.isOnline = true;
                                }
                                if ((paramHashMap.containsKey("can_ban")) && (((Boolean) paramHashMap.get("can_ban")).booleanValue())) {
                                    this.canBan = true;
                                }
                                if ((paramHashMap.containsKey("is_ban")) && (((Boolean) paramHashMap.get("is_ban")).booleanValue())) {
                                    this.isBan = true;
                                }
                                if (paramHashMap.containsKey("post_count")) {
                                    this.postCount = ((Integer) paramHashMap.get("post_count")).intValue();
                                }
                                if ((paramHashMap.containsKey("can_move")) && (((Boolean) paramHashMap.get("can_move")).booleanValue())) {
                                    this.canMove = true;
                                }
                                if ((paramHashMap.containsKey("can_merge")) && (((Boolean) paramHashMap.get("can_merge")).booleanValue())) {
                                    this.canMerge = true;
                                }
                                if ((paramHashMap.containsKey("can_merge_post")) && (((Boolean) paramHashMap.get("can_merge_post")).booleanValue())) {
                                    this.canMergePost = true;
                                }
                                if ((paramHashMap.containsKey("can_like")) && (((Boolean) paramHashMap.get("can_like")).booleanValue())) {
                                    this.canLike = true;
                                }
                                if ((paramHashMap.containsKey("is_like")) && (((Boolean) paramHashMap.get("is_like")).booleanValue())) {
                                    this.isLike = true;
                                }
                                if ((paramHashMap.containsKey("can_thank")) && (((Boolean) paramHashMap.get("can_thank")).booleanValue())) {
                                    this.canThank = true;
                                }
                                if (paramHashMap.containsKey("thanks_info")) {
                                    paramActivity = (Object[]) paramHashMap.get("thanks_info");
                                    if (paramActivity.length > 0) {
                                        this.thanksUsers = new ArrayList();
                                        i = 0;
                                        if (i < paramActivity.length) {
                                            break;
                                        }
                                    }
                                }
                                if (paramHashMap.containsKey("like_info")) {
                                    paramActivity = (Object[]) paramHashMap.get("like_info");
                                    if (paramActivity.length > 0) {
                                        this.likeUsers = new ArrayList();
                                        i = 0;
                                        if (i < paramActivity.length) {
                                            break label1183;
                                        }
                                    }
                                }
                                if (paramHashMap.containsKey("editor_id")) {
                                    this.edit_id = ((String) paramHashMap.get("editor_id"));
                                }
                                if (paramHashMap.containsKey("editor_name")) {
                                    this.edit_name = ((String) paramHashMap.get("editor_name"));
                                }
                                if (paramHashMap.containsKey("edit_time")) {
                                    this.edit_time = ((String) paramHashMap.get("edit_time"));
                                }
                                if (paramHashMap.containsKey("edit_reason")) {
                                    this.edit_reason = ((String) paramHashMap.get("edit_reason"));
                                }
                                return;
                                paramActivity = paramActivity;
                                paramActivity.printStackTrace();
                                continue;
                                paramActivity = "";
                                continue;
                                paramActivity = paramActivity;
                                paramActivity.printStackTrace();
                                paramActivity = (Activity) localObject1;
                                Object localObject1 = localArrayList;
                            }
                            paramActivity = paramActivity;
                            paramActivity.printStackTrace();
                        } catch (UnsupportedEncodingException paramActivity) {
                            for (; ; ) {
                                int i;
                                paramActivity.printStackTrace();
                                continue;
                                paramForumStatus = (HashMap) paramActivity[i];
                                try {
                                    new String((byte[]) paramForumStatus.get("username"), "UTF-8");
                                    this.thanksUsers.add(paramForumStatus);
                                    i += 1;
                                } catch (UnsupportedEncodingException paramForumStatus) {
                                    for (; ; ) {
                                        paramForumStatus.printStackTrace();
                                    }
                                }
                                label1183:
                                paramForumStatus = (HashMap) paramActivity[i];
                                try {
                                    new String((byte[]) paramForumStatus.get("username"), "UTF-8");
                                    this.likeUsers.add(paramForumStatus);
                                    i += 1;
                                } catch (UnsupportedEncodingException paramForumStatus) {
                                    for (; ; ) {
                                        paramForumStatus.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception paramActivity) {
            for (; ; ) {
            }
        }
    }

    public int getFloor() {
        return this.floor;
    }

    public ArrayList getImageBeans() {
        return this.mBeans;
    }

    public ArrayList getImageBeansFinished() {
        return this.mBeansFinished;
    }

    public String getPostContent() {
        if ((this.post_content != null) && (this.post_content.length() > 200)) {
            return this.post_content.substring(0, 200) + "......";
        }
        return this.post_content;
    }

    public void getPostContent(String paramString) {
        this.mAdapter.setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        this.mAdapter.getEngine().call("get_raw_post", localArrayList);
        this.outFragment.quoteHelper.actionFinish();
    }

    public String getPostId() {
        return this.postId;
    }

    public int getPostTimeStamp() {
        if (this.postTime != null) {
            return (int) (this.postTime.getTime() / 1000L);
        }
        return 0;
    }

    public View getPostView(View paramView, int paramInt1, boolean paramBoolean, ForumStatus paramForumStatus, ForumRootAdapter paramForumRootAdapter, ThreadOuterFragment paramThreadOuterFragment, int paramInt2, int paramInt3) {
        System.currentTimeMillis();
        this.mContext = paramThreadOuterFragment;
        Object localObject2;
        Object localObject1;
        if ((paramView == null) || (!(paramView.getTag() instanceof ThreadViewHolder))) {
            if (this.outFragment == null) {
                this.outFragment = paramThreadOuterFragment;
            }
            localObject2 = Typeface.createFromAsset(this.outFragment.getActivity().getAssets(), "font/Roboto_Condensed.ttf");
            paramView = LayoutInflater.from(this.outFragment.getActivity()).inflate(2130903402, null);
            localObject1 = (RelativeLayout) paramView.findViewById(2131231258);
            localObject1 = new ThreadViewHolder();
            ((ThreadViewHolder) localObject1).divice = ((TextView) paramView.findViewById(2131231026));
            ((ThreadViewHolder) localObject1).avaterbg = ((ImageView) paramView.findViewById(2131230795));
            ((ThreadViewHolder) localObject1).iconView = ((GifImageView) paramView.findViewById(2131231264));
            ((ThreadViewHolder) localObject1).postAuthor = ((TextView) paramView.findViewById(2131231666));
            ((ThreadViewHolder) localObject1).postTime = ((TextView) paramView.findViewById(2131231266));
            ((ThreadViewHolder) localObject1).floorView = ((TextView) paramView.findViewById(2131231265));
            ((ThreadViewHolder) localObject1).content = ((LinearLayout) paramView.findViewById(2131231267));
            ((ThreadViewHolder) localObject1).attach = ((LinearLayout) paramView.findViewById(2131231268));
            ((ThreadViewHolder) localObject1).onlineStatus = ((ImageView) paramView.findViewById(2131231536));
            ((ThreadViewHolder) localObject1).approve = ((ImageView) paramView.findViewById(2131231204));
            ((ThreadViewHolder) localObject1).thankstoView = ((TextView) paramView.findViewById(2131231271));
            ((ThreadViewHolder) localObject1).thanksView = ((LinearLayout) paramView.findViewById(2131231269));
            ((ThreadViewHolder) localObject1).likeInfoView = ((LinearLayout) paramView.findViewById(2131231272));
            ((ThreadViewHolder) localObject1).likeInfoIcon = ((ImageView) paramView.findViewById(2131231273));
            ((ThreadViewHolder) localObject1).likeInfoText = ((TextView) paramView.findViewById(2131231274));
            ((ThreadViewHolder) localObject1).likeInfoText.setTypeface((Typeface) localObject2);
            ((ThreadViewHolder) localObject1).thankstoView.setTypeface((Typeface) localObject2);
            ((ThreadViewHolder) localObject1).postAuthorFlag = ((ThreadViewHolder) localObject1).postAuthor.getPaintFlags();
            ((ThreadViewHolder) localObject1).postTimeFlag = ((ThreadViewHolder) localObject1).postTime.getPaintFlags();
            ((ThreadViewHolder) localObject1).reasonView = ((TextView) paramView.findViewById(2131231672));
            ((ThreadViewHolder) localObject1).thankstoView.setTextColor(paramThreadOuterFragment.getResources().getColor(ThemeUtil.getSubTextColor(this.outFragment.getActivity())));
            ((ThreadViewHolder) localObject1).likeInfoText.setTextColor(paramThreadOuterFragment.getResources().getColor(ThemeUtil.getSubTextColor(this.outFragment.getActivity())));
            ((ThreadViewHolder) localObject1).avaterbg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.outFragment.getActivity()));
            ((ThreadViewHolder) localObject1).avaterbg.bringToFront();
            paramView.setTag(localObject1);
            if (this != null) {
                if (!SettingsFragment.isLightTheme(this.outFragment.getActivity())) {
                    break label1551;
                }
                ((ThreadViewHolder) localObject1).divice.setBackgroundColor(Color.parseColor("#e8e8e8"));
                label498:
                if (!this.isDeleted) {
                    break label1568;
                }
                ((ThreadViewHolder) localObject1).postAuthor.setTextColor(-7829368);
                ((ThreadViewHolder) localObject1).postTime.setTextColor(-7829368);
                ((ThreadViewHolder) localObject1).postAuthor.setPaintFlags(((ThreadViewHolder) localObject1).postAuthor.getPaintFlags() | 0x10);
                ((ThreadViewHolder) localObject1).postTime.setPaintFlags(((ThreadViewHolder) localObject1).postTime.getPaintFlags() | 0x10);
                label565:
                if (this.authorDisplayName == null) {
                    break label1648;
                }
                ((ThreadViewHolder) localObject1).postAuthor.setText(this.authorDisplayName);
                label584:
                ThemeUtil.setAuthorColor(this.outFragment.getActivity(), ((ThreadViewHolder) localObject1).postAuthor);
                ((ThreadViewHolder) localObject1).postTime.setTextColor(this.outFragment.getActivity().getApplicationContext().getResources().getColor(2131165275));
                ThemeUtil.setAuthorColor(this.outFragment.getActivity(), ((ThreadViewHolder) localObject1).postAuthor);
                ((ThreadViewHolder) localObject1).postTime.setTextColor(this.outFragment.getActivity().getResources().getColor(2131165275));
                if (!this.isOnline) {
                    break label1663;
                }
                ((ThreadViewHolder) localObject1).onlineStatus.setVisibility(0);
                ((ThreadViewHolder) localObject1).onlineStatus.setImageResource(2130839197);
                label692:
                if (this.isApprove) {
                    break label1676;
                }
                ((ThreadViewHolder) localObject1).approve.setVisibility(0);
                ((ThreadViewHolder) localObject1).approve.setImageResource(2130839472);
                label719:
                if (this.floorNum != -1) {
                    break label1689;
                }
                ((ThreadViewHolder) localObject1).floorView.setText("#" + (paramInt1 + paramInt2));
                label755:
                this.floor = (paramInt1 + paramInt2);
                if (this.timeStamp == 0) {
                    break label1745;
                }
                if (SettingsFragment.getTimeStyle(this.outFragment.getActivity()) != 0) {
                    break label1720;
                }
                ((ThreadViewHolder) localObject1).postTime.setText(Util.getSmartTimeString(this.outFragment.getActivity(), this.timeStamp));
                label805:
                ((ThreadViewHolder) localObject1).iconView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (PostData.this.mAdapter.forumStatus.isLogin()) {
                            paramAnonymousView = new Intent(PostData.this.outFragment.getActivity(), ProfilesActivity.class);
                            paramAnonymousView.putExtra("forumStatus", PostData.this.mAdapter.forumStatus);
                            paramAnonymousView.putExtra("iconusername", jdField_this.authorName);
                            if ((PostData.this.outFragment != null) && (PostData.this.outFragment.mFragment != null) && (PostData.this.outFragment.mFragment.mThreadAdapter != null)) {
                                paramAnonymousView.putExtra("can_upload", PostData.this.outFragment.mFragment.mThreadAdapter.isCanUpload());
                            }
                            PostData.this.outFragment.getActivity().startActivityForResult(paramAnonymousView, 41);
                            return;
                        }
                        Toast.makeText(PostData.this.outFragment.getActivity(), PostData.this.outFragment.getActivity().getString(2131099865), 1).show();
                    }
                });
                if ((this.thanksUsers == null) || (this.thanksUsers.size() == 0)) {
                    break label1760;
                }
                ((ThreadViewHolder) localObject1).thanksView.setVisibility(0);
                ((ThreadViewHolder) localObject1).thankstoView.setVisibility(0);
                initThanksString();
                ((ThreadViewHolder) localObject1).thankstoView.setText(this.thanksString.toString());
                label876:
                if ((this.likeUsers == null) || (this.likeUsers.size() == 0)) {
                    break label1783;
                }
                ((ThreadViewHolder) localObject1).likeInfoView.setVisibility(0);
                if ((this.canLike) && (this.canThank)) {
                    ((ThreadViewHolder) localObject1).likeInfoIcon.setImageResource(2130838882);
                }
                initLikeString();
                ((ThreadViewHolder) localObject1).likeInfoText.setText(this.likeString.toString());
                label946:
                if ((this.edit_time == null) || (this.edit_time.equals("0"))) {
                    break label1889;
                }
                if ((!paramForumStatus.isXF()) && (!paramForumStatus.isSMF()) && (!paramForumStatus.isSMF1()) && (!paramForumStatus.isSMF()) && (!paramForumStatus.isMB())) {
                    break label1796;
                }
                localObject2 = paramThreadOuterFragment.getResources().getString(2131100806) + this.edit_name + ": " + Util.getTimeString(paramThreadOuterFragment.getActivity(), Integer.parseInt(this.edit_time));
                ((ThreadViewHolder) localObject1).reasonView.setText(Html.fromHtml("<small><i><font color=\"" + paramThreadOuterFragment.getResources().getColor(2131165283) + "\">" + (String) localObject2 + "</font><i></small>"));
                ((ThreadViewHolder) localObject1).reasonView.setVisibility(0);
                label1127:
                ((ThreadViewHolder) localObject1).likeInfoView.setOnClickListener(new LikeAndThanksOnClickListener(this.likeUsers, true));
                ((ThreadViewHolder) localObject1).thanksView.setOnClickListener(new LikeAndThanksOnClickListener(this.thanksUsers, false));
                Util.getUserImage(this.outFragment.getActivity(), paramForumRootAdapter.forumStatus, ((ThreadViewHolder) localObject1).iconView, this.icon_url, ((ThreadViewHolder) localObject1).avaterbg);
                if (this.postContent == null) {
                    this.postContent = new LinearLayout(this.outFragment.getActivity());
                    this.postContent.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.postContent.setOrientation(1);
                    paramForumStatus = new MessageContentAdapter(this.outFragment.getActivity(), paramForumRootAdapter, paramForumStatus).getViewFromPost(this.posts, this, paramInt3, false);
                    paramInt1 = 0;
                    label1281:
                    if (paramInt1 < paramForumStatus.length) {
                        break label1902;
                    }
                    if (this.attachments != null) {
                        Arrays.sort(this.attachments, this.comp);
                        AttachmentInfo.getAttachView(this.outFragment, this.mAdapter, this.attachments, this);
                    }
                }
                if (this.postContent.getParent() == null) {
                    break label1927;
                }
                ((LinearLayout) this.postContent.getParent()).removeView(this.postContent);
                ((ThreadViewHolder) localObject1).content.addView(this.postContent);
                label1361:
                if ((this.attach != null) && (this.attach.getChildCount() > 0)) {
                    if (this.attach.getParent() == null) {
                        break label1942;
                    }
                    ((LinearLayout) this.attach.getParent()).removeView(this.attach);
                    ((ThreadViewHolder) localObject1).attach.addView(this.attach);
                }
            }
            label1417:
            this.contentView = paramView;
            paramInt1 = 0;
            paramInt2 = 0;
            if (this.outFragment.quoteHelper.multiQuoteIds != null) {
                paramInt3 = 0;
                paramInt1 = paramInt2;
                paramInt2 = paramInt3;
                label1450:
                if (paramInt2 < this.outFragment.quoteHelper.multiQuoteIds.size()) {
                    break label1957;
                }
            }
            if (paramInt1 == 0) {
                break label2034;
            }
            if (paramThreadOuterFragment.getResources().getBoolean(2131558401)) {
                break label2017;
            }
            if (!SettingsFragment.isLightTheme(this.outFragment.getActivity())) {
                break label1996;
            }
            this.contentView.setBackgroundColor(paramThreadOuterFragment.getResources().getColor(2131165504));
        }
        for (; ; ) {
            paramView.invalidate();
            return paramView;
            localObject1 = (ThreadViewHolder) paramView.getTag();
            ((ThreadViewHolder) localObject1).content.removeAllViews();
            ((ThreadViewHolder) localObject1).attach.removeAllViews();
            break;
            label1551:
            ((ThreadViewHolder) localObject1).divice.setBackgroundColor(Color.parseColor("#37393b"));
            break label498;
            label1568:
            ((ThreadViewHolder) localObject1).postAuthor.setPaintFlags(((ThreadViewHolder) localObject1).postAuthorFlag);
            ((ThreadViewHolder) localObject1).postTime.setPaintFlags(((ThreadViewHolder) localObject1).postTimeFlag);
            ((ThreadViewHolder) localObject1).floorView.setTextColor(this.outFragment.getActivity().getApplicationContext().getResources().getColor(2131165275));
            ((ThreadViewHolder) localObject1).floorView.setTextColor(this.outFragment.getActivity().getResources().getColor(2131165275));
            break label565;
            label1648:
            ((ThreadViewHolder) localObject1).postAuthor.setText(this.authorName);
            break label584;
            label1663:
            ((ThreadViewHolder) localObject1).onlineStatus.setVisibility(8);
            break label692;
            label1676:
            ((ThreadViewHolder) localObject1).approve.setVisibility(8);
            break label719;
            label1689:
            ((ThreadViewHolder) localObject1).floorView.setText("#" + this.floorNum);
            break label755;
            label1720:
            ((ThreadViewHolder) localObject1).postTime.setText(Util.getTimeString(this.outFragment.getActivity(), this.timeStamp));
            break label805;
            label1745:
            ((ThreadViewHolder) localObject1).postTime.setText(this.replyTime);
            break label805;
            label1760:
            ((ThreadViewHolder) localObject1).thanksView.setVisibility(8);
            ((ThreadViewHolder) localObject1).thankstoView.setVisibility(8);
            break label876;
            label1783:
            ((ThreadViewHolder) localObject1).likeInfoView.setVisibility(8);
            break label946;
            label1796:
            StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramThreadOuterFragment.getResources().getString(2131100807))).append(Util.getTimeString(paramThreadOuterFragment.getActivity(), Integer.parseInt(this.edit_time)));
            if (this.edit_reason == null) {
            }
            for (localObject2 = ""; ; localObject2 = ": " + this.edit_reason) {
                localObject2 = (String) localObject2;
                break;
            }
            label1889:
            ((ThreadViewHolder) localObject1).reasonView.setVisibility(8);
            break label1127;
            label1902:
            if (paramForumStatus[paramInt1] != null) {
                this.postContent.addView(paramForumStatus[paramInt1]);
            }
            paramInt1 += 1;
            break label1281;
            label1927:
            ((ThreadViewHolder) localObject1).content.addView(this.postContent);
            break label1361;
            label1942:
            ((ThreadViewHolder) localObject1).attach.addView(this.attach);
            break label1417;
            label1957:
            if (((PostData) this.outFragment.quoteHelper.multiQuoteIds.get(paramInt2)).getPostId() == getPostId()) {
                paramInt1 = 1;
            }
            paramInt2 += 1;
            break label1450;
            label1996:
            this.contentView.setBackgroundColor(paramThreadOuterFragment.getResources().getColor(2131165509));
            continue;
            label2017:
            ThemeUtil.setHeightLight(this.outFragment.getActivity(), this.contentView);
            continue;
            label2034:
            if ((this.outFragment.quoteHelper.singleActionmMode != null) && (this.outFragment.quoteHelper.multiQuoteIds.size() == 0)) {
                this.outFragment.quoteHelper.singleActionmMode.finish();
            }
            this.contentView.setBackgroundColor(paramThreadOuterFragment.getResources().getColor(2131165212));
        }
    }

    public String getRealName() {
        if (this.authorDisplayName != null) {
            return this.authorDisplayName;
        }
        return this.authorName;
    }

    public void initLikeString() {
        this.likeString = new StringBuilder();
        int i = 0;
        if ((i >= this.likeUsers.size()) || (i >= 3)) {
            this.likeFullString = new StringBuilder("");
            if (this.likeUsers.size() > 3) {
                this.likeString.append(String.format(this.mContext.getString(2131100393), new Object[]{Integer.valueOf(this.likeUsers.size() - 3)}));
                i = 3;
                if (i < this.likeUsers.size()) {
                    break label203;
                }
            }
        } else {
            if (i == 0) {
                this.likeString.append(new String((byte[]) ((HashMap) this.likeUsers.get(i)).get("username")));
            }
            for (; ; ) {
                i += 1;
                break;
                this.likeString.append(", ");
                this.likeString.append(new String((byte[]) ((HashMap) this.likeUsers.get(i)).get("username")));
            }
        }
        label203:
        if (i == 3) {
            this.likeFullString.append(new String((byte[]) ((HashMap) this.likeUsers.get(i)).get("username")));
        }
        for (; ; ) {
            i += 1;
            break;
            this.likeFullString.append(", ");
            this.likeFullString.append(new String((byte[]) ((HashMap) this.likeUsers.get(i)).get("username")));
        }
    }

    public void initThanksString() {
        this.thanksString = new StringBuilder();
        int i = 0;
        if ((i >= this.thanksUsers.size()) || (i >= 3)) {
            this.thanksFullString = new StringBuilder("");
            if (this.thanksUsers.size() > 3) {
                this.thanksString.append(String.format(this.mContext.getString(2131100393), new Object[]{Integer.valueOf(this.thanksUsers.size() - 3)}));
                i = 3;
                if (i < this.thanksUsers.size()) {
                    break label203;
                }
            }
        } else {
            if (i == 0) {
                this.thanksString.append(new String((byte[]) ((HashMap) this.thanksUsers.get(i)).get("username")));
            }
            for (; ; ) {
                i += 1;
                break;
                this.thanksString.append(", ");
                this.thanksString.append(new String((byte[]) ((HashMap) this.thanksUsers.get(i)).get("username")));
            }
        }
        label203:
        if (i == 3) {
            this.thanksFullString.append(new String((byte[]) ((HashMap) this.thanksUsers.get(i)).get("username")));
        }
        for (; ; ) {
            i += 1;
            break;
            this.thanksFullString.append(", ");
            this.thanksFullString.append(new String((byte[]) ((HashMap) this.thanksUsers.get(i)).get("username")));
        }
    }

    public boolean isCanLike() {
        return this.canLike;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public boolean isLike() {
        return this.isLike;
    }

    public void likePost(String paramString) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        this.isLike = true;
        this.mAdapter.notifyDataSetChanged();
        this.mAdapter.getEngine().call("like_post", localArrayList);
        this.outFragment.quoteHelper.actionFinish();
    }

    public void movePost() {
        this.mAdapter.setTryTwice(false);
        this.mAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.postId);
        this.mAdapter.getEngine().call("m_move_post", localArrayList);
        this.outFragment.quoteHelper.actionFinish();
    }

    public void setAttachLay(View paramView) {
        this.attach = ((LinearLayout) paramView);
    }

    public void setCanLike(boolean paramBoolean) {
        this.canLike = paramBoolean;
    }

    public void setIsDeleted(boolean paramBoolean) {
        this.isDeleted = paramBoolean;
    }

    public void setLike(boolean paramBoolean) {
        this.isLike = paramBoolean;
    }

    public void showQuickAction(ForumStatus paramForumStatus, int paramInt) {
        paramForumStatus = new AnActionModeOfEpicProportions(paramForumStatus);
        this.outFragment.mThreadAdapter.setmLongclickItemPosition(paramInt);
        if (this.outFragment.quoteHelper != null) {
            this.outFragment.quoteHelper.singleActionmMode = this.outFragment.getActivity().startActionMode(paramForumStatus);
            this.outFragment.quoteHelper.actionSelect(this.mAdapter.getPost(paramInt));
        }
    }

    public void showQuickAction(ForumStatus paramForumStatus, String paramString) {
        paramForumStatus = new AnActionModeOfEpicProportions(paramForumStatus);
        if (this.outFragment.quoteHelper != null) {
            this.outFragment.quoteHelper.singleActionmMode = this.outFragment.getActivity().startActionMode(paramForumStatus);
            this.outFragment.quoteHelper.actionSelectPostId(this.mAdapter.getPostByPostId(paramString));
        }
    }

    public void thankstoPost() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.postId);
        this.mAdapter.getEngine().call("thank_post", localArrayList);
        this.outFragment.quoteHelper.actionFinish();
    }

    public void unDeletePost() {
        this.mAdapter.setTryTwice(false);
        this.mAdapter.setOpCancel(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.postId);
        localArrayList.add("".getBytes());
        this.mAdapter.getEngine().call("m_undelete_post", localArrayList);
        this.outFragment.quoteHelper.actionFinish();
    }

    public void unlikePost(String paramString) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        this.isLike = false;
        int i = 0;
        for (; ; ) {
            if (i >= this.likeUsers.size()) {
                this.mAdapter.notifyDataSetChanged();
                this.mAdapter.getEngine().call("unlike_post", localArrayList);
                this.outFragment.quoteHelper.actionFinish();
                return;
            }
            paramString = new String((byte[]) ((HashMap) this.likeUsers.get(i)).get("username"));
            if ((paramString.equalsIgnoreCase(this.mAdapter.forumStatus.tapatalkForum.getUserName())) || (paramString.equalsIgnoreCase(this.mAdapter.forumStatus.tapatalkForum.getDisplayName()))) {
                this.likeUsers.remove(i);
            }
            i += 1;
        }
    }

    class AnActionModeOfEpicProportions
            implements ActionMode.Callback {
        ForumStatus forumStatus;

        public AnActionModeOfEpicProportions(ForumStatus paramForumStatus) {
            this.forumStatus = paramForumStatus;
        }

        public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
            switch (paramMenuItem.getItemId()) {
            }
            for (; ; ) {
                return true;
                PostData.this.actionQuote();
                continue;
                PostData.this.actionEdit(this.forumStatus);
                paramActionMode.finish();
                continue;
                PostData.this.actionModify(this.forumStatus);
                paramActionMode.finish();
                continue;
                PostData.this.actionShare();
                paramActionMode.finish();
                continue;
                int j = 0;
                int i;
                boolean bool;
                for (; ; ) {
                    try {
                        if (PostData.this.thanksUsers == null) {
                            PostData.this.thanksUsers = new ArrayList();
                        }
                        paramMenuItem = new HashMap();
                        paramMenuItem.put("userid", PostData.this.mAdapter.forumStatus.getUserId());
                        paramMenuItem.put("username", PostData.this.mAdapter.forumStatus.tapatalkForum.getDisplayNameOrUsername().getBytes("UTF-8"));
                        i = 0;
                        if (i < PostData.this.thanksUsers.size()) {
                            continue;
                        }
                        if (j == 0) {
                            PostData.this.thanksUsers.add(paramMenuItem);
                        }
                    } catch (UnsupportedEncodingException paramMenuItem) {
                        paramMenuItem.printStackTrace();
                        continue;
                    }
                    PostData.this.mAdapter.notifyDataSetChanged();
                    PostData.this.thankstoPost();
                    paramActionMode.finish();
                    break;
                    bool = ((String) ((HashMap) PostData.this.thanksUsers.get(i)).get("userid")).equalsIgnoreCase(PostData.this.mAdapter.forumStatus.getUserId());
                    if (bool) {
                        j = 1;
                    }
                    i += 1;
                }
                j = 0;
                for (; ; ) {
                    try {
                        if (PostData.this.likeUsers == null) {
                            PostData.this.likeUsers = new ArrayList();
                        }
                        paramMenuItem = new HashMap();
                        paramMenuItem.put("userid", PostData.this.mAdapter.forumStatus.getUserId());
                        paramMenuItem.put("username", PostData.this.mAdapter.forumStatus.tapatalkForum.getDisplayNameOrUsername().getBytes("UTF-8"));
                        i = 0;
                        if (i < PostData.this.likeUsers.size()) {
                            continue;
                        }
                        if (j == 0) {
                            PostData.this.likeUsers.add(paramMenuItem);
                        }
                    } catch (UnsupportedEncodingException paramMenuItem) {
                        paramMenuItem.printStackTrace();
                        continue;
                    }
                    PostData.this.mAdapter.notifyDataSetChanged();
                    PostData.this.likePost(PostData.this.postId);
                    paramActionMode.finish();
                    break;
                    bool = ((String) ((HashMap) PostData.this.likeUsers.get(i)).get("userid")).equalsIgnoreCase(PostData.this.mAdapter.forumStatus.getUserId());
                    if (bool) {
                        j = 1;
                    }
                    i += 1;
                }
                PostData.this.unlikePost(PostData.this.postId);
                paramActionMode.finish();
                continue;
                PostData.this.actionPm(this.forumStatus);
                paramActionMode.finish();
                continue;
                PostData.this.actionConvo(this.forumStatus);
                paramActionMode.finish();
                continue;
                PostData.this.actionReport(this.forumStatus);
                paramActionMode.finish();
                continue;
                PostData.this.actionCopyPost();
                paramActionMode.finish();
                continue;
                PostData.this.actionCopyUrl(this.forumStatus);
                paramActionMode.finish();
                continue;
                PostData.this.actionViewProfile(this.forumStatus);
                paramActionMode.finish();
                continue;
                PostData.this.actionOpenPostInBrowser(this.forumStatus);
                paramActionMode.finish();
            }
        }

        public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
            if (this.forumStatus.isLogin()) {
                int j;
                int i;
                if (PostData.this.authorDisplayName != null) {
                    paramActionMode.setTitle(PostData.this.authorDisplayName);
                    if (((!PostData.this.outFragment.mTopic.isAnn()) || (!this.forumStatus.isVB())) && (PostData.this.outFragment.mThreadAdapter.isCanReply())) {
                        paramMenu.add(0, 1041, 0, PostData.this.outFragment.getActivity().getString(2131100096)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_quote", PostData.this.outFragment.getActivity())).setShowAsAction(2);
                    }
                    if (PostData.this.canThank) {
                        j = 0;
                        i = 0;
                        label140:
                        if ((PostData.this.thanksUsers != null) && (i < PostData.this.thanksUsers.size())) {
                            break label832;
                        }
                        if (j == 0) {
                            paramMenu.add(0, 1046, 0, PostData.this.outFragment.getActivity().getString(2131100104)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_thank", PostData.this.outFragment.getActivity())).setShowAsAction(2);
                        }
                    }
                    if ((!PostData.this.canLike) || (PostData.this.isLike)) {
                        break label1048;
                    }
                    if ((!this.forumStatus.getUrl().contains("androidforums.com")) && (!this.forumStatus.getUrl().contains("fiatforum.com"))) {
                        break label925;
                    }
                    paramMenu.add(0, 1048, 0, PostData.this.outFragment.getActivity().getString(2131100105)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_like", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                    label325:
                    if ((!PostData.this.canEdit) || (this.forumStatus.isCanModerate()) || (PostData.this.canDelete)) {
                        break label1249;
                    }
                    if (((PostData.this.authorDisplayName == null) || (!PostData.this.authorDisplayName.equals(this.forumStatus.getCurrentUserName()))) && ((PostData.this.authorName == null) || (!PostData.this.authorName.equals(this.forumStatus.getCurrentUserName())))) {
                        break label1192;
                    }
                    paramMenu.add(0, 1043, 0, PostData.this.outFragment.getActivity().getString(2131100098)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_edit", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                    label469:
                    paramMenu.add(0, 1045, 0, PostData.this.outFragment.getActivity().getString(2131100100)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_share", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                    if ((this.forumStatus.isCanPm()) && (this.forumStatus.isCanSendPm()) && (PostData.this.authorName != null) && (this.forumStatus.tapatalkForum.getUserName() != null) && (!PostData.this.authorName.toLowerCase().equalsIgnoreCase(this.forumStatus.tapatalkForum.getUserName().toLowerCase()))) {
                        if (!this.forumStatus.tapatalkForum.isSupportConve()) {
                            break label1456;
                        }
                        paramMenu.add(0, 1140, 0, PostData.this.outFragment.getActivity().getString(2131099842)).setShowAsAction(0);
                    }
                }
                for (; ; ) {
                    if (this.forumStatus.isReportPost()) {
                        paramMenu.add(0, 1142, 0, PostData.this.outFragment.getActivity().getString(2131099843)).setShowAsAction(0);
                    }
                    paramMenu.add(0, 1143, 0, PostData.this.outFragment.getActivity().getString(2131100075)).setShowAsAction(0);
                    paramMenu.add(0, 1144, 0, PostData.this.outFragment.getActivity().getString(2131100076)).setShowAsAction(0);
                    paramMenu.add(0, 1145, 0, PostData.this.outFragment.getActivity().getString(2131099840)).setShowAsAction(0);
                    paramMenu.add(0, 1146, 0, PostData.this.outFragment.getActivity().getString(2131099969)).setShowAsAction(0);
                    return true;
                    paramActionMode.setTitle(PostData.this.authorName);
                    break;
                    label832:
                    if ((new String((byte[]) ((HashMap) PostData.this.thanksUsers.get(i)).get("username")).toString().equals(this.forumStatus.tapatalkForum.getUserName())) || (((HashMap) PostData.this.thanksUsers.get(i)).get("username").equals(this.forumStatus.tapatalkForum.getDisplayName()))) {
                        j = 1;
                    }
                    i += 1;
                    break label140;
                    label925:
                    if (PostData.this.canThank) {
                        paramMenu.add(0, 1048, 0, PostData.this.outFragment.getActivity().getString(2131100105)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_like", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                        break label325;
                    }
                    paramMenu.add(0, 1048, 0, PostData.this.outFragment.getActivity().getString(2131100105)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_thank", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                    break label325;
                    label1048:
                    if ((!PostData.this.canLike) || (!PostData.this.isLike)) {
                        break label325;
                    }
                    if (PostData.this.canThank) {
                        paramMenu.add(0, 1049, 0, PostData.this.outFragment.getActivity().getString(2131100106)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_unlike", PostData.this.outFragment.getActivity())).setShowAsAction(2);
                        break label325;
                    }
                    paramMenu.add(0, 1049, 0, PostData.this.outFragment.getActivity().getString(2131100106)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_unthank", PostData.this.outFragment.getActivity())).setShowAsAction(2);
                    break label325;
                    label1192:
                    paramMenu.add(0, 1044, 0, PostData.this.outFragment.getActivity().getString(2131100039)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_modif", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                    break label469;
                    label1249:
                    if (((!PostData.this.canEdit) || (PostData.this.mAdapter.forumStatus.isBB())) && (!PostData.this.canDelete)) {
                        break label469;
                    }
                    if (((PostData.this.authorDisplayName != null) && (PostData.this.authorDisplayName.equals(this.forumStatus.getCurrentUserName()))) || ((PostData.this.authorName != null) && (PostData.this.authorName.equals(this.forumStatus.getCurrentUserName())))) {
                        paramMenu.add(0, 1043, 0, PostData.this.outFragment.getActivity().getString(2131100098)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_edit", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                    }
                    paramMenu.add(0, 1044, 0, PostData.this.outFragment.getActivity().getString(2131100039)).setIcon(ThemeUtil.getActionModeDrawableId("bubble_modif", PostData.this.outFragment.getActivity())).setShowAsAction(1);
                    break label469;
                    label1456:
                    paramMenu.add(0, 1141, 0, PostData.this.outFragment.getActivity().getString(2131099841)).setShowAsAction(0);
                }
            }
            return false;
        }

        public void onDestroyActionMode(ActionMode paramActionMode) {
            if ((PostData.this.outFragment.quoteHelper.multiQuoteIds != null) && (PostData.this.outFragment.quoteHelper.multiQuoteIds.size() == 1)) {
                PostData.this.outFragment.quoteHelper.multiQuoteIds.clear();
                PostData.this.mAdapter.notifyDataSetChanged();
            }
        }

        public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
            return false;
        }
    }

    class LikeAndThanksOnClickListener
            implements View.OnClickListener {
        private boolean isLike;
        private ArrayList<HashMap> list;

        public LikeAndThanksOnClickListener(boolean paramBoolean) {
            this.list = paramBoolean;
            boolean bool;
            this.isLike = bool;
        }

        public void onClick(View paramView) {
            paramView = new Intent(PostData.this.outFragment.getActivity(), LikeAndThankActivity.class);
            paramView.putExtra("forumStatus", PostData.this.mAdapter.forumStatus);
            paramView.putExtra("user_map", this.list);
            paramView.putExtra("isLike", this.isLike);
            PostData.this.outFragment.getActivity().startActivity(paramView);
        }
    }

    private class Mycomparator
            implements Comparator<Object> {
        private Mycomparator() {
        }

        public int compare(Object paramObject1, Object paramObject2) {
            return ((HashMap) paramObject1).get("content_type").toString().compareTo(((HashMap) paramObject2).get("content_type").toString());
        }
    }

    protected static class ThreadViewHolder {
        ImageView approve;
        LinearLayout attach;
        ImageView avaterbg;
        LinearLayout content;
        TextView divice;
        TextView floorView;
        GifImageView iconView;
        ImageView likeInfoIcon;
        TextView likeInfoText;
        LinearLayout likeInfoView;
        ImageButton more;
        ImageView onlineStatus;
        TextView postAuthor;
        int postAuthorFlag;
        TextView postTime;
        int postTimeFlag;
        TextView reasonView;
        RelativeLayout relativeLayout;
        TextView textView;
        LinearLayout thanksView;
        TextView thankstoView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/PostData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */