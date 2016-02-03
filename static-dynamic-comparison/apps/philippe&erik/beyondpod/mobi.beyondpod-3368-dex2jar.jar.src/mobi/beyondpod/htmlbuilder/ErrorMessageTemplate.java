package mobi.beyondpod.htmlbuilder;

import java.util.HashMap;
import java.util.List;
import mobi.beyondpod.R.raw;

public class ErrorMessageTemplate
  extends InfoMessageTemplate
{
  private static List<TemplateBase.KeyValuePair> _Template;
  
  public ErrorMessageTemplate(int paramInt)
  {
    super(paramInt);
  }
  
  public List<TemplateBase.KeyValuePair> Template()
  {
    if (_Template == null)
    {
      this._TemplateResourceId = R.raw.error_message;
      _Template = LoadTemplate();
    }
    return _Template;
  }
  
  public String getMessage()
  {
    return (String)this._Parameters.get("#MESSAGE#");
  }
  
  public void setMessage(String paramString)
  {
    this._Parameters.put("#MESSAGE#", paramString.replace("\n", "<br/>"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/htmlbuilder/ErrorMessageTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */