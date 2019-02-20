package ru.sstu.lessons.lesson8;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleFormater extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getLoggerName() + " " + record.getLevel().getName() + " " + record.getMessage() + "\n";
    }
}
