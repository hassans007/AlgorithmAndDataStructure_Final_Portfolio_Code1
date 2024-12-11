package Practical_11;

public class Conference {

    public static void main(String[] args) {
        Session session1 = new Session(1, "Room A");
        Session session2 = new Session(2, "Room B");
        Session session3 = new Session(3, "Room C");
        Session session4 = new Session(4, "Room D");

        scheduleAndCancelTalks(session1);
        scheduleAndCancelTalks(session2);
        scheduleAndCancelTalks(session3);
        scheduleAndCancelTalks(session4);

        printConferenceSchedule(session1);
        printConferenceSchedule(session2);
        printConferenceSchedule(session3);
        printConferenceSchedule(session4);
    }

    private static void scheduleAndCancelTalks(Session session) {
        Talk talk1 = new Talk(1, "Speaker1", "Title1", "10:00:00");
        Talk talk2 = new Talk(2, "Speaker2", "Title2", "11:00:00");
        Talk talk3 = new Talk(3, "Speaker3", "Title3", "14:00:00");
        Talk talk4 = new Talk(4, "Speaker4", "Title4", "15:00:00");

        session.scheduleTalk(talk1);
        session.scheduleTalk(talk2);
        session.scheduleTalk(talk3);
        session.scheduleTalk(talk4);

        session.cancelTalk(talk1);
        session.cancelTalk(talk3);
    }

    private static void printConferenceSchedule(Session session) {
        System.out.println(session);
        System.out.println(" ");
    }
}