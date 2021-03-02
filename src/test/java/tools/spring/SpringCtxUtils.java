package tools.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 全局范围spring容器工具
 * 
 * @author hbm
 *
 */
public class SpringCtxUtils {
	public static ClassPathXmlApplicationContext ctx;

	public static void init(String[] springConfigs) {
		ctx = new ClassPathXmlApplicationContext(springConfigs);
	}

	public static void start() {
		ctx.start();
	}

	public static void close() {
		ctx.close();
	}

	public static <T> T getBean(Class<T> requiredType) {
		return ctx.getBean(requiredType);
	}

	public static <T> T getBean(String beanName, Class<T> requiredType) {
		return ctx.getBean(beanName, requiredType);
	}

}
