package chapter1509;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		CharBuffer buff=CharBuffer.allocate(8);
		System.out.println("capacity: "+buff.capacity());
		System.out.println("limit: "+buff.limit());
		System.out.println("position: "+buff.position());
		//放入元素
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("加入三个元素之后，position="+buff.position());
		System.out.println("加入三个元素之后，limit="+buff.limit());
		//调用flip（）方法
		buff.flip();
		System.out.println("执行flip（）后，limit="+buff.limit());
		System.out.println("执行flip（）后，position="+buff.position());
		System.out.println("第一个元素（position=0）："+buff.get());
		System.out.println("取出第一个元素后，position="+buff.position());
		System.out.println("第二个元素（position=1）："+buff.get());
		System.out.println("取出第二个元素后，position="+buff.position());
		buff.clear();
		System.out.println("执行clear()之后，limit="+buff.limit());
		System.out.println("执行clear()之后，position="+buff.position());
		System.out.println("执行clear()后，缓存区内容并没有被清楚："+"第三个元素为："+buff.get(2));
		System.out.println("执行绝对读取后，position="+buff.position());
		
	}
}
