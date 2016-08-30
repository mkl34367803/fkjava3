package chapter1702;

public class MultiThreadDown {
	public static void main(String[] args) throws Exception {
		final DownUtil downUtil=new DownUtil("http://www.crazyit.org/attachments/month_1403/1403202355ff6cc9a4fbf6f14a.png", "ios.png",4);
		downUtil.download();
		new Thread(){
			public void run(){
				while(downUtil.getCompleteRate()<1){
					System.out.println("ÒÑÍê³É£º"+downUtil.getCompleteRate());
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}			
		}.start();
	}
}
