package com.quoord.tapatalkpro.action.directory;

import android.app.Activity;
import com.quoord.tapatalkpro.bean.UploadVimeoTicket;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.JSONUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadVimeoAction {
    private UploadVimeoActionActionCallBack actionCallBack;
    private Activity mActivity;

    public UploadVimeoAction(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    public void bindVimeo(UploadVimeoActionActionCallBack paramUploadVimeoActionActionCallBack, String paramString1, String paramString2, String paramString3, String paramString4) {
        this.actionCallBack = paramUploadVimeoActionActionCallBack;
        paramUploadVimeoActionActionCallBack = DirectoryUrlUtil.getBindVimeoUrl(this.mActivity, paramString1, paramString2, paramString3, paramString4);
        new TapatalkAjaxAction(this.mActivity).getJsonObjectAction(paramUploadVimeoActionActionCallBack, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                paramAnonymousObject = UploadVimeoAction.this.getTicketResult((JSONObject) paramAnonymousObject);
                UploadVimeoAction.this.actionCallBack.actionCallBack((UploadVimeoTicket) paramAnonymousObject);
            }
        });
    }

    public UploadVimeoTicket getTicketResult(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return null;
        }
        UploadVimeoTicket localUploadVimeoTicket = new UploadVimeoTicket();
        JSONUtil localJSONUtil = new JSONUtil(paramJSONObject);
        localUploadVimeoTicket.setResult(localJSONUtil.optBoolean("result").booleanValue());
        if (!localUploadVimeoTicket.isResult()) {
            localUploadVimeoTicket.setResult_code(localJSONUtil.optString("result_code"));
            return localUploadVimeoTicket;
        }
        if (paramJSONObject.has("ticket")) {
        }
        try {
            paramJSONObject = new JSONUtil((JSONObject) paramJSONObject.get("ticket"));
            localUploadVimeoTicket.setEndpoint(paramJSONObject.optString("endpoint"));
            localUploadVimeoTicket.setEndpoint_secure(paramJSONObject.optString("endpoint_secure"));
            localUploadVimeoTicket.setHost(paramJSONObject.optString("host"));
            localUploadVimeoTicket.setTicketId(paramJSONObject.optString("id"));
            localUploadVimeoTicket.setMax_file_size(paramJSONObject.optInteger("max_file_size").intValue());
            localUploadVimeoTicket.setVideo_id(localJSONUtil.optString("video_id"));
            localUploadVimeoTicket.setId(localJSONUtil.optString("id"));
            return localUploadVimeoTicket;
        } catch (JSONException paramJSONObject) {
            for (; ; ) {
                paramJSONObject.printStackTrace();
            }
        }
    }

    public void getUploadVimeoTicket(UploadVimeoActionActionCallBack paramUploadVimeoActionActionCallBack) {
        this.actionCallBack = paramUploadVimeoActionActionCallBack;
        paramUploadVimeoActionActionCallBack = DirectoryUrlUtil.getUploadVimeoTicketUrl(this.mActivity);
        new TapatalkAjaxAction(this.mActivity).getJsonObjectAction(paramUploadVimeoActionActionCallBack, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                paramAnonymousObject = UploadVimeoAction.this.getTicketResult((JSONObject) paramAnonymousObject);
                UploadVimeoAction.this.actionCallBack.actionCallBack((UploadVimeoTicket) paramAnonymousObject);
            }
        });
    }

    public void removeVimeo(UploadVimeoActionActionCallBack paramUploadVimeoActionActionCallBack, String paramString1, String paramString2) {
        this.actionCallBack = paramUploadVimeoActionActionCallBack;
        paramUploadVimeoActionActionCallBack = DirectoryUrlUtil.getRemoveVimeoUrl(this.mActivity, paramString1, paramString2);
        new TapatalkAjaxAction(this.mActivity).getJsonObjectAction(paramUploadVimeoActionActionCallBack, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                paramAnonymousObject = UploadVimeoAction.this.getTicketResult((JSONObject) paramAnonymousObject);
                UploadVimeoAction.this.actionCallBack.actionCallBack((UploadVimeoTicket) paramAnonymousObject);
            }
        });
    }

    public void uploadVimeoComplete(UploadVimeoActionActionCallBack paramUploadVimeoActionActionCallBack, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        this.actionCallBack = paramUploadVimeoActionActionCallBack;
        paramUploadVimeoActionActionCallBack = DirectoryUrlUtil.getUploadVimeoCompleteUrl(this.mActivity, paramString1, paramString2, paramString3, paramString4, paramString5);
        new TapatalkAjaxAction(this.mActivity).getJsonObjectAction(paramUploadVimeoActionActionCallBack, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                paramAnonymousObject = UploadVimeoAction.this.getTicketResult((JSONObject) paramAnonymousObject);
                UploadVimeoAction.this.actionCallBack.actionCallBack((UploadVimeoTicket) paramAnonymousObject);
            }
        });
    }

    public static abstract interface UploadVimeoActionActionCallBack {
        public abstract void actionCallBack(UploadVimeoTicket paramUploadVimeoTicket);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/directory/UploadVimeoAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */