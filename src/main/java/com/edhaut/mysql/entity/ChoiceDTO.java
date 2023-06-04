package com.edhaut.mysql.entity;

public class ChoiceDTO {
	 private String choiceText;
	    private boolean correct;
	    private String correctChoiceNo;
	    private String slNo;
		public String getCorrectChoiceNo() {
			return correctChoiceNo;
		}
		public String getSlNo() {
			return slNo;
		}
		public void setSlNo(String slNo) {
			this.slNo = slNo;
		}
		public void setCorrectChoiceNo(String correctChoiceNo) {
			this.correctChoiceNo = correctChoiceNo;
		}
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
