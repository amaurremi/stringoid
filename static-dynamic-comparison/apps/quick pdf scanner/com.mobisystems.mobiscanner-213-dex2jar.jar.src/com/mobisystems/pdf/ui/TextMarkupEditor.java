package com.mobisystems.pdf.ui;

import android.util.Log;
import android.view.MotionEvent;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.PDFQuadrilateral;
import com.mobisystems.pdf.PDFText;
import com.mobisystems.pdf.annotation.HighlightAnnotation;
import com.mobisystems.pdf.annotation.TextMarkupAnnotation;

public class TextMarkupEditor
  extends AnnotationEditorView
{
  protected static final String TAG = "TextMarkupEditor";
  Class<? extends TextMarkupAnnotation> type = HighlightAnnotation.class;
  
  public TextMarkupEditor(PDFView paramPDFView)
  {
    super(paramPDFView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new int[2];
    getPDFView().getLocationInWindow((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    getLocationInWindow((int[])localObject);
    int k = localObject[0];
    int m = localObject[1];
    float f1 = paramMotionEvent.getX() - (i - k);
    float f2 = paramMotionEvent.getY() - (j - m);
    Log.d("TextMarkupEditor", "onTouchEvent() x= " + f1 + ", y= " + f2);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      if (this.editedAnnotation != null) {
        removeAnnotation();
      }
      return !setPage(f1, f2);
    case 2: 
      if (this.page == null)
      {
        setPage(f1, f2);
        return true;
      }
      paramMotionEvent = new PDFPoint(f1, f2);
      this.page.deviceToUserPoint(paramMotionEvent);
      i = this.page.getText().getOffset(paramMotionEvent.x, paramMotionEvent.y);
      if (i >= 0)
      {
        paramMotionEvent = (TextMarkupAnnotation)getAnnotation();
        paramMotionEvent.clearQuadrilaterals();
        this.page.getText().setCursor(i, true);
        i = 0;
        for (;;)
        {
          if (i < this.page.getText().quadrilaterals())
          {
            localObject = this.page.getText().getQuadrilateral(i);
            try
            {
              paramMotionEvent.addQuadrilateral(((PDFQuadrilateral)localObject).x1, ((PDFQuadrilateral)localObject).y1, ((PDFQuadrilateral)localObject).x2, ((PDFQuadrilateral)localObject).y2, ((PDFQuadrilateral)localObject).x3, ((PDFQuadrilateral)localObject).y3, ((PDFQuadrilateral)localObject).x4, ((PDFQuadrilateral)localObject).y4);
              i += 1;
            }
            catch (PDFError localPDFError)
            {
              for (;;)
              {
                localPDFError.printStackTrace();
              }
            }
          }
        }
        startBitmapRequest(0, 0);
      }
      return true;
    }
    if (this.page != null)
    {
      if (this.page.text.getSelectionStart() == this.page.text.getSelectionEnd()) {
        removeAnnotation();
      }
      getPDFView().closeAnnotationEditor(true);
    }
    return true;
  }
  
  protected boolean setPage(float paramFloat1, float paramFloat2)
  {
    if (!super.setPage(paramFloat1, paramFloat2)) {
      return false;
    }
    PDFPoint localPDFPoint = new PDFPoint(paramFloat1, paramFloat2);
    this.page.deviceToUserPoint(localPDFPoint);
    int i = this.page.getText().getOffset(localPDFPoint.x, localPDFPoint.y);
    if (i >= 0)
    {
      Log.i("TextMarkupEditor", "Highlight offset " + i);
      this.page.getText().setCursor(i, false);
      addAnnotation(this.type, localPDFPoint, localPDFPoint);
      return true;
    }
    this.page = null;
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/TextMarkupEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */