package reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 取得 method area 的 Class Object 相關 API.
 */
public class GettingClassObject {

  private static Logger logger = LoggerFactory.getLogger(GettingClassObject.class);

  public static void main(String[] args) throws ClassNotFoundException {

    /*
      透過 Class.forName API 取得對應的 package 下, 該 class 檔在
      method area 的 Class Object
    */

    // 以下為從 method area 取得 String 的 Class Object
    Class strClassObj1 = Class.forName("java.lang.String");

    Class strClassObj2 = Class.forName("java.lang.String");

    // 都是同一個 method area 的 String Class Object
    logger.info("strClassObj1 == strClassObj2:{}", strClassObj1 == strClassObj2);// true

    // 以下是取得 method area Class Object 的另一種方式
    Class intClassObject = int.class;

    Class strClassObject = String.class;


    // 透過物件的 reference 取得 method area Class object 的方式
    MyClass myClass = new MyClass();

    Class myClassObj = myClass.getClass();

    // 取得 myClassObj 的 super class object
    Class supperClass = myClassObj.getSuperclass();

    // 取得 myClassObj 的 interfaces
    Class[] interfaces = myClassObj.getInterfaces();

  }

}
