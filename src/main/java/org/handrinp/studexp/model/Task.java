package org.handrinp.studexp.model;

public class Task {
  private long id;
  private String desc;
  private long due;

  public Task(String description, long due) {
    this.id = -1L;
    this.desc = description;
    this.due = due;
  }

  public long getID() {
    return id;
  }

  public void setID(long id) {
    this.id = id;
  }

  public String getDescription() {
    return desc;
  }

  public void setDescription(String description) {
    this.desc = description;
  }

  public long getDue() {
    return due;
  }

  public void setDue(long due) {
    this.due = due;
  }
}
