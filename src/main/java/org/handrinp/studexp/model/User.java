package org.handrinp.studexp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
  private String name;
  private int exp;
  private List<Task> tasks;

  public User(String name, int exp, List<Task> tasks) {
    this.name = name;
    this.exp = exp;
    this.tasks = tasks;
  }

  public User(String name) {
    this(name, 0, new ArrayList<>());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public int numTasks() {
    return tasks.size();
  }

  public Task getTask(int index) {
    return tasks.get(index);
  }

  public void addTask(Task task) {
    tasks.add(task);
  }

  public void deleteTask(long id) {
    tasks = tasks.stream().filter(t -> t.getId() != id).collect(Collectors.toList());
  }

  public int getExp() {
    return exp;
  }

  public boolean gainEXP(int amount) {
    int oldLevel = level();
    exp += amount;
    return oldLevel != level();
  }

  public int level() {
    int lv = 0;
    while (expf(++lv) <= exp);
    return lv - 1;
  }

  private static int expf(int lv) {
    return 100 * (int) Math
        .floor((Math.pow(2.0, (lv - 1.0) / 10.0) - 1.0) / (Math.pow(2.0, 1.0 / 10.0) - 1.0));
  }
}
