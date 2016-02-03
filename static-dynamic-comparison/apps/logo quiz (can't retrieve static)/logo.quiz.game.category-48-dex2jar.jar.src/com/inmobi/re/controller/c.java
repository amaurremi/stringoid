package com.inmobi.re.controller;

import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;

class c
  implements AudioTriggerCallback
{
  c(JSUtilityController paramJSUtilityController) {}
  
  public void audioLevel(double paramDouble)
  {
    this.a.imWebView.raiseMicEvent(paramDouble);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/re/controller/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */