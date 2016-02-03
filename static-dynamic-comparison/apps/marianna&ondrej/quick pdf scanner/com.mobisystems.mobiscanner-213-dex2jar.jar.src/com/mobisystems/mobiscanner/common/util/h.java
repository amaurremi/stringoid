package com.mobisystems.mobiscanner.common.util;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
  implements Comparable<h>
{
  private List<Point> axA;
  private ArrayList<b> axB;
  private int axC;
  
  public h(h paramh)
  {
    Object localObject;
    if (paramh.axB != null)
    {
      this.axB = new ArrayList(paramh.axB.size());
      localObject = paramh.axB.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        this.axB.add(new b(localb));
      }
    }
    this.axB = null;
    this.axA = new ArrayList(paramh.vh().size());
    paramh = paramh.vh().iterator();
    while (paramh.hasNext())
    {
      localObject = (Point)paramh.next();
      this.axA.add(new Point((Point)localObject));
    }
    init();
  }
  
  public h(ArrayList<b> paramArrayList, List<Point> paramList)
  {
    this.axA = paramList;
    this.axB = paramArrayList;
    init();
  }
  
  private void init()
  {
    int i = ((Point)this.axA.get(2)).x;
    int j = ((Point)this.axA.get(0)).x;
    this.axC = Math.abs((((Point)this.axA.get(2)).y - ((Point)this.axA.get(0)).y) * (i - j));
  }
  
  public int Ea()
  {
    return this.axC;
  }
  
  public double Eb()
  {
    Iterator localIterator = this.axB.iterator();
    for (double d = 0.0D; localIterator.hasNext(); d += ((b)localIterator.next()).DK()) {}
    return d;
  }
  
  public int a(h paramh)
  {
    return (int)Math.signum(Eb() - paramh.Eb());
  }
  
  public List<Point> vh()
  {
    return this.axA;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */