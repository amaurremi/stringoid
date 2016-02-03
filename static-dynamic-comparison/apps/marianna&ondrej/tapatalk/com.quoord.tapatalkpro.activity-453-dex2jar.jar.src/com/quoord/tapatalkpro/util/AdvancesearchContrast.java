package com.quoord.tapatalkpro.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AdvancesearchContrast
        implements Serializable {
    public String FORUMID = "";
    public String FORUMNAME = "";
    public String KEYWORD = "";
    public boolean SHOWPOSTS = false;
    public String THREADID = "";
    public boolean TITLEONLY = false;
    public String USERID;
    public String USERNAME = "";

    private void readObject(ObjectInputStream paramObjectInputStream) {
        try {
            this.KEYWORD = ((String) paramObjectInputStream.readObject());
            this.FORUMNAME = ((String) paramObjectInputStream.readObject());
            this.FORUMID = ((String) paramObjectInputStream.readObject());
            this.USERNAME = ((String) paramObjectInputStream.readObject());
            this.THREADID = ((String) paramObjectInputStream.readObject());
            this.TITLEONLY = ((Boolean) paramObjectInputStream.readObject()).booleanValue();
            this.SHOWPOSTS = ((Boolean) paramObjectInputStream.readObject()).booleanValue();
            return;
        } catch (Exception paramObjectInputStream) {
        }
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream) {
        try {
            paramObjectOutputStream.writeObject(this.KEYWORD);
            paramObjectOutputStream.writeObject(this.FORUMNAME);
            paramObjectOutputStream.writeObject(this.FORUMID);
            paramObjectOutputStream.writeObject(this.USERNAME);
            paramObjectOutputStream.writeObject(this.THREADID);
            paramObjectOutputStream.writeObject(Boolean.valueOf(this.TITLEONLY));
            paramObjectOutputStream.writeObject(Boolean.valueOf(this.SHOWPOSTS));
            return;
        } catch (Exception paramObjectOutputStream) {
        }
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof AdvancesearchContrast)) {
            paramObject = (AdvancesearchContrast) paramObject;
            bool1 = bool2;
            if (((AdvancesearchContrast) paramObject).KEYWORD.equals(this.KEYWORD)) {
                bool1 = bool2;
                if (((AdvancesearchContrast) paramObject).FORUMNAME.equals(this.FORUMNAME)) {
                    bool1 = bool2;
                    if (((AdvancesearchContrast) paramObject).FORUMID == this.FORUMID) {
                        bool1 = bool2;
                        if (((AdvancesearchContrast) paramObject).USERNAME.equals(this.USERNAME)) {
                            bool1 = bool2;
                            if (((AdvancesearchContrast) paramObject).THREADID == this.THREADID) {
                                bool1 = bool2;
                                if (((AdvancesearchContrast) paramObject).TITLEONLY == this.TITLEONLY) {
                                    bool1 = bool2;
                                    if (((AdvancesearchContrast) paramObject).SHOWPOSTS == this.SHOWPOSTS) {
                                        bool1 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bool1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/AdvancesearchContrast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */