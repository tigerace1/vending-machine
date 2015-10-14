package Cars;

public class test {
 public static void main(String[] args)
 {
   CarLL car = new CarLL();
   car.addLast("ss","d");
   car.addLast("aa","d");
   car.addLast("dd","d");
   car.addLast("ff","s");
   System.out.println(car.toString());
   System.out.println("Remove: "+car.remove());
   System.out.println("Remove: "+car.remove());
   System.out.println("Remove: "+car.remove());
   System.out.println("Remove: "+car.remove());
   System.out.println("Remove: "+car.remove());
   System.out.println(car.isEmpty());
 }
}
