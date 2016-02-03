package org.codehaus.jackson.format;

import java.io.InputStream;
import java.util.Collection;
import org.codehaus.jackson.JsonFactory;

public class DataFormatDetector
{
  public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
  protected final JsonFactory[] _detectors;
  protected final int _maxInputLookahead;
  protected final MatchStrength _minimalMatch;
  protected final MatchStrength _optimalMatch;
  
  public DataFormatDetector(Collection paramCollection)
  {
    this((JsonFactory[])paramCollection.toArray(new JsonFactory[paramCollection.size()]));
  }
  
  public DataFormatDetector(JsonFactory... paramVarArgs)
  {
    this(paramVarArgs, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
  }
  
  private DataFormatDetector(JsonFactory[] paramArrayOfJsonFactory, MatchStrength paramMatchStrength1, MatchStrength paramMatchStrength2, int paramInt)
  {
    this._detectors = paramArrayOfJsonFactory;
    this._optimalMatch = paramMatchStrength1;
    this._minimalMatch = paramMatchStrength2;
    this._maxInputLookahead = paramInt;
  }
  
  private DataFormatMatcher _findFormat(InputAccessor.Std paramStd)
  {
    JsonFactory[] arrayOfJsonFactory = this._detectors;
    int j = arrayOfJsonFactory.length;
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    Object localObject4;
    if (i < j)
    {
      localObject3 = arrayOfJsonFactory[i];
      paramStd.reset();
      localObject4 = ((JsonFactory)localObject3).hasFormat(paramStd);
      if (localObject4 != null) {
        if (((MatchStrength)localObject4).ordinal() >= this._minimalMatch.ordinal()) {}
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localObject1 == null) || (((MatchStrength)localObject2).ordinal() < ((MatchStrength)localObject4).ordinal()))
      {
        if (((MatchStrength)localObject4).ordinal() >= this._optimalMatch.ordinal()) {
          for (;;)
          {
            return paramStd.createMatcher((JsonFactory)localObject3, (MatchStrength)localObject4);
            break;
            localObject4 = localObject2;
            localObject3 = localObject1;
          }
        }
        localObject2 = localObject4;
        localObject1 = localObject3;
      }
    }
  }
  
  public DataFormatMatcher findFormat(InputStream paramInputStream)
  {
    return _findFormat(new InputAccessor.Std(paramInputStream, new byte[this._maxInputLookahead]));
  }
  
  public DataFormatMatcher findFormat(byte[] paramArrayOfByte)
  {
    return _findFormat(new InputAccessor.Std(paramArrayOfByte));
  }
  
  public DataFormatDetector withMaxInputLookahead(int paramInt)
  {
    if (paramInt == this._maxInputLookahead) {
      return this;
    }
    return new DataFormatDetector(this._detectors, this._optimalMatch, this._minimalMatch, paramInt);
  }
  
  public DataFormatDetector withMinimalMatch(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == this._minimalMatch) {
      return this;
    }
    return new DataFormatDetector(this._detectors, this._optimalMatch, paramMatchStrength, this._maxInputLookahead);
  }
  
  public DataFormatDetector withOptimalMatch(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == this._optimalMatch) {
      return this;
    }
    return new DataFormatDetector(this._detectors, paramMatchStrength, this._minimalMatch, this._maxInputLookahead);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/format/DataFormatDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */