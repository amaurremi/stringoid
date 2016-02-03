package com.mobisystems.pdf.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.simpleViewer.R.id;
import com.mobisystems.pdf.simpleViewer.R.layout;
import com.mobisystems.pdf.simpleViewer.R.menu;

public class SignatureActivityImpl
  extends FragmentActivity
  implements SignatureActivity
{
  public static final String DOCUMENT_KEY = "DOCUMENT";
  PDFDocumentImpl mDocument;
  private boolean mResumed = false;
  
  private SignatureActivity.Observer getObserver()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(R.id.signatureFragment);
    if ((localFragment != null) && ((localFragment instanceof SignatureActivity.Observer))) {
      return (SignatureActivity.Observer)localFragment;
    }
    return null;
  }
  
  private void handleIntent(Intent paramIntent)
  {
    this.mDocument = ((PDFDocumentImpl)paramIntent.getParcelableExtra("DOCUMENT"));
    paramIntent = getObserver();
    if (paramIntent != null) {
      paramIntent.onDocumentChanged(this.mDocument);
    }
  }
  
  public PDFDocument getDocument()
  {
    return this.mDocument;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.pdf_signature_activity);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(R.menu.pdf_signatures, paramMenu);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    if (this.mResumed) {
      handleIntent(getIntent());
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.menuitem_verify_all_signatures)
    {
      paramMenuItem = getObserver();
      if (paramMenuItem != null) {
        paramMenuItem.verifyAllSignatures();
      }
    }
    do
    {
      do
      {
        return true;
        if (i != R.id.menuitem_timestamp_invisible) {
          break;
        }
        paramMenuItem = getObserver();
      } while (paramMenuItem == null);
      paramMenuItem.timeStampInvisible();
      return true;
      if (i != R.id.menuitem_sign_invisible) {
        break;
      }
      paramMenuItem = getObserver();
    } while (paramMenuItem == null);
    paramMenuItem.signInvisible();
    return true;
    return false;
  }
  
  public void onPause()
  {
    super.onPause();
    this.mResumed = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.mResumed = true;
    handleIntent(getIntent());
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/SignatureActivityImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */