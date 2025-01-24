
//this interface extends the JpaRepository interface which have all the methods to do manipulate our db

// the extended interface, must



package com.ganesh.TaskTracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTrackRepository extends JpaRepository<TaskTrackerDb,Long> {
}
