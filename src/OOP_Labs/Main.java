package OOP_Labs;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Point3D firstPoint3D=null;  //Создание объекта firstPoint3D
        Point3D secondPoint3D=null; //Создание объекта secondPoint3D
        Point3D thirdPoint3D=null;  //Создание объекта thirdPoint3D

        String[] inputs=GetInput(); //Вызов метода GetInput() для получения координат точки в пространстве
        if(inputs!=null) /*Проверка есть ли в полученном массиве данные*/
        {
            /*Вызов конструктора класса Point3D*/
           firstPoint3D=new Point3D(Integer.parseInt(inputs[0]), //Присвоении Координате Х значения из массива строк inputs[]
                                    Integer.parseInt(inputs[1]), //Присвоении Координате Y значения из массива строк inputs[]
                                    Integer.parseInt(inputs[2])  //Присвоении Координате Z значения из массива строк inputs[]
                                    );

           System.out.println(String.format("Создана точка с координатами: {%.2f; %.2f; %.2f}", ///Вывод сообщения пользователю о создании точки
                                            firstPoint3D.getPointX(), //Получение Х координаты
                                            firstPoint3D.getPointY(), //Получение Y координаты
                                            firstPoint3D.getPointZ()  //Получение Z координаты
                                            ));
        }

        inputs=GetInput(); //Вызов метода GetInput() для получения координат точки в пространстве
        if(inputs!=null) /*Проверка есть ли в полученном массиве данные*/
        {
            /*Вызов конструктора класса Point3D*/
            secondPoint3D=new Point3D(Integer.parseInt(inputs[0]), //Присвоении Координате Х значения из массива строк inputs[]
                                      Integer.parseInt(inputs[1]), //Присвоении Координате Y значения из массива строк inputs[]
                                      Integer.parseInt(inputs[2])  //Присвоении Координате Z значения из массива строк inputs[]
                                     );


            System.out.println(String.format("Создана точка с координатами: {%.2f; %.2f; %.2f}",
                                            secondPoint3D.getPointX(), //Получение Х координаты
                                            secondPoint3D.getPointY(), //Получение Y координаты
                                            secondPoint3D.getPointZ()  //Получение Z координаты
                                            ));
        }

        inputs=GetInput(); //Вызов метода GetInput() для получения координат точки в пространстве
        if(inputs!=null) /*Проверка есть ли в полученном массиве данные*/
        {
            /*Вызов конструктора класса Point3D*/
            thirdPoint3D=new Point3D(Integer.parseInt(inputs[0]), //Присвоении Координате Х значения из массива строк inputs[]
                                     Integer.parseInt(inputs[1]), //Присвоении Координате Y значения из массива строк inputs[]
                                     Integer.parseInt(inputs[2])  //Присвоении Координате Z значения из массива строк inputs[]
                                    );

            System.out.println(String.format("Создана точка с координатами: {%.2f; %.2f; %.2f}" , ///Вывод сообщения пользователю о создании точки
                                            thirdPoint3D.getPointX(),//Получение Х координаты
                                            thirdPoint3D.getPointY(),//Получение У координаты
                                            thirdPoint3D.getPointZ()//Получение Z координаты
                                            ));
        }

        System.out.println(String.format("Площадь треугольника равна: %.2f",
                                        computeArea(firstPoint3D, secondPoint3D, thirdPoint3D))); /* Рассчет площади треугольника и вывод результата на экран*/
    }
    public static String[] GetInput() /* Метод обработки ввода с клавиатуры */
    {

        Scanner scanner=new Scanner(System.in); //Объявление сканнера

        String[] inputs=null; //Создание массива их строк

        System.out.println("Введите координаты точки в пространстве: "); //Вывод сообщения пользователю

        if(scanner.hasNextLine()) //Проверка есть ли в потоке ввода строка
        {
            String tmp = scanner.nextLine(); //Считывание строки из потока ввода

            inputs=tmp.split(" ");//Разбиение строки на массив строк по пробелу
        }
        return inputs; //Возвращение массива строк. Формат возврата: ["X","Y","Z"]
    }

    public static double computeArea(Point3D firstPoint, Point3D secondPoint, Point3D thirdPoint) /*Метод для рассчета площади треугольника */
    {
        ///Рассчет сторон треугольника
            double cadetA =firstPoint.getDistance(secondPoint);
            double cadetB =secondPoint.getDistance(thirdPoint);
            double hypotenuse =thirdPoint.getDistance(firstPoint);
            double halfPerimeter=(cadetA + cadetB + hypotenuse)/2;
        ///

        ///Расчет площади треугольника по теореме Гаусса
            return Math.sqrt(halfPerimeter * (halfPerimeter-cadetA) * (halfPerimeter-cadetB) * (halfPerimeter-hypotenuse));
        ///


    }

}
