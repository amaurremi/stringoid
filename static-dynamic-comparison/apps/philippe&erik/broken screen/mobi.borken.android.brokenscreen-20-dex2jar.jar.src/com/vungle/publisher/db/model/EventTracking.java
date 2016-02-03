package com.vungle.publisher.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.vungle.publisher.ar;
import com.vungle.publisher.ar.a;
import com.vungle.publisher.cl;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.message.RequestAdResponse.ThirdPartyAdTracking;
import com.vungle.publisher.protocol.message.RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class EventTracking
  extends ar<Integer>
{
  String a;
  a b;
  String c;
  @Inject
  Factory d;
  
  protected final ContentValues a(boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", (Integer)this.n);
    localContentValues.put("ad_id", this.a);
    localContentValues.put("event", this.b.toString());
    localContentValues.put("url", this.c);
    return localContentValues;
  }
  
  protected final String b()
  {
    return "event_tracking";
  }
  
  public final StringBuilder n()
  {
    StringBuilder localStringBuilder = super.n();
    cl.a(localStringBuilder, "ad_id", this.a);
    cl.a(localStringBuilder, "event", this.b);
    cl.a(localStringBuilder, "url", this.c);
    return localStringBuilder;
  }
  
  @Singleton
  static class Factory
    extends ar.a<EventTracking, Integer>
  {
    @Inject
    Provider<EventTracking> a;
    
    private EventTracking a()
    {
      return (EventTracking)this.a.get();
    }
    
    private void a(String paramString, Map<EventTracking.a, List<EventTracking>> paramMap, EventTracking.a parama, String[] paramArrayOfString)
    {
      ArrayList localArrayList;
      EventTracking localEventTracking;
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      {
        if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
          break label173;
        }
        localArrayList = new ArrayList();
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramArrayOfString[i];
          if ((parama == null) || (str == null)) {
            break label167;
          }
          localEventTracking = (EventTracking)this.a.get();
          localEventTracking.a = paramString;
          localEventTracking.b = parama;
          localEventTracking.c = str;
          if (localEventTracking != null) {
            localArrayList.add(localEventTracking);
          }
          i += 1;
        }
      }
      label167:
      label173:
      for (paramString = localArrayList;; paramString = null)
      {
        if (paramString != null)
        {
          paramArrayOfString = paramString;
          if (!paramString.isEmpty()) {}
        }
        else
        {
          paramArrayOfString = null;
        }
        if ((paramArrayOfString != null) && (!paramArrayOfString.isEmpty())) {
          paramMap.put(parama, paramArrayOfString);
        }
        return;
        localEventTracking = null;
        break;
      }
    }
    
    static void a(Map<EventTracking.a, List<EventTracking>> paramMap)
    {
      if (paramMap != null)
      {
        paramMap = paramMap.values().iterator();
        while (paramMap.hasNext())
        {
          Object localObject = (List)paramMap.next();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              ((EventTracking)((Iterator)localObject).next()).o();
            }
          }
        }
      }
    }
    
    final Map<EventTracking.a, List<EventTracking>> a(String paramString, RequestAdResponse.ThirdPartyAdTracking paramThirdPartyAdTracking)
    {
      if (paramThirdPartyAdTracking != null)
      {
        HashMap localHashMap = new HashMap();
        a(paramString, localHashMap, EventTracking.a.a, paramThirdPartyAdTracking.f());
        a(paramString, localHashMap, EventTracking.a.b, paramThirdPartyAdTracking.g());
        RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint[] arrayOfPlayCheckpoint = paramThirdPartyAdTracking.i();
        if ((arrayOfPlayCheckpoint != null) && (arrayOfPlayCheckpoint.length > 0))
        {
          int j = arrayOfPlayCheckpoint.length;
          int i = 0;
          if (i < j)
          {
            RequestAdResponse.ThirdPartyAdTracking.PlayCheckpoint localPlayCheckpoint = arrayOfPlayCheckpoint[i];
            Object localObject = localPlayCheckpoint.a;
            float f;
            if (localObject != null)
            {
              f = ((Float)localObject).floatValue();
              if (f != 0.0F) {
                break label137;
              }
              localObject = EventTracking.a.c;
            }
            for (;;)
            {
              if (localObject != null) {
                a(paramString, localHashMap, (EventTracking.a)localObject, localPlayCheckpoint.b);
              }
              i += 1;
              break;
              label137:
              if (f == 0.25D)
              {
                localObject = EventTracking.a.d;
              }
              else if (f == 0.5D)
              {
                localObject = EventTracking.a.e;
              }
              else if (f == 0.75D)
              {
                localObject = EventTracking.a.f;
              }
              else if (f == 1.0F)
              {
                localObject = EventTracking.a.h;
              }
              else
              {
                Logger.w("VungleDatabase", "invalid play percent: " + f);
                localObject = null;
              }
            }
          }
        }
        a(paramString, localHashMap, EventTracking.a.i, paramThirdPartyAdTracking.c());
        a(paramString, localHashMap, EventTracking.a.j, paramThirdPartyAdTracking.j());
        a(paramString, localHashMap, EventTracking.a.l, paramThirdPartyAdTracking.d());
        a(paramString, localHashMap, EventTracking.a.m, paramThirdPartyAdTracking.e());
        a(paramString, localHashMap, EventTracking.a.n, paramThirdPartyAdTracking.h());
        a(paramString, localHashMap, EventTracking.a.o, paramThirdPartyAdTracking.k());
        a(paramString, localHashMap, EventTracking.a.k, paramThirdPartyAdTracking.l());
        return localHashMap;
      }
      return null;
    }
    
    final void a(String paramString)
    {
      int i = this.b.getWritableDatabase().delete("event_tracking", "ad_id = ?", new String[] { paramString });
      Logger.v("VungleDatabase", "deleted " + i + " expired event_tracking records for adId: " + paramString);
    }
    
    final Map<EventTracking.a, List<EventTracking>> b(String paramString)
    {
      Object localObject = null;
      if (paramString == null)
      {
        Logger.w("VungleDatabase", "failed to fetch event_tracking records by ad_id: " + paramString);
        localObject = null;
      }
      label234:
      do
      {
        return (Map<EventTracking.a, List<EventTracking>>)localObject;
        try
        {
          Logger.d("VungleDatabase", "fetching event_tracking records by ad_id: " + paramString);
          localCursor = this.b.getReadableDatabase().query("event_tracking", null, "ad_id = ?", new String[] { paramString }, null, null, null);
          try
          {
            int i = localCursor.getCount();
            Logger.v("VungleDatabase", i + " event_tracking for ad_id: " + paramString);
            if (i <= 0) {
              break;
            }
            localObject = new HashMap();
            while (localCursor.moveToNext())
            {
              EventTracking localEventTracking = a();
              b(localEventTracking, localCursor, false);
              if (localEventTracking != null)
              {
                EventTracking.a locala = localEventTracking.b;
                List localList = (List)((Map)localObject).get(locala);
                paramString = localList;
                if (localList == null)
                {
                  paramString = new ArrayList();
                  ((Map)localObject).put(locala, paramString);
                }
                paramString.add(localEventTracking);
              }
            }
            if (localObject == null) {
              break label234;
            }
          }
          finally
          {
            localObject = localCursor;
          }
        }
        finally
        {
          for (;;)
          {
            Cursor localCursor;
            continue;
            paramString = null;
          }
        }
        ((Cursor)localObject).close();
        throw paramString;
        paramString = (String)localObject;
        localObject = paramString;
      } while (localCursor == null);
      localCursor.close();
      return paramString;
    }
  }
  
  public static enum a
  {
    public final float p;
    
    private a()
    {
      this(-1.0F);
    }
    
    private a(float paramFloat)
    {
      this.p = paramFloat;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db/model/EventTracking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */