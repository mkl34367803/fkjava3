package chapter1802;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import sun.applet.AppletClassLoader;

public class ClassLoaderPropTest {
	public static void main(String[] args) throws Exception {
		ClassLoader systemClassLoader=ClassLoader.getSystemClassLoader();
		System.out.println("system classLoader:"+systemClassLoader);
		Enumeration<URL> eml=systemClassLoader.getResources("");
		while(eml.hasMoreElements()){
			System.out.println(eml.nextElement());
		}
		ClassLoader extendClassLoader=systemClassLoader.getParent();
		System.out.println("extend classLoader:"+extendClassLoader);
		System.out.println("extend classLoader path:"+System.getProperty("java.ext.dirs"));
		System.out.println("extend calssLoader parent:"+extendClassLoader.getParent());
	}
}
