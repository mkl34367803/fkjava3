package chapter1404;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({"Persistent","Id","Property"})
public class HibernateAnnotationProcessor extends AbstractProcessor{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		PrintStream printStream=null;
		try {
			for(Element e:roundEnv.getElementsAnnotatedWith(Persistent.class)){
				Name className=e.getSimpleName();
				Persistent persistent=e.getAnnotation(Persistent.class);
				printStream=new PrintStream(new FileOutputStream(className+".hbm.xml"));
				printStream.println("<?xml version=\"1.0\"?>");
				printStream.println("<!DOCTYPE hibernate-mapping PUBLIC");
				printStream.println("-//Hibernate/Hibernate Configuration DTD 3.0//EN");
				printStream.println("http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd"+">");
				printStream.println("<hibernate-mapping>");
				printStream.println("    <class name=\""+className+"\" table=\""+persistent.table()+"\">");
				for(Element f:e.getEnclosedElements()){
					if(f.getKind()==ElementKind.FIELD){
						Id id=f.getAnnotation(Id.class);
						if(id!=null){
							printStream.println("        <id name=\""+f.getSimpleName()+"\" column=\""+id.column()+"\" type=\""+id.type()+"\">");
							printStream.println("            <generator class=\""+id.generator()+"\"/>");
							printStream.println("        </id>");
						}
						Property property=f.getAnnotation(Property.class);
						if(property!=null){
							printStream.println("        <property name=\""+f.getSimpleName()+"\" column=\""+property.column()+"\" type=\""+property.type()+"\"/>");
						}
					}
				}
				printStream.println("    </class>");
				printStream.println("</hibernate-mapping>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(printStream!=null){
				try {
					printStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return true;
	}

}
