package chapter1509;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("ReadFile.java");
			FileChannel fcin=fis.getChannel();
			ByteBuffer bbuff=ByteBuffer.allocate(256);
			while(fcin.read(bbuff)!=-1){
				bbuff.flip();
				Charset charset=Charset.forName("GBK");
				CharsetDecoder decoder=charset.newDecoder();
				CharBuffer charBuffer=decoder.decode(bbuff);
				System.out.println(charBuffer);
				bbuff.clear();
				System.out.println(bbuff.getChar());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
