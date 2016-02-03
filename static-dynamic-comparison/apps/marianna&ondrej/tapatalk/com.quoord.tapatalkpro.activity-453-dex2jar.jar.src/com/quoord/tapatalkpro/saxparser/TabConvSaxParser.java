package com.quoord.tapatalkpro.saxparser;

import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Participant;
import com.quoord.tapatalkpro.util.Base64;
import com.quoord.xmlrpc.XmlRpcParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class TabConvSaxParser
        implements ContentHandler {
    private boolean can_upload = false;
    private String conv_id;
    private String conv_subject;
    private Conversation conversation;
    private int conversation_count = 0;
    private String currentName;
    Participant currentParticipant;
    private String currentTag = "";
    private ForumStatus forumStatus;
    private String icon_url;
    boolean inEnterPart;
    boolean inPartChild;
    boolean isEnterList;
    private boolean is_newPost;
    private String last_conv_time;
    private String last_user_id;
    private int level = 0;
    private ICallback mCallback;
    private boolean mIsName;
    private String participant_count;
    private String reply_count;
    private boolean result;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(XmlRpcParser.DATETIME_FORMAT);
    private String start_conv_time;
    private String start_user_id;
    private int unread_count = 0;
    private int unread_num = 0;
    private String userId;
    private String username;

    public TabConvSaxParser() {
    }

    public TabConvSaxParser(ForumStatus paramForumStatus) {
        this.forumStatus = paramForumStatus;
    }

    private void parseName(String paramString) {
        this.currentTag = paramString;
    }

    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        if (paramArrayOfChar.equals("\n")) {
        }
        do {
            do {
                do {
                    do {
                        do {
                            for (; ; ) {
                                return;
                                if (!this.mIsName) {
                                    break;
                                }
                                if (this.currentName != null) {
                                    this.currentName += paramArrayOfChar;
                                    parseName(this.currentName.trim());
                                }
                                while (this.level == 3) {
                                    this.currentParticipant = new Participant();
                                    this.userId = paramArrayOfChar;
                                    this.currentParticipant.setUserId(this.userId);
                                    return;
                                    this.currentName = paramArrayOfChar;
                                    parseName(paramArrayOfChar.trim());
                                }
                            }
                            switch (this.level) {
                                case 3:
                                default:
                                    return;
                                case 1:
                                    if (this.currentTag.equals("conversation_count")) {
                                        this.conversation_count = Integer.parseInt(paramArrayOfChar);
                                        return;
                                    }
                                    if (this.currentTag.equals("result")) {
                                        if (paramArrayOfChar.equalsIgnoreCase("1")) {
                                            this.result = true;
                                            return;
                                        }
                                        this.result = false;
                                        return;
                                    }
                                    if (this.currentTag.equals("unread_count")) {
                                        this.unread_count = Integer.parseInt(paramArrayOfChar);
                                        return;
                                    }
                                    break;
                            }
                        } while (!this.currentTag.equals("can_upload"));
                        if (!paramArrayOfChar.equalsIgnoreCase("1")) {
                            break;
                        }
                        this.can_upload = true;
                    } while (this.forumStatus == null);
                    this.forumStatus.setCan_upload_attachment_conv(true);
                    return;
                    this.can_upload = false;
                } while (this.forumStatus == null);
                this.forumStatus.setCan_upload_attachment_conv(false);
                return;
                if (this.currentTag.equals("conv_id")) {
                    if (this.conv_id == null) {
                        this.conv_id = paramArrayOfChar;
                        return;
                    }
                    this.conv_id += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("reply_count")) {
                    if (this.reply_count == null) {
                        this.reply_count = paramArrayOfChar;
                        return;
                    }
                    this.reply_count += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("participant_count")) {
                    if (this.participant_count == null) {
                        this.participant_count = paramArrayOfChar;
                        return;
                    }
                    this.participant_count += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("start_user_id")) {
                    if (this.start_user_id == null) {
                        this.start_user_id = paramArrayOfChar;
                        return;
                    }
                    this.start_user_id += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("last_user_id")) {
                    if (this.last_user_id == null) {
                        this.last_user_id = paramArrayOfChar;
                        return;
                    }
                    this.last_user_id += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("last_conv_time")) {
                    if (this.last_conv_time == null) {
                        this.last_conv_time = paramArrayOfChar;
                        return;
                    }
                    this.last_conv_time += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("start_conv_time")) {
                    if (this.start_conv_time == null) {
                        this.start_conv_time = paramArrayOfChar;
                        return;
                    }
                    this.start_conv_time += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("conv_subject")) {
                    if (this.conv_subject == null) {
                        this.conv_subject = paramArrayOfChar;
                        return;
                    }
                    this.conv_subject += paramArrayOfChar;
                    return;
                }
                if (this.currentTag.equals("new_post")) {
                    if (paramArrayOfChar.equalsIgnoreCase("1")) {
                        this.is_newPost = true;
                        return;
                    }
                    this.is_newPost = false;
                    return;
                }
            } while (!this.currentTag.equals("unread_num"));
            this.unread_num = Integer.parseInt(paramArrayOfChar);
            return;
            if (this.currentTag.equals("username")) {
                if (this.username == null) {
                    this.username = paramArrayOfChar;
                    return;
                }
                this.username += paramArrayOfChar;
                return;
            }
        } while (!this.currentTag.equals("icon_url"));
        if (this.icon_url == null) {
            this.icon_url = paramArrayOfChar;
            return;
        }
        this.icon_url += paramArrayOfChar;
    }

    public void endDocument()
            throws SAXException {
        this.mCallback.onDocEnd();
    }

    public void endElement(String paramString1, String paramString2, String paramString3)
            throws SAXException {
        if (paramString2.equals("struct")) {
            switch (this.level) {
            }
        }
        for (; ; ) {
            this.level -= 1;
            return;
            if (this.conv_id != null) {
                this.conversation.setConv_id(this.conv_id);
            }
            if (this.reply_count != null) {
                this.conversation.setReply_count(this.reply_count);
            }
            if (this.participant_count != null) {
                this.conversation.setParticipant_count(this.participant_count);
            }
            if (this.start_user_id != null) {
                this.conversation.setStart_user_id(this.start_user_id);
            }
            if (this.last_user_id != null) {
                this.conversation.setLast_user_id(this.last_user_id);
            }
            this.conversation.setUnread_num(this.unread_num);
            if (this.last_conv_time != null) {
            }
            try {
                this.conversation.setLast_conv_time((Date) this.simpleDateFormat.parseObject(this.last_conv_time));
                if (this.start_conv_time == null) {
                }
            } catch (ParseException paramString1) {
                try {
                    this.conversation.setStart_conv_time((Date) this.simpleDateFormat.parseObject(this.start_conv_time));
                    if (this.conv_subject != null) {
                        this.conversation.setConv_subject(new String(Base64.decode(this.conv_subject)));
                    }
                    this.conversation.setNew_post(this.is_newPost);
                    this.conv_id = null;
                    this.reply_count = null;
                    this.participant_count = null;
                    this.start_user_id = null;
                    this.last_user_id = null;
                    this.last_conv_time = null;
                    this.start_conv_time = null;
                    this.conv_subject = null;
                    this.userId = null;
                    this.username = null;
                    this.icon_url = null;
                    this.mCallback.onAddItem(this.conversation, this.result, this.conversation_count, this.unread_count);
                    continue;
                    paramString1 = paramString1;
                    paramString1.printStackTrace();
                } catch (ParseException paramString1) {
                    for (; ; ) {
                        paramString1.printStackTrace();
                    }
                }
            }
            if (this.username != null) {
                this.currentParticipant.setUserName(new String(Base64.decode(this.username)));
            }
            if (this.icon_url != null) {
                this.currentParticipant.setIcon_url(this.icon_url);
            }
            this.username = null;
            this.icon_url = null;
            this.conversation.partcipated.put(this.currentParticipant.getUserId(), this.currentParticipant);
        }
    }

    public void endPrefixMapping(String paramString)
            throws SAXException {
    }

    public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
    }

    public boolean isCan_upload() {
        return this.can_upload;
    }

    public void processingInstruction(String paramString1, String paramString2)
            throws SAXException {
    }

    public void setCallback(ICallback paramICallback) {
        this.mCallback = paramICallback;
    }

    public void setCan_upload(boolean paramBoolean) {
        this.can_upload = paramBoolean;
    }

    public void setDocumentLocator(Locator paramLocator) {
    }

    public void skippedEntity(String paramString)
            throws SAXException {
    }

    public void startDocument()
            throws SAXException {
        if (this.mCallback != null) {
            this.mCallback.onDocBegin();
        }
    }

    public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
            throws SAXException {
        if (paramString2.equals("struct")) {
            this.level += 1;
            if (this.level == 2) {
                this.conversation = new Conversation();
            }
        }
        if (paramString2.equals("name")) {
            this.currentName = null;
            this.mIsName = true;
        }
        while (!paramString2.equals("value")) {
            return;
        }
        this.currentName = null;
        this.mIsName = false;
    }

    public void startPrefixMapping(String paramString1, String paramString2)
            throws SAXException {
    }

    public static abstract interface ICallback {
        public abstract void onAddItem(Conversation paramConversation, boolean paramBoolean, int paramInt1, int paramInt2);

        public abstract void onDocBegin();

        public abstract void onDocEnd();

        public abstract void onGetResultText(String paramString);

        public abstract void onGetTopicNum(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/saxparser/TabConvSaxParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */