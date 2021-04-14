import java.util.Calendar;
import java.util.GregorianCalendar;
public class Question {
    String question; //Вопрос //publick
    String answer; //Ответ //publick
    private Date_simple last_date; //Дата, когда попадался этот вопрос последний раз //1.1.1-значит еще не было
    private int size_of_view; //сколько раз попадался этот вопрос
    private boolean know; //Вопрос выучен- 1, не выучен- 0
    public Question() {
        question = "";
        answer = "";
        last_date = new Date_simple(1, 1, 1);
        size_of_view = 0;
        know = false;
    }
    public Question(String quest, String ansver)
    {
        question = quest;
        answer = ansver;
        last_date = new Date_simple(1, 1, 1);
        size_of_view = 0;
        know = false;
    }
    void base_click(int click_on_res)
    //____________________________________________
    // если правильно-1, если нет- 0, 2- если неизвестно
    {
        last_date.day=new Date_simple().day;
        last_date.month=new Date_simple().month;
        last_date.year=new Date_simple().year;
        //должен установить текущее время

        if(click_on_res==0) {
            know = false;
            size_of_view++;
        }
        else if ((click_on_res == 1)&& know == false) {
            know = true;
            size_of_view++;
        }
        else if (click_on_res == 2) {
            know = false;
            size_of_view++;
        }
    }
    boolean Getknow_answer() {
        return know;
    }
    int get_size_of_view(){
        return size_of_view;
    }

    Date_simple GetDate() {
        return last_date;
    }
    void formaintestNOTOUCH(int sov, boolean k, Date_simple ld){
        size_of_view=sov;
        know=k;
        last_date=ld;
    }
}
