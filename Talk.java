package Practical_11;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Talk implements Comparable<Talk> {

    private int id;
    private String speaker;
    private String title;
    private LocalTime startTime; // Time in ISO 8601 format (HH:mm:ss)

    // Constructor for Talk
    public Talk(int id, String speaker, String title, String startTime) {
        this.id = id;
        this.speaker = speaker;
        this.title = title;
        this.startTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    // Override toString() for a human-friendly representation of the class
    @Override
    public String toString() {
        return "Talk{" +
                "id=" + id +
                ", speaker='" + speaker + '\'' +
                ", title='" + title + '\'' +
                ", startTime=" + startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) +
                '}';
    }

    // Override compareTo() for total ordering based on startTime
    @Override
    public int compareTo(Talk otherTalk) {
        return this.startTime.compareTo(otherTalk.startTime);
    }
}