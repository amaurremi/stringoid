package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import com.squareup.okio.Buffer;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public class Platform
{
  private static final Platform PLATFORM = ;
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    Buffer localBuffer = new Buffer();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localBuffer.writeByte(localProtocol.toString().length());
        localBuffer.writeUtf8(localProtocol.toString());
      }
    }
    return localBuffer.readByteArray();
  }
  
  private static Platform findPlatform()
  {
    try
    {
      localClass2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
      try
      {
        localMethod1 = localClass2.getMethod("setUseSessionTickets", new Class[] { Boolean.TYPE });
        localMethod2 = localClass2.getMethod("setHostname", new Class[] { String.class });
        localObject7 = null;
        localObject5 = null;
        localObject6 = null;
        localObject1 = localObject5;
        localObject4 = localObject7;
      }
      catch (ClassNotFoundException localClassNotFoundException4)
      {
        Method localMethod1;
        Method localMethod2;
        Object localObject7;
        Object localObject5;
        Object localObject6;
        Object localObject1;
        Object localObject4;
        Object localObject8;
        label111:
        for (;;) {}
      }
      try
      {
        localObject8 = Class.forName("android.net.TrafficStats");
        localObject1 = localObject5;
        localObject4 = localObject7;
        localObject5 = ((Class)localObject8).getMethod("tagSocket", new Class[] { Socket.class });
        localObject1 = localObject5;
        localObject4 = localObject5;
        localObject7 = ((Class)localObject8).getMethod("untagSocket", new Class[] { Socket.class });
        localObject6 = localObject7;
        localObject1 = localObject5;
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        break label111;
      }
      catch (ClassNotFoundException localClassNotFoundException5)
      {
        Object localObject3 = localNoSuchMethodException3;
        break label111;
      }
      localObject4 = null;
      localObject7 = null;
      try
      {
        localObject5 = localClass2.getMethod("setNpnProtocols", new Class[] { byte[].class });
        localObject4 = localObject5;
        localObject8 = localClass2.getMethod("getNpnSelectedProtocol", new Class[0]);
        localObject7 = localObject8;
        localObject4 = localObject5;
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        Object localObject2;
        Class localClass1;
        for (;;) {}
      }
      return new Android(localClass2, localMethod1, localMethod2, (Method)localObject1, (Method)localObject6, (Method)localObject4, (Method)localObject7, null);
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        localClass2 = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Class localClass2;
      localObject4 = "org.eclipse.jetty.alpn.ALPN";
      try
      {
        localObject2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
        try
        {
          localObject5 = Class.forName((String)localObject4 + "$Provider");
          localClass2 = Class.forName((String)localObject4 + "$ClientProvider");
          localObject4 = Class.forName((String)localObject4 + "$ServerProvider");
          localObject2 = new JdkWithJettyBootPlatform(((Class)localObject2).getMethod("put", new Class[] { SSLSocket.class, localObject5 }), ((Class)localObject2).getMethod("get", new Class[] { SSLSocket.class }), localClass2, (Class)localObject4);
          return (Platform)localObject2;
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          return new Platform();
        }
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        for (;;)
        {
          localObject4 = "org.eclipse.jetty.npn.NextProtoNego";
          localClass1 = Class.forName("org.eclipse.jetty.npn.NextProtoNego");
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;) {}
      }
    }
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  public void configureTls(SSLSocket paramSSLSocket, String paramString1, String paramString2)
  {
    if (paramString2.equals("SSLv3")) {
      paramSSLSocket.setEnabledProtocols(new String[] { "SSLv3" });
    }
  }
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix()
  {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void logW(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void setProtocols(SSLSocket paramSSLSocket, List<Protocol> paramList) {}
  
  public void tagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  public URI toUriLenient(URL paramURL)
    throws URISyntaxException
  {
    return paramURL.toURI();
  }
  
  public void untagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  private static class Android
    extends Platform
  {
    private final Method getNpnSelectedProtocol;
    protected final Class<?> openSslSocketClass;
    private final Method setHostname;
    private final Method setNpnProtocols;
    private final Method setUseSessionTickets;
    private final Method trafficStatsTagSocket;
    private final Method trafficStatsUntagSocket;
    
    private Android(Class<?> paramClass, Method paramMethod1, Method paramMethod2, Method paramMethod3, Method paramMethod4, Method paramMethod5, Method paramMethod6)
    {
      this.openSslSocketClass = paramClass;
      this.setUseSessionTickets = paramMethod1;
      this.setHostname = paramMethod2;
      this.trafficStatsTagSocket = paramMethod3;
      this.trafficStatsUntagSocket = paramMethod4;
      this.setNpnProtocols = paramMethod5;
      this.getNpnSelectedProtocol = paramMethod6;
    }
    
    public void configureTls(SSLSocket paramSSLSocket, String paramString1, String paramString2)
    {
      super.configureTls(paramSSLSocket, paramString1, paramString2);
      if ((paramString2.equals("TLSv1")) && (this.openSslSocketClass.isInstance(paramSSLSocket))) {}
      try
      {
        this.setUseSessionTickets.invoke(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invoke(paramSSLSocket, new Object[] { paramString1 });
        return;
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        throw new RuntimeException(paramSSLSocket);
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
    }
    
    public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      if (this.getNpnSelectedProtocol == null) {
        return null;
      }
      if (!this.openSslSocketClass.isInstance(paramSSLSocket)) {
        return null;
      }
      try
      {
        paramSSLSocket = (byte[])this.getNpnSelectedProtocol.invoke(paramSSLSocket, new Object[0]);
        if (paramSSLSocket == null) {
          return null;
        }
        paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);
        return paramSSLSocket;
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        throw new RuntimeException(paramSSLSocket);
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
    }
    
    public void setProtocols(SSLSocket paramSSLSocket, List<Protocol> paramList)
    {
      if (this.setNpnProtocols == null) {}
      while (!this.openSslSocketClass.isInstance(paramSSLSocket)) {
        return;
      }
      try
      {
        paramList = concatLengthPrefixed(paramList);
        this.setNpnProtocols.invoke(paramSSLSocket, new Object[] { paramList });
        return;
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        throw new RuntimeException(paramSSLSocket);
      }
    }
    
    public void tagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsTagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
    }
    
    public void untagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsUntagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
    }
  }
  
  private static class JdkWithJettyBootPlatform
    extends Platform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Class<?> paramClass1, Class<?> paramClass2)
    {
      this.putMethod = paramMethod1;
      this.getMethod = paramMethod2;
      this.clientProviderClass = paramClass1;
      this.serverProviderClass = paramClass2;
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$100(paramSSLSocket)) && (Platform.JettyNegoProvider.access$200(paramSSLSocket) == null))
        {
          Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN/ALPN callback dropped: SPDY and HTTP/2 are disabled. Is npn-boot or alpn-boot on the boot class path?");
          return null;
        }
        if (!Platform.JettyNegoProvider.access$100(paramSSLSocket))
        {
          paramSSLSocket = Platform.JettyNegoProvider.access$200(paramSSLSocket);
          return paramSSLSocket;
        }
      }
      catch (InvocationTargetException paramSSLSocket)
      {
        throw new AssertionError();
      }
      catch (IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      return null;
    }
    
    public void setProtocols(SSLSocket paramSSLSocket, List<Protocol> paramList)
    {
      for (;;)
      {
        int i;
        try
        {
          localObject1 = new ArrayList(paramList.size());
          i = 0;
          int j = paramList.size();
          if (i < j)
          {
            localObject2 = (Protocol)paramList.get(i);
            if (localObject2 == Protocol.HTTP_1_0) {
              break label162;
            }
            ((List)localObject1).add(((Protocol)localObject2).toString());
          }
        }
        catch (InvocationTargetException paramSSLSocket)
        {
          throw new AssertionError(paramSSLSocket);
          paramList = Platform.class.getClassLoader();
          Object localObject2 = this.clientProviderClass;
          Class localClass = this.serverProviderClass;
          Object localObject1 = new Platform.JettyNegoProvider((List)localObject1);
          paramList = Proxy.newProxyInstance(paramList, new Class[] { localObject2, localClass }, (InvocationHandler)localObject1);
          this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramList });
          return;
        }
        catch (IllegalAccessException paramSSLSocket)
        {
          throw new AssertionError(paramSSLSocket);
        }
        label162:
        i += 1;
      }
    }
  }
  
  private static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = Util.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.protocols;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int i = 0;
        int j = ((List)paramObject).size();
        while (i < j)
        {
          if (this.protocols.contains(((List)paramObject).get(i)))
          {
            paramObject = (String)((List)paramObject).get(i);
            this.selected = ((String)paramObject);
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.protocols.get(0);
        this.selected = ((String)paramObject);
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.selected = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, (Object[])paramObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/okhttp/internal/Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */