package com.capg.fms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_master2")
public class FeedbackDTO {

	@Id
	@Column(name = "feedback_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	@Column(name = "training_code")
	private int trainingCode;
	@Column(name = "participant_id")
	private int participantId;
	@Column(name = "fb_prs_comm")
	private int prsComm;
	@Column(name = "fb_clrfy_dbts")
	private int clrfyDbts;
	@Column(name = "fb_tm")
	private int tm;
	@Column(name = "fb_hnd_out")
	private int hndOut;
	@Column(name = "fb_hw_sw_ntwrk")
	private int hwSwNtwrk;
	@Column(name = "comments")
	private String comments;
	@Column(name = "suggestions")
	private String suggestions;

	public FeedbackDTO(int feedbackId, int trainingCode, int participantId,
			int prsComm, int clrfyDbts, int tm, int hndOut, int hwSwNtwrk,
			String comments, String suggestions) {
		super();
		this.feedbackId = feedbackId;
		this.trainingCode = trainingCode;
		this.participantId = participantId;
		this.prsComm = prsComm;
		this.clrfyDbts = clrfyDbts;
		this.tm = tm;
		this.hndOut = hndOut;
		this.hwSwNtwrk = hwSwNtwrk;
		this.comments = comments;
		this.suggestions = suggestions;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getTrainingCode() {
		return trainingCode;
	}

	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getPrsComm() {
		return prsComm;
	}

	public void setPrsComm(int prsComm) {
		this.prsComm = prsComm;
	}

	public int getClrfyDbts() {
		return clrfyDbts;
	}

	public void setClrfyDbts(int clrfyDbts) {
		this.clrfyDbts = clrfyDbts;
	}

	public int getTm() {
		return tm;
	}

	public void setTm(int tm) {
		this.tm = tm;
	}

	public int getHndOut() {
		return hndOut;
	}

	public void setHndOut(int hndOut) {
		this.hndOut = hndOut;
	}

	public int getHwSwNtwrk() {
		return hwSwNtwrk;
	}

	public void setHwSwNtwrk(int hwSwNtwrk) {
		this.hwSwNtwrk = hwSwNtwrk;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	public FeedbackDTO() {
	}

	@Override
	public String toString() {
		return "FeedbackDTO [feedbackId=" + feedbackId + ", trainingCode="
				+ trainingCode + ", participantId=" + participantId
				+ ", prsComm=" + prsComm + ", clrfyDbts=" + clrfyDbts + ", tm="
				+ tm + ", hndOut=" + hndOut + ", hwSwNtwrk=" + hwSwNtwrk
				+ ", comments=" + comments + ", suggestions=" + suggestions
				+ "]";
	}

}
