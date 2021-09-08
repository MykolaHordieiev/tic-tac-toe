package com.tictactoe.app.game.service;

import com.tictactoe.app.game.entity.WinningCombination;
import com.tictactoe.app.game.repository.WinningCombinationRepository;
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
