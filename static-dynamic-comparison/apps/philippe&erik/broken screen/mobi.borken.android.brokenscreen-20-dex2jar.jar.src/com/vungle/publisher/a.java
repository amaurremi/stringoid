package com.vungle.publisher;

import java.util.ArrayList;

public abstract class a
  implements Cloneable
{
  ArrayList a = null;
  
  public void a() {}
  
  public void b() {}
  
  public a c()
  {
    try
    {
      a locala = (a)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        locala.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          locala.a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */