package com.quoord.tapatalkpro.ics.forum;

import android.content.Context;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.TapatalkForum;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ForumCallBackResult
        extends CallBackResult {
    public void handleBackResult(EngineResponse paramEngineResponse, Context paramContext) {
    }

    public void handleBackResult(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
    }

    public void handleBackResult(String paramString, Context paramContext) {
    }

    public void handleBackResult(String paramString, ForumActivityStatus paramForumActivityStatus) {
    }

    public void handleBackResult(JSONArray paramJSONArray, Context paramContext)
            throws Exception {
        if (paramJSONArray != null) {
            handleBackResult(paramJSONArray.getJSONObject(0), paramContext);
        }
    }

    public void handleBackResult(JSONArray paramJSONArray, ForumActivityStatus paramForumActivityStatus) {
    }

    public void handleBackResult(JSONObject paramJSONObject, Context paramContext)
            throws Exception {
        if (paramJSONObject != null) {
            paramContext = new TapatalkForum();
            paramContext.setId(Integer.valueOf(paramJSONObject.optInt("id", 0)));
            paramContext.setName(paramJSONObject.optString("name"));
            paramContext.setUrl(paramJSONObject.optString("url"));
            paramContext.setDescription(paramJSONObject.optString("description"));
            paramContext.setIconUrl(paramJSONObject.optString("logo").replace("90x90", "HD"));
            paramContext.setFolder(paramJSONObject.optString("mobiquo_dir"));
            paramContext.setExt(paramJSONObject.optString("ext"));
            paramContext.setSignatureType(paramJSONObject.optInt("tapatalk_signature"));
            paramContext.setSupportTkUpload(paramJSONObject.optString("hosted_image_support").equals("1"));
            paramContext.setMedia_sharing(paramJSONObject.optString("hosted_image_support").equals("1"));
            paramContext.setViglinkSupport(paramJSONObject.optString("viglink_support").equals("1"));
            paramContext.setSupportedPR(paramJSONObject.optInt("pr", 0));
            paramContext.setIsPT(paramJSONObject.optInt("pt", 0));
            paramContext.setDfp(Integer.valueOf(paramJSONObject.optString("dfp").toString()).intValue());
            paramContext.setHasImage("1".equals(paramJSONObject.optString("topic_image")));
            paramContext.setForumUrl(paramJSONObject.optString("android_product_url"));
            paramContext.setCms_url(paramJSONObject.optString("cms_url"));
            paramContext.setGa(paramJSONObject.optString("ga"));
            paramJSONObject = new ArrayList();
            paramJSONObject.add(paramContext);
            setDataList(paramJSONObject);
        }
    }

    public void handleBackResult(JSONObject paramJSONObject, ForumActivityStatus paramForumActivityStatus) {
    }

    public void saveResponseValue(EngineResponse paramEngineResponse, Context paramContext) {
    }

    public void saveResponseValue(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/forum/ForumCallBackResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */