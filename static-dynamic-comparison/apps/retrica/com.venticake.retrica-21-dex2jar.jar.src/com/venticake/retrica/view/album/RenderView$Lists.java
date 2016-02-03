package com.venticake.retrica.view.album;

import java.util.ArrayList;

public final class RenderView$Lists
{
  public final ArrayList<Layer> blendedList = new ArrayList();
  public final ArrayList<Layer> hitTestList = new ArrayList();
  public final ArrayList<Layer> opaqueList = new ArrayList();
  public final ArrayList<Layer> systemList = new ArrayList();
  public final ArrayList<Layer> updateList = new ArrayList();
  
  void clear()
  {
    this.updateList.clear();
    this.opaqueList.clear();
    this.blendedList.clear();
    this.hitTestList.clear();
    this.systemList.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/RenderView$Lists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */