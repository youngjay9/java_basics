package reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 取得 method area 的 Class Object 相關 API.
 */
public class GettingClassObject {

  private static Logger logger = LoggerFactory.getLogger(GettingClassObject.class);

  public static void main(String[] args) throws ClassNotFoundException {

    // 都是從 method area 取得 String 的 Class Object
    Class strClassObj1 = Class.forName("java.lang.String");

    Class strClassObj2 = Class.forName("java.lang.String");

    logger.info("strClassObj1 == strClassObj2:{}", strClassObj1 == strClassObj2);// true

    // 以下是取得 method area Class Object 的方式
    Class intClassObject = int.class;

    Class strClassObject = String.class;

    MyClass myClass = new MyClass();
    // 透過物件的 reference 取得 method area Class object
    Class myClassObj = myClass.getClass();

    // 取得 myClassObj 的 super class object
    Class supperClass = myClassObj.getSuperclass();

    // 取得 myClassObj 的 interfaces
    Class[] interfaces = myClassObj.getInterfaces();

  }

}
