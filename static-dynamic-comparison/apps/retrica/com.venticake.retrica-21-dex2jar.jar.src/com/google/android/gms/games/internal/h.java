package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;

final class h
  extends b
  implements Quests.ClaimMilestoneResult
{
  private final Milestone a;
  private final Quest b;
  
  /* Error */
  h(com.google.android.gms.common.data.DataHolder paramDataHolder, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 15	com/google/android/gms/common/api/b:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   7: new 17	com/google/android/gms/games/quest/QuestBuffer
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 18	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokevirtual 22	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
    //   20: ifle +108 -> 128
    //   23: aload_0
    //   24: new 24	com/google/android/gms/games/quest/QuestEntity
    //   27: dup
    //   28: aload_1
    //   29: iconst_0
    //   30: invokevirtual 28	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
    //   33: checkcast 30	com/google/android/gms/games/quest/Quest
    //   36: invokespecial 33	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
    //   39: putfield 35	com/google/android/gms/games/internal/h:b	Lcom/google/android/gms/games/quest/Quest;
    //   42: aload_0
    //   43: getfield 35	com/google/android/gms/games/internal/h:b	Lcom/google/android/gms/games/quest/Quest;
    //   46: invokeinterface 39 1 0
    //   51: astore 5
    //   53: aload 5
    //   55: invokeinterface 44 1 0
    //   60: istore 4
    //   62: iload_3
    //   63: iload 4
    //   65: if_icmpge +53 -> 118
    //   68: aload 5
    //   70: iload_3
    //   71: invokeinterface 45 2 0
    //   76: checkcast 47	com/google/android/gms/games/quest/Milestone
    //   79: invokeinterface 51 1 0
    //   84: aload_2
    //   85: invokevirtual 57	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +23 -> 111
    //   91: aload_0
    //   92: aload 5
    //   94: iload_3
    //   95: invokeinterface 45 2 0
    //   100: checkcast 47	com/google/android/gms/games/quest/Milestone
    //   103: putfield 59	com/google/android/gms/games/internal/h:a	Lcom/google/android/gms/games/quest/Milestone;
    //   106: aload_1
    //   107: invokevirtual 63	com/google/android/gms/games/quest/QuestBuffer:close	()V
    //   110: return
    //   111: iload_3
    //   112: iconst_1
    //   113: iadd
    //   114: istore_3
    //   115: goto -53 -> 62
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 59	com/google/android/gms/games/internal/h:a	Lcom/google/android/gms/games/quest/Milestone;
    //   123: aload_1
    //   124: invokevirtual 63	com/google/android/gms/games/quest/QuestBuffer:close	()V
    //   127: return
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 59	com/google/android/gms/games/internal/h:a	Lcom/google/android/gms/games/quest/Milestone;
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 35	com/google/android/gms/games/internal/h:b	Lcom/google/android/gms/games/quest/Quest;
    //   138: goto -15 -> 123
    //   141: astore_2
    //   142: aload_1
    //   143: invokevirtual 63	com/google/android/gms/games/quest/QuestBuffer:close	()V
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	h
    //   0	148	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   0	148	2	paramString	String
    //   1	114	3	i	int
    //   60	6	4	j	int
    //   51	42	5	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   16	62	141	finally
    //   68	106	141	finally
    //   118	123	141	finally
    //   128	138	141	finally
  }
  
  public Milestone getMilestone()
  {
    return this.a;
  }
  
  public Quest getQuest()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */