package testApi;

import api.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CardTest {

    private Actions actions;
    private Cards cards;
    private Cards cardsOnTheList;

    @Test( priority = 1 )
    public void checkCreatingCards() throws IOException {
        cardsOnTheList = actions.createNewCard(cards);
        Assert.assertEquals(cardsOnTheList.name, cards.name);
    }

    @Test( priority = 2 )
    public void checkThatCardUpDated() throws IOException {
        cards.name = "NEW TEST CARD";
        Assert.assertEquals(actions.updateCardById(cards, cardsOnTheList.id).name,
                cards.name);
    }

    @Test( priority = 3 )
    public void checkCardNameById() throws IOException {
        Assert.assertEquals(actions.getCardInfoById(cardsOnTheList.id, cards.key, cards.token).name,
                "NEW TEST CARD");
    }

    @Test( priority = 4 )
    public void deleteCardById() throws IOException {
        Assert.assertNull(actions.deleteCardById(cardsOnTheList.id, cards.key, cards.token).name);
    }

    @BeforeClass
    private void prepareData() throws IOException {
        actions = new Actions(new RetrofitBuilder());
        cards = new Cards();
        cards.idList = getListId();
        cards.name = "Test";
    }

    private String getListId() throws IOException {
        Lists lists = new Lists();
        lists.name = "cardTest";
        lists.idBoard = getBoardId();
        return actions.createNewList(lists).id;
    }

    private String getBoardId() throws IOException {
        Board board = new Board();
        return actions.getBoardById("ddBlYlVV", board.key, board.token).id;
    }
}
