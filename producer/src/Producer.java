import service.HitokotoService;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import service.IHitokotoService;

public class Producer {

	final private static int port = 8764;

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("[info] new socket");
				ObjectInputStream objectInputStream = new ObjectInputStream(
					socket.getInputStream());
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					socket.getOutputStream());

				String apiClassName = objectInputStream.readUTF();
				String methodName = objectInputStream.readUTF();
				Class[] paramterTypes = (Class[]) objectInputStream.readObject();
				Object[] paramters = (Object[]) objectInputStream.readObject();

				Class clazz = null;

				// 如果是一言的service
				if (apiClassName.equals(IHitokotoService.class.getName())) {
					clazz = HitokotoService.class;
				}

				if (clazz == null) {
					objectOutputStream.writeObject("WRONG CLASS NAME");
					System.out.println(String.format("[error] WRONG CLASS NAME %s", apiClassName));
				} else {
					Method method = clazz.getMethod(methodName, paramterTypes);
					Object returnObject = method.invoke(clazz.newInstance(), paramters);
					objectOutputStream.writeObject(returnObject);
					System.out.println(String.format("[info] return %s", returnObject.toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
