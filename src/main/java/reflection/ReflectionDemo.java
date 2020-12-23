package reflection;

import java.lang.reflect.Constructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyClass {

  private static Logger logger = LoggerFactory.getLogger(MyClass.class);

  public MyClass() {
    logger.info("MyClass object created!!");
  }
}


public class ReflectionDemo {

  private static Logger logger = LoggerFactory.getLogger(ReflectionDemo.class);

  public static void main(String[] args)
      throws Exception {

    // Class.forName 是尋找 method area 的 Class object, 如果沒有的話再用 class loader 新增
    Class c = Class.forName("reflection.MyClass");

    Constructor constructor = c.getDeclaredConstructor();
    constructor.setAccessible(true);

    Object newInstance = constructor.newInstance();

  }
}
