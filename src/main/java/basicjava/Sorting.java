package basicjava;

import java.util.*;

public class Sorting {
    int sessions = 1000000;
    int eventsinSession = 50;
    Random random = new Random();
    long epochBase = 1458053812000l;
    private ArrayList<Long> getEvents(int n){
        ArrayList<Long> eventList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            eventList.add(epochBase+ random.nextInt(10000));
        }
        return eventList;

    }
    public void sortSessions(){
        List<ArrayList<Long>> list = new ArrayList<>();
        for (int i = 0 ;i<sessions;i++){
            ArrayList<Long> sessionEvents = getEvents(eventsinSession);
            list.add(sessionEvents);}
            Date d = new Date();
            System.out.println("Starting sorting"+d);
            for (ArrayList<Long> events:list){
                Collections.sort(events);
            }
            Date ed = new Date();
            System.out.println("ended sorting"+ed);

        }

    public void sortTotals(){
        List<Long> events = getEvents(sessions*eventsinSession);
        Date d = new Date();
        System.out.println("Starting sorting"+d);
        Collections.sort(events);
        Date ed = new Date();
        System.out.println("ended sorting"+ed);
    }

    public static void main(String[] args) {
        Sorting mm = new Sorting();
        mm.sortSessions();
        mm.sortTotals();
    }


}
