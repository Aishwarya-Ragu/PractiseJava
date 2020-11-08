package walmart;

interface GPI
{
    // default method
    default void show()
    {
        System.out.println("Default GPI");
    }
}

interface PI1 extends GPI {
    default void show()
    {
        System.out.println("Default PI");
    }

}

interface PI2 extends GPI {
    default void show()
    {
        GPI.super.show();
        System.out.println("Default PI2");
    }
}

// Implementation class code
class TestClass implements PI1, PI2
{
    public static void main(String args[])
    {
        TestClass d = new TestClass();
        d.show();
    }


    @Override
    public void show() {
        PI1.super.show();
        PI2.super.show();

    }
}
