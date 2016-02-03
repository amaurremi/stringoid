package com.vungle.publisher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.service.SessionEventHandler;

public final class cg
  extends cc<SessionEventHandler>
{
  public cg(String paramString)
  {
    super(paramString);
  }
  
  private Message a(int paramInt, String paramString, Long paramLong1, Long paramLong2)
  {
    Message localMessage = ((SessionEventHandler)a()).obtainMessage(1);
    localMessage.arg1 = paramInt;
    localMessage.obj = paramString;
    paramString = new Bundle();
    if (paramLong1 != null) {
      paramString.putLong("sessionStartSeconds", paramLong1.longValue());
    }
    if (paramLong2 != null) {
      paramString.putLong("activityPauseSeconds", paramLong2.longValue());
    }
    localMessage.setData(paramString);
    return localMessage;
  }
  
  protected final void b(Intent paramIntent, int paramInt)
  {
    Long localLong2 = null;
    Long localLong1 = null;
    String str;
    for (;;)
    {
      try
      {
        str = paramIntent.getStringExtra("activityEvent");
        if (!"activityResume".equals(str)) {
          break;
        }
        if (!paramIntent.hasExtra("sessionStartSeconds")) {
          break label381;
        }
        paramIntent = Long.valueOf(paramIntent.getLongExtra("sessionStartSeconds", 0L));
        if (paramIntent == null)
        {
          Logger.d("VungleService", "queuing activityResume (session continuation)");
          a(a(paramInt, "activityResume", paramIntent, null));
          return;
        }
        if (paramIntent.longValue() <= 0L)
        {
          Logger.w("VungleService", "queuing activityResume (session continuation) - invalid session start seconds in intent: " + paramIntent);
          paramIntent = localLong1;
        }
        else
        {
          Logger.d("VungleService", "queuing activityResume (session start seconds: " + paramIntent + ")");
        }
      }
      catch (Exception paramIntent)
      {
        Logger.e("VungleService", this.a + ": error queuing message", paramIntent);
        return;
      }
    }
    if ("activityPause".equals(str)) {
      if (!paramIntent.hasExtra("sessionStartSeconds")) {
        break label386;
      }
    }
    label381:
    label386:
    for (localLong1 = Long.valueOf(paramIntent.getLongExtra("sessionStartSeconds", 0L));; localLong1 = null)
    {
      if (paramIntent.hasExtra("activityPauseSeconds")) {
        localLong2 = Long.valueOf(paramIntent.getLongExtra("activityPauseSeconds", 0L));
      }
      if (localLong1 == null)
      {
        Logger.w("VungleService", "null session start seconds - dropping activityPause intent");
        return;
      }
      if (localLong1.longValue() <= 0L)
      {
        Logger.w("VungleService", "invalid session start seconds: " + localLong1 + " - dropping activityPause intent");
        return;
      }
      if (localLong2 == null)
      {
        Logger.w("VungleService", "null activity pause seconds - dropping activityPause intent");
        return;
      }
      if (localLong2.longValue() <= 0L)
      {
        Logger.w("VungleService", "invalid activity pause seconds: " + localLong2 + " - dropping activityPause intent");
        return;
      }
      Logger.d("VungleService", "queuing activityPause (session start seconds: " + localLong1 + ", acitivty pause seconds: " + localLong2);
      b(a(paramInt, "activityPause", localLong1, localLong2));
      return;
      Logger.w("VungleService", "unknown activity event in intent: " + str);
      return;
      paramIntent = null;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */