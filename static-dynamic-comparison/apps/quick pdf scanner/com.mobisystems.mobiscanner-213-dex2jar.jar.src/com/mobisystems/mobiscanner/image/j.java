package com.mobisystems.mobiscanner.image;

import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.photoimageview.e;

public class j
  extends e
{
  private boolean aIA;
  private int aIz;
  private final c mLog;
  
  private void In()
  {
    try
    {
      if ((this.aIz <= 0) && (this.aIA))
      {
        this.mLog.dl("No longer being used or cached so recycling. ");
        KH();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void bp(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.aIz += 1;
        this.aIA = true;
        In();
        return;
      }
      finally {}
      this.aIz -= 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */