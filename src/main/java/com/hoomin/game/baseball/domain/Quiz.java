package com.hoomin.game.baseball.domain;

/**
 * 숫자 야구에 한 문제 단위
 */
public class Quiz {
	private static final int THREE_COUNT = 3;
	private final Numbers rightNumbers;
	private QuizState quizState;

	public Quiz(Numbers rightNumbers) {
		this.rightNumbers = rightNumbers;
		this.quizState = QuizState.UNSOLVED;
	}

	public boolean isUnSolved() {
		return quizState == QuizState.UNSOLVED;
	}

	public Hints checkNumbers(Numbers inputNumbers) {
		final Hints hints = rightNumbers.compareTo(inputNumbers);
		if (isSolved(hints)) {
			this.quizState = QuizState.SOLVED;
		}
		return hints;
	}

	private boolean isSolved(Hints hints) {
		return hints.getStrikeCount() == THREE_COUNT;
	}

	enum QuizState {
		SOLVED, UNSOLVED
	}
}
