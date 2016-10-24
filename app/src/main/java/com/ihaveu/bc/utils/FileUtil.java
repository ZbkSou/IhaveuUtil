package com.ihaveu.bc.utils;

import java.io.File;

/**
 * Created by bc on 16/10/21.
 * Describe
 */
public class FileUtil {
  /**
   * 删除文件夹
   * @param dir
   * @return
   */
  public static boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    // The directory is now empty so delete it
    return dir.delete();
  }
}
