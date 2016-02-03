package com.quoord.tapatalkpro.saxparser;

import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.ThreadAdapter;
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

public class PostSaxParser
        implements ContentHandler {
    private String currentAttachmentName;
    private String currentEditReason;
    private String currentEditTime;
    private String currentEditUserID;
    private String currentEditUserName;
    private String currentForumId;
    private String currentLikeUserID;
    private String currentLikeUserName;
    String currentName;
    private String currentPostAuthorDisplayName;
    private String currentPostAuthorName;
    private String currentPostContent;
    private String currentPostId;
    private String currentPostTime;
    private String currentPrefix;
    private String currentResultText;
    private String currentThankstoUserID;
    private String currentThankstoUserName;
    private String currentTimeStamp;
    private String currentTimeString = null;
    private String currentTopicId;
    private String currentTopicTitle;
    private SimpleDateFormat dateFormat = new SimpleDateFormat(XmlRpcParser.DATETIME_FORMAT);
    private boolean isCancel = false;
    private int level = 0;
    private ThreadOuterFragment mActivity;
    private ThreadAdapter mAdapter;
    private ICallback mCallback;
    private ArrayList<HashMap> mCurrentAttachments = null;
    private String mCurrentFieldName;
    private ArrayList<HashMap> mCurrentLike = null;
    private HashMap mCurrentPost = null;
    private ArrayList<HashMap> mCurrentThanksto = null;
    private String mCurrentType;
    private boolean mIsEnterAttachment = false;
    private boolean mIsEnterLike = false;
    private boolean mIsEnterPost = false;
    private boolean mIsEnterThanks = false;
    private boolean mIsEnterTopicTitle = false;
    private boolean mIsName = false;
    private boolean mIsType = false;
    private boolean mIsValue = false;
    private int mLock = 0;
    private HashMap<String, Integer> mLocks = new HashMap();
    private int mPage;
    private int mTag;
    private int mTotalPostNum;

    public PostSaxParser(ThreadOuterFragment paramThreadOuterFragment, ThreadAdapter paramThreadAdapter, int paramInt) {
        this.mAdapter = paramThreadAdapter;
        this.mActivity = paramThreadOuterFragment;
        this.mTag = paramInt;
    }

    private void parseName(String paramString) {
        if (paramString.equals("posts")) {
            this.mIsEnterPost = true;
            this.mIsEnterAttachment = false;
            return;
        }
        if (paramString.equals("attachments")) {
            this.mIsEnterAttachment = true;
            this.mIsEnterPost = false;
            this.mIsEnterThanks = false;
            this.mIsEnterLike = false;
            this.mCurrentAttachments = new ArrayList();
            return;
        }
        if (paramString.equals("thanks_info")) {
            this.mIsEnterThanks = true;
            this.mIsEnterLike = false;
            this.mIsEnterPost = false;
            this.mIsEnterAttachment = false;
            this.mCurrentThanksto = new ArrayList();
        }
        if (paramString.equals("likes_info")) {
            this.mIsEnterLike = true;
            this.mIsEnterThanks = false;
            this.mIsEnterPost = false;
            this.mIsEnterAttachment = false;
            this.mCurrentLike = new ArrayList();
        }
        this.mCurrentFieldName = paramString;
    }

    private void parseType(String paramString) {
        this.mCurrentType = paramString;
        this.mIsValue = true;
    }

    private void parseValue(String paramString) {
        if (this.mCurrentFieldName != null) {
            if ((this.level != 2) || (!this.mIsEnterPost)) {
                break label1363;
            }
            if ((!this.mCurrentFieldName.equals("post_id")) || (!this.mCurrentType.equals("string"))) {
                break label91;
            }
            if (this.currentPostId != null) {
                break label62;
            }
            this.currentPostId = paramString.trim();
        }
        label62:
        label91:
        label1363:
        label1769:
        label2316:
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
                                                return;
                                                this.currentPostId += paramString.trim();
                                                return;
                                                if (this.mCurrentFieldName.equals("post_content")) {
                                                    if (this.currentPostContent == null) {
                                                        this.currentPostContent = paramString;
                                                        return;
                                                    }
                                                    this.currentPostContent += paramString;
                                                    return;
                                                }
                                            }
                                            while ((this.mCurrentFieldName.equals("post_author_id")) && (this.mCurrentType.equals("string")));
                                            if (this.mCurrentFieldName.equals("post_author_name")) {
                                                if (this.currentPostAuthorName == null) {
                                                    this.currentPostAuthorName = paramString.trim();
                                                    return;
                                                }
                                                this.currentPostAuthorName += paramString.trim();
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("post_author_display_name")) {
                                                if (this.currentPostAuthorDisplayName == null) {
                                                    this.currentPostAuthorDisplayName = paramString.trim();
                                                    return;
                                                }
                                                this.currentPostAuthorDisplayName += paramString.trim();
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
                                            if (this.mCurrentFieldName.equals("post_time")) {
                                                if (this.currentPostTime != null) {
                                                    this.currentPostTime += paramString;
                                                    return;
                                                }
                                                this.currentPostTime = paramString;
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("post_count")) {
                                                this.mCurrentPost.put("post_count", new Integer(paramString.trim()));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("can_delete")) {
                                                this.mCurrentPost.put("can_delete", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("is_liked")) {
                                                this.mCurrentPost.put("is_like", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("can_like")) {
                                                this.mCurrentPost.put("can_like", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("like_count")) {
                                                this.mCurrentPost.put("like_count", new Integer(paramString.trim()));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("is_approved")) {
                                                this.mCurrentPost.put("is_approved", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("is_deleted")) {
                                                this.mCurrentPost.put("is_deleted", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("can_approve")) {
                                                this.mCurrentPost.put("can_approve", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("can_ban")) {
                                                this.mCurrentPost.put("can_ban", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("is_ban")) {
                                                this.mCurrentPost.put("is_ban", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("can_move")) {
                                                this.mCurrentPost.put("can_move", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("can_edit")) {
                                                this.mCurrentPost.put("can_edit", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("is_online")) {
                                                this.mCurrentPost.put("is_online", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("allow_smilie")) {
                                                this.mCurrentPost.put("allow_smilie", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("allow_smilies")) {
                                                this.mCurrentPost.put("allow_smilies", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("icon_url")) {
                                                if (!this.mCurrentPost.containsKey("icon_url")) {
                                                    this.mCurrentPost.put("icon_url", paramString.trim());
                                                    return;
                                                }
                                                this.mCurrentPost.put("icon_url", this.mCurrentPost.get("icon_url") + paramString.trim());
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("timestamp")) {
                                                if (this.currentTimeStamp != null) {
                                                    this.currentTimeStamp += paramString;
                                                    return;
                                                }
                                                this.currentTimeStamp = paramString;
                                                return;
                                            }
                                            if (this.mCurrentFieldName.equals("can_thank")) {
                                                this.mCurrentPost.put("can_thank", new Boolean(paramString.trim().equals("1")));
                                                return;
                                            }
                                        }
                                        while ((this.mCurrentFieldName.equals("attachment_authority")) && (this.mCurrentType.equals("int")));
                                        if (this.mCurrentFieldName.equals("editor_id")) {
                                            if (this.currentEditUserID != null) {
                                                this.currentEditUserID += paramString;
                                                return;
                                            }
                                            this.currentEditUserID = paramString;
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("editor_name")) {
                                            if (this.currentEditUserName != null) {
                                                this.currentEditUserName += paramString;
                                                return;
                                            }
                                            this.currentEditUserName = paramString;
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("edit_time")) {
                                            if (this.currentEditTime != null) {
                                                this.currentEditTime += paramString;
                                                return;
                                            }
                                            this.currentEditTime = paramString;
                                            return;
                                        }
                                    } while (!this.mCurrentFieldName.equals("edit_reason"));
                                    if (this.currentEditReason != null) {
                                        this.currentEditReason += paramString;
                                        return;
                                    }
                                    this.currentEditReason = paramString;
                                    return;
                                    if (this.mCurrentFieldName.equals("result_text")) {
                                        if (this.currentResultText == null) {
                                            this.currentResultText = paramString;
                                            return;
                                        }
                                        this.currentResultText += paramString;
                                        return;
                                    }
                                    if (this.mIsEnterAttachment) {
                                        if (this.mCurrentFieldName.equals("filename")) {
                                            if (this.currentAttachmentName == null) {
                                                this.currentAttachmentName = paramString;
                                                return;
                                            }
                                            this.currentAttachmentName += paramString;
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("filesize")) {
                                            ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).put("filesize", new Integer(paramString));
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("url")) {
                                            if (((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).get("url") == null) {
                                                ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).put("url", paramString);
                                                return;
                                            }
                                            ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).put("url", ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).get("url") + paramString);
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("thumbnail_url")) {
                                            if (((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).get("thumbnail_url") != null) {
                                                break label1769;
                                            }
                                            ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).put("thumbnail_url", paramString);
                                        }
                                        while (this.mCurrentFieldName.equals("content_type")) {
                                            ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).put("content_type", paramString);
                                            return;
                                            ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).put("thumbnail_url", ((HashMap) this.mCurrentAttachments.get(this.mCurrentAttachments.size() - 1)).get("thumbnail_url") + paramString);
                                        }
                                    }
                                    if (this.mIsEnterThanks) {
                                        if (this.mCurrentFieldName.equals("userid")) {
                                            if (this.currentThankstoUserID != null) {
                                                this.currentThankstoUserID += paramString;
                                                return;
                                            }
                                            this.currentThankstoUserID = paramString;
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("username")) {
                                            if (this.currentThankstoUserName != null) {
                                                this.currentThankstoUserName += paramString;
                                                return;
                                            }
                                            this.currentThankstoUserName = paramString;
                                            return;
                                        }
                                    }
                                    if (this.mIsEnterLike) {
                                        if (this.mCurrentFieldName.equals("userid")) {
                                            if (this.currentLikeUserID != null) {
                                                this.currentLikeUserID += paramString;
                                                return;
                                            }
                                            this.currentLikeUserID = paramString;
                                            return;
                                        }
                                        if (this.mCurrentFieldName.equals("username")) {
                                            if (this.currentLikeUserName != null) {
                                                this.currentLikeUserName += paramString;
                                                return;
                                            }
                                            this.currentLikeUserName = paramString;
                                            return;
                                        }
                                    }
                                    if (!this.mCurrentFieldName.equals("total_post_num")) {
                                        break;
                                    }
                                    this.mTotalPostNum = Integer.parseInt(paramString.trim());
                                } while ((this.mCallback == null) || (this.isCancel));
                                this.mCallback.onGetPostNum(this.mTotalPostNum);
                                return;
                                if (!this.mCurrentFieldName.equals("issubscribed")) {
                                    break;
                                }
                            } while (!paramString.trim().equals("1"));
                            this.mActivity.mTopic.setSubscribe(true);
                            return;
                            if (!this.mCurrentFieldName.equals("is_subscribed")) {
                                break;
                            }
                        } while (!paramString.trim().equals("1"));
                        this.mActivity.mTopic.setSubscribe(true);
                        return;
                        if (this.mCurrentFieldName.equals("can_reply")) {
                            if (paramString.trim().equals("1")) {
                                this.mAdapter.canReply = true;
                                return;
                            }
                            this.mAdapter.canReply = false;
                            return;
                        }
                        if (!this.mCurrentFieldName.equals("can_upload")) {
                            break label2316;
                        }
                        if (!paramString.trim().equals("1")) {
                            break;
                        }
                        this.mAdapter.canUpload = true;
                    } while (this.mAdapter.forumStatus == null);
                    this.mAdapter.forumStatus.setCan_upload_attachment_post(true);
                    return;
                    this.mAdapter.canUpload = false;
                } while (this.mAdapter.forumStatus == null);
                this.mAdapter.forumStatus.setCan_upload_attachment_post(false);
                return;
                if (this.mCurrentFieldName.equals("can_delete")) {
                    this.mActivity.mTopic.setCanDelete(paramString.trim().equals("1"));
                    return;
                }
                if (this.mCurrentFieldName.equals("can_close")) {
                    this.mActivity.mTopic.setCanClose(paramString.trim().equals("1"));
                    return;
                }
                if (this.mCurrentFieldName.equals("can_sticky")) {
                    this.mActivity.mTopic.setSticked(paramString.trim().equals("1"));
                    return;
                }
                if (this.mCurrentFieldName.equals("is_closed")) {
                    this.mActivity.mTopic.setClosed(paramString.trim().equals("1"));
                    return;
                }
                if (!this.mCurrentFieldName.equals("position")) {
                    break;
                }
            } while ((this.mCallback == null) || (this.isCancel));
            this.mCallback.onPosition(Integer.parseInt(paramString.trim()));
            return;
            if (this.mCurrentFieldName.equals("prefix")) {
                this.mIsEnterTopicTitle = true;
                if (this.currentPrefix != null) {
                    this.currentPrefix += paramString;
                    return;
                }
                this.currentPrefix = paramString;
                return;
            }
            if (this.mCurrentFieldName.equals("forum_id")) {
                this.mIsEnterTopicTitle = true;
                if (this.currentForumId != null) {
                    this.currentForumId += paramString;
                    return;
                }
                this.currentForumId = paramString;
                return;
            }
            if (this.mCurrentFieldName.equals("topic_title")) {
                this.mIsEnterTopicTitle = true;
                if (this.currentTopicTitle != null) {
                    this.currentTopicTitle += paramString;
                    return;
                }
                this.currentTopicTitle = paramString;
                return;
            }
        } while (!this.mCurrentFieldName.equals("topic_id"));
        this.mIsEnterTopicTitle = true;
        if (this.currentTopicId != null) {
            this.currentTopicId += paramString;
            return;
        }
        this.currentTopicId = paramString;
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
        this.currentName = null;
        parseValue(paramArrayOfChar.trim());
    }

    public void endDocument()
            throws SAXException {
        if ((this.mCallback != null) && (!this.isCancel)) {
            this.mCallback.onDocEnd(this.mTag, this.mPage);
        }
    }

    /* Error */
    public void endElement(String paramString1, String paramString2, String paramString3)
            throws SAXException {
        // Byte code:
        //   0: aload_2
        //   1: ldc_w 438
        //   4: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   7: ifeq +13 -> 20
        //   10: aload_0
        //   11: aload_0
        //   12: getfield 74	com/quoord/tapatalkpro/saxparser/PostSaxParser:level	I
        //   15: iconst_1
        //   16: isub
        //   17: putfield 74	com/quoord/tapatalkpro/saxparser/PostSaxParser:level	I
        //   20: aload_2
        //   21: ldc_w 438
        //   24: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   27: ifeq +411 -> 438
        //   30: aload_0
        //   31: getfield 74	com/quoord/tapatalkpro/saxparser/PostSaxParser:level	I
        //   34: iconst_1
        //   35: if_icmpne +403 -> 438
        //   38: aload_0
        //   39: getfield 76	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterPost	Z
        //   42: ifeq +396 -> 438
        //   45: aload_0
        //   46: getfield 180	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostContent	Ljava/lang/String;
        //   49: invokestatic 444	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   52: astore_1
        //   53: aload_0
        //   54: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   57: ldc -78
        //   59: aload_1
        //   60: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   63: pop
        //   64: aload_0
        //   65: getfield 186	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostAuthorName	Ljava/lang/String;
        //   68: ifnull +22 -> 90
        //   71: aload_0
        //   72: getfield 186	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostAuthorName	Ljava/lang/String;
        //   75: invokestatic 447	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   78: astore_1
        //   79: aload_0
        //   80: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   83: ldc -72
        //   85: aload_1
        //   86: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   89: pop
        //   90: aload_0
        //   91: getfield 190	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostAuthorDisplayName	Ljava/lang/String;
        //   94: ifnull +22 -> 116
        //   97: aload_0
        //   98: getfield 190	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostAuthorDisplayName	Ljava/lang/String;
        //   101: invokestatic 447	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   104: astore_1
        //   105: aload_0
        //   106: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   109: ldc -68
        //   111: aload_1
        //   112: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   115: pop
        //   116: aload_0
        //   117: getfield 196	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostTime	Ljava/lang/String;
        //   120: ifnull +27 -> 147
        //   123: aload_0
        //   124: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   127: ldc -62
        //   129: aload_0
        //   130: getfield 104	com/quoord/tapatalkpro/saxparser/PostSaxParser:dateFormat	Ljava/text/SimpleDateFormat;
        //   133: aload_0
        //   134: getfield 196	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostTime	Ljava/lang/String;
        //   137: invokevirtual 451	java/text/SimpleDateFormat:parseObject	(Ljava/lang/String;)Ljava/lang/Object;
        //   140: checkcast 453	java/util/Date
        //   143: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   146: pop
        //   147: aload_0
        //   148: getfield 92	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTimeString	Ljava/lang/String;
        //   151: ifnull +27 -> 178
        //   154: aload_0
        //   155: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   158: ldc -64
        //   160: new 133	java/lang/String
        //   163: dup
        //   164: aload_0
        //   165: getfield 92	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTimeString	Ljava/lang/String;
        //   168: invokestatic 447	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   171: invokespecial 456	java/lang/String:<init>	([B)V
        //   174: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   177: pop
        //   178: aload_0
        //   179: getfield 259	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTimeStamp	Ljava/lang/String;
        //   182: ifnull +25 -> 207
        //   185: aload_0
        //   186: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   189: ldc_w 257
        //   192: new 200	java/lang/Integer
        //   195: dup
        //   196: aload_0
        //   197: getfield 259	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTimeStamp	Ljava/lang/String;
        //   200: invokespecial 201	java/lang/Integer:<init>	(Ljava/lang/String;)V
        //   203: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   206: pop
        //   207: aload_0
        //   208: getfield 277	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditTime	Ljava/lang/String;
        //   211: ifnull +18 -> 229
        //   214: aload_0
        //   215: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   218: ldc_w 275
        //   221: aload_0
        //   222: getfield 277	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditTime	Ljava/lang/String;
        //   225: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   228: pop
        //   229: aload_0
        //   230: getfield 269	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditUserID	Ljava/lang/String;
        //   233: ifnull +18 -> 251
        //   236: aload_0
        //   237: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   240: ldc_w 267
        //   243: aload_0
        //   244: getfield 269	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditUserID	Ljava/lang/String;
        //   247: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   250: pop
        //   251: aload_0
        //   252: getfield 273	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditUserName	Ljava/lang/String;
        //   255: ifnull +28 -> 283
        //   258: aload_0
        //   259: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   262: ldc_w 271
        //   265: new 133	java/lang/String
        //   268: dup
        //   269: aload_0
        //   270: getfield 273	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditUserName	Ljava/lang/String;
        //   273: invokestatic 447	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   276: invokespecial 456	java/lang/String:<init>	([B)V
        //   279: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   282: pop
        //   283: aload_0
        //   284: getfield 281	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditReason	Ljava/lang/String;
        //   287: ifnull +28 -> 315
        //   290: aload_0
        //   291: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   294: ldc_w 279
        //   297: new 133	java/lang/String
        //   300: dup
        //   301: aload_0
        //   302: getfield 281	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditReason	Ljava/lang/String;
        //   305: invokestatic 447	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   308: invokespecial 456	java/lang/String:<init>	([B)V
        //   311: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   314: pop
        //   315: aload_0
        //   316: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   319: ldc -102
        //   321: aload_0
        //   322: getfield 158	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostId	Ljava/lang/String;
        //   325: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   328: pop
        //   329: aload_0
        //   330: aconst_null
        //   331: putfield 158	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostId	Ljava/lang/String;
        //   334: aload_0
        //   335: aconst_null
        //   336: putfield 259	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTimeStamp	Ljava/lang/String;
        //   339: aload_0
        //   340: aconst_null
        //   341: putfield 92	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTimeString	Ljava/lang/String;
        //   344: aload_0
        //   345: aconst_null
        //   346: putfield 180	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostContent	Ljava/lang/String;
        //   349: aload_0
        //   350: aconst_null
        //   351: putfield 393	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPrefix	Ljava/lang/String;
        //   354: aload_0
        //   355: aconst_null
        //   356: putfield 186	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostAuthorName	Ljava/lang/String;
        //   359: aload_0
        //   360: aconst_null
        //   361: putfield 397	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentForumId	Ljava/lang/String;
        //   364: aload_0
        //   365: aconst_null
        //   366: putfield 190	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostAuthorDisplayName	Ljava/lang/String;
        //   369: aload_0
        //   370: aconst_null
        //   371: putfield 196	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPostTime	Ljava/lang/String;
        //   374: aload_0
        //   375: aconst_null
        //   376: putfield 277	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditTime	Ljava/lang/String;
        //   379: aload_0
        //   380: aconst_null
        //   381: putfield 269	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditUserID	Ljava/lang/String;
        //   384: aload_0
        //   385: aconst_null
        //   386: putfield 273	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditUserName	Ljava/lang/String;
        //   389: aload_0
        //   390: aconst_null
        //   391: putfield 281	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentEditReason	Ljava/lang/String;
        //   394: aload_0
        //   395: getfield 326	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/PostSaxParser$ICallback;
        //   398: ifnull +31 -> 429
        //   401: aload_0
        //   402: getfield 121	com/quoord/tapatalkpro/saxparser/PostSaxParser:isCancel	Z
        //   405: ifne +24 -> 429
        //   408: aload_0
        //   409: getfield 326	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/PostSaxParser$ICallback;
        //   412: aload_0
        //   413: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   416: aload_0
        //   417: getfield 127	com/quoord/tapatalkpro/saxparser/PostSaxParser:mTag	I
        //   420: aload_0
        //   421: getfield 426	com/quoord/tapatalkpro/saxparser/PostSaxParser:mPage	I
        //   424: invokeinterface 460 4 0
        //   429: return
        //   430: astore_1
        //   431: aload_1
        //   432: invokevirtual 463	java/lang/Exception:printStackTrace	()V
        //   435: goto -319 -> 116
        //   438: aload_0
        //   439: getfield 76	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterPost	Z
        //   442: ifeq +18 -> 460
        //   445: aload_2
        //   446: ldc_w 465
        //   449: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   452: ifeq +8 -> 460
        //   455: aload_0
        //   456: iconst_0
        //   457: putfield 76	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterPost	Z
        //   460: aload_0
        //   461: getfield 401	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTopicTitle	Ljava/lang/String;
        //   464: ifnull +48 -> 512
        //   467: aload_0
        //   468: getfield 80	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterTopicTitle	Z
        //   471: ifeq +41 -> 512
        //   474: aload_0
        //   475: getfield 123	com/quoord/tapatalkpro/saxparser/PostSaxParser:mAdapter	Lcom/quoord/tapatalkpro/adapter/forum/ThreadAdapter;
        //   478: ifnull +34 -> 512
        //   481: aload_0
        //   482: iconst_0
        //   483: putfield 80	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterTopicTitle	Z
        //   486: aload_0
        //   487: getfield 401	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTopicTitle	Ljava/lang/String;
        //   490: invokestatic 444	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   493: astore_1
        //   494: aload_0
        //   495: getfield 125	com/quoord/tapatalkpro/saxparser/PostSaxParser:mActivity	Lcom/quoord/tapatalkpro/activity/forum/ThreadOuterFragment;
        //   498: getfield 338	com/quoord/tapatalkpro/activity/forum/ThreadOuterFragment:mTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   501: new 133	java/lang/String
        //   504: dup
        //   505: aload_1
        //   506: invokespecial 456	java/lang/String:<init>	([B)V
        //   509: invokevirtual 468	com/quoord/tapatalkpro/bean/Topic:setTitle	(Ljava/lang/String;)V
        //   512: aload_0
        //   513: getfield 393	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPrefix	Ljava/lang/String;
        //   516: ifnull +45 -> 561
        //   519: aload_0
        //   520: getfield 80	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterTopicTitle	Z
        //   523: ifeq +38 -> 561
        //   526: aload_0
        //   527: getfield 123	com/quoord/tapatalkpro/saxparser/PostSaxParser:mAdapter	Lcom/quoord/tapatalkpro/adapter/forum/ThreadAdapter;
        //   530: ifnull +31 -> 561
        //   533: aload_0
        //   534: iconst_0
        //   535: putfield 80	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterTopicTitle	Z
        //   538: aload_0
        //   539: getfield 393	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentPrefix	Ljava/lang/String;
        //   542: invokestatic 444	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   545: astore_1
        //   546: aload_0
        //   547: getfield 123	com/quoord/tapatalkpro/saxparser/PostSaxParser:mAdapter	Lcom/quoord/tapatalkpro/adapter/forum/ThreadAdapter;
        //   550: new 133	java/lang/String
        //   553: dup
        //   554: aload_1
        //   555: invokespecial 456	java/lang/String:<init>	([B)V
        //   558: putfield 471	com/quoord/tapatalkpro/adapter/forum/ThreadAdapter:mPrefix	Ljava/lang/String;
        //   561: aload_0
        //   562: getfield 397	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentForumId	Ljava/lang/String;
        //   565: ifnull +31 -> 596
        //   568: aload_0
        //   569: getfield 80	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterTopicTitle	Z
        //   572: ifeq +24 -> 596
        //   575: aload_0
        //   576: getfield 123	com/quoord/tapatalkpro/saxparser/PostSaxParser:mAdapter	Lcom/quoord/tapatalkpro/adapter/forum/ThreadAdapter;
        //   579: ifnull +17 -> 596
        //   582: aload_0
        //   583: getfield 125	com/quoord/tapatalkpro/saxparser/PostSaxParser:mActivity	Lcom/quoord/tapatalkpro/activity/forum/ThreadOuterFragment;
        //   586: getfield 338	com/quoord/tapatalkpro/activity/forum/ThreadOuterFragment:mTopic	Lcom/quoord/tapatalkpro/bean/Topic;
        //   589: aload_0
        //   590: getfield 397	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentForumId	Ljava/lang/String;
        //   593: invokevirtual 474	com/quoord/tapatalkpro/bean/Topic:setForumId	(Ljava/lang/String;)V
        //   596: aload_0
        //   597: getfield 405	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTopicId	Ljava/lang/String;
        //   600: ifnull +46 -> 646
        //   603: aload_0
        //   604: getfield 80	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterTopicTitle	Z
        //   607: ifeq +39 -> 646
        //   610: aload_0
        //   611: getfield 123	com/quoord/tapatalkpro/saxparser/PostSaxParser:mAdapter	Lcom/quoord/tapatalkpro/adapter/forum/ThreadAdapter;
        //   614: ifnull +32 -> 646
        //   617: aload_0
        //   618: iconst_0
        //   619: putfield 80	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterTopicTitle	Z
        //   622: aload_0
        //   623: getfield 405	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTopicId	Ljava/lang/String;
        //   626: ldc_w 476
        //   629: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   632: ifne +14 -> 646
        //   635: aload_0
        //   636: getfield 123	com/quoord/tapatalkpro/saxparser/PostSaxParser:mAdapter	Lcom/quoord/tapatalkpro/adapter/forum/ThreadAdapter;
        //   639: aload_0
        //   640: getfield 405	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentTopicId	Ljava/lang/String;
        //   643: invokevirtual 479	com/quoord/tapatalkpro/adapter/forum/ThreadAdapter:setTopicId	(Ljava/lang/String;)V
        //   646: aload_0
        //   647: getfield 78	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterAttachment	Z
        //   650: ifeq +58 -> 708
        //   653: aload_2
        //   654: ldc_w 438
        //   657: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   660: ifeq +48 -> 708
        //   663: aload_0
        //   664: getfield 289	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentAttachmentName	Ljava/lang/String;
        //   667: ifnull +36 -> 703
        //   670: aload_0
        //   671: getfield 82	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentAttachments	Ljava/util/ArrayList;
        //   674: aload_0
        //   675: getfield 82	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentAttachments	Ljava/util/ArrayList;
        //   678: invokevirtual 295	java/util/ArrayList:size	()I
        //   681: iconst_1
        //   682: isub
        //   683: invokevirtual 298	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   686: checkcast 108	java/util/HashMap
        //   689: ldc_w 287
        //   692: aload_0
        //   693: getfield 289	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentAttachmentName	Ljava/lang/String;
        //   696: invokestatic 444	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   699: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   702: pop
        //   703: aload_0
        //   704: aconst_null
        //   705: putfield 289	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentAttachmentName	Ljava/lang/String;
        //   708: aload_0
        //   709: getfield 285	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentResultText	Ljava/lang/String;
        //   712: ifnull +48 -> 760
        //   715: aload_0
        //   716: getfield 285	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentResultText	Ljava/lang/String;
        //   719: invokevirtual 416	java/lang/String:length	()I
        //   722: ifle +38 -> 760
        //   725: aload_0
        //   726: getfield 326	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/PostSaxParser$ICallback;
        //   729: ifnull +26 -> 755
        //   732: aload_0
        //   733: getfield 326	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCallback	Lcom/quoord/tapatalkpro/saxparser/PostSaxParser$ICallback;
        //   736: new 133	java/lang/String
        //   739: dup
        //   740: aload_0
        //   741: getfield 285	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentResultText	Ljava/lang/String;
        //   744: invokestatic 447	com/quoord/tapatalkpro/util/Base64:decode	(Ljava/lang/String;)[B
        //   747: invokespecial 456	java/lang/String:<init>	([B)V
        //   750: invokeinterface 482 2 0
        //   755: aload_0
        //   756: aconst_null
        //   757: putfield 285	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentResultText	Ljava/lang/String;
        //   760: aload_0
        //   761: getfield 78	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterAttachment	Z
        //   764: ifeq +50 -> 814
        //   767: aload_2
        //   768: ldc_w 465
        //   771: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   774: ifeq +40 -> 814
        //   777: aload_0
        //   778: getfield 82	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentAttachments	Ljava/util/ArrayList;
        //   781: invokevirtual 295	java/util/ArrayList:size	()I
        //   784: ifle +20 -> 804
        //   787: aload_0
        //   788: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   791: ldc -117
        //   793: aload_0
        //   794: getfield 82	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentAttachments	Ljava/util/ArrayList;
        //   797: invokevirtual 486	java/util/ArrayList:toArray	()[Ljava/lang/Object;
        //   800: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   803: pop
        //   804: aload_0
        //   805: iconst_0
        //   806: putfield 78	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterAttachment	Z
        //   809: aload_0
        //   810: iconst_1
        //   811: putfield 76	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterPost	Z
        //   814: aload_0
        //   815: getfield 113	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterThanks	Z
        //   818: ifeq +86 -> 904
        //   821: aload_2
        //   822: ldc_w 438
        //   825: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   828: ifeq +76 -> 904
        //   831: aload_0
        //   832: getfield 117	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentThanksto	Ljava/util/ArrayList;
        //   835: aload_0
        //   836: getfield 117	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentThanksto	Ljava/util/ArrayList;
        //   839: invokevirtual 295	java/util/ArrayList:size	()I
        //   842: iconst_1
        //   843: isub
        //   844: invokevirtual 298	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   847: checkcast 108	java/util/HashMap
        //   850: ldc_w 306
        //   853: aload_0
        //   854: getfield 308	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentThankstoUserID	Ljava/lang/String;
        //   857: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   860: pop
        //   861: aload_0
        //   862: getfield 117	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentThanksto	Ljava/util/ArrayList;
        //   865: aload_0
        //   866: getfield 117	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentThanksto	Ljava/util/ArrayList;
        //   869: invokevirtual 295	java/util/ArrayList:size	()I
        //   872: iconst_1
        //   873: isub
        //   874: invokevirtual 298	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   877: checkcast 108	java/util/HashMap
        //   880: ldc_w 310
        //   883: aload_0
        //   884: getfield 312	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentThankstoUserName	Ljava/lang/String;
        //   887: invokestatic 444	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   890: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   893: pop
        //   894: aload_0
        //   895: aconst_null
        //   896: putfield 308	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentThankstoUserID	Ljava/lang/String;
        //   899: aload_0
        //   900: aconst_null
        //   901: putfield 312	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentThankstoUserName	Ljava/lang/String;
        //   904: aload_0
        //   905: getfield 113	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterThanks	Z
        //   908: ifeq +50 -> 958
        //   911: aload_2
        //   912: ldc_w 465
        //   915: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   918: ifeq +40 -> 958
        //   921: aload_0
        //   922: getfield 117	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentThanksto	Ljava/util/ArrayList;
        //   925: invokevirtual 295	java/util/ArrayList:size	()I
        //   928: ifle +20 -> 948
        //   931: aload_0
        //   932: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   935: ldc -112
        //   937: aload_0
        //   938: getfield 117	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentThanksto	Ljava/util/ArrayList;
        //   941: invokevirtual 486	java/util/ArrayList:toArray	()[Ljava/lang/Object;
        //   944: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   947: pop
        //   948: aload_0
        //   949: iconst_0
        //   950: putfield 113	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterThanks	Z
        //   953: aload_0
        //   954: iconst_1
        //   955: putfield 76	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterPost	Z
        //   958: aload_0
        //   959: getfield 115	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterLike	Z
        //   962: ifeq +86 -> 1048
        //   965: aload_2
        //   966: ldc_w 438
        //   969: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   972: ifeq +76 -> 1048
        //   975: aload_0
        //   976: getfield 119	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentLike	Ljava/util/ArrayList;
        //   979: aload_0
        //   980: getfield 119	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentLike	Ljava/util/ArrayList;
        //   983: invokevirtual 295	java/util/ArrayList:size	()I
        //   986: iconst_1
        //   987: isub
        //   988: invokevirtual 298	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   991: checkcast 108	java/util/HashMap
        //   994: ldc_w 306
        //   997: aload_0
        //   998: getfield 314	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentLikeUserID	Ljava/lang/String;
        //   1001: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   1004: pop
        //   1005: aload_0
        //   1006: getfield 119	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentLike	Ljava/util/ArrayList;
        //   1009: aload_0
        //   1010: getfield 119	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentLike	Ljava/util/ArrayList;
        //   1013: invokevirtual 295	java/util/ArrayList:size	()I
        //   1016: iconst_1
        //   1017: isub
        //   1018: invokevirtual 298	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   1021: checkcast 108	java/util/HashMap
        //   1024: ldc_w 310
        //   1027: aload_0
        //   1028: getfield 316	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentLikeUserName	Ljava/lang/String;
        //   1031: invokestatic 444	com/quoord/tapatalkpro/util/Base64:decodeFast	(Ljava/lang/String;)[B
        //   1034: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   1037: pop
        //   1038: aload_0
        //   1039: aconst_null
        //   1040: putfield 314	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentLikeUserID	Ljava/lang/String;
        //   1043: aload_0
        //   1044: aconst_null
        //   1045: putfield 316	com/quoord/tapatalkpro/saxparser/PostSaxParser:currentLikeUserName	Ljava/lang/String;
        //   1048: aload_0
        //   1049: getfield 115	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterLike	Z
        //   1052: ifeq -623 -> 429
        //   1055: aload_2
        //   1056: ldc_w 465
        //   1059: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   1062: ifeq -633 -> 429
        //   1065: aload_0
        //   1066: getfield 119	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentLike	Ljava/util/ArrayList;
        //   1069: invokevirtual 295	java/util/ArrayList:size	()I
        //   1072: ifle +21 -> 1093
        //   1075: aload_0
        //   1076: getfield 84	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentPost	Ljava/util/HashMap;
        //   1079: ldc_w 488
        //   1082: aload_0
        //   1083: getfield 119	com/quoord/tapatalkpro/saxparser/PostSaxParser:mCurrentLike	Ljava/util/ArrayList;
        //   1086: invokevirtual 486	java/util/ArrayList:toArray	()[Ljava/lang/Object;
        //   1089: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   1092: pop
        //   1093: aload_0
        //   1094: iconst_0
        //   1095: putfield 115	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterLike	Z
        //   1098: aload_0
        //   1099: iconst_1
        //   1100: putfield 76	com/quoord/tapatalkpro/saxparser/PostSaxParser:mIsEnterPost	Z
        //   1103: return
        //   1104: astore_1
        //   1105: aload_1
        //   1106: invokevirtual 463	java/lang/Exception:printStackTrace	()V
        //   1109: goto -401 -> 708
        //   1112: astore_1
        //   1113: goto -784 -> 329
        //   1116: astore_1
        //   1117: goto -802 -> 315
        //   1120: astore_1
        //   1121: goto -838 -> 283
        //   1124: astore_1
        //   1125: goto -874 -> 251
        //   1128: astore_1
        //   1129: goto -900 -> 229
        //   1132: astore_1
        //   1133: goto -926 -> 207
        //   1136: astore_1
        //   1137: goto -990 -> 147
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1140	0	this	PostSaxParser
        //   0	1140	1	paramString1	String
        //   0	1140	2	paramString2	String
        //   0	1140	3	paramString3	String
        // Exception table:
        //   from	to	target	type
        //   45	90	430	java/lang/Exception
        //   90	116	430	java/lang/Exception
        //   663	703	1104	java/lang/Exception
        //   703	708	1104	java/lang/Exception
        //   315	329	1112	java/lang/Exception
        //   283	315	1116	java/lang/Exception
        //   251	283	1120	java/lang/Exception
        //   229	251	1124	java/lang/Exception
        //   207	229	1128	java/lang/Exception
        //   147	178	1132	java/lang/Exception
        //   178	207	1132	java/lang/Exception
        //   123	147	1136	java/text/ParseException
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

    public void setCancel(boolean paramBoolean) {
        this.isCancel = paramBoolean;
    }

    public void setDocumentLocator(Locator paramLocator) {
    }

    public void skippedEntity(String paramString)
            throws SAXException {
    }

    public void startDocument()
            throws SAXException {
        if ((this.mCallback != null) && (!this.isCancel)) {
            this.mCallback.onDocBegin(this.mTag, this.mPage);
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
            if (paramString2.equals("struct")) {
                this.level += 1;
                if ((this.level == 2) && (this.mIsEnterPost)) {
                    this.mCurrentPost = new HashMap();
                    return;
                }
            }
            if ((this.mIsEnterAttachment) && (paramString2.equals("struct"))) {
                this.mCurrentAttachments.add(new HashMap());
                return;
            }
            if ((this.mIsEnterThanks) && (paramString2.equals("struct"))) {
                this.mCurrentThanksto.add(new HashMap());
                return;
            }
            if ((this.mIsEnterLike) && (paramString2.equals("struct"))) {
                this.mCurrentLike.add(new HashMap());
                return;
            }
        } while (!this.mIsType);
        parseType(paramString2);
    }

    public void startPrefixMapping(String paramString1, String paramString2)
            throws SAXException {
    }

    /* Error */
    public void tryLock() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 106	com/quoord/tapatalkpro/saxparser/PostSaxParser:mLock	I
        //   6: ifgt +29 -> 35
        //   9: aload_0
        //   10: iconst_1
        //   11: putfield 106	com/quoord/tapatalkpro/saxparser/PostSaxParser:mLock	I
        //   14: aload_0
        //   15: getfield 111	com/quoord/tapatalkpro/saxparser/PostSaxParser:mLocks	Ljava/util/HashMap;
        //   18: invokestatic 523	java/lang/Thread:currentThread	()Ljava/lang/Thread;
        //   21: invokevirtual 524	java/lang/Thread:toString	()Ljava/lang/String;
        //   24: iconst_1
        //   25: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   28: invokevirtual 205	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   31: pop
        //   32: aload_0
        //   33: monitorexit
        //   34: return
        //   35: ldc2_w 528
        //   38: invokestatic 533	java/lang/Thread:sleep	(J)V
        //   41: goto -39 -> 2
        //   44: astore_1
        //   45: aload_1
        //   46: invokevirtual 534	java/lang/InterruptedException:printStackTrace	()V
        //   49: goto -47 -> 2
        //   52: astore_1
        //   53: aload_0
        //   54: monitorexit
        //   55: aload_1
        //   56: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	57	0	this	PostSaxParser
        //   44	2	1	localInterruptedException	InterruptedException
        //   52	4	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   35	41	44	java/lang/InterruptedException
        //   2	32	52	finally
        //   35	41	52	finally
        //   45	49	52	finally
    }

    public void unLock() {
        if (this.mLocks.containsKey(Thread.currentThread().toString())) {
            this.mLock = 0;
            this.mLocks.remove(Thread.currentThread().toString());
        }
    }

    public static abstract interface ICallback {
        public abstract void onAddItem(HashMap paramHashMap, int paramInt1, int paramInt2);

        public abstract void onDocBegin(int paramInt1, int paramInt2);

        public abstract void onDocEnd(int paramInt1, int paramInt2);

        public abstract void onGetPostNum(int paramInt);

        public abstract void onGetResultText(String paramString);

        public abstract void onPosition(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/saxparser/PostSaxParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */