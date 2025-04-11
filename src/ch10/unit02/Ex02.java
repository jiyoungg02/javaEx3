package ch10.unit02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		String className = "ch10.unit02.User";
		
		try {
			Class<?> cls = Class.forName(className);
			
			System.out.println("Modifiers...");
			System.out.println(cls.getModifiers()); // 1: public
			System.out.println(Modifier.toString(cls.getModifiers()));
			
			System.out.println("\nSuper class...");
			System.out.println(cls.getSuperclass().getName());
			
			System.out.println("\n생성자...");
			for(Constructor<?> c : cls.getConstructors()) {
				System.out.println(c);
			}
			
			System.out.println("\n필드(private 포함)...");
			Field[] ff = cls.getDeclaredFields();
			// Field[] ff = cls.getFields(); // public 만
			for(Field f : ff) {
				System.out.println(f);
			}
			
			System.out.println("\n메소드(public)...");
			Method[] mm = cls.getMethods();
			for(Method m : mm) {
				System.out.println(m);
				Class<?> c = m.getReturnType();
				Parameter[] pp = m.getParameters();
				// Class<?>[] ps = m.getParameterTypes();
				System.out.println(c.getTypeName() + " : " + Arrays.toString(pp));
				System.out.println("-------------------------------");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
