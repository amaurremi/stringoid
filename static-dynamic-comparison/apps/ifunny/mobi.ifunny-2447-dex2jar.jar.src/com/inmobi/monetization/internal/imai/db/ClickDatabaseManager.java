package com.inmobi.monetization.internal.imai.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.inmobi.commons.db.ColumnData;
import com.inmobi.commons.db.ColumnData.ColumnType;
import com.inmobi.commons.db.DatabaseHandler;
import com.inmobi.commons.db.TableData;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.IMAIClickEventList;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ClickDatabaseManager
        extends DatabaseHandler {
    public static final String COLUMN_CLICK_ID = "clickid";
    public static final String COLUMN_CLICK_URL = "clickurl";
    public static final String COLUMN_FOLLOW_REDIRECT = "followredirect";
    public static final String COLUMN_PINGWV = "pingwv";
    public static final String COLUMN_RETRY_COUNT = "retrycount";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String TABLE_CLICK = "clickevent";
    private static ClickDatabaseManager a;
    private int b = 1000;

    protected ClickDatabaseManager(Context paramContext, ArrayList<TableData> paramArrayList) {
        super(paramContext, paramArrayList);
    }

    private static TableData a() {
        TableData localTableData = new TableData();
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        ColumnData localColumnData = new ColumnData();
        localColumnData.setPrimaryKey(true);
        localColumnData.setDataType(ColumnData.ColumnType.INTEGER);
        localColumnData.setMandatory(true);
        localLinkedHashMap.put("clickid", localColumnData);
        localColumnData = new ColumnData();
        localColumnData.setDataType(ColumnData.ColumnType.VARCHAR);
        localColumnData.setMandatory(true);
        localLinkedHashMap.put("clickurl", localColumnData);
        localColumnData = new ColumnData();
        localColumnData.setDataType(ColumnData.ColumnType.INTEGER);
        localColumnData.setMandatory(true);
        localLinkedHashMap.put("pingwv", localColumnData);
        localColumnData = new ColumnData();
        localColumnData.setDataType(ColumnData.ColumnType.INTEGER);
        localColumnData.setMandatory(true);
        localLinkedHashMap.put("followredirect", localColumnData);
        localColumnData = new ColumnData();
        localColumnData.setDataType(ColumnData.ColumnType.INTEGER);
        localColumnData.setMandatory(true);
        localLinkedHashMap.put("retrycount", localColumnData);
        localColumnData = new ColumnData();
        localColumnData.setDataType(ColumnData.ColumnType.INTEGER);
        localColumnData.setMandatory(true);
        localLinkedHashMap.put("timestamp", localColumnData);
        localTableData.setmColumns(localLinkedHashMap);
        localTableData.setmTableName("clickevent");
        return localTableData;
    }

    public static ClickDatabaseManager getInstance() {
        try {
            if (a == null) {
                localObject1 = new ArrayList();
                ((ArrayList) localObject1).add(a());
                a = new ClickDatabaseManager(InternalSDKUtil.getContext(), (ArrayList) localObject1);
            }
            localObject1 = a;
        } catch (Exception localException) {
            for (; ; ) {
                Object localObject1;
                Log.internal("[InMobi]-[Monetization]", "Exception getting DB Manager Instance", localException);
                Object localObject2 = null;
            }
        } finally {
        }
        return (ClickDatabaseManager) localObject1;
    }

    /* Error */
    public boolean deleteClickEvents(ArrayList<Long> paramArrayList) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: ifnull +98 -> 101
        //   6: aload_1
        //   7: invokevirtual 121	java/util/ArrayList:isEmpty	()Z
        //   10: ifne +91 -> 101
        //   13: aload_0
        //   14: invokevirtual 124	com/inmobi/monetization/internal/imai/db/ClickDatabaseManager:open	()V
        //   17: aload_1
        //   18: invokevirtual 128	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   21: astore_1
        //   22: aload_1
        //   23: invokeinterface 133 1 0
        //   28: ifeq +63 -> 91
        //   31: aload_1
        //   32: invokeinterface 137 1 0
        //   37: checkcast 139	java/lang/Long
        //   40: invokevirtual 143	java/lang/Long:longValue	()J
        //   43: lstore_2
        //   44: aload_0
        //   45: ldc 26
        //   47: new 145	java/lang/StringBuilder
        //   50: dup
        //   51: invokespecial 146	java/lang/StringBuilder:<init>	()V
        //   54: ldc -108
        //   56: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   59: lload_2
        //   60: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   63: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   66: aconst_null
        //   67: invokevirtual 163	com/inmobi/monetization/internal/imai/db/ClickDatabaseManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
        //   70: pop
        //   71: goto -49 -> 22
        //   74: astore_1
        //   75: ldc 107
        //   77: ldc -91
        //   79: aload_1
        //   80: invokestatic 115	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   83: iconst_0
        //   84: istore 4
        //   86: aload_0
        //   87: monitorexit
        //   88: iload 4
        //   90: ireturn
        //   91: aload_0
        //   92: invokevirtual 168	com/inmobi/monetization/internal/imai/db/ClickDatabaseManager:close	()V
        //   95: iconst_1
        //   96: istore 4
        //   98: goto -12 -> 86
        //   101: iconst_0
        //   102: istore 4
        //   104: goto -18 -> 86
        //   107: astore_1
        //   108: aload_0
        //   109: monitorexit
        //   110: aload_1
        //   111: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	112	0	this	ClickDatabaseManager
        //   0	112	1	paramArrayList	ArrayList<Long>
        //   43	17	2	l	long
        //   84	19	4	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   6	22	74	java/lang/Exception
        //   22	71	74	java/lang/Exception
        //   91	95	74	java/lang/Exception
        //   6	22	107	finally
        //   22	71	107	finally
        //   75	83	107	finally
        //   91	95	107	finally
    }

    public IMAIClickEventList getClickEvents(int paramInt) {
        for (; ; ) {
            ClickData localClickData;
            try {
                IMAIClickEventList localIMAIClickEventList = new IMAIClickEventList();
                try {
                    open();
                    Cursor localCursor = getNRows("clickevent", "timestamp", paramInt);
                    localCursor.moveToFirst();
                    localClickData = new ClickData();
                    localClickData.setClickId(localCursor.getLong(0));
                    localClickData.setClickUrl(localCursor.getString(1));
                    if (1 != localCursor.getInt(2)) {
                        continue;
                    }
                    localClickData.setPingWv(true);
                    if (1 != localCursor.getInt(3)) {
                        break label178;
                    }
                    localClickData.setFollowRedirect(true);
                    localClickData.setRetryCount(localCursor.getInt(4));
                    localClickData.setTimestamp(localCursor.getLong(5));
                    localIMAIClickEventList.add(localClickData);
                    if (localCursor.moveToNext()) {
                        continue;
                    }
                    localCursor.close();
                    close();
                } catch (Exception localException) {
                    Log.internal("[InMobi]-[Monetization]", "Failed to get clicks from db", localException);
                    continue;
                }
                return localIMAIClickEventList;
            } finally {
            }
            localClickData.setPingWv(false);
            continue;
            label178:
            localClickData.setFollowRedirect(false);
        }
    }

    public int getNoOfEvents() {
        try {
            open();
            int i = getInstance().getNoOfRows("clickevent", null, null);
            close();
            return i;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Exception getting no of click events", localException);
        }
        return 0;
    }

    public void insertClick(ClickData paramClickData) {
        try {
            open();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("timestamp", Long.valueOf(paramClickData.getTimestamp()));
            localContentValues.put("clickurl", paramClickData.getClickUrl());
            localContentValues.put("pingwv", Boolean.valueOf(paramClickData.isPingWv()));
            localContentValues.put("retrycount", Integer.valueOf(paramClickData.getRetryCount()));
            localContentValues.put("followredirect", Boolean.valueOf(paramClickData.isFollowRedirects()));
            if (getTableSize("clickevent") >= this.b) {
                paramClickData = executeQuery("SELECT clickid FROM clickevent WHERE timestamp= (SELECT MIN(timestamp) FROM clickevent Limit 1);", null);
                paramClickData.moveToFirst();
                long l = paramClickData.getLong(0);
                paramClickData.close();
                delete("clickevent", "clickid = " + l, null);
            }
            insert("clickevent", localContentValues);
            close();
        } catch (Exception paramClickData) {
            for (; ; ) {
                Log.internal("[InMobi]-[Monetization]", "Failed to insert click event to db", paramClickData);
            }
        } finally {
        }
    }

    public void setDBLimit(int paramInt) {
        if (paramInt > 0) {
            this.b = paramInt;
        }
    }

    /* Error */
    public boolean updateRetryCount(ArrayList<ClickData> paramArrayList) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: ifnull +184 -> 187
        //   6: aload_1
        //   7: invokevirtual 121	java/util/ArrayList:isEmpty	()Z
        //   10: ifne +177 -> 187
        //   13: aload_0
        //   14: invokevirtual 124	com/inmobi/monetization/internal/imai/db/ClickDatabaseManager:open	()V
        //   17: aload_1
        //   18: invokevirtual 128	java/util/ArrayList:iterator	()Ljava/util/Iterator;
        //   21: astore_1
        //   22: aload_1
        //   23: invokeinterface 133 1 0
        //   28: ifeq +150 -> 178
        //   31: aload_1
        //   32: invokeinterface 137 1 0
        //   37: checkcast 185	com/inmobi/monetization/internal/imai/db/ClickData
        //   40: astore_3
        //   41: new 238	android/content/ContentValues
        //   44: dup
        //   45: invokespecial 239	android/content/ContentValues:<init>	()V
        //   48: astore 4
        //   50: aload 4
        //   52: ldc 8
        //   54: aload_3
        //   55: invokevirtual 301	com/inmobi/monetization/internal/imai/db/ClickData:getClickId	()J
        //   58: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   61: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   64: aload 4
        //   66: ldc 11
        //   68: aload_3
        //   69: invokevirtual 252	com/inmobi/monetization/internal/imai/db/ClickData:getClickUrl	()Ljava/lang/String;
        //   72: invokevirtual 255	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
        //   75: aload 4
        //   77: ldc 14
        //   79: aload_3
        //   80: invokevirtual 280	com/inmobi/monetization/internal/imai/db/ClickData:isFollowRedirects	()Z
        //   83: invokestatic 263	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   86: invokevirtual 266	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
        //   89: aload 4
        //   91: ldc 17
        //   93: aload_3
        //   94: invokevirtual 258	com/inmobi/monetization/internal/imai/db/ClickData:isPingWv	()Z
        //   97: invokestatic 263	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   100: invokevirtual 266	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
        //   103: aload 4
        //   105: ldc 20
        //   107: aload_3
        //   108: invokevirtual 269	com/inmobi/monetization/internal/imai/db/ClickData:getRetryCount	()I
        //   111: iconst_1
        //   112: iadd
        //   113: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   116: invokevirtual 277	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
        //   119: aload 4
        //   121: ldc 23
        //   123: aload_3
        //   124: invokevirtual 242	com/inmobi/monetization/internal/imai/db/ClickData:getTimestamp	()J
        //   127: invokestatic 246	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   130: invokevirtual 249	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
        //   133: aload_0
        //   134: ldc 26
        //   136: aload 4
        //   138: ldc_w 303
        //   141: iconst_1
        //   142: anewarray 305	java/lang/String
        //   145: dup
        //   146: iconst_0
        //   147: aload_3
        //   148: invokevirtual 301	com/inmobi/monetization/internal/imai/db/ClickData:getClickId	()J
        //   151: invokestatic 308	java/lang/String:valueOf	(J)Ljava/lang/String;
        //   154: aastore
        //   155: invokevirtual 312	com/inmobi/monetization/internal/imai/db/ClickDatabaseManager:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)J
        //   158: pop2
        //   159: goto -137 -> 22
        //   162: astore_1
        //   163: ldc 107
        //   165: ldc_w 314
        //   168: aload_1
        //   169: invokestatic 115	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   172: iconst_0
        //   173: istore_2
        //   174: aload_0
        //   175: monitorexit
        //   176: iload_2
        //   177: ireturn
        //   178: aload_0
        //   179: invokevirtual 168	com/inmobi/monetization/internal/imai/db/ClickDatabaseManager:close	()V
        //   182: iconst_1
        //   183: istore_2
        //   184: goto -10 -> 174
        //   187: iconst_0
        //   188: istore_2
        //   189: goto -15 -> 174
        //   192: astore_1
        //   193: aload_0
        //   194: monitorexit
        //   195: aload_1
        //   196: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	197	0	this	ClickDatabaseManager
        //   0	197	1	paramArrayList	ArrayList<ClickData>
        //   173	16	2	bool	boolean
        //   40	108	3	localClickData	ClickData
        //   48	89	4	localContentValues	ContentValues
        // Exception table:
        //   from	to	target	type
        //   6	22	162	java/lang/Exception
        //   22	159	162	java/lang/Exception
        //   178	182	162	java/lang/Exception
        //   6	22	192	finally
        //   22	159	192	finally
        //   163	172	192	finally
        //   178	182	192	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/db/ClickDatabaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */