package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.saxparser.TabConvSaxParser;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TitleTextView;
import com.quoord.tools.LoginStatus;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Conversation
        extends BaseBean
        implements Serializable {
    private static GradientDrawable draw;
    private static final long serialVersionUID = 5669791794268908340L;
    public View contentView;
    private ConvAdapter convAdapter;
    private String conv_id;
    private String conv_subject;
    private boolean isFromAccountList = false;
    private Date last_conv_time;
    private String last_user_id;
    private LoginStatus loginStatus;
    private Activity mContext = null;
    private boolean new_post = false;
    public String other_1_id;
    public String other_2_id;
    public HashMap<String, Participant> partcipated = new HashMap();
    private String participant_count;
    private String reply_count;
    private Date start_conv_time;
    private String start_user_id;
    private int unread_num;

    public static Conversation createConverBean(HashMap paramHashMap, Context paramContext) {
        if (paramHashMap == null) {
            paramContext = null;
            return paramContext;
        }
        Conversation localConversation = new Conversation();
        if (paramHashMap.get("conv_id") != null) {
            localConversation.setConv_id((String) paramHashMap.get("conv_id"));
        }
        if (paramHashMap.get("reply_count") != null) {
            localConversation.setReply_count((String) paramHashMap.get("reply_count"));
        }
        if (paramHashMap.get("participant_count") != null) {
            paramContext = paramHashMap.get("participant_count");
            if (!(paramContext instanceof String)) {
                break label366;
            }
            localConversation.setParticipant_count((String) paramContext);
        }
        for (; ; ) {
            if (paramHashMap.get("start_user_id") != null) {
                localConversation.setStart_user_id((String) paramHashMap.get("start_user_id"));
            }
            if (paramHashMap.get("last_user_id") != null) {
                localConversation.setLast_user_id((String) paramHashMap.get("last_user_id"));
            }
            if (paramHashMap.get("last_conv_time") != null) {
                localConversation.setLast_conv_time((Date) paramHashMap.get("last_conv_time"));
            }
            if (paramHashMap.get("start_conv_time") != null) {
                localConversation.setStart_conv_time((Date) paramHashMap.get("start_conv_time"));
            }
            if (paramHashMap.get("conv_subject") != null) {
                localConversation.setConv_subject(new String((byte[]) paramHashMap.get("conv_subject")));
            }
            if (paramHashMap.get("new_post") != null) {
                localConversation.setNew_post(((Boolean) paramHashMap.get("new_post")).booleanValue());
            }
            paramContext = localConversation;
            if (paramHashMap.get("participants") == null) {
                break;
            }
            paramHashMap = (HashMap) paramHashMap.get("participants");
            Iterator localIterator = paramHashMap.keySet().iterator();
            for (; ; ) {
                paramContext = localConversation;
                if (!localIterator.hasNext()) {
                    break;
                }
                paramContext = (String) localIterator.next();
                HashMap localHashMap = (HashMap) paramHashMap.get(paramContext);
                Participant localParticipant = new Participant();
                localParticipant.setUserId((String) localHashMap.get("msg_author_id"));
                localParticipant.setUserName(new String((byte[]) localHashMap.get("username")));
                localParticipant.setIcon_url((String) localHashMap.get("icon_url"));
                localConversation.putToPartcipated(paramContext, localParticipant);
            }
            label366:
            localConversation.setParticipant_count(paramHashMap.get("participant_count"));
        }
    }

    public static Conversation createConverBean(HashMap paramHashMap, Context paramContext, boolean paramBoolean) {
        paramHashMap = createConverBean(paramHashMap, paramContext);
        paramHashMap.isFromAccountList = paramBoolean;
        return paramHashMap;
    }

    private void putToPartcipated(String paramString, Participant paramParticipant) {
        this.partcipated.put(paramString, paramParticipant);
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        this.conv_id = ((String) paramObjectInputStream.readObject());
        this.reply_count = ((String) paramObjectInputStream.readObject());
        this.participant_count = ((String) paramObjectInputStream.readObject());
        this.start_user_id = ((String) paramObjectInputStream.readObject());
        this.last_user_id = ((String) paramObjectInputStream.readObject());
        this.last_conv_time = ((Date) paramObjectInputStream.readObject());
        this.start_conv_time = ((Date) paramObjectInputStream.readObject());
        this.other_1_id = ((String) paramObjectInputStream.readObject());
        this.other_2_id = ((String) paramObjectInputStream.readObject());
        this.new_post = ((Boolean) paramObjectInputStream.readObject()).booleanValue();
        this.partcipated = ((HashMap) paramObjectInputStream.readObject());
        this.conv_subject = ((String) paramObjectInputStream.readObject());
        this.unread_num = ((Integer) paramObjectInputStream.readObject()).intValue();
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        paramObjectOutputStream.writeObject(this.conv_id);
        paramObjectOutputStream.writeObject(this.reply_count);
        paramObjectOutputStream.writeObject(this.participant_count);
        paramObjectOutputStream.writeObject(this.start_user_id);
        paramObjectOutputStream.writeObject(this.last_user_id);
        paramObjectOutputStream.writeObject(this.last_conv_time);
        paramObjectOutputStream.writeObject(this.start_conv_time);
        paramObjectOutputStream.writeObject(this.other_1_id);
        paramObjectOutputStream.writeObject(this.other_2_id);
        paramObjectOutputStream.writeObject(Boolean.valueOf(this.new_post));
        paramObjectOutputStream.writeObject(this.partcipated);
        paramObjectOutputStream.writeObject(this.conv_subject);
        paramObjectOutputStream.writeObject(Integer.valueOf(this.unread_num));
    }

    public String getConv_id() {
        return this.conv_id;
    }

    public String getConv_subject() {
        return this.conv_subject;
    }

    public View getConversationView(int paramInt, View paramView, final Activity paramActivity, final ForumRootAdapter paramForumRootAdapter) {
        this.mContext = paramActivity;
        if (draw == null) {
            draw = new GradientDrawable();
            draw.setSize(this.mContext.getResources().getDimensionPixelOffset(2131427384), this.mContext.getResources().getDimensionPixelOffset(2131427385));
            draw.setColor(ThemeUtil.getAuthorColor(this.mContext));
            draw.setShape(0);
        }
        this.convAdapter = ((ConvAdapter) paramForumRootAdapter);
        PMViewHolder localPMViewHolder;
        Participant localParticipant;
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof PMViewHolder))) {
            localPMViewHolder = new PMViewHolder();
            paramView = LayoutInflater.from(paramActivity).inflate(2130903181, null);
            localPMViewHolder.llayout1 = paramView.findViewById(2131230793);
            localPMViewHolder.avaterbg = ((ImageView) paramView.findViewById(2131230795));
            localPMViewHolder.icon = ((GifImageView) paramView.findViewById(2131231144));
            localPMViewHolder.pmAuthor = ((TextView) paramView.findViewById(2131231145));
            localPMViewHolder.pmTime = ((TextView) paramView.findViewById(2131230968));
            localPMViewHolder.pmTitle = ((TitleTextView) paramView.findViewById(2131231146));
            localPMViewHolder.shortContent = ((TextView) paramView.findViewById(2131230801));
            localPMViewHolder.unreadImage = ((ImageView) paramView.findViewById(2131231142));
            ThemeUtil.setAuthorColor(this.mContext, localPMViewHolder.pmAuthor);
            localPMViewHolder.llayout1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", this.mContext));
            localPMViewHolder.avaterbg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.mContext));
            localPMViewHolder.avaterbg.bringToFront();
            paramView.setTag(localPMViewHolder);
            localParticipant = (Participant) this.partcipated.get(getLast_user_id());
            localPMViewHolder.pmTitle.setText(getConv_subject());
            final String str2 = "";
            final String str1 = "";
            if (localParticipant != null) {
                str2 = localParticipant.getUserName();
                str1 = localParticipant.getUserId();
            }
            if (SettingsFragment.getTimeStyle(this.mContext) != 0) {
                break label665;
            }
            localPMViewHolder.pmTime.setText(Util.formatSmartDate(this.mContext, Util.stringFormat(getLast_conv_time())));
            label392:
            if ((localParticipant != null) && (localParticipant.getUserName() != null)) {
                localPMViewHolder.pmAuthor.setText(localParticipant.getUserName());
            }
            if (localParticipant != null) {
                if (paramForumRootAdapter == null) {
                    break label690;
                }
                Util.getUserImage(this.mContext, paramForumRootAdapter.forumStatus, localPMViewHolder.icon, localParticipant.getIcon_url(), localPMViewHolder.avaterbg);
            }
            label455:
            if (paramForumRootAdapter != null) {
                localPMViewHolder.icon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        paramAnonymousView = new Intent(paramActivity, ProfilesActivity.class);
                        if (str2 != null) {
                            paramAnonymousView.putExtra("iconusername", str2);
                            if ((Conversation.this.convAdapter != null) && (Conversation.this.convAdapter.convSaxParser != null)) {
                                paramAnonymousView.putExtra("can_upload", Conversation.this.convAdapter.convSaxParser.isCan_upload());
                            }
                            paramAnonymousView.putExtra("userid", str1);
                            paramAnonymousView.putExtra("forumStatus", paramForumRootAdapter.forumStatus);
                            paramActivity.startActivity(paramAnonymousView);
                            return;
                        }
                        Toast.makeText(paramActivity, paramActivity.getString(2131099810), 1).show();
                    }
                });
            }
            localPMViewHolder.pmTitle.setPadding(0, 0, 0, 0);
            if (!this.isFromAccountList) {
                break label719;
            }
            localPMViewHolder.unreadImage.setVisibility(0);
            label511:
            if (!isNew_post()) {
                break label732;
            }
            localPMViewHolder.pmTitle.setTypeface(Typeface.defaultFromStyle(1), 1);
            if (!SettingsFragment.isLightTheme(this.mContext)) {
                localPMViewHolder.pmTitle.setTextColor(paramActivity.getResources().getColor(2131165213));
            }
            localPMViewHolder.pmTitle.setCompoundDrawablesWithIntrinsicBounds(draw, null, null, null);
            localPMViewHolder.pmTitle.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelOffset(2131427373));
        }
        for (; ; ) {
            paramActivity = null;
            if (localParticipant != null) {
                paramActivity = getWithString(localParticipant.getUserName());
            }
            if ((paramActivity == null) || (paramActivity.length() <= 0)) {
                break label812;
            }
            localPMViewHolder.shortContent.setVisibility(0);
            localPMViewHolder.shortContent.setText(paramActivity);
            localPMViewHolder.shortContent.setTextSize(13.0F);
            return paramView;
            localPMViewHolder = (PMViewHolder) paramView.getTag();
            break;
            label665:
            localPMViewHolder.pmTime.setText(Util.formatDate2(this.mContext, Util.stringFormat(getLast_conv_time())));
            break label392;
            label690:
            Util.getUserImage(this.mContext, this.loginStatus, localPMViewHolder.icon, localParticipant.getIcon_url(), localPMViewHolder.avaterbg);
            break label455;
            label719:
            localPMViewHolder.unreadImage.setVisibility(8);
            break label511;
            label732:
            localPMViewHolder.pmTitle.setTypeface(Typeface.defaultFromStyle(0), 0);
            if (!SettingsFragment.isLightTheme(this.mContext)) {
                localPMViewHolder.pmTitle.setTextColor(paramActivity.getResources().getColor(2131165461));
            }
            localPMViewHolder.pmTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            localPMViewHolder.pmTitle.setPadding(this.mContext.getResources().getDimensionPixelOffset(2131427374), 0, 0, 0);
        }
        label812:
        localPMViewHolder.shortContent.setVisibility(8);
        localPMViewHolder.pmTitle.setPadding(localPMViewHolder.pmTitle.getPaddingLeft(), localPMViewHolder.pmTitle.getPaddingTop(), localPMViewHolder.pmTitle.getPaddingRight(), 20);
        return paramView;
    }

    public Date getLast_conv_time() {
        return this.last_conv_time;
    }

    public String getLast_user_id() {
        return this.last_user_id;
    }

    public String getParticipant_count() {
        return this.participant_count;
    }

    public String getReply_count() {
        return this.reply_count;
    }

    public Date getStart_conv_time() {
        return this.start_conv_time;
    }

    public String getStart_user_id() {
        return this.start_user_id;
    }

    public int getUnread_num() {
        return this.unread_num;
    }

    public String getWithString(String paramString) {
        Object localObject1 = "";
        Iterator localIterator = this.partcipated.keySet().iterator();
        label268:
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return (String) localObject1;
            }
            String str1 = (String) localIterator.next();
            if ((this.partcipated.get(str1) != null) && (((Participant) this.partcipated.get(str1)).getUserName() != null) && (!((Participant) this.partcipated.get(str1)).getUserName().equalsIgnoreCase(paramString))) {
                String str2 = ((Participant) this.partcipated.get(str1)).getUserName();
                if (this.loginStatus == null) {
                }
                for (Object localObject2 = this.convAdapter.forumStatus.tapatalkForum.getUserName(); ; localObject2 = this.loginStatus.getUserName()) {
                    if (str2.equalsIgnoreCase((String) localObject2)) {
                        break label268;
                    }
                    localObject2 = localObject1;
                    if (((String) localObject1).length() > 0) {
                        localObject2 = localObject1 + ", ";
                    }
                    localObject2 = localObject2 + ((Participant) this.partcipated.get(str1)).getUserName();
                    localObject1 = localObject2;
                    if (this.convAdapter == null) {
                        break;
                    }
                    this.convAdapter.userNameList.put(((Participant) this.partcipated.get(str1)).getUserName(), ((Participant) this.partcipated.get(str1)).getUserName());
                    localObject1 = localObject2;
                    break;
                }
            }
        }
    }

    public boolean isNew_post() {
        return this.new_post;
    }

    public void setConv_id(String paramString) {
        this.conv_id = paramString;
    }

    public void setConv_subject(String paramString) {
        this.conv_subject = paramString;
    }

    public void setLast_conv_time(Date paramDate) {
        this.last_conv_time = paramDate;
    }

    public void setLast_user_id(String paramString) {
        this.last_user_id = paramString;
    }

    public void setLoginStatus(LoginStatus paramLoginStatus) {
        this.loginStatus = paramLoginStatus;
    }

    public void setNew_post(boolean paramBoolean) {
        this.new_post = paramBoolean;
    }

    public void setParticipant_count(String paramString) {
        this.participant_count = paramString;
    }

    public void setReply_count(String paramString) {
        this.reply_count = paramString;
    }

    public void setStart_conv_time(Date paramDate) {
        this.start_conv_time = paramDate;
    }

    public void setStart_user_id(String paramString) {
        this.start_user_id = paramString;
    }

    public void setUnread_num(int paramInt) {
        this.unread_num = paramInt;
    }

    static class PMViewHolder {
        ImageView avaterbg;
        GifImageView icon;
        View llayout1;
        TextView pmAuthor;
        TextView pmTime;
        TitleTextView pmTitle;
        TextView shortContent;
        ImageView unreadImage;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Conversation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */