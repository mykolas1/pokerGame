package com.poker.saiGlobal.controller;

import com.poker.saiGlobal.kernel.PlayPokerKernel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Controller to test poker game.
 */
@Controller
@RequiredArgsConstructor
@Validated
public class PokerController {

    private final PlayPokerKernel playPokerKernel;

    /**
     * End point controller to test poker game.
     * @param playerSize players size which must be from 2 to 10.
     */
    @GetMapping(value = "/play/poker/size/{playerSize}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String>  playPoker(@PathVariable @Max(10) @Min(2) int playerSize) {
        return new ResponseEntity<>(playPokerKernel.playPoker(playerSize), HttpStatus.OK);
    }

    /**
     * End point for error handler.
     * @param e
     * @return Returns 400 Bad Request with error message.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("ERROR: Player size is not valid. Size must be from 2 to 10.", HttpStatus.BAD_REQUEST);
    }
}
