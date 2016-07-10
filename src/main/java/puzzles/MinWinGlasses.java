package puzzles;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mm on 5/3/16.
 */
public class MinWinGlasses {
    public static void main(String[] args) {
        BufferedReader br = null;
        int len = 0;
        ArrayList<Time> timeArr = new ArrayList<>() ;
        try {
            String sCurrentLine;
            int i = 0;
            br = new BufferedReader(new FileReader("/home/mm/misc/algorithms/src/main/resources/wineglassesinput1"));
            while ((sCurrentLine = br.readLine()) != null) {
                   i++;
                   if (i  > 2){
                    String[] timeStr = sCurrentLine.split(" ");
                    Time arr = new Time(Integer.parseInt(timeStr[0]),'A');
                    Time dep = new Time(Integer.parseInt(timeStr[1]),'D');
                    timeArr.add(arr);
                    timeArr.add(dep);
                }
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        int maxWineGlasses = 0;
        int currentWineGlasses = 0;
        Collections.sort(timeArr);
        for (Time time: timeArr){
            System.out.println(time);
            if (time.type=='A') currentWineGlasses++;
            if (time.type=='D') currentWineGlasses--;
            if (currentWineGlasses > maxWineGlasses) maxWineGlasses = currentWineGlasses;
        }

        System.out.printf("maxwineglasses:"+maxWineGlasses);
    }



}

class Time implements Comparable<Time> {
    int time;
    char type;

    public Time(int time, char type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Time time) {
        return this.time - time.time;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                ", type=" + type +
                '}';
    }
}