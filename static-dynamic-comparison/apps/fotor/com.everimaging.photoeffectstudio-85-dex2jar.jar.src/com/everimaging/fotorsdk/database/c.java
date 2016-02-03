package com.everimaging.fotorsdk.database;

import android.provider.BaseColumns;
import com.everimaging.fotorsdk.provider.FotorContentProvider.ActionsColumns;
import com.everimaging.fotorsdk.provider.FotorContentProvider.SessionColumns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class c
        implements BaseColumns {
    public static final String DATABASE_NAME = "com.everimaing.fotorsdk.sqlite";
    public static final int DATABASE_VERSION = 1;
    protected static final String SCHEME = "content://";
    public static final String[] SUBCLASSES = {FotorContentProvider.SessionColumns.class.getName(), FotorContentProvider.ActionsColumns.class.getName(), e.class.getName(), a.class.getName()};

    public static final Class<c>[] getSubClasses() {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (; ; ) {
            if (i < SUBCLASSES.length) {
                try {
                    localArrayList.add(Class.forName(SUBCLASSES[i]));
                    i += 1;
                } catch (ClassNotFoundException localClassNotFoundException) {
                    for (; ; ) {
                        localClassNotFoundException.printStackTrace();
                    }
                }
            }
        }
        return (Class[]) localArrayList.toArray(new Class[0]);
    }

    private static final String getTableCreator(String paramString, Map<String, String> paramMap) {
        String[] arrayOfString = (String[]) paramMap.keySet().toArray(new String[0]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CREATE TABLE ").append(paramString).append("( ");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j) {
            paramString = (String) paramMap.get(arrayOfString[i]);
            localStringBuilder.append(arrayOfString[i]).append(" ");
            localStringBuilder.append(paramString);
            if (i < j - 1) {
                localStringBuilder.append(",");
            }
            i += 1;
        }
        localStringBuilder.append(")");
        return localStringBuilder.toString();
    }

    public String[] getColumns() {
        return (String[]) getTableMap().values().toArray(new String[0]);
    }

    public String getTableCreateor() {
        return getTableCreator(getTableName(), getTableMap());
    }

    protected abstract Map<String, String> getTableMap();

    public abstract String getTableName();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/database/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */