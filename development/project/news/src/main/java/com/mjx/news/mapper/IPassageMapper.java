package com.mjx.news.mapper;

import java.util.List;

// import javax.persistence.FetchType;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.mjx.news.entity.*;

public interface IPassageMapper {
  @Insert("insert into passage(pid, uid, title, part_id, datetime, content) values (#{id}, #{uid}, #{title}, #{part_id}, now(), #{content})")
  public int addPassage(Passage passage);
  @Delete("delete from passage where id=#{id}")
  public int deleteById(String id);
  @Update("update passage set uid=#{uid}, title=#{title}, part_id=#{part_id}, content=#{content} where pid=#{id}")
  public int updatePassage(Passage passage);
  @Select("select * from passage where pid=#{id}")
  public Passage getPassageById(String id);
  // get all passage
  @Select("select * from passage")
  public List<Passage> getAllPassages();

  @Select("select passage.*, user.realname as username from passage,user where passage.uid=user.uid")
  public List<Passage> getAllInfos();
  @Select("select passage.*, user.realname as username from passage,user where passage.uid=user.uid and passage.pid=#{id}") 
  public Passage getInfoById(String id); 
  // get passage by part
  @Select("select * from passage where part_id=#{id}")
  public List<Passage> getPassageByPart(int id); 
  //get data
  @Select("select date as x,count as y from passage_log where pid=#{id} order by date") 
  public List<DataFrame> getData(String id); 

  // @Select("select * from ")
}