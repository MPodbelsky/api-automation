package api;

import java.io.IOException;

public class Actions {

    TrelloApi trelloApi;

    public Actions(final RetrofitBuilder retrofitBuilder) {
        trelloApi = retrofitBuilder.call();
    }

    public Board createBoardById(Board board) throws IOException {
        return trelloApi.createBoard(board).execute().body();
    }

    public Board updateBoardById(Board board, String boardId) throws IOException {
        return trelloApi.updateBoard(board, boardId).execute().body();
    }

    public Board getBoardById(String id, String key, String token) throws IOException {
        return trelloApi.getBoard(id, key, token).execute().body();
    }

    public Board deleteBoardById(String id, String key,
                                 String token) throws IOException {
        return trelloApi.deleteBoard(id, key, token).execute().body();
    }

    public Lists createNewList(Lists lists) throws IOException {
        return trelloApi.createList(lists).execute().body();
    }

    public Cards createNewCard(Cards cards) throws IOException {
        return trelloApi.createCard(cards).execute().body();
    }

    public Cards updateCardById(Cards cards, String id) throws IOException {
        return trelloApi.updateCardById(cards, id).execute().body();
    }

    public Cards getCardInfoById(String id, String key, String token) throws IOException {
        return trelloApi.getCardInfoById(id, key, token).execute().body();
    }

    public Cards deleteCardById(String id, String key, String token) throws IOException {
        return trelloApi.deleteCardById(id, key, token).execute().body();
    }
}