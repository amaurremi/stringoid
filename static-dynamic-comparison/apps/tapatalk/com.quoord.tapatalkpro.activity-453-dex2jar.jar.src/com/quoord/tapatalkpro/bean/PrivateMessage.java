package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.DialogUtil.PMDialogAdapter;
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.PmContentFragment;
import com.quoord.tapatalkpro.activity.forum.ProfilesActivity;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.ShortContentView;
import com.quoord.tapatalkpro.view.TitleTextView;
import com.quoord.tools.LoginStatus;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PrivateMessage
        extends BaseBean
        implements Serializable, ParseableData {
    private static int UNREAD = 1;
    private static GradientDrawable draw;
    private static final long serialVersionUID = 3281960664643895938L;
    private static int timeStamp = 0;
    private String boxId;
    private String icon_url;
    private boolean isFromAccountList = false;
    private boolean isInbox;
    private LoginStatus loginStatus;
    public ArrayList<ImageInThread> mBeansFinished = new ArrayList();
    private Context mContext = null;
    private String msg_from;
    private String msg_from_display;
    private String msg_from_id;
    private String msg_id;
    private int msg_state = -1;
    private String msg_subject;
    private ArrayList<String> msg_to = new ArrayList();
    private ArrayList<String> msg_to_display = new ArrayList();
    private ArrayList<String> msg_to_userid = new ArrayList();
    private String sentDateString;
    private String sentSmartDateString;
    private Date sent_date;
    private Date sent_standard_date;
    private String shortContent;
    private String text_body;
    public ArrayList<String> url = new ArrayList();

    public static PrivateMessage createPMBean(HashMap paramHashMap, Context paramContext, String paramString, boolean paramBoolean, PrivateMessage paramPrivateMessage) {
        if (paramHashMap == null) {
            return null;
        }
        PrivateMessage localPrivateMessage = paramPrivateMessage;
        if (paramPrivateMessage == null) {
            localPrivateMessage = new PrivateMessage();
        }
        if ((paramHashMap.containsKey("msg_id")) && ((paramHashMap.get("msg_id") instanceof String))) {
            localPrivateMessage.setMsgid((String) paramHashMap.get("msg_id"));
        }
        if ((paramHashMap.containsKey("icon_url")) && ((paramHashMap.get("icon_url") instanceof String))) {
            localPrivateMessage.setIconUrl((String) paramHashMap.get("icon_url"));
        }
        localPrivateMessage.setBoxId(paramString);
        localPrivateMessage.setInbox(paramBoolean);
        if ((paramHashMap.containsKey("msg_state")) && ((paramHashMap.get("msg_state") instanceof Integer))) {
            paramString = (Integer) paramHashMap.get("msg_state");
            if (paramString != null) {
                localPrivateMessage.setMsgState(paramString.intValue());
            }
        }
        if ((Date) paramHashMap.get("sent_date") != null) {
            localPrivateMessage.setSentDate((Date) paramHashMap.get("sent_date"), paramContext);
            localPrivateMessage.setSent_tandard_date((Date) paramHashMap.get("sent_date"), paramContext);
        }
        try {
            if (paramHashMap.containsKey("short_content")) {
                localPrivateMessage.setShortContent(new String((byte[]) paramHashMap.get("short_content"), "UTF-8"));
            }
            if (paramHashMap.containsKey("msg_from_display_name")) {
                localPrivateMessage.setMsg_from_display(new String((byte[]) paramHashMap.get("msg_from_display_name"), "UTF-8"));
            }
            if (paramHashMap.containsKey("msg_from")) {
                localPrivateMessage.setMsgFrom(new String((byte[]) paramHashMap.get("msg_from"), "UTF-8"));
            }
            if ((paramHashMap.containsKey("msg_from_id")) && ((paramHashMap.get("msg_from_id") instanceof String))) {
                localPrivateMessage.setMsgFromId((String) paramHashMap.get("msg_from_id"));
            }
            if (!paramHashMap.containsKey("msg_to")) {
                break label376;
            }
            paramContext = (Object[]) paramHashMap.get("msg_to");
            localPrivateMessage.msg_to_display.clear();
            localPrivateMessage.msg_to.clear();
            localPrivateMessage.msg_to_userid.clear();
            i = 0;
        } catch (UnsupportedEncodingException paramHashMap) {
            for (; ; ) {
                int i;
                label376:
                paramHashMap.printStackTrace();
                continue;
                i += 1;
            }
        }
        if (i >= paramContext.length) {
            if (paramHashMap.containsKey("msg_subject")) {
                localPrivateMessage.setMsgSubject(new String((byte[]) paramHashMap.get("msg_subject"), "UTF-8"));
            }
            paramContext = "";
            paramBoolean = paramHashMap.containsKey("text_body");
            if (!paramBoolean) {
            }
        }
        try {
            paramHashMap = new String(Util.parseByteArray((byte[]) paramHashMap.get("text_body")), "UTF-8");
            localPrivateMessage.setTextBody(paramHashMap);
            localPrivateMessage.url = new ArrayList();
            localPrivateMessage.mBeansFinished = new ArrayList();
            return localPrivateMessage;
            paramString = (HashMap) paramContext[i];
            if ((paramString != null) && (paramString.containsKey("username")) && ((paramString.get("username") instanceof byte[])) && (((byte[]) paramString.get("username")).length > 0)) {
                localPrivateMessage.setMsgTo(new String((byte[]) paramString.get("username"), "UTF-8"));
            }
            if ((paramString != null) && (paramString.containsKey("username")) && ((paramString.get("display_name") instanceof byte[])) && (((byte[]) paramString.get("display_name")).length > 0)) {
                localPrivateMessage.setMsgToDisplay(new String((byte[]) paramString.get("display_name"), "UTF-8"));
            }
            if ((paramString != null) && (paramString.containsKey("user_id")) && ((paramString.get("user_id") instanceof String)) && (((String) paramString.get("user_id")).length() > 0)) {
                localPrivateMessage.setMsgToUserid(new String((String) paramString.get("user_id")));
            }
        } catch (UnsupportedEncodingException paramHashMap) {
            for (; ; ) {
                paramHashMap.printStackTrace();
                paramHashMap = paramContext;
            }
        }
    }

    public static PrivateMessage createPMBean(HashMap paramHashMap, Context paramContext, String paramString, boolean paramBoolean1, PrivateMessage paramPrivateMessage, boolean paramBoolean2) {
        paramHashMap = createPMBean(paramHashMap, paramContext, paramString, paramBoolean1, paramPrivateMessage);
        paramHashMap.isFromAccountList = true;
        return paramHashMap;
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
            throws IOException, ClassNotFoundException {
        this.sent_standard_date = ((Date) paramObjectInputStream.readObject());
        this.msg_id = ((String) paramObjectInputStream.readObject());
        this.sent_date = ((Date) paramObjectInputStream.readObject());
        this.msg_from = ((String) paramObjectInputStream.readObject());
        this.msg_from_display = ((String) paramObjectInputStream.readObject());
        this.shortContent = ((String) paramObjectInputStream.readObject());
        this.msg_subject = ((String) paramObjectInputStream.readObject());
        this.msg_to = ((ArrayList) paramObjectInputStream.readObject());
        this.shortContent = ((String) paramObjectInputStream.readObject());
        this.msg_to_display = ((ArrayList) paramObjectInputStream.readObject());
        this.text_body = ((String) paramObjectInputStream.readObject());
        this.icon_url = ((String) paramObjectInputStream.readObject());
        this.sentDateString = ((String) paramObjectInputStream.readObject());
        this.msg_state = paramObjectInputStream.readInt();
        this.boxId = ((String) paramObjectInputStream.readObject());
        this.isInbox = paramObjectInputStream.readBoolean();
        this.msg_from_id = ((String) paramObjectInputStream.readObject());
        this.msg_to_userid = ((ArrayList) paramObjectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
            throws IOException {
        paramObjectOutputStream.writeObject(this.sent_standard_date);
        paramObjectOutputStream.writeObject(this.msg_id);
        paramObjectOutputStream.writeObject(this.sent_date);
        paramObjectOutputStream.writeObject(this.msg_from);
        paramObjectOutputStream.writeObject(this.msg_from_display);
        paramObjectOutputStream.writeObject(this.shortContent);
        paramObjectOutputStream.writeObject(this.msg_subject);
        paramObjectOutputStream.writeObject(this.msg_to);
        paramObjectOutputStream.writeObject(this.shortContent);
        paramObjectOutputStream.writeObject(this.msg_to_display);
        paramObjectOutputStream.writeObject(this.text_body);
        paramObjectOutputStream.writeObject(this.icon_url);
        paramObjectOutputStream.writeObject(this.sentDateString);
        paramObjectOutputStream.writeInt(this.msg_state);
        paramObjectOutputStream.writeObject(this.boxId);
        paramObjectOutputStream.writeBoolean(this.isInbox);
        paramObjectOutputStream.writeObject(this.msg_from_id);
        paramObjectOutputStream.writeObject(this.msg_to_userid);
    }

    public void actionFwdPm(PmContentFragment paramPmContentFragment, ForumStatus paramForumStatus, ForumRootAdapter paramForumRootAdapter) {
        paramForumRootAdapter.curAction = 2;
        if (paramForumStatus.getApiLevel() >= 3) {
            paramPmContentFragment.showProgress();
            getQuotePm(this, paramForumRootAdapter);
            return;
        }
        getMessage(this, paramForumRootAdapter, paramForumStatus);
    }

    public void actionReplay(PmContentFragment paramPmContentFragment, ForumStatus paramForumStatus, ForumRootAdapter paramForumRootAdapter) {
        paramForumRootAdapter.curAction = 4;
        Intent localIntent = new Intent(paramPmContentFragment.mActivity, CreatePmActivity.class);
        localIntent.putExtra("action", paramForumRootAdapter.curAction);
        localIntent.putExtra("pm", this);
        localIntent.putExtra("forumStatus", paramForumStatus);
        paramPmContentFragment.startActivityForResult(localIntent, 11);
    }

    public void actionReplyAll(PmContentFragment paramPmContentFragment, ForumStatus paramForumStatus, ForumRootAdapter paramForumRootAdapter) {
        paramForumRootAdapter.curAction = 3;
        if (paramForumStatus.getApiLevel() >= 3) {
            paramPmContentFragment.showProgress();
            getQuotePm(this, paramForumRootAdapter);
            return;
        }
        paramForumRootAdapter = new Intent(paramPmContentFragment.mActivity, CreatePmActivity.class);
        paramForumRootAdapter.putExtra("action", 1);
        paramForumRootAdapter.putExtra("pm", this);
        paramForumRootAdapter.putExtra("forumStatus", paramForumStatus);
        paramPmContentFragment.startActivityForResult(paramForumRootAdapter, 11);
    }

    public void actionReplyPm(PmContentFragment paramPmContentFragment, ForumStatus paramForumStatus, ForumRootAdapter paramForumRootAdapter) {
        paramForumRootAdapter.curAction = 1;
        if (paramForumStatus.getApiLevel() >= 3) {
            paramPmContentFragment.showProgress();
            getQuotePm(this, paramForumRootAdapter);
            return;
        }
        paramForumRootAdapter = new Intent(paramPmContentFragment.mActivity, CreatePmActivity.class);
        paramForumRootAdapter.putExtra("action", 1);
        paramForumRootAdapter.putExtra("pm", this);
        paramForumRootAdapter.putExtra("forumStatus", paramForumStatus);
        paramPmContentFragment.startActivityForResult(paramForumRootAdapter, 11);
    }

    public void addImageBeanToFinished(ImageInThread paramImageInThread) {
        if (!this.url.contains(paramImageInThread)) {
            this.mBeansFinished.add(paramImageInThread);
        }
    }

    public void deleteMessage(ForumRootAdapter paramForumRootAdapter) {
        paramForumRootAdapter.setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(getMsgId());
        if (paramForumRootAdapter.forumStatus.getApiLevel() >= 3) {
            localArrayList.add(this.boxId);
        }
        paramForumRootAdapter.getEngine().call("delete_message", localArrayList);
    }

    public void destory() {
    }

    public String getBoxId() {
        return this.boxId;
    }

    public int getFloor() {
        return 0;
    }

    public String getIconUrl() {
        return this.icon_url;
    }

    public ArrayList getImageBeans() {
        return null;
    }

    public ArrayList<ImageInThread> getImageBeansFinished() {
        return this.mBeansFinished;
    }

    public LoginStatus getLoginStatus() {
        return this.loginStatus;
    }

    public AlertDialog getLongClickDialog(final Activity paramActivity, PrivateMessage paramPrivateMessage, final ForumStatus paramForumStatus, final Handler paramHandler) {
        paramForumStatus = new PMDialogAdapter(paramActivity, paramForumStatus, "");
        new AlertDialog.Builder(paramActivity).setTitle(paramPrivateMessage.getMsgSubject()).setAdapter(paramForumStatus, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (paramForumStatus.getItem(paramAnonymousInt).equalsIgnoreCase(paramActivity.getString(2131099817))) {
                    paramHandler.sendEmptyMessage(1);
                }
            }
        }).create();
    }

    public void getMessage(PrivateMessage paramPrivateMessage, ForumRootAdapter paramForumRootAdapter, ForumStatus paramForumStatus) {
        paramForumRootAdapter.setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramPrivateMessage.getMsgId());
        if (paramForumStatus.getApiLevel() >= 3) {
            localArrayList.add(this.boxId);
        }
        paramPrivateMessage.setMsgState(0);
        paramForumRootAdapter.getEngine().call("get_message", localArrayList);
    }

    public String getMsgFrom() {
        return this.msg_from;
    }

    public String getMsgFromId() {
        return this.msg_from_id;
    }

    public String getMsgId() {
        return this.msg_id;
    }

    public int getMsgState() {
        return this.msg_state;
    }

    public String getMsgSubject() {
        return this.msg_subject;
    }

    public ArrayList<String> getMsgTo() {
        return this.msg_to;
    }

    public String getMsgToString() {
        String str1 = "";
        int i;
        String str2;
        if ((this.msg_to_display != null) && (this.msg_to_display.size() > 0)) {
            i = 0;
            if (i >= this.msg_to_display.size()) {
                str2 = str1;
            }
        }
        for (; ; ) {
            if ((str2 != null) && (str2.length() > 0)) {
                return str2;
                str2 = str1;
                if (i > 0) {
                    str2 = str1 + ";";
                }
                str1 = str2 + (String) this.msg_to_display.get(i);
                i += 1;
                break;
                str2 = str1;
                if (this.msg_to != null) {
                    str2 = str1;
                    if (this.msg_to.size() > 0) {
                        i = 0;
                        for (; ; ) {
                            str2 = str1;
                            if (i >= this.msg_to.size()) {
                                break;
                            }
                            str2 = str1;
                            if (i > 0) {
                                str2 = str1 + ";";
                            }
                            str1 = str2 + (String) this.msg_to.get(i);
                            i += 1;
                        }
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<String> getMsgToUserid() {
        return this.msg_to_userid;
    }

    public String getMsg_from_display() {
        return this.msg_from_display;
    }

    public View getPMView(int paramInt, PrivateMessage paramPrivateMessage, final View paramView, final ViewGroup paramViewGroup, final Activity paramActivity, boolean paramBoolean1, ForumActivityStatus paramForumActivityStatus, final ForumRootAdapter paramForumRootAdapter, boolean paramBoolean2) {
        if (draw == null) {
            draw = new GradientDrawable();
            draw.setSize(paramActivity.getResources().getDimensionPixelOffset(2131427384), paramActivity.getResources().getDimensionPixelOffset(2131427385));
            draw.setColor(ThemeUtil.getAuthorColor(paramActivity));
            draw.setShape(0);
        }
        this.mContext = paramActivity;
        View localView;
        PMViewHolder localPMViewHolder;
        label304:
        String str;
        label346:
        label357:
        label377:
        Object localObject;
        if ((paramView == null) || (paramView.getTag() == null) || (!(paramView.getTag() instanceof PMViewHolder))) {
            localView = LayoutInflater.from(paramActivity).inflate(2130903198, null);
            localPMViewHolder = new PMViewHolder();
            localPMViewHolder.avaterbg = ((ImageView) localView.findViewById(2131230795));
            localPMViewHolder.llayout1 = localView.findViewById(2131230793);
            localPMViewHolder.icon = ((GifImageView) localView.findViewById(2131231144));
            localPMViewHolder.pmAuthor = ((TextView) localView.findViewById(2131231145));
            ThemeUtil.setAuthorColor(paramActivity, localPMViewHolder.pmAuthor);
            localPMViewHolder.pmTime = ((TextView) localView.findViewById(2131230968));
            localPMViewHolder.pmTitle = ((TitleTextView) localView.findViewById(2131231146));
            localPMViewHolder.shortContent = ((ShortContentView) localView.findViewById(2131230801));
            localPMViewHolder.unreadImage = ((ImageView) localView.findViewById(2131231142));
            localPMViewHolder.avaterbg.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", paramActivity));
            localPMViewHolder.avaterbg.bringToFront();
            localView.setTag(localPMViewHolder);
            if (!paramBoolean2) {
                break label639;
            }
            localPMViewHolder.llayout1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_select_bg", paramForumActivityStatus.getDefaultActivity()));
            paramViewGroup = "";
            str = "";
            if (!paramBoolean1) {
                break label678;
            }
            paramView = str;
            if (paramPrivateMessage.getMsgFrom() != null) {
                if (paramPrivateMessage.getMsg_from_display() == null) {
                    break label663;
                }
                localPMViewHolder.pmAuthor.setText(paramPrivateMessage.getMsg_from_display());
                paramViewGroup = paramPrivateMessage.getMsgFrom();
                paramView = paramPrivateMessage.getMsgFromId();
            }
            if (SettingsFragment.getTimeStyle(paramActivity) != 0) {
                break label763;
            }
            localPMViewHolder.pmTime.setText(paramPrivateMessage.getSentSmartDateString());
            localPMViewHolder.pmTitle.setText(paramPrivateMessage.getMsgSubject());
            if (paramPrivateMessage.getShortContent() != null) {
                str = paramPrivateMessage.getShortContent().replaceAll("&quot;", "\"");
                localObject = new GetEmojiImage(paramForumActivityStatus.getDefaultActivity());
                ((GetEmojiImage) localObject).view = localPMViewHolder.shortContent;
                paramForumActivityStatus = Html.fromHtml(BBcodeUtil.parseSmile(str, paramForumActivityStatus.getForumStatus()), (Html.ImageGetter) localObject, new MyTagHandler());
                localPMViewHolder.shortContent.setText(paramForumActivityStatus);
            }
            if (paramForumRootAdapter == null) {
                break label778;
            }
            Util.getUserImage(paramActivity, paramForumRootAdapter.forumStatus, localPMViewHolder.icon, this.icon_url, localPMViewHolder.avaterbg);
            label502:
            if (this.loginStatus == null) {
                localPMViewHolder.icon.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        paramAnonymousView = new Intent(paramActivity, ProfilesActivity.class);
                        if (paramViewGroup != null) {
                            paramAnonymousView.putExtra("iconusername", paramViewGroup);
                            paramAnonymousView.putExtra("userid", paramView);
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
                break label804;
            }
            localPMViewHolder.unreadImage.setVisibility(0);
        }
        for (; ; ) {
            if (paramPrivateMessage.getMsgState() != UNREAD) {
                break label817;
            }
            localPMViewHolder.pmTitle.isRead(true);
            localPMViewHolder.shortContent.isRead(true);
            localPMViewHolder.pmTitle.setCompoundDrawablesWithIntrinsicBounds(draw, null, null, null);
            localPMViewHolder.pmTitle.setCompoundDrawablePadding(paramActivity.getResources().getDimensionPixelOffset(2131427373));
            return localView;
            localPMViewHolder = (PMViewHolder) paramView.getTag();
            localView = paramView;
            break;
            label639:
            localPMViewHolder.llayout1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", paramForumActivityStatus.getDefaultActivity()));
            break label304;
            label663:
            localPMViewHolder.pmAuthor.setText(paramPrivateMessage.getMsgFrom());
            break label346;
            label678:
            paramView = str;
            if (paramPrivateMessage.getMsgToString() == null) {
                break label357;
            }
            localPMViewHolder.pmAuthor.setText(paramPrivateMessage.getMsgToString());
            localObject = (String) paramPrivateMessage.getMsgTo().get(0);
            paramView = str;
            paramViewGroup = (ViewGroup) localObject;
            if (paramPrivateMessage.getMsgToUserid() == null) {
                break label357;
            }
            paramView = str;
            paramViewGroup = (ViewGroup) localObject;
            if (paramPrivateMessage.getMsgToUserid().size() <= 0) {
                break label357;
            }
            paramView = (String) paramPrivateMessage.getMsgToUserid().get(0);
            paramViewGroup = (ViewGroup) localObject;
            break label357;
            label763:
            localPMViewHolder.pmTime.setText(paramPrivateMessage.getSentDateString());
            break label377;
            label778:
            Util.getUserImage(paramActivity, this.loginStatus, localPMViewHolder.icon, this.icon_url, localPMViewHolder.avaterbg);
            break label502;
            label804:
            localPMViewHolder.unreadImage.setVisibility(8);
        }
        label817:
        localPMViewHolder.pmTitle.isRead(false);
        localPMViewHolder.shortContent.isRead(false);
        localPMViewHolder.pmTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        localPMViewHolder.pmTitle.setPadding(paramActivity.getResources().getDimensionPixelOffset(2131427374), 0, 0, 0);
        return localView;
    }

    public String getPostId() {
        return null;
    }

    public int getPostTimeStamp() {
        return (int) (this.sent_date.getTime() / 1000L);
    }

    public void getQuotePm(PrivateMessage paramPrivateMessage, ForumRootAdapter paramForumRootAdapter) {
        paramForumRootAdapter.setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramPrivateMessage.getMsgId());
        paramForumRootAdapter.getEngine().call("get_quote_pm", localArrayList);
    }

    public String getReplyAllString(String paramString) {
        Object localObject1;
        int i;
        Object localObject2;
        if ((this.msg_to_display != null) && (this.msg_to_display.size() > 0)) {
            localObject1 = this.msg_to_display;
            i = 0;
            if (i >= this.msg_to_display.size()) {
                paramString = "";
                localObject2 = paramString;
                if (localObject1 != null) {
                    localObject2 = paramString;
                    if (((ArrayList) localObject1).size() > 0) {
                        i = 0;
                    }
                }
            }
        }
        for (; ; ) {
            if (i >= ((ArrayList) localObject1).size()) {
                localObject2 = paramString;
                if ((this.msg_from_display == null) || (this.msg_from_display.length() <= 0)) {
                    break label262;
                }
                return this.msg_from_display + ";" + (String) localObject2;
                if (((String) this.msg_to_display.get(i)).equalsIgnoreCase(paramString)) {
                    ((ArrayList) localObject1).remove(i);
                }
                i += 1;
                break;
                localObject2 = this.msg_to;
                i = 0;
                for (; ; ) {
                    localObject1 = localObject2;
                    if (i >= this.msg_to.size()) {
                        break;
                    }
                    if (((String) this.msg_to.get(i)).equalsIgnoreCase(paramString)) {
                        ((ArrayList) localObject2).remove(i);
                    }
                    i += 1;
                }
            }
            localObject2 = paramString;
            if (i > 0) {
                localObject2 = paramString + ";";
            }
            paramString = localObject2 + (String) ((ArrayList) localObject1).get(i);
            i += 1;
        }
        label262:
        return this.msg_from + ";" + (String) localObject2;
    }

    public Date getSentDate() {
        return this.sent_date;
    }

    public String getSentDateString() {
        return this.sentDateString;
    }

    public String getSentSmartDateString() {
        return this.sentSmartDateString;
    }

    public Date getSent_standard_date() {
        return this.sent_standard_date;
    }

    public String getShortContent() {
        return this.shortContent;
    }

    public String getTextBody() {
        return this.text_body;
    }

    public boolean isDeleted() {
        return false;
    }

    public boolean isInbox() {
        return this.isInbox;
    }

    public void setAttachLay(View paramView) {
    }

    public void setBoxId(String paramString) {
        this.boxId = paramString;
    }

    public void setIconUrl(String paramString) {
        this.icon_url = paramString;
    }

    public void setInbox(boolean paramBoolean) {
        this.isInbox = paramBoolean;
    }

    public void setLoginStatus(LoginStatus paramLoginStatus) {
        this.loginStatus = paramLoginStatus;
    }

    public void setMsgFrom(String paramString) {
        this.msg_from = paramString;
    }

    public void setMsgFromId(String paramString) {
        this.msg_from_id = paramString;
    }

    public void setMsgState(int paramInt) {
        this.msg_state = paramInt;
    }

    public void setMsgSubject(String paramString) {
        this.msg_subject = paramString;
    }

    public void setMsgTo(String paramString) {
        this.msg_to.add(paramString);
    }

    public void setMsgToDisplay(String paramString) {
        this.msg_to_display.add(paramString);
    }

    public void setMsgToUserid(String paramString) {
        this.msg_to_userid.add(paramString);
    }

    public void setMsg_from_display(String paramString) {
        this.msg_from_display = paramString;
    }

    public void setMsgid(String paramString) {
        this.msg_id = paramString;
    }

    public void setSentDate(Date paramDate, Context paramContext) {
        this.sent_date = paramDate;
        setSentSmartDateString(Util.formatSmartDate(paramContext, Util.stringFormat(paramDate)));
    }

    public void setSentDateString(String paramString) {
        this.sentDateString = paramString;
    }

    public void setSentSmartDateString(String paramString) {
        this.sentSmartDateString = paramString;
    }

    public void setSent_tandard_date(Date paramDate, Context paramContext) {
        this.sent_date = paramDate;
        setSentDateString(Util.formatDate2(paramContext, Util.stringFormat(paramDate)));
    }

    public void setShortContent(String paramString) {
        this.shortContent = paramString;
    }

    public void setTextBody(String paramString) {
        this.text_body = paramString;
    }

    protected static class PMViewHolder {
        ImageView avaterbg;
        GifImageView icon;
        View llayout1;
        TextView pmAuthor;
        TextView pmTime;
        TitleTextView pmTitle;
        ShortContentView shortContent;
        ImageView unreadImage;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/PrivateMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */