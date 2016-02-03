package com.adwhirl.obj;

public class Ration
  implements Comparable<Ration>
{
  public String key = "";
  public String key2 = "";
  public String name = "";
  public String nid = "";
  public int priority = 0;
  public int type = 0;
  public double weight = 0.0D;
  
  public int compareTo(Ration paramRation)
  {
    int i = paramRation.priority;
    if (this.priority < i) {
      return -1;
    }
    if (this.priority > i) {
      return 1;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adwhirl/obj/Ration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */