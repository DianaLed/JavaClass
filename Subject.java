import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Subject {
    String name_of_sub;
    private ArrayList <Question> question;

    Subject() {
        name_of_sub="";
        question=new ArrayList<Question>();
    }
    Subject(String name) {
        name_of_sub=name;
        question=new ArrayList<Question>();
    }
    Subject(String name, ArrayList<Question> arr_questions) {
        name_of_sub=name;
        question=arr_questions;
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

    //--------------------Выдача вопросов для алгоритма---------
    int O_most_difficult_n(int max){
        //выводит вопрос с максимальным количесвом попаданий и при этом не выученный
        int res=-1;
        int d=0, d1=0;
        for(int i=0; i<question.size(); i++){
            d1=question.get(i).get_size_of_view();
            if(!(question.get(i).Getknow_answer())&&d1!=0&&(d1>d))
            {
                if(d1<max){
                    d=d1;
                    res=i;
                }
            }
        }
        return res;
    }
    int O_most_difficult(int max){
        //выводит вопрос с максимальным количесвом попаданий и при этом выученный
        int res=-1;
        int d=0, d1=0;
        for(int i=0; i<question.size(); i++){
            d1=question.get(i).get_size_of_view();
            if((question.get(i).Getknow_answer())&&d1!=0&&(d1>d))
            {
                if(d1<max&&question.get(i).GetDate().day==Calendar.DATE &&question.get(i).GetDate().month==Calendar.MONTH && question.get(i).GetDate().year==Calendar.YEAR){
                    d=d1;
                    res=i;
                }
            }
        }
        return res;
    }
    int O_oldest(Date_simple max) { //???
        int res = -1;
        Date_simple d = new Date_simple(), d1 = new Date_simple(1, 1, 1);
        for (int i = 0; i < question.size(); i++) {
            d = question.get(i).GetDate(); //получили дату
            if ((question.get(i).Getknow_answer()) && (d1.before(d))) { //знаем вопрос+ d1 до d
                if(question.get(i).GetDate().before(max)){
                    d = d1;
                    res = i;
                }
            }
        }
        return res;
    }
    int O_new(){
        int res=-1;
        for (int i = 0; i < question.size(); i++) {
            if (!(question.get(i).Getknow_answer())){
                return i;
            }
        }
        return res;
    }
    ArrayList<Integer> O_get_array_new_q(int size){
        ArrayList<Integer> res=new ArrayList<Integer>();
        for (int i = 0; i < question.size(); i++) {
            if (!(question.get(i).Getknow_answer())&&(question.get(i).get_size_of_view()==0)){
                res.add(i);
            }
        }
        return res;
    }

    int O_size_difficult() {
        int res = 0;
        int d1;
        for (int i = 0; i < question.size(); i++) {
            d1 = question.get(i).get_size_of_view();
            if (!(question.get(i).Getknow_answer()) && d1 != 0) {
                res++;
            }
        }
        return res;
    }
    int O_size_new(){
        int res=0;
        for (int i = 0; i < question.size(); i++) {
            if (!(question.get(i).Getknow_answer())&&question.get(i).get_size_of_view()==0){
                res++;
            }
        }
        return res;
    }
    //Calendar GetDate() {
    //    return date_of_exams;
    //}
    //int dd(){
     //   return date_of_exams.get(Calendar.DAY_OF_MONTH);
   // }
   // int mo(){
   //     return date_of_exams.get(Calendar.MONTH);
   // }
   // int yy(){
   //     return date_of_exams.get(Calendar.YEAR);
   // }
  //  int hh(){
   //     return  date_of_exams.get(Calendar.HOUR);
   // }
   // int mi(){
    //    return  date_of_exams.get(Calendar.MINUTE);
   // }
}
