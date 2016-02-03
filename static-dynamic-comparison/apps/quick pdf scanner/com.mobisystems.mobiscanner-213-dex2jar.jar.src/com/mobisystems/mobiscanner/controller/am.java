package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class am
  extends bb
{
  private long aAa;
  private long aAh;
  private boolean aDQ;
  private long[] aDR;
  
  public am(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aDR = paramBundle.getLongArray("PAGES");
    this.aAa = paramBundle.getLong("doc_id");
    this.aAh = paramBundle.getLong("NEW_DOC_ID");
    this.aDQ = paramBundle.getBoolean("COPY_FLAG");
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    for (;;)
    {
      Object localObject1;
      long l1;
      int i;
      long l3;
      try
      {
        this.mLog.dl("Async task started");
        if (this.aDQ)
        {
          this.aGa = OperationStatus.avT;
          localObject1 = new DocumentModel();
          l2 = this.aAh;
          l1 = l2;
          if (l2 < 0L) {
            l1 = ((DocumentModel)localObject1).f(new b());
          }
          paramVarArgs = "";
          if (l1 >= 0L)
          {
            paramVarArgs = ((DocumentModel)localObject1).ae(l1);
            if (paramVarArgs == null) {
              break label431;
            }
            l2 = paramVarArgs.IA();
            paramVarArgs = paramVarArgs.getName();
            if (this.aDQ)
            {
              this.aGa = OperationStatus.awp;
              localObject2 = new ArrayList();
              long[] arrayOfLong = this.aDR;
              int j = arrayOfLong.length;
              i = 0;
              if (i < j)
              {
                l3 = arrayOfLong[i];
                if (!this.aDQ) {
                  break label345;
                }
                l3 = ((DocumentModel)localObject1).b(l3, l1, -1);
                if (l3 >= 0L) {
                  break label331;
                }
                this.aGa = OperationStatus.avT;
                e(Integer.valueOf(this.aGe.get() + 1));
                if (!isCancelled()) {
                  break label442;
                }
              }
              if ((!isCancelled()) || (!this.aDQ)) {
                break label428;
              }
              if (this.aAh >= 0L) {
                break label379;
              }
              ((DocumentModel)localObject1).ag(l1);
            }
          }
          else
          {
            localObject1 = ((DocumentModel)localObject1).ae(this.aAa);
            if (localObject1 != null) {
              ((b)localObject1).p(this.aFZ);
            }
            if (!isCancelled())
            {
              this.aFZ.putString("NEW_DOC_NAME", paramVarArgs);
              this.aFZ.putLong("NEW_DOC_ID", l1);
              this.aFZ.putBoolean("COPY_FLAG", this.aDQ);
            }
            paramVarArgs = this.aFZ;
            return paramVarArgs;
          }
        }
        else
        {
          this.aGa = OperationStatus.avU;
          continue;
        }
        this.aGa = OperationStatus.awq;
      }
      finally {}
      continue;
      label331:
      ((ArrayList)localObject2).add(Long.valueOf(l3));
      continue;
      label345:
      if (!((DocumentModel)localObject1).a(l3, l1, -1)) {
        this.aGa = OperationStatus.avU;
      }
      ((ArrayList)localObject2).add(Long.valueOf(l3));
      continue;
      label379:
      Object localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((DocumentModel)localObject1).ak(((Long)((Iterator)localObject2).next()).longValue());
      }
      ((DocumentModel)localObject1).g(l1, l2);
      label428:
      continue;
      label431:
      long l2 = -1L;
      paramVarArgs = "";
      continue;
      label442:
      i += 1;
    }
  }
  
  protected void onPreExecute()
  {
    this.aGd.set(this.aDR.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */