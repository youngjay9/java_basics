package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConstructorInfo {

  private static Logger logger = LoggerFactory.getLogger(ConstructorInfo.class);

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

    // 取得 Entity Class 在 method area 的 Class Object
    Class entityClassObj = Class.forName("reflection.Entity");

    // 透過 entityClassObj 的 reflection API 取得 constructor 資訊
    Constructor entityObjCons1 = entityClassObj.getDeclaredConstructor(int.class, String.class);

    // 用 reflection 的 constructor 建立一個 Entity Object
    Entity entityObj = (Entity) entityObjCons1.newInstance(9, "ID");

    logger.info("entityObj val: {}, type:{}", entityObj.getVal(), entityObj.getType());


  }
}
