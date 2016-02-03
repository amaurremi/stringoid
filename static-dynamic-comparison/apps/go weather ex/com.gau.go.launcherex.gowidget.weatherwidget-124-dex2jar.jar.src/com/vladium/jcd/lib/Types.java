package com.vladium.jcd.lib;

import com.vladium.jcd.cls.IAccessFlags;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Types
{
  public static String accessFlagsToString(int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int k = 1;
    int i = 1;
    int j;
    if (paramBoolean)
    {
      j = 0;
      if (j < IAccessFlags.ALL_ACC.length)
      {
        int m = IAccessFlags.ALL_ACC[j];
        k = i;
        if ((paramInt & m) != 0)
        {
          if (i == 0) {
            break label79;
          }
          i = 0;
          label51:
          if (m != 32) {
            break label90;
          }
          localStringBuffer.append("super");
        }
        for (k = i;; k = i)
        {
          j += 1;
          i = k;
          break;
          label79:
          localStringBuffer.append(" ");
          break label51;
          label90:
          localStringBuffer.append(IAccessFlags.ALL_ACC_NAMES[j]);
        }
      }
    }
    else
    {
      j = 0;
      i = k;
      if (j < IAccessFlags.ALL_ACC.length)
      {
        k = i;
        if ((paramInt & IAccessFlags.ALL_ACC[j]) != 0)
        {
          if (i == 0) {
            break label163;
          }
          i = 0;
        }
        for (;;)
        {
          localStringBuffer.append(IAccessFlags.ALL_ACC_NAMES[j]);
          k = i;
          j += 1;
          i = k;
          break;
          label163:
          localStringBuffer.append(" ");
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String[] descriptorToParameterTypes(String paramString)
  {
    try
    {
      Object localObject = new methodDescriptorCompiler(paramString);
      ((methodDescriptorCompiler)localObject).methodDescriptor();
      localObject = ((methodDescriptorCompiler)localObject).getResult();
      return (String[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("error parsing [" + paramString + "]: " + localIOException.toString());
    }
  }
  
  public static String descriptorToReturnType(String paramString)
  {
    int i = paramString.indexOf('(');
    int j = paramString.lastIndexOf(')');
    if ((i < 0) || (j <= 0) || (i >= j) || (j >= paramString.length() - 1)) {
      throw new IllegalArgumentException("malformed method descriptor: [" + paramString + "]");
    }
    return paramString.substring(j + 1);
  }
  
  public static Class descriptorToType(String paramString)
    throws ClassNotFoundException
  {
    return new typeDescriptorCompiler(null).descriptorToClass(paramString);
  }
  
  public static String fullMethodDescriptorToFullUserName(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString2;
    if ("<init>".equals(paramString2)) {
      str = simpleClassName(paramString1);
    }
    paramString2 = str;
    if ("<clinit>".equals(str)) {
      paramString2 = "<static class initializer>";
    }
    return paramString1 + '.' + paramString2 + ' ' + methodDescriptorToUserName(paramString3);
  }
  
  public static String fullMethodDescriptorToUserName(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString2;
    if ("<init>".equals(paramString2)) {
      str = simpleClassName(paramString1);
    }
    paramString1 = str;
    if ("<clinit>".equals(str)) {
      paramString1 = "<static class initializer>";
    }
    return paramString1 + ' ' + methodDescriptorToUserName(paramString3);
  }
  
  public static String getClassPackageName(Class paramClass)
  {
    paramClass = paramClass.getName();
    int i = paramClass.lastIndexOf('.');
    if (i >= 0) {
      return paramClass.substring(0, i);
    }
    return "";
  }
  
  public static String javaNameToVMName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace('.', '/');
  }
  
  public static String methodDescriptorToUserName(String paramString)
  {
    paramString = descriptorToParameterTypes(paramString);
    StringBuffer localStringBuffer = new StringBuffer("(");
    int i = 0;
    if (i < paramString.length)
    {
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      String str = typeDescriptorToUserName(paramString[i]);
      int j = str.lastIndexOf('.');
      if ((j < 0) || (!"java.lang.".equals(str.substring(0, j + 1)))) {
        localStringBuffer.append(str);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(str.substring(j + 1));
      }
    }
    localStringBuffer.append(')');
    return localStringBuffer.toString();
  }
  
  public static String signatureToDescriptor(Method paramMethod)
  {
    if (paramMethod == null) {
      throw new IllegalArgumentException("null input: method");
    }
    return signatureToDescriptor(paramMethod.getParameterTypes(), paramMethod.getReturnType());
  }
  
  public static String signatureToDescriptor(Class[] paramArrayOfClass, Class paramClass)
  {
    return new signatureCompiler(null).signatureDescriptor(paramArrayOfClass, paramClass);
  }
  
  public static String signatureToMethodDescriptor(String[] paramArrayOfString, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("(");
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      i += 1;
    }
    localStringBuffer.append(')');
    localStringBuffer.append(paramString);
    return localStringBuffer.toString();
  }
  
  private static String simpleClassName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(i + 1);
  }
  
  public static String typeDescriptorToUserName(String paramString)
  {
    return new typeDescriptorCompiler2(null).descriptorToClass(paramString);
  }
  
  public static String typeToDescriptor(Class paramClass)
  {
    return new signatureCompiler(null).typeDescriptor(paramClass);
  }
  
  public static String vmNameToJavaName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace('/', '.');
  }
  
  private static class methodDescriptorCompiler
  {
    private PushbackReader m_in;
    final List m_result = new ArrayList();
    private StringBuffer m_token = new StringBuffer();
    
    methodDescriptorCompiler(String paramString)
    {
      this.m_in = new PushbackReader(new StringReader(paramString));
    }
    
    private void consume(char paramChar)
      throws IOException
    {
      char c = (char)this.m_in.read();
      if (c != paramChar) {
        throw new IllegalArgumentException("consumed '" + c + "' while expecting '" + paramChar + "'");
      }
    }
    
    private void newToken()
    {
      this.m_result.add(this.m_token.toString());
      this.m_token.setLength(0);
    }
    
    void arrayType()
      throws IOException
    {
      consume('[');
      this.m_token.append('[');
      componentType();
    }
    
    void baseType()
      throws IOException
    {
      char c = (char)this.m_in.read();
      switch (c)
      {
      default: 
        throw new IllegalArgumentException("unknown base type: " + c);
      }
      this.m_token.append(c);
    }
    
    void componentType()
      throws IOException
    {
      fieldType();
    }
    
    void fieldType()
      throws IOException
    {
      int i = (char)this.m_in.read();
      this.m_in.unread(i);
      switch (i)
      {
      default: 
        baseType();
        return;
      case 76: 
        objectType();
        return;
      }
      arrayType();
    }
    
    String[] getResult()
    {
      String[] arrayOfString = new String[this.m_result.size()];
      this.m_result.toArray(arrayOfString);
      return arrayOfString;
    }
    
    void methodDescriptor()
      throws IOException
    {
      consume('(');
      for (;;)
      {
        int i = (char)this.m_in.read();
        if (i == 41) {
          break;
        }
        this.m_in.unread(i);
        parameterDescriptor();
      }
      returnDescriptor();
    }
    
    void objectType()
      throws IOException
    {
      consume('L');
      this.m_token.append('L');
      for (;;)
      {
        char c = (char)this.m_in.read();
        if (c == ';') {
          break;
        }
        this.m_token.append(c);
      }
      this.m_token.append(';');
    }
    
    void parameterDescriptor()
      throws IOException
    {
      fieldType();
      newToken();
    }
    
    void returnDescriptor()
      throws IOException
    {
      char c = (char)this.m_in.read();
      switch (c)
      {
      default: 
        this.m_in.unread(c);
        fieldType();
        return;
      }
      this.m_token.append(c);
    }
  }
  
  private static final class signatureCompiler
  {
    private StringBuffer m_desc = new StringBuffer();
    
    private void emit(char paramChar)
    {
      this.m_desc.append(paramChar);
    }
    
    private void emit(String paramString)
    {
      this.m_desc.append(paramString);
    }
    
    private void parameterType(Class paramClass)
    {
      if (paramClass != null)
      {
        if (!paramClass.isPrimitive()) {
          break label123;
        }
        if (Byte.TYPE != paramClass) {
          break label25;
        }
        emit('B');
      }
      label25:
      do
      {
        return;
        if (Character.TYPE == paramClass)
        {
          emit('C');
          return;
        }
        if (Double.TYPE == paramClass)
        {
          emit('D');
          return;
        }
        if (Float.TYPE == paramClass)
        {
          emit('F');
          return;
        }
        if (Integer.TYPE == paramClass)
        {
          emit('I');
          return;
        }
        if (Long.TYPE == paramClass)
        {
          emit('J');
          return;
        }
        if (Short.TYPE == paramClass)
        {
          emit('S');
          return;
        }
      } while (Boolean.TYPE != paramClass);
      emit('Z');
      return;
      label123:
      if (paramClass.isArray())
      {
        emit('[');
        parameterType(paramClass.getComponentType());
        return;
      }
      emit('L');
      emit(Types.javaNameToVMName(paramClass.getName()));
      emit(';');
    }
    
    private void parameterTypes(Class[] paramArrayOfClass)
    {
      if (paramArrayOfClass != null)
      {
        int i = 0;
        while (i < paramArrayOfClass.length)
        {
          parameterType(paramArrayOfClass[i]);
          i += 1;
        }
      }
    }
    
    private void returnType(Class paramClass)
    {
      if ((paramClass == null) || (paramClass == Void.TYPE))
      {
        emit('V');
        return;
      }
      parameterType(paramClass);
    }
    
    String signatureDescriptor(Class[] paramArrayOfClass, Class paramClass)
    {
      emit('(');
      parameterTypes(paramArrayOfClass);
      emit(')');
      returnType(paramClass);
      return this.m_desc.toString();
    }
    
    String typeDescriptor(Class paramClass)
    {
      parameterType(paramClass);
      return this.m_desc.toString();
    }
  }
  
  private static class typeDescriptorCompiler
  {
    Class arrayOf(String paramString)
      throws ClassNotFoundException
    {
      char c = paramString.charAt(0);
      if (c == '[') {
        paramString = arrayOf(paramString.substring(1));
      }
      for (;;)
      {
        return Array.newInstance(paramString, 0).getClass();
        if (c == 'L') {
          paramString = Class.forName(Types.vmNameToJavaName(paramString.substring(1, paramString.length() - 1)));
        } else {
          paramString = primitive(c);
        }
      }
    }
    
    Class descriptorToClass(String paramString)
      throws ClassNotFoundException
    {
      char c = paramString.charAt(0);
      if (c == '[') {
        return arrayOf(paramString.substring(1));
      }
      if (c == 'L') {
        return Class.forName(Types.vmNameToJavaName(paramString.substring(1, paramString.length() - 1)));
      }
      return primitive(c);
    }
    
    Class primitive(char paramChar)
      throws ClassNotFoundException
    {
      if (paramChar == 'B') {
        return Byte.TYPE;
      }
      if (paramChar == 'C') {
        return Character.TYPE;
      }
      if (paramChar == 'D') {
        return Double.TYPE;
      }
      if (paramChar == 'F') {
        return Float.TYPE;
      }
      if (paramChar == 'I') {
        return Integer.TYPE;
      }
      if (paramChar == 'J') {
        return Long.TYPE;
      }
      if (paramChar == 'S') {
        return Short.TYPE;
      }
      if (paramChar == 'Z') {
        return Boolean.TYPE;
      }
      throw new ClassNotFoundException("unknown base type: " + paramChar);
    }
  }
  
  private static class typeDescriptorCompiler2
  {
    String arrayOf(String paramString)
    {
      char c = paramString.charAt(0);
      if (c == '[') {
        paramString = arrayOf(paramString.substring(1));
      }
      for (;;)
      {
        return paramString + " []";
        if (c == 'L') {
          paramString = Types.vmNameToJavaName(paramString.substring(1, paramString.length() - 1));
        } else {
          paramString = primitive(c);
        }
      }
    }
    
    String descriptorToClass(String paramString)
    {
      char c = paramString.charAt(0);
      if (c == '[') {
        return arrayOf(paramString.substring(1));
      }
      if (c == 'L') {
        return Types.vmNameToJavaName(paramString.substring(1, paramString.length() - 1));
      }
      return primitive(c);
    }
    
    String primitive(char paramChar)
    {
      switch (paramChar)
      {
      default: 
        throw new IllegalArgumentException("unknown primitive: " + paramChar);
      case 'B': 
        return "byte";
      case 'C': 
        return "char";
      case 'D': 
        return "double";
      case 'F': 
        return "float";
      case 'I': 
        return "int";
      case 'J': 
        return "long";
      case 'S': 
        return "short";
      }
      return "boolean";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/lib/Types.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */