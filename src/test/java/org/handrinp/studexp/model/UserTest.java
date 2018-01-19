package org.handrinp.studexp.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest {
  @Test
  public void testEXP() {
    User lv1User = new User("tryme");
    User lv1UserToo = new User("tryme", 99, null);
    User lv2User = new User("tryme", 100, null);
    User lv50User = new User("trymealso", 40200, null);
    User lv100User = new User("buttryme", 1329700, null);

    assertEquals(1, lv1User.level());
    assertEquals(1, lv1UserToo.level());
    assertEquals(2, lv2User.level());
    assertEquals(50, lv50User.level());
    assertEquals(100, lv100User.level());
  }
}
