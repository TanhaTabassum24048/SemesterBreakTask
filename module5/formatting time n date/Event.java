import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Event {
    private String name;
    private ZonedDateTime dateTime;
    private Duration duration;

    public Event(String name, ZonedDateTime dateTime, Duration duration) {
        this.name = name;
        this.dateTime = dateTime;
        this.duration = duration;
    }
    public String getName() { return name; }
    public ZonedDateTime getDateTime() { return dateTime; }
    public String display(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return name + " | " + dateTime.format(formatter) +
               " | Duration: " + duration.toHours() + " hrs";
    }
}