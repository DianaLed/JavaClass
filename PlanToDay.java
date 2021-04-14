import java.util.Calendar;
import java.util.GregorianCalendar;

public class PlanToDay {
    Date_simple date;
    int size_of_quetion;
    PlanToDay(int day, int mon, int year, int size_of_quet){
       date= new Date_simple(day, mon, year);
       size_of_quetion=size_of_quet;
    }
    PlanToDay(Date_simple date_, int size_of_quet){
        date=  date_;
        size_of_quetion=size_of_quet;
    }

    void change_size_of_quetion(int a){
        size_of_quetion=a;
    }

}
