package tasktracking.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public abstract class Work{

    private String jobName = null;
    private int priority = -1;
    private int jobStatusTime = 0;
    private LocalTime timeNow = LocalTime.now();
    private LocalTime timeStart = LocalTime.now();
    private LocalTime timeEnd = timeStart.plusMinutes(1);
    private LocalDate dateNow = LocalDate.now();
    private LocalDate dateStart = LocalDate.now();
    private LocalDate dateEnd = LocalDate.now();
    private String formattedDate = null;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
    private String category = null;
    private int count = -1;
    private int hour1 = -1;
    private int minute1 = -1;
    private int hour2 = -1;
    private int minute2 = -1;

    public Work(int count,String jobName,int priority,int hour1,int minute1,int hour2,int minute2,LocalDate date,String category){
        this.count = count;
        this.jobName = jobName;
        setPriority(priority);
        this.timeStart = LocalTime.of(hour1,minute1);
        this.timeEnd = LocalTime.of(hour2,minute2);
        this.formattedDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        this.dateStart = date;
        this.dateEnd = dateStart;
        this.hour1 = hour1;
        this.minute1 = minute1;
        this.hour2 = hour2;
        this.minute2 = minute2;
        if(category.equals("")){
            this.category = "-";
        }else{
            this.category = category;
        }
        checkDate();
    }

    public void setJobName(String jobName){
        this.jobName = jobName;
    }

    public void setPriority(int priority){
        if(priority > 5){
            this.priority = 5;
        }else if(priority <= 0){
            this.priority = 0;
        }else{
            this.priority = priority;
        }

    }

    public void setJobStatusTime(int jobStatusTime){
        this.jobStatusTime = jobStatusTime;
    }

    public void setHour1(int hour1) {
        this.hour1 = hour1;
    }

    public void setMinute1(int minute1) {
        this.minute1 = minute1;
    }

    public void setHour2(int hour2) {
        this.hour2 = hour2;
    }

    public void setMinute2(int minute2) {
        this.minute2 = minute2;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setTimeStart(int hour, int minute){
        this.timeStart = LocalTime.of(hour,minute);
        checkTime();
    }

    public void setTimeEnd(int hour,int minute){
        this.timeEnd = LocalTime.of(hour,minute);
        checkTime();
    }

    public void setDateStart(int year,int month ,int dayOfMonth) {
        this.dateStart = LocalDate.of(year,month,dayOfMonth);
        checkDate();
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void checkDate(){
        if(dateNow.compareTo(dateStart) == 0){
            checkTime();
        }else if(dateNow.compareTo(dateStart)>0){
            setJobStatusTime(2);
        }else{
            setJobStatusTime(0);
        }
    }

    public void checkTime(){
        if(timeNow.compareTo(timeStart)>0){
            if(timeNow.compareTo(timeEnd)<0){
                this.jobStatusTime = 1;
            }else{
                this.jobStatusTime = 2;
            }
        }else{
            if(timeNow.compareTo(timeEnd)<0){
                this.jobStatusTime = 0;
            }else{
                this.jobStatusTime = 1;
            }

        }
    }

    public String showJobName(){
        return jobName;
    }

    public int showPriority(){
        return priority;
    }

    public String showJobStatus(){
        String ans = "";
        if(jobStatusTime == 0){
            ans = "ยังไม่เริ่ม";
        }else if(jobStatusTime == 1){
            ans = "กำลังทำ";
        }else if(jobStatusTime == 2){
            ans = "เสร็จแล้ว";
        }
        return ans;
    }

    public LocalTime showTimeStart(){
        return timeStart;
    }

    public LocalTime showTimeEnd(){
        return timeEnd;
    }

    public LocalDate showDateStart(){
        return dateStart;
    }

    public String showForMattedDateStart(){
        return formattedDate;
    }

    public LocalDate showDateEnd(){
        return dateEnd;
    }

    public String showForMattedTimeStart(){
        return timeStart.format(dtf);
    }

    public String showForMattedTimeEnd(){
        return timeEnd.format(dtf);
    }

    public String showCategory() {
        return category;
    }

    public  int showCount(){
        return count;
    }

    public int showHour1(){
        return hour1;
    }

    public int showMinute1(){
        return minute1;
    }

    public int showHour2(){
        return hour2;
    }

    public int showMinute2(){
        return minute2;
    }

    public LocalDate showDateNow() {
        return dateNow;
    }
}
