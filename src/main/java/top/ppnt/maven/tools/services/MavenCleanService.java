package top.ppnt.maven.tools.services;

import com.litongjava.utils.sytstem.RuntimeUtils;
import top.ppnt.maven.tools.constants.ConfigConstants;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ping E Lee on 2022-04-14_19:33
 */
public class MavenCleanService {
  public void clean(String absolutePath) {
    if(absolutePath.contains("target\\classes")){
      return;
    }

    if(absolutePath.contains("target\\m2e-wtp")){
      return;
    }

    if(absolutePath.contains("maven-tools\\pom.xml")){
      return;
    }


    //开始清除目录,使用但线程模式
    String m2Home = System.getenv("M2_HOME");
    String cmd = String.format(ConfigConstants.MAVEN_CLEAN_CMD_TEMPLATE, m2Home,absolutePath);
    System.out.println(cmd);
    try {
      String output = RuntimeUtils.exec(cmd);
      System.out.println(output);
    } catch (IOException e) {
      e.printStackTrace();
    }
    //String output = CmdUtils.execCmd(cmd);
  }

  public void clean(List<String> poms) {
    for (String pom : poms) {
      this.clean(pom);
    }
  }
}
