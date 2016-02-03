package com.mobisystems.pdf.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFTrace;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;
import com.mobisystems.pdf.UtilsSE;
import com.mobisystems.pdf.form.PDFForm;
import com.mobisystems.pdf.signatures.PDFPrivateKeyImpl;
import com.mobisystems.pdf.signatures.PDFSignature;
import com.mobisystems.pdf.signatures.PDFSignatureCache;
import com.mobisystems.pdf.signatures.PDFSignatureFormField;
import com.mobisystems.pdf.signatures.PDFSignatureStrings;
import com.mobisystems.pdf.signatures.PDFSigningInfo;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

public class SignatureFragment
  extends ListFragment
  implements SignatureActivity.Observer
{
  private static final String COLUMN_SIG_STATUS = "Status";
  private static final String COLUMN_SIG_TYPE = "Type";
  Activity mActivity;
  final Object mActivitySync = new Object();
  SimpleAdapter mAdapter;
  PDFDocument mDocument;
  ListView mListView;
  boolean mProcessing = false;
  
  private HashMap<String, String> loadSigContent(PDFSignature paramPDFSignature)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Type", PDFSignatureStrings.sigType(paramPDFSignature.getType()));
    localHashMap.put("Status", PDFSignatureStrings.sigStatus(paramPDFSignature.getStatus()));
    return localHashMap;
  }
  
  private void reloadContent()
  {
    int i = R.id.signatureTypeView;
    int j = R.id.signatureStatusView;
    Vector localVector = new Vector();
    if (this.mDocument != null) {
      try
      {
        PDFSignatureCache localPDFSignatureCache = this.mDocument.getSignatureCache();
        for (PDFSignature localPDFSignature = localPDFSignatureCache.findNext(null); localPDFSignature != null; localPDFSignature = localPDFSignatureCache.findNext(localPDFSignature)) {
          localVector.add(loadSigContent(localPDFSignature));
        }
      }
      catch (PDFError localPDFError)
      {
        PDFTrace.e("Error loading signature list", localPDFError);
        Utils.showError(this.mActivity, localPDFError);
      }
    }
    tmp99_96[0] = "Type";
    String[] tmp104_99 = tmp99_96;
    tmp104_99[1] = "Status";
    this.mAdapter = new SimpleAdapter(this.mActivity, localVector, R.layout.pdf_signature_list_item, tmp104_99, new int[] { i, j });
    setListAdapter(this.mAdapter);
    setLoadingViews(false);
  }
  
  private void setLoadingViews(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getView().findViewById(R.id.sigListEmpty).setVisibility(8);
      this.mListView.setEmptyView(getView().findViewById(R.id.docListLoadingProgressBar));
      return;
    }
    getView().findViewById(R.id.docListLoadingProgressBar).setVisibility(8);
    this.mListView.setEmptyView(getView().findViewById(R.id.sigListEmpty));
  }
  
  private void signInvisible(String paramString)
  {
    if ((this.mActivity != null) && (this.mDocument != null) && (!this.mProcessing))
    {
      setListAdapter(null);
      setLoadingViews(true);
    }
    try
    {
      String str = this.mDocument.getPath() + ".signed.pdf";
      PDFSigningInfo localPDFSigningInfo = new PDFSigningInfo();
      localPDFSigningInfo.setType(2);
      localPDFSigningInfo.setFilter(1);
      localPDFSigningInfo.setSubFilter(2);
      localPDFSigningInfo.setDigestAlgorithm(1);
      localPDFSigningInfo.setEncryptAlgorithm(1);
      localPDFSigningInfo.setTime(UtilsSE.toPdfDateString(new Date()));
      this.mProcessing = true;
      RequestQueue.post(new SignInvisibleRequest(this.mActivity, this.mDocument, paramString, localPDFSigningInfo, str));
      return;
    }
    catch (PDFError paramString)
    {
      this.mProcessing = false;
      PDFTrace.e("Error while signing invisible", paramString);
      Utils.showError(this.mActivity, paramString);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mListView = getListView();
    if (this.mProcessing)
    {
      setListAdapter(null);
      setLoadingViews(true);
    }
    while (this.mDocument == null) {
      return;
    }
    reloadContent();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    synchronized (this.mActivitySync)
    {
      this.mActivity = paramActivity;
      PDFSignatureStrings.init(this.mActivity);
      if ((this.mActivity instanceof SignatureActivity)) {
        this.mDocument = ((SignatureActivity)this.mActivity).getDocument();
      }
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.pdf_signature_fragment, paramViewGroup, false);
  }
  
  public void onDetach()
  {
    super.onDetach();
    synchronized (this.mActivitySync)
    {
      this.mActivity = null;
      return;
    }
  }
  
  public void onDocumentChanged(PDFDocument paramPDFDocument)
  {
    this.mDocument = paramPDFDocument;
    if ((this.mActivity != null) && (!this.mProcessing)) {
      reloadContent();
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  @TargetApi(14)
  public void signInvisible()
  {
    if ((this.mActivity != null) && (this.mDocument != null) && (!this.mProcessing))
    {
      if (Build.VERSION.SDK_INT >= 14) {
        KeyChain.choosePrivateKeyAlias(this.mActivity, new KeyChainListener(), new String[] { "RSA" }, null, null, -1, null);
      }
    }
    else {
      return;
    }
    Toast.makeText(this.mActivity, "Signing requires Android version 4.0 or later", 0).show();
  }
  
  public void timeStampInvisible()
  {
    if ((this.mActivity != null) && (this.mDocument != null) && (!this.mProcessing))
    {
      setListAdapter(null);
      setLoadingViews(true);
    }
    try
    {
      String str = this.mDocument.getPath() + ".timestamped.pdf";
      PDFSigningInfo localPDFSigningInfo = new PDFSigningInfo();
      localPDFSigningInfo.setType(4);
      localPDFSigningInfo.setFilter(1);
      localPDFSigningInfo.setSubFilter(16);
      localPDFSigningInfo.setDigestAlgorithm(1);
      localPDFSigningInfo.setCreateTimestamp(true);
      localPDFSigningInfo.setTimeStampServerURL("https://timestamp.geotrust.com/tsa");
      localPDFSigningInfo.setAddRevInfo(true);
      this.mProcessing = true;
      RequestQueue.post(new TimeStampInvisibleRequest(this.mDocument, localPDFSigningInfo, str));
      return;
    }
    catch (PDFError localPDFError)
    {
      this.mProcessing = false;
      PDFTrace.e("Error while timestamping invisible", localPDFError);
      Utils.showError(this.mActivity, localPDFError);
    }
  }
  
  public void verifyAllSignatures()
  {
    if ((this.mDocument != null) && (!this.mProcessing))
    {
      setListAdapter(null);
      setLoadingViews(true);
      this.mProcessing = true;
      RequestQueue.post(new VerifySignaturesRequest(this.mDocument));
    }
  }
  
  @TargetApi(14)
  class KeyChainListener
    implements KeyChainAliasCallback
  {
    KeyChainListener() {}
    
    public void alias(String paramString)
    {
      if (paramString != null) {
        synchronized (SignatureFragment.this.mActivitySync)
        {
          if (SignatureFragment.this.mActivity != null) {
            SignatureFragment.this.mActivity.runOnUiThread(new KeyChainListenerRunnable(paramString));
          }
          return;
        }
      }
    }
    
    class KeyChainListenerRunnable
      implements Runnable
    {
      private String mAlias;
      
      public KeyChainListenerRunnable(String paramString)
      {
        this.mAlias = paramString;
      }
      
      public void run()
      {
        SignatureFragment.this.signInvisible(this.mAlias);
      }
    }
  }
  
  class SignInvisibleRequest
    extends RequestQueue.Request
  {
    Context mContext;
    String mDestPath;
    String mKeyAlias;
    PDFDocument mReqDocument;
    PDFSigningInfo mSigningInfo;
    
    SignInvisibleRequest(Context paramContext, PDFDocument paramPDFDocument, String paramString1, PDFSigningInfo paramPDFSigningInfo, String paramString2)
    {
      this.mReqDocument = paramPDFDocument;
      this.mKeyAlias = paramString1;
      this.mSigningInfo = paramPDFSigningInfo;
      this.mDestPath = paramString2;
      this.mContext = paramContext;
    }
    
    public void onAsyncExec()
    {
      this.mReqDocument.loadFullPermissions();
      this.mReqDocument.pushState();
      this.mReqDocument.getForm().addInvisibleSignatureField().sign(new PDFPrivateKeyImpl(this.mContext, this.mKeyAlias), this.mSigningInfo, this.mDestPath);
      this.mReqDocument.popState();
    }
    
    public void onRequestFinished(Throwable paramThrowable)
    {
      SignatureFragment.this.mProcessing = false;
      if (SignatureFragment.this.mActivity == null) {
        return;
      }
      if (paramThrowable != null) {
        Utils.showError(SignatureFragment.this.mActivity, paramThrowable);
      }
      for (;;)
      {
        SignatureFragment.this.reloadContent();
        return;
        Toast.makeText(SignatureFragment.this.mActivity, "Signed document saved to " + this.mDestPath, 0).show();
      }
    }
  }
  
  class TimeStampInvisibleRequest
    extends RequestQueue.Request
  {
    String mDestPath;
    PDFDocument mReqDocument;
    PDFSigningInfo mSigningInfo;
    
    TimeStampInvisibleRequest(PDFDocument paramPDFDocument, PDFSigningInfo paramPDFSigningInfo, String paramString)
    {
      this.mReqDocument = paramPDFDocument;
      this.mSigningInfo = paramPDFSigningInfo;
      this.mDestPath = paramString;
    }
    
    public void onAsyncExec()
    {
      this.mReqDocument.loadFullPermissions();
      this.mReqDocument.pushState();
      this.mReqDocument.getForm().addInvisibleSignatureField().sign(null, this.mSigningInfo, this.mDestPath);
      this.mReqDocument.popState();
    }
    
    public void onRequestFinished(Throwable paramThrowable)
    {
      SignatureFragment.this.mProcessing = false;
      if (SignatureFragment.this.mActivity == null) {
        return;
      }
      if (paramThrowable != null) {
        Utils.showError(SignatureFragment.this.mActivity, paramThrowable);
      }
      for (;;)
      {
        SignatureFragment.this.reloadContent();
        return;
        Toast.makeText(SignatureFragment.this.mActivity, "Timestamped document saved to " + this.mDestPath, 0).show();
      }
    }
  }
  
  class VerifySignaturesRequest
    extends RequestQueue.Request
  {
    PDFDocument mReqDocument;
    
    VerifySignaturesRequest(PDFDocument paramPDFDocument)
    {
      this.mReqDocument = paramPDFDocument;
    }
    
    public void onAsyncExec()
    {
      this.mReqDocument.getSignatureCache().verifyAllSignatures(true);
    }
    
    public void onRequestFinished(Throwable paramThrowable)
    {
      SignatureFragment.this.mProcessing = false;
      if (SignatureFragment.this.mActivity == null) {
        return;
      }
      if (paramThrowable != null) {
        Utils.showError(SignatureFragment.this.mActivity, paramThrowable);
      }
      SignatureFragment.this.reloadContent();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/SignatureFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */