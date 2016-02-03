package com.inmobi.commons.analytics.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AnalyticsDatabaseManager {
    private static AnalyticsDatabaseManager c;
    private static final String[] d = {"_id", "eventid", "type", "sid", "ts", "ssts", "am"};
    private static final String[] e = {"_id", "levelid", "levelname"};
    private static final String[] f = {"_id", "levelid", "levelname", "levelstatus", "timetaken", "attemptcount", "attempttime"};
    private static final String[] g = {"_id", "eventname"};
    private static final String[] h = {"_id", "attributename", "attributevalue"};
    private static final String[] i = {"_id", "levelid", "begintime", "totalcount", "totaltime"};
    private static final String[] j = {"_id", "itemName", "itemType", "itemCount", "itemDescription", "itemPrice", "currencyCode", "productId", "transactionId", "transactionStatus"};
    private AnalyticsSQLiteHelper a;
    private SQLiteDatabase b;

    private AnalyticsEvent a(Cursor paramCursor) {
        Object localObject = null;
        AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent(paramCursor.getString(2));
        localAnalyticsEvent.setEventSessionId(paramCursor.getString(3));
        localAnalyticsEvent.setEventId(paramCursor.getLong(0));
        localAnalyticsEvent.setEventTimeStamp(paramCursor.getLong(4));
        localAnalyticsEvent.setEventSessionTimeStamp(paramCursor.getLong(5));
        localAnalyticsEvent.setEventAttributeMap(paramCursor.getString(6));
        long l = paramCursor.getLong(1);
        String str = Long.toString(l);
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Analytics]-4.5.1", "IMAppDatabaseManager->" + localAnalyticsEvent.getEventType() + "-" + l);
        if (l > -1L) {
            if (!localAnalyticsEvent.getEventType().equals("lb")) {
                break label223;
            }
            paramCursor = this.b.query("levelbegin", e, "_id = ?", new String[]{str}, null, null, null);
            paramCursor.moveToFirst();
            localAnalyticsEvent.setEventLevelId(paramCursor.getString(1));
            localAnalyticsEvent.setEventLevelName(paramCursor.getString(2));
        }
        for (; ; ) {
            if (paramCursor != null) {
                paramCursor.close();
            }
            return localAnalyticsEvent;
            label223:
            if (localAnalyticsEvent.getEventType().equals("le")) {
                paramCursor = this.b.query("levelend", f, "_id = ?", new String[]{str}, null, null, null);
                paramCursor.moveToFirst();
                localAnalyticsEvent.setEventLevelId(paramCursor.getString(1));
                localAnalyticsEvent.setEventLevelName(paramCursor.getString(2));
                localAnalyticsEvent.setEventLevelStatus(paramCursor.getString(3));
                localAnalyticsEvent.setEventTimeTaken(paramCursor.getString(4));
                localAnalyticsEvent.setEventAttemptCount(paramCursor.getString(5));
                localAnalyticsEvent.setEventAttemptTime(paramCursor.getString(6));
            } else if (localAnalyticsEvent.getEventType().equals("ce")) {
                paramCursor = this.b.query("customevent", g, "_id = ?", new String[]{str}, null, null, null);
                paramCursor.moveToFirst();
                localAnalyticsEvent.setEventCustomName(paramCursor.getString(1));
            } else if (localAnalyticsEvent.getEventType().equals("ae")) {
                paramCursor = this.b.query("attribute", h, "_id = ?", new String[]{str}, null, null, null);
                paramCursor.moveToFirst();
                localAnalyticsEvent.setUserAttribute(paramCursor.getString(1), paramCursor.getString(2));
            } else {
                paramCursor = (Cursor) localObject;
                if (localAnalyticsEvent.getEventType().equals("pi")) {
                    paramCursor = this.b.query("transactiondetail", j, "_id = ?", new String[]{str}, null, null, null);
                    paramCursor.moveToFirst();
                    localAnalyticsEvent.setTransactionItemName(paramCursor.getString(1));
                    localAnalyticsEvent.setTransactionItemType(paramCursor.getInt(2));
                    localAnalyticsEvent.setTransactionItemCount(paramCursor.getInt(3));
                    localAnalyticsEvent.setTransactionItemDescription(paramCursor.getString(4));
                    localAnalyticsEvent.setTransactionItemPrice(paramCursor.getDouble(5));
                    localAnalyticsEvent.setTransactionCurrencyCode(paramCursor.getString(6));
                    localAnalyticsEvent.setTransactionProductId(paramCursor.getString(7));
                    localAnalyticsEvent.setTransactionId(paramCursor.getString(8));
                    localAnalyticsEvent.setTransactionStatus(paramCursor.getInt(9));
                }
            }
        }
    }

    private void a() {
        this.b = this.a.getWritableDatabase();
    }

    private void a(AnalyticsEvent paramAnalyticsEvent, long paramLong) {
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Analytics]-4.5.1", "IMAppDatabaseManager->insertEvents-" + paramAnalyticsEvent.getEventType());
        ContentValues localContentValues1;
        Object localObject;
        label294:
        Cursor localCursor;
        String str2;
        String str1;
        if (paramLong < AnalyticsUtils.getMaxdbcount()) {
            localContentValues1 = new ContentValues();
            paramLong = -1L;
            long l = paramAnalyticsEvent.getEventTimeStamp();
            if (paramAnalyticsEvent.getEventType().equals("lb")) {
                localObject = new ContentValues();
                ((ContentValues) localObject).put("begintime", Long.valueOf(l));
                if (this.b.update("attemptdata", (ContentValues) localObject, "levelid = ?", new String[]{paramAnalyticsEvent.getEventLevelId()}) <= 0) {
                    ((ContentValues) localObject).put("levelid", paramAnalyticsEvent.getEventLevelId());
                    ((ContentValues) localObject).put("totalcount", Integer.toString(0));
                    ((ContentValues) localObject).put("totaltime", Integer.toString(0));
                    this.b.insert("attemptdata", null, (ContentValues) localObject);
                }
                localContentValues1.put("levelid", paramAnalyticsEvent.getEventLevelId());
                localContentValues1.put("levelname", paramAnalyticsEvent.getEventLevelName());
                paramLong = this.b.insert("levelbegin", null, localContentValues1);
                localObject = new ContentValues();
                ((ContentValues) localObject).put("eventid", Long.valueOf(paramLong));
                ((ContentValues) localObject).put("type", paramAnalyticsEvent.getEventType());
                ((ContentValues) localObject).put("sid", paramAnalyticsEvent.getEventSessionId());
                ((ContentValues) localObject).put("ts", Long.valueOf(paramAnalyticsEvent.getEventTimeStamp()));
                ((ContentValues) localObject).put("ssts", Long.valueOf(paramAnalyticsEvent.getEventSessionTimeStamp()));
                ((ContentValues) localObject).put("am", paramAnalyticsEvent.getEventAttributeMap());
                this.b.insert("eventlist", null, (ContentValues) localObject);
                if ((!AnalyticsUtils.getStartHandle()) && (AnalyticsNetworkManager.getHandler() != null)) {
                    AnalyticsUtils.setStartHandle(true);
                    AnalyticsNetworkManager.getHandler().sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
                }
                return;
            }
            if (paramAnalyticsEvent.getEventType().equals("le")) {
                localCursor = this.b.query("attemptdata", i, "levelid = ?", new String[]{paramAnalyticsEvent.getEventLevelId()}, null, null, null, "1");
                if (localCursor.getCount() <= 0) {
                    break label861;
                }
                localCursor.moveToFirst();
                paramLong = l - Long.parseLong(localCursor.getString(2));
                str2 = Long.toString(paramLong);
                localObject = Long.toString(paramLong + Long.parseLong(localCursor.getString(4)));
                str1 = Integer.toString(Integer.parseInt(localCursor.getString(3)) + 1);
                ContentValues localContentValues2 = new ContentValues();
                localContentValues2.put("totalcount", str1);
                localContentValues2.put("totaltime", (String) localObject);
                this.b.update("attemptdata", localContentValues2, "levelid = ?", new String[]{paramAnalyticsEvent.getEventLevelId()});
            }
        }
        for (; ; ) {
            localCursor.close();
            localContentValues1.put("levelid", paramAnalyticsEvent.getEventLevelId());
            localContentValues1.put("levelstatus", paramAnalyticsEvent.getEventLevelStatus());
            localContentValues1.put("levelname", paramAnalyticsEvent.getEventLevelName());
            localContentValues1.put("timetaken", str2);
            localContentValues1.put("attemptcount", str1);
            localContentValues1.put("attempttime", (String) localObject);
            paramLong = this.b.insert("levelend", null, localContentValues1);
            break;
            if (paramAnalyticsEvent.getEventType().equals("pi")) {
                localContentValues1.put("itemName", paramAnalyticsEvent.getTransactionItemName());
                int k = paramAnalyticsEvent.getTransactionItemType();
                if (AnalyticsEvent.TRANSACTION_ITEM_TYPE.INVALID.getValue() != k) {
                    localContentValues1.put("itemType", Integer.valueOf(k));
                }
                k = paramAnalyticsEvent.getTransactionItemCount();
                if (k > 0) {
                    localContentValues1.put("itemCount", Integer.valueOf(k));
                }
                localContentValues1.put("itemDescription", paramAnalyticsEvent.getTransactionItemDescription());
                localContentValues1.put("itemPrice", Double.valueOf(paramAnalyticsEvent.getTransactionItemPrice()));
                localContentValues1.put("currencyCode", paramAnalyticsEvent.getTransactionCurrencyCode());
                localContentValues1.put("productId", paramAnalyticsEvent.getTransactionProductId());
                localContentValues1.put("transactionId", paramAnalyticsEvent.getTransactionId());
                k = paramAnalyticsEvent.getTransactionStatus();
                if (AnalyticsEvent.TRANSACTION_STATUS_SERVER_CODE.INVALID.getValue() != k) {
                    localContentValues1.put("transactionStatus", Integer.valueOf(k));
                }
                paramLong = this.b.insert("transactiondetail", null, localContentValues1);
                break;
            }
            if (paramAnalyticsEvent.getEventType().equals("ce")) {
                localContentValues1.put("eventname", paramAnalyticsEvent.getEventCustomName());
                paramLong = this.b.insert("customevent", null, localContentValues1);
                break;
            }
            if (!paramAnalyticsEvent.getEventType().equals("ae")) {
                break;
            }
            localContentValues1.put("attributename", paramAnalyticsEvent.getAttributeName());
            localContentValues1.put("attributevalue", paramAnalyticsEvent.getAttributeValue());
            paramLong = this.b.insert("attribute", null, localContentValues1);
            break;
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Analytics]-4.5.1", "Database full");
            break label294;
            label861:
            localObject = "0";
            str1 = "0";
            str2 = "0";
        }
    }

    private void a(List<Long> paramList) {
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Analytics]-4.5.1", "IMAppDatabaseManager->deleteEvents");
        paramList = paramList.iterator();
        if (paramList.hasNext()) {
            String str1 = ((Long) paramList.next()).toString();
            Cursor localCursor = this.b.query("eventlist", d, "_id=?", new String[]{str1}, null, null, null, "1");
            localCursor.moveToFirst();
            Long localLong = Long.valueOf(localCursor.getLong(1));
            String str2 = localLong.toString();
            String str3 = localCursor.getString(2);
            if (localLong.longValue() > -1L) {
                if (!str3.equals("lb")) {
                    break label176;
                }
                this.b.delete("levelbegin", "_id = ?", new String[]{str2});
            }
            for (; ; ) {
                localCursor.close();
                this.b.delete("eventlist", "_id = ?", new String[]{str1});
                break;
                label176:
                if (str3.equals("le")) {
                    this.b.delete("levelend", "_id = ?", new String[]{str2});
                } else if (str3.equals("ce")) {
                    this.b.delete("customevent", "_id = ?", new String[]{str2});
                } else if (str3.equals("ae")) {
                    this.b.delete("attribute", "_id = ?", new String[]{str2});
                } else if (str3.equals("pi")) {
                    this.b.delete("transactiondetail", "_id = ?", new String[]{str2});
                }
            }
        }
    }

    private void b() {
        this.a.close();
    }

    private List<AnalyticsEvent> c() {
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Analytics]-4.5.1", "IMAppDatabaseManager->getEvents");
        ArrayList localArrayList = new ArrayList();
        if (!this.b.isOpen()) {
            android.util.Log.v("[InMobi]-[Analytics]-4.5.1", "IMAppDatabaseManager->getEvents()-database is not open");
            return localArrayList;
        }
        Cursor localCursor = this.b.query("eventlist", d, null, null, null, null, null, AnalyticsUtils.getMaxevents());
        localCursor.moveToFirst();
        while (!localCursor.isAfterLast()) {
            AnalyticsEvent localAnalyticsEvent = a(localCursor);
            localAnalyticsEvent.setEventTableId(localCursor.getLong(0));
            localArrayList.add(localAnalyticsEvent);
            localCursor.moveToNext();
        }
        localCursor.close();
        return localArrayList;
    }

    public static AnalyticsDatabaseManager getInstance() {
        try {
            if (c == null) {
                c = new AnalyticsDatabaseManager();
                localObject1 = InternalSDKUtil.getContext().getDatabasePath("appengage.db");
                if (((File) localObject1).isFile()) {
                    ((File) localObject1).renameTo(InternalSDKUtil.getContext().getDatabasePath("ltvp.db"));
                    SessionInfo.updatedFromOldSDK(InternalSDKUtil.getContext());
                }
                c.a = new AnalyticsSQLiteHelper(InternalSDKUtil.getContext());
            }
            Object localObject1 = c;
            return (AnalyticsDatabaseManager) localObject1;
        } finally {
        }
    }

    public void deleteEvents(List<Long> paramList) {
        try {
            a();
            a(paramList);
            b();
            return;
        } catch (Exception paramList) {
            for (; ; ) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[Analytics]-4.5.1", "Error deleting from DB.");
            }
        } finally {
        }
    }

    public List<AnalyticsEvent> getEvents() {
        try {
            a();
            List localList = c();
            b();
            return localList;
        } catch (Exception localException) {
            for (; ; ) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[Analytics]-4.5.1", "Error reading events from DB.");
                ArrayList localArrayList = new ArrayList();
            }
        } finally {
        }
    }

    public void insertEvents(AnalyticsEvent paramAnalyticsEvent) {
        try {
            a();
            a(paramAnalyticsEvent, this.b.compileStatement("SELECT COUNT(*) FROM eventlist").simpleQueryForLong());
            b();
            return;
        } catch (Exception paramAnalyticsEvent) {
            for (; ; ) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[Analytics]-4.5.1", "Error in inserting into DB.", paramAnalyticsEvent);
                paramAnalyticsEvent.printStackTrace();
            }
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsDatabaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */