# README for Practical_11 Java Project

## Project Overview
This project simulates the scheduling and cancellation of talks within a conference. The conference consists of multiple sessions, each taking place in a designated room. Each session can host multiple talks, which are scheduled based on their start time. Talks can be scheduled, and if necessary, canceled. The project includes three primary classes: `Conference`, `Session`, and `Talk`.

## Classes Overview

### 1. `Conference` Class
The `Conference` class is the main entry point for the program. It creates multiple `Session` objects, schedules talks within each session, cancels specific talks, and then prints the final schedule of each session.

**Key Methods:**
- `main(String[] args)`: This method creates multiple sessions and schedules and cancels talks for each session.
- `scheduleAndCancelTalks(Session session)`: This method schedules four talks and cancels two of them within a given session.
- `printConferenceSchedule(Session session)`: This method prints the schedule of a given session after scheduling and canceling talks.

### 2. `Session` Class
The `Session` class represents a conference session, including a session ID, location (room name), and a list of scheduled talks. It allows talks to be scheduled, canceled, and printed in a readable format.

**Key Methods:**
- `scheduleTalk(Talk talk)`: Schedules a new talk in the session, ensuring that talks are ordered based on their start time.
- `cancelTalk(Talk talk)`: Cancels a talk from the session by finding the talk and removing it from the list.
- `IsTalkScheduledAlready(Talk talk)`: Checks if a given talk is already scheduled in the session.
- `indexOfTalk(Talk talk)`: Finds the index of a given talk in the session’s talk list.
- `toString()`: Returns a human-readable string representation of the session, including all scheduled talks.

### 3. `Talk` Class
The `Talk` class represents an individual talk within a session, including details such as the talk ID, speaker name, title, and start time.

**Key Methods:**
- `compareTo(Talk otherTalk)`: Compares the start time of the current talk with another talk. This is used to maintain an ascending order of talks based on their start times.
- `toString()`: Returns a human-readable string representation of the talk, showing the ID, speaker, title, and start time in the `HH:mm:ss` format.

## How the Program Works

1. **Creating Sessions:**
   - In the `main()` method of the `Conference` class, four `Session` objects are created, each with a unique session ID and room location (e.g., "Room A", "Room B").

2. **Scheduling Talks:**
   - The `scheduleAndCancelTalks()` method is called for each session. This method creates four `Talk` objects with unique IDs, speakers, titles, and start times.
   - These talks are scheduled using the `scheduleTalk()` method, which adds each talk to the session in the correct order based on its start time.

3. **Canceling Talks:**
   - After scheduling, two talks are canceled for each session using the `cancelTalk()` method. Talks are removed from the session’s talk list, and the remaining talks are shifted to maintain the correct order.

4. **Printing the Schedule:**
   - After scheduling and canceling talks, the `printConferenceSchedule()` method is called for each session to display the final schedule. This is done by printing the session’s `toString()` representation, which includes the session ID, room name, and all scheduled talks.

## Example Output
The output will display the details of each session, showing the talks that are scheduled for each session after cancellations. An example output might look like this:

