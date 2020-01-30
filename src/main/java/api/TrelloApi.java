package api;

import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {

    @POST( "1/boards/" )
    Call<Board> createBoard(@Body Board board);

    @PUT( "1/boards/{id}" )
    Call<Board> updateBoard(@Body Board board, @Path( "id" ) String id);

    @GET( "1/boards/{id}" )
    Call<Board> getBoard(@Path( "id" ) String id, @Query( "key" ) String key,
                         @Query( "token" ) String token);

    @DELETE( "1/boards/{id}" )
    Call<Board> deleteBoard(@Path( "id" ) String id, @Query( "key" ) String key,
                            @Query( "token" ) String token);

    @POST( "1/lists/" )
    Call<Lists> createList(@Body Lists lists);

    @POST( "1/cards/" )
    Call<Cards> createCard(@Body Cards cards);

    @PUT( "1/cards/{id}" )
    Call<Cards> updateCardById(@Body Cards cards, @Path( "id" ) String id);

    @GET( "1/cards/{id}" )
    Call<Cards> getCardInfoById(@Path( "id" ) String id, @Query( "key" ) String key,
                                @Query( "token" ) String token);

    @DELETE( "1/cards/{id}" )
    Call<Cards> deleteCardById(@Path( "id" ) String id, @Query( "key" ) String key,
                               @Query( "token" ) String token);
}