package top.ppnt.maven.tools.services;

import top.ppnt.maven.tools.visitor.ScanPathFileVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

/**
 * Created by Ping E Lee on 2022-04-14_19:18
 */
public class MavenService {

  /**
   * 扫描目录下的文件,如果检测到pom.xml则执行maven clean
   *
   * @param path
   */
  public void scanAndCleanMavenProject(String path) {

    Path start = Paths.get(path);
    // 使用FileVisitor对目录进行遍历
    try {
      SimpleFileVisitor<Path> visitor = new ScanPathFileVisitor();
      Files.walkFileTree(start, visitor);
    } catch (IOException e) {
      e.printStackTrace();
    }
    MavenCleanService mavenCleanService = new MavenCleanService();
    mavenCleanService.clean(PomService.poms);
  }
}

