package tasktracking.models;

import tasktracking.services.FileManager;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegularWork extends Work implements Comparable{

    private String test = "";
    private String test1 = "";
    private ArrayList<RegularDayofWeek> regularDayofWeeks;
    public RegularWork(int count,String jobName, int priority, int hour1, int minute1, int hour2, int minute2, LocalDate date,String category){
        super(count,jobName,priority,hour1,minute1,hour2,minute2,date,category);
        if(category.equals("")){
            setCategory("-");
            category = "-";
        }
        test = count+","+jobName+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date+","+category;
        checkDate();
        regularDayofWeeks = new FileManager().readFileRegularDayOfWeek(count);

    }

    public String toString(){
        return showJobName()+","+showDateStart()+","+showTimeStart()+","+showTimeEnd()+","+showPriority()+","+showJobStatus()+","+showCategory()+","+showCount();
    }


    public String test(){
        return test;
    }


    public ArrayList<RegularDayofWeek> showDayOfWeeks(){
        return regularDayofWeeks;
    }

    public String test1(){
        test1 = showCount()+","+showDateStart()+","+false+","+false+","+false+","+false+","+false+","+false;
        return test1;
    }

    public DayOfWeek dayOfWeek(){
        return showDateStart().getDayOfWeek();
    }

    public String showForMattedDate(){
        return super.showDateStart().toString();
    }

    @Override
    public int compareTo(Object o) {
        int comparePriority = ((RegularWork) o).showPriority();

        //ascending order
        return comparePriority - this.showPriority();
    }

}
