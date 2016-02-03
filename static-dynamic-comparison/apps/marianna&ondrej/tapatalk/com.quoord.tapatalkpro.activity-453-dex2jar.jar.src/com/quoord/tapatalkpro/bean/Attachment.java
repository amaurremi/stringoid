package com.quoord.tapatalkpro.bean;

import java.util.HashMap;

public class Attachment {
    private String content_type;
    private String fileName;
    private int filesize;
    private String thumbnail_url;
    private String url;

    public Attachment(HashMap paramHashMap) {
        setFileName(new String((byte[]) paramHashMap.get("filename")));
        setThumbnail_url((String) paramHashMap.get("thumbnail_url"));
        setContent_type((String) paramHashMap.get("content_type"));
        setUrl((String) paramHashMap.get("url"));
        setFilesize(((Integer) paramHashMap.get("filesize")).intValue());
    }

    public String getContent_type() {
        return this.content_type;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFilesize() {
        return this.filesize;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setContent_type(String paramString) {
        this.content_type = paramString;
    }

    public void setFileName(String paramString) {
        this.fileName = paramString;
    }

    public void setFilesize(int paramInt) {
        this.filesize = paramInt;
    }

    public void setThumbnail_url(String paramString) {
        this.thumbnail_url = paramString;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Attachment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */