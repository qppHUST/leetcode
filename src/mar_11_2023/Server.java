package mar_11_2023;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * ClassName: Server
 * PackageName:mar_11_2023
 * Description:
 * date: 2023/3/14 22:30
 *
 * @author: 邱攀攀
 * @version: since JDK 1.8
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true){
            Socket chain = server.accept();
            InputStream inputStream = chain.getInputStream();
            byte[] bytes = new byte[1024 * 4];
            int read = inputStream.read(bytes);
            System.out.println(new String(bytes,0,read));
            chain.close();
        }
    }
}
