package reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entity {

  private static Logger logger = LoggerFactory.getLogger(Entity.class);

  private int val;
  public String type;

  public Entity(int val, String type) {
    this.val = val;
    this.type = type;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setTwoParams(Entity e1, Entity e2) {
    if (e1 == null || e2 == null) {
      logger.info("Entity is null!!");
      return;
    }
    logger.info("e1.val:{}, e2.val:{}", e1.getVal(), e2.getVal());
  }
}
