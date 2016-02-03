package com.mobisystems.pdf.ui;

import android.util.Log;
import android.view.MotionEvent;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.annotation.InkAnnotation;

public class InkEditor
  extends AnnotationEditorView
{
  protected static final String TAG = "InkEditor";
  
  public InkEditor(PDFView paramPDFView)
  {
    super(paramPDFView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new int[2];
    getPDFView().getLocationInWindow((int[])localObject);
    int j = localObject[0];
    int i = localObject[1];
    getLocationInWindow((int[])localObject);
    j -= localObject[0];
    int k = i - localObject[1];
    float f1 = paramMotionEvent.getX() - j;
    float f2 = paramMotionEvent.getY() - k;
    Log.d("InkEditor", "onTouchEvent() x= " + f1 + ", y= " + f2);
    localObject = new PDFPoint();
    InkAnnotation localInkAnnotation;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      if ((this.page == null) && (!setPage(f1, f2))) {
        return true;
      }
      localInkAnnotation = (InkAnnotation)getAnnotation();
      ((PDFPoint)localObject).x = (paramMotionEvent.getX() - j);
      ((PDFPoint)localObject).y = (paramMotionEvent.getY() - k);
      this.page.deviceToUserPoint((PDFPoint)localObject);
      try
      {
        localInkAnnotation.moveTo(((PDFPoint)localObject).x, ((PDFPoint)localObject).y);
        return true;
      }
      catch (PDFError paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    case 2: 
      if (this.page == null)
      {
        if (!setPage(f1, f2)) {
          return true;
        }
        localInkAnnotation = (InkAnnotation)getAnnotation();
        ((PDFPoint)localObject).x = (paramMotionEvent.getX() - j);
        ((PDFPoint)localObject).y = (paramMotionEvent.getY() - k);
        this.page.deviceToUserPoint((PDFPoint)localObject);
        try
        {
          localInkAnnotation.moveTo(((PDFPoint)localObject).x, ((PDFPoint)localObject).y);
          return true;
        }
        catch (PDFError paramMotionEvent)
        {
          for (;;)
          {
            paramMotionEvent.printStackTrace();
          }
        }
      }
      int m = paramMotionEvent.getHistorySize();
      if (paramMotionEvent.getPointerCount() > 0)
      {
        localInkAnnotation = (InkAnnotation)getAnnotation();
        i = 0;
        for (;;)
        {
          if (i < m)
          {
            ((PDFPoint)localObject).x = (paramMotionEvent.getHistoricalX(0, i) - j);
            ((PDFPoint)localObject).y = (paramMotionEvent.getHistoricalY(0, i) - k);
            this.page.deviceToUserPoint((PDFPoint)localObject);
            try
            {
              localInkAnnotation.addPoint(((PDFPoint)localObject).x, ((PDFPoint)localObject).y);
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
        ((PDFPoint)localObject).x = (paramMotionEvent.getX() - j);
        ((PDFPoint)localObject).y = (paramMotionEvent.getY() - k);
        this.page.deviceToUserPoint((PDFPoint)localObject);
      }
      try
      {
        localInkAnnotation.addPoint(((PDFPoint)localObject).x, ((PDFPoint)localObject).y);
        startBitmapRequest(0, 0);
        return true;
      }
      catch (PDFError paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    }
    if (this.reloadAnnotationBitmapOnUpEvent) {
      this.editedAnnotation.startBitmapRequest(0, 0);
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
    addAnnotation(InkAnnotation.class, localPDFPoint, localPDFPoint);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/InkEditor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */