package pseudoaio;

import bio.TimeServerHander;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yuicon
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port: " + port);
            Socket socket = null;
            //创建 I/O 任务线程池
            TimeServerHanderExecutePool singleExecutor = new TimeServerHanderExecutePool(
                    50, 10000);
            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHander(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }

}
