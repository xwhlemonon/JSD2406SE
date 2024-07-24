package Refelect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Target(ElementType.TYPE)
@interface Entity {
    String value();
}

@Target({ElementType.FIELD, ElementType.METHOD})
@interface ID {
    String value();
}

@Target(ElementType.METHOD)
@interface Table {
    String value();
}

@Entity("user")
public class ClassDemo01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<RectangleDemo> rectangleDemoClass = RectangleDemo.class;
        Constructor<RectangleDemo> constructor = rectangleDemoClass.getConstructor(int.class, int.class);
        RectangleDemo rectangleDemo = constructor.newInstance(10, 10);
        int perimeter = rectangleDemo.getPerimeter();
        int area = rectangleDemo.getArea();
        System.out.println(perimeter);
        System.out.println(area);

        Field f1 = rectangleDemoClass.getDeclaredField("length");
        f1.setAccessible(true);
        f1.set(rectangleDemo, 50);
        int perimeter1 = rectangleDemo.getPerimeter();
        System.out.println(perimeter1);

        List<String> li = new ArrayList<>();
        li.add("100");
        System.out.println(li);

        Class<List> cl = List.class;
        Method method = cl.getDeclaredMethod("add", Object.class);
        method.invoke(li, 200);
        System.out.println(li);
    }
}
