package com.jirbo.adcolony;

abstract class ADCEvent
{
  ADCController controller;
  
  ADCEvent(ADCController paramADCController)
  {
    this(paramADCController, true);
  }
  
  ADCEvent(ADCController paramADCController, boolean paramBoolean)
  {
    this.controller = paramADCController;
    if (paramBoolean) {
      paramADCController.queue_event(this);
    }
  }
  
  abstract void dispatch();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */