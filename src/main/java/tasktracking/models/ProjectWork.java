package tasktracking.models;

import java.time.LocalDate;

public class ProjectWork extends Work implements Comparable{
    private String test = "";
    private String projectLeader = "";

    public ProjectWork(int count,String jobName,String projectLeader ,int priority, int hour1, int minute1, int hour2, int minute2 ,LocalDate date,String category){
        super(count,jobName,priority,hour1,minute1,hour2,minute2,date,category);
        if(category.equals("")){
            setCategory("-");
            category = "-";
        }

        this.projectLeader = projectLeader;
        test = count+","+jobName+","+projectLeader+","+priority+","+hour1+","+minute1+","+hour2+","+minute2+","+date+","+showDateEnd()+","+category;
        checkDate();
    }

    public void checkDate(){
        if(showDateNow().compareTo(showDateStart()) < 0){
            setJobStatusTime(0);
        }else{
            if(showDateNow().compareTo(showDateEnd())>0){
                setJobStatusTime(2);
            }else {
                setJobStatusTime(1);
            }
        }
    }

    public String test(){

        return test;
    }

    public String showForMattedDateStart(){
        return super.showDateStart().toString();
    }

    public String showForMattedDateEnd(){
        return super.showDateEnd().toString();
    }

    public String showProjectLeader(){
        return projectLeader;
    }

    public void setProjectLeader(String name){
        this.projectLeader = name;
    }

    @Override
    public int compareTo(Object o) {
        int comparePriority = ((ProjectWork) o).showPriority();

        //ascending order
        return comparePriority - this.showPriority();
    }

}

