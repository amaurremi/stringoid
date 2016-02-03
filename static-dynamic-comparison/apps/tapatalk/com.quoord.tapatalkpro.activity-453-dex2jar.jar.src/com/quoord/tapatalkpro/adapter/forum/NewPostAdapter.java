package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.bean.UploadImageInfo;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.GeoPictureUploader;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class NewPostAdapter
        extends ForumRootAdapter
        implements TryTwiceCallBackInterface {
    public ArrayList<String> attachIds = new ArrayList();
    private TapatalkForum forum;
    public String groupId = null;
    public ArrayList<String> ids = new ArrayList();
    public ArrayList<Object> imageIds = new ArrayList();
    private boolean isShare = false;
    String mAttachmentId;
    private Activity mContext = null;
    public String mTopicId = null;
    public String mTopicTitle = null;
    private String subForumId;
    public ArrayList<String> videoIds = new ArrayList();

    public NewPostAdapter(Activity paramActivity, String paramString) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
    }

    public NewPostAdapter(Activity paramActivity, String paramString1, String paramString2) {
        super(paramActivity, paramString1);
        this.mContext = paramActivity;
        this.subForumId = paramString2;
    }

    public void CreateNewTopic(ArrayList paramArrayList, String paramString, boolean paramBoolean, TapatalkForum paramTapatalkForum) {
        this.isShare = paramBoolean;
        this.forum = paramTapatalkForum;
        setTryTwice(false);
        this.mTopicTitle = paramString;
        this.engine.call(this.forumStatus.getNewTopicFunction(), paramArrayList);
    }

    public void ReplyTopic(ArrayList paramArrayList, String paramString1, String paramString2) {
        setTryTwice(false);
        this.mTopicId = paramString1;
        this.mTopicTitle = paramString2;
        this.engine.call(this.forumStatus.getReplyPostFunction(), paramArrayList);
    }

    public String attachImage(UploadAdapter paramUploadAdapter) {
        GeoPictureUploader localGeoPictureUploader = new GeoPictureUploader(this.forumStatus.getForumId(), Util.getMD5(Util.getMacAddress(this.mContext)), (ForumActivityStatus) this.mContext);
        if (!this.mContext.getApplicationContext().getResources().getBoolean(2131558401)) {
            Object localObject1 = new ArrayList();
            ((ArrayList) localObject1).add(this.forumStatus.getForumId());
            ((ArrayList) localObject1).add(Util.getMD5(Util.getMacAddress(this.mContext)));
            Object localObject2 = TapatalkJsonEngine.FILE_UPLOAD + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(this.mContext)) + "&device_type=" + Util.getDeviceName() + "&fid=" + this.forumStatus.getForumId() + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName());
            localObject1 = localObject2;
            if (this.forumStatus.getUserId() != null) {
                localObject1 = localObject2 + "&author_id=" + this.forumStatus.getUserId();
            }
            localObject2 = localObject1;
            if (this.mTopicId != null) {
                localObject2 = localObject1 + "&tid=" + this.mTopicId;
            }
            localObject1 = localObject2;
            if (this.mTopicTitle != null) {
                localObject1 = localObject2 + "&title=" + this.mTopicTitle;
            }
            TapatalkJsonEngine.callLogin(this.mContext, (String) localObject1);
        }
        return localGeoPictureUploader.uploadPicture(paramUploadAdapter, this.forumStatus.tapatalkForum.getUserName(), this.forumStatus.getUserId(), Util.getMD5(Util.getMacAddress(this.mContext)), this.forumStatus.getForumId());
    }

    public void attachImage(UploadAdapter paramUploadAdapter, String paramString) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        localArrayList.add(paramUploadAdapter);
        if (this.groupId != null) {
            localArrayList.add(this.groupId);
        }
        if (!this.mContext.getApplicationContext().getResources().getBoolean(2131558401)) {
            paramUploadAdapter = new ArrayList();
            paramUploadAdapter.add(this.forumStatus.getForumId());
            paramUploadAdapter.add(Util.getMD5(Util.getMacAddress(this.mContext)));
            paramString = TapatalkJsonEngine.FILE_UPLOAD + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(this.mContext)) + "&device_type=" + Util.getDeviceName() + "&fid=" + this.forumStatus.getForumId() + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName());
            paramUploadAdapter = paramString;
            if (this.forumStatus.getUserId() != null) {
                paramUploadAdapter = paramString + "&author_id=" + this.forumStatus.getUserId();
            }
            paramString = paramUploadAdapter;
            if (this.mTopicId != null) {
                paramString = paramUploadAdapter + "&tid=" + this.mTopicId;
            }
            paramUploadAdapter = paramString;
            if (this.mTopicTitle != null) {
                paramUploadAdapter = paramString + "&title=" + this.mTopicTitle;
            }
            TapatalkJsonEngine.callLogin(this.mContext, paramUploadAdapter);
        }
        this.engine.call("upload_attachment_x", localArrayList);
    }

    public void clearAll() {
        notifyDataSetChanged();
    }

    public void editPost(ArrayList paramArrayList) {
        setTryTwice(false);
        this.engine.call("save_raw_post", paramArrayList);
    }

    public int getCount() {
        return 0;
    }

    public Object getItem(int paramInt) {
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return null;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        Object localObject3 = (HashMap) paramEngineResponse.getResponse();
        int i;
        label279:
        label330:
        TapatalkId localTapatalkId;
        if (((String) localObject1).equals(this.forumStatus.getNewTopicFunction())) {
            if (!this.mContext.getApplicationContext().getResources().getBoolean(2131558401)) {
            }
            try {
                localObject3 = TapatalkJsonEngine.NEW_TOPIC + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(this.mContext)) + "&fid=" + this.forumStatus.getForumId() + "&tid=" + ((HashMap) localObject3).get("topic_id") + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName(), "utf-8") + "&author_id=" + this.forumStatus.tapatalkForum.getUserId() + "&title=" + URLEncoder.encode(this.mTopicTitle, "utf-8");
                localObject1 = localObject3;
                if (this.attachIds.size() > 0) {
                    localObject1 = localObject3 + "&attach=" + this.attachIds.size();
                }
                if (this.imageIds.size() <= 0) {
                    localObject3 = localObject1;
                    if (this.ids.size() <= 0) {
                    }
                } else {
                    localObject1 = localObject1 + "&image_ids=";
                    i = 0;
                    if (i < this.imageIds.size()) {
                        break label651;
                    }
                    i = 0;
                    if (i < this.ids.size()) {
                        break label791;
                    }
                    localObject3 = localObject1;
                }
                localObject1 = localObject3;
                if (this.videoIds.size() > 0) {
                    localObject1 = localObject3 + "&video_ids=";
                    i = 0;
                    if (i < this.videoIds.size()) {
                        break label874;
                    }
                }
                localTapatalkId = TapatalkIdFactory.getTapatalkId(this.mContext);
                localObject3 = localObject1;
                if (this.subForumId != null) {
                    localObject3 = localObject1;
                    if (!this.subForumId.equals("")) {
                        localObject3 = localObject1 + "&sub_fid=" + this.subForumId;
                    }
                }
                localObject1 = localObject3 + "&au_id=" + localTapatalkId.getAuid();
                TapatalkJsonEngine.callLogin(this.mContext, (String) localObject1);
                if (this.forumStatus.getPost_countdown() > 0) {
                    localObject1 = Prefs.get(this.mContext).edit();
                    ((SharedPreferences.Editor) localObject1).putLong("post_countdown_quite_time|" + this.forumStatus.getForumId(), System.currentTimeMillis());
                    ((SharedPreferences.Editor) localObject1).putInt("post_countdown_number|" + this.forumStatus.getForumId(), this.forumStatus.getPost_countdown());
                    ((SharedPreferences.Editor) localObject1).commit();
                }
            } catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
                for (; ; ) {
                    localUnsupportedEncodingException1.printStackTrace();
                }
            }
            this.mStatus.updateUI(12, paramEngineResponse.getResponse());
            if (this.isShare) {
                paramEngineResponse = (String) ((HashMap) paramEngineResponse.getResponse()).get("topic_id");
                localObject1 = new Intent(this.mContext, ThreadActivity.class);
                ((Intent) localObject1).putExtra("isShare", this.isShare);
                ((Intent) localObject1).putExtra("forum", this.forum);
                ((Intent) localObject1).putExtra("forumStatus", this.forumStatus);
                ((Intent) localObject1).putExtra("topic_id", paramEngineResponse);
                this.mContext.startActivity((Intent) localObject1);
            }
            label650:
            return;
            label651:
            if (i != this.imageIds.size() - 1) {
                localObject1 = localObject1 + ((UploadImageInfo) this.imageIds.get(i)).getId() + ",";
            } else if (this.ids.size() > 0) {
                localObject1 = localObject1 + ((UploadImageInfo) this.imageIds.get(i)).getId() + ",";
            } else {
                localObject1 = localObject1 + ((UploadImageInfo) this.imageIds.get(i)).getId();
                break label1907;
                label791:
                if (i != this.ids.size() - 1) {
                    localObject1 = localObject1 + (String) this.ids.get(i) + ",";
                    break label1914;
                }
                localObject1 = localObject1 + (String) this.ids.get(i);
                break label1914;
                label874:
                if (i != this.videoIds.size() - 1) {
                    localObject1 = localObject1 + (String) this.videoIds.get(i) + ",";
                    break label1921;
                }
                localObject1 = localObject1 + (String) this.videoIds.get(i);
                break label1921;
            }
        } else if ((localUnsupportedEncodingException1.equals("reply_topic")) || (localUnsupportedEncodingException1.equals("reply_post"))) {
            if (this.mContext.getApplicationContext().getResources().getBoolean(2131558401)) {
            }
        }
        for (; ; ) {
            try {
                localObject3 = TapatalkJsonEngine.REPLAY_POST + "?" + "device_id=" + Util.getMD5(Util.getMacAddress(this.mContext)) + "&fid=" + this.forumStatus.getForumId() + "&pid=" + ((HashMap) localObject3).get("post_id") + "&tid=" + this.mTopicId + "&author=" + URLEncoder.encode(this.forumStatus.tapatalkForum.getUserName(), "utf-8") + "&author_id=" + this.forumStatus.tapatalkForum.getUserId() + "&title=" + URLEncoder.encode(this.mTopicTitle, "utf-8");
                if (this.imageIds.size() <= 0) {
                    localObject2 = localObject3;
                    if (this.ids.size() <= 0) {
                    }
                } else {
                    localObject2 = localObject3 + "&image_ids=";
                    i = 0;
                    if (i < this.imageIds.size()) {
                        continue;
                    }
                    i = 0;
                    if (i < this.ids.size()) {
                        continue;
                    }
                }
                localObject3 = localObject2;
                if (this.videoIds.size() > 0) {
                    localObject3 = localObject2 + "&video_ids=";
                    i = 0;
                    if (i < this.videoIds.size()) {
                        continue;
                    }
                }
                localObject2 = localObject3;
                if (this.attachIds.size() > 0) {
                    localObject2 = localObject3 + "&attach=" + this.attachIds.size();
                }
                localTapatalkId = TapatalkIdFactory.getTapatalkId(this.mContext);
                localObject3 = localObject2;
                if (this.subForumId != null) {
                    localObject3 = localObject2;
                    if (!this.subForumId.equals("")) {
                        localObject3 = localObject2 + "&sub_fid=" + this.subForumId;
                    }
                }
                localObject2 = localObject3 + "&au_id=" + localTapatalkId.getAuid();
                TapatalkJsonEngine.callLogin(this.mContext, (String) localObject2);
            } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
                Object localObject2;
                localUnsupportedEncodingException2.printStackTrace();
                continue;
            }
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            paramEngineResponse.put("is_reply", "is_reply");
            this.mStatus.updateUI(19, paramEngineResponse);
            return;
            if (i != this.imageIds.size() - 1) {
                localObject2 = localObject2 + ((UploadImageInfo) this.imageIds.get(i)).getId() + ",";
            } else if (this.ids.size() > 0) {
                localObject2 = localObject2 + ((UploadImageInfo) this.imageIds.get(i)).getId() + ",";
            } else {
                localObject2 = localObject2 + ((UploadImageInfo) this.imageIds.get(i)).getId();
                break label1928;
                if (i != this.ids.size() - 1) {
                    localObject2 = localObject2 + (String) this.ids.get(i) + ",";
                    break label1935;
                }
                localObject2 = localObject2 + (String) this.ids.get(i);
                break label1935;
                if (i != this.videoIds.size() - 1) {
                    localObject3 = localObject3 + (String) this.videoIds.get(i) + ",";
                    break label1942;
                }
                localObject3 = localObject3 + (String) this.videoIds.get(i);
                break label1942;
                if (localUnsupportedEncodingException2.equals("save_raw_post")) {
                    paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                    this.mStatus.updateUI(19, paramEngineResponse);
                    if (!paramEngineResponse.containsKey("result_text")) {
                        break label650;
                    }
                    paramEngineResponse = new String((byte[]) paramEngineResponse.get("result_text"));
                    if (paramEngineResponse.equals("")) {
                        break label650;
                    }
                    Toast.makeText(this.mContext, paramEngineResponse, 1).show();
                    return;
                }
                if (!localUnsupportedEncodingException2.equals("attach_image")) {
                    break label650;
                }
                paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
                if (paramEngineResponse.containsKey("attachment_id")) {
                    this.mStatus.updateUI(30, paramEngineResponse);
                    return;
                }
                this.mStatus.updateUI(13, this.mContext.getString(2131099859));
                return;
                label1907:
                i += 1;
                break;
                label1914:
                i += 1;
                break label279;
                label1921:
                i += 1;
                break label330;
            }
            label1928:
            i += 1;
            continue;
            label1935:
            i += 1;
            continue;
            label1942:
            i += 1;
        }
    }

    public void refresh() {
    }

    public void removeItem(int paramInt) {
        notifyDataSetChanged();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/NewPostAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */