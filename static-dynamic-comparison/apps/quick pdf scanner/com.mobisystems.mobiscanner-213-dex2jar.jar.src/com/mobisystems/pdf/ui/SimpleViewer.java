package com.mobisystems.pdf.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.chiralcode.colorpicker.a;
import com.chiralcode.colorpicker.a.a;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFOutline;
import com.mobisystems.pdf.annotation.Annotation;
import com.mobisystems.pdf.annotation.FreeTextAnnotation;
import com.mobisystems.pdf.annotation.HighlightAnnotation;
import com.mobisystems.pdf.annotation.InkAnnotation;
import com.mobisystems.pdf.annotation.MarkupAnnotation;
import com.mobisystems.pdf.annotation.TextAnnotation;
import com.mobisystems.pdf.simpleViewer.R.id;
import com.mobisystems.pdf.simpleViewer.R.layout;
import com.mobisystems.pdf.simpleViewer.R.menu;
import com.mobisystems.pdf.simpleViewer.R.string;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"NewApi"})
public class SimpleViewer
  extends FragmentActivity
  implements a.a, AnnotationTextEditDialog.OnAnnotationTextChangedListener, DocumentActivity, EnterPasswordDialog.SetPasswordActivity, OpacityDialog.OnOpacityChangedListener, ThicknessDialog.ThicknessChangedListener
{
  static final String KEY_DELETE_ON_DESTROY = "pdf.deleteOnDestroy";
  static final String KEY_PASSWORD = "pdf.password";
  static final String KEY_PATH = "pdf.path";
  static final String KEY_TITLE = "pdf.title";
  private static final String TAG = "SimpleViewer";
  static final String TAG_ENTER_PASSWORD_DIALOG = "EnterPasswordDialog";
  ActionMode _actionMode;
  DocumentActivity.ContentMode _contentMode = DocumentActivity.ContentMode.FIT_PAGE;
  boolean _deleteOnDestroy = false;
  PDFDocument _document;
  DocumentFragment _documentFragment;
  ArrayList<DocumentActivity.Observer> _observers = new ArrayList();
  PDFOutline _outline;
  String _password;
  String _path;
  boolean _searchForeward = true;
  String _searchedText;
  boolean _stopEditingOnAnnotationTextChanged = false;
  boolean _textFound;
  String _title;
  
  private void showSignatures()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, SignatureActivityImpl.class);
    localIntent.putExtra("DOCUMENT", this._document);
    startActivity(localIntent);
  }
  
  public void createAnnotation(Class<? extends Annotation> paramClass)
  {
    getPDFView().createAnnotation(paramClass);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      PDFView localPDFView = getPDFView();
      if ((localPDFView == null) || (!localPDFView.isEditingAnnotation())) {
        break label43;
      }
      localPDFView.closeAnnotationEditor(false);
    }
    for (;;)
    {
      return super.dispatchKeyEvent(paramKeyEvent);
      label43:
      if (this._document.isModified()) {
        try
        {
          Log.i("SimpleViewer", "Saving document...");
          this._document.save(null);
        }
        catch (PDFError paramKeyEvent)
        {
          paramKeyEvent.printStackTrace();
        }
      }
    }
    return true;
  }
  
  public DocumentActivity.ContentMode getContentMode()
  {
    return this._contentMode;
  }
  
  PageFragment getCurrentPage()
  {
    return ((DocumentAdapter)getDocumentPager().getPager().D()).getCurrentPageFragment();
  }
  
  public PDFDocument getDocument()
  {
    return this._document;
  }
  
  protected DocumentPager getDocumentPager()
  {
    return (DocumentPager)findViewById(R.id.pager);
  }
  
  public PDFOutline getOutline()
  {
    return this._outline;
  }
  
  PDFView getPDFView()
  {
    if (this._documentFragment != null) {
      return this._documentFragment.getPDFView();
    }
    return getCurrentPage().getPDFView();
  }
  
  public DocumentActivity.SearchDirection getSearchDirection()
  {
    if (this._searchForeward) {
      return DocumentActivity.SearchDirection.FOREWARD;
    }
    return DocumentActivity.SearchDirection.BACKWORD;
  }
  
  public String getSearchText()
  {
    return this._searchedText;
  }
  
  public boolean hideContextMenu()
  {
    return false;
  }
  
  void notifyContentModeChanged()
  {
    Iterator localIterator = this._observers.iterator();
    while (localIterator.hasNext()) {
      ((DocumentActivity.Observer)localIterator.next()).onContentModeChanged(getContentMode());
    }
  }
  
  public void onAnnotationEndEditing(AnnotationEditorView paramAnnotationEditorView)
  {
    paramAnnotationEditorView = this._actionMode;
    this._actionMode = null;
    if (paramAnnotationEditorView != null) {
      paramAnnotationEditorView.finish();
    }
  }
  
  public void onAnnotationStartEditing(AnnotationEditorView paramAnnotationEditorView, boolean paramBoolean)
  {
    paramAnnotationEditorView = paramAnnotationEditorView.getAnnotation();
    if ((paramBoolean) && (((paramAnnotationEditorView instanceof TextAnnotation)) || ((paramAnnotationEditorView instanceof FreeTextAnnotation))))
    {
      AnnotationTextEditDialog.newInstance(paramAnnotationEditorView).show(getSupportFragmentManager(), "AnnotationTextEditDialog");
      this._stopEditingOnAnnotationTextChanged = true;
      return;
    }
    this._actionMode = startActionMode(new AnnotationEditorCallback(paramAnnotationEditorView));
  }
  
  public void onAnnotationTextChanged(String paramString)
  {
    getPDFView().getAnnotationEditor().setContents(paramString);
  }
  
  public void onAnnotationTextDialogDismiss()
  {
    if (this._stopEditingOnAnnotationTextChanged)
    {
      this._stopEditingOnAnnotationTextChanged = false;
      getPDFView().closeAnnotationEditor(true);
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onColorSelected(int paramInt)
  {
    getPDFView().getAnnotationEditor().setColor(paramInt);
    getPDFView().setDefaultAnnotationColor(paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.pdf_simple_viewer_2);
    this._documentFragment = ((DocumentFragment)getSupportFragmentManager().findFragmentById(R.id.pdf_document_fragment));
    if (this._documentFragment == null)
    {
      setContentView(R.layout.pdf_simple_viewer);
      getDocumentPager().getPager().k(3);
    }
    if (paramBundle != null)
    {
      this._path = paramBundle.getString("pdf.path");
      this._title = paramBundle.getString("pdf.title");
      this._password = paramBundle.getString("pdf.password");
      this._deleteOnDestroy = paramBundle.getBoolean("pdf.deleteOnDestroy");
    }
    for (;;)
    {
      setTitle(this._title);
      RequestQueue.post(new LoadDocumentRequest());
      return;
      paramBundle = getIntent().getData();
      if ((paramBundle != null) && (paramBundle.getScheme() != null))
      {
        this._title = paramBundle.getLastPathSegment();
        if (paramBundle.getScheme().equals("file"))
        {
          this._path = paramBundle.getPath();
        }
        else if (paramBundle.getScheme().equals("content"))
        {
          paramBundle = Utils.storeFile(this, paramBundle);
          if (paramBundle != null)
          {
            this._path = paramBundle.getPath();
            this._deleteOnDestroy = true;
          }
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(R.menu.pdf_simple_viewer, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    if ((this._deleteOnDestroy) && (isFinishing())) {
      new File(this._path).delete();
    }
    super.onDestroy();
  }
  
  public void onGoToPage(int paramInt)
  {
    if (this._documentFragment != null)
    {
      this._documentFragment.setCurrentPage(paramInt);
      return;
    }
    getDocumentPager().setCurrentPage(paramInt);
  }
  
  public void onOpacityChanged(int paramInt)
  {
    Annotation localAnnotation = getPDFView().getAnnotationEditor().getAnnotation();
    if ((localAnnotation instanceof MarkupAnnotation))
    {
      ((MarkupAnnotation)localAnnotation).setOpacity(paramInt);
      getPDFView().setDefaultAnnotationOpacity(Integer.valueOf(paramInt));
      getPDFView().getAnnotationEditor().refreshEdittedAnnotation();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_about)
    {
      Utils.showAbout(this);
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.search)
    {
      startSearchActionMode();
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_show_outline)
    {
      paramMenuItem = getSupportFragmentManager().beginTransaction();
      paramMenuItem.add(16908290, new OutlineFragment());
      paramMenuItem.addToBackStack(null);
      paramMenuItem.commit();
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_go_to_page)
    {
      int j = this._document.pageCount();
      if (this._documentFragment != null) {}
      for (int i = this._documentFragment.currentPage();; i = getDocumentPager().getPager().F())
      {
        GoToPageDialog.newInstance(i, j).show(getSupportFragmentManager(), "GoToPageDialog");
        return true;
      }
    }
    if (paramMenuItem.getItemId() == R.id.item_zoom_fit_page)
    {
      this._contentMode = DocumentActivity.ContentMode.FIT_PAGE;
      notifyContentModeChanged();
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_zoom_fit_width)
    {
      this._contentMode = DocumentActivity.ContentMode.FIT_PAGE_WIDTH;
      notifyContentModeChanged();
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_zoom_real_size)
    {
      this._contentMode = DocumentActivity.ContentMode.REAL_SIZE;
      notifyContentModeChanged();
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_add_text)
    {
      createAnnotation(TextAnnotation.class);
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_highlight)
    {
      createAnnotation(HighlightAnnotation.class);
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_add_ink)
    {
      createAnnotation(InkAnnotation.class);
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.item_signatures)
    {
      showSignatures();
      return true;
    }
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = true;
    MenuItem localMenuItem = paramMenu.findItem(R.id.search);
    if ((Build.VERSION.SDK_INT < 11) && (localMenuItem != null)) {
      localMenuItem.setVisible(false);
    }
    localMenuItem = paramMenu.findItem(R.id.item_go_to_page);
    if (localMenuItem != null)
    {
      if (this._document != null)
      {
        bool1 = true;
        localMenuItem.setVisible(bool1);
      }
    }
    else
    {
      localMenuItem = paramMenu.findItem(R.id.item_show_outline);
      if (localMenuItem != null) {
        if (this._outline == null) {
          break label114;
        }
      }
    }
    label114:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMenuItem.setVisible(bool1);
      return super.onPrepareOptionsMenu(paramMenu);
      bool1 = false;
      break;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("pdf.path", this._path);
    paramBundle.putString("pdf.title", this._title);
    if (this._password != null) {
      paramBundle.putString("pdf.password", this._password);
    }
    paramBundle.putBoolean("pdf.deleteOnDestroy", this._deleteOnDestroy);
  }
  
  public void onSearchFinished(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this._textFound = true;
      return;
    }
    if (this._textFound) {}
    for (Toast localToast = Toast.makeText(this, R.string.pdf_toast_no_more_matches, 1);; localToast = Toast.makeText(this, R.string.pdf_toast_text_not_found, 1))
    {
      localToast.show();
      return;
    }
  }
  
  public void onThicknessChanged(float paramFloat)
  {
    getPDFView().getAnnotationEditor().setBorderWidth(paramFloat);
    getPDFView().setDefaultAnnotationLineWidth(paramFloat);
  }
  
  public void registerObserver(DocumentActivity.Observer paramObserver)
  {
    this._observers.add(paramObserver);
  }
  
  public void setPassword(String paramString)
  {
    this._password = paramString;
    RequestQueue.post(new LoadDocumentRequest());
  }
  
  public boolean showContextMenu(PDFView.ContextMenuType paramContextMenuType, Point paramPoint)
  {
    return false;
  }
  
  @SuppressLint({"NewApi"})
  void startSearchActionMode()
  {
    startActionMode(new SearchActionModeCallback());
  }
  
  public void unregisterObserver(DocumentActivity.Observer paramObserver)
  {
    this._observers.remove(paramObserver);
  }
  
  @SuppressLint({"NewApi"})
  class AnnotationEditorCallback
    implements ActionMode.Callback
  {
    Annotation _annotation;
    
    public AnnotationEditorCallback(Annotation paramAnnotation)
    {
      this._annotation = paramAnnotation;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      Log.d("SimpleViewer", "EditMode: onActionItemClicked " + paramMenuItem);
      if (paramMenuItem.getItemId() == R.id.annot_text) {
        AnnotationTextEditDialog.newInstance(this._annotation).show(SimpleViewer.this.getSupportFragmentManager(), "AnnotationTextEditDialog");
      }
      for (;;)
      {
        return false;
        if (paramMenuItem.getItemId() == R.id.annot_color)
        {
          int i = this._annotation.getColorRGB();
          new a(SimpleViewer.this, i, SimpleViewer.this).show();
        }
        else if (paramMenuItem.getItemId() == R.id.annot_opacity)
        {
          paramActionMode = new OpacityDialog();
          paramActionMode.setColor(this._annotation.getColorRGB(), ((MarkupAnnotation)this._annotation).getOpacity());
          paramActionMode.show(SimpleViewer.this.getSupportFragmentManager(), "OpacityDialog");
        }
        else if (paramMenuItem.getItemId() == R.id.annot_thickness)
        {
          paramActionMode = new ThicknessDialog();
          paramActionMode.setThickness(this._annotation.getBorderWidth());
          paramActionMode.show(SimpleViewer.this.getSupportFragmentManager(), "ThicknessDialog");
        }
        else if (paramMenuItem.getItemId() == R.id.annot_delete)
        {
          SimpleViewer.this.getPDFView().getAnnotationEditor().removeAnnotation();
          paramActionMode.finish();
        }
      }
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      paramActionMode.getMenuInflater().inflate(R.menu.pdf_annot_editor, paramMenu);
      paramActionMode = paramMenu.findItem(R.id.annot_opacity);
      if (paramActionMode != null) {
        paramActionMode.setVisible(this._annotation instanceof InkAnnotation);
      }
      paramActionMode = paramMenu.findItem(R.id.annot_thickness);
      if (paramActionMode != null) {
        paramActionMode.setVisible(this._annotation instanceof InkAnnotation);
      }
      return true;
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      Log.d("SimpleViewer", "EditMode: onDestroyActionMode");
      if (SimpleViewer.this.getPDFView().isEditingAnnotation()) {
        SimpleViewer.this.getPDFView().closeAnnotationEditor(true);
      }
      if (SimpleViewer.this._actionMode == paramActionMode) {
        SimpleViewer.this._actionMode = null;
      }
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return false;
    }
  }
  
  class LoadDocumentRequest
    extends RequestQueue.Request
  {
    PDFDocument document;
    PDFOutline outline;
    
    LoadDocumentRequest() {}
    
    public void onAsyncExec()
    {
      this.document = new PDFDocumentImpl(SimpleViewer.this._path, SimpleViewer.this.getBaseContext());
      if (SimpleViewer.this._password != null) {
        PDFError.throwError(this.document.setPassword(SimpleViewer.this._password));
      }
      for (;;)
      {
        PDFError.throwError(this.document.loadPageCount());
        try
        {
          this.outline = new PDFOutline(this.document);
          return;
          if (this.document.requiresPassword()) {
            PDFError.throwError(64543);
          }
        }
        catch (PDFError localPDFError)
        {
          while (localPDFError.errorCode() == 64538) {}
          localPDFError.printStackTrace();
        }
      }
    }
    
    public void onRequestFinished(Throwable paramThrowable)
    {
      if (SimpleViewer.this.isFinishing()) {}
      for (;;)
      {
        return;
        if (paramThrowable != null)
        {
          if ((PDFError.class.isInstance(paramThrowable)) && (((PDFError)paramThrowable).errorCode() == 64543))
          {
            paramThrowable = SimpleViewer.this.getSupportFragmentManager().beginTransaction();
            Fragment localFragment = SimpleViewer.this.getSupportFragmentManager().findFragmentByTag("EnterPasswordDialog");
            if (localFragment != null) {
              paramThrowable.remove(localFragment);
            }
            paramThrowable.commit();
            new EnterPasswordDialog().show(SimpleViewer.this.getSupportFragmentManager(), "EnterPasswordDialog");
            if (SimpleViewer.this._password != null) {
              Toast.makeText(SimpleViewer.this, R.string.pdf_toast_invalid_password, 0).show();
            }
            SimpleViewer.this._password = null;
            return;
          }
          Utils.showError(SimpleViewer.this, paramThrowable);
          return;
        }
        SimpleViewer.this._outline = this.outline;
        SimpleViewer.this._document = this.document;
        SimpleViewer.this.supportInvalidateOptionsMenu();
        if (SimpleViewer.this._documentFragment == null) {
          SimpleViewer.this.getDocumentPager().setAdapter(new DocumentAdapter(SimpleViewer.this.getSupportFragmentManager(), this.document));
        }
        paramThrowable = SimpleViewer.this._observers.iterator();
        while (paramThrowable.hasNext()) {
          ((DocumentActivity.Observer)paramThrowable.next()).onDocumentChanged(this.document);
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  class SearchActionModeCallback
    implements ActionMode.Callback, TextView.OnEditorActionListener
  {
    SearchActionModeCallback() {}
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      updateSearchedText((TextView)paramActionMode.getCustomView());
      if (paramMenuItem.getItemId() == R.id.next)
      {
        SimpleViewer.this._searchForeward = true;
        updateSearchedText((TextView)paramActionMode.getCustomView());
        startSearching();
        return true;
      }
      if (paramMenuItem.getItemId() == R.id.prev)
      {
        SimpleViewer.this._searchForeward = false;
        updateSearchedText((TextView)paramActionMode.getCustomView());
        startSearching();
        return true;
      }
      return false;
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      View localView = SimpleViewer.this.getLayoutInflater().inflate(R.layout.pdf_search_action_view, null);
      ((TextView)localView.findViewById(R.id.search_text)).setOnEditorActionListener(this);
      paramActionMode.setCustomView(localView);
      paramActionMode.getMenuInflater().inflate(R.menu.pdf_search_mode, paramMenu);
      return true;
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      SimpleViewer.this._searchedText = null;
      stopSearching();
    }
    
    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      updateSearchedText(paramTextView);
      startSearching();
      return true;
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return false;
    }
    
    void startSearching()
    {
      if (SimpleViewer.this._documentFragment != null)
      {
        SimpleViewer.this._documentFragment.startSearching();
        return;
      }
      SimpleViewer.this.getCurrentPage().startSearching();
    }
    
    void stopSearching()
    {
      if (SimpleViewer.this._documentFragment != null)
      {
        SimpleViewer.this._documentFragment.stopSearching();
        return;
      }
      SimpleViewer.this.getCurrentPage().stopSearching();
    }
    
    void updateSearchedText(TextView paramTextView)
    {
      paramTextView = paramTextView.getText().toString();
      if (paramTextView.equals(SimpleViewer.this._searchedText)) {
        return;
      }
      if (paramTextView.length() == 0)
      {
        SimpleViewer.this._searchedText = null;
        return;
      }
      SimpleViewer.this._textFound = false;
      SimpleViewer.this._searchedText = paramTextView;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/SimpleViewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */