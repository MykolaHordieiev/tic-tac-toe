package com.tictactoe.app.game;

import com.tictactoe.app.game.entity.WinningCombination;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class WinningCombinationRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<WinningCombination> findAll() {
        String findAll = "SELECT * FROM winning_combination";
        return jdbcTemplate.query(findAll, resultSet -> {
            List<WinningCombination> combinationList = new ArrayList<>();
            while (resultSet.next()) {
                WinningCombination combination = new WinningCombination();
                combination.setFirstFieldNumber(resultSet.getInt("first_field_number"));
                combination.setSecondFieldNumber(resultSet.getInt("second_field_number"));
                combination.setThirdFieldNumber(resultSet.getInt("third_field_number"));
                combinationList.add(combination);
            }
            return combinationList;
        });
    }
}
