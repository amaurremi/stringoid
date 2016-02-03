package com.quoord.tapatalkpro.bean;

public class UploadVimeoTicket {
    private String endpoint;
    private String endpoint_secure;
    private String host;
    private String id;
    private long max_file_size;
    private boolean result;
    private String result_code;
    private String ticketId;
    private String video_id;

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getEndpoint_secure() {
        return this.endpoint_secure;
    }

    public String getHost() {
        return this.host;
    }

    public String getId() {
        return this.id;
    }

    public long getMax_file_size() {
        return this.max_file_size;
    }

    public String getResult_code() {
        return this.result_code;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setEndpoint(String paramString) {
        this.endpoint = paramString;
    }

    public void setEndpoint_secure(String paramString) {
        this.endpoint_secure = paramString;
    }

    public void setHost(String paramString) {
        this.host = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setMax_file_size(long paramLong) {
        this.max_file_size = paramLong;
    }

    public void setResult(boolean paramBoolean) {
        this.result = paramBoolean;
    }

    public void setResult_code(String paramString) {
        this.result_code = paramString;
    }

    public void setTicketId(String paramString) {
        this.ticketId = paramString;
    }

    public void setVideo_id(String paramString) {
        this.video_id = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/UploadVimeoTicket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */