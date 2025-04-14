package api.store.base;

import config.Configuration;

public final class Constants {
  public static final String BASE_URL = Configuration.getProperty("store.url");

  private Constants() {}
}
