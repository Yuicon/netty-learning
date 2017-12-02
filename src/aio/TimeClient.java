package aio;

/**
 *
 * @author Yuicon
 * @date 2017/12/2
 * https://github.com/Yuicon
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-011").start();
    }

}
