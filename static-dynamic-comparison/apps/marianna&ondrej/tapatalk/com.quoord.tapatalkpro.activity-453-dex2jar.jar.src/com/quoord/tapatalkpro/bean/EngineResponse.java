package com.quoord.tapatalkpro.bean;

public class EngineResponse {
    private String errorMessage;
    private String method;
    private Object response;
    private boolean success;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getMethod() {
        return this.method;
    }

    public Object getResponse() {
        return this.response;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setErrorMessage(String paramString) {
        this.errorMessage = paramString;
    }

    public void setMethod(String paramString) {
        this.method = paramString;
    }

    public void setResponse(Object paramObject) {
        this.response = paramObject;
    }

    public void setSuccess(boolean paramBoolean) {
        this.success = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/EngineResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */