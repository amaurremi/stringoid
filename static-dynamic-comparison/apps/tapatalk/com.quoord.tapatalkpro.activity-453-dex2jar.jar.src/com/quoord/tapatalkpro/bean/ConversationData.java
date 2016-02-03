package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.MessageContentAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvDetailAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ui.ConversationQuoteHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.BBcodeUtil.BBElement;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ConversationData
        extends BaseBean
        implements Serializable, ParseableData {
    public static ArrayList<Attachment> attchmentList;
    private static final long serialVersionUID = -1064209133302776750L;
    public ActionMode actionmMode;
    public LinearLayout attach;
    private ArrayList<Attachment> attachment;
    private LinearLayout content;
    public View contentView;
    private String conv_id;
    private boolean has_left;
    private boolean is_online;
    private boolean is_unread;
    private Activity mActivity;
    private ConvDetailAdapter mAdapter;
    public ArrayList<ImageInThread> mBeans = new ArrayList();
    public ArrayList<ImageInThread> mBeansFinished = new ArrayList();
    private ConversationData mThis;
    private Bitmap mThumbnail = null;
    private String msg_author_id;
    private String msg_content;
    private String msg_id;
    private boolean new_post;
    private Object[] obj_attachment;
    private Participant participant;
    private Date post_time;
    public List<BBcodeUtil.BBElement> posts;

    public ConversationData(Activity paramActivity, ConvDetailAdapter paramConvDetailAdapter) {
        this.mActivity = paramActivity;
        this.mAdapter = paramConvDetailAdapter;
        this.mThis = this;
    }

    public static ConversationData getConversation(HashMap paramHashMap, Participant paramParticipant, String paramString, Activity paramActivity, ConvDetailAdapter paramConvDetailAdapter) {
        paramActivity = new ConversationData(paramActivity, paramConvDetailAdapter);
        if (paramString != null) {
            paramActivity.setConv_id(paramString);
        }
        if (paramHashMap.containsKey("msg_id")) {
            paramActivity.setMsg_id((String) paramHashMap.get("msg_id"));
        }
        if (paramHashMap.containsKey("msg_content")) {
        }
        try {
            paramActivity.setMsg_content(new String((byte[]) paramHashMap.get("msg_content"), "UTF-8"));
            if (paramHashMap.containsKey("msg_author_id")) {
                paramActivity.setMsg_author_id((String) paramHashMap.get("msg_author_id"));
            }
            if (paramHashMap.containsKey("is_unread")) {
                paramActivity.setIs_unread(((Boolean) paramHashMap.get("is_unread")).booleanValue());
            }
            if (paramHashMap.containsKey("is_online")) {
                paramActivity.setIs_online(((Boolean) paramHashMap.get("is_online")).booleanValue());
            }
            if (paramHashMap.containsKey("has_left")) {
                paramActivity.setHas_left(((Boolean) paramHashMap.get("has_left")).booleanValue());
            }
            if (paramHashMap.containsKey("post_time")) {
                paramActivity.setPost_time((Date) paramHashMap.get("post_time"));
            }
            if (paramHashMap.containsKey("new_post")) {
                paramActivity.setNew_post(((Boolean) paramHashMap.get("new_post")).booleanValue());
            }
            if (paramHashMap.containsKey("attachments")) {
                attchmentList = new ArrayList();
                paramActivity.setObj_attachment((Object[]) paramHashMap.get("attachments"));
                i = 0;
                if (i < paramActivity.getObj_attachment().length) {
                }
            } else {
                if (paramParticipant != null) {
                    paramActivity.setParticipant(paramParticipant);
                }
                return paramActivity;
            }
        } catch (Exception paramString) {
            for (; ; ) {
                int i;
                paramString.printStackTrace();
                continue;
                paramHashMap = new Attachment((HashMap) paramActivity.getObj_attachment()[i]);
                attchmentList.add(paramHashMap);
                paramActivity.setAttachment(attchmentList);
                i += 1;
            }
        }
    }

    public void addImageBeanToFinished(ImageInThread paramImageInThread) {
        if (this.mBeansFinished.size() == 0) {
            this.mBeansFinished.add(paramImageInThread);
        }
        int j = 0;
        int i = 0;
        for (; ; ) {
            if (i >= this.mBeansFinished.size()) {
                if (j == 0) {
                    this.mBeansFinished.add(paramImageInThread);
                }
                return;
            }
            if (((ImageInThread) this.mBeansFinished.get(i)).equals(paramImageInThread)) {
                j = 1;
            }
            i += 1;
        }
    }

    public void changeBackgroud() {
        int j = 0;
        int i = j;
        if (this.mAdapter.getConvOuterFragment().quoteHelper.multiQuoteIds != null) {
            i = j;
            if (this.mAdapter.getConvOuterFragment().quoteHelper.multiQuoteIds.size() != 0) {
                i = j;
                if (((ConversationData) this.mAdapter.getConvOuterFragment().quoteHelper.multiQuoteIds.get(0)).getMsg_id().equals(this.msg_id)) {
                    i = 1;
                }
            }
        }
        if (i != 0) {
            if (!this.mActivity.getResources().getBoolean(2131558401)) {
                if (SettingsFragment.isLightTheme(this.mActivity)) {
                    this.contentView.setBackgroundColor(this.mActivity.getResources().getColor(2131165504));
                    return;
                }
                this.contentView.setBackgroundColor(this.mActivity.getResources().getColor(2131165509));
                return;
            }
            ThemeUtil.setHeightLight(this.mActivity, this.contentView);
            return;
        }
        this.contentView.setBackgroundColor(this.mActivity.getResources().getColor(2131165212));
    }

    public void destory() {
        this.attach = null;
    }

    public ArrayList<Attachment> getAttachment() {
        return this.attachment;
    }

    public String getConv_id() {
        return this.conv_id;
    }

    public View getConversationView(ForumStatus paramForumStatus, int paramInt, ForumRootAdapter paramForumRootAdapter, View paramView, final ForumActivityStatus paramForumActivityStatus) {
        ConverSationHolder localConverSationHolder;
        if ((paramView == null) || (paramView.getTag() == null)) {
            localConverSationHolder = new ConverSationHolder();
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903118, null);
            localConverSationHolder.avaterbg = ((ImageView) paramView.findViewById(2131230795));
            localConverSationHolder.conversation_info = paramView.findViewById(2131230964);
            localConverSationHolder.msg_author_icon = ((GifImageView) paramView.findViewById(2131230963));
            localConverSationHolder.msg_author_name = ((TextView) paramView.findViewById(2131230965));
            localConverSationHolder.msg_shortcontent = ((LinearLayout) paramView.findViewById(2131230966));
            localConverSationHolder.msg_author_time = ((TextView) paramView.findViewById(2131230968));
            localConverSationHolder.conversation_attachment = ((LinearLayout) paramView.findViewById(2131230967));
            ThemeUtil.setAuthorColor(this.mActivity, localConverSationHolder.msg_author_name);
            localConverSationHolder.conversation_info.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("conversation_white_bg", this.mActivity));
            localConverSationHolder.avaterbg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.mActivity));
            localConverSationHolder.avaterbg.bringToFront();
            paramView.setTag(localConverSationHolder);
            if (this.content == null) {
                this.content = new LinearLayout(this.mActivity);
                this.content.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.content.setOrientation(1);
                paramForumStatus = new MessageContentAdapter(this.mActivity, paramForumRootAdapter, paramForumStatus).getViewFromPost(this.posts, this, paramInt, false);
                paramInt = 0;
                label285:
                if (paramInt < paramForumStatus.length) {
                    break label642;
                }
                if ((getAttachment() != null) && (getAttachment().size() > 0)) {
                    AttachmentInfo.getAttachView(paramForumActivityStatus, this.mAdapter, getObj_attachment(), this);
                }
            }
            if (this.content.getParent() == null) {
                break label665;
            }
            ((LinearLayout) this.content.getParent()).removeView(this.content);
            localConverSationHolder.msg_shortcontent.addView(this.content);
            label361:
            AvatarTool.showAvatar(this.mActivity, paramForumRootAdapter.forumStatus, localConverSationHolder.msg_author_icon, this.participant.getIcon_url(), 0);
            Util.getUserImage(this.mActivity, paramForumRootAdapter.forumStatus, localConverSationHolder.msg_author_icon, this.participant.getIcon_url(), localConverSationHolder.avaterbg);
            localConverSationHolder.msg_author_icon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (((ConversationOuterFragment) paramForumActivityStatus).getForumStatus().isLogin()) {
                        paramAnonymousView = new Intent(ConversationData.this.mActivity, ProfilesActivity.class);
                        paramAnonymousView.putExtra("forumStatus", ((ConversationOuterFragment) paramForumActivityStatus).getForumStatus());
                        paramAnonymousView.putExtra("iconusername", ConversationData.this.mThis.getParticipant().getUserName());
                        paramAnonymousView.putExtra("userid", ConversationData.this.mThis.getParticipant().getUserId());
                        if (ConversationData.this.mAdapter != null) {
                            paramAnonymousView.putExtra("can_upload", ConversationData.this.mAdapter.can_upload);
                        }
                        ConversationData.this.mActivity.startActivityForResult(paramAnonymousView, 41);
                        return;
                    }
                    Toast.makeText(ConversationData.this.mActivity, ConversationData.this.mActivity.getString(2131099865), 1).show();
                }
            });
            if ((this.attach == null) || (this.attach.getChildCount() <= 0)) {
                break label695;
            }
            if (this.attach.getParent() == null) {
                break label680;
            }
            ((LinearLayout) this.attach.getParent()).removeView(this.attach);
            localConverSationHolder.conversation_attachment.addView(this.attach);
            label487:
            localConverSationHolder.conversation_attachment.setVisibility(0);
            label496:
            if (SettingsFragment.getTimeStyle(this.mActivity) != 0) {
                break label716;
            }
            localConverSationHolder.msg_author_time.setText(Util.formatSmartDate(this.mActivity, Util.stringFormat(getPost_time())));
            label528:
            localConverSationHolder.msg_author_name.setText(getParticipant().getUserName());
            if (this.content.getParent() == null) {
                break label741;
            }
            if (!this.content.getParent().equals(localConverSationHolder.msg_shortcontent)) {
                ((LinearLayout) this.content.getParent()).removeView(this.content);
                localConverSationHolder.msg_shortcontent.addView(this.content);
            }
        }
        for (; ; ) {
            this.contentView = paramView;
            changeBackgroud();
            return paramView;
            localConverSationHolder = (ConverSationHolder) paramView.getTag();
            localConverSationHolder.msg_shortcontent.removeAllViews();
            localConverSationHolder.conversation_attachment.removeAllViews();
            break;
            label642:
            if (paramForumStatus[paramInt] != null) {
                this.content.addView(paramForumStatus[paramInt]);
            }
            paramInt += 1;
            break label285;
            label665:
            localConverSationHolder.msg_shortcontent.addView(this.content);
            break label361;
            label680:
            localConverSationHolder.conversation_attachment.addView(this.attach);
            break label487;
            label695:
            if (localConverSationHolder.conversation_attachment == null) {
                break label496;
            }
            localConverSationHolder.conversation_attachment.setVisibility(8);
            break label496;
            label716:
            localConverSationHolder.msg_author_time.setText(Util.formatDate2(this.mActivity, Util.stringFormat(getPost_time())));
            break label528;
            label741:
            localConverSationHolder.msg_shortcontent.addView(this.content);
        }
    }

    public View getConversationView(ForumStatus paramForumStatus, int paramInt, ForumRootAdapter paramForumRootAdapter, View paramView, ForumActivityStatus paramForumActivityStatus, boolean paramBoolean) {
        ConverSationofMeHolder localConverSationofMeHolder;
        if (paramView == null) {
            localConverSationofMeHolder = new ConverSationofMeHolder();
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903119, null);
            localConverSationofMeHolder.conversation_layout = paramView.findViewById(2131230962);
            localConverSationofMeHolder.conversation_layout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("conversation_blue_bg", paramForumActivityStatus.getDefaultActivity()));
            localConverSationofMeHolder.conversation_attachment_layout = ((LinearLayout) paramView.findViewById(2131230967));
            localConverSationofMeHolder.shortcontent = ((LinearLayout) paramView.findViewById(2131230966));
            localConverSationofMeHolder.author_time = ((TextView) paramView.findViewById(2131230968));
            paramView.setTag(localConverSationofMeHolder);
            if (this.content == null) {
                this.content = new LinearLayout(paramForumActivityStatus.getDefaultActivity());
                this.content.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.content.setOrientation(1);
                paramForumStatus = new MessageContentAdapter(paramForumActivityStatus.getDefaultActivity(), paramForumRootAdapter, paramForumStatus).getViewFromPost(this.posts, this, paramInt, false);
                paramInt = 0;
                label200:
                if (paramInt < paramForumStatus.length) {
                    break label472;
                }
                if ((getAttachment() != null) && (getAttachment().size() > 0)) {
                    AttachmentInfo.getAttachView(paramForumActivityStatus, this.mAdapter, getObj_attachment(), this);
                }
            }
            if (this.content.getParent() == null) {
                break label495;
            }
            ((LinearLayout) this.content.getParent()).removeView(this.content);
            localConverSationofMeHolder.shortcontent.addView(this.content);
            label276:
            if ((this.attach == null) || (this.attach.getChildCount() <= 0)) {
                break label525;
            }
            if (this.attach.getParent() == null) {
                break label510;
            }
            ((LinearLayout) this.attach.getParent()).removeView(this.attach);
            localConverSationofMeHolder.conversation_attachment_layout.addView(this.attach);
            label332:
            localConverSationofMeHolder.conversation_attachment_layout.setVisibility(0);
            label341:
            if (SettingsFragment.getTimeStyle(this.mActivity) != 0) {
                break label546;
            }
            localConverSationofMeHolder.author_time.setText(Util.formatSmartDate(this.mActivity, Util.stringFormat(getPost_time())));
            label373:
            if (this.content.getParent() == null) {
                break label571;
            }
            if (!this.content.getParent().equals(localConverSationofMeHolder.shortcontent)) {
                ((LinearLayout) this.content.getParent()).removeView(this.content);
                localConverSationofMeHolder.shortcontent.addView(this.content);
            }
        }
        for (; ; ) {
            this.contentView = paramView;
            changeBackgroud();
            return paramView;
            localConverSationofMeHolder = (ConverSationofMeHolder) paramView.getTag();
            localConverSationofMeHolder.shortcontent.removeAllViews();
            localConverSationofMeHolder.conversation_attachment_layout.removeAllViews();
            break;
            label472:
            if (paramForumStatus[paramInt] != null) {
                this.content.addView(paramForumStatus[paramInt]);
            }
            paramInt += 1;
            break label200;
            label495:
            localConverSationofMeHolder.shortcontent.addView(this.content);
            break label276;
            label510:
            localConverSationofMeHolder.conversation_attachment_layout.addView(this.attach);
            break label332;
            label525:
            if (localConverSationofMeHolder.conversation_attachment_layout == null) {
                break label341;
            }
            localConverSationofMeHolder.conversation_attachment_layout.setVisibility(8);
            break label341;
            label546:
            localConverSationofMeHolder.author_time.setText(Util.formatDate2(this.mActivity, Util.stringFormat(getPost_time())));
            break label373;
            label571:
            localConverSationofMeHolder.shortcontent.addView(this.content);
        }
    }

    public int getFloor() {
        return 0;
    }

    public ArrayList<ImageInThread> getImageBeans() {
        return this.mBeans;
    }

    public ArrayList<ImageInThread> getImageBeansFinished() {
        return this.mBeansFinished;
    }

    public String getMsg_author_id() {
        return this.msg_author_id;
    }

    public String getMsg_content() {
        return this.msg_content;
    }

    public String getMsg_id() {
        return this.msg_id;
    }

    public Object[] getObj_attachment() {
        return this.obj_attachment;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public String getPostId() {
        return null;
    }

    public int getPostTimeStamp() {
        return (int) (this.post_time.getTime() / 1000L);
    }

    public Date getPost_time() {
        return this.post_time;
    }

    public boolean isDeleted() {
        return false;
    }

    public boolean isHas_left() {
        return this.has_left;
    }

    public boolean isIs_online() {
        return this.is_online;
    }

    public boolean isIs_unread() {
        return this.is_unread;
    }

    public boolean isNew_post() {
        return this.new_post;
    }

    public void setAttachLay(View paramView) {
        this.attach = ((LinearLayout) paramView);
    }

    public void setAttachment(ArrayList<Attachment> paramArrayList) {
        this.attachment = paramArrayList;
    }

    public void setConv_id(String paramString) {
        this.conv_id = paramString;
    }

    public void setHas_left(boolean paramBoolean) {
        this.has_left = paramBoolean;
    }

    public void setIs_online(boolean paramBoolean) {
        this.is_online = paramBoolean;
    }

    public void setIs_unread(boolean paramBoolean) {
        this.is_unread = paramBoolean;
    }

    public void setMsg_author_id(String paramString) {
        this.msg_author_id = paramString;
    }

    public void setMsg_content(String paramString) {
        this.msg_content = paramString;
    }

    public void setMsg_id(String paramString) {
        this.msg_id = paramString;
    }

    public void setNew_post(boolean paramBoolean) {
        this.new_post = paramBoolean;
    }

    public void setObj_attachment(Object[] paramArrayOfObject) {
        this.obj_attachment = paramArrayOfObject;
    }

    public void setParticipant(Participant paramParticipant) {
        this.participant = paramParticipant;
    }

    public void setPost_time(Date paramDate) {
        this.post_time = paramDate;
    }

    class AnActionModeOfEpicProportions
            implements ActionMode.Callback {
        private View contentView;

        public AnActionModeOfEpicProportions(View paramView) {
            this.contentView = paramView;
        }

        public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
            switch (paramMenuItem.getItemId()) {
            }
            for (; ; ) {
                return true;
                ConversationData.this.mAdapter.actionQuote(ConversationData.this.mThis.getConv_id(), ConversationData.this.mThis.getMsg_id());
                paramActionMode.finish();
            }
        }

        public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
            paramMenu.add(0, 1041, 0, ConversationData.this.mActivity.getString(2131100096)).setIcon(2130837634).setShowAsAction(2);
            return true;
        }

        public void onDestroyActionMode(ActionMode paramActionMode) {
            this.contentView.setSelected(false);
        }

        public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
            return false;
        }
    }

    public class ConverSationHolder {
        ImageView avaterbg;
        LinearLayout conversation_attachment;
        View conversation_info;
        GifImageView msg_author_icon;
        TextView msg_author_name;
        TextView msg_author_time;
        LinearLayout msg_shortcontent;

        public ConverSationHolder() {
        }
    }

    public class ConverSationofMeHolder {
        TextView author_time;
        LinearLayout conversation_attachment_layout;
        View conversation_layout;
        LinearLayout shortcontent;

        public ConverSationofMeHolder() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/ConversationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */