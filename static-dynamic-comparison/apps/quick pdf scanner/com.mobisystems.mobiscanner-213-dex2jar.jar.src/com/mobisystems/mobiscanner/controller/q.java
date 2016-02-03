package com.mobisystems.mobiscanner.controller;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.mobisystems.mobiscanner.a.b;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import java.io.File;
import java.util.ArrayList;

public class q
  extends bd
{
  private b aAj;
  
  private void Fh()
  {
    if (this.aGj == null)
    {
      this.aAj = b.a(getActivity(), getActivity().getSupportFragmentManager());
      this.aGj = new r(getActivity(), this, getTag(), getArguments(), this.aAj);
      this.aGj.execute(new Void[0]);
    }
  }
  
  public void a(OperationStatus paramOperationStatus, Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArray("EXPORTED_FILES");
    Object localObject = getTag();
    FragmentActivity localFragmentActivity = getActivity();
    Resources localResources;
    if (localFragmentActivity != null)
    {
      localResources = getResources();
      if (!paramOperationStatus.equals(OperationStatus.avF)) {
        break label645;
      }
      if (!((String)localObject).equals("DOCUMENT_EXPORT")) {
        break label138;
      }
      if ((paramBundle.length > 0) && (paramBundle[0] != null))
      {
        paramBundle = d.e(new File(paramBundle[0]).getParentFile());
        Toast.makeText(localFragmentActivity, String.format(localResources.getString(paramOperationStatus.Ds()), new Object[] { paramBundle }), 0).show();
      }
    }
    for (;;)
    {
      if (this.axJ != null)
      {
        paramOperationStatus = getArguments();
        this.axJ.onDialogPositiveAction(getTag(), paramOperationStatus);
      }
      dismiss();
      return;
      label138:
      if (((String)localObject).equals("DOCUMENT_OPEN"))
      {
        if ((paramBundle.length > 0) && (paramBundle[0] != null))
        {
          paramOperationStatus = new Intent("android.intent.action.VIEW");
          paramOperationStatus.setDataAndType(Uri.fromFile(new File(paramBundle[0]).getAbsoluteFile()), "application/pdf");
          localFragmentActivity.startActivity(Intent.createChooser(paramOperationStatus, localResources.getText(2131296720)));
        }
        else
        {
          Toast.makeText(localFragmentActivity, OperationStatus.avE.Ds(), 0).show();
        }
      }
      else
      {
        if (((String)localObject).equals("DOCUMENT_SHARE"))
        {
          paramOperationStatus = new Intent();
          if (paramBundle.length > 1)
          {
            paramOperationStatus.setAction("android.intent.action.SEND_MULTIPLE");
            localObject = new ArrayList();
            int j = paramBundle.length;
            int i = 0;
            while (i < j)
            {
              String str = paramBundle[i];
              if (str != null) {
                ((ArrayList)localObject).add(Uri.fromFile(new File(str)));
              }
              i += 1;
            }
            paramOperationStatus.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject);
          }
          for (;;)
          {
            paramOperationStatus.setType("application/pdf");
            paramOperationStatus.putExtra("android.intent.extra.SUBJECT", localResources.getText(2131297007));
            paramOperationStatus.putExtra("android.intent.extra.TEXT", localResources.getText(2131297008));
            localFragmentActivity.startActivity(Intent.createChooser(paramOperationStatus, localResources.getText(2131296721)));
            break;
            if ((paramBundle.length > 0) && (paramBundle[0] != null))
            {
              paramOperationStatus.setAction("android.intent.action.SEND");
              paramOperationStatus.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramBundle[0])));
            }
          }
        }
        if (((String)localObject).equals("DOCUMENT_PRINT"))
        {
          if ((paramBundle.length > 0) && (paramBundle[0] != null))
          {
            paramBundle = Uri.fromFile(new File(paramBundle[0]).getAbsoluteFile());
            paramOperationStatus = new Intent();
            paramOperationStatus.setAction("android.intent.action.SEND");
            paramOperationStatus.setDataAndType(paramBundle, "application/pdf");
            paramOperationStatus.putExtra("android.intent.extra.STREAM", paramBundle);
            paramBundle = getActivity().getPackageManager().queryIntentActivities(paramOperationStatus, 65536);
            if ((getActivity() instanceof PageGridActivity)) {
              ((PageGridActivity)getActivity()).a(paramBundle, paramOperationStatus, false, "DOCUMENT_PRINT");
            }
          }
        }
        else if (((String)localObject).equals("DOCUMENT_FAX")) {
          if ((paramBundle.length > 0) && (paramBundle[0] != null))
          {
            paramOperationStatus = new Intent("android.intent.action.VIEW");
            paramOperationStatus.setDataAndType(Uri.fromFile(new File(paramBundle[0]).getAbsoluteFile()), "application/pdf");
            paramBundle = getActivity().getPackageManager().queryIntentActivities(paramOperationStatus, 65536);
            if ((getActivity() instanceof PageGridActivity)) {
              ((PageGridActivity)getActivity()).a(paramBundle, paramOperationStatus, false, "DOCUMENT_FAX");
            }
          }
          else
          {
            Toast.makeText(localFragmentActivity, OperationStatus.avE.Ds(), 0).show();
            continue;
            label645:
            Toast.makeText(localFragmentActivity, paramOperationStatus.Ds(), 0).show();
          }
        }
      }
    }
  }
  
  protected void init()
  {
    this.mDialogResId = 2130903085;
    String str = getTag();
    if (str.equals("DOCUMENT_EXPORT")) {
      this.app = 2131296717;
    }
    for (;;)
    {
      this.aGh = 2131296796;
      return;
      if (str.equals("DOCUMENT_OPEN")) {
        this.app = 2131296718;
      } else if (str.equals("DOCUMENT_SHARE")) {
        this.app = 2131296719;
      } else if (str.equals("DOCUMENT_PRINT")) {
        this.app = 2131296746;
      } else if (str.equals("DOCUMENT_FAX")) {
        this.app = 2131296747;
      }
    }
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    super.onPause();
    this.aAj.flushCache();
  }
  
  public void onResume()
  {
    super.onResume();
    super.Fa();
    Fh();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */