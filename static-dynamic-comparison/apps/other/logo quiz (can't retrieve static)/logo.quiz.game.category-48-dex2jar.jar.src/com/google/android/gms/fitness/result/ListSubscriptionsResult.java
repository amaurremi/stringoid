package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSubscriptionsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new e();
  private final int BR;
  private final Status CM;
  private final List<Subscription> UN;
  
  ListSubscriptionsResult(int paramInt, List<Subscription> paramList, Status paramStatus)
  {
    this.BR = paramInt;
    this.UN = paramList;
    this.CM = paramStatus;
  }
  
  public ListSubscriptionsResult(List<Subscription> paramList, Status paramStatus)
  {
    this.BR = 3;
    this.UN = Collections.unmodifiableList(paramList);
    this.CM = ((Status)n.b(paramStatus, "status"));
  }
  
  public static ListSubscriptionsResult G(Status paramStatus)
  {
    return new ListSubscriptionsResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean b(ListSubscriptionsResult paramListSubscriptionsResult)
  {
    return (this.CM.equals(paramListSubscriptionsResult.CM)) && (m.equal(this.UN, paramListSubscriptionsResult.UN));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof ListSubscriptionsResult)) && (b((ListSubscriptionsResult)paramObject)));
  }
  
  public Status getStatus()
  {
    return this.CM;
  }
  
  public List<Subscription> getSubscriptions()
  {
    return this.UN;
  }
  
  public List<Subscription> getSubscriptions(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Subscription localSubscription = (Subscription)localIterator.next();
      if (localSubscription.getDataType().equals(paramDataType)) {
        localArrayList.add(localSubscription);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.CM, this.UN });
  }
  
  public String toString()
  {
    return m.h(this).a("status", this.CM).a("dataSets", this.UN).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/result/ListSubscriptionsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */