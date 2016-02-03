package com.jirbo.adcolony;

import java.util.ArrayList;

class ADCZoneStateManager
{
  ADCController controller;
  ArrayList<ADCZoneState> data = new ArrayList();
  boolean modified = false;
  
  ADCZoneStateManager(ADCController paramADCController)
  {
    this.controller = paramADCController;
  }
  
  int count()
  {
    return this.data.size();
  }
  
  ADCZoneState find(String paramString)
  {
    int j = this.data.size();
    int i = 0;
    while (i < j)
    {
      ADCZoneState localADCZoneState = (ADCZoneState)this.data.get(i);
      if (localADCZoneState.uuid.equals(paramString)) {
        return localADCZoneState;
      }
      i += 1;
    }
    this.modified = true;
    paramString = new ADCZoneState(paramString);
    this.data.add(paramString);
    return paramString;
  }
  
  ADCZoneState get(int paramInt)
  {
    return (ADCZoneState)this.data.get(paramInt);
  }
  
  void load()
  {
    Object localObject = ADCJSON.load_List(new ADCDataFile("zone_state.txt"));
    if (localObject != null)
    {
      this.data.clear();
      i = 0;
      while (i < ((ADCData.List)localObject).count())
      {
        ADCData.Table localTable = ((ADCData.List)localObject).get_Table(i);
        ADCZoneState localADCZoneState = new ADCZoneState();
        if (localADCZoneState.parse(localTable)) {
          this.data.add(localADCZoneState);
        }
        i += 1;
      }
    }
    localObject = this.controller.configuration.zone_ids;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      find(localObject[i]);
      i += 1;
    }
  }
  
  void save()
  {
    ADCLog.dev.println("Saving zone state...");
    this.modified = false;
    ADCData.List localList = new ADCData.List();
    String[] arrayOfString = this.controller.configuration.zone_ids;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localList.add(find(arrayOfString[i]).to_Table());
      i += 1;
    }
    ADCJSON.save(new ADCDataFile("zone_state.txt"), localList);
    ADCLog.dev.println("Saved zone state");
  }
  
  void update()
  {
    if (this.modified) {
      save();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCZoneStateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */