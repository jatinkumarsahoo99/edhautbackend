package com.edhaut.mysql.entity;

public class ChoiceDTO {
	 private String choiceText;
	    private boolean correct;
		public String getChoiceText() {
			return choiceText;
		}
		public void setChoiceText(String choiceText) {
			this.choiceText = choiceText;
		}
		public boolean isCorrect() {
			return correct;
		}
		public void setCorrect(boolean correct) {
			this.correct = correct;
		}
}
