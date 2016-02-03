package com.mobisystems.pdf.ui;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFMatrix;
import com.mobisystems.pdf.PDFPage;
import com.mobisystems.pdf.PDFSize;
import com.mobisystems.pdf.PDFText;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;
import com.mobisystems.pdf.R.string;
import com.mobisystems.pdf.annotation.Annotation;
import com.mobisystems.pdf.annotation.FreeTextAnnotation;
import com.mobisystems.pdf.annotation.LinkAnnotation;
import com.mobisystems.pdf.annotation.MarkupAnnotation;

public class PageFragment
  extends Fragment
  implements AnnotationTextEditDialog.OnAnnotationTextChangedListener, DocumentActivity.Observer
{
  public static final String KEY_PAGE_NUMBER = "page";
  private static final String TAG = "PageFragment";
  protected Throwable _contentError;
  protected FindTextRequest _findTextRequest;
  PDFView.OnStateChangeListener _onPageStateListener = new PDFView.OnStateChangeListener()
  {
    public boolean onAnnotationClick(PDFView paramAnonymousPDFView, Annotation paramAnonymousAnnotation)
    {
      Log.d("PageFragment", "onAnnotationClick " + paramAnonymousAnnotation);
      if (LinkAnnotation.class.isInstance(paramAnonymousAnnotation)) {
        Utils.executePDFAction(((LinkAnnotation)paramAnonymousAnnotation).getAction(), PageFragment.this._page, (DocumentActivity)PageFragment.this.getActivity(), PageFragment.this.getActivity());
      }
      for (;;)
      {
        return false;
        if ((MarkupAnnotation.class.isInstance(paramAnonymousAnnotation)) || (FreeTextAnnotation.class.isInstance(paramAnonymousAnnotation))) {
          paramAnonymousPDFView.editAnnotation(paramAnonymousAnnotation, true);
        }
      }
    }
    
    public void onAnnotationEditorDismiss(PDFView paramAnonymousPDFView, AnnotationEditorView paramAnonymousAnnotationEditorView) {}
    
    public void onAnnotationEditorStart(PDFView paramAnonymousPDFView, AnnotationEditorView paramAnonymousAnnotationEditorView, boolean paramAnonymousBoolean)
    {
      ((DocumentActivity)PageFragment.this.getActivity()).onAnnotationStartEditing(paramAnonymousAnnotationEditorView, paramAnonymousBoolean);
    }
    
    public boolean onAnnotationLongPress(PDFView paramAnonymousPDFView, Annotation paramAnonymousAnnotation)
    {
      return false;
    }
    
    public void onContentLoadError(PDFView paramAnonymousPDFView, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      PageFragment.this.showContentError(paramAnonymousThrowable);
    }
    
    public boolean onContextMenu(PDFView.ContextMenuType paramAnonymousContextMenuType, boolean paramAnonymousBoolean, Point paramAnonymousPoint)
    {
      if (paramAnonymousBoolean) {
        return PageFragment.this.getDocumentActivity().showContextMenu(paramAnonymousContextMenuType, paramAnonymousPoint);
      }
      return PageFragment.this.getDocumentActivity().hideContextMenu();
    }
    
    public void onPageLoadFailed(PDFView paramAnonymousPDFView, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      PageFragment.this._pageView.setVisibility(8);
      paramAnonymousPDFView = (TextView)PageFragment.this.getActivity().findViewById(R.id.description);
      paramAnonymousPDFView.setText(Utils.getErrorMessage(PageFragment.this.getActivity(), paramAnonymousThrowable));
      paramAnonymousPDFView.setVisibility(0);
    }
    
    public void onPageLoaded(PDFView paramAnonymousPDFView, int paramAnonymousInt)
    {
      PageFragment.this._pageView.setVisibility(0);
      paramAnonymousPDFView = (DocumentActivity)PageFragment.this.getActivity();
      PageFragment.this._pageView.setHighlightedText(paramAnonymousPDFView.getSearchText());
      if (PageFragment.this._pageView.getHighlightsCount() >= 0)
      {
        if (paramAnonymousPDFView.getSearchDirection() != DocumentActivity.SearchDirection.FOREWARD) {
          break label93;
        }
        PageFragment.this._pageView.setCurrentHighlight(0);
      }
      for (;;)
      {
        PageFragment.this.getActivity().findViewById(R.id.description).setVisibility(8);
        return;
        label93:
        PageFragment.this._pageView.setCurrentHighlight(PageFragment.this._pageView.getHighlightsCount() - 1);
      }
    }
  };
  int _page;
  private LinearLayout _pageContainer;
  PDFView _pageView;
  protected boolean _suppressErrorMessages = true;
  private Annotation createdTextAnnotation;
  
  public static PageFragment create(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("page", paramInt);
    PageFragment localPageFragment = new PageFragment();
    localPageFragment.setArguments(localBundle);
    return localPageFragment;
  }
  
  DocumentActivity getDocumentActivity()
  {
    return (DocumentActivity)getActivity();
  }
  
  public PDFView getPDFView()
  {
    return this._pageView;
  }
  
  public void onAnnotationTextChanged(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!(this.createdTextAnnotation instanceof FreeTextAnnotation)) {
          continue;
        }
        ((FreeTextAnnotation)this.createdTextAnnotation).setContentsAndResize(paramString, this._pageView._contentSize.width);
        this.createdTextAnnotation.serialize();
        this._pageView.refreshAnnotationViews();
        this._pageView.reloadContent();
      }
      catch (PDFError paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      this.createdTextAnnotation = null;
      return;
      this.createdTextAnnotation.setContents(paramString);
    }
  }
  
  public void onAnnotationTextDialogDismiss() {}
  
  public void onContentModeChanged(DocumentActivity.ContentMode paramContentMode)
  {
    switch (paramContentMode)
    {
    default: 
      return;
    case ???: 
      this._pageView.setScaleMode(PDFView.ScaleMode.FIT_INSIDE);
      return;
    case ???: 
      this._pageView.setScaleMode(PDFView.ScaleMode.FIT_WIDTH);
      return;
    }
    this._pageView.setScaleMode(PDFView.ScaleMode.KEEP_SIZE);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._page = getArguments().getInt("page");
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this._pageContainer = ((LinearLayout)paramLayoutInflater.inflate(R.layout.pdf_page_fragment, paramViewGroup, false));
    this._pageView = ((PDFView)this._pageContainer.findViewById(R.id.page_view));
    this._pageView.setOnSateChangeListener(this._onPageStateListener);
    updateContent();
    ((DocumentActivity)getActivity()).registerObserver(this);
    return this._pageContainer;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    try
    {
      this._pageView.setContent(null, this._page);
      this._pageView = null;
      ((DocumentActivity)getActivity()).unregisterObserver(this);
      return;
    }
    catch (PDFError localPDFError)
    {
      for (;;)
      {
        localPDFError.printStackTrace();
      }
    }
  }
  
  public void onDocumentChanged(PDFDocument paramPDFDocument)
  {
    updateContent();
  }
  
  public void onPageActivate()
  {
    this._suppressErrorMessages = false;
    if (this._contentError != null) {
      showContentError(this._contentError);
    }
    if (this._pageView != null)
    {
      DocumentActivity localDocumentActivity = getDocumentActivity();
      this._pageView.setHighlightedText(localDocumentActivity.getSearchText());
      if (this._pageView.getHighlightsCount() >= 0)
      {
        if (localDocumentActivity.getSearchDirection() != DocumentActivity.SearchDirection.FOREWARD) {
          break label76;
        }
        this._pageView.setCurrentHighlight(0);
      }
    }
    return;
    label76:
    this._pageView.setCurrentHighlight(this._pageView.getHighlightsCount() - 1);
  }
  
  public void onPageDeactivate()
  {
    this._suppressErrorMessages = true;
    this._pageView.setCurrentHighlight(-1);
    onContentModeChanged(((DocumentActivity)getActivity()).getContentMode());
    stopSearching();
  }
  
  public void setScale(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    paramFloat = localDisplayMetrics.densityDpi * paramFloat / 72.0F;
    this._pageView.scaleTo(paramFloat);
  }
  
  void showContentError(Throwable paramThrowable)
  {
    this._contentError = paramThrowable;
    if (this._suppressErrorMessages) {
      return;
    }
    Toast.makeText(getActivity(), R.string.pdf_toast_page_contains_errors, 0).show();
    this._suppressErrorMessages = true;
  }
  
  public void startSearching()
  {
    boolean bool = true;
    DocumentActivity localDocumentActivity = getDocumentActivity();
    if (localDocumentActivity.getSearchText() == null) {
      stopSearching();
    }
    do
    {
      return;
      if (!localDocumentActivity.getSearchText().equals(this._pageView.getHighlightedText()))
      {
        if (this._findTextRequest != null)
        {
          this._findTextRequest.cancel();
          this._findTextRequest = null;
        }
        this._pageView.setHighlightedText(localDocumentActivity.getSearchText());
        if (this._pageView.getHighlightsCount() <= 0) {
          break;
        }
        if (localDocumentActivity.getSearchDirection() == DocumentActivity.SearchDirection.FOREWARD) {
          this._pageView.setCurrentHighlight(0);
        }
        for (;;)
        {
          localDocumentActivity.onSearchFinished(true);
          return;
          this._pageView.setCurrentHighlight(this._pageView.getHighlightsCount() - 1);
        }
      }
    } while (this._findTextRequest != null);
    int i = this._pageView.currentHighlight();
    if (localDocumentActivity.getSearchDirection() == DocumentActivity.SearchDirection.FOREWARD)
    {
      i += 1;
      if (i < this._pageView.getHighlightsCount())
      {
        this._pageView.setCurrentHighlight(i);
        localDocumentActivity.onSearchFinished(true);
      }
    }
    else
    {
      i -= 1;
      if (i >= 0)
      {
        this._pageView.setCurrentHighlight(i);
        localDocumentActivity.onSearchFinished(true);
        return;
      }
    }
    i = this._page;
    if (localDocumentActivity.getSearchDirection() == DocumentActivity.SearchDirection.FOREWARD) {}
    while (bool)
    {
      j = i + 1;
      i = j;
      if (j < localDocumentActivity.getDocument().pageCount()) {
        break label295;
      }
      localDocumentActivity.onSearchFinished(false);
      return;
      bool = false;
    }
    int j = i - 1;
    i = j;
    if (j < 0)
    {
      localDocumentActivity.onSearchFinished(false);
      return;
    }
    label295:
    this._findTextRequest = new FindTextRequest(localDocumentActivity.getDocument(), localDocumentActivity.getSearchText(), i, bool);
    RequestQueue.post(this._findTextRequest);
  }
  
  public void stopSearching()
  {
    this._pageView.setHighlightedText(null);
    if (this._findTextRequest != null) {
      this._findTextRequest.cancel();
    }
    this._findTextRequest = null;
  }
  
  boolean updateContent()
  {
    DocumentActivity localDocumentActivity = (DocumentActivity)getActivity();
    if (localDocumentActivity.getDocument() == null) {
      return false;
    }
    try
    {
      this._pageView.setContent(localDocumentActivity.getDocument(), this._page);
      onContentModeChanged(localDocumentActivity.getContentMode());
      return true;
    }
    catch (PDFError localPDFError)
    {
      for (;;)
      {
        localPDFError.printStackTrace();
      }
    }
  }
  
  protected class FindTextRequest
    extends RequestQueue.Request
  {
    boolean _canceled = false;
    PDFDocument _document;
    boolean _foreward;
    boolean _found = false;
    int _idxPage;
    String _text;
    
    FindTextRequest(PDFDocument paramPDFDocument, String paramString, int paramInt, boolean paramBoolean)
    {
      this._document = paramPDFDocument;
      this._text = paramString;
      this._idxPage = paramInt;
      this._foreward = paramBoolean;
    }
    
    void cancel()
    {
      this._canceled = true;
    }
    
    public String getText()
    {
      return this._text;
    }
    
    public boolean isForeward()
    {
      return this._foreward;
    }
    
    public void onAsyncExec()
    {
      boolean bool = false;
      PDFPage localPDFPage = new PDFPage(this._document);
      localPDFPage.open(this._idxPage);
      PDFText localPDFText = new PDFText();
      localPDFPage.loadContent(new PDFMatrix(), null, 0, localPDFText);
      if (localPDFText.indexOf(this._text, 0) >= 0) {
        bool = true;
      }
      this._found = bool;
    }
    
    public void onRequestFinished(Throwable paramThrowable)
    {
      paramThrowable = (DocumentActivity)PageFragment.this.getActivity();
      if (paramThrowable == null) {}
      do
      {
        return;
        PageFragment.this._findTextRequest = null;
      } while (this._canceled);
      if (this._found)
      {
        paramThrowable.onSearchFinished(true);
        paramThrowable.onGoToPage(this._idxPage);
        return;
      }
      int i;
      if (this._foreward)
      {
        i = this._idxPage + 1;
        this._idxPage = i;
        if (i >= this._document.pageCount()) {
          paramThrowable.onSearchFinished(false);
        }
      }
      else
      {
        i = this._idxPage - 1;
        this._idxPage = i;
        if (i < 0)
        {
          paramThrowable.onSearchFinished(false);
          return;
        }
      }
      RequestQueue.post(this);
      PageFragment.this._findTextRequest = this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/PageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */