package chapter140302;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {
	public static void processAnnotations(Object object){
		try {
			Class clazz=object.getClass();
			for(Field field:clazz.getDeclaredFields()){
				field.setAccessible(true);
				ActionListenerFor actionListenerFor=field.getAnnotation(ActionListenerFor.class);
				Object fieldObject=field.get(object);
				if(actionListenerFor!=null&&fieldObject!=null&&fieldObject instanceof AbstractButton){
					Class<? extends ActionListener> listenerClass=actionListenerFor.listener();
					ActionListener actionListener=listenerClass.newInstance();
					AbstractButton abstractButton=(AbstractButton) fieldObject;
					abstractButton.addActionListener(actionListener);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
