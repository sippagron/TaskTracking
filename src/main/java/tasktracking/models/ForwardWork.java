package tasktracking.models;

import java.time.LocalDate;

public class ForwardWork extends Work implements Comparable{
    private String test = "";
    private String responsibleMan = "";

    public ForwardWork(int count,String jobName,String responsibleMan ,int priority, int hour1, int minute1, int hour2, int minute2 ,LocalDate date,String category){
        super(count,jobName,priority,hour1,minute1,hour2,minute2,date,category);
        if(category.equals("")){
            setCategory("-");
            category = "-";
        }

        this.responsibleMan = responsibleMan;
        test = count+","+jobName+","+responsibleMan+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date+","+category;
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

    public String showResponsibleMan(){
        return responsibleMan;
    }

    public void setResponsibleMan(String name){
        this.responsibleMan = name;
    }

    @Override
    public int compareTo(Object o) {
        int comparePriority = ((ForwardWork) o).showPriority();

        //ascending order
        return comparePriority - this.showPriority();
    }
}
