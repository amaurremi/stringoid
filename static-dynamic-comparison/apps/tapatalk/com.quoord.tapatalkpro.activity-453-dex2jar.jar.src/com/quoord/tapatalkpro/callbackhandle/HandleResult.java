package com.quoord.tapatalkpro.callbackhandle;

import java.util.HashMap;

public class HandleResult {
    private boolean connnectionValue = false;
    private String methodName;
    private HashMap<String, Object> needOfHandleResult;
    private boolean responseValue = false;
    private String resultText;

    public String getMethodName() {
        return this.methodName;
    }

    public HashMap<String, Object> getNeedOfHandleResult() {
        return this.needOfHandleResult;
    }

    public String getResultText() {
        return this.resultText;
    }

    public boolean isConnnectionValue() {
        return this.connnectionValue;
    }

    public boolean isResponseValue() {
        return this.responseValue;
    }

    void setConnnectionValue(boolean paramBoolean) {
        this.connnectionValue = paramBoolean;
    }

    void setMethodName(String paramString) {
        this.methodName = paramString;
    }

    void setNeedOfHandleResult(HashMap<String, Object> paramHashMap) {
        this.needOfHandleResult = paramHashMap;
    }

    void setResponseValue(boolean paramBoolean) {
        this.responseValue = paramBoolean;
    }

    void setResultText(String paramString) {
        this.resultText = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/callbackhandle/HandleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */