package com.everimaging.fotor.discovery.entity;

import java.util.List;

public class NewsDataInfo {
    private NewsData data;
    private String msg;
    private PageInfo pageInfo;
    private boolean status;

    public NewsData getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setData(NewsData paramNewsData) {
        this.data = paramNewsData;
    }

    public void setMsg(String paramString) {
        this.msg = paramString;
    }

    public void setPageInfo(PageInfo paramPageInfo) {
        this.pageInfo = paramPageInfo;
    }

    public void setStatus(boolean paramBoolean) {
        this.status = paramBoolean;
    }

    public static class NewsData {
        private List<NewsEntity> discoverList;
        private int newsNum;
        private long timestamp;

        public List<NewsEntity> getDiscoverList() {
            return this.discoverList;
        }

        public int getNewsNum() {
            return this.newsNum;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setDiscoverList(List<NewsEntity> paramList) {
            this.discoverList = paramList;
        }

        public void setNewsNum(int paramInt) {
            this.newsNum = paramInt;
        }

        public void setTimestamp(long paramLong) {
            this.timestamp = paramLong;
        }
    }

    private class PageInfo {
        int index;
        int num;
        int size;

        private PageInfo() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/discovery/entity/NewsDataInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */