package by.tms.springtest2.entity;


import by.tms.springtest2.validation.StartFieldWith;

import javax.validation.constraints.Pattern;

public class User {


  @StartFieldWith(value = "qx", message = "должно начинаться с qx")
  @Pattern(regexp = "(\\S+).{2,}", message = "мало символов или без пробелов")
  private String name;

  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "минимум: " +
          "8 символов, @#$%^&+=, нижний и верхний регистр, никаких пробелов")
  private String pass;

  @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "wrong email")
  private String email;

  @Pattern(regexp = "^([0-9][0-9]|[6-9]|1[0-7][0-9]|180)$", message = "ТОлько циферки(6-180)")
  private String age;

  public User() {
  }

  public User(String name, String pass, String email, String age) {
    this.name = name;
    this.pass = pass;
    this.email = email;
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            ", pass='" + pass + '\'' +
            ", email='" + email + '\'' +
            ", age='" + age + '\'' +
            '}';
  }
}
