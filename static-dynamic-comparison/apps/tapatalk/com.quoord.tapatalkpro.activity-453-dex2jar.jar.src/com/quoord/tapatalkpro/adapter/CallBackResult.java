package com.quoord.tapatalkpro.adapter;

import android.content.Context;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class CallBackResult {
    public static final int RESULT_TYPECODE_JSONARRAY = 1;
    public static final int RESULT_TYPECODE_JSONOBJECT = 0;
    public static final int RESULT_TYPECODE_STRING = 2;
    public static final String hadleerror = "Handle Error!";
    private int callNums = 0;
    private boolean connectionResult = false;
    private ArrayList dataList = null;
    private String handleError = null;
    private boolean handleResult = false;
    private boolean invokeResult = false;
    private String methodName = null;
    private Object responseEntity = null;
    private int resultCode = -100;
    private String resultText = null;
    private int resultTypeCode = -1;
    private String url = null;

    public void addNumsCall() {
        this.callNums += 1;
    }

    public int getCallNums() {
        return this.callNums;
    }

    public Object getCallResultEntity() {
        return this.responseEntity;
    }

    public boolean getConnectionResult() {
        return this.connectionResult;
    }

    public ArrayList getDataList() {
        return this.dataList;
    }

    public String getHandleError() {
        return this.handleError;
    }

    public boolean getHandleResult() {
        return this.handleResult;
    }

    public boolean getInvokeResult() {
        return this.invokeResult;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public Object getResponseEntity() {
        return this.responseEntity;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultText() {
        return this.resultText;
    }

    public int getResultTypeCode() {
        return this.resultTypeCode;
    }

    public String getUrl() {
        return this.url;
    }

    public abstract void handleBackResult(EngineResponse paramEngineResponse, Context paramContext)
            throws Exception;

    public abstract void handleBackResult(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus)
            throws Exception;

    public abstract void handleBackResult(String paramString, Context paramContext)
            throws Exception;

    public abstract void handleBackResult(String paramString, ForumActivityStatus paramForumActivityStatus)
            throws Exception;

    public abstract void handleBackResult(JSONArray paramJSONArray, Context paramContext)
            throws Exception;

    public abstract void handleBackResult(JSONArray paramJSONArray, ForumActivityStatus paramForumActivityStatus)
            throws Exception;

    public abstract void handleBackResult(JSONObject paramJSONObject, Context paramContext)
            throws Exception;

    public abstract void handleBackResult(JSONObject paramJSONObject, ForumActivityStatus paramForumActivityStatus)
            throws Exception;

    public void resetNumsCall() {
        this.callNums = 0;
    }

    public abstract void saveResponseValue(EngineResponse paramEngineResponse, Context paramContext)
            throws Exception;

    public abstract void saveResponseValue(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus)
            throws Exception;

    public void setCallResultEntity(Object paramObject) {
        this.responseEntity = paramObject;
    }

    public void setConnectionResult(boolean paramBoolean) {
        this.connectionResult = paramBoolean;
    }

    public void setDataList(ArrayList paramArrayList) {
        this.dataList = paramArrayList;
    }

    public void setHandleError(String paramString) {
        this.handleError = paramString;
    }

    public void setHandleResult(boolean paramBoolean) {
        this.handleResult = paramBoolean;
    }

    public void setInvokeResult(boolean paramBoolean) {
        this.invokeResult = paramBoolean;
    }

    public void setMethodName(String paramString) {
        this.methodName = paramString;
    }

    public void setResponseEntity(Object paramObject) {
        this.responseEntity = paramObject;
    }

    public void setResultCode(int paramInt) {
        this.resultCode = paramInt;
    }

    public void setResultText(String paramString) {
        this.resultText = paramString;
    }

    public void setResultTypeCode(int paramInt) {
        this.resultTypeCode = paramInt;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/CallBackResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */