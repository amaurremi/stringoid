package com.mobisystems.pdf.ui;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFMatrix;
import com.mobisystems.pdf.PDFPage;
import com.mobisystems.pdf.PDFText;
import com.mobisystems.pdf.R.layout;
import com.mobisystems.pdf.R.string;
import com.mobisystems.pdf.annotation.Annotation;
import com.mobisystems.pdf.annotation.FreeTextAnnotation;
import com.mobisystems.pdf.annotation.LinkAnnotation;
import com.mobisystems.pdf.annotation.MarkupAnnotation;

public class DocumentFragment
  extends Fragment
  implements DocumentActivity.Observer
{
  int _corruptedPage = -1;
  protected FindTextRequest _findTextRequest;
  PDFView.OnStateChangeListener _onStateChangeListener = new PDFView.OnStateChangeListener()
  {
    public boolean onAnnotationClick(PDFView paramAnonymousPDFView, Annotation paramAnonymousAnnotation)
    {
      boolean bool2 = false;
      boolean bool1;
      if (LinkAnnotation.class.isInstance(paramAnonymousAnnotation))
      {
        Utils.executePDFAction(((LinkAnnotation)paramAnonymousAnnotation).getAction(), DocumentFragment.this._pdfView.currentPage(), (DocumentActivity)DocumentFragment.this.getActivity(), DocumentFragment.this.getActivity());
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          if (MarkupAnnotation.class.isInstance(paramAnonymousAnnotation)) {
            break;
          }
          bool1 = bool2;
        } while (!FreeTextAnnotation.class.isInstance(paramAnonymousAnnotation));
        bool1 = bool2;
      } while (DocumentFragment.this._pdfView.isEditingAnnotation());
      DocumentFragment.this._pdfView.editAnnotation(paramAnonymousAnnotation, true);
      return true;
    }
    
    public void onAnnotationEditorDismiss(PDFView paramAnonymousPDFView, AnnotationEditorView paramAnonymousAnnotationEditorView)
    {
      DocumentFragment.this.getDocumentActivity().onAnnotationEndEditing(paramAnonymousAnnotationEditorView);
    }
    
    public void onAnnotationEditorStart(PDFView paramAnonymousPDFView, AnnotationEditorView paramAnonymousAnnotationEditorView, boolean paramAnonymousBoolean)
    {
      DocumentFragment.this.getDocumentActivity().onAnnotationStartEditing(paramAnonymousAnnotationEditorView, paramAnonymousBoolean);
    }
    
    public boolean onAnnotationLongPress(PDFView paramAnonymousPDFView, Annotation paramAnonymousAnnotation)
    {
      return (paramAnonymousAnnotation instanceof LinkAnnotation);
    }
    
    public void onContentLoadError(PDFView paramAnonymousPDFView, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      if (paramAnonymousInt != paramAnonymousPDFView.currentPage()) {}
      while (DocumentFragment.this._corruptedPage == paramAnonymousInt) {
        return;
      }
      Toast.makeText(DocumentFragment.this.getActivity(), R.string.pdf_toast_page_contains_errors, 1).show();
      DocumentFragment.this._corruptedPage = paramAnonymousInt;
    }
    
    public boolean onContextMenu(PDFView.ContextMenuType paramAnonymousContextMenuType, boolean paramAnonymousBoolean, Point paramAnonymousPoint)
    {
      if (paramAnonymousBoolean) {
        return DocumentFragment.this.getDocumentActivity().showContextMenu(paramAnonymousContextMenuType, paramAnonymousPoint);
      }
      return DocumentFragment.this.getDocumentActivity().hideContextMenu();
    }
    
    public void onPageLoadFailed(PDFView paramAnonymousPDFView, int paramAnonymousInt, Throwable paramAnonymousThrowable)
    {
      if (paramAnonymousInt != paramAnonymousPDFView.currentPage()) {}
      do
      {
        return;
        DocumentFragment.this._updateCurrentHighlight = false;
      } while (DocumentFragment.this._corruptedPage == paramAnonymousInt);
      Toast.makeText(DocumentFragment.this.getActivity(), R.string.pdf_toast_page_contains_errors, 1).show();
      DocumentFragment.this._corruptedPage = paramAnonymousInt;
    }
    
    public void onPageLoaded(PDFView paramAnonymousPDFView, int paramAnonymousInt)
    {
      int j = 0;
      if (paramAnonymousInt != paramAnonymousPDFView.currentPage()) {}
      for (;;)
      {
        return;
        DocumentFragment.this._corruptedPage = -1;
        if (DocumentFragment.this._updateCurrentHighlight)
        {
          DocumentFragment.this._updateCurrentHighlight = false;
          int i = 0;
          while (j < paramAnonymousPDFView.renderedPagesCount())
          {
            if (paramAnonymousPDFView.firstRenderedPage() + j == paramAnonymousInt)
            {
              j = i;
              if (DocumentFragment.this.getDocumentActivity().getSearchDirection() == DocumentActivity.SearchDirection.BACKWORD) {
                j = i + (paramAnonymousPDFView.getPageHighlighsCount(paramAnonymousInt) - 1);
              }
              paramAnonymousPDFView.setCurrentHighlight(j);
              return;
            }
            i += paramAnonymousPDFView.getPageHighlighsCount(paramAnonymousPDFView.firstRenderedPage() + j);
            j += 1;
          }
        }
      }
    }
  };
  PDFView _pdfView;
  boolean _updateCurrentHighlight = false;
  
  public int currentPage()
  {
    if (this._pdfView == null) {
      return -1;
    }
    return this._pdfView.currentPage();
  }
  
  DocumentActivity getDocumentActivity()
  {
    return (DocumentActivity)getActivity();
  }
  
  public PDFView getPDFView()
  {
    return this._pdfView;
  }
  
  public void onContentModeChanged(DocumentActivity.ContentMode paramContentMode)
  {
    switch (paramContentMode)
    {
    default: 
      return;
    case ???: 
      this._pdfView.setScaleMode(PDFView.ScaleMode.KEEP_SIZE);
      paramContentMode = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics(paramContentMode);
      float f = paramContentMode.densityDpi / 72.0F;
      this._pdfView.scaleTo(f);
      return;
    case ???: 
      this._pdfView.setScaleMode(PDFView.ScaleMode.FIT_INSIDE);
      return;
    }
    this._pdfView.setScaleMode(PDFView.ScaleMode.FIT_WIDTH);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this._pdfView = ((PDFView)paramLayoutInflater.inflate(R.layout.pdf_view, paramViewGroup));
    this._pdfView.setOnSateChangeListener(this._onStateChangeListener);
    onContentModeChanged(getDocumentActivity().getContentMode());
    try
    {
      this._pdfView.setContent(getDocumentActivity().getDocument());
      getDocumentActivity().registerObserver(this);
      return this._pdfView;
    }
    catch (PDFError paramLayoutInflater)
    {
      for (;;)
      {
        paramLayoutInflater.printStackTrace();
        Utils.showError(getActivity(), paramLayoutInflater);
      }
    }
  }
  
  public void onDestroyView()
  {
    getDocumentActivity().unregisterObserver(this);
    this._pdfView = null;
    super.onDestroyView();
  }
  
  public void onDocumentChanged(PDFDocument paramPDFDocument)
  {
    try
    {
      this._pdfView.setContent(paramPDFDocument);
      return;
    }
    catch (PDFError paramPDFDocument)
    {
      paramPDFDocument.printStackTrace();
      Utils.showError(getActivity(), paramPDFDocument);
    }
  }
  
  public void setCurrentPage(int paramInt)
  {
    this._pdfView.scrollToPage(paramInt);
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
      if (!localDocumentActivity.getSearchText().equals(this._pdfView.getHighlightedText()))
      {
        if (this._findTextRequest != null)
        {
          this._findTextRequest.cancel();
          this._findTextRequest = null;
        }
        this._pdfView.setHighlightedText(localDocumentActivity.getSearchText());
        if (this._pdfView.getHighlightsCount() <= 0) {
          break;
        }
        if (localDocumentActivity.getSearchDirection() == DocumentActivity.SearchDirection.FOREWARD) {
          this._pdfView.setCurrentHighlight(0);
        }
        for (;;)
        {
          localDocumentActivity.onSearchFinished(true);
          return;
          this._pdfView.setCurrentHighlight(this._pdfView.getHighlightsCount() - 1);
        }
      }
    } while (this._findTextRequest != null);
    int i = this._pdfView.currentHighlight();
    if (localDocumentActivity.getSearchDirection() == DocumentActivity.SearchDirection.FOREWARD)
    {
      i += 1;
      if (i < this._pdfView.getHighlightsCount())
      {
        this._pdfView.setCurrentHighlight(i);
        localDocumentActivity.onSearchFinished(true);
      }
    }
    else
    {
      i -= 1;
      if (i >= 0)
      {
        this._pdfView.setCurrentHighlight(i);
        localDocumentActivity.onSearchFinished(true);
        return;
      }
    }
    i = this._pdfView.firstRenderedPage();
    if (localDocumentActivity.getSearchDirection() == DocumentActivity.SearchDirection.FOREWARD) {}
    while (bool)
    {
      j = i + this._pdfView.renderedPagesCount();
      i = j;
      if (j < localDocumentActivity.getDocument().pageCount()) {
        break label304;
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
    label304:
    this._findTextRequest = new FindTextRequest(localDocumentActivity.getDocument(), localDocumentActivity.getSearchText(), i, bool);
    RequestQueue.post(this._findTextRequest);
  }
  
  public void stopSearching()
  {
    this._pdfView.setHighlightedText(null);
    if (this._findTextRequest != null) {
      this._findTextRequest.cancel();
    }
    this._findTextRequest = null;
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
      paramThrowable = (DocumentActivity)DocumentFragment.this.getActivity();
      if (paramThrowable == null) {}
      do
      {
        return;
        DocumentFragment.this._findTextRequest = null;
      } while (this._canceled);
      if (this._found)
      {
        DocumentFragment.this._updateCurrentHighlight = true;
        DocumentFragment.this._pdfView.scrollToPage(this._idxPage);
        paramThrowable.onSearchFinished(true);
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
      DocumentFragment.this._findTextRequest = this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/DocumentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */