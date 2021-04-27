package com.hoomin.game.baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.hoomin.game.baseball.enums.GameOption;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseBallGameTest {

	@ParameterizedTest
	@ValueSource(strings = {"RESTART"})
	public void isOnGoing_RevivedRESTART_ReturnTrue(String input) {
		assertTrue(GameOption.valueOf(input).isOnGoing());
	}

	@ParameterizedTest
	@ValueSource(strings = {"QUIT"})
	public void isOnGoing_RevivedQUIT_ReturnFalse(String input) {
		assertFalse(GameOption.valueOf(input).isOnGoing());
	}

	@ParameterizedTest
	@ValueSource(strings = {"TEST"})
	public void isOnGoing_InvalidInput_IllegalArgumentExceptionThrown(String input) {
		assertThatThrownBy(() -> GameOption.valueOf(input).isOnGoing())
			.isInstanceOf(IllegalArgumentException.class);
	}
}
