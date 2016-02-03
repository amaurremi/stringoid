package com.inmobi.androidsdk.impl.imai;

import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class IMAIClickEventList
  extends ArrayList<IMAIClickEvent>
{
  private static final long serialVersionUID = -211778664111073467L;
  
  /* Error */
  public static IMAIClickEventList getLoggedClickEvents()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore_0
    //   5: invokestatic 22	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   8: ldc 24
    //   10: invokestatic 30	com/inmobi/commons/internal/FileOperations:isFileExist	(Landroid/content/Context;Ljava/lang/String;)Z
    //   13: ifeq +15 -> 28
    //   16: invokestatic 22	com/inmobi/commons/internal/InternalSDKUtil:getContext	()Landroid/content/Context;
    //   19: ldc 24
    //   21: invokestatic 34	com/inmobi/commons/internal/FileOperations:readFromFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 2	com/inmobi/androidsdk/impl/imai/IMAIClickEventList
    //   27: astore_0
    //   28: aload_0
    //   29: ifnull +8 -> 37
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: new 2	com/inmobi/androidsdk/impl/imai/IMAIClickEventList
    //   40: dup
    //   41: invokespecial 35	com/inmobi/androidsdk/impl/imai/IMAIClickEventList:<init>	()V
    //   44: astore_0
    //   45: goto -13 -> 32
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   4	41	0	localIMAIClickEventList	IMAIClickEventList
    //   48	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	28	48	finally
    //   37	45	48	finally
  }
  
  public boolean addClickEvent(String paramString, boolean paramBoolean1, boolean paramBoolean2, WeakReference<IMWebView> paramWeakReference)
  {
    try
    {
      RequestResponseManager.isSynced.set(false);
      add(new IMAIClickEvent(paramString, paramBoolean1, paramBoolean2, paramWeakReference, true, 0));
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public IMAIClickEvent getClickEvent(int paramInt)
  {
    try
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext())
      {
        IMAIClickEvent localIMAIClickEvent = (IMAIClickEvent)localIterator.next();
        int i = localIMAIClickEvent.getClickId();
        if (i == paramInt) {
          return localIMAIClickEvent;
        }
      }
    }
    catch (Exception localException)
    {
      Log.internal("InMobiAndroidSDK_3.7.1", "Cant get click event", localException);
      return null;
    }
    return null;
  }
  
  public void reduceRetryCount(int paramInt)
  {
    try
    {
      RequestResponseManager.isSynced.set(false);
      IMAIClickEvent localIMAIClickEvent = getClickEvent(paramInt);
      int i = localIMAIClickEvent.getRetryCount();
      removeClickEvent(paramInt);
      if (i > 1)
      {
        localIMAIClickEvent.setFirstClick(false);
        localIMAIClickEvent.setRetryCount(localIMAIClickEvent.getRetryCount() - 1);
        add(localIMAIClickEvent);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.internal("InMobiAndroidSDK_3.7.1", "Cant reduce retry count", localException);
      }
    }
    finally {}
  }
  
  public boolean removeClickEvent(int paramInt)
  {
    boolean bool = false;
    try
    {
      RequestResponseManager.isSynced.set(false);
      remove(getClickEvent(paramInt));
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.internal("InMobiAndroidSDK_3.7.1", "Cant remove click event", localException);
      }
    }
    finally {}
    return bool;
  }
  
  public void resetFirstClick(int paramInt)
  {
    try
    {
      RequestResponseManager.isSynced.set(false);
      IMAIClickEvent localIMAIClickEvent = getClickEvent(paramInt);
      removeClickEvent(paramInt);
      localIMAIClickEvent.setFirstClick(false);
      add(localIMAIClickEvent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.internal("InMobiAndroidSDK_3.7.1", "Cant reset first click flag", localException);
      }
    }
    finally {}
  }
  
  public void saveClickEvents()
  {
    Log.internal("InMobiAndroidSDK_3.7.1", "Save ping events");
    FileOperations.saveToFile(InternalSDKUtil.getContext(), "imai_click_events", this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/imai/IMAIClickEventList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */