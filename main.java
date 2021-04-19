import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class main {
    public static void main(String args[]){


        {
            Question a=new Question("Кто?", "Я");
            Question b=new Question("Что?", "предмет");
            ArrayList<Question> arr1=new ArrayList<Question>();
            arr1.add(a);
            arr1.add(b);
            Subject sub3=new Subject("Русский язык", arr1);
            PlanToSub pl=new PlanToSub(sub3, 25, 3, 2021);
            Study styd=new Study(pl.sub, pl.todaylearned, pl.get_size_q_today());
        }


        System.out.println("Запуск тестов.\n");
        //Тесты для Date_simple
        {
            System.out.println("Тесты для Date_simple.");
            int mistaker=0;
            Date_simple a=new Date_simple();
            Date_simple b=new Date_simple(5, 5, 2021);
            Date_simple c=new Date_simple(a.day, a.month, b.year+1);
            Calendar aa =new GregorianCalendar();
            if(a.day!=aa.get(Calendar.DATE)|| a.month!=aa.get(Calendar.MONTH) ||a.year!=2021)
            {System.out.println("Ошибка конструктора по умолчанию.");
              mistaker++;
               }

            if(b.day!=5 && b.month!=5 && b.year!=2021) {
                System.out.println("Ошибка конструктора c аргументами.");
                mistaker++;
            }
            if(c.before(a)||a.before(a)) {
                System.out.println("Ошибка метода  before.");
                mistaker++;
            }
            if(c.equally(a)||!(a.equally(a))){
                System.out.println("Ошибка метода  equally.");
                mistaker++;
            }
            if(mistaker==0) System.out.println("Тестирование пройдено успешно.");
            else System.out.println("Тестирование не пройдено.");
        }

        //Тесты для Question
        {
            System.out.println("Тесты для Question.");
            int mistaker=0;
            Question a=new Question();
            Question b=new Question("Ты кто?", "Пользователь.");
            if(!(a.question==""&& a.answer==""&&a.GetDate().before(new Date_simple())&&a.Getknow_answer()==false&&a.get_size_of_view()==0)) {
                System.out.println("Ошибка конструктора по умолчанию.");
                mistaker++;
            }
            if(!(b.question=="Ты кто?"&& b.answer=="Пользователь."&&b.GetDate().before(new Date_simple())&&b.Getknow_answer()==false&&b.get_size_of_view()==0)) {
                System.out.println("Ошибка конструктора c аргументами.");
                mistaker++;
            }
            a.base_click(1);
            if(!(a.GetDate().equally(new Date_simple())&&a.get_size_of_view()==1&&a.Getknow_answer())){
                System.out.println();
                mistaker++;
                System.out.println();
                System.out.println("Ошибка base_click1.");
            }
            a.base_click(1);
            if(!(a.GetDate().equally(new Date_simple())&&a.get_size_of_view()==1&&a.Getknow_answer())){
                mistaker++;
                System.out.println("Ошибка base_click2.");
            }
            a.base_click(0);
            if(!(a.GetDate().equally(new Date_simple())&&a.get_size_of_view()==2&&a.Getknow_answer()==false)){
                mistaker++;
                System.out.println("Ошибка base_click3.");
            }
            if(mistaker==0) System.out.println("Тестирование пройдено успешно.");
            else System.out.println("Тестирование не пройдено.");
        }

        //Тесты для Subject
        {
            System.out.println("Тесты для Subject.");
            int mistaker=0;
            Question a=new Question("Кто?", "Я");
            Question b=new Question("Что?", "предмет");
            ArrayList<Question> arr1=new ArrayList<Question>();
            arr1.add(a);
            arr1.add(b);
            Subject sub1=new Subject();
            Subject sub2=new Subject("Математика");
            Subject sub3=new Subject("Русский язык", arr1);
            if(sub1.get_Class_Question(0).Getknow_answer()){
                mistaker++;
                System.out.println("Ошибка в пямяти.");
            }
            if(!(sub2.name_of_sub=="Математика"&&sub2.get_size_all_quest()==0)){
                mistaker++;
                System.out.println("Ошибка конструктора.");
            }
            if(!(sub3.get_size_all_quest()==2&&sub3.get_size_no_know()==2&&sub3.get_Class_Question(0).question==arr1.get(0).question)){
                mistaker++;
                System.out.println("Ошибка конструктора arraylist.");
            }
            sub2.add_question(a);
            if(!(sub2.get_Class_Question(0).question=="Кто?")){
                mistaker++;
                System.out.println("Ошибка конструктора add_question.");
            }
            sub2.change_question(0, "Какой вид ты представляешь?", "");
            if(!(sub2.get_Class_Question(0).question=="Какой вид ты представляешь?"&&sub2.get_Class_Question(0).answer=="Я")){
                mistaker++;
                System.out.println("Ошибка конструктора change_question.");
            }
            sub2.delete_question(0);
            if(!(sub2.get_size_all_quest()==0)){
                mistaker++;
                System.out.println("Ошибка конструктора delete_question.");
            }
            //---Проверки функций для выдачи вопросов---
            ArrayList<Question> arr2=new ArrayList<Question>();
            arr2.add(new Question("01", "01"));
            arr2.add(new Question("02", "02"));
            arr2.add(new Question("03", "03"));
            arr2.add(new Question("04", "04"));
            arr2.add(new Question("05", "05"));
            arr2.add(new Question("06", "06"));
            arr2.get(0).formaintestNOTOUCH(3, false, new Date_simple(8, 1, 2021));
            arr2.get(1).formaintestNOTOUCH(3, false, new Date_simple(9, 1, 2021));
            arr2.get(2).formaintestNOTOUCH(3, true, new Date_simple(10, 1, 2021));
            arr2.get(3).formaintestNOTOUCH(3, true, new Date_simple(10, 1, 2021));
            arr2.get(4).formaintestNOTOUCH(0, false, new Date_simple(12, 1, 2021));
            arr2.get(5).formaintestNOTOUCH(0, false, new Date_simple(13, 1, 2021));
            Subject quest1=new Subject("Тестирование", arr2);
            ArrayList <Integer> ar_O=new ArrayList<Integer>();
            ar_O.addAll(quest1.O_get_array_new_q(5));
            if(!(ar_O.size()==2&&ar_O.get(0)==4&&ar_O.get(1)==5)){
                mistaker++;
                System.out.println("Ошибка O_get_array_new_q.");
            }
            ar_O.clear();
            Date_simple ds=new Date_simple();
            ds.year++;
            ar_O.addAll(quest1.O_array_oldest(ds));
            if(!(ar_O.size()==2)&& ar_O.get(0)==2 &&ar_O.get(1)==2){
                mistaker++;
                System.out.println("Ошибка O_oldest.");
            }
            ar_O.clear();
            ar_O.addAll(quest1.O_difficult_q(1000));
            if(!(ar_O.size()==2&& ar_O.get(0)==2&& ar_O.get(1)==3)){
                mistaker++;
                System.out.println("Ошибка O_difficult_q.");
            }
            ar_O.clear();
            ar_O.addAll(quest1.O_base_q(10));
            if(!(ar_O.size()==2&& ar_O.get(0)==0&& ar_O.get(1)==1)){
                mistaker++;
                System.out.println("Ошибка O_base_q.");
            }
            if(!(quest1.o_oldest_day().day==10&&quest1.o_oldest_day().month==1&&quest1.o_oldest_day().year==2021)){
                mistaker++;
                System.out.println("Ошибка o_oldest_day.");
            }
            if(!(quest1.max_size_of_view()==3)){
                mistaker++;
                System.out.println("Ошибка max_size_of_view.");
            }
            if(mistaker==0) System.out.println("Тестирование пройдено успешно.");
            else System.out.println("Тестирование не пройдено.");
        }



        //Тесты для Study (для их работы у функций надо убрать private)
        {
            System.out.println("Тесты для Study.");
            int mistaker=0;
            ArrayList<Question> arr2=new ArrayList<Question>();
            arr2.add(new Question("01", "01"));
            arr2.add(new Question("02", "02"));
            arr2.add(new Question("03", "03"));
            arr2.add(new Question("04", "04"));
            arr2.add(new Question("05", "05"));
            arr2.add(new Question("06", "06"));

            arr2.get(0).formaintestNOTOUCH(10, false, new Date_simple(8, 1, 2021));
            arr2.get(1).formaintestNOTOUCH(3, false, new Date_simple(9, 1, 2021));
            arr2.get(2).formaintestNOTOUCH(3, true, new Date_simple(10, 1, 2021));
            arr2.get(3).formaintestNOTOUCH(3, true, new Date_simple(10, 1, 2021));
            arr2.get(4).formaintestNOTOUCH(0, false, new Date_simple(12, 1, 2021));
            arr2.get(5).formaintestNOTOUCH(7, false, new Date_simple(13, 1, 2021));
            Subject sub1=new Subject("Тесты", arr2);
            PlanToSub pts=new PlanToSub(sub1, 10, 4, 2021);
            Study study=new Study(pts.sub, pts.get_size_q_today(), pts.todaylearned);
            System.out.println(pts.sub.get_Class_Question(study.STUDY()).question);
            System.out.println(pts.sub.get_Class_Question(study.STUDY()).question);
            System.out.println(pts.sub.get_Class_Question(study.STUDY()).question);
            System.out.println(pts.sub.get_Class_Question(study.STUDY()).question);
            System.out.println(pts.sub.get_Class_Question(study.STUDY()).question);
            System.out.println(pts.sub.get_Class_Question(study.STUDY()).question);
            if(mistaker!=0){
                mistaker++;
                System.out.println("Ошибка .");
            }




            if(mistaker!=0){
                mistaker++;
                System.out.println("Ошибка .");
            }
            if(mistaker==0) System.out.println("Тестирование пройдено успешно.");
            else System.out.println("Тестирование не пройдено.");
        }

        //Тесты для PlanToSub
        {
            System.out.println("Тесты для PlanToSub.");
            int mistaker=0;
            ArrayList<Question> arr2=new ArrayList<Question>();
            arr2.add(new Question("01", "01"));
            arr2.add(new Question("02", "02"));
            arr2.add(new Question("03", "03"));
            arr2.add(new Question("04", "04"));
            arr2.add(new Question("05", "05"));
            arr2.add(new Question("06", "06"));

            arr2.get(0).formaintestNOTOUCH(10, false, new Date_simple(8, 1, 2021));
            arr2.get(1).formaintestNOTOUCH(3, false, new Date_simple(9, 1, 2021));
            arr2.get(2).formaintestNOTOUCH(3, true, new Date_simple(10, 1, 2021));
            arr2.get(3).formaintestNOTOUCH(3, true, new Date_simple(10, 1, 2021));
            arr2.get(4).formaintestNOTOUCH(0, false, new Date_simple(12, 1, 2021));
            arr2.get(5).formaintestNOTOUCH(7, false, new Date_simple(13, 1, 2021));
            Subject sub1=new Subject("Тесты", arr2);
            PlanToSub pts=new PlanToSub(sub1, 25, 3, 2021);
            if(pts.plan_to_day.size()!=2){
                mistaker++;
                System.out.println("Ошибка add_date_to_study и delete.");
            }
            if(pts.plan_to_day.get(2).size_of_quetion!=1){
                mistaker++;
                System.out.println("Ошибка do_plan.");
            }

            pts.add_date_to_study(3, 3, 2021);
            pts.todaylearned=10;
            pts.today=new Date_simple(3, 3, 2021);
            pts.open_prog();
            if(pts.todaylearned!=0){
                System.out.println("Ошибка open_prog()");
                mistaker++;
            }
            pts.plan_to_day.get(0).size_of_quetion=0;

            if(mistaker==0) System.out.println("Тестирование пройдено успешно.");
            else System.out.println("Тестирование не пройдено.");
            PlanToSub pts1=new PlanToSub(sub1, 25, 3, 2021);
            System.out.println(pts1.size_today_day_of_exams_plan());
            for(int i=0; i<pts1.plan_to_day.size(); i++){
                System.out.println(pts1.plan_to_day.get(i).date.day+"."+pts1.plan_to_day.get(i).date.month+"."+pts1.plan_to_day.get(i).date.year);
            }
        }

        System.out.println();
        System.out.println("Все тесты окончены.\n");
    }

}
