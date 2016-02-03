package com.inmobi.re.controller;

import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;

class d
  implements AudioTriggerCallback
{
  d(JSUtilityController paramJSUtilityController) {}
  
  public void audioLevel(double paramDouble)
  {
    this.a.imWebView.raiseMicEvent(paramDouble);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/controller/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */