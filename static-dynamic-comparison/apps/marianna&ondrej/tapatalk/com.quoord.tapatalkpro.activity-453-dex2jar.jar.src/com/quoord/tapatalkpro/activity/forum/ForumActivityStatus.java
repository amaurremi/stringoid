package com.quoord.tapatalkpro.activity.forum;

import android.app.Activity;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;

public abstract interface ForumActivityStatus {
    public static final int AUTHORIZEFAIL = 3;
    public static final int AUTHORIZEUSER = 6;
    public static final int CAMERA = 1001;
    public static final int CREATE_CONVERSATION = 26;
    public static final int CREATE_NEWTOPIC = 60;
    public static final int DIALOG_ATTACH = 9;
    public static final int DIALOG_ATTACH_M = 21;
    public static final int DIALOG_DISCARD = 15;
    public static final int DIALOG_DRAFT = 44;
    public static final int DIALOG_INSERT_IMG = 39;
    public static final int DIALOG_INSERT_URL = 45;
    public static final int DIALOG_LATEST_LANDING_DIALOG = 40;
    public static final int DIALOG_LEAVE_CONFIRM = 46;
    public static final int DIALOG_LICENSE_SERVER = 25;
    public static final int DIALOG_LOGIN_FORUM = 22;
    public static final int DIALOG_MARK_READ_CONFIRM = 23;
    public static final int DIALOG_MESSAGE = 2;
    public static final int DIALOG_MESSAGE_1 = 18;
    public static final int DIALOG_MOVE_CONFIRM = 37;
    public static final int DIALOG_OUTBOX = 8;
    public static final int DIALOG_PROGRESS = 0;
    public static final int DIALOG_PROGRESS_INITIAL = 99;
    public static final int DIALOG_RATE_US = 41;
    public static final int DIALOG_REMIND_UPDATE = 101;
    public static final int DIALOG_REMOVE_ATTACH = 11;
    public static final int DIALOG_REPORT_PM = 20;
    public static final int DIALOG_REPORT_POST = 19;
    public static final int DIALOG_SETUP_USERNAME = 100;
    public static final int DIALOG_SUBSCRIBE = 4;
    public static final int DIALOG_SUB_FORUM = 12;
    public static final int DIALOG_TOPICLIST = 5;
    public static final int DIALOG_UPLOAD_PROGRESS = 42;
    public static final int DIALOG_URL = 14;
    public static final int DIALOG_XF_INLINE = 47;
    public static final int DISPLAYERROR = 13;
    public static final int GALLERY = 1000;
    public static final int GUESTLOGIN = 29;
    public static final int ICS_THREADDETAIL_BACK = 51;
    public static final String INBOXTYPE = "INBOX";
    public static final int INVITE_PARTICIPANT = 31;
    public static final int LEAVE_CONVERSATION = 29;
    public static final int LOGIN_FORUM_REQUEST = 2001;
    public static final int LOGOUTUSER = 9;
    public static final int MENU_ADVANCESEARCH = 52;
    public static final int MENU_BAN = 54;
    public static final int MENU_BROWSER = 44;
    public static final int MENU_CLOSE_CONVERSATION = 35;
    public static final int MENU_CONVERSATION = 53;
    public static final int MENU_COPY_URL = 22;
    public static final int MENU_EDIT = 40;
    public static final int MENU_EDIT_TITLE = 53328;
    public static final int MENU_FORWARDPM = 23;
    public static final int MENU_MARKREAD = 17;
    public static final int MENU_MARKUNREAD = 27;
    public static final int MENU_MORE = 20;
    public static final int MENU_NEWPM = 10;
    public static final int MENU_NEWTOPIC = 1;
    public static final int MENU_OPEN_CONVERSATION = 36;
    public static final int MENU_QUOTE = 39;
    public static final int MENU_READTOPIC = 14;
    public static final int MENU_REFRESH = 0;
    public static final int MENU_REFRESHLATEST = 6;
    public static final int MENU_REFRESHPMBOX = 12;
    public static final int MENU_REFRESHSUBSCRIBE = 7;
    public static final int MENU_REGISTER = 13;
    public static final int MENU_REPLY = 38;
    public static final int MENU_REPLYPM = 11;
    public static final int MENU_REPLYPMALL = 18;
    public static final int MENU_REPLY_PM = 47;
    public static final int MENU_REPORTPM = 19;
    public static final int MENU_SEARCH = 2;
    public static final int MENU_SEARCH_FORUM = 25;
    public static final int MENU_SHARE = 46;
    public static final int MENU_SHOWTHREAD = 8;
    public static final int MENU_SUBSCRIBE = 15;
    public static final int MENU_THREAD_MODERATE = 45;
    public static final int MENU_UNBAN = 55;
    public static final int MENU_UNSUBSCRIBE = 43;
    public static final int MERGE_TOPIC = 601;
    public static final int MODERATION_MERGE_TOPIC_CONFIRM = 82;
    public static final int MODERATION_MOVE_POST_CONFIRM = 81;
    public static final int MODERATION_MOVE_POST_REQUESTCODE = 901;
    public static final int MODERATION_MOVE_POST_RESULTCODE = 902;
    public static final int MODERATION_MOVE_TOPIC_CONFIRM = 80;
    public static final int MOVE_TOPIC_FLAG = 21;
    public static final int MYINFO_INPUT_DIALOG = 3;
    public static final int NEW_CONVERSATION = 30;
    public static final String OUTBOXTYPE = "SENT";
    public static final int PROFILES_BAN_USER = 500;
    public static final int QUOTE_CONVERSATION = 28;
    public static final int REFRESH_CONVERSATION = 33;
    public static final int REFRESH_CONVERSATIONDATA = 34;
    public static final int REPLY_CONVERSATION = 27;
    public static final int REQUESTCODE = 32;
    public static final int SUBSCRIBETOPIC = 16;
    public static final int TAPATALKID_UPDATE = 37;
    public static final int THREAD_CLOSE = 42;
    public static final int UPDATEATTACH = 30;
    public static final int UPDATECLOSEPROGRESS = 27;
    public static final int UPDATECUSTOMTITLE = 20;
    public static final int UPDATEDIRECTORY = 39;
    public static final int UPDATEFAVORIATE = 40;
    public static final int UPDATEFLIPPER = 38;
    public static final int UPDATEFORUM = 0;
    public static final int UPDATEICON = 14;
    public static final int UPDATEMARKREAD = 45;
    public static final int UPDATEMORE = 21;
    public static final int UPDATENEWPM = 24;
    public static final int UPDATENEWTOPIC = 12;
    public static final int UPDATEOPENURL = 42;
    public static final int UPDATEPMSERVICE = 35;
    public static final int UPDATEPOST = 18;
    public static final int UPDATEPROGRESSDIALOG = 31;
    public static final int UPDATEPROGRESSDLG_CONNECTING = 0;
    public static final int UPDATEPROGRESSDLG_PROGRESSING = 3;
    public static final int UPDATEPROGRESSDLG_RECEIVING = 2;
    public static final int UPDATEPROGRESSDLG_SENDING = 1;
    public static final int UPDATEPROGRESSDLG_UPLOAD = 4;
    public static final int UPDATEREPLY = 19;
    public static final int UPDATESEARCHPOST = 34;
    public static final int UPDATESECTIONTITLE = 44;
    public static final int UPDATESHOWPM = 25;
    public static final int UPDATESPLASHDISMISS = 43;
    public static final int UPDATESUBFORUM = 7;
    public static final int UPDATESUBSCRIBE = 15;
    public static final int UPDATETHREAD = 2;
    public static final int UPDATETOPIC = 1;
    public static final int UPDATEUNREADTOPIC = 32;
    public static final int UPDATEUPLOADPROGRESS = 37;
    public static final int UPDATEUSER = 8;
    public static final int UPDATEUSERPOST = 11;
    public static final int UPDATEUSERTOPIC = 10;
    public static final int UPDATEWHOSONLINE = 28;
    public static final int USER_PROFILE = 41;

    public abstract void closeProgress();

    public abstract Activity getDefaultActivity();

    public abstract ForumActivityStatus getForumActivityStatus();

    public abstract ForumStatus getForumStatus();

    public abstract ForumStatus getForumStatus(TapatalkForum paramTapatalkForum);

    public abstract void showDialog(int paramInt);

    public abstract void showProgress();

    public abstract void showProgress(String paramString);

    public abstract void updateDialog(int paramInt);

    public abstract void updateUI(int paramInt, Object paramObject);

    public abstract void updateUI(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/ForumActivityStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */