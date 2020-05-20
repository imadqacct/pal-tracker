package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private Map<Object,TimeEntry> timeEntryMap = new HashMap<>();
    private long currentId = 1L;
    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }
    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry lTimeEntry = null;
        long id = currentId++;
        lTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryMap.put(id,lTimeEntry);
        return lTimeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {

        return timeEntryMap.get(timeEntryId);
    }
    @Override
    public List<TimeEntry> list() {

        ArrayList<TimeEntry> timeEntries = new ArrayList();
        for(Object id: timeEntryMap.keySet()){
            timeEntries.add(timeEntryMap.get(id));
        }
        System.out.println(timeEntries);
        return timeEntries;

    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        //TimeEntry lTimeEntry = timeEntryMap.get(eq);
        if (find(eq) == null) return null;

        TimeEntry lTimeEntry = new TimeEntry(
                eq,
                any.getProjectId(),
                any.getUserId(),
                any.getDate(),
                any.getHours()
        );

        timeEntryMap.replace(eq, lTimeEntry);
        return lTimeEntry;
    }

    @Override
    public void delete(long timeEntryId) {
        timeEntryMap.remove(timeEntryId);
    }

}
