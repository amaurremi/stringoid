package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class n
  extends bb
{
  private long[] aAd;
  private final boolean aAg;
  private long aAh;
  private String aAi;
  
  public n(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aAd = paramBundle.getLongArray("DOCUMENTS");
    this.aAh = paramBundle.getLong("NEW_DOC_ID");
    this.aAi = paramContext.getResources().getString(2131297011);
    this.aAg = paramBundle.getBoolean("COPY_FLAG", true);
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    for (;;)
    {
      DocumentModel localDocumentModel;
      long[] arrayOfLong;
      long l2;
      Object localObject;
      int i;
      try
      {
        this.mLog.dl("Async task started");
        this.aGa = OperationStatus.avQ;
        localDocumentModel = new DocumentModel();
        arrayOfLong = (long[])this.aAd.clone();
        l2 = this.aAh;
        if (l2 >= 0L) {
          break label563;
        }
        paramVarArgs = null;
        if (arrayOfLong.length == 1)
        {
          localObject = localDocumentModel.ae(arrayOfLong[0]);
          paramVarArgs = (Void[])localObject;
          if (localObject != null)
          {
            ((b)localObject).setName(((b)localObject).getName() + this.aAi);
            paramVarArgs = (Void[])localObject;
          }
        }
        localObject = paramVarArgs;
        if (paramVarArgs == null) {
          localObject = new b();
        }
        l1 = localDocumentModel.f((b)localObject);
        if (l1 < 0L) {
          break label551;
        }
        paramVarArgs = localDocumentModel.ae(l1);
        if (paramVarArgs == null) {
          break label543;
        }
        l2 = paramVarArgs.IA();
        this.aGa = OperationStatus.awo;
        paramVarArgs = new ArrayList();
        int j = arrayOfLong.length;
        i = 0;
        if (i >= j) {
          break label435;
        }
        long l3 = arrayOfLong[i];
        this.aGc.getAndIncrement();
        localObject = localDocumentModel.ah(l3);
        if (localObject != null)
        {
          this.aGd.set(((Cursor)localObject).getCount());
          e(Integer.valueOf(0));
          ((Cursor)localObject).moveToFirst();
          if (!((Cursor)localObject).isAfterLast())
          {
            long l4 = localDocumentModel.b(((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("_id")), l1, -1);
            if (l4 < 0L) {
              this.aGa = OperationStatus.avQ;
            }
            paramVarArgs.add(Long.valueOf(l4));
            if (!isCancelled()) {
              break label401;
            }
          }
          ((Cursor)localObject).close();
        }
        if (this.aAg) {
          break label556;
        }
        localDocumentModel.ag(l3);
      }
      finally {}
      long l1 = l2;
      if (i < arrayOfLong.length) {
        if (arrayOfLong[i] == l2)
        {
          l1 = l2;
          if (i != 0)
          {
            arrayOfLong[i] = arrayOfLong[0];
            arrayOfLong[0] = l2;
            l1 = l2;
          }
        }
        else
        {
          i += 1;
          continue;
          label401:
          e(Integer.valueOf(this.aGe.get() + 1));
          if (!isCancelled())
          {
            ((Cursor)localObject).moveToNext();
            continue;
            label435:
            if (isCancelled()) {
              if (this.aAh < 0L)
              {
                localDocumentModel.ag(l1);
                paramVarArgs = null;
              }
            }
            for (;;)
            {
              if (paramVarArgs != null) {
                paramVarArgs.p(this.aFZ);
              }
              paramVarArgs = this.aFZ;
              return paramVarArgs;
              paramVarArgs = paramVarArgs.iterator();
              while (paramVarArgs.hasNext()) {
                localDocumentModel.ak(((Long)paramVarArgs.next()).longValue());
              }
              localDocumentModel.g(l1, l2);
              paramVarArgs = null;
              continue;
              paramVarArgs = localDocumentModel.ae(l1);
              continue;
              label543:
              l2 = -1L;
              break;
              label551:
              paramVarArgs = null;
            }
            label556:
            i += 1;
            continue;
            label563:
            i = 0;
          }
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    this.aGb.set(this.aAd.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */