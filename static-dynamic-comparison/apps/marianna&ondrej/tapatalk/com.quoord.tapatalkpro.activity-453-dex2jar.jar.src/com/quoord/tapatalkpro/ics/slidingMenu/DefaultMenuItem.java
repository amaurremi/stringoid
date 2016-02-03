package com.quoord.tapatalkpro.ics.slidingMenu;

import java.util.ArrayList;

public class DefaultMenuItem {
    private boolean isContainAllForum = false;
    private boolean isContainLogin = false;
    private boolean isContainTimeLine = false;
    private boolean isContainUnread = false;

    public boolean isContainAllForum() {
        return this.isContainAllForum;
    }

    public boolean isContainLogin() {
        return this.isContainLogin;
    }

    public boolean isContainTimeLine() {
        return this.isContainTimeLine;
    }

    public boolean isContainUnread() {
        return this.isContainUnread;
    }

    public void selectLoginMenuItem(ArrayList<TabItem> paramArrayList) {
        int i = 0;
        if (i >= paramArrayList.size()) {
            return;
        }
        if (((TabItem) paramArrayList.get(i)).getMenuid() == 1013) {
            setContainUnread(true);
        }
        for (; ; ) {
            i += 1;
            break;
            if (((TabItem) paramArrayList.get(i)).getMenuid() == 1016) {
                setContainTimeLine(true);
            }
        }
    }

    public void selectMenuItem(ArrayList<TabItem> paramArrayList) {
        int i = 0;
        if (i >= paramArrayList.size()) {
            return;
        }
        if (((TabItem) paramArrayList.get(i)).getMenuid() == 1016) {
            setContainTimeLine(true);
        }
        for (; ; ) {
            i += 1;
            break;
            if (((TabItem) paramArrayList.get(i)).getMenuid() == 1018) {
                setContainAllForum(true);
            } else if (((TabItem) paramArrayList.get(i)).getMenuid() == 1027) {
                setContainLogin(true);
            }
        }
    }

    public void setContainAllForum(boolean paramBoolean) {
        this.isContainAllForum = paramBoolean;
    }

    public void setContainLogin(boolean paramBoolean) {
        this.isContainLogin = paramBoolean;
    }

    public void setContainTimeLine(boolean paramBoolean) {
        this.isContainTimeLine = paramBoolean;
    }

    public void setContainUnread(boolean paramBoolean) {
        this.isContainUnread = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/DefaultMenuItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */