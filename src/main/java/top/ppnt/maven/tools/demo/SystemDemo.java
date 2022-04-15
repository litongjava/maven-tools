package top.ppnt.maven.tools.demo;

/**
 * Created by Ping E Lee on 2022-04-14_19:44
 */
public class SystemDemo {
  public static void main(String[] args) {
    //String m2Home = System.getProperty("M2_HOME");
    String m2Home = System.getenv("M2_HOME");
    System.out.println(m2Home);
  }
}
