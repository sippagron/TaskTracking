package tasktracking.models;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RegularDayofWeek{

    private LocalDate date;
    private Boolean status = false;

    public RegularDayofWeek(LocalDate date){
        this.date = date;
    }

    public void setStatus(){
        if(status == false){
            status = true;
        }else{
            status = false;
        }
    }

    public void setStatus2(boolean status){
        this.status = status;
    }

    public Boolean getStatus(){
        return status;
    }

    public DayOfWeek showDate(){
        return date.getDayOfWeek();
    }

}
