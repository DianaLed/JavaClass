import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PlanToSub {
    Subject sub; //предмет
    ArrayList<PlanToDay> plan_to_day; //планы на все дни
    int todaylearned; //сколько выучили именно сегодня
    Date_simple today;
    private Date_simple date_of_exams; //Дата, когда будет экзамен
    PlanToSub(Subject sub_, int day, int mon, int year){
        sub=sub_;
        date_of_exams= new Date_simple(year, mon, day);
        plan_to_day=new ArrayList<PlanToDay>();
        todaylearned=0;
        today=new Date_simple();
    }
    //При открытии программы это делать всегда.
    void open_prog(){
        Date_simple av=new Date_simple();
        if(today.before(av)) { //тут проверяется наступил ли новый день
            int a=search_nom_plan(today.day, today.month, today.year);
            plan_to_day.get(a).size_of_quetion=todaylearned;
            todaylearned=0;
            today=av;
        }
    }
    void after_sudy(Study a){
        todaylearned=todaylearned+a.now_learned;
    }

    private void sort_list(){
        Date_simple a=new Date_simple(0, 0, 0);
        int d=0;
        for(int i=1; i<plan_to_day.size(); i++) {
            if(plan_to_day.get(i-1).date.before(plan_to_day.get(i).date)) continue;
            for(int j=i; j>=1; j--){
                if(plan_to_day.get(j).date.before(plan_to_day.get(j-1).date)) {
                   plan_to_day.add(j-1,plan_to_day.get(j));
                   plan_to_day.remove(j+1);
               } else continue;
            }
        }
    }
    private int search_nom_plan(int dat, int mon, int yy){
        Date_simple a=new Date_simple(dat, mon, yy);
        for(int i=0; i<plan_to_day.size(); i++){
            if(a.equally(plan_to_day.get(i).date)) return i;
        }
        return -1;
    }
    void delete_date_to_study(int day, int mon, int year){
        int a=search_nom_plan(day, mon, year);
        if(a!=-1) {
            plan_to_day.remove(a);
            do_plan();
        }
    }
    void add_date_to_study(int day, int mon, int year){
        //проверить, не было ли этой даты ранее
        int d=0;
        Date_simple da=new Date_simple(day, mon, year);
        for(int i=0; i<plan_to_day.size(); i++) {
            if (plan_to_day.get(i).date.equally(da)) {
                d++;
                break;
            }
        }
        //2- добавить дату
        if(d==0){
            plan_to_day.add(new  PlanToDay(da, 0));
            sort_list();
            do_plan();
        }
    }
    //количество дней до экзамена
    int size_today_day_of_exams(){
        Calendar a= new GregorianCalendar();
        Calendar b= new GregorianCalendar(date_of_exams.year, date_of_exams.month, date_of_exams.day);
        int res=0;
        if(a.before(b)){
            while(a!=b){
                a.add(Calendar.DATE, 1);
                res++;
            } //пока a!=b прибавлять день
        }
        return res;
    }
    private void do_plan(){
        int size_of_fall_qwestion=sub.get_size_no_know(); //количество не выученных вопросов
        int size_of_days=size_today_day_of_exams(); //количество дней до экзамена
        int average; //среднее арифметическое
        if(size_of_days==0) average=0;
        else average=size_of_fall_qwestion/size_of_days;
        if(average*size_of_days==size_of_fall_qwestion) //если чудом все поделилось нацело
            for(int i=size_today_day_of_exams()-1; i<plan_to_day.size()-1; i++){
                plan_to_day.get(i).size_of_quetion=average;
            }
        else{ //если не поделилось на цело
            int s=size_of_fall_qwestion-average*size_of_days; //считаем остаток
            for(int i=size_today_day_of_exams()-1; i<plan_to_day.size()-1; i++){
                if(s!=0) { //добавляем этот остаток, пока он не иссякнет
                    plan_to_day.get(i).size_of_quetion=average+1;
                    s--;
               } else plan_to_day.get(i).size_of_quetion=average;
            }
       }
    } //план создается для ненаступивших дат и количества невыученных вопросов.
    void change_date_of_exams( int day, int mon, int year){
    //проверки на дурака нет, вводи все сразу правильно
        date_of_exams.day=day;
        date_of_exams.month=mon;
        date_of_exams.year=year;
        do_plan();
    }
}