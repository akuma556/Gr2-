package com.capg.fms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "participant_enrollment")
public class ParticipantDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participant_generator")
	@SequenceGenerator(name = "participant_generator", sequenceName = "participant_seq", allocationSize = 1009)
	@Column(name="enrollment_id")
	private int enrollmentId;
	@Column(name = "participant_id")
	private int participantId;
	@Column(name = "training_code")
	private int trainingCode;

	public ParticipantDTO() {
	}

	
	public ParticipantDTO(int enrollmentId, int participantId, int trainingCode) {
		this.enrollmentId = enrollmentId;
		this.participantId = participantId;
		this.trainingCode = trainingCode;
	}


	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getTrainingCode() {
		return trainingCode;
	}

	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}


	@Override
	public String toString() {
		return "ParticipantDTO [enrollmentId=" + enrollmentId + ", participanrId=" + participantId + ", trainingCode="
				+ trainingCode + "]";
	}


}
