package foundation.javaFoundation.abstractimpl;

public abstract class Interview {

    public abstract void fail();//只声明，不实现

    public abstract void success();

    public void before() {
        System.out.println("刷题");
    }

    public void after() {
        System.out.println("h1b");
    }
}
