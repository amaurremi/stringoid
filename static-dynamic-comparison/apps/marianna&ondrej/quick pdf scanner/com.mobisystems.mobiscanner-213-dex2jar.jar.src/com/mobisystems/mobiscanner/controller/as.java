package com.mobisystems.mobiscanner.controller;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.d;
import java.io.File;
import java.util.ArrayList;

public class as
  extends bd
{
  private void Hg()
  {
    if (this.aGj == null)
    {
      this.aGj = new at(getActivity(), this, getTag(), getArguments());
      this.aGj.execute(new Void[0]);
    }
  }
  
  protected void R(View paramView)
  {
    super.R(paramView);
    gs(getArguments().getLongArray("PAGES").length);
  }
  
  public void a(OperationStatus paramOperationStatus, Bundle paramBundle)
  {
    int i = 0;
    Object localObject1 = paramBundle.getStringArray("EXPORTED_FILES");
    Object localObject2 = getTag();
    FragmentActivity localFragmentActivity = getActivity();
    Resources localResources;
    if (localFragmentActivity != null)
    {
      localResources = getResources();
      if (!paramOperationStatus.equals(OperationStatus.avH)) {
        break label455;
      }
      if (!((String)localObject2).equals("PAGE_EXPORT")) {
        break label166;
      }
      if ((localObject1.length > 0) && (localObject1[0] != null))
      {
        localObject1 = new File(localObject1[0]);
        localObject2 = d.e(((File)localObject1).getParentFile());
        Toast.makeText(localFragmentActivity, String.format(localResources.getString(paramOperationStatus.Ds()), new Object[] { localObject2 }), 0).show();
      }
    }
    try
    {
      MediaScannerConnection.scanFile(getActivity(), new String[] { ((File)localObject1).getAbsolutePath() }, null, null);
      for (;;)
      {
        if (this.axJ != null) {
          this.axJ.onDialogPositiveAction(getTag(), paramBundle);
        }
        dismiss();
        return;
        label166:
        if (((String)localObject2).equals("PAGE_OPEN"))
        {
          if ((localObject1.length > 0) && (localObject1[0] != null))
          {
            paramOperationStatus = new Intent("android.intent.action.VIEW");
            paramOperationStatus.setDataAndType(Uri.fromFile(new File(localObject1[0]).getAbsoluteFile()), "image/*");
            localFragmentActivity.startActivity(Intent.createChooser(paramOperationStatus, localResources.getText(2131296727)));
          }
          else
          {
            Toast.makeText(localFragmentActivity, OperationStatus.avG.Ds(), 0).show();
          }
        }
        else if (((String)localObject2).equals("PAGE_SHARE"))
        {
          paramOperationStatus = new Intent();
          if (localObject1.length > 1)
          {
            paramOperationStatus.setAction("android.intent.action.SEND_MULTIPLE");
            localObject2 = new ArrayList();
            int j = localObject1.length;
            while (i < j)
            {
              String str = localObject1[i];
              if (str != null) {
                ((ArrayList)localObject2).add(Uri.fromFile(new File(str)));
              }
              i += 1;
            }
            paramOperationStatus.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject2);
          }
          for (;;)
          {
            paramOperationStatus.setType("image/*");
            paramOperationStatus.putExtra("android.intent.extra.SUBJECT", localResources.getText(2131297009));
            paramOperationStatus.putExtra("android.intent.extra.TEXT", localResources.getText(2131297010));
            localFragmentActivity.startActivity(Intent.createChooser(paramOperationStatus, localResources.getText(2131296728)));
            break;
            if ((localObject1.length > 0) && (localObject1[0] != null))
            {
              paramOperationStatus.setAction("android.intent.action.SEND");
              paramOperationStatus.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(localObject1[0])));
            }
          }
          label455:
          Toast.makeText(localFragmentActivity, paramOperationStatus.Ds(), 0).show();
        }
      }
    }
    catch (Throwable paramOperationStatus)
    {
      for (;;) {}
    }
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903101;
    String str = getTag();
    if ((str.equals("PAGE_EXPORT")) || (str.equals("PAGE_EXPORT_FOR_EDIT")) || (str.equals("PAGE_EXPORT_FOR_BATCH_EDIT"))) {
      this.app = 2131296723;
    }
    for (;;)
    {
      this.aGh = 2131296801;
      return;
      if (str.equals("PAGE_OPEN")) {
        this.app = 2131296725;
      } else if (str.equals("PAGE_SHARE")) {
        this.app = 2131296726;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    super.Fa();
    Hg();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */