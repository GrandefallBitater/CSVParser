import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //создаём список компаний, которые буду в файле
        ArrayList<offer> listOfOffers = new ArrayList<>();

        //вызывыаем функцию парсера, закидывая компании в список
        parser.parseCompany(listOfOffers);

        //выводим результат
//        for (offer o:
//                listOfOffers) {
//            System.out.println(o.toString());
//        }


        //составление отчёта
        parser.report(listOfOffers);


    }
}