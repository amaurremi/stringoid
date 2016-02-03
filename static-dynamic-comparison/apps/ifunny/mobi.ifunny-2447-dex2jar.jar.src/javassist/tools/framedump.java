package javassist.tools;

import java.io.PrintStream;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.analysis.FramePrinter;

public class framedump {
    public static void main(String[] paramArrayOfString) {
        if (paramArrayOfString.length != 1) {
            System.err.println("Usage: java javassist.tools.framedump <class file name>");
            return;
        }
        paramArrayOfString = ClassPool.getDefault().get(paramArrayOfString[0]);
        System.out.println("Frame Dump of " + paramArrayOfString.getName() + ":");
        FramePrinter.print(paramArrayOfString, System.out);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/framedump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */