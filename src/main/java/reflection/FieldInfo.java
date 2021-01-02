package reflection;

import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 透過 reflection API 取得 method area Class Object 存取 field 資訊
 */
public class FieldInfo {

  private static Logger logger = LoggerFactory.getLogger(FieldInfo.class);

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

    Entity entityObj = new Entity(10, "id");

    // 透過物件的 reference 取得 method area 的 Class Object
    Class entityClassObject = entityObj.getClass();

    // 取得該 class 所有宣告的 field
    Field[] declaredFields = entityClassObject.getDeclaredFields();
    for (Field field : declaredFields) {
      logger.info("declared field name:{}", field.getName());
    }

    // 更改 Entity object 的 type 欄位值, 把它從 id 改為 ruleNo.
    logger.info("before change the Entity field type:{}", entityObj.getType());

    // 透過 entityClassObj 的 reflection API 取得 Field: type 的資訊
    Field type_Field = entityClassObject.getDeclaredField("type");
    // 設定 Field: type 的值為 ruleNo
    type_Field.set(entityObj, "ruleNo");

    logger.info("after change the Entity field type:{}", entityObj.getType());

    // 更改 Entity object 的 val 欄位值, 把它從 10 改為 9
    logger.info("before change the Entity field val:{}", entityObj.getVal());

    // 透過 entityClassObj 的 reflection API 取得 Field: val 的資訊
    Field valField = entityClassObject.getDeclaredField("val");
    // 因為 val 欄位為 private,需改成 public 才可更改它的值
    valField.setAccessible(true);
    valField.set(entityObj, 9);

    logger.info("after change the Entity field val:{}", entityObj.getVal());




  }
}
