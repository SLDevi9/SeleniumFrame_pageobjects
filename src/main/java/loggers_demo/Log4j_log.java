package loggers_demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j_log {

    static Logger logger = LogManager.getLogger(Log4j_log.class);

public static void main(String[] args) {

    System.out.println("\n Hello world...!\n");
    logger.trace("This is trace message");
    logger.info("This is information message");
    logger.error("This is error message");
    logger.warn("This is warn message");
    logger.fatal("This is fatal message");
    System.out.println("\n Completed...!\n");

}
}
