package com.quoord.tapatalkpro.bean;

import android.content.Context;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

public class TopicParser {
    public static Topic createTopicBean(HashMap paramHashMap, String paramString, Context paramContext, ForumStatus paramForumStatus) {
        if (paramHashMap == null) {
            paramString = null;
        }
        Topic localTopic;
        label158:
        label197:
        label246:
        label284:
        label545:
        label673:
        label1407:
        label1416:
        label1425:
        label1494:
        label1503:
        label1512:
        label1521:
        label1530:
        label1539:
        label1579:
        label1588:
        label1597:
        label1606:
        label1615:
        label1624:
        label1664:
        label1673:
        label1713:
        do {
            for (; ; ) {
                return paramString;
                localTopic = new Topic();
                localTopic.setForumId((String) paramHashMap.get("forum_id"));
                if ((paramHashMap.containsKey("topic_id")) && (!paramHashMap.get("topic_id").equals(""))) {
                    localTopic.setId((String) paramHashMap.get("topic_id"));
                }
                if ((paramHashMap.containsKey("post_id")) && (!paramHashMap.get("post_id").equals(""))) {
                    localTopic.setPostId((String) paramHashMap.get("post_id"));
                }
                if ((paramHashMap.get("topic_author_id") instanceof String)) {
                    localTopic.setAuthorId((String) paramHashMap.get("topic_author_id"));
                }
                if ((Date) paramHashMap.get("last_reply_time") != null) {
                    localTopic.setLastReplyTime((Date) paramHashMap.get("last_reply_time"), paramContext);
                    if (paramHashMap.get("new_post") == null) {
                        break label1407;
                    }
                    if (((Boolean) paramHashMap.get("new_post")).booleanValue()) {
                        localTopic.setNewPost(true);
                        paramForumStatus.removeTopicMark(localTopic.getId());
                    }
                    if (paramHashMap.get("post_author_id") != null) {
                        localTopic.setLastPosterId((String) paramHashMap.get("post_author_id"));
                    }
                    if (!paramHashMap.containsKey("issubscribed")) {
                        break label1416;
                    }
                    localTopic.setSubscribe(((Boolean) paramHashMap.get("issubscribed")).booleanValue());
                    if (paramHashMap.containsKey("timestamp")) {
                        if (!(paramHashMap.get("timestamp") instanceof Integer)) {
                            break label1425;
                        }
                        localTopic.setTimeStamp(((Integer) paramHashMap.get("timestamp")).intValue());
                    }
                    paramContext = (Integer) paramHashMap.get("reply_number");
                    if (paramContext != null) {
                        localTopic.setReplyCount(paramContext.intValue());
                    }
                    if (paramHashMap.containsKey("view_number")) {
                        paramContext = (Integer) paramHashMap.get("view_number");
                        if (paramContext != null) {
                            localTopic.setViewCount(paramContext.intValue());
                        }
                    }
                }
                try {
                    localTopic.setShortContent(new String((byte[]) paramHashMap.get("short_content"), "UTF-8"));
                    localTopic.setTitle(new String((byte[]) paramHashMap.get("topic_title"), "UTF-8"));
                    if (paramHashMap.get("topic_author_name") != null) {
                        localTopic.setAuthorName(new String((byte[]) paramHashMap.get("topic_author_name"), "UTF-8"));
                    }
                    if (paramHashMap.get("post_author_name") != null) {
                        localTopic.setLastPosterName(new String((byte[]) paramHashMap.get("post_author_name"), "UTF-8"));
                    }
                    if (paramHashMap.get("prefix") != null) {
                        localTopic.setPrefix(new String((byte[]) paramHashMap.get("prefix"), "UTF-8"));
                    }
                    if (paramHashMap.get("time_string") != null) {
                        localTopic.setTimeString(new String((byte[]) paramHashMap.get("time_string"), "UTF-8"));
                    }
                    if (paramHashMap.get("forum_name") != null) {
                        localTopic.setForumName(new String((byte[]) paramHashMap.get("forum_name"), "UTF-8"));
                        if (paramHashMap.get("topic_author_display_name") != null) {
                            localTopic.setAuthorDisplayName(new String((byte[]) paramHashMap.get("topic_author_display_name"), "UTF-8"));
                        }
                        if (paramHashMap.get("post_author_display_name") != null) {
                            localTopic.setLastPosterDisplayName(new String((byte[]) paramHashMap.get("post_author_display_name"), "UTF-8"));
                        }
                        if (paramHashMap.get("last_reply_author_display_name") != null) {
                            localTopic.setLastPosterDisplayName(new String((byte[]) paramHashMap.get("last_reply_author_display_name"), "UTF-8"));
                        }
                        if (paramHashMap.get("last_reply_author_name") != null) {
                            localTopic.setLastPosterName(new String((byte[]) paramHashMap.get("last_reply_author_name"), "UTF-8"));
                        }
                    }
                } catch (UnsupportedEncodingException paramString) {
                    try {
                        if (paramHashMap.get("can_subscribe") != null) {
                            localTopic.setCanSubscribe(((Boolean) paramHashMap.get("can_subscribe")).booleanValue());
                        }
                        for (; ; ) {
                            if (paramHashMap.containsKey("icon_url")) {
                                localTopic.setIconUrl((String) paramHashMap.get("icon_url"));
                            }
                            if (paramHashMap.containsKey("attachment")) {
                                localTopic.setAttachFlag(Integer.parseInt((String) paramHashMap.get("attachment")));
                            }
                            if (!paramHashMap.containsKey("is_sticky")) {
                                break label1494;
                            }
                            localTopic.setSticked(((Boolean) paramHashMap.get("is_sticky")).booleanValue());
                            if (!paramHashMap.containsKey("is_deleted")) {
                                break label1503;
                            }
                            localTopic.setDeleted(((Boolean) paramHashMap.get("is_deleted")).booleanValue());
                            if (!paramHashMap.containsKey("can_delete")) {
                                break label1512;
                            }
                            localTopic.setCanDelete(((Boolean) paramHashMap.get("can_delete")).booleanValue());
                            if (!paramHashMap.containsKey("can_approve")) {
                                break label1521;
                            }
                            localTopic.setCanApprove(((Boolean) paramHashMap.get("can_approve")).booleanValue());
                            if (!paramHashMap.containsKey("can_rename")) {
                                break label1530;
                            }
                            localTopic.setCanRename(((Boolean) paramHashMap.get("can_rename")).booleanValue());
                            if (!paramHashMap.containsKey("is_approve")) {
                                break label1539;
                            }
                            localTopic.setApproved(((Boolean) paramHashMap.get("is_approve")).booleanValue());
                            if (!paramHashMap.containsKey("is_closed")) {
                                break label1579;
                            }
                            localTopic.setClosed(((Boolean) paramHashMap.get("is_closed")).booleanValue());
                            if (!paramHashMap.containsKey("can_close")) {
                                break label1588;
                            }
                            localTopic.setCanClose(((Boolean) paramHashMap.get("can_close")).booleanValue());
                            if (!paramHashMap.containsKey("can_ban")) {
                                break label1597;
                            }
                            localTopic.setCanBan(((Boolean) paramHashMap.get("can_ban")).booleanValue());
                            if (!paramHashMap.containsKey("is_ban")) {
                                break label1606;
                            }
                            localTopic.setBan(((Boolean) paramHashMap.get("is_ban")).booleanValue());
                            if (!paramHashMap.containsKey("can_move")) {
                                break label1615;
                            }
                            localTopic.setCanMove(((Boolean) paramHashMap.get("can_move")).booleanValue());
                            if (!paramHashMap.containsKey("can_stick")) {
                                break label1624;
                            }
                            localTopic.setCanStick(((Boolean) paramHashMap.get("can_stick")).booleanValue());
                            if (!paramHashMap.containsKey("can_merge")) {
                                break label1664;
                            }
                            localTopic.setCanMerge(((Boolean) paramHashMap.get("can_merge")).booleanValue());
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
                            if (!paramHashMap.containsKey("issubscribed")) {
                                break label1673;
                            }
                            localTopic.setSubscribe(((Boolean) paramHashMap.get("issubscribed")).booleanValue());
                            if (paramHashMap.containsKey("real_topic_id")) {
                                localTopic.setReal_topic_id((String) paramHashMap.get("real_topic_id"));
                            }
                            if (paramHashMap.containsKey("topic_image")) {
                                localTopic.setTopicImgUrl((String) paramHashMap.get("topic_image"));
                            }
                            if (paramHashMap.containsKey("fid")) {
                                localTopic.setTapatalkForumId((String) paramHashMap.get("fid"));
                            }
                            if (paramHashMap.containsKey("fname")) {
                                localTopic.setTapatalkForumName((String) paramHashMap.get("fname"));
                            }
                            paramString = localTopic;
                            if (!paramHashMap.containsKey("can_post")) {
                                break;
                            }
                            try {
                                if (!(paramHashMap.get("can_post") instanceof Boolean)) {
                                    break label1713;
                                }
                                localTopic.setCanPost(((Boolean) paramHashMap.get("can_post")).booleanValue());
                                return localTopic;
                            } catch (Exception paramHashMap) {
                                return localTopic;
                            }
                            if ((!paramHashMap.containsKey("post_time")) || (paramHashMap.get("post_time").equals(""))) {
                                break label158;
                            }
                            localTopic.setLastReplyTime((Date) paramHashMap.get("post_time"), paramContext);
                            break label158;
                            localTopic.setNewPost(false);
                            break label197;
                            localTopic.setSubscribe(false);
                            break label246;
                            localTopic.setTimeStamp(new Integer((String) paramHashMap.get("timestamp")).intValue());
                            break label284;
                            if (paramString == null) {
                                break label545;
                            }
                            localTopic.setForumName(paramString);
                            break label545;
                            paramString = paramString;
                            paramString.printStackTrace();
                            break label673;
                            if (paramForumStatus.getApiLevel() >= 4) {
                                localTopic.setCanSubscribe(false);
                            }
                        }
                    } catch (Exception paramString) {
                        for (; ; ) {
                            continue;
                            localTopic.setSticked(false);
                            continue;
                            localTopic.setDeleted(false);
                            continue;
                            localTopic.setCanDelete(false);
                            continue;
                            localTopic.setCanApprove(false);
                            continue;
                            localTopic.setCanRename(false);
                            continue;
                            if (paramHashMap.containsKey("is_approved")) {
                                localTopic.setApproved(((Boolean) paramHashMap.get("is_approved")).booleanValue());
                            } else {
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
                                    if (paramHashMap.containsKey("is_subscribed")) {
                                        localTopic.setSubscribe(((Boolean) paramHashMap.get("is_subscribed")).booleanValue());
                                    } else {
                                        localTopic.setSubscribe(false);
                                    }
                                }
                            }
                        }
                        if ((paramHashMap.get("can_post") instanceof Integer)) {
                            if (((Integer) paramHashMap.get("can_post")).intValue() == 1) {
                                localTopic.setCanPost(true);
                                return localTopic;
                            }
                            localTopic.setCanPost(false);
                            return localTopic;
                        }
                        paramString = localTopic;
                    }
                }
            }
        } while (!(paramHashMap.get("can_post") instanceof String));
        if (paramHashMap.get("can_post").equals("1")) {
            localTopic.setCanPost(true);
            return localTopic;
        }
        localTopic.setCanPost(false);
        return localTopic;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/TopicParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */