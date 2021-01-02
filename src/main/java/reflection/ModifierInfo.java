package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModifierInfo {

  private static Logger logger = LoggerFactory.getLogger(ModifierInfo.class);

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException {

    // 取得 Entity Class 在 method area 的 Class Object
    Class entityClassObj = Class.forName("reflection.Entity");

    // 透過 entityClassObj 的 reflection API 取得 method 資訊
    Method getVal_method = entityClassObj.getDeclaredMethod("getVal");

    // 取得該 method 的 modifiers
    int getVal_method_modifiers = getVal_method.getModifiers();

    boolean isPublic = Modifier.isPublic(getVal_method_modifiers);

    String strModifier = Modifier.toString(getVal_method_modifiers);

    logger.info("getVal_method_modifiers isPublic:{}", isPublic);

    logger.info("getVal_method_modifiers toString:{}", strModifier);

  }
}
