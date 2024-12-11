package Practical_11;

import java.util.Arrays;

class Session {
    private int sessionId;
    private String location;
    private Talk[] talkList;
    private int currentSize;

    // Constructor for Session
    public Session(int sessionId, String location) {
        this.sessionId = sessionId;
        this.location = location;
        this.talkList = new Talk[4];
        this.currentSize = 0;
    }

    // Schedules a talk in the session
    public void scheduleTalk(Talk talk) {
        // Resize the array if it's full
        if (currentSize == talkList.length) {
            talkList = Arrays.copyOf(talkList, talkList.length * 2); // copyof is duplicating the array
        }

        // Check if the talk is not already in the talk list
        if (!IsTalkScheduledAlready(talk)) {
            int index = 0;
            // Find the correct position to maintain ascending order based on startTime
            while (index < currentSize && talkList[index].compareTo(talk) < 0) {
                index++;
            }

            // Shift talks to make space for the new talk
            System.arraycopy(talkList, index, talkList, index + 1, currentSize - index);
            talkList[index] = talk;
            currentSize++;
        }
    }

    // Cancels a scheduled talk in the session
    public void cancelTalk(Talk talk) {
        // Check if the talk is in the talk list
        int index = indexOfTalk(talk);
        if (index != -1) {
            // Remove the talk and shift remaining talks
            System.arraycopy(talkList, index + 1, talkList, index, currentSize - index - 1);
            talkList[--currentSize] = null; // Set the last element to null
        }
    }

    // Helper method to check if a talk is already scheduled in the session
    private boolean IsTalkScheduledAlready(Talk talk) {
        for (int i = 0; i < currentSize; i++) {
            if (talkList[i].equals(talk)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to find the index of a talk in the talk list
    private int indexOfTalk(Talk talk) {
        for (int i = 0; i < currentSize; i++) {
            if (talkList[i].equals(talk)) {
                return i;
            }
        }
        return -1;
    }

    // Override toString() for a human-friendly representation of the class
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Session{" +
                "sessionId=" + sessionId +
                ", location='" + location + '\'' +
                ", talkList=[");

        // Append non-empty talks to the result
        for (int i = 0; i < currentSize; i++) {
            result.append(talkList[i]);
            if (i < currentSize - 1) {
                result.append(", ");
            }
        }

        result.append("]}");
        return result.toString();
    }
}