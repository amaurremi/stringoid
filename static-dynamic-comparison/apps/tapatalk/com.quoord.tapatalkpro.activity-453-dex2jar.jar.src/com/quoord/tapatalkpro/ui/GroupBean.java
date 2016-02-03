package com.quoord.tapatalkpro.ui;

import java.util.ArrayList;

public class GroupBean {
    private ArrayList childrenList = new ArrayList();
    public boolean isSigleView = false;
    private Object obj;
    private String title = "";
    public String viewType;

    public GroupBean() {
    }

    public GroupBean(String paramString) {
        this.title = paramString;
    }

    public GroupBean(String paramString, ArrayList paramArrayList) {
        this.title = paramString;
        this.childrenList = paramArrayList;
    }

    public void clear() {
        this.childrenList.clear();
        this.obj = null;
    }

    public ArrayList getChildrenList() {
        return this.childrenList;
    }

    public Object getObj() {
        return this.obj;
    }

    public int getSize() {
        if (this.isSigleView) {
            return 1;
        }
        return this.childrenList.size();
    }

    public String getTitle() {
        return this.title;
    }

    public void setChildrenList(ArrayList paramArrayList) {
        this.childrenList = paramArrayList;
    }

    public void setObj(Object paramObject) {
        this.obj = paramObject;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/GroupBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */