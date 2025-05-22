import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {
    private String name;
    private float price;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{0} - проверка имени")
    public static Object[][] getNameParameters() {
        return new Object[][] {
                {"black bun", "black bun"},
                {"white bun", "white bun"},
                {"red bun", "red bun"}
        };
    }

    @Parameterized.Parameters(name = "{0} - проверка цены")
    public static Object[][] getPriceParameters() {
        return new Object[][] {
                {"black bun", 100.0f},
                {"white bun", 200.0f},
                {"red bun", 300.0f}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals("Неверное имя булочки", name, actualName);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertEquals("Неверная цена булочки", price, actualPrice, 0);
    }
}