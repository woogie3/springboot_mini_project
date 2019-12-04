package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.bean.Board;

@Mapper
public interface BoardMapper {
	List<Board> getBoardList();
	Board getBoard(int boardno);
	List<Board> searchTitle(String boardtitle);
	List<Board> searchUserid(String userid);
	int insertQ(Board board);
	int insertA(String userid, String boardtitle, String boardpw, String contentp, int originno, int groupord, int grouplayer);
	int deleteBoard(int boardno);
	int updateBoard(Board board);
	int updateGrouplayer(int originno, int groupord); //답글 입력 -> grouplayer update
	int updateCount(int boardno);
	List<Board> lookingD(@Param("pagenum") int pagenum,@Param("contentnum") int contentnum);
	int RegBoardD(Board board);
	int UpdateBoardD(Board board);
	int DeleteBoardD(Board board);
	List<Board> detail(Board board);
	int updatecountp(Board board);
	
	
	@Select("SELECT * FROM ( SELECT p.*, ROW_NUMBER() OVER(ORDER BY originno desc, groupord asc) AS RNUM FROM boardList p) WHERE RNUM BETWEEN #{pagenum} AND #{contentnum} ")
    public List<Board> plist(@Param("pagenum") int pagenum,@Param("contentnum") int contentnum);
  //페이지 번호를 가져오고(현재 페이지 번호) ,몇개를 가져오는지(한 페이지에 몇개를 표시할 지)
    @Select("SELECT count(*) from BoardList")
    public int pcount();
  //전체 게시글의 갯수를 가져오는 함수이다.
    
    ////////////////
    @Select("SELECT count(*) from boardList where boardtitle like '%'||#{boardtitle}||'%'")
    public int CStitle(@Param("boardtitle") String boardtitle);
    
    @Select("SELECT count(*) from boardList where userid like '%'||#{userid}||'%'")
    public int CWtitle(@Param("userid") String userid);
    ////페이징 처리를 위한 count함수들

    
    ////////////////////////////////////////////////////////////////////////////////////////////  
    @Select("SELECT * FROM ( SELECT p.*, ROW_NUMBER() OVER(ORDER BY originno desc, groupord asc) AS RNUM FROM boardList p where title like '%'||#{boardtitle}||'%') WHERE RNUM BETWEEN #{pagenum} AND #{contentnum}")
    public List<Board> Stitle(@Param("boardtitle") String boardtitle,@Param("pagenum") int pagenum,@Param("contentnum") int contentnum);
    //페이징 + 검색기능을 위한 sql구문
    @Select("SELECT * FROM ( SELECT p.*, ROW_NUMBER() OVER(ORDER BY originno desc, groupord asc) AS RNUM FROM boardList p where writer like '%'||#{userid}||'%') WHERE RNUM BETWEEN #{pagenum} AND #{contentnum}")
    public List<Board> Wtitle(@Param("userid") String userid,@Param("pagenum") int pagenum,@Param("contentnum") int contentnum);
    ////////////////////////////////////////////////////////////////////////////////////////////  
    /*mapper.xml 적용부분
     * <select id="plist" parameterType="int" resultType="java.util.List">
		<![CDATA[ SELECT * FROM ( SELECT p.*, ROW_NUMBER() OVER(ORDER BY originno desc, groupord asc) AS RNUM FROM boardList p) WHERE RNUM BETWEEN #{pagenum} AND #{contentnum}]]>
	</select>
	
	<select id="pcount" resultType="int">
		SELECT count(*) from boardList
	</select>
	
	<select id="CStitle" parameterType="String" resultType="int">
		SELECT count(*) from boardList where boardtitle like '%'||#{boardtitle}||'%'
	</select>
	
	<select id="CWtitle" parameterType="String" resultType="int">
		SELECT count(*) from boardList where userid like '%'||#{userid}||'%'
	</select>
	
	<select id="Stitle" parameterType="map" resultType="Board">
		SELECT * FROM ( SELECT p.*, ROW_NUMBER() OVER(ORDER BY originno desc, groupord asc) AS RNUM FROM boardList p where title like '%'||#{boardtitle}||'%') WHERE RNUM BETWEEN #{pagenum} AND #{contentnum}
	</select>
	
	<select id="Wtitle" parameterType="map" resultType="Board">
		SELECT * FROM ( SELECT p.*, ROW_NUMBER() OVER(ORDER BY originno desc, groupord asc) AS RNUM FROM boardList p where writer like '%'||#{userid}||'%') WHERE RNUM BETWEEN #{pagenum} AND #{contentnum}
	</select>
     */
}
