package com.capg.fms.bean;

public class FeedbackReportDTO {

	private int trainingCode;
	private String facultyName;
	private double avgPrsComm;
	private double avgClrfyDbts;
	private double avgTm;
	private double avgHndOut;
	private double avgHwSwNtwrk;
	public int getTrainingCode() {
		return trainingCode;
	}
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public double getAvgPrsComm() {
		return avgPrsComm;
	}
	public void setAvgPrsComm(double avgPrsComm) {
		this.avgPrsComm = avgPrsComm;
	}
	public double getAvgClrfyDbts() {
		return avgClrfyDbts;
	}
	public void setAvgClrfyDbts(double avgClrfyDbts) {
		this.avgClrfyDbts = avgClrfyDbts;
	}
	public double getAvgTm() {
		return avgTm;
	}
	public void setAvgTm(double avgTm) {
		this.avgTm = avgTm;
	}
	public double getAvgHndOut() {
		return avgHndOut;
	}
	public void setAvgHndOut(double avgHndOut) {
		this.avgHndOut = avgHndOut;
	}
	public double getAvgHwSwNtwrk() {
		return avgHwSwNtwrk;
	}
	public void setAvgHwSwNtwrk(double avgHwSwNtwrk) {
		this.avgHwSwNtwrk = avgHwSwNtwrk;
	}
	public FeedbackReportDTO(int trainingCode, String facultyName,
			double avgPrsComm, double avgClrfyDbts, double avgTm,
			double avgHndOut, double avgHwSwNtwrk) {
		super();
		this.trainingCode = trainingCode;
		this.facultyName = facultyName;
		this.avgPrsComm = avgPrsComm;
		this.avgClrfyDbts = avgClrfyDbts;
		this.avgTm = avgTm;
		this.avgHndOut = avgHndOut;
		this.avgHwSwNtwrk = avgHwSwNtwrk;
	}
	@Override
	public String toString() {
		return "FeedbackReportDTO [trainingCode=" + trainingCode
				+ ", facultyName=" + facultyName + ", avgPrsComm=" + avgPrsComm
				+ ", avgClrfyDbts=" + avgClrfyDbts + ", avgTm=" + avgTm
				+ ", avgHndOut=" + avgHndOut + ", avgHwSwNtwrk=" + avgHwSwNtwrk
				+ "]";
	}
	public FeedbackReportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
