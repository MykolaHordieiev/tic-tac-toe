package com.tictactoe.app.game;

import com.tictactoe.app.game.entity.WinningCombination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WinningCombinationService {
    private final WinningCombinationRepository repository;

    public List<WinningCombination> getAllWinningCombination() {
        return repository.findAll();
    }

}
