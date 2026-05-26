package P6_Request_And_Response_Specification;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgAnnotations
{

    @AfterClass
    public void m2()
    {
        System.out.println("----running after class----");
    }

    @BeforeClass
    public void m1()
    {
        System.out.println("----running before class----");
    }

    @Test
    public void TC1()
    {
        System.out.println("running TC1");
    }

    @Test
    public void TC2()
    {
        System.out.println("running TC2");
    }

    @Test
    public void TC3()
    {
        System.out.println("running TC3");
    }





}
