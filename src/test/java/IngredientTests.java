import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTests {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ингредиент {1} типа {0} за {2} денег")
    public static Object[][] getParameters() {
        return new Object[][] {
                {IngredientType.FILLING, "hot sauce", 100.0F},
                {IngredientType.FILLING, "sour cream", 200.0F},
                {IngredientType.FILLING, "chili sauce", 300.0F},
                {IngredientType.SAUCE, "cutlet", 100.0F},
                {IngredientType.SAUCE, "dinosaur", 200.0F},
                {IngredientType.SAUCE, "sausage", 300.0F},
        };
    }

    @Test
    public void getPriceTest_CorrectPriceReturned() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals("Цена ингредиента должна быть равна " + price, price, actualPrice, 0);
    }

    @Test
    public void getNameTest_CorrectNameReturned() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertEquals("Имя ингредиента должно быть равно " + name, name, actualName);
    }

    @Test
    public void getIngredientTypeTest_CorrectTypeReturned() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals("Тип ингредиента должен быть равен " + type, type, actualType);
    }
}