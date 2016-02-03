package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class ao
{
  private static MessageDigest nI = null;
  protected Object mw = new Object();
  
  protected MessageDigest ba()
  {
    for (;;)
    {
      MessageDigest localMessageDigest;
      int i;
      synchronized (this.mw)
      {
        if (nI != null)
        {
          localMessageDigest = nI;
          return localMessageDigest;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        nI = MessageDigest.getInstance("MD5");
        i += 1;
        continue;
        localMessageDigest = nI;
        return localMessageDigest;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
  
  abstract byte[] l(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */