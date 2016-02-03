package com.getjar.sdk.comm;

import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Result
  implements Serializable
{
  private static final long serialVersionUID = -6466952006253915476L;
  private Map<String, List<String>> _headers = null;
  private String _requestId = null;
  private String _responseBody = null;
  private byte[] _responseBytes = null;
  private int _responseCode;
  private JSONObject _responseJson = null;
  private int _responseTime = -1;
  private boolean _suppressInternalCallbacks = false;
  
  public Result() {}
  
  public Result(byte[] paramArrayOfByte, Map<String, List<String>> paramMap, int paramInt, String paramString, boolean paramBoolean)
  {
    int j = 0;
    int i = j;
    if (paramMap != null)
    {
      Object localObject = (List)paramMap.get("Content-Type");
      i = j;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        String str;
        do
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          str = (String)((Iterator)localObject).next();
        } while ((!str.toLowerCase(Locale.US).contains("image/png")) && (!str.toLowerCase(Locale.US).contains("image/jpeg")) && (!str.toLowerCase(Locale.US).contains("image/jpg")));
        i = 1;
      }
    }
    if (i != 0) {
      this._responseBytes = paramArrayOfByte;
    }
    for (;;)
    {
      this._headers = paramMap;
      if (this._headers == null) {
        this._headers = new HashMap();
      }
      this._responseCode = paramInt;
      this._requestId = paramString;
      this._suppressInternalCallbacks = paramBoolean;
      validateObjectState();
      return;
      try
      {
        this._responseBody = new String(paramArrayOfByte, "UTF-8");
        if (!StringUtility.isNullOrEmpty(this._responseBody)) {
          this._responseJson = new JSONObject(this._responseBody);
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        Logger.d(Area.COMM.value(), "Response body decoding as UTF-8 string failed", new Object[0]);
      }
      catch (JSONException paramArrayOfByte)
      {
        Logger.d(Area.COMM.value(), "Response body parsing as JSON failed", new Object[0]);
      }
    }
  }
  
  private char getEndChar(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      throw new IllegalStateException(String.format(Locale.US, "Unrecognized start character '%1$c'", new Object[] { Character.valueOf(paramChar) }));
    case '"': 
      return '"';
    case '{': 
      return '}';
    }
    return ']';
  }
  
  private List<String> getResponseBodyValueAsRawString(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str = String.format(Locale.US, "\"%1$s\"", new Object[] { paramString });
    int j = this._responseBody.indexOf(str);
    int i = j;
    if (j < 0) {
      return localArrayList;
    }
    char c;
    for (;;)
    {
      c = this._responseBody.charAt(i);
      if (c != 'n') {
        break;
      }
      i = this._responseBody.indexOf(str, i + 4);
      label77:
      if (i < 0) {
        break label481;
      }
      j = i;
      for (;;)
      {
        i = j;
        if (this._responseBody.charAt(j) == ':') {
          break;
        }
        j += 1;
      }
      while ((this._responseBody.charAt(i) != '"') && (this._responseBody.charAt(i) != '{') && (this._responseBody.charAt(i) != '[') && (this._responseBody.charAt(i) != 'n')) {
        i += 1;
      }
    }
    paramString = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    paramString.addFirst(Character.valueOf(c));
    localLinkedList.addFirst(Character.valueOf(getEndChar(c)));
    int k = i;
    int m = 0;
    while (paramString.size() > 0)
    {
      int i1 = k + 1;
      k = 0;
      int n = 0;
      if (this._responseBody.charAt(i1) == '\\') {
        j = m + 1;
      }
      for (;;)
      {
        m = j;
        k = i1;
        if (n != 0) {
          break;
        }
        if ((((Character)paramString.peek()).charValue() == '"') || (!isStartChar(this._responseBody.charAt(i1)))) {
          break label363;
        }
        paramString.addFirst(Character.valueOf(this._responseBody.charAt(i1)));
        localLinkedList.addFirst(Character.valueOf(getEndChar(this._responseBody.charAt(i1))));
        m = j;
        k = i1;
        break;
        if (m == 1) {
          k = 1;
        }
        j = 0;
        n = k;
      }
      label363:
      m = j;
      k = i1;
      if (((Character)localLinkedList.peek()).charValue() == this._responseBody.charAt(i1))
      {
        paramString.removeFirst();
        localLinkedList.removeFirst();
        m = j;
        k = i1;
      }
    }
    j = k + 1;
    if (c == '"') {}
    for (paramString = this._responseBody.substring(i + 1, j - 1);; paramString = this._responseBody.substring(i, j))
    {
      if ((!StringUtility.isNullOrEmpty(paramString)) && (!"null".equalsIgnoreCase(paramString))) {
        localArrayList.add(paramString);
      }
      i = this._responseBody.indexOf(str, j);
      break label77;
      label481:
      break;
    }
  }
  
  private boolean isStartChar(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isSuccessfulCreationResponse(int paramInt)
  {
    return paramInt == 201;
  }
  
  public static boolean isSuccessfulResponse(int paramInt)
  {
    return (paramInt == 200) || (paramInt == 201);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this._responseBody = paramObjectInputStream.readUTF();
    if (!StringUtility.isNullOrEmpty(this._responseBody)) {}
    try
    {
      this._responseJson = new JSONObject(this._responseBody);
      this._responseCode = paramObjectInputStream.readInt();
      this._requestId = paramObjectInputStream.readUTF();
      this._suppressInternalCallbacks = paramObjectInputStream.readBoolean();
      this._headers = ((Map)paramObjectInputStream.readObject());
      this._responseTime = paramObjectInputStream.readInt();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramObjectInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Logger.d(Area.COMM.value(), localJSONException, "Cached response body parsing as JSON failed", new Object[0]);
      }
      this._responseBytes = null;
      if (localJSONException.size() > 0) {
        this._responseBytes = localJSONException.toByteArray();
      }
      validateObjectState();
    }
  }
  
  private void validateObjectState()
  {
    if (this._responseCode < 0) {
      throw new IllegalStateException("'responseCode' can not be less than zero");
    }
    if (this._headers == null) {
      throw new IllegalStateException("'headers' can not be NULL");
    }
    if (this._responseTime < -1) {
      throw new IllegalStateException("'responseTime' must be greater than -1");
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    validateObjectState();
    if (this._responseBody != null) {}
    for (String str = this._responseBody;; str = "")
    {
      paramObjectOutputStream.writeUTF(str);
      paramObjectOutputStream.writeInt(this._responseCode);
      paramObjectOutputStream.writeUTF(this._requestId);
      paramObjectOutputStream.writeBoolean(this._suppressInternalCallbacks);
      paramObjectOutputStream.writeObject(this._headers);
      paramObjectOutputStream.writeInt(this._responseTime);
      if (this._responseBytes != null) {
        paramObjectOutputStream.write(this._responseBytes);
      }
      return;
    }
  }
  
  public boolean checkForCallerUnauthorized()
    throws JSONException
  {
    return (this._responseJson != null) && (this._responseJson.has("error")) && (this._responseJson.getJSONObject("error").has("code")) && (this._responseJson.getJSONObject("error").getString("code").equalsIgnoreCase("CALLER_UNAUTHORIZED"));
  }
  
  public boolean checkForNonReAuthableSubCodes()
    throws JSONException
  {
    if ((checkForCallerUnauthorized()) && (this._responseJson != null) && (this._responseJson.getJSONObject("error") != null) && (this._responseJson.getJSONObject("error").has("subcode")))
    {
      String str = this._responseJson.getJSONObject("error").getString("subcode");
      if (!StringUtility.isNullOrEmpty(str))
      {
        str = str.toLowerCase(Locale.US);
        if ((str.equals("no_reauth")) || (str.equals("unsupported_device")) || (str.equals("missing_capability")) || (str.equals("signature_verification_failed")) || (str.startsWith("black_listed"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean checkForNonReAuthableSubCodesAndMakeCallbacks(CommContext paramCommContext)
    throws JSONException
  {
    boolean bool1 = false;
    if (checkForCallerUnauthorized())
    {
      boolean bool2 = checkForNonReAuthableSubCodes();
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this._responseJson != null)
        {
          String str = this._responseJson.getJSONObject("error").getString("subcode");
          if (!this._suppressInternalCallbacks) {
            paramCommContext.makeAuthorizationFailureCallbacks(str);
          }
          Logger.v(Area.COMM.value() | Area.AUTH.value(), "checkForNonReAuthableSubCodesAndMakeCallbacks() found subCode:%1$s", new Object[] { str });
          bool1 = bool2;
        }
      }
    }
    Logger.v(Area.COMM.value() | Area.AUTH.value(), "checkForNonReAuthableSubCodesAndMakeCallbacks() returning %1$s", new Object[] { Boolean.valueOf(bool1) });
    return bool1;
  }
  
  public boolean checkForUnauthorizedAndOKToReAuth(CommContext paramCommContext)
    throws JSONException
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (checkForCallerUnauthorized())
    {
      bool2 = true;
      bool1 = checkForNonReAuthableSubCodesAndMakeCallbacks(paramCommContext);
    }
    boolean bool3;
    long l1;
    long l2;
    if ((bool2) && (!bool1))
    {
      bool3 = true;
      if (bool2)
      {
        l1 = Area.COMM.value();
        l2 = Area.AUTH.value();
        if (getResponseJson() == null) {
          break label116;
        }
      }
    }
    label116:
    for (paramCommContext = getResponseJson().toString(4);; paramCommContext = "")
    {
      Logger.v(l1 | l2, "checkForUnauthorizedAndOKToReAuth() isUnauthorized=%1$s and isNotOKToReAuth=%2$s, returning %3$s for:\r\n%4$s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3), paramCommContext });
      return bool3;
      bool3 = false;
      break;
    }
  }
  
  public String getErrorResponseCode()
  {
    try
    {
      if ((this._responseJson != null) && (this._responseJson.has("error")) && (this._responseJson.getJSONObject("error").has("code")))
      {
        String str = this._responseJson.getJSONObject("error").getString("code");
        return str;
      }
    }
    catch (Exception localException)
    {
      Logger.e(Area.COMM.value(), localException, "Unable to get an error code from '%1$s'", new Object[] { this._responseBody });
    }
    return null;
  }
  
  public String getErrorResponseSubcode()
  {
    try
    {
      if ((this._responseJson != null) && (this._responseJson.has("error")) && (this._responseJson.getJSONObject("error").has("subcode")))
      {
        String str = this._responseJson.getJSONObject("error").getString("subcode");
        return str;
      }
    }
    catch (Exception localException)
    {
      Logger.e(Area.COMM.value(), localException, "Unable to get an error subcode from '%1$s'", new Object[] { this._responseBody });
    }
    return null;
  }
  
  public int getEstimatedResponseSizeInBytes()
  {
    int i = 8;
    if (this._responseBody != null) {
      i = 8 + this._responseBody.getBytes().length;
    }
    int j;
    for (;;)
    {
      j = i;
      if (this._headers == null) {
        break;
      }
      Iterator localIterator = this._headers.keySet().iterator();
      do
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        j = i;
        if (!StringUtility.isNullOrEmpty((String)localObject)) {
          j = i + ((String)localObject).getBytes().length;
        }
        i = j;
      } while (this._headers.get(localObject) == null);
      Object localObject = ((List)this._headers.get(localObject)).iterator();
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        String str = (String)((Iterator)localObject).next();
        if (!StringUtility.isNullOrEmpty(str)) {
          j += str.getBytes().length;
        }
      }
      if (this._responseBytes != null) {
        i = 8 + this._responseBytes.length;
      }
    }
    return j;
  }
  
  public Map<String, List<String>> getHeaders()
  {
    return this._headers;
  }
  
  public List<String> getLicenseSignatures()
  {
    localArrayList = new ArrayList();
    try
    {
      if ((this._responseJson != null) && (this._responseJson.has("return")))
      {
        if ((this._responseJson.getJSONObject("return").has("license_signature")) && (!this._responseJson.getJSONObject("return").isNull("license_signature")) && (!"null".equalsIgnoreCase(this._responseJson.getJSONObject("return").getString("license_signature"))))
        {
          localArrayList.add(this._responseJson.getJSONObject("return").getString("license_signature"));
          return localArrayList;
        }
        if (this._responseJson.getJSONObject("return").has("licenses"))
        {
          JSONArray localJSONArray = this._responseJson.getJSONObject("return").getJSONArray("licenses");
          int i = 0;
          while (i < localJSONArray.length())
          {
            if ((localJSONArray.getJSONObject(i).has("signature")) && (!localJSONArray.getJSONObject(i).isNull("signature")) && (!"null".equalsIgnoreCase(localJSONArray.getJSONObject(i).getString("signature")))) {
              localArrayList.add(localJSONArray.getJSONObject(i).getString("signature"));
            }
            i += 1;
          }
        }
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      Logger.e(Area.COMM.value(), localJSONException, "getLicenseSignatures() failed", new Object[0]);
    }
  }
  
  public String getRequestId()
  {
    return this._requestId;
  }
  
  public String getResponseBody()
  {
    return this._responseBody;
  }
  
  public byte[] getResponseBytes()
  {
    return this._responseBytes;
  }
  
  public int getResponseCode()
  {
    return this._responseCode;
  }
  
  public JSONObject getResponseJson()
  {
    return this._responseJson;
  }
  
  public int getResponseTime()
  {
    return this._responseTime;
  }
  
  public List<String> getSignedLicenseData()
  {
    try
    {
      if ((this._responseJson != null) && (this._responseJson.has("return")))
      {
        if (this._responseJson.getJSONObject("return").has("signed_license_data")) {
          return getResponseBodyValueAsRawString("signed_license_data");
        }
        if (this._responseJson.getJSONObject("return").has("licenses"))
        {
          List localList = getResponseBodyValueAsRawString("signed_data");
          return localList;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Logger.e(Area.COMM.value(), localJSONException, "getSignedLicenseData() failed", new Object[0]);
    }
    return new ArrayList();
  }
  
  public String getSignedTransactionData()
  {
    List localList = getResponseBodyValueAsRawString("signed_transaction_data");
    if ((localList != null) && (localList.size() > 0)) {
      return (String)localList.get(0);
    }
    return null;
  }
  
  public String getTransactionSignature()
  {
    try
    {
      if ((this._responseJson != null) && (this._responseJson.has("return")) && (this._responseJson.getJSONObject("return").has("transaction_signature")) && (!this._responseJson.getJSONObject("return").isNull("transaction_signature")))
      {
        String str = this._responseJson.getJSONObject("return").getString("transaction_signature");
        return str;
      }
    }
    catch (JSONException localJSONException)
    {
      Logger.e(Area.COMM.value(), localJSONException, "getTransactionSignature() failed", new Object[0]);
    }
    return null;
  }
  
  public boolean isSuccessfulCreationResponse()
  {
    return isSuccessfulCreationResponse(getResponseCode());
  }
  
  public boolean isSuccessfulResponse()
  {
    return isSuccessfulResponse(getResponseCode());
  }
  
  public void setResponseTime(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("'responseTime' must be greater than 0");
    }
    this._responseTime = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */