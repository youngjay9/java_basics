package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 透過 reflection API 取得 method area Class Object 存取 method 資訊
 */
public class MethodInfo {

  private static Logger logger = LoggerFactory.getLogger(MethodInfo.class);

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    Entity entityObj = new Entity(10, "id");

    // 透過物件的 reference 取得 method area 的 Class Object
    Class entityClassObj = entityObj.getClass();

    Method[] methods = entityClassObj.getDeclaredMethods();

    for (Method m : methods) {
      logger.info("method name: {}", m.getName());
    }

    // 透過 entityClassObj 的 reflection API 取得 method: getVal 資訊
    Method getVal_Method = entityClassObj.getDeclaredMethod("getVal", null);

    // 執行 entiyObj 的 method: getVal
    int val = (Integer) getVal_Method.invoke(entityObj, null);

    logger.info("original val: {}", val);

    // 透過 entityClassObj 的 reflection API 取得 method: setVal  資訊
    Method setVal_Method = entityClassObj.getDeclaredMethod("setVal", int.class);

    // 執行 entityObj 的 method: setVal, 將 val 從 10 改為 11
    setVal_Method.invoke(entityObj, 11);

    val = (Integer) getVal_Method.invoke(entityObj, null);

    logger.info("after changed val: {}", val);


    Entity entityObj2 = new Entity(8, "id");

    // 都是同一個 method area 的 Entity Class Object
    Class entityClassObj2 = entityObj2.getClass();
    logger.info("entityClassObj==entityClassObj2: {}", entityClassObj == entityClassObj);// true

    // 執行有 2 個參數的 method
    Method setTwoParams_Method = entityClassObj2
        .getDeclaredMethod("setTwoParams", Entity.class, Entity.class);

    setTwoParams_Method.invoke(entityObj2, entityObj, entityObj2);

  }
}
