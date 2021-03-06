
public class TestSimpleGeometricObject {

	public static void main(String[] args) {
		CircleFromSimpleGeometricObject circle = new CircleFromSimpleGeometricObject(1);
		System.out.println("A circle " + circle.toString());
		System.out.println("The color is " + circle.getColor());
		System.out.println("The radius is " + circle.getRadius());
		System.out.println("The area is " + circle.getArea());
		System.out.println("The perimeter is " + circle.getPerimeter());
		System.out.println("The diameter is " + circle.getDiameter());
		
		RectangleFromSimpleGeometricObject rectangle = new RectangleFromSimpleGeometricObject(2, 4);
		System.out.println("\nA rectangle: " + rectangle.toString());
		System.out.println("The area is : " + rectangle.getArea());
		System.out.println("The perimeter is: " + rectangle.getPerimeter());
		
		// polymorphism
		System.out.println(circle instanceof CircleFromSimpleGeometricObject); // true
		System.out.println(circle instanceof SimpleGeometricObject); // true
		
		SimpleGeometricObject rectangle1 = new RectangleFromSimpleGeometricObject(4, 5, "black", true);
		
		System.out.println("\nA new rectangle: " + rectangle1);
		System.out.println("The area is : " + ((RectangleFromSimpleGeometricObject) rectangle1).getArea());
		System.out.println("The perimeter is: " + ((RectangleFromSimpleGeometricObject) rectangle1).getPerimeter());
		
	}

}
