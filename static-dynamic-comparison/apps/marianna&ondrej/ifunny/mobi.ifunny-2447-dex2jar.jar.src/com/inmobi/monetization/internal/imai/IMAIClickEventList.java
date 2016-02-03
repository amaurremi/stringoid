package com.inmobi.monetization.internal.imai;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.db.ClickData;
import com.inmobi.monetization.internal.imai.db.ClickDatabaseManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class IMAIClickEventList
        extends ArrayList<ClickData> {
    private static final long serialVersionUID = -211778664111073467L;

    public static IMAIClickEventList getLoggedClickEvents() {
        IMAIClickEventList localIMAIClickEventList1 = null;
        try {
            if (ClickDatabaseManager.getInstance().getNoOfEvents() != 0) {
                int i = Initializer.getConfigParams().getImai().getmDefaultEventsBatch();
                ClickDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getImai().getmMaxDb());
                localIMAIClickEventList1 = ClickDatabaseManager.getInstance().getClickEvents(i);
                ArrayList localArrayList = new ArrayList();
                Iterator localIterator = localIMAIClickEventList1.iterator();
                while (localIterator.hasNext()) {
                    localArrayList.add(Long.valueOf(((ClickData) localIterator.next()).getClickId()));
                }
                ClickDatabaseManager.getInstance().deleteClickEvents(localArrayList);
            }
        } finally {
        }
        if (localIMAIClickEventList2 != null) {
        }
        for (; ; ) {
            return localIMAIClickEventList2;
            IMAIClickEventList localIMAIClickEventList3 = new IMAIClickEventList();
        }
    }

    public ClickData getClickEvent(long paramLong) {
        try {
            Iterator localIterator = iterator();
            while (localIterator.hasNext()) {
                ClickData localClickData = (ClickData) localIterator.next();
                long l = localClickData.getClickId();
                if (l == paramLong) {
                    return localClickData;
                }
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Monetization]", "Cant get click event", localException);
            return null;
        }
        return null;
    }

    public void reduceRetryCount(int paramInt) {
        try {
            RequestResponseManager.isSynced.set(false);
            ClickData localClickData = getClickEvent(paramInt);
            int i = localClickData.getRetryCount();
            removeClickEvent(paramInt);
            if (i > 1) {
                localClickData.setRetryCount(localClickData.getRetryCount() - 1);
                add(localClickData);
            }
        } catch (Exception localException) {
            for (; ; ) {
                Log.internal("[InMobi]-[Monetization]", "Cant reduce retry count", localException);
            }
        } finally {
        }
    }

    public boolean removeClickEvent(long paramLong) {
        boolean bool = false;
        try {
            RequestResponseManager.isSynced.set(false);
            remove(getClickEvent(paramLong));
            bool = true;
        } catch (Exception localException) {
            for (; ; ) {
                Log.internal("[InMobi]-[Monetization]", "Cant remove click event", localException);
            }
        } finally {
        }
        return bool;
    }

    public void saveClickEvents() {
        Log.internal("[InMobi]-[Monetization]", "Save ping events");
        if ((RequestResponseManager.mDBWriterQueue != null) && (!RequestResponseManager.mDBWriterQueue.isEmpty())) {
            Iterator localIterator = RequestResponseManager.mDBWriterQueue.iterator();
            while (localIterator.hasNext()) {
                ClickData localClickData = (ClickData) localIterator.next();
                ClickDatabaseManager.getInstance().insertClick(localClickData);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/IMAIClickEventList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */