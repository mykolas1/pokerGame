package com.poker.saiGlobal.component.controller;

import com.poker.saiGlobal.controller.PokerController;
import com.poker.saiGlobal.kernel.PlayPokerKernel;
import com.poker.saiGlobal.kernel.PlayPokerKernelImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokerControllerTest {

    @InjectMocks
    private PokerController pokerController;

    @Mock private PlayPokerKernel playPokerKernel;

    @Test
    public void playPoker_Test () {
        when(playPokerKernel.playPoker(3)).thenReturn("1");
        ResponseEntity<String> result = pokerController.playPoker(3);
        assertEquals("<200 OK OK,1,[]>", result.toString());
    }

}
