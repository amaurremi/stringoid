package com.quoord.tapatalkpro.saxparser;

import android.app.Activity;
import android.os.Handler;
import com.quoord.tapatalkpro.action.GetTopicAction;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.xmlrpc.XmlRpcParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class TopicSaxParser
        implements ContentHandler {
    private boolean autherNameFlag = false;
    private String currentForumName;
    private String currentForumTitle;
    private String currentName = null;
    private ArrayList<HashMap<String, Object>> currentPrefix;
    private String currentPrefixName;
    private String currentResultText;
    private String currentTimeStamp;
    private String currentTimeString = null;
    private String currentTopicPrefix;
    private String currentTopicTitle;
    private SimpleDateFormat dateFormat = new SimpleDateFormat(XmlRpcParser.DATETIME_FORMAT);
    private ForumStatus forumStatus;
    private boolean isEnterIconurls;
    private String lastPostUserName;
    private String lastReplyAuthorName;
    private String lastReplyTime;
    private String lastReplyUserDisplayName;
    private GetTopicAction mAction;
    private ICallback mCallback;
    private Activity mContext;
    private String mCurrentFieldName;
    private Topic mCurrentTopic = null;
    private String mCurrentType;
    private boolean mIsAddFinish = false;
    private boolean mIsEnterIconurls = false;
    private boolean mIsEnterPrefix = false;
    private boolean mIsEnterTopic = false;
    private boolean mIsName = false;
    private boolean mIsType = false;
    private boolean mIsValue = false;
    private int mLock = 0;
    private HashMap<String, Integer> mLocks = new HashMap();
    private int mTotalTopicNum;
    private Handler mUIHandler;
    private String postAuthorDisplayName;
    private String postAuthorName;
    private String postTime;
    private String searchid;
    private String shortContent;
    private String topicAuthorDisplayName;
    private String topicAuthorName;

    public TopicSaxParser(Activity paramActivity, GetTopicAction paramGetTopicAction) {
        this.mAction = paramGetTopicAction;
        this.mContext = paramActivity;
        this.forumStatus = this.mAction.forumStatus;
        if (this.forumStatus.getApiLevel() >= 4) {
            this.mAction.canPost = false;
        }
    }

    public TopicSaxParser(Activity paramActivity, ForumStatus paramForumStatus) {
        this.mContext = paramActivity;
        this.forumStatus = paramForumStatus;
    }

    private void parseName(String paramString) {
        if (paramString.equals("topics")) {
            this.mIsEnterTopic = true;
            return;
        }
        if (paramString.equals("prefixes")) {
            this.mIsEnterPrefix = true;
            this.mIsEnterTopic = false;
            this.currentPrefix = new ArrayList();
            return;
        }
        if (paramString.equals("icon_urls")) {
            this.mIsEnterIconurls = true;
            this.mIsEnterTopic = false;
            return;
        }
        if (paramString.equals("posts")) {
            this.mIsEnterTopic = true;
            return;
        }
        this.mCurrentFieldName = paramString;
    }

    private void parseType(String paramString) {
        this.mCurrentType = paramString;
        this.mIsValue = true;
    }

    private void parseValue(String paramString) {
        if (this.mCurrentFieldName != null) {
            if (!this.mCurrentFieldName.equals("total_topic_num")) {
                break label51;
            }
            this.mTotalTopicNum = Integer.parseInt(paramString.trim());
            if (this.mCallback != null) {
                this.mCallback.onGetTopicNum(this.mTotalTopicNum);
            }
        }
        label51:
        label339:
        label2600:
        do {
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            do {
                                                do {
                                                    for (; ; ) {
                                                        return;
                                                        if (this.mCurrentFieldName.equals("total_post_num")) {
                                                            this.mTotalTopicNum = Integer.parseInt(paramString.trim());
                                                            if (this.mCallback != null) {
                                                                this.mCallback.onGetTopicNum(this.mTotalTopicNum);
                                                            }
                                                        } else {
                                                            if (!this.mCurrentFieldName.equals("search_id")) {
                                                                break;
                                                            }
                                                            if (this.searchid == null) {
                                                            }
                                                            for (this.searchid = paramString; this.mCallback != null; this.searchid += paramString) {
                                                                this.mCallback.onGetSearchID(this.searchid);
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    if ((this.mAction == null) || (!this.mCurrentFieldName.equals("require_prefix"))) {
                                                        break;
                                                    }
                                                } while (paramString.trim().equals("1"));
                                                this.mAction.requiredPrefix = Boolean.valueOf(false);
                                                return;
                                                if ((this.mAction != null) && (this.mCurrentFieldName.equals("can_post"))) {
                                                    if (paramString.trim().equals("1")) {
                                                        this.mAction.canPost = true;
                                                        return;
                                                    }
                                                    this.mAction.canPost = false;
                                                    return;
                                                }
                                                if ((this.mAction == null) || (!this.mCurrentFieldName.equals("can_upload"))) {
                                                    break label339;
                                                }
                                                if (!paramString.trim().equals("1")) {
                                                    break;
                                                }
                                                this.mAction.canUpload = true;
                                            } while (this.forumStatus == null);
                                            this.forumStatus.setCan_upload_attachment_post(true);
                                            return;
                                            this.mAction.canUpload = false;
                                        } while (this.forumStatus == null);
                                        this.forumStatus.setCan_upload_attachment_post(false);
                                        return;
                                        if (this.mCurrentFieldName.equals("forum_title")) {
                                            if (this.currentForumTitle == null) {
                                                this.currentForumTitle = paramString;
                                                return;
                                            }
                                            this.currentForumTitle += paramString;
                                            return;
                                        }
                                        if ((this.mCurrentFieldName.equals("forum_name")) && (!this.mIsEnterTopic)) {
                                            if (this.currentForumTitle == null) {
                                                this.currentForumTitle = paramString;
                                                return;
                                            }
                                            this.currentForumTitle += paramString;
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("result_text")) {
                                            if (this.currentResultText == null) {
                                                this.currentResultText = paramString;
                                                return;
                                            }
                                            this.currentResultText += paramString;
                                            return;
                                        }
                                        if (!this.mIsEnterPrefix) {
                                            break;
                                        }
                                        if (this.mCurrentFieldName.equals("prefix_display_name")) {
                                            if (this.currentPrefixName == null) {
                                                this.currentPrefixName = paramString;
                                                return;
                                            }
                                            this.currentPrefixName += paramString;
                                            return;
                                        }
                                    } while (!this.mCurrentFieldName.equals("prefix_id"));
                                    ((HashMap) this.currentPrefix.get(this.currentPrefix.size() - 1)).put("prefix_id", new String(paramString));
                                    return;
                                } while (!this.mIsEnterTopic);
                                if (this.mCurrentFieldName.equals("post_id")) {
                                    if (this.mCurrentTopic.getPostId() == null) {
                                        this.mCurrentTopic.setPostId(paramString.trim());
                                        return;
                                    }
                                    this.mCurrentTopic.setPostId(this.mCurrentTopic.getPostId() + paramString.trim());
                                    return;
                                }
                                if (this.mCurrentFieldName.equals("icon_urls")) {
                                    this.isEnterIconurls = true;
                                }
                                if (this.mCurrentFieldName.equals("forum_id")) {
                                    if (this.mCurrentTopic.getForumId() == null) {
                                        this.mCurrentTopic.setForumId(paramString.trim());
                                        return;
                                    }
                                    this.mCurrentTopic.setForumId(this.mCurrentTopic.getForumId() + paramString.trim());
                                    return;
                                }
                                if (this.mCurrentFieldName.equals("topic_id")) {
                                    if (this.mCurrentTopic.getId() == null) {
                                        this.mCurrentTopic.setId(paramString.trim());
                                        return;
                                    }
                                    this.mCurrentTopic.setId(this.mCurrentTopic.getId() + paramString.trim());
                                    return;
                                }
                                if (this.mCurrentFieldName.equals("topic_title")) {
                                    if (this.currentTopicTitle != null) {
                                        this.currentTopicTitle += paramString;
                                        return;
                                    }
                                    this.currentTopicTitle = paramString;
                                    return;
                                }
                                if (this.mCurrentFieldName.equals("topic_author_id")) {
                                    this.mCurrentTopic.setAuthorId(paramString);
                                    return;
                                }
                                if (this.mCurrentFieldName.equals("post_author_id")) {
                                    this.mCurrentTopic.setLastPosterId(paramString);
                                    return;
                                }
                                if (this.mCurrentFieldName.equals("topic_author_name")) {
                                    this.autherNameFlag = true;
                                    if (this.topicAuthorName != null) {
                                        this.topicAuthorName += paramString;
                                        return;
                                    }
                                    this.topicAuthorName = paramString;
                                    return;
                                }
                                if (!this.mCurrentFieldName.equals("post_author_name")) {
                                    break;
                                }
                            } while (this.autherNameFlag);
                            if (this.topicAuthorName != null) {
                                this.topicAuthorName += paramString;
                                return;
                            }
                            this.topicAuthorName = paramString;
                            return;
                            if (this.mCurrentFieldName.equals("prefix")) {
                                if (this.currentTopicPrefix != null) {
                                    this.currentTopicPrefix += paramString;
                                    return;
                                }
                                this.currentTopicPrefix = paramString;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("time_string")) {
                                if (this.currentTimeString != null) {
                                    this.currentTimeString += paramString;
                                    return;
                                }
                                this.currentTimeString = paramString;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("topic_author_display_name")) {
                                if (this.topicAuthorDisplayName != null) {
                                    this.topicAuthorDisplayName += paramString;
                                    return;
                                }
                                this.topicAuthorDisplayName = paramString;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("post_author_display_name")) {
                                if (this.postAuthorDisplayName != null) {
                                    this.postAuthorDisplayName += paramString;
                                    return;
                                }
                                this.postAuthorDisplayName = paramString;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("last_reply_author_display_name")) {
                                if (this.lastReplyUserDisplayName != null) {
                                    this.lastReplyUserDisplayName += paramString;
                                    return;
                                }
                                this.lastReplyUserDisplayName = paramString;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("post_author_name")) {
                                if (this.postAuthorName != null) {
                                    this.postAuthorName += paramString;
                                    return;
                                }
                                this.postAuthorName = paramString;
                                return;
                            }
                            if (this.mCurrentFieldName.equals("reply_number")) {
                                this.mCurrentTopic.setReplyCount(Integer.parseInt(paramString));
                                return;
                            }
                            if (this.mCurrentFieldName.equals("view_number")) {
                                this.mCurrentTopic.setViewCount(Integer.parseInt(paramString));
                                return;
                            }
                            if (this.mCurrentFieldName.equals("issubscribed")) {
                                this.mCurrentTopic.setSubscribe(new Boolean(paramString.trim().equals("1")).booleanValue());
                                return;
                            }
                            if (this.mCurrentFieldName.equals("is_subscribed")) {
                                this.mCurrentTopic.setSubscribe(new Boolean(paramString.trim().equals("1")).booleanValue());
                                return;
                            }
                            if (this.mCurrentFieldName.equals("is_deleted")) {
                                this.mCurrentTopic.setDeleted(new Boolean(paramString.trim().equals("1")).booleanValue());
                                return;
                            }
                            if (this.mCurrentFieldName.equals("can_subscribe")) {
                                this.mCurrentTopic.setCanSubscribe(new Boolean(paramString.trim().equals("1")).booleanValue());
                                return;
                            }
                            if (this.mCurrentFieldName.equals("new_post")) {
                                if ((this.forumStatus != null) && (this.forumStatus.isLogin())) {
                                    this.mCurrentTopic.setNewPost(new Boolean(paramString.trim().equals("1")).booleanValue());
                                    return;
                                }
                                this.mCurrentTopic.setNewPost(true);
                                return;
                            }
                            if (!this.mCurrentFieldName.equals("icon_url")) {
                                break;
                            }
                        } while (!this.mCurrentType.equals("string"));
                        if (this.mCurrentTopic.getIconUrl() == null) {
                            this.mCurrentTopic.setIconUrl(paramString);
                            return;
                        }
                        this.mCurrentTopic.setIconUrl(this.mCurrentTopic.getIconUrl() + paramString);
                        return;
                        if (this.mCurrentFieldName.equals("is_closed")) {
                            this.mCurrentTopic.setClosed(new Boolean(paramString.trim().equals("1")).booleanValue());
                            return;
                        }
                        if (!this.mCurrentFieldName.equals("attachment")) {
                            break;
                        }
                    } while (!this.mCurrentType.equals("string"));
                    this.mCurrentTopic.setAttachFlag(Integer.parseInt(paramString));
                    return;
                    if (this.mCurrentFieldName.equals("can_move")) {
                        this.mCurrentTopic.setCanMove(new Boolean(paramString.trim().equals("1")).booleanValue());
                        return;
                    }
                    if (this.mCurrentFieldName.equals("can_rename")) {
                        this.mCurrentTopic.setCanRename(new Boolean(paramString.trim().equals("1")).booleanValue());
                        return;
                    }
                    if (this.mCurrentFieldName.equals("can_close")) {
                        this.mCurrentTopic.setCanClose(new Boolean(paramString.trim().equals("1")).booleanValue());
                        return;
                    }
                    if (this.mCurrentFieldName.equals("is_sticky")) {
                        this.mCurrentTopic.setSticked(new Boolean(paramString.trim().equals("1")).booleanValue());
                        return;
                    }
                    if (this.mCurrentFieldName.equals("can_merge")) {
                        this.mCurrentTopic.setCanMerge(new Boolean(paramString.trim().equals("1")).booleanValue());
                        return;
                    }
                    if (!this.mCurrentFieldName.equals("is_merged")) {
                        break;
                    }
                    this.mCurrentTopic.setMerged(new Boolean(paramString.trim().equals("1")).booleanValue());
                } while (!new Boolean(paramString.trim().equals("1")).booleanValue());
                this.mCurrentTopic.setRedirect(true);
                return;
                if (!this.mCurrentFieldName.equals("is_moved")) {
                    break;
                }
                this.mCurrentTopic.setMoved(new Boolean(paramString.trim().equals("1")).booleanValue());
            } while (!new Boolean(paramString.trim().equals("1")).booleanValue());
            this.mCurrentTopic.setRedirect(true);
            return;
            if (this.mCurrentFieldName.equals("real_topic_id")) {
                this.mCurrentTopic.setReal_topic_id(paramString.trim());
                return;
            }
            if (this.mCurrentFieldName.equals("can_delete")) {
                this.mCurrentTopic.setCanDelete(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("can_sticky")) {
                this.mCurrentTopic.setCanStick(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("can_stick")) {
                this.mCurrentTopic.setCanStick(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("can_approve")) {
                this.mCurrentTopic.setCanApprove(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("is_approve")) {
                this.mCurrentTopic.setApproved(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("is_approved")) {
                this.mCurrentTopic.setApproved(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("can_ban")) {
                this.mCurrentTopic.setCanBan(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("is_ban")) {
                this.mCurrentTopic.setBan(new Boolean(paramString.trim().equals("1")).booleanValue());
                return;
            }
            if (this.mCurrentFieldName.equals("last_reply_user")) {
                if (this.lastPostUserName != null) {
                    this.lastPostUserName += paramString;
                }
            } else if (this.mCurrentFieldName.equals("timestamp")) {
                if (this.currentTimeStamp == null) {
                    break label2600;
                }
                this.currentTimeStamp += paramString;
            }
            for (; ; ) {
                if (this.mCurrentFieldName.equals("short_content")) {
                    if (this.shortContent == null) {
                        this.shortContent = paramString;
                        return;
                        this.lastPostUserName = paramString;
                        break;
                        this.currentTimeStamp = paramString;
                        continue;
                    }
                    this.shortContent += paramString;
                    return;
                }
            }
            if (this.mCurrentFieldName.equals("last_reply_time")) {
                if (this.lastReplyTime != null) {
                    this.lastReplyTime += paramString;
                    return;
                }
                this.lastReplyTime = paramString;
                return;
            }
            if (this.mCurrentFieldName.equals("post_time")) {
                if (this.postTime != null) {
                    this.postTime += paramString;
                    return;
                }
                this.postTime = paramString;
                return;
            }
            if (this.mCurrentFieldName.equals("forum_name")) {
                if (this.currentForumName == null) {
                    this.currentForumName = paramString;
                    return;
                }
                this.currentForumName += paramString;
                return;
            }
        } while (!this.mCurrentFieldName.equals("last_reply_author_name"));
        if (this.lastReplyAuthorName == null) {
            this.lastReplyAuthorName = paramString;
            return;
        }
        this.lastReplyAuthorName += paramString;
    }

    public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
        paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
        if ((paramArrayOfChar.equals("\n")) || (paramArrayOfChar.trim().length() == 0)) {
        }
        do {
            return;
            if (this.mIsName) {
                if (this.currentName != null) {
                    this.currentName += paramArrayOfChar;
                    parseName(this.currentName.trim());
                    return;
                }
                this.currentName = paramArrayOfChar;
                parseName(paramArrayOfChar.trim());
                return;
            }
        } while (!this.mIsValue);
        parseValue(paramArrayOfChar.trim());
    }

    public void endDocument()
            throws SAXException {
        if (this.mCallback != null) {
            this.mCallback.onDocEnd();
        }
    }

    /* Error */
    public void endElement(String paramString1, String paramString2, String paramString3)
            throws SAXException {
        // Byte code:
        //   0: aload_0
        //   1: getfield 72	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterTopic	Z
        //   4: ifeq +621 -> 625
        //   7: aload_2
        //   8: ldc_w 512
        //   11: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   14: ifeq +611 -> 625
        //   17: aload_0
        //   18: iconst_0
        //   19: putfield 84	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsAddFinish	Z
        //   22: aload_0
        //   23: getfield 228	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentForumTitle	Ljava/lang/String;
        //   26: ifnull +44 -> 70
        //   29: aload_0
        //   30: getfield 113	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mAction	Lcom/quoord/tapatalkpro/action/GetTopicAction;
        //   33: ifnull +37 -> 70
        //   36: aload_0
        //   37: getfield 113	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mAction	Lcom/quoord/tapatalkpro/action/GetTopicAction;
        //   40: invokevirtual 516	com/quoord/tapatalkpro/action/GetTopicAction:getForum	()Lcom/quoord/tapatalkpro/bean/Forum;
        //   43: ifnull +27 -> 70
        //   46: aload_0
        //   47: getfield 113	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mAction	Lcom/quoord/tapatalkpro/action/GetTopicAction;
        //   50: invokevirtual 516	com/quoord/tapatalkpro/action/GetTopicAction:getForum	()Lcom/quoord/tapatalkpro/bean/Forum;
        //   53: new 136	java/lang/String
        //   56: dup
        //   57: aload_0
        //   58: getfield 228	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentForumTitle	Ljava/lang/String;
        //   61: invokestatic 522	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   64: invokespecial 525	java/lang/String:<init>	([B)V
        //   67: invokevirtual 530	com/quoord/tapatalkpro/bean/Forum:setName	(Ljava/lang/String;)V
        //   70: aload_0
        //   71: getfield 480	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentForumName	Ljava/lang/String;
        //   74: ifnull +24 -> 98
        //   77: aload_0
        //   78: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   81: new 136	java/lang/String
        //   84: dup
        //   85: aload_0
        //   86: getfield 480	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentForumName	Ljava/lang/String;
        //   89: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   92: invokespecial 525	java/lang/String:<init>	([B)V
        //   95: invokevirtual 536	com/quoord/tapatalkpro/bean/Topic:setForumName	(Ljava/lang/String;)V
        //   98: aload_0
        //   99: getfield 484	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyAuthorName	Ljava/lang/String;
        //   102: ifnull +24 -> 126
        //   105: aload_0
        //   106: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   109: new 136	java/lang/String
        //   112: dup
        //   113: aload_0
        //   114: getfield 484	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyAuthorName	Ljava/lang/String;
        //   117: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   120: invokespecial 525	java/lang/String:<init>	([B)V
        //   123: invokevirtual 539	com/quoord/tapatalkpro/bean/Topic:setLastPosterName	(Ljava/lang/String;)V
        //   126: aload_0
        //   127: getfield 298	com/quoord/tapatalkpro/saxparser/TopicSaxParser:topicAuthorName	Ljava/lang/String;
        //   130: ifnull +24 -> 154
        //   133: aload_0
        //   134: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   137: new 136	java/lang/String
        //   140: dup
        //   141: aload_0
        //   142: getfield 298	com/quoord/tapatalkpro/saxparser/TopicSaxParser:topicAuthorName	Ljava/lang/String;
        //   145: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   148: invokespecial 525	java/lang/String:<init>	([B)V
        //   151: invokevirtual 542	com/quoord/tapatalkpro/bean/Topic:setAuthorName	(Ljava/lang/String;)V
        //   154: aload_0
        //   155: getfield 284	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTopicTitle	Ljava/lang/String;
        //   158: ifnull +24 -> 182
        //   161: aload_0
        //   162: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   165: new 136	java/lang/String
        //   168: dup
        //   169: aload_0
        //   170: getfield 284	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTopicTitle	Ljava/lang/String;
        //   173: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   176: invokespecial 525	java/lang/String:<init>	([B)V
        //   179: invokevirtual 545	com/quoord/tapatalkpro/bean/Topic:setTitle	(Ljava/lang/String;)V
        //   182: aload_0
        //   183: getfield 462	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastPostUserName	Ljava/lang/String;
        //   186: ifnull +24 -> 210
        //   189: aload_0
        //   190: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   193: new 136	java/lang/String
        //   196: dup
        //   197: aload_0
        //   198: getfield 462	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastPostUserName	Ljava/lang/String;
        //   201: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   204: invokespecial 525	java/lang/String:<init>	([B)V
        //   207: invokevirtual 539	com/quoord/tapatalkpro/bean/Topic:setLastPosterName	(Ljava/lang/String;)V
        //   210: aload_0
        //   211: getfield 320	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postAuthorName	Ljava/lang/String;
        //   214: ifnull +24 -> 238
        //   217: aload_0
        //   218: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   221: new 136	java/lang/String
        //   224: dup
        //   225: aload_0
        //   226: getfield 320	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postAuthorName	Ljava/lang/String;
        //   229: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   232: invokespecial 525	java/lang/String:<init>	([B)V
        //   235: invokevirtual 539	com/quoord/tapatalkpro/bean/Topic:setLastPosterName	(Ljava/lang/String;)V
        //   238: aload_0
        //   239: getfield 304	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTopicPrefix	Ljava/lang/String;
        //   242: ifnull +24 -> 266
        //   245: aload_0
        //   246: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   249: new 136	java/lang/String
        //   252: dup
        //   253: aload_0
        //   254: getfield 304	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTopicPrefix	Ljava/lang/String;
        //   257: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   260: invokespecial 525	java/lang/String:<init>	([B)V
        //   263: invokevirtual 548	com/quoord/tapatalkpro/bean/Topic:setPrefix	(Ljava/lang/String;)V
        //   266: aload_0
        //   267: getfield 474	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyTime	Ljava/lang/String;
        //   270: ifnull +28 -> 298
        //   273: aload_0
        //   274: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   277: aload_0
        //   278: getfield 98	com/quoord/tapatalkpro/saxparser/TopicSaxParser:dateFormat	Ljava/text/SimpleDateFormat;
        //   281: aload_0
        //   282: getfield 474	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyTime	Ljava/lang/String;
        //   285: invokevirtual 552	java/text/SimpleDateFormat:parseObject	(Ljava/lang/String;)Ljava/lang/Object;
        //   288: checkcast 554	java/util/Date
        //   291: aload_0
        //   292: getfield 115	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mContext	Landroid/app/Activity;
        //   295: invokevirtual 558	com/quoord/tapatalkpro/bean/Topic:setLastReplyTime	(Ljava/util/Date;Landroid/content/Context;)V
        //   298: aload_0
        //   299: getfield 318	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyUserDisplayName	Ljava/lang/String;
        //   302: ifnull +24 -> 326
        //   305: aload_0
        //   306: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   309: new 136	java/lang/String
        //   312: dup
        //   313: aload_0
        //   314: getfield 318	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyUserDisplayName	Ljava/lang/String;
        //   317: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   320: invokespecial 525	java/lang/String:<init>	([B)V
        //   323: invokevirtual 561	com/quoord/tapatalkpro/bean/Topic:setLastPosterDisplayName	(Ljava/lang/String;)V
        //   326: aload_0
        //   327: getfield 314	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postAuthorDisplayName	Ljava/lang/String;
        //   330: ifnull +24 -> 354
        //   333: aload_0
        //   334: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   337: new 136	java/lang/String
        //   340: dup
        //   341: aload_0
        //   342: getfield 314	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postAuthorDisplayName	Ljava/lang/String;
        //   345: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   348: invokespecial 525	java/lang/String:<init>	([B)V
        //   351: invokevirtual 561	com/quoord/tapatalkpro/bean/Topic:setLastPosterDisplayName	(Ljava/lang/String;)V
        //   354: aload_0
        //   355: getfield 310	com/quoord/tapatalkpro/saxparser/TopicSaxParser:topicAuthorDisplayName	Ljava/lang/String;
        //   358: ifnull +24 -> 382
        //   361: aload_0
        //   362: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   365: new 136	java/lang/String
        //   368: dup
        //   369: aload_0
        //   370: getfield 310	com/quoord/tapatalkpro/saxparser/TopicSaxParser:topicAuthorDisplayName	Ljava/lang/String;
        //   373: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   376: invokespecial 525	java/lang/String:<init>	([B)V
        //   379: invokevirtual 564	com/quoord/tapatalkpro/bean/Topic:setAuthorDisplayName	(Ljava/lang/String;)V
        //   382: aload_0
        //   383: getfield 478	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postTime	Ljava/lang/String;
        //   386: ifnull +28 -> 414
        //   389: aload_0
        //   390: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   393: aload_0
        //   394: getfield 98	com/quoord/tapatalkpro/saxparser/TopicSaxParser:dateFormat	Ljava/text/SimpleDateFormat;
        //   397: aload_0
        //   398: getfield 478	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postTime	Ljava/lang/String;
        //   401: invokevirtual 552	java/text/SimpleDateFormat:parseObject	(Ljava/lang/String;)Ljava/lang/Object;
        //   404: checkcast 554	java/util/Date
        //   407: aload_0
        //   408: getfield 115	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mContext	Landroid/app/Activity;
        //   411: invokevirtual 558	com/quoord/tapatalkpro/bean/Topic:setLastReplyTime	(Ljava/util/Date;Landroid/content/Context;)V
        //   414: aload_0
        //   415: getfield 470	com/quoord/tapatalkpro/saxparser/TopicSaxParser:shortContent	Ljava/lang/String;
        //   418: ifnull +24 -> 442
        //   421: aload_0
        //   422: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   425: new 136	java/lang/String
        //   428: dup
        //   429: aload_0
        //   430: getfield 470	com/quoord/tapatalkpro/saxparser/TopicSaxParser:shortContent	Ljava/lang/String;
        //   433: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   436: invokespecial 525	java/lang/String:<init>	([B)V
        //   439: invokevirtual 567	com/quoord/tapatalkpro/bean/Topic:setShortContent	(Ljava/lang/String;)V
        //   442: aload_0
        //   443: getfield 109	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTimeString	Ljava/lang/String;
        //   446: ifnull +24 -> 470
        //   449: aload_0
        //   450: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   453: new 136	java/lang/String
        //   456: dup
        //   457: aload_0
        //   458: getfield 109	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTimeString	Ljava/lang/String;
        //   461: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   464: invokespecial 525	java/lang/String:<init>	([B)V
        //   467: invokevirtual 570	com/quoord/tapatalkpro/bean/Topic:setTimeString	(Ljava/lang/String;)V
        //   470: aload_0
        //   471: getfield 466	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTimeStamp	Ljava/lang/String;
        //   474: ifnull +24 -> 498
        //   477: aload_0
        //   478: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   481: new 165	java/lang/Integer
        //   484: dup
        //   485: aload_0
        //   486: getfield 466	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTimeStamp	Ljava/lang/String;
        //   489: invokespecial 571	java/lang/Integer:<init>	(Ljava/lang/String;)V
        //   492: invokevirtual 574	java/lang/Integer:intValue	()I
        //   495: invokevirtual 577	com/quoord/tapatalkpro/bean/Topic:setTimeStamp	(I)V
        //   498: aload_0
        //   499: aconst_null
        //   500: putfield 304	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTopicPrefix	Ljava/lang/String;
        //   503: aload_0
        //   504: aconst_null
        //   505: putfield 480	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentForumName	Ljava/lang/String;
        //   508: aload_0
        //   509: aconst_null
        //   510: putfield 484	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyAuthorName	Ljava/lang/String;
        //   513: aload_0
        //   514: aconst_null
        //   515: putfield 298	com/quoord/tapatalkpro/saxparser/TopicSaxParser:topicAuthorName	Ljava/lang/String;
        //   518: aload_0
        //   519: aconst_null
        //   520: putfield 320	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postAuthorName	Ljava/lang/String;
        //   523: aload_0
        //   524: aconst_null
        //   525: putfield 462	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastPostUserName	Ljava/lang/String;
        //   528: aload_0
        //   529: aconst_null
        //   530: putfield 284	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTopicTitle	Ljava/lang/String;
        //   533: aload_0
        //   534: aconst_null
        //   535: putfield 470	com/quoord/tapatalkpro/saxparser/TopicSaxParser:shortContent	Ljava/lang/String;
        //   538: aload_0
        //   539: aconst_null
        //   540: putfield 107	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentName	Ljava/lang/String;
        //   543: aload_0
        //   544: aconst_null
        //   545: putfield 228	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentForumTitle	Ljava/lang/String;
        //   548: aload_0
        //   549: aconst_null
        //   550: putfield 478	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postTime	Ljava/lang/String;
        //   553: aload_0
        //   554: aconst_null
        //   555: putfield 310	com/quoord/tapatalkpro/saxparser/TopicSaxParser:topicAuthorDisplayName	Ljava/lang/String;
        //   558: aload_0
        //   559: aconst_null
        //   560: putfield 314	com/quoord/tapatalkpro/saxparser/TopicSaxParser:postAuthorDisplayName	Ljava/lang/String;
        //   563: aload_0
        //   564: aconst_null
        //   565: putfield 318	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyUserDisplayName	Ljava/lang/String;
        //   568: aload_0
        //   569: aconst_null
        //   570: putfield 474	com/quoord/tapatalkpro/saxparser/TopicSaxParser:lastReplyTime	Ljava/lang/String;
        //   573: aload_0
        //   574: aconst_null
        //   575: putfield 109	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTimeString	Ljava/lang/String;
        //   578: aload_0
        //   579: aconst_null
        //   580: putfield 466	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentTimeStamp	Ljava/lang/String;
        //   583: aload_0
        //   584: aconst_null
        //   585: putfield 183	com/quoord/tapatalkpro/saxparser/TopicSaxParser:searchid	Ljava/lang/String;
        //   588: aload_0
        //   589: getfield 173	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/TopicSaxParser$ICallback;
        //   592: ifnull +16 -> 608
        //   595: aload_0
        //   596: getfield 173	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/TopicSaxParser$ICallback;
        //   599: aload_0
        //   600: getfield 76	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCurrentTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   603: invokeinterface 581 2 0
        //   608: return
        //   609: astore_1
        //   610: aload_1
        //   611: invokevirtual 584	java/text/ParseException:printStackTrace	()V
        //   614: goto -316 -> 298
        //   617: astore_1
        //   618: aload_1
        //   619: invokevirtual 584	java/text/ParseException:printStackTrace	()V
        //   622: goto -208 -> 414
        //   625: aload_0
        //   626: getfield 234	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentResultText	Ljava/lang/String;
        //   629: ifnull +48 -> 677
        //   632: aload_0
        //   633: getfield 234	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentResultText	Ljava/lang/String;
        //   636: invokevirtual 495	java/lang/String:length	()I
        //   639: ifle +38 -> 677
        //   642: aload_0
        //   643: getfield 173	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/TopicSaxParser$ICallback;
        //   646: ifnull +26 -> 672
        //   649: aload_0
        //   650: getfield 173	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/TopicSaxParser$ICallback;
        //   653: new 136	java/lang/String
        //   656: dup
        //   657: aload_0
        //   658: getfield 234	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentResultText	Ljava/lang/String;
        //   661: invokestatic 533	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   664: invokespecial 525	java/lang/String:<init>	([B)V
        //   667: invokeinterface 587 2 0
        //   672: aload_0
        //   673: aconst_null
        //   674: putfield 234	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentResultText	Ljava/lang/String;
        //   677: aload_0
        //   678: getfield 86	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterPrefix	Z
        //   681: ifeq +72 -> 753
        //   684: aload_2
        //   685: ldc_w 512
        //   688: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   691: ifeq +62 -> 753
        //   694: aload_0
        //   695: getfield 238	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefixName	Ljava/lang/String;
        //   698: ifnull +43 -> 741
        //   701: aload_0
        //   702: getfield 238	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefixName	Ljava/lang/String;
        //   705: invokestatic 522	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   708: pop
        //   709: aload_0
        //   710: getfield 147	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefix	Ljava/util/ArrayList;
        //   713: aload_0
        //   714: getfield 147	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefix	Ljava/util/ArrayList;
        //   717: invokevirtual 243	java/util/ArrayList:size	()I
        //   720: iconst_1
        //   721: isub
        //   722: invokevirtual 247	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   725: checkcast 102	java/util/HashMap
        //   728: ldc -20
        //   730: aload_0
        //   731: getfield 238	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefixName	Ljava/lang/String;
        //   734: invokestatic 522	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   737: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   740: pop
        //   741: aload_0
        //   742: aconst_null
        //   743: putfield 238	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefixName	Ljava/lang/String;
        //   746: return
        //   747: astore_1
        //   748: aload_1
        //   749: invokevirtual 588	java/lang/Exception:printStackTrace	()V
        //   752: return
        //   753: aload_0
        //   754: getfield 86	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterPrefix	Z
        //   757: ifeq +64 -> 821
        //   760: aload_2
        //   761: ldc_w 590
        //   764: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   767: ifeq +54 -> 821
        //   770: aload_0
        //   771: getfield 147	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefix	Ljava/util/ArrayList;
        //   774: invokevirtual 243	java/util/ArrayList:size	()I
        //   777: ifle +38 -> 815
        //   780: aload_0
        //   781: getfield 113	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mAction	Lcom/quoord/tapatalkpro/action/GetTopicAction;
        //   784: ifnull +31 -> 815
        //   787: aload_0
        //   788: getfield 113	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mAction	Lcom/quoord/tapatalkpro/action/GetTopicAction;
        //   791: getfield 593	com/quoord/tapatalkpro/action/GetTopicAction:mPrefixes	Ljava/util/ArrayList;
        //   794: invokevirtual 243	java/util/ArrayList:size	()I
        //   797: ifne +18 -> 815
        //   800: aload_0
        //   801: getfield 113	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mAction	Lcom/quoord/tapatalkpro/action/GetTopicAction;
        //   804: getfield 593	com/quoord/tapatalkpro/action/GetTopicAction:mPrefixes	Ljava/util/ArrayList;
        //   807: aload_0
        //   808: getfield 147	com/quoord/tapatalkpro/saxparser/TopicSaxParser:currentPrefix	Ljava/util/ArrayList;
        //   811: invokevirtual 597	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
        //   814: pop
        //   815: aload_0
        //   816: iconst_0
        //   817: putfield 86	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterPrefix	Z
        //   820: return
        //   821: aload_0
        //   822: getfield 74	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterIconurls	Z
        //   825: ifeq +24 -> 849
        //   828: aload_2
        //   829: ldc_w 590
        //   832: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   835: ifeq +14 -> 849
        //   838: aload_0
        //   839: iconst_0
        //   840: putfield 74	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterIconurls	Z
        //   843: aload_0
        //   844: iconst_1
        //   845: putfield 72	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterTopic	Z
        //   848: return
        //   849: aload_0
        //   850: getfield 72	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterTopic	Z
        //   853: ifeq -245 -> 608
        //   856: aload_2
        //   857: ldc_w 590
        //   860: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   863: ifeq -255 -> 608
        //   866: aload_0
        //   867: iconst_0
        //   868: putfield 72	com/quoord/tapatalkpro/saxparser/TopicSaxParser:mIsEnterTopic	Z
        //   871: return
        //   872: astore_1
        //   873: goto -375 -> 498
        //   876: astore_1
        //   877: goto -435 -> 442
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	880	0	this	TopicSaxParser
        //   0	880	1	paramString1	String
        //   0	880	2	paramString2	String
        //   0	880	3	paramString3	String
        // Exception table:
        //   from	to	target	type
        //   273	298	609	java/text/ParseException
        //   389	414	617	java/text/ParseException
        //   694	741	747	java/lang/Exception
        //   741	746	747	java/lang/Exception
        //   477	498	872	java/lang/Exception
        //   421	442	876	java/lang/Exception
    }

    public void endPrefixMapping(String paramString)
            throws SAXException {
    }

    public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws SAXException {
    }

    public void processingInstruction(String paramString1, String paramString2)
            throws SAXException {
    }

    public void setCallback(ICallback paramICallback) {
        this.mCallback = paramICallback;
    }

    public void setDocumentLocator(Locator paramLocator) {
    }

    public void setIsAddFinished(boolean paramBoolean) {
        this.mIsAddFinish = paramBoolean;
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
        if (paramString2.equals("name")) {
            this.currentName = null;
            this.mIsName = true;
            this.mIsType = false;
        }
        do {
            return;
            if (paramString2.equals("value")) {
                this.currentName = null;
                this.mIsName = false;
                this.mIsType = true;
                return;
            }
            if ((this.mIsEnterTopic) && (paramString2.equals("struct"))) {
                this.mCurrentTopic = new Topic();
                if (this.forumStatus.getApiLevel() >= 4) {
                    this.mCurrentTopic.setCanSubscribe(false);
                    this.mCurrentTopic.setCanUpload(false);
                    this.mCurrentTopic.setApproved(false);
                }
            }
            if ((this.mIsEnterPrefix) && (paramString2.equals("struct"))) {
                this.currentPrefix.add(new HashMap());
                return;
            }
        } while (!this.mIsType);
        parseType(paramString2);
    }

    public void startPrefixMapping(String paramString1, String paramString2)
            throws SAXException {
    }

    public static abstract interface ICallback {
        public abstract void onAddItem(Topic paramTopic);

        public abstract void onDocBegin();

        public abstract void onDocEnd();

        public abstract void onGetResultText(String paramString);

        public abstract void onGetSearchID(String paramString);

        public abstract void onGetTopicNum(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/saxparser/TopicSaxParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */