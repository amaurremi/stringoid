package com.jirbo.adcolony;

class ADCZoneState
{
  int play_order_index;
  int session_play_count;
  int skipped_plays;
  String uuid = "";
  
  ADCZoneState() {}
  
  ADCZoneState(String paramString)
  {
    this.uuid = paramString;
  }
  
  boolean parse(ADCData.Table paramTable)
  {
    if (paramTable == null) {
      return false;
    }
    this.uuid = paramTable.get_String("uuid", "error");
    this.skipped_plays = paramTable.get_Integer("skipped_plays");
    this.play_order_index = paramTable.get_Integer("play_order_index");
    return true;
  }
  
  ADCData.Table to_Table()
  {
    ADCData.Table localTable = new ADCData.Table();
    localTable.set("uuid", this.uuid);
    localTable.set("skipped_plays", this.skipped_plays);
    localTable.set("play_order_index", this.play_order_index);
    return localTable;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCZoneState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */