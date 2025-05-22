import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    public Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient0;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void makeBurger() {
        burger = new Burger();
    }

    // **setBunsTest**
    @Test
    public void setBunsTest_SetsBunCorrectly() {
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("Название булочки");
        assertEquals("Установлена не верная булочка", "Название булочки", burger.bun.getName());
    }

    // **addIngredientTest**
    @Test
    public void addIngredientTest_AddsIngredientToList() {
        burger.addIngredient(ingredient0);
        assertEquals("Список ингредиентов должен содержать 1 элемент", 1, burger.ingredients.size());
    }

    @Test
    public void addIngredientTest_IngredientIsAdded() {
        burger.addIngredient(ingredient0);
        assertTrue("Ингредиент не был добавлен в бургер", burger.ingredients.contains(ingredient0));
    }

    // **removeIngredientTest**
    @Test
    public void removeIngredientTest_RemovesIngredientCorrectly() {
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.removeIngredient(1);
        assertEquals("После удаления ингредиента список должен содержать 2 элемента", 2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest_CorrectIngredientsRemain() {
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.removeIngredient(1);
        assertTrue("После удаления должен остаться только ingredient0 и ingredient2",
                burger.ingredients.contains(ingredient0) && burger.ingredients.contains(ingredient2) && !burger.ingredients.contains(ingredient1));
    }

    // **moveIngredientTest**
    @Test
    public void moveIngredientTest_MovesIngredientCorrectly() {
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals("В бургере должно быть 3 ингредиента", 3, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest_IngredientMovedToCorrectPosition() {
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals("Ингредиент 1 должен быть на позиции 0", burger.ingredients.get(0), ingredient1);
        assertEquals("Ингредиент 0 должен быть на позиции 1", burger.ingredients.get(1), ingredient0);
    }

    // **getPriceTest**
    @Test
    public void getPriceTest_CalculatesPriceCorrectly() {
        burger.bun = bun;
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        when(bun.getPrice()).thenReturn(50.0F);
        when(ingredient0.getPrice()).thenReturn(20.0F);
        when(ingredient1.getPrice()).thenReturn(25.0F);
        when(ingredient2.getPrice()).thenReturn(5.0F);
        float expectedPrice = 150.0F;
        assertEquals("Неверная итоговая цена", expectedPrice, burger.getPrice(), 0);
    }

    // **getReceiptTest**
    @Test
    public void getReceiptTest_GeneratesCorrectReceipt() {
        burger.bun = bun;
        burger.ingredients.add(ingredient0);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        when(bun.getName()).thenReturn("bun");
        when(ingredient0.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient0.getName()).thenReturn("ingredient0");
        when(ingredient1.getName()).thenReturn("ingredient1");
        when(ingredient2.getName()).thenReturn("ingredient2");
        when(bun.getPrice()).thenReturn(50.0F);
        when(ingredient0.getPrice()).thenReturn(20.0F);
        when(ingredient1.getPrice()).thenReturn(25.0F);
        when(ingredient2.getPrice()).thenReturn(5.0F);

        String expectedReceipt = "(==== bun ====)\r\n" +
                "= filling ingredient0 =\r\n" +
                "= filling ingredient1 =\r\n" +
                "= sauce ingredient2 =\r\n" +
                "(==== bun ====)\r\n" +
                "\r\n" +
                "Price: 150,000000\r\n";
        assertEquals("Неверный чек", expectedReceipt, burger.getReceipt());
    }
}