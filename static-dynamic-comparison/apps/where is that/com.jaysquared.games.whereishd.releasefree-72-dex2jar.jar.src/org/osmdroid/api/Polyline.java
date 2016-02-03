package org.osmdroid.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline
{
  public int color = -16777216;
  public List<IGeoPoint> points = new ArrayList();
  public float width = 2.0F;
  
  public Polyline color(int paramInt)
  {
    this.color = paramInt;
    return this;
  }
  
  public Polyline points(List<IGeoPoint> paramList)
  {
    this.points = paramList;
    return this;
  }
  
  public Polyline points(IGeoPoint... paramVarArgs)
  {
    return points(Arrays.asList(paramVarArgs));
  }
  
  public Polyline width(float paramFloat)
  {
    this.width = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/api/Polyline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */