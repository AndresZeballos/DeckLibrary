package com.decks.exceptions;

public class CardNotInDeckException extends Exception {

	private static final long serialVersionUID = -2389152578886169739L;

	public CardNotInDeckException() {
		// TODO Auto-generated constructor stub
	}

	public CardNotInDeckException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CardNotInDeckException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CardNotInDeckException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CardNotInDeckException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
