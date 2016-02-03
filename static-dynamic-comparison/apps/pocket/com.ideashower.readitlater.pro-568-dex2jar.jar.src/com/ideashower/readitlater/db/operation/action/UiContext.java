package com.ideashower.readitlater.db.operation.action;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.activity.f;
import com.ideashower.readitlater.util.l;
import com.pocket.app.b;
import com.pocket.list.adapter.data.ItemQuery.ReadOnlyItemQuery;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

public class UiContext
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public UiContext a(Parcel paramAnonymousParcel)
    {
      return new UiContext(paramAnonymousParcel);
    }
    
    public UiContext[] a(int paramAnonymousInt)
    {
      return new UiContext[paramAnonymousInt];
    }
  };
  private final ObjectNode a;
  
  public UiContext(Parcel paramParcel)
  {
    this.a = l.a(paramParcel.readString());
  }
  
  private UiContext(String paramString, UiTrigger paramUiTrigger)
  {
    this.a = l.b();
    if (paramUiTrigger != null) {
      this.a.put("cxt_ui", paramUiTrigger.a());
    }
    if (paramString != null) {
      this.a.put("cxt_view", paramString);
    }
  }
  
  public static UiContext a(int paramInt1, int paramInt2)
  {
    UiContext localUiContext = new UiContext("carousel", null);
    ObjectNode localObjectNode = localUiContext.a();
    localObjectNode.put("cxt_index", paramInt2 + 1);
    localObjectNode.put("cxt_grouping", paramInt1);
    return localUiContext;
  }
  
  public static UiContext a(UiTrigger paramUiTrigger)
  {
    return new UiContext(d(), paramUiTrigger);
  }
  
  public static UiContext a(UiTrigger paramUiTrigger, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramUiTrigger = new UiContext("add_tags", paramUiTrigger);
    ObjectNode localObjectNode = paramUiTrigger.a();
    localObjectNode.put("cxt_tags_cnt", paramInt1);
    localObjectNode.put("cxt_suggested_available", paramInt2);
    localObjectNode.put("cxt_enter_cnt", paramInt3);
    localObjectNode.put("cxt_suggested_cnt", paramInt4);
    localObjectNode.put("cxt_tap_cnt", paramInt5);
    localObjectNode.put("cxt_remove_cnt", paramInt6);
    return paramUiTrigger;
  }
  
  public static UiContext a(UiTrigger paramUiTrigger, int paramInt1, int paramInt2, int paramInt3, ItemQuery.ReadOnlyItemQuery paramReadOnlyItemQuery)
  {
    paramUiTrigger = new UiContext("list", paramUiTrigger);
    ObjectNode localObjectNode = paramUiTrigger.a;
    if (paramReadOnlyItemQuery.J())
    {
      localObjectNode.put("cxt_section", "queue");
      if (paramReadOnlyItemQuery.n() != 0)
      {
        localObjectNode.put("cxt_section", "highlights");
        localObjectNode.put("cxt_grouping", paramReadOnlyItemQuery.n());
        localObjectNode.remove("cxt_sort");
      }
      switch (paramInt1)
      {
      default: 
        label96:
        switch (paramReadOnlyItemQuery.E())
        {
        default: 
          label128:
          if ((paramReadOnlyItemQuery.h()) && (paramReadOnlyItemQuery.i() == 1)) {
            localObjectNode.put("cxt_content_type", "shared_to_me");
          }
          switch (paramReadOnlyItemQuery.j())
          {
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      if (paramInt2 > -1) {
        localObjectNode.put("cxt_index", paramInt2 + 1);
      }
      if (paramReadOnlyItemQuery.y()) {
        localObjectNode.put("cxt_search", paramReadOnlyItemQuery.x());
      }
      if (paramReadOnlyItemQuery.B()) {
        localObjectNode.put("cxt_tag", paramReadOnlyItemQuery.A());
      }
      if ((paramReadOnlyItemQuery.n() == 0) && (paramInt3 != 0)) {
        localObjectNode.put("cxt_grouping", paramInt3);
      }
      return paramUiTrigger;
      if (paramReadOnlyItemQuery.w())
      {
        localObjectNode.put("cxt_section", "favorites");
        break;
      }
      if (!paramReadOnlyItemQuery.f())
      {
        localObjectNode.put("cxt_section", "all");
        break;
      }
      if (paramReadOnlyItemQuery.e().intValue() != 1) {
        break;
      }
      localObjectNode.put("cxt_section", "archive");
      break;
      localObjectNode.put("cxt_list_view", "list");
      break label96;
      localObjectNode.put("cxt_list_view", "tile");
      break label96;
      localObjectNode.put("cxt_content_type", "article");
      break label128;
      localObjectNode.put("cxt_content_type", "video");
      break label128;
      localObjectNode.put("cxt_content_type", "image");
      break label128;
      localObjectNode.put("cxt_sort", "newest");
      continue;
      localObjectNode.put("cxt_sort", "oldest");
      continue;
      localObjectNode.put("cxt_sort", "relevance");
    }
  }
  
  public static UiContext a(UiTrigger paramUiTrigger, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = 1;
    paramUiTrigger = new UiContext("reader", paramUiTrigger);
    ObjectNode localObjectNode = paramUiTrigger.a();
    switch (paramInt1)
    {
    default: 
      localObjectNode.put("cxt_top", paramInt2);
      localObjectNode.put("cxt_bottom", paramInt3);
      if (!paramBoolean) {
        break;
      }
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      localObjectNode.put("cxt_fullscreen", paramInt1);
      return paramUiTrigger;
      localObjectNode.put("cxt_reader_view", 1);
      break;
      localObjectNode.put("cxt_reader_view", 2);
      break;
      localObjectNode.put("cxt_reader_view", 3);
      break;
    }
  }
  
  public static UiContext a(String paramString)
  {
    UiContext localUiContext = new UiContext(d(), UiTrigger.D);
    ObjectNode localObjectNode = localUiContext.a();
    if (paramString != null) {
      localObjectNode.put("cxt_ui", UiTrigger.D.a() + "_" + paramString);
    }
    return localUiContext;
  }
  
  public static UiContext a(String paramString, UiTrigger paramUiTrigger, int paramInt)
  {
    paramString = new UiContext(paramString, paramUiTrigger);
    paramUiTrigger = paramString.a();
    if (paramInt >= 0) {
      paramUiTrigger.put("cxt_index", paramInt);
    }
    return paramString;
  }
  
  private static String a(a parama)
  {
    if (parama == null) {
      return null;
    }
    Iterator localIterator = parama.k().f().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof f)) {
        return ((f)localFragment).K();
      }
    }
    return parama.f();
  }
  
  public static UiContext b()
  {
    return b(-1, -1);
  }
  
  public static UiContext b(int paramInt1, int paramInt2)
  {
    UiContext localUiContext = new UiContext("highlights", null);
    ObjectNode localObjectNode = localUiContext.a();
    if (paramInt1 != -1)
    {
      localObjectNode.put("cxt_index", paramInt2 + 1);
      localObjectNode.put("cxt_grouping", paramInt1);
    }
    return localUiContext;
  }
  
  private static String d()
  {
    return a(g.n());
  }
  
  public ObjectNode a()
  {
    return this.a;
  }
  
  public UiTrigger c()
  {
    String str = this.a.get("cxt_ui").getTextValue();
    if (k.a(str)) {
      return null;
    }
    return UiTrigger.a(str);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "UiContext " + this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/UiContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */