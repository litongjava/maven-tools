package top.ppnt.maven.tools.visitor;

import lombok.extern.slf4j.Slf4j;
import top.ppnt.maven.tools.services.PomService;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Ping E Lee on 2022-04-14_19:27
 */
@Slf4j
public class ScanPathFileVisitor extends SimpleFileVisitor<Path> {
  // 在访问子目录前触发该方法
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    return FileVisitResult.CONTINUE;
  }

  // 在访问文件时触发该方法
  @Override
  public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
    if (path.endsWith("pom.xml")) {
      String absolutePath = path.toFile().getAbsolutePath();
      PomService.poms.add(absolutePath);
      //log.info("找到文件:{}",absolutePath);
    }
    return FileVisitResult.CONTINUE;
  }

  // 在访问失败时触发该方法
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    // 写一些具体的业务逻辑
    return super.visitFileFailed(file, exc);
  }

  // 在访问目录之后触发该方法
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    // 写一些具体的业务逻辑
    return super.postVisitDirectory(dir, exc);
  }
}
