package org.handrinp.studexp.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest {
  @Test
  public void testEXP() {
    User lv1User = new User("tryme");
    User lv50User = new User("trymealso", 40200, null);
    User lv100User = new User("buttryme", 1329700, null);

    assertEquals(1, lv1User.getLevel());
    assertEquals(50, lv50User.getLevel());
    assertEquals(100, lv100User.getLevel());
  }
}
