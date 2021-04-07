import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Subject {
    String name_of_sub;
    ArrayList <Question> question;
    private Calendar date_of_exams; //Дата, когда будет экзамен .. 1.1.1- не вводили
    Subject() {
        name_of_sub="";
        question=new ArrayList<Question>();
        date_of_exams= new GregorianCalendar(1, 1, 1);
    }
    Subject(String name, int day, int mon, int year ) {
        name_of_sub=name;
        question=new ArrayList<Question>();
        date_of_exams= new GregorianCalendar(year, mon, day);
    }

    void add_question(Question quest)
    //добавить вопрос в конец списка
    {
        question.add(quest);
    }
    void delete_question(int nom)
    //удалить вопрос по номеру
    {
        if(nom>=0&&nom<question.size()) question.remove(nom);
    }
    void change_question (int nom, String quest, String answer){
        //изменить вопрос по номеру, если "", менять не будет
        if(nom>=0&&nom<question.size()) {
            if(answer!="")question.get(nom).answer = answer;
            if(quest!="")question.get(nom).question = quest;
        }
    }
    void change_date( int day, int mon, int year){
        //проверки на дурака нет, вводи все сразу правильно
        date_of_exams.set(year, mon, day);
    }
    String get_Question (int nom){
        if(nom < question.size() && nom >= 0) return question.get(nom).question;
        return "ERROR";
    }
    String get_Answer(int nom){
        if(nom < question.size() && nom >= 0) return question.get(nom).answer;
        return "ERROR";
    }
    Question get_Class_Question (int nom){
        if(nom < question.size() && nom >= 0) return question.get(nom);
        return new Question();
    }
    int get_size_all_quest(){
        //количество вопросов
        return question.size();
    }
    int get_size_know()
    //количество выученных вопросов
    {
        int d=0;
        for(int i=0; i<question.size(); i++){
            if(question.get(i).Getknow_answer()) d++;
        }
        return d;
    }
    int get_size_no_know()
    //количество невыченных вопросов
    {
        int d=0;
        for(int i=0; i<question.size(); i++){
            if(!question.get(i).Getknow_answer()) d++;
        }
        return d;
    }
    Calendar GetDate() {
        return date_of_exams;
    }
    int dd(){
        return date_of_exams.get(Calendar.DAY_OF_MONTH);
    }
    int mo(){
        return date_of_exams.get(Calendar.MONTH);
    }
    int yy(){
        return date_of_exams.get(Calendar.YEAR);
    }
    int hh(){
        return  date_of_exams.get(Calendar.HOUR);
    }
    int mi(){
        return  date_of_exams.get(Calendar.MINUTE);
    }
}
