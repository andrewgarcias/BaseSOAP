package com.training.adl.api.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogPrinter {
  private static final Logger logger = LoggerFactory.getLogger(LogPrinter.class);

  private LogPrinter() {
    super();
  }

  public static void printLog(String message) {
    logger.info(message);
  }

  public static void printErrror(String error) {
    logger.error(error);
  }
}
