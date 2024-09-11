package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import java.util.Random;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest {
    private static Random random = new Random();
    private String name;
    private float price;


    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {randomAlphabetic(10), random.nextFloat()},
                {randomAlphabetic(10), 700.000000000F}
        };
    }

    @Test
    public void TestGetName() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals(name, actual);
    }

    @Test
    public void TestGetPrice() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        assertEquals(price, actual, 0);
    }
}
