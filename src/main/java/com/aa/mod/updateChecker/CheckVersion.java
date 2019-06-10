package com.aa.mod.updateChecker;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class CheckVersion
  implements Runnable
{
  private static boolean isLatestVersion = false;
  private static String latestVersion = "";
  
  public CheckVersion() {}
  
  public void run() {
    InputStream in = null;
    try
    {
      in = new URL("https://raw.githubusercontent.com/jordsta95/ArcaneArteries/master/aaversion.txt").openStream();

    }
    catch (MalformedURLException e)
    {

      e.printStackTrace();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    try
    {
      latestVersion = (String)IOUtils.readLines(in).get(0);

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      IOUtils.closeQuietly(in);
    }
    System.out.println("Latest version of Arcane Arteries is = " + latestVersion);
    isLatestVersion = "5".equals(latestVersion);
  }
  
  public boolean isLatestVersion()
  {
    return isLatestVersion;
  }
  
  public String getLatestVersion()
  {
    return latestVersion;
  }
}
