package com.mobisystems.pdf.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ListView;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFMatrix;
import com.mobisystems.pdf.PDFOutline;
import com.mobisystems.pdf.PDFOutline.Item;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.PDFQuadrilateral;
import com.mobisystems.pdf.R.string;
import com.mobisystems.pdf.actions.PDFAction;
import com.mobisystems.pdf.actions.PDFActionGoTo;
import com.mobisystems.pdf.actions.PDFActionGoToRemote;
import com.mobisystems.pdf.actions.PDFActionNamed;
import com.mobisystems.pdf.actions.PDFActionURI;

public class Utils
{
  public static boolean executePDFAction(PDFAction paramPDFAction, int paramInt, DocumentActivity paramDocumentActivity, Context paramContext)
  {
    if (PDFActionGoTo.class.isInstance(paramPDFAction)) {
      paramDocumentActivity.onGoToPage(((PDFActionGoTo)paramPDFAction).getPage(paramDocumentActivity.getDocument()));
    }
    do
    {
      return true;
      if (!(paramPDFAction instanceof PDFActionURI)) {
        break;
      }
      paramPDFAction = ((PDFActionURI)paramPDFAction).getURI();
    } while (paramPDFAction == null);
    paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramPDFAction)));
    return true;
    if ((paramPDFAction instanceof PDFActionNamed))
    {
      switch (((PDFActionNamed)paramPDFAction).getAction())
      {
      default: 
        return true;
      case 1: 
        paramDocumentActivity.onGoToPage(0);
        return true;
      case 2: 
        paramDocumentActivity.onGoToPage(paramInt - 1);
        return true;
      }
      paramDocumentActivity.onGoToPage(paramInt + 1);
      return true;
    }
    if ((paramPDFAction instanceof PDFActionGoToRemote))
    {
      paramPDFAction = (PDFActionGoToRemote)paramPDFAction;
      paramDocumentActivity = paramPDFAction.getURL();
      if (paramDocumentActivity != null)
      {
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramDocumentActivity)));
        return true;
      }
      paramPDFAction.getFile();
      return true;
    }
    return false;
  }
  
  public static String getErrorMessage(Context paramContext, Throwable paramThrowable)
  {
    String str = paramThrowable.toString();
    int i;
    if (PDFError.class.isInstance(paramThrowable))
    {
      paramThrowable.getMessage();
      i = ((PDFError)paramThrowable).errorCode();
    }
    switch (i)
    {
    default: 
      str = "Unknown error: " + i;
      return str;
    case -1000: 
      return paramContext.getString(R.string.pdf_error_no_memory);
    case -997: 
      return paramContext.getString(R.string.pdf_error_not_implemented);
    case -999: 
    case -998: 
    case -996: 
    case -995: 
    case -992: 
    case -991: 
      return paramContext.getString(R.string.pdf_error_corrupted);
    case -994: 
      return paramContext.getString(R.string.pdf_error_in_use);
    case -993: 
      return paramContext.getString(R.string.pdf_error_access_denied);
    case -990: 
      return paramContext.getString(R.string.pdf_error_unsupported_encryption_method);
    case -989: 
      return paramContext.getString(R.string.pdf_error_unsupported);
    case -988: 
      return paramContext.getString(R.string.pdf_error_storage_full);
    case -987: 
      return paramContext.getString(R.string.pdf_error_http_request);
    case -986: 
      return paramContext.getString(R.string.pdf_error_invalid_certificate);
    }
    return paramContext.getString(R.string.pdf_error_invalid_timestamp);
  }
  
  public static Path quadraterialToPath(PDFQuadrilateral paramPDFQuadrilateral, PDFMatrix paramPDFMatrix, PDFPoint paramPDFPoint)
  {
    Path localPath = new Path();
    paramPDFPoint.set(paramPDFQuadrilateral.x1, paramPDFQuadrilateral.y1);
    paramPDFPoint.convert(paramPDFMatrix);
    localPath.moveTo(paramPDFPoint.x, paramPDFPoint.y);
    paramPDFPoint.set(paramPDFQuadrilateral.x2, paramPDFQuadrilateral.y2);
    paramPDFPoint.convert(paramPDFMatrix);
    localPath.lineTo(paramPDFPoint.x, paramPDFPoint.y);
    paramPDFPoint.set(paramPDFQuadrilateral.x3, paramPDFQuadrilateral.y3);
    paramPDFPoint.convert(paramPDFMatrix);
    localPath.lineTo(paramPDFPoint.x, paramPDFPoint.y);
    paramPDFPoint.set(paramPDFQuadrilateral.x4, paramPDFQuadrilateral.y4);
    paramPDFPoint.convert(paramPDFMatrix);
    localPath.lineTo(paramPDFPoint.x, paramPDFPoint.y);
    localPath.close();
    return localPath;
  }
  
  public static void showAbout(Context paramContext)
  {
    Object localObject = "N/A";
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      localObject = str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(R.string.pdf_simple_viewer_title);
    paramContext.setMessage("Version " + (String)localObject + "\nTODO:");
    paramContext.setPositiveButton(17039370, null);
    paramContext.create().show();
  }
  
  public static void showError(Context paramContext, Throwable paramThrowable)
  {
    paramThrowable = getErrorMessage(paramContext, paramThrowable);
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setIcon(17301659);
    paramContext.setTitle(R.string.pdf_error_dialog_title);
    paramContext.setMessage(paramThrowable);
    paramContext.setPositiveButton(17039370, null);
    paramContext.show();
  }
  
  public static void showOutline(Activity paramActivity, PDFOutline paramPDFOutline)
  {
    OutlineAdapter localOutlineAdapter = new OutlineAdapter(paramPDFOutline);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setAdapter(localOutlineAdapter, new OutlineListener((DocumentActivity)paramActivity, paramPDFOutline));
    paramActivity = localBuilder.create();
    paramActivity.getListView().setChoiceMode(2);
    paramActivity.show();
  }
  
  /* Error */
  public static java.io.File storeFile(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 307	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: invokevirtual 313	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: ldc_w 315
    //   12: ldc_w 317
    //   15: aload_0
    //   16: invokevirtual 321	android/content/Context:getCacheDir	()Ljava/io/File;
    //   19: invokestatic 327	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   22: astore_0
    //   23: new 329	java/io/FileOutputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 332	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: sipush 4000
    //   35: newarray <illegal type>
    //   37: astore 4
    //   39: aload_1
    //   40: aload 4
    //   42: invokevirtual 338	java/io/InputStream:read	([B)I
    //   45: istore_2
    //   46: iload_2
    //   47: ifge +27 -> 74
    //   50: aload_3
    //   51: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   54: aload_1
    //   55: invokevirtual 340	java/io/InputStream:close	()V
    //   58: aload_0
    //   59: areturn
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 341	java/io/IOException:printStackTrace	()V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 342	java/io/FileNotFoundException:printStackTrace	()V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_3
    //   75: aload 4
    //   77: iconst_0
    //   78: iload_2
    //   79: invokevirtual 346	java/io/FileOutputStream:write	([BII)V
    //   82: goto -43 -> 39
    //   85: astore_0
    //   86: aload_3
    //   87: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 341	java/io/IOException:printStackTrace	()V
    //   97: aload_1
    //   98: invokevirtual 340	java/io/InputStream:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 341	java/io/IOException:printStackTrace	()V
    //   108: goto -7 -> 101
    //   111: astore_0
    //   112: aload_1
    //   113: invokevirtual 340	java/io/InputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 341	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramContext	Context
    //   0	126	1	paramUri	Uri
    //   45	34	2	i	int
    //   31	56	3	localFileOutputStream	java.io.FileOutputStream
    //   37	39	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   54	58	60	java/io/IOException
    //   0	9	67	java/io/FileNotFoundException
    //   54	58	67	java/io/FileNotFoundException
    //   61	65	67	java/io/FileNotFoundException
    //   97	101	67	java/io/FileNotFoundException
    //   104	108	67	java/io/FileNotFoundException
    //   112	116	67	java/io/FileNotFoundException
    //   116	118	67	java/io/FileNotFoundException
    //   119	123	67	java/io/FileNotFoundException
    //   39	46	85	finally
    //   74	82	85	finally
    //   9	39	92	java/io/IOException
    //   50	54	92	java/io/IOException
    //   86	92	92	java/io/IOException
    //   97	101	103	java/io/IOException
    //   9	39	111	finally
    //   50	54	111	finally
    //   86	92	111	finally
    //   93	97	111	finally
    //   112	116	118	java/io/IOException
  }
  
  static class OutlineListener
    implements DialogInterface.OnClickListener
  {
    DocumentActivity _documentActivity;
    PDFOutline _outline;
    
    OutlineListener(DocumentActivity paramDocumentActivity, PDFOutline paramPDFOutline)
    {
      this._documentActivity = paramDocumentActivity;
      this._outline = paramPDFOutline;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramDialogInterface.dismiss();
      paramDialogInterface = this._outline.get(paramInt).action();
      if (PDFActionGoTo.class.isInstance(paramDialogInterface)) {
        this._documentActivity.onGoToPage(((PDFActionGoTo)paramDialogInterface).getPage(this._documentActivity.getDocument()));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */