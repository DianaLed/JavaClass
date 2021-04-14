import java.util.ArrayList;

public class Study {
    Subject sub; //предмет передаем ТОЛЬКО из PLAN_TO_SUB
    int nom;
    int plan_learned; //сколько нужно выучить сегодня
    int now_learned; //сколько выучено уже
    ArrayList<Integer> qw;
    Study(Subject s, int plan_learned_today, int now_learn){
        sub=s;
        plan_learned=plan_learned_today;
        now_learned=now_learn;
        qw=new ArrayList<Integer>();
        nom=0;
        set_start_question();
    }
    //-------Формирование_стартового_запаса_вопросов-------
    private void set_most_difficult_n(){
             for(int j=0; j<sub.get_size_all_quest(); j++) {
                 if (!(sub.get_Class_Question(j).Getknow_answer()) && sub.get_Class_Question(j).get_size_of_view() != 0) {
                     qw.add(j);
                 }
                 if(qw.size()==plan_learned-now_learned) break;
             }
    }
    private void set_start_question(){
        int d;
        if(qw.size()<plan_learned-now_learned){
            qw.clear();
            set_most_difficult_n();
            d= plan_learned-now_learned-qw.size();
            if (d>0) qw.addAll(sub.O_get_array_new_q(d));
        }
    }
    //----------Поиск-элемента-----------------------------
    private boolean have_question(int nomer){
        for(int i=0; i< qw.size(); i++){
            if(qw.get(i)==nomer) return true;
        }
        return false;
    }

    //-----Добавление 1го новго вопроса определенного типа
    private void set_one_old_que(){
        int nom1=sub.O_oldest(new Date_simple(100, 100, 11111));
        while(!have_question(nom1)){
            nom1=sub.O_oldest(sub.get_Class_Question(nom1).GetDate());
        }
        qw.add(nom1);
    }
    private void set_one_hard_que(){
        int nom1=sub.O_most_difficult(50000000);
        while(!have_question(nom1)){
            nom1=sub.O_most_difficult(sub.get_Class_Question(nom1).get_size_of_view());
        }
        qw.add(nom1);
    }
    //-----Проверка вопроса (выучен ли он)---
    private void delete_kn_quest(){
            if(sub.get_Class_Question(qw.get(nom)).Getknow_answer()) {
                qw.remove(nom);
                now_learned++;
            }

    }

    //-----Обучение---------


    Question STUDY(){
        delete_kn_quest();
        if(qw.size()<5){
            set_one_old_que();
            set_one_hard_que();
        }
        if(nom<qw.size()+1) nom++; else nom=0;
        return sub.get_Class_Question(qw.get(nom));
    }
}
