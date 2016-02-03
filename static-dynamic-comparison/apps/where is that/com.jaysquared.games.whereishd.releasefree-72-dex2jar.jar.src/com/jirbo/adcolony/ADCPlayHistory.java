package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class ADCPlayHistory
{
  ADCController controller;
  boolean loaded = false;
  boolean modified = false;
  HashMap<Integer, Integer> play_counts = new HashMap();
  ArrayList<PlayEvent> play_events = new ArrayList();
  HashMap<String, Integer> reward_credit = new HashMap();
  
  ADCPlayHistory(ADCController paramADCController)
  {
    this.controller = paramADCController;
  }
  
  int ad_daily_play_count(int paramInt)
  {
    return ad_interval_play_count(paramInt, 86400.0D);
  }
  
  int ad_half_year_play_count(int paramInt)
  {
    return ad_interval_play_count(paramInt, 1.5768E7D);
  }
  
  /* Error */
  int ad_interval_play_count(int paramInt, double paramDouble)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 61	com/jirbo/adcolony/ADCUtil:current_time	()D
    //   5: dstore 4
    //   7: iconst_0
    //   8: istore 9
    //   10: aload_0
    //   11: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   14: invokevirtual 65	java/util/ArrayList:size	()I
    //   17: iconst_1
    //   18: isub
    //   19: istore 8
    //   21: iload 8
    //   23: iflt +30 -> 53
    //   26: aload_0
    //   27: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   30: iload 8
    //   32: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   35: checkcast 6	com/jirbo/adcolony/ADCPlayHistory$PlayEvent
    //   38: getfield 73	com/jirbo/adcolony/ADCPlayHistory$PlayEvent:timestamp	D
    //   41: dstore 6
    //   43: dload 6
    //   45: dload 4
    //   47: dload_2
    //   48: dsub
    //   49: dcmpg
    //   50: ifge +8 -> 58
    //   53: aload_0
    //   54: monitorexit
    //   55: iload 9
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   62: iload 8
    //   64: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   67: checkcast 6	com/jirbo/adcolony/ADCPlayHistory$PlayEvent
    //   70: getfield 77	com/jirbo/adcolony/ADCPlayHistory$PlayEvent:ad_id	I
    //   73: istore 11
    //   75: iload 9
    //   77: istore 10
    //   79: iload_1
    //   80: iload 11
    //   82: if_icmpne +9 -> 91
    //   85: iload 9
    //   87: iconst_1
    //   88: iadd
    //   89: istore 10
    //   91: iload 8
    //   93: iconst_1
    //   94: isub
    //   95: istore 8
    //   97: iload 10
    //   99: istore 9
    //   101: goto -80 -> 21
    //   104: astore 12
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 12
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ADCPlayHistory
    //   0	111	1	paramInt	int
    //   0	111	2	paramDouble	double
    //   5	41	4	d1	double
    //   41	3	6	d2	double
    //   19	77	8	i	int
    //   8	92	9	j	int
    //   77	21	10	k	int
    //   73	10	11	m	int
    //   104	5	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	104	finally
    //   10	21	104	finally
    //   26	43	104	finally
    //   58	75	104	finally
  }
  
  int ad_monthly_play_count(int paramInt)
  {
    return ad_interval_play_count(paramInt, 2628000.0D);
  }
  
  int ad_weekly_play_count(int paramInt)
  {
    return ad_interval_play_count(paramInt, 604800.0D);
  }
  
  void add_play_event(String paramString, int paramInt)
  {
    ADCLog.dev.println("Adding play event to play history");
    this.modified = true;
    this.play_events.add(new PlayEvent(this.controller.session_manager.current_session_id, ADCUtil.current_time(), paramString, paramInt));
    paramString = (Integer)this.play_counts.get(Integer.valueOf(paramInt));
    ADCLog.dev.print("Got play count of ").print(paramString).println(" for this ad");
    if (paramString == null)
    {
      this.play_counts.put(Integer.valueOf(paramInt), Integer.valueOf(1));
      return;
    }
    this.play_counts.put(Integer.valueOf(paramInt), Integer.valueOf(paramString.intValue() + 1));
  }
  
  void configure()
  {
    load();
    this.modified = false;
  }
  
  int get_reward_credit(String paramString)
  {
    paramString = (Integer)this.reward_credit.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  void load()
  {
    ADC.active = true;
    if ((this.loaded) && (((PlayEvent)this.play_events.get(this.play_events.size() - 1)).session_id == this.controller.session_manager.current_session_id)) {}
    do
    {
      return;
      localTable = ADCJSON.load_Table(new ADCDataFile("play_history_info.txt"));
    } while (localTable == null);
    this.play_events.clear();
    this.reward_credit = new HashMap();
    Object localObject1 = localTable.get_Table("reward_credit");
    int i = 0;
    Object localObject2;
    int j;
    while (i < ((ADCData.Table)localObject1).count())
    {
      localObject2 = ((ADCData.Table)localObject1).key_at(i);
      j = ((ADCData.Table)localObject1).get_Integer((String)localObject2);
      this.reward_credit.put(localObject2, Integer.valueOf(j));
      i += 1;
    }
    localObject1 = localTable.get_List("play_events");
    i = 0;
    while (i < ((ADCData.List)localObject1).count())
    {
      localObject2 = ((ADCData.List)localObject1).get_Table(i);
      double d = ((ADCData.Table)localObject2).get_Real("timestamp");
      String str = ((ADCData.Table)localObject2).get_String("zone_id");
      j = ((ADCData.Table)localObject2).get_Integer("ad_id");
      if ((d != 0.0D) && (str != null) && (j != 0)) {
        this.play_events.add(new PlayEvent(null, d, str, j));
      }
      i += 1;
    }
    this.play_counts = new HashMap();
    ADCData.Table localTable = localTable.get_Table("play_counts");
    i = 0;
    while (i < localTable.count())
    {
      j = Integer.parseInt(localTable.key_at(i));
      int k = localTable.get_Integer("" + j);
      this.play_counts.put(Integer.valueOf(j), Integer.valueOf(k));
      i += 1;
    }
    this.loaded = true;
  }
  
  void save()
  {
    Object localObject1 = new ADCData.List();
    ADCData.Table localTable1 = new ADCData.Table();
    ADCData.Table localTable2 = new ADCData.Table();
    double d = ADCUtil.current_time();
    int i = this.play_events.size() - 1;
    Object localObject2;
    for (;;)
    {
      if (i >= 0)
      {
        localObject2 = (PlayEvent)this.play_events.get(i);
        if (((PlayEvent)localObject2).timestamp >= d - 2678400.0D) {}
      }
      else
      {
        localTable1.set("play_events", (ADCData.Value)localObject1);
        localObject1 = this.play_counts.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          i = ((Integer)((Iterator)localObject1).next()).intValue();
          int j = ((Integer)this.play_counts.get(Integer.valueOf(i))).intValue();
          localTable2.set("" + i, j);
        }
      }
      ADCData.Table localTable3 = new ADCData.Table();
      localTable3.set("zone_id", ((PlayEvent)localObject2).zone_id);
      localTable3.set("ad_id", ((PlayEvent)localObject2).ad_id);
      localTable3.set("timestamp", ((PlayEvent)localObject2).timestamp);
      ((ADCData.List)localObject1).add(localTable3);
      i -= 1;
    }
    localTable1.set("play_counts", localTable2);
    localTable2 = new ADCData.Table();
    if (this.reward_credit.size() > 0)
    {
      localObject1 = this.reward_credit.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localTable2.set((String)localObject2, ((Integer)this.reward_credit.get(localObject2)).intValue());
      }
    }
    localTable1.set("reward_credit", localTable2);
    ADCLog.dev.print("Saving play history");
    ADCJSON.save(new ADCDataFile("play_history_info.txt"), localTable1);
  }
  
  void set_reward_credit(String paramString, int paramInt)
  {
    this.reward_credit.put(paramString, Integer.valueOf(paramInt));
    this.modified = true;
  }
  
  void update()
  {
    if (this.modified)
    {
      this.modified = false;
      save();
    }
  }
  
  int zone_daily_play_count(String paramString)
  {
    return zone_interval_play_count(paramString, 86400.0D);
  }
  
  /* Error */
  int zone_interval_play_count(String paramString, double paramDouble)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 61	com/jirbo/adcolony/ADCUtil:current_time	()D
    //   5: dstore 4
    //   7: iconst_0
    //   8: istore 9
    //   10: aload_0
    //   11: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   14: invokevirtual 65	java/util/ArrayList:size	()I
    //   17: iconst_1
    //   18: isub
    //   19: istore 8
    //   21: iload 8
    //   23: iflt +30 -> 53
    //   26: aload_0
    //   27: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   30: iload 8
    //   32: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   35: checkcast 6	com/jirbo/adcolony/ADCPlayHistory$PlayEvent
    //   38: getfield 73	com/jirbo/adcolony/ADCPlayHistory$PlayEvent:timestamp	D
    //   41: dstore 6
    //   43: dload 6
    //   45: dload 4
    //   47: dload_2
    //   48: dsub
    //   49: dcmpg
    //   50: ifge +8 -> 58
    //   53: aload_0
    //   54: monitorexit
    //   55: iload 9
    //   57: ireturn
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   63: iload 8
    //   65: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   68: checkcast 6	com/jirbo/adcolony/ADCPlayHistory$PlayEvent
    //   71: getfield 265	com/jirbo/adcolony/ADCPlayHistory$PlayEvent:zone_id	Ljava/lang/String;
    //   74: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: istore 11
    //   79: iload 9
    //   81: istore 10
    //   83: iload 11
    //   85: ifeq +9 -> 94
    //   88: iload 9
    //   90: iconst_1
    //   91: iadd
    //   92: istore 10
    //   94: iload 8
    //   96: iconst_1
    //   97: isub
    //   98: istore 8
    //   100: iload 10
    //   102: istore 9
    //   104: goto -83 -> 21
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ADCPlayHistory
    //   0	112	1	paramString	String
    //   0	112	2	paramDouble	double
    //   5	41	4	d1	double
    //   41	3	6	d2	double
    //   19	80	8	i	int
    //   8	95	9	j	int
    //   81	20	10	k	int
    //   77	7	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	107	finally
    //   10	21	107	finally
    //   26	43	107	finally
    //   58	79	107	finally
  }
  
  /* Error */
  int zone_session_play_count(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/jirbo/adcolony/ADCPlayHistory:controller	Lcom/jirbo/adcolony/ADCController;
    //   6: getfield 103	com/jirbo/adcolony/ADCController:session_manager	Lcom/jirbo/adcolony/ADCSessionManager;
    //   9: getfield 109	com/jirbo/adcolony/ADCSessionManager:current_session_id	Ljava/lang/String;
    //   12: astore 8
    //   14: iconst_0
    //   15: istore 5
    //   17: iconst_0
    //   18: istore 4
    //   20: aload_0
    //   21: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   24: invokevirtual 65	java/util/ArrayList:size	()I
    //   27: iconst_1
    //   28: isub
    //   29: istore_2
    //   30: iload_2
    //   31: iflt +35 -> 66
    //   34: aload_0
    //   35: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   38: iload_2
    //   39: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: ifnull +24 -> 66
    //   45: aload_0
    //   46: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   49: iload_2
    //   50: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   53: checkcast 6	com/jirbo/adcolony/ADCPlayHistory$PlayEvent
    //   56: getfield 156	com/jirbo/adcolony/ADCPlayHistory$PlayEvent:session_id	Ljava/lang/String;
    //   59: astore 9
    //   61: aload 9
    //   63: ifnonnull +8 -> 71
    //   66: aload_0
    //   67: monitorexit
    //   68: iload 4
    //   70: ireturn
    //   71: aload_0
    //   72: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   75: iload_2
    //   76: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   79: checkcast 6	com/jirbo/adcolony/ADCPlayHistory$PlayEvent
    //   82: getfield 156	com/jirbo/adcolony/ADCPlayHistory$PlayEvent:session_id	Ljava/lang/String;
    //   85: aload 8
    //   87: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +61 -> 151
    //   93: iconst_1
    //   94: istore 5
    //   96: aload_0
    //   97: getfield 30	com/jirbo/adcolony/ADCPlayHistory:play_events	Ljava/util/ArrayList;
    //   100: iload_2
    //   101: invokevirtual 69	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   104: checkcast 6	com/jirbo/adcolony/ADCPlayHistory$PlayEvent
    //   107: getfield 265	com/jirbo/adcolony/ADCPlayHistory$PlayEvent:zone_id	Ljava/lang/String;
    //   110: aload_1
    //   111: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: istore 7
    //   116: iload 4
    //   118: istore 6
    //   120: iload 5
    //   122: istore_3
    //   123: iload 7
    //   125: ifeq +12 -> 137
    //   128: iload 4
    //   130: iconst_1
    //   131: iadd
    //   132: istore 6
    //   134: iload 5
    //   136: istore_3
    //   137: iload_2
    //   138: iconst_1
    //   139: isub
    //   140: istore_2
    //   141: iload 6
    //   143: istore 4
    //   145: iload_3
    //   146: istore 5
    //   148: goto -118 -> 30
    //   151: iload 4
    //   153: istore 6
    //   155: iload 5
    //   157: istore_3
    //   158: iload 5
    //   160: ifeq -23 -> 137
    //   163: goto -97 -> 66
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	ADCPlayHistory
    //   0	171	1	paramString	String
    //   29	112	2	i	int
    //   122	36	3	j	int
    //   18	134	4	k	int
    //   15	144	5	m	int
    //   118	36	6	n	int
    //   114	10	7	bool	boolean
    //   12	74	8	str1	String
    //   59	3	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	14	166	finally
    //   20	30	166	finally
    //   34	61	166	finally
    //   71	93	166	finally
    //   96	116	166	finally
  }
  
  static class PlayEvent
  {
    int ad_id;
    String session_id;
    double timestamp;
    String zone_id;
    
    PlayEvent(String paramString1, double paramDouble, String paramString2, int paramInt)
    {
      this.session_id = paramString1;
      this.timestamp = paramDouble;
      this.zone_id = paramString2;
      this.ad_id = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCPlayHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */