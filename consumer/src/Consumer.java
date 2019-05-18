import bean.Hitokoto;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;
import service.IHitokotoService;

public class Consumer {

	final private static String host = "127.0.0.1";
	final private static int port = 8764;

	public static void main(String[] args) {
		IHitokotoService hitokotoService = (IHitokotoService) rpc(IHitokotoService.class);

		for (int i = 0; i < 10; i++) {
			Hitokoto hitokoto = hitokotoService.random();
			System.out.println(hitokoto.toString());
		}
	}

	private static Object rpc(final Class clazz) {
		return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
			(proxy, method, args) -> {
				try (
					Socket socket = new Socket(host, port);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())
				) {

					String apiClassName = clazz.getName();
					String methodName = method.getName();
					Class[] paramTypes = method.getParameterTypes();

					objectOutputStream.writeUTF(apiClassName);
					objectOutputStream.writeUTF(methodName);
					objectOutputStream.writeObject(paramTypes);
					objectOutputStream.writeObject(args);

					return objectInputStream.readObject();
				}
			});
	}
}
