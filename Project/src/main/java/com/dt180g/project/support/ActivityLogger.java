package com.dt180g.project.support;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ActivityLogger {
    public static final ActivityLogger INSTANCE = new ActivityLogger();
    private final Logger logger;

    private ActivityLogger() {
        logger = Logger.getLogger("Game Activity");
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
    }

    public static ActivityLogger getInstance() {
        return INSTANCE;
    }

    private void delayExecution() {
        try {
            Thread.sleep(AppConfig.SLEEP_DELAY);
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private void performLog(String message) {
        if (AppConfig.USE_SLEEP_DELAY) {
            delayExecution();
        }
        logger.log(Level.INFO, message);
    }

    public void logRoundInfo(String message) {
        performLog("[ROUND] " + message);
    }

    public void logTurnInfo(String message) {
        performLog("[TURN] " + message);
    }

    public void logAttack(String message) {
        performLog("[ATTACK] " + message);
    }

    public void logDamage(String message) {
        performLog("[DAMAGE] " + message);
    }

    public void logDeath(String message) {
        performLog("[DEATH] " + message);
    }

    public void logHealing(String message) {
        performLog("[HEALING] " + message);
    }
}
