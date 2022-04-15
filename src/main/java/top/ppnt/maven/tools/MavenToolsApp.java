package top.ppnt.maven.tools;

import com.litongjava.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import top.ppnt.maven.tools.services.MavenService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 */
@Slf4j
//top.ppnt.maven.tools.MavenToolsApp
public class MavenToolsApp {
  public static void main(String[] args) {
    //log.info("args,{}",Arrays.toString(args));
    //System.out.println(System.getProperty("file.encoding"));
    log.info("开始扫描文件文件夹:");
    //将args转换到map数值中
    Map<String,String> argsMap=new HashMap<>();
    for(int i=0;i<args.length;i+=2){
      argsMap.put(args[i],args[i+1]);
    }
    //遍历map
//    for (Map.Entry<String,String> e :argsMap.entrySet()){
//      log.info("{}={}",e.getKey(),e.getValue());
//    }
    String argCValue = argsMap.get("-c");
    if(!StringUtils.isEmpty(argCValue)){
      MavenService mavenServices = new MavenService();
      mavenServices.scanAndCleanMavenProject(argCValue);
    }
  }
}
