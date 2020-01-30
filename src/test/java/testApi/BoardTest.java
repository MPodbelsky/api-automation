package testApi;

import api.Actions;
import api.Board;
import api.RetrofitBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BoardTest {

    private Actions actions;
    private Board board;
    private Board boardOnTrello;

    @Test( priority = 1 )
    public void checkUserCanCreateBoard() throws IOException {
        boardOnTrello = actions.createBoardById(board);
        Assert.assertEquals(boardOnTrello.name, board.name);
    }

    @Test( priority = 2 )
    public void updateBoard() throws IOException {
        board.name = "Alice";
        Assert.assertEquals(actions.updateBoardById(board, boardOnTrello.id).name
                , board.name);
    }

    @Test( priority = 3 )
    public void getBoard() throws IOException {
        Assert.assertEquals(actions.getBoardById(boardOnTrello.id, board.key, board.token).name,
                "Alice");
    }

    @Test( priority = 4 )
    public void deleteBoard() throws IOException {
        Assert.assertNull(actions.deleteBoardById(boardOnTrello.id, board.key,
                board.token).name);
    }

    @BeforeClass
    private void beforeTest() {
        actions = new Actions(new RetrofitBuilder());
        board = new Board();
        board.name = "NEW-BOARD";
    }
}