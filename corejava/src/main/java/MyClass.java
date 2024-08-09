interface I1{
	default void add() {
		System.out.println("i am default method of interface I1");
	}
}
interface I2{
	default void add() {
		System.out.println("i am default method of interface I1");
	}
}
public class MyClass implements I1,I2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
