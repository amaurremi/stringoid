package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;

public class FilterRender
{
  private final SparseArray a;
  private Context b;
  
  protected FilterRender(Context paramContext)
  {
    this.b = paramContext;
    this.a = new SparseArray();
  }
  
  private AbsFilterHandler a(int paramInt)
  {
    AbsFilterHandler localAbsFilterHandler = (AbsFilterHandler)this.a.get(paramInt);
    Object localObject = localAbsFilterHandler;
    if (localAbsFilterHandler == null)
    {
      if (!OriginalHandler.canHandle(paramInt)) {
        break label44;
      }
      localObject = new OriginalHandler();
    }
    for (;;)
    {
      this.a.append(paramInt, localObject);
      return (AbsFilterHandler)localObject;
      label44:
      if (ClothHandler.canHandle(paramInt))
      {
        localObject = new ClothHandler();
      }
      else if (BlackWhiteHandler.canHandle(paramInt))
      {
        localObject = new BlackWhiteHandler();
      }
      else if (ColorToneHandler.canHandle(paramInt))
      {
        localObject = new ColorToneHandler();
      }
      else if (SunshineHandler.canHandle(paramInt))
      {
        localObject = new SunshineHandler();
      }
      else if (SketchHandler.canHandle(paramInt))
      {
        localObject = new SketchHandler();
      }
      else if (CloudyHandler.canHandle(paramInt))
      {
        localObject = new CloudyHandler();
      }
      else if (GaussianBlurHandler.canHandle(paramInt))
      {
        localObject = new GaussianBlurHandler();
      }
      else if (BrightcontrastHandler.canHandle(paramInt))
      {
        localObject = new BrightcontrastHandler();
      }
      else if (NeonHandler.canHandle(paramInt))
      {
        localObject = new NeonHandler();
      }
      else if (MilkHandler.canHandle(paramInt))
      {
        localObject = new MilkHandler(this.b);
      }
      else if (SunriseHandler.canHandle(paramInt))
      {
        localObject = new SunriseHandler(this.b);
      }
      else if (SunSetHandler.canHandle(paramInt))
      {
        localObject = new SunSetHandler(this.b);
      }
      else
      {
        if (!FilmHandler.canHandle(paramInt)) {
          break;
        }
        localObject = new FilmHandler(this.b);
      }
    }
    throw new IllegalAccessError("AbsFilterHandler：Is typeId=" + paramInt + " a new type?");
  }
  
  public void cleanUp()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public Bitmap render(FilterParameter paramFilterParameter)
  {
    if (paramFilterParameter == null) {}
    AbsFilterHandler localAbsFilterHandler;
    do
    {
      return null;
      localAbsFilterHandler = a(paramFilterParameter.getTypeId());
    } while (localAbsFilterHandler == null);
    return localAbsFilterHandler.handler(paramFilterParameter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/FilterRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */