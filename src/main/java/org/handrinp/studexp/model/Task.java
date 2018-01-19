package org.handrinp.studexp.model;

public class Task {
  private long id;
  private String description;
  private long due;
  private int exp;

  public Task(String description, long due, int exp) {
    this.id = -1L;
    this.description = description;
    this.due = due;
    this.exp = exp;
  }

  public int getExp() {
    return exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getDue() {
    return due;
  }

  public void setDue(long due) {
    this.due = due;
  }
}
