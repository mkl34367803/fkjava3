package chapter1602;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread {
	public static void main(String[] args) {
		ThirdThread rt=new ThirdThread();
		FutureTask<Integer> task=new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int i=0;
				for(;i<100;i++){
					System.out.println(Thread.currentThread().getName()+"循环遍历i的值:"+i);
				}
				return i;
			}
		});
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"循环变量i的值:"+i);
			if(i==20){
				//实质还是以callable对象创建并启动线程的
				new Thread(task, "有返回值的线程").start();
			}
		}
		try {
			System.out.println("子线程的返回值："+task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
