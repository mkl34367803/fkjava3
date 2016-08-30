package chapter140302;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnnotationTest {
	private JFrame mainWin=new JFrame("使用注解绑定事件监听器");
	@ActionListenerFor(listener=OkListener.class)
	private JButton ok=new JButton("确定");
	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel=new JButton("取消");
	public void init(){
		JPanel jPanel=new JPanel();
		jPanel.add(ok);
		jPanel.add(cancel);
		mainWin.add(jPanel);
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args) {
		new AnnotationTest().init();
	}
}
