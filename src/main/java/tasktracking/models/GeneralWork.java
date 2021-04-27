package tasktracking.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class GeneralWork extends Work implements Comparable{

    private String test = "";

    public GeneralWork(int count,String jobName, int priority, int hour1, int minute1, int hour2, int minute2, LocalDate date,String category){
        super(count,jobName,priority,hour1,minute1,hour2,minute2,date,category);
        if(category.equals("")){
            setCategory("-");
            category = "-";
        }
        test = count+","+jobName+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date+","+category;
        checkDate();
    }

    public String toString(){
        return showJobName()+","+showDateStart()+","+showTimeStart()+","+showTimeEnd()+","+showPriority()+","+showJobStatus()+","+showCategory()+","+showCount();
    }


    public String test(){

        return test;
    }

    public String showForMattedDate(){
        return super.showDateStart().toString();
    }

    @Override
    public int compareTo(Object o) {
        int comparePriority = ((GeneralWork) o).showPriority();

        //ascending order
        return comparePriority - this.showPriority();
    }
}
