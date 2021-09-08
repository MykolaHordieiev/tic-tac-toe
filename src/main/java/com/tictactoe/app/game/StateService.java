package com.tictactoe.app.game;

import com.tictactoe.app.game.entity.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;

    @Transactional(readOnly = true)
    public State getStateById(Long id) {
        return stateRepository.findStateById(id)
                .orElseThrow(() -> new RuntimeException("state by id not find"));
    }

    @Transactional(readOnly = true)
    public State getStateByDescription(String description) {
        return stateRepository.findStateByDescription(description)
                .orElseThrow(() -> new RuntimeException("state by description not find"));
    }
}
