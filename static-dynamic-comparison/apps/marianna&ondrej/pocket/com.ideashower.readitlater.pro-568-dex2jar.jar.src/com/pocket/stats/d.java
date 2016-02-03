package com.pocket.stats;

import com.ideashower.readitlater.objects.UserMessage;

public class d
{
  public static final k a = new e("search", "view_search_results", null);
  public static final k b = new e("search", "view_search_upsell", null);
  public static final k c = new e("add_tags", "view_tags_upsell", null);
  public static final k d = new e("updated", "view_updated_upsell", null);
  public static final k e = new e("upgrade", "view_page", null);
  public static final k f = new e("upgrade", "scroll_to_bottom", 3, null);
  public static final k g = new e("upgrade", "click_close", 2, null);
  public static final k h = new e("upgrade", "click_monthly", 2, null);
  public static final k i = new e("upgrade", "click_annual", 2, null);
  public static final k j = new e("upgrade", "cancel_monthly", 3, null);
  public static final k k = new e("upgrade", "cancel_annual", 3, null);
  public static final k l = new e("upgrade", "error_monthly", 4, null);
  public static final k m = new e("upgrade", "error_annual", 4, null);
  public static final k n = new e("confirmation", "confirm_monthly", null);
  public static final k o = new e("confirmation", "confirm_annual", null);
  
  public static String a(UserMessage paramUserMessage)
  {
    return "message_" + paramUserMessage.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */