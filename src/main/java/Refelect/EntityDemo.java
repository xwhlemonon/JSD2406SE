package Refelect;

import java.lang.reflect.Field;

public class EntityDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<RectangleDemo> cls = RectangleDemo.class;
        Field fis = cls.getDeclaredField("length");
        Length length = fis.getAnnotation(Length.class);
        int idValue = length.value();
        fis.setAccessible(true);
        RectangleDemo rd = new RectangleDemo(10, 10);
        fis.set(rd, idValue);
        System.out.println(fis.get(rd));
    }
}
