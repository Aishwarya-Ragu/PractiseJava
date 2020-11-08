public class Inheritance {
    public static void main(String[] args) {
        parent p = new child();
    }
}

class parent{
    int a;
    parent(){
        System.out.println("Parent");
    }
}

class child extends parent{
 child(){
     System.out.println("child");
 }
}
