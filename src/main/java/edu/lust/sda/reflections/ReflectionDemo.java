package edu.lust.sda.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    /**
     * Refleksja pozwala podglądać definicję klas w trakcie działania programu
     * Pozwala też uzależnić działanie programu od tego jaka klasa go wykonuje
     * Dodatkowo pozwala modyfikować działanie klas, metod już w trakcie działania
     * */
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("edu.lust.sda.reflections.StudentRef");

            System.out.println("Sprawdzamy metody klasy studentRef");
            Method[] classMetchods = studentClass.getDeclaredMethods();
            for (Method classMethod : classMetchods){
                System.out.println(classMethod);
            }

            System.out.println("========================");
            System.out.println("Sprawdzamy metody klasy StudentRef i jej przodków");
            Method[] allMethods = studentClass.getMethods();
            for (Method method : allMethods) {
                System.out.println(method);
            }
            Field[] classFields = studentClass.getDeclaredFields();
            for (Field field : classFields) {
                System.out.println(field);
            }

            Field[] allFields = studentClass.getFields();
            for (Field field : allFields) {
                System.out.println(field);
            }

            StudentRef studentRef =(StudentRef) studentClass.getDeclaredConstructor().newInstance();
            Method setNameMethod = studentClass.getDeclaredMethod("setName", String.class);
            Method getNameMethod = studentClass.getDeclaredMethod("getName");
            setNameMethod.invoke(studentRef,"Mariola");
            System.out.println(getNameMethod.invoke(studentRef));


            System.out.println("Powołany refleksyjnie, ale jest do niego dostęp, bo to normalny obiekt");
//            studentRef.setSurname() ;
//            Method getAllUniversityInfoMethod = studentClass.getDeclaredMethod("getAllUniversityInfo");
//            System.out.println(getAllUniversityInfoMethod.invoke(studentRef));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
