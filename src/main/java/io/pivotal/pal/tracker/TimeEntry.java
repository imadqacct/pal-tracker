package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int hours) {
        id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        date = parse;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate parse, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        date = parse;
        this.hours = hours;
    }

    public TimeEntry() {

    }


    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }


    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return getId() == timeEntry.getId() &&
                getProjectId() == timeEntry.getProjectId() &&
                getUserId() == timeEntry.getUserId() &&
                getHours() == timeEntry.getHours() &&
                getDate().equals(timeEntry.getDate());
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectId(), getUserId(), getDate(), getHours());
    }
}
