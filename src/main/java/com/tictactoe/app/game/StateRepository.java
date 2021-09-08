package com.tictactoe.app.game;

import com.tictactoe.app.game.entity.State;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StateRepository {
    private final JdbcTemplate jdbcTemplate;

    public Optional<State> findStateById(Long id) {
        String findById = "SELECT * FROM state WHERE id=" + id;
        return jdbcTemplate.query(findById, resultSet -> {
            if (resultSet.next()) {
                State state = new State();
                state.setId(id);
                state.setDescription(resultSet.getString("description"));
                state.setRequiredTurn(resultSet.getString("required_turn"));
                return Optional.of(state);
            }
            return Optional.empty();
        });
    }

    public Optional<State> findStateByDescription(String description) {
        String findById = "SELECT * FROM state WHERE description='" + description + "'";
        return jdbcTemplate.query(findById, resultSet -> {
            if (resultSet.next()) {
                State state = new State();
                state.setId(resultSet.getLong(1));
                state.setDescription(resultSet.getString("description"));
                state.setRequiredTurn(resultSet.getString("required_turn"));
                return Optional.of(state);
            }
            return Optional.empty();
        });
    }
}
