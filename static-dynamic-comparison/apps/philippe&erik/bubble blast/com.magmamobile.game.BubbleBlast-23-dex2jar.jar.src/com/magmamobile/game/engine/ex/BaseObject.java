package com.magmamobile.game.engine.ex;

import com.magmamobile.game.engine.IGameEvents;

public class BaseObject
  implements IGameEvents
{
  public boolean enabled;
  public boolean visible;
  
  public boolean hide()
  {
    this.visible = false;
    return true;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public boolean isVisible()
  {
    return this.visible;
  }
  
  public void onAction() {}
  
  public void onRender() {}
  
  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
  
  public boolean show()
  {
    this.visible = true;
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ex/BaseObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */