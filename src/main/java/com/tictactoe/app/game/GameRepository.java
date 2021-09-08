package com.tictactoe.app.game;

import com.tictactoe.app.game.configGame.ConfigGame;
import com.tictactoe.app.game.entity.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class GameRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ConfigGame configGame;

    public Long saveGame(Game game) {
        String insertGame = "INSERT INTO game (player1,player2,state,board,playing) VALUES (?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertGame, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getPlayer1().toString());
            ps.setString(2, game.getPlayer2().toString());
            ps.setString(3, game.getState().getDescription());
            ps.setString(4, game.getBoard().toString());
            ps.setBoolean(5, game.getIsPlaying());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public Optional<Game> getGameById(Long gameId) {
        String getPerson = "SELECT * FROM game WHERE game.id=" + gameId;
        return jdbcTemplate.query(getPerson, resultSet -> {
            if (resultSet.next()) {
                String player1 = resultSet.getString("player1");
                String player2 = resultSet.getString("player2");
                String board = resultSet.getString("board");
                String state = resultSet.getString("state");
                boolean playing = resultSet.getBoolean("playing");
                Game gameFromDB = configGame.getGameFromDB(player1, player2, board, state, playing);
                gameFromDB.setId(gameId);
                return Optional.of(gameFromDB);
            }
            return Optional.empty();
        });
    }

    public Game updateGame(Game updateGame) {
        String update = "UPDATE game SET player1=?,player2=?,state=?,board=?,playing=? where id="
                + updateGame.getId();
        jdbcTemplate.update(update
                , ps -> {
                    ps.setString(1, updateGame.getPlayer1().toString());
                    ps.setString(2, updateGame.getPlayer2().toString());
                    ps.setString(3, updateGame.getState().getDescription());
                    ps.setString(4, updateGame.getBoard().toString());
                    ps.setBoolean(5, updateGame.getIsPlaying());
                });
        return updateGame;
    }
}
