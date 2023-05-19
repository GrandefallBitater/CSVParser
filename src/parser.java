import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class parser {

    private static final String CSVPath = "./IO/movementList.csv";


    public static void parseCompany(ArrayList<offer> listOfcompany){
        //открываем файл
        File CSV = new File(CSVPath);
        Scanner CSVScanner;
        try {
            CSVScanner = new Scanner(CSV);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            throw new RuntimeException(e);
        }


        //
        CSVScanner.nextLine();
        while(CSVScanner.hasNextLine()){
            String Line = CSVScanner.nextLine();
            String[] arr = Line.split("," ,7);

            //добавление счёта в список
            String number_Of_fer = arr[1];
            offer numberOfOffer = new offer(number_Of_fer);
            listOfcompany.add(numberOfOffer);
            int index = listOfcompany.indexOf(numberOfOffer);
            offer offer = listOfcompany.get(index);


            offer.setNameOfOffer(arr[0]);
            offer.setCurrency(arr[2]);
            offer.setDateOffer(arr[3]);
            offer.setRef(arr[4]);
            offer.setDescription(arr[5]);

            String[] doubleArray = DoubleParsing(arr[6]);


            String Income = DoubleCheck(doubleArray[0]);

            offer.setInput(Double.parseDouble(Income));



            String Purchise = DoubleCheck(doubleArray[1]);

            Purchise = Purchise.replaceAll(",", ".");
            offer.setOutput(Double.parseDouble(Purchise));

//            String InputString = arr[6];
//            InputString = DoubleCheck(InputString);
//            offer.setInput(Double.parseDouble(InputString));

//            String OutputString = arr[7];
//            OutputString = DoubleCheck(OutputString);
//            offer.setOutput(Double.parseDouble(OutputString));
        }


    }

    private static String[] DoubleParsing(String name) {
        char[] chars = name.toCharArray();
        Integer countPoint = 0;
        for (char ch: chars) {
            if((ch == ',')){
                countPoint++;
            }
        }
        String[] arr = new String[chars.length];
        if(countPoint == 1){
            arr = name.split(",");
            return arr;
        }else if(countPoint == 3){
            arr = name.split(",\"\"");
            return arr;
        }else{
            if(chars[0] == '\"'){
                arr = name.split("\",");
                return arr;
            }
            if(isDigit(chars[0])){
                arr = name.split(",\"");
                return arr;
            }
        }

        return arr;
    }

    public static void report(ArrayList<offer> listOfOffers){

        ArrayList<offer> listOfIncome = new ArrayList<>();
        ArrayList<offer> listOfPurchases = new ArrayList<>();
        String DName;


        for (offer of:
             listOfOffers) {
            String description = of.getDescription();
            description = description.replaceAll(" +", " ");
            String[] arr = description.split(" ");

            if(of.getInput() > 0){
                DName = arr[1];
                listOfIncome.add(new offer(DName, of.getInput(), true));
            }else if(of.getOutput() > 0){
                DName = arr[1];
                listOfPurchases.add(new offer(DName, of.getOutput()));
            }else{
                System.out.println("проверьте платежи");
                return;
            }
        }
        printReport(listOfIncome, listOfPurchases);
    }

    private static void printReport(ArrayList<offer> listOfIncome, ArrayList<offer> listOfPurchases) {
        Double Income = 0.0;
        Double Purchase = 0.0;
        String IncomeString = "";
        String PurchaseString = "";

        //сумма доходов
        for (offer IncomeOffer:
             listOfIncome) {
            Income += IncomeOffer.getInput();
            IncomeString += "\n" + IncomeOffer.getDescription() + "   " + IncomeOffer.getInput();
        }
        //сумма расходов
        for (offer PurchiseOffer:
                listOfPurchases) {
            Purchase += PurchiseOffer.getOutput();
            PurchaseString += "\n" + PurchiseOffer.getDescription() + "   " + PurchiseOffer.getOutput();
        }


        System.out.println("\nсумма расходов: " + Purchase);
        System.out.println("\nсумма доходов: " + Income);

        System.out.println("суммы доходов по арганизациям");
        System.out.println(IncomeString);
        System.out.println("суммы расходов по арганизациям");
        System.out.println(PurchaseString);
    }

    private static String DoubleCheck(String number){
        String newDouble = "";

        char[] chars = number.toCharArray();


        for (char ch: chars) {
            if((ch == ',') || (isDigit(ch))){
                newDouble += ch;
            }
        }
        System.out.println(newDouble);
        return newDouble;
    }
}
