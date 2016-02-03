package com.quoord.tapatalkpro.bean;

import android.view.LayoutInflater;
import android.view.View;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class TapatalkCategory
        extends BaseBean
        implements Serializable {
    private int cat_order;
    private ArrayList<TapatalkCategory> childCats;
    private String iconURL;
    private String id;
    private boolean isSelected;
    private String name;
    private int numberOfForums;
    private int ob;
    private String obName;

    public void addChildCat(TapatalkCategory paramTapatalkCategory) {
        if (this.childCats == null) {
            this.childCats = new ArrayList();
        }
        this.childCats.add(paramTapatalkCategory);
    }

    public View createView(HashMap paramHashMap, View paramView, ForumActivityStatus paramForumActivityStatus) {
        return LayoutInflater.from(paramForumActivityStatus.getDefaultActivity()).inflate(2130903222, null);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof TapatalkCategory)) {
            bool1 = bool2;
            if (this.id.equals(((TapatalkCategory) paramObject).getId())) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public int getCat_order() {
        return this.cat_order;
    }

    public ArrayList<TapatalkCategory> getChildCat() {
        return this.childCats;
    }

    public String getIconURL() {
        return this.iconURL;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfForums() {
        return this.numberOfForums;
    }

    public int getOb() {
        return this.ob;
    }

    public String getObName() {
        return this.obName;
    }

    public boolean hasChild() {
        return (this.childCats != null) && (this.childCats.size() != 0);
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setCat_order(int paramInt) {
        this.cat_order = paramInt;
    }

    public void setChildCat(ArrayList<TapatalkCategory> paramArrayList) {
        this.childCats = paramArrayList;
    }

    public void setIconURL(String paramString) {
        this.iconURL = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setNumberOfForums(int paramInt) {
        this.numberOfForums = paramInt;
    }

    public void setOb(int paramInt) {
        this.ob = paramInt;
    }

    public void setObName(String paramString) {
        this.obName = paramString;
    }

    public void setSelected(boolean paramBoolean) {
        this.isSelected = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/TapatalkCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */