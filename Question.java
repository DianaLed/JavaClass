import java.util.Calendar;
import java.util.GregorianCalendar;
public class Question {
    String question; //Вопрос //publick
    String answer; //Ответ //publick
    private Calendar last_date; //Дата, когда попадался этот вопрос последний раз //1.1.1-значит еще не было
    private int size_of_view; //сколько раз попадался этот вопрос
    private boolean know; //Вопрос выучен- 1, не выучен- 0
    public Question() {
        question = "";
        answer = "";
        last_date = new GregorianCalendar(1, 1, 1);
        size_of_view = 0;
        know = false;
    }
    public Question(String quest, String ansver)
    {
        question = quest;
        answer = ansver;
        last_date = new GregorianCalendar(1, 1, 1);
        size_of_view = 0;
        know = false;
    }
    void base_click(int click_on_res)
    // если правильно-1, если нет- 0, 2- если неизвестно
    {
        last_date=Calendar.getInstance(); //должен установить текущее время

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

    Calendar GetDate() {
        return last_date;
    }
    int dd(){
        return last_date.get(Calendar.DATE);
    }
    int mo(){
        return last_date.get(Calendar.MONTH);
    }
    int yy(){
        return last_date.get(Calendar.YEAR);
    }
    int hh(){
        return  last_date.get(Calendar.HOUR);
    }
    int mi(){
        return  last_date.get(Calendar.MINUTE);
    }

    int GetSizeOfView() {
        return size_of_view;
    }
}
