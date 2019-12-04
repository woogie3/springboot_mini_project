package com.example.demo.bean;

import java.sql.Date;

public class Board {
	String userid;
	String boardtitle;
	int boardno;
	Date regdate;
	String boardpw;
	String filesrc;
	String imagesrc;
	String contentp;
	int countp;
	int boardparent;
	int originno;
	int groupord;
	int grouplayer;
	
	public Board() {
		super();
	}
	public Board(String userid, String boardtitle, int boardno, Date regdate, String boardpw, String filesrc, String imagesrc,
			String contentp, int countp, int boardparent, int originno, int groupord, int grouplayer) {
		super();
		this.userid = userid;
		this.boardtitle = boardtitle;
		this.boardno = boardno;
		this.regdate = regdate;
		this.boardpw = boardpw;
		this.filesrc = filesrc;
		this.imagesrc = imagesrc;
		this.contentp = contentp;
		this.countp = countp;
		this.boardparent = boardparent;
		this.originno = originno;
		this.groupord = groupord;
		this.grouplayer = grouplayer;
	}
	public String getImagesrc() {
		return imagesrc;
	}
	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getBoardpw() {
		return boardpw;
	}
	public void setBoardpw(String boardpw) {
		this.boardpw = boardpw;
	}
	public String getFilesrc() {
		return filesrc;
	}
	public void setFilesrc(String filesrc) {
		this.filesrc = filesrc;
	}
	public String getContentp() {
		return contentp;
	}
	public void setContentp(String contentp) {
		this.contentp = contentp;
	}
	public int getCountp() {
		return countp;
	}
	public void setCountp(int countp) {
		this.countp = countp;
	}
	public int getBoardparent() {
		return boardparent;
	}
	public void setBoardparent(int boardparent) {
		this.boardparent = boardparent;
	}
	public int getOriginno() {
		return originno;
	}
	public void setOriginno(int originno) {
		this.originno = originno;
	}
	public int getGroupord() {
		return groupord;
	}
	public void setGroupord(int groupord) {
		this.groupord = groupord;
	}
	public int getGrouplayer() {
		return grouplayer;
	}
	public void setGrouplayer(int grouplayer) {
		this.grouplayer = grouplayer;
	}
	@Override
	public String toString() {
		return "Board [userid=" + userid + ", boardtitle=" + boardtitle + ", boardno=" + boardno + ", regdate="
				+ regdate + ", boardpw=" + boardpw + ", filesrc=" + filesrc + ", imagesrc=" + imagesrc + ", contentp=" + contentp + ", countp="
				+ countp + ", boardparent=" + boardparent + ", originno=" + originno + ", groupord=" + groupord
				+ ", grouplayer=" + grouplayer + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardno;
		result = prime * result + boardparent;
		result = prime * result + ((boardpw == null) ? 0 : boardpw.hashCode());
		result = prime * result + ((boardtitle == null) ? 0 : boardtitle.hashCode());
		result = prime * result + ((contentp == null) ? 0 : contentp.hashCode());
		result = prime * result + countp;
		result = prime * result + ((filesrc == null) ? 0 : filesrc.hashCode());
		result = prime * result + ((imagesrc == null) ? 0 : imagesrc.hashCode());
		result = prime * result + grouplayer;
		result = prime * result + groupord;
		result = prime * result + originno;
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (boardno != other.boardno)
			return false;
		if (boardparent != other.boardparent)
			return false;
		if (boardpw == null) {
			if (other.boardpw != null)
				return false;
		} else if (!boardpw.equals(other.boardpw))
			return false;
		if (boardtitle == null) {
			if (other.boardtitle != null)
				return false;
		} else if (!boardtitle.equals(other.boardtitle))
			return false;
		if (contentp == null) {
			if (other.contentp != null)
				return false;
		} else if (!contentp.equals(other.contentp))
			return false;
		if (countp != other.countp)
			return false;
		if (filesrc == null) {
			if (other.filesrc != null)
				return false;
		} else if (!filesrc.equals(other.filesrc))
			return false;
		if (imagesrc == null) {
			if (other.imagesrc != null)
				return false;
		} else if (!imagesrc.equals(other.imagesrc))
			return false;
		if (grouplayer != other.grouplayer)
			return false;
		if (groupord != other.groupord)
			return false;
		if (originno != other.originno)
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
	

}
