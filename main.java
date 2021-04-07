import java.util.Calendar;
import java.util.GregorianCalendar;

public class main {
    public static void main(String args[]){
        System.out.println("Запуск тестов, если что-то выведется, значит не работает.\n");
        Question a=new Question(), b=new Question("Сколько тебе лет?", "20");
        a.question="Как тебя зовут?";
        a.answer="Диана";
        //тестирование class Question
        //в случае ошибок выводятся сообщения
        if(!(
                a.question=="Как тебя зовут?"
                        && a.answer=="Диана"
                        && a.Getknow_answer()==false
                        && a.yy()==1
                        && a.mo()==1
                        && a.dd()==1
                        && a.GetSizeOfView()==0
                )
        ) System.out.println("ERROR Constr_base\n");
        if(!(b.question=="Сколько тебе лет?"
                && b.answer=="20"
                && b.Getknow_answer()==false
                && b.yy()==1
                && b.mo()==1
                && b.dd()==1
                && b.GetSizeOfView()==0
        )
        ) System.out.println("ERROR Constr_params\n");

        a.base_click(0);
        Calendar today=new GregorianCalendar();

        if(a.dd()!=today.get(Calendar.DATE)
        &&a.mo()!=today.get(Calendar.MONTH)
                && a.yy()!=today.get(Calendar.YEAR)
        ) System.out.println("ERROR, time  base_click 0 \n");
        if(a.GetSizeOfView()!=1) System.out.println("ERROR, SizeOfView base_click 0 \n");
        if(a.Getknow_answer()!=false) System.out.println("ERROR, know_answer base_click 0 \n");
        a.base_click(1);
        if(a.Getknow_answer()!=true) System.out.println("ERROR, know_answer base_click 1 \n");
        if(a.GetSizeOfView()!=2) System.out.println("ERROR, SizeOfView base_click 1 \n");

        //тестирование class  Subject
        //в случае ошибок выводятся сообщения
        Subject s=new Subject();
        if(!(s.dd()==1 && s.yy()==1 && s.mo()==1 && s.get_size_all_quest()==0 && s.get_size_know()==0)) System.out.println("ERROR, Subject \n");
        s.add_question(a);
        if(s.get_size_all_quest()!=1) System.out.println("ERROR, Subject add_question\n");
        if(s.get_Question(-1)!="ERROR") System.out.println("ERROR, Subject get_Qwestion\n");
        if(s.get_Question(0)!="Как тебя зовут?") System.out.println("ERROR, Subject get_Qwestion\n");
        if(s.get_Question(1)!="ERROR") System.out.println("ERROR, Subject get_Qwestion\n");
        s.delete_question(0); //элементов больше нет
        s.delete_question(0); //идет проверка на ошибки
        s.change_question(0, "", ""); //элементов нет, ошибки нет
        s.add_question(a);
        s.add_question(b);
        s.change_question(0, "Кто", "");
        if(s.get_Question(0)!="Кто" || s.get_Answer(0)!="Диана") System.out.println("ERROR, change_question\n");
        s.change_question(1, "", "18");
        if(s.get_Question(1)!="Сколько тебе лет?" || s.get_Answer(1)!="18") System.out.println("ERROR, change_question\n");
        Question c= new Question();
        c= s.get_Class_Question(0);
        if(c.answer!="Диана" && c.question!="Кто") System.out.println("ERROR, get_Class_Question\n");
        s.change_date(10, 2, 2021);
        if(s.yy()!=2021 && s.dd()!=10 && s.mo()!=2) System.out.println("ERROR, change_date\n");
        System.out.println("Тесты окончены.\n");
    }
}
