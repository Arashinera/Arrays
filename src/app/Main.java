package app;

import java.util.Scanner;
import java.util.Locale;

//Протягом певного періоду часу здійснювались закупівлі
//товарів. Закупівельний набір містить найменування
//товарів (як різних, так і однакових).
//Реалізуйте функціонал, який виводить нумерований
//перелік найменувань цих товарів, а також дає змогу
//пошуку певного найменування товару в цьому переліку.

public class Main {

    //Створюємо змінні класу :
    static String[] productNames;
    static int dayNumbers;
    static int quota;
    static int count;
    static int productCount;
    static String productSearch;

    public static void main(String[] args) {

        //Налаштовуємо сканер та локейл :
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        //Вводимо значення :
        System.out.println("Input the number of days you sold the product : ");
        dayNumbers = input.nextInt();
        System.out.println("Input number of sold product : ");
        quota = input.nextInt();

        //Фіксимо сканер :
        input.nextLine();

        //Налаштовуємо межі масиву :
        productNames = new String[quota];

        //Налаштовуємо лічильник :
        count = 0;

        //Заповнюємо масив даними :
        System.out.println("Insert product names : ");
        for (int i = 0; i < quota; i++){
            productNames[i] = input.nextLine();
        }

        //Виводимо дані на екран :
        System.out.printf("Product names list for %d days : %n", dayNumbers);
        for (int j = 0; j < quota; j++){
            count++;
            System.out.printf("%d) %s%n", count, productNames[j]);
        }

        //Налаштовуємо лічильники :
        count = 0;
        productCount = 0;

        //Вводимо значення :
        System.out.println("Input product name witch you want to find in list : ");
        productSearch = input.nextLine();

        //Проходимось по масиву та шукаємо бажане значення :
        System.out.printf("There are results of searching \"%s\" in list : %n", productSearch);
        for (int i = 0; i < quota; i++){
            count++;
            if (productSearch.equals(productNames[i])){
                productCount++;
                System.out.printf("%d) %s(%d)%n", count, productSearch, productCount);
            }
        }

        //Виводимо відповідне значення якщо співпадінь не знайдено :
        if (productCount == 0){
            System.out.println("no matches... ");
        }

        //Закриваємо сканер :
        input.close();
    }
}
